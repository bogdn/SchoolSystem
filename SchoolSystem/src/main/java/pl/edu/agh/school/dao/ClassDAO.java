package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Class;

public interface ClassDAO {

	public List<Class> findAll();
	public void removeClass(int id);
}
