package com.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	private String bookName;

	private String genre;

	private String bookAuthor;

//	@OneToOne(targetEntity = BorrowDetails.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "borrowId")
//	private BorrowDetails borrow;
//
//	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId")
//	private User user;

	public Books() {
		// TODO Auto-generated constructor stub
	}

public Books(int bookId, String bookName, String genre, String bookAuthor) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.genre = genre;
	this.bookAuthor = bookAuthor;
}

public int getBookId() {
	return bookId;
}

public void setBookId(int bookId) {
	this.bookId = bookId;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getBookAuthor() {
	return bookAuthor;
}

public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}

@Override
public String toString() {
	return "Books [bookId=" + bookId + ", bookName=" + bookName + ", genre=" + genre + ", bookAuthor=" + bookAuthor
			+ "]";
}

	

}
