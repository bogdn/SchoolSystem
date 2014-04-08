package pl.edu.agh.school.dao;

import pl.edu.agh.school.models.Role;

public interface RoleDAO {

	public Role getRole(int id);
	public Role getRole(String role);
}