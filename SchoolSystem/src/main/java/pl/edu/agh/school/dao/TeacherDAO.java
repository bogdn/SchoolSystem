package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Teacher;

public interface TeacherDAO {
	public void saveTeacher(Teacher teacher);
	public List<Teacher> findAll();
	public void removeTeacher(Teacher teacher);
	public Teacher getTeacher(int id);
	public void updateTeacher(Teacher teacher);
}
