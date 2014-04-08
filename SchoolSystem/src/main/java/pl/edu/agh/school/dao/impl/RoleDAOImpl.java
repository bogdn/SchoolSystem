package pl.edu.agh.school.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.school.dao.RoleDAO;
import pl.edu.agh.school.models.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired 
	private SessionFactory sessionFactory;

	@Transactional
	public Role getRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, id);
		return role;
	}

	@Transactional
	public Role getRole(String role) {

	Session session = sessionFactory.getCurrentSession();
	Query query = session.createQuery("from Role r where r.role = :role");  
	query.setParameter("role", role);
	List<Role> roleList = new ArrayList<Role>();  
	roleList = query.list();
	
	if (roleList.size() > 0)  
		return roleList.get(0);
	
	return null;
	}
}
