package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.model.Books;

@Repository
@Transactional
public interface BooksRepo extends JpaRepository<Books, Integer> {

	@Query("select genre from Books order by bookId")
	public List<String> getBookGenreList();

}
