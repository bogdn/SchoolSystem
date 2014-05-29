package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.StudentDAO;
import pl.edu.agh.school.models.Student;
import pl.edu.agh.school.models.Teacher;

public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		
		
	}
	
	@Transactional
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student").list();
		return students;
	}
	@Transactional
	public void removeStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
        session.delete(student);
	}
	@Transactional
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student s where s.id = :id");  
        query.setInteger("id", id);
        List<Student> studentList = new ArrayList<Student>();  
        studentList = query.list();  
        if (studentList.size() > 0)  
        	return studentList.get(0);
        
        return null;
	}

	@Transactional
	public void updateStudent(Student student) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
		
	}

	@Transactional
	public List<Student> getStudentsFromClass(int classId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student s where s.studentClass :=id");
		query.setInteger("id", classId);
		List<Student> students = query.list();
		return students;
	}

}
