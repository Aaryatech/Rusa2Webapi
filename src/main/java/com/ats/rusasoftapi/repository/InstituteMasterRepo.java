package com.ats.rusasoftapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.InstituteMaster;

public interface InstituteMasterRepo extends JpaRepository<InstituteMaster, Integer> {
	
	InstituteMaster findByAisheCode(String aisheCode);
	

}
