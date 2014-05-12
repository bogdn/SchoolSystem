package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Subject;

public interface SubjectDAO {
	public Subject getSubject(Integer id);
	public void saveSubject(Subject subject);
	public List<Subject> findAll();
	public void removeSubject(Subject subject);
	public void updateSubject(Subject subject);

}
