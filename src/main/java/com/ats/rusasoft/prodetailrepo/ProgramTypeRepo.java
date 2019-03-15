package com.ats.rusasoft.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.progdetail.ProgramType;

public interface ProgramTypeRepo extends JpaRepository<ProgramType, Integer> {
	
	List<ProgramType> findByDelStatusAndIsActive(int delStatus, int isActive);
	
}
