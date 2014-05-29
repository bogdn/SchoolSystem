package pl.edu.agh.school.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.MarkDAO;
import pl.edu.agh.school.models.Mark;

public class MarkDAOImpl implements MarkDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Mark getMark(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Mark m where m.id :=id");
		query.setInteger("id", id);
		List<Mark> marks = query.list();
		if(marks.get(0)!= null) 
			return marks.get(0);
		else return null;
	}

	@Transactional
	public List<Mark> getStudentMarks(int studentId, int subjectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Mark m where m.student = :student and m.subject = :subject");
		query.setInteger("student", studentId);
		query.setInteger("subject", subjectId);
		List<Mark> marks = query.list();
		return marks;
		
	}

	@Transactional
	public void saveMark(Mark mark) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mark);
		
	}


}
