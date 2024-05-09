package com.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.controller.BorrowController;
import com.lms.model.Books;
import com.lms.model.BorrowDetails;

@SpringBootTest
public class BorrowTesting {

	@Autowired
	BorrowController borrow;

	@Test
	void createBookSuccesful() {
		BorrowDetails b = new BorrowDetails();
		b.setBorrowId(1);
		b.setBorrowDate("02/05/2024");
		b.setReturnDate("02/05/2024");
		String result = borrow.createBorrow(b);
		assertEquals("User Object Saved", result);
	}

	@Test
	void findAllBorrow() {
		List<BorrowDetails> list = borrow.getAllBorrowDetails();
		assertNotNull(list);

	}

	@Test
	void deleteBorrowSuccesful() {
		String result = borrow.deleteUser(139);
		assertEquals("delete!!!!", result);
	}

	@Test
	void deleteBorrowFailure() {
		String result = borrow.deleteUser(845120451);
		assertEquals("delete!!!!", result);
	}

}
