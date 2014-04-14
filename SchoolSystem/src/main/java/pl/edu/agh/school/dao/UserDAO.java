package pl.edu.agh.school.dao;

import pl.edu.agh.school.models.User;

public interface UserDAO {
	public User getUser(String login);
	public Boolean isUserNameAvailable(String name);
}
