package com.lms.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usertable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;

	private Long userContact;


	public User() {
		super();
	}

	public User(int userId, String userName, Long userContact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userContact = userContact;
	
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserContact() {
		return userContact;
	}

	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userContact=" + userContact 
				+ "]";
	}

}
