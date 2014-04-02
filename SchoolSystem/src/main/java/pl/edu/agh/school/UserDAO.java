package pl.edu.agh.school;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDAO {
	
	@Autowired private SessionFactory sessionFactory;
	
	/**
	 * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
	 * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
	 */
	@Transactional
	public User getUser(String login) {
		List userList = new ArrayList();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return (User) userList.get(0);
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
	public User getUser(String username, String password) {
Session session = sessionFactory.getCurrentSession();
Query query = session.createQuery("from User where username = :username AND password = :password");
query.setParameter("username", username);
query.setParameter("password", password);
return (User) query.uniqueResult();
	}
	
}
