package com.phamhuy.example1.user;

import java.io.Serializable;

import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class User implements Serializable {
	private long id;
	private String username;

	@Size(max = 5, message = "first name length must be less than or equal to 5")
	private String firstName;
	private String lastName;
	private static long totalIds = 0;

	public User(String firstName, String lastName) {
		id = ++User.totalIds;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(User src) {
		id = ++User.totalIds;
		firstName = src.firstName;
		lastName = src.lastName;
	}

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
}
