package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.Hod;

public interface HodRepo extends JpaRepository<Hod, Integer> {
	
	Hod findByHodId(int hodId);
	
	List<Hod> findByInstituteIdAndIsActiveAndDelStatusOrderByHodIdDesc(int instId,int isActive,int delStatus);

}
