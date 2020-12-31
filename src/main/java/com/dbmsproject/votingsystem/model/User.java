package com.dbmsproject.votingsystem.model;

import java.util.List;

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class User {

	@Id
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@OneToMany(mappedBy="voter")
	List<Voter> votes;
	
	@OneToMany(mappedBy="candidateUser")
	List<Candidate> candidateIn;
	
	@OneToMany(mappedBy="admin")
	List<Election> electionsCreated;
	
	@OneToMany(mappedBy="candidate")
	List<Voter> votedBy;

	@NotNull
	private String name;

	@NotNull
	private Integer age;

	@NotNull
	private String phone;
	
	@NotNull
	private String email;
	
	public User() {
		this.username = null;
		this.name = null;
		this.age = null;
		this.phone = null;
		this.email = null;
	}
	
	public User(String username, String password, String name, Integer age, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email="
				+ email + ", password=" + password + "]";
	}

}
