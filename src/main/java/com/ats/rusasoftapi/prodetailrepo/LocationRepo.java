package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.progdetail.Location;

public interface LocationRepo extends JpaRepository<Location, Integer>{
	
	List<Location> findByDelStatusAndIsActive(int delStatus, int isActive);

	
}
