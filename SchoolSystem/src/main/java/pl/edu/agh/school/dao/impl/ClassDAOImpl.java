package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Student;
import pl.edu.agh.school.models.User;

public class ClassDAOImpl implements ClassDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Class> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Class> classes = session.createQuery("from Class").list();
		return classes;
	}

	@Transactional
	public void removeClass(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Class c where c.id = :id");  
        query.setInteger("id", id);
        List<Class> classList = new ArrayList<Class>();  
        classList = query.list();  
        if (classList.size() > 0)  
        session.delete(classList.get(0));
        
	}

	@Transactional
	public Class getClass(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Class c where c.id = :id");  
        query.setInteger("id", id);
        List<Class> classList = new ArrayList<Class>();  
        classList = query.list();  
        if (classList.size() > 0)  
        	return classList.get(0);
        
        return null;
	}

	@Transactional
	public void saveClass(Class schoolClass) {
		Session session = sessionFactory.getCurrentSession();
		session.save(schoolClass);
	}

	@Transactional
	public void updateClass(Class _class) {
		
		Session session =sessionFactory.getCurrentSession();
		session.update(_class);
		
	}

	@Transactional
	public Class getStudentsFromClass(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Class c where c.id = :id");  

        query.setInteger("id", id);
        List<Class> classList = new ArrayList<Class>();  
        classList = query.list();  
        if (classList.size() > 0)  
        	return classList.get(0);
        
        return null;
	}
	
	

}
