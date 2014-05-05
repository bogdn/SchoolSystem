package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Student;

public interface StudentDAO {
	
	public void saveStudent(Student student);
	public List<Student> findAll();


}
