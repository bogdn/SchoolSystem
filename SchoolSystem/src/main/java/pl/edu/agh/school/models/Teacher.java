package pl.edu.agh.school.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="teacher")  
public class Teacher extends User {

	@OneToOne
	@JoinColumn(name = "class_id")
	private Class schoolClass;

	public Class getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(Class schoolClass) {
		this.schoolClass = schoolClass;
	}

	
}
