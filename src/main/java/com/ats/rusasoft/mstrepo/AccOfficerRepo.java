package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.AccOfficer;

public interface AccOfficerRepo extends JpaRepository<AccOfficer, Integer> {

	AccOfficer findByOfficerId(int officerId);
	
	

}
