package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.progdetail.Cast;

public interface CastRepo extends JpaRepository<Cast, Integer>{
	
	
	List<Cast> findByDelStatusAndIsActiveOrderByCastIdDesc(int delStatus, int isActive);
	
	Cast findByDelStatusAndIsActiveAndCastId(int delStatus, int isActive, int castId);	

}
