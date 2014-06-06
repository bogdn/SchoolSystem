package pl.edu.agh.school.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToOne
	@JoinColumn(name="class")
	private Class subClass;
	@OneToOne
	@JoinColumn(name="teacher")
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getSubClass() {
		return subClass;
	}
	public void setSubClass(Class subClass) {
		this.subClass = subClass;
	}
	
	
	

}
