package pl.edu.agh.school;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue 
	private long id;
	private String username;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="user_roles",
	joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
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
