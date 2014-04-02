package pl.edu.agh.school;

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
