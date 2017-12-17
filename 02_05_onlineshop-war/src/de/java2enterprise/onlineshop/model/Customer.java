package de.java2enterprise.onlineshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.Dependent;

@Dependent
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String password;
	
	private String comment;
	
	private String favoritActivity;
	
	private Date birthdate;
	
	private String favoritColor;
	
	private Integer rating;
	
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

	public String getFavoritActivity() {
		return favoritActivity;
	}

	public void setFavoritActivity(String favoritActivity) {
		this.favoritActivity = favoritActivity;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFavoritColor() {
		return favoritColor;
	}

	public void setFavoritColor(String favoritColor) {
		this.favoritColor = favoritColor;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
