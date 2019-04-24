package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Dean;
public interface DeanRepo extends JpaRepository<Dean, Integer> {

	Dean findByDeanIdAndDelStatus(@Param("id") int id,@Param("i") int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_dean_reg SET del_status=0 WHERE dean_id = :id",nativeQuery=true)
	int deleteByDeanId(@Param("id") int id);

	List<Dean> findByContactNo(String contactNo);

	List<Dean> findByContactNoAndDeanIdNot(String contactNo, int deanId);

	List<Dean> findByEmail(String email);

	List<Dean> findByEmailAndDeanIdNot(String email, int deanId);

	
}
