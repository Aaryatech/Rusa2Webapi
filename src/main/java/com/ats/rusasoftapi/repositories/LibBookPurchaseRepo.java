package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.LibBookPurchase;

public interface LibBookPurchaseRepo extends JpaRepository<LibBookPurchase, Integer> {

	List<LibBookPurchase> findByDelStatusAndInstituteIdAndAcademicYridOrderByBookPurchaseIdDesc(int i, int instituteId, int acadYear);
	
	LibBookPurchase findByBookPurchaseIdAndDelStatus(int bookId, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE lib_book_purchase SET del_status = 0 WHERE book_purchase_id=:bookId", nativeQuery=true)
	int deletePurchasedBookInfoById(@Param("bookId") int bookId);

	@Transactional
	@Modifying
	@Query(value="UPDATE lib_book_purchase SET del_status=0  WHERE book_purchase_id IN (:libBookIdList)",nativeQuery=true)
	int deleteLibInfo(List<String> libBookIdList);

	

	
}
