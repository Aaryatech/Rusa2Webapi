package com.ats.rusasoft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

	List<Staff> findByIsActiveAndDelStatus(@Param("i") int i,@Param("j") int j);
	

	
}
