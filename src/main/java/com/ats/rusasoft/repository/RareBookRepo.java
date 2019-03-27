package com.ats.rusasoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.RareBook;

public interface RareBookRepo extends JpaRepository<RareBook, Integer> {
	
	List<RareBook> findByInstituteIdAndDelStatusOrderByRareBookInfoIdDesc(int instituteId,int del);
	
	RareBook findByRareBookInfoId(int bookId);
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_rare_book_info SET del_status=0 WHERE rare_book_info_id=:bookId ", nativeQuery = true)
	int deleteRareBookInfoById(int bookId);
}
