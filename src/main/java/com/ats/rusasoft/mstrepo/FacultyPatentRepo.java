package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.FacultyPatent;

public interface FacultyPatentRepo extends JpaRepository<FacultyPatent, Integer>{

	FacultyPatent findByPatentId(int patentId);
	
	
	FacultyPatent findByPatentIdAndDelStatus(int patentId,int i);


	List<FacultyPatent> findByDelStatusAndIsActive(int i, int j);
}
