package pl.edu.agh.school.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "user")
@Inheritance(strategy=InheritanceType.JOINED)//Highly normalized  
public class User {
	@Id
	@GeneratedValue 
	private long id;
	@Size(min=4, max=20) 
	private String username;
	@Size(min=6, max=30) 
	private String password;
	
	@Size(min=2, max=30)
	private String name;
	
	@Size(min=2, max=30)
	private String surname;
	
	@Email
	private String email;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinTable(name="user_roles",
	joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	@OneToMany(mappedBy = "user")
	
	private Role role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
