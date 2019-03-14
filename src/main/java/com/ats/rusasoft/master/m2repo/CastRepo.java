package com.ats.rusasoft.master.m2repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.progdetail.Cast;

public interface CastRepo extends JpaRepository<Cast, Integer>{
	
	
	List<Cast> findByDelStatusAndIsActive(int delStatus, int isActive);
	
	

}
