package com.ats.rusasoft.master.m2repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.progdetail.Location;

public interface LocationRepo extends JpaRepository<Location, Integer>{
	
	List<Location> findByDelStatusAndIsActive(int delStatus, int isActive);

	
}
