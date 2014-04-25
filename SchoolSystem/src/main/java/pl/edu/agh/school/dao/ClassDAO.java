package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Class;

public interface ClassDAO {

	public Class getClass(int id);
	public List<Class> findAll();
	public void removeClass(int id);
	public void saveClass(Class schoolClass);
	public void updateClass(Class _class);
}
