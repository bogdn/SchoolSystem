package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Student;

public interface StudentDAO {
	
	public void saveStudent(Student student);
	public List<Student> findAll();
	public List<Student> getStudentsFromClass(int classId);
	public void removeStudent(Student student);
	public Student getStudent(int id);
	public void updateStudent(Student student);


}
