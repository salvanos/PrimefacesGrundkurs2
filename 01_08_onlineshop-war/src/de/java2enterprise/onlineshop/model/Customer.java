package de.java2enterprise.onlineshop.model;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

@Dependent
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String password;
	
	private String comment;
	
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
