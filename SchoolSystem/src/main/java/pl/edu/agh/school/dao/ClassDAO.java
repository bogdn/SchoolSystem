package pl.edu.agh.school.dao;

import java.util.List;
import java.util.Set;

import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Student;

public interface ClassDAO {

	public Class getClass(int id);
	public Class getStudentsFromClass(int id);
	public List<Class> findAll();
	public void removeClass(int id);
	public void saveClass(Class schoolClass);
	public void updateClass(Class _class);
}
