package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.OutreachType;


public interface OutreachTypeRepo  extends JpaRepository<OutreachType, Integer> {
	
	
	List<OutreachType> findByDelStatusOrderByTypeIdDesc(int delStatus);

}
