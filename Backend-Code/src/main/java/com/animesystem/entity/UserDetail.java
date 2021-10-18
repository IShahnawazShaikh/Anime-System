package com.animesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetail")
public class UserDetail {
	
	@Id
	@Column(name="Id")
	private String Id;
	
	@Column(name="email")
	private  String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
    private String lastName;
	
	@Column(name="password")
	private String password;
	
	public UserDetail() {}

	
	
	public UserDetail(String id, String email, String firstName, String lastName, String password) {
		super();
		Id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}


	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
