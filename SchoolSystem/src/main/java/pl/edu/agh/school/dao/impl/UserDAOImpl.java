package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.UserDAO;
import pl.edu.agh.school.models.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired private SessionFactory sessionFactory;
	
	/**
	 * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
	 * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
	 */
	@Transactional
    public User getUser(String login) {  
		System.out.println("getUser");
    	Session session = sessionFactory.getCurrentSession();
    	System.out.println(session);
        List<User> userList = new ArrayList<User>();  
        Query query = session.createQuery("from User u where u.username = :username");  
        query.setParameter("username", login);  
        userList = query.list();  
        if (userList.size() > 0)  
            return userList.get(0);  
        else  
            return null;      
    }  
  
	
	@Transactional
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from User").list();
		return users;
	}
	
	@Transactional
	public Boolean isUserNameAvailable(String name) {
    	Session session = sessionFactory.getCurrentSession();
    	System.out.println(session);
        List<User> userList = new ArrayList<User>();  
        Query query = session.createQuery("from User u where u.username = :username");  
        query.setParameter("username", name);  
        userList = query.list();  
        if (userList.size() > 0)  
            return false;  
        else  
            return true;
	}
	
}
