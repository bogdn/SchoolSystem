package pl.edu.agh.school.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student") 
public class Student extends User {
	
	@ManyToOne
	@JoinTable(name="students_class", joinColumns = {@JoinColumn(name="student_id", referencedColumnName="id")}, inverseJoinColumns = {@JoinColumn(name="class_id", referencedColumnName="id")}  
		    )  
	private Class studentClass;

	public Class getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Class studentClass) {
		this.studentClass = studentClass;
	}
	

}
