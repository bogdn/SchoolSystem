package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.TeacherDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		Class schoolClass = teacher.getSchoolClass();
		if (schoolClass != null) {
			Teacher oldTeacher = schoolClass.getMaster();
			if (oldTeacher != null && oldTeacher != teacher) {
				oldTeacher.setSchoolClass(null);
				session.update(oldTeacher);
			}
		}
		session.save(teacher);
	}
	
	@Transactional
	public void updateTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		
		Class schoolClass = teacher.getSchoolClass();
		if (schoolClass != null) {
			Teacher oldTeacher = schoolClass.getMaster();
			if (oldTeacher != null && oldTeacher != teacher) {
				oldTeacher.setSchoolClass(null);
				session.update(oldTeacher);
			}
		}
		session.update(teacher);
	}

	@Transactional
	public List<Teacher> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Teacher> teachers = session.createQuery("from Teacher").list();
		return teachers;
	}
	
	@Transactional
	public Teacher getTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Teacher t where t.id = :id");  
        query.setInteger("id", id);
        List<Teacher> teacherList = new ArrayList<Teacher>();  
        teacherList = query.list();  
        if (teacherList.size() > 0)  
        	return teacherList.get(0);
        
        return null;
	}
	
	@Transactional
	public void removeTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
	}

}
