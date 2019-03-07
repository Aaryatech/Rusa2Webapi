package com.ats.rusasoft.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

	Staff findByFacultyIdAndDelStatus(@Param("id") int id,@Param("i") int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_faculty SET del_status=0 WHERE faculty_id=:id",nativeQuery=true)
	int deleteByFacultyId(@Param("id") int id);

	
	

	
}
