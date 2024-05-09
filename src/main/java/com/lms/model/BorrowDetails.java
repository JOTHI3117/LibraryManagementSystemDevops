package com.lms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class BorrowDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;

	private String borrowDate;

	private String returnDate;

	@OneToOne(cascade = CascadeType.MERGE)
	private Books books;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;

	public BorrowDetails() {
		super();
	}

	public BorrowDetails(int borrowId, String borrowDate, String returnDate, Books books, User user) {
		super();
		this.borrowId = borrowId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.books = books;
		this.user = user;
	}

	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BorrowDetails [borrowId=" + borrowId + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate
				+ ", books=" + books + ", user=" + user + "]";
	}

}
