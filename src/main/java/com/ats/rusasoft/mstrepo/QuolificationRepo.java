package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.Quolification;

public interface QuolificationRepo extends JpaRepository<Quolification, Integer>{
	
	List<Quolification> findByTypeAndDelStatusOrderByQualificationIdDesc(int type,int delStatus);
	
	

}
