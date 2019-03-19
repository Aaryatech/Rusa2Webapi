package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.OutreachType;


public interface OutreachTypeRepo  extends JpaRepository<OutreachType, Integer> {
	
	
	List<OutreachType> findByDelStatusAndInstituteIdOrderByTypeIdDesc(int delStatus, int instId);

}
