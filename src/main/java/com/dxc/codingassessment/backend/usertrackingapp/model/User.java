package com.dxc.codingassessment.backend.usertrackingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;


@Entity (name="users")
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
    private String firstName;
	@Column(name = "last_name")
    private String lastName;
    private String email;
	@JsonIgnore
    private String password;
    private char manager;
	@Column(name = "created_at")
	private Date createdAt;

    //required for jpa to work correctly
    public User(){
    	
    }
	public User(String firstName, String lastName, String email, String password, char manager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.manager = manager;
	}
    
	public Long getId() {
		return id;
	}
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getManager() {
		return manager;
	}
	public void setManager(char manager) {
		this.manager = manager;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@PrePersist
	public void onCreate() {
		createdAt = new Date();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", manager=" + manager + "]";
	}
}
