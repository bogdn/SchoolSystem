package pl.edu.agh.school.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.YesNoType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "class")
public class Class {
	
	@Id
	@GeneratedValue 
	private long id;
	private String name;
	private String fullName; 
	
	private int year;
	
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
		return "id:" + id + "name:" + name + "fullname:" + fullName + "year:" + year;
	}
}
