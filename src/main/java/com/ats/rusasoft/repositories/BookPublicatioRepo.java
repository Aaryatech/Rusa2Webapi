package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.FacultyBook;

public interface BookPublicatioRepo extends JpaRepository<FacultyBook, Integer> {

	List<FacultyBook> findByFacultyIdAndDelStatusOrderByBookIdDesc(int facId, int del);
	
	FacultyBook findByBookIdAndDelStatus(int bookId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_book SET del_status=0 WHERE book_id=:bookId",nativeQuery=true)
	int deleteByBookId(@Param("bookId") int bookId);
}
