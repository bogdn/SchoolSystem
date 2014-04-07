package pl.edu.agh.school.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class RoleDAOImpl implements RoleDAO {

//	@Autowired 
	private SessionFactory sessionFactory;

	public Role getRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, id);
		return role;
	}

}
