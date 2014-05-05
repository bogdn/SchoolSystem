package pl.edu.agh.school.dao.impl;

import java.util.List;

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

}
