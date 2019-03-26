package com.ats.rusasoft.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.progdetail.Cast;

public interface CastRepo extends JpaRepository<Cast, Integer>{
	
	
	List<Cast> findByDelStatusAndIsActiveOrderByCastIdDesc(int delStatus, int isActive);
	
	

}
