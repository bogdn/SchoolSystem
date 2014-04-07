package pl.edu.agh.school.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.edu.agh.school.dao.RoleDAO;
import pl.edu.agh.school.models.Role;

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
