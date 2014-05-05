package pl.edu.agh.school.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, max=10) 
	private String name;
	@Size(min=2, max=30) 
	private String fullName;
	
	@NotNull 
	@Min(1992) @Max(2012)
	private int year;
	
	@OneToOne(mappedBy = "schoolClass")
	private Teacher teacher;
	
	@OneToMany(mappedBy ="studentClass")
	private Set<Student> student;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id:" + id + "name:" + name + "fullname:" + fullName + "year:"
				+ year;
	}

	
	
}
