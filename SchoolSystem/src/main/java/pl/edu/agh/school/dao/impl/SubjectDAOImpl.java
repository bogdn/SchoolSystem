package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.SubjectDAO;
import pl.edu.agh.school.models.Mark;
import pl.edu.agh.school.models.Student;
import pl.edu.agh.school.models.Subject;

public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void saveSubject(Subject subject) {
		Session session = sessionFactory.getCurrentSession();
		session.save(subject);
	}
	@Transactional
	public List<Subject> findAll() {
		Session session =sessionFactory.getCurrentSession();
		List<Subject> subjects = session.createQuery("from Subject").list();
		return subjects;
	}
	@Transactional
	public void removeSubject(Subject subject) {
		Session session =sessionFactory.getCurrentSession();
		session.delete(subject);
		
	}
	@Transactional
	public Subject getSubject(Integer id) {
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Subject s where s.id = :id");  
        query.setInteger("id", id);
        List<Subject> subjectList = new ArrayList<Subject>();  
        subjectList = query.list();  
        if (subjectList.size() > 0)  
        	return subjectList.get(0);
        
        return null;
		
		
	}
	@Transactional
	public void updateSubject(Subject subject) {
		Session session =sessionFactory.getCurrentSession();
		session.update(subject);
	}
	@Transactional
	public List<Subject> getSubjectsFromClass(int classID) {
		
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Subject s where s.subClass = :subClass");
		query.setInteger("subClass", classID);
		
		List<Subject> subjects = new ArrayList<Subject>();
		subjects = query.list();
		
		return subjects;
	}


}
