package pl.edu.agh.school.dao;

import java.util.List;

import pl.edu.agh.school.models.Mark;

public interface MarkDAO {
	public Mark getMark(int id);
	public List<Mark> getStudentMarks(int studentId, int subjectId);
	public void saveMark(Mark mark);

}
