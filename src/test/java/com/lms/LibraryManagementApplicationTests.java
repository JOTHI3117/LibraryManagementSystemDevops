package com.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.controller.BookController;
import com.lms.model.Books;

@SpringBootTest
class LibraryManagementApplicationTests {

	@Autowired
	BookController book;

	@Test
	void createBookSuccesful() {
		Books books = new Books();
		books.setBookName("Harry Potter");
		books.setGenre("fantasy");
		books.setBookAuthor("jk rowling");
		String result = book.createBook(books);
		assertEquals("User Object Saved", result);
	}

	@Test
	void createBookFailure() {
		Books books = new Books();
		books.setBookId(1);
		books.setBookName("jothi");
		books.setGenre("fantasy");
		books.setBookAuthor("jk rowling");
		String result = book.createBook(books);
		assertEquals("User Object Saved", result);
	}

	@Test
	void deleteBookSuccesful() {
		String result = book.deleteUser(5);
		assertEquals("delete!!!!", result);
	}

	@Test
	void deleteBookFailure() {
		String result = book.deleteUser(20);
		assertEquals("delete!!!!", result);
	}

	@Test
	void findAllBook() {
		List<Books> list = book.getAllBookDetails();
		assertNotNull(list);
	}

	@Test
	void findAllGenreList() {
		List<String> list = book.getBookGenreNameList();
		assertNotNull(list);
	}

}
