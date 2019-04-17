package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.AcademicYear;



public interface AcademicYearRepo extends JpaRepository<AcademicYear, Integer>  {

	List<AcademicYear> findByTypeAndDelStatusOrderByYearIdDesc(int type, int i);
	
	AcademicYear findByYearIdAndDelStatus(int yearId, int delStatus);

	AcademicYear findByIsCurrentAndDelStatus(int isCurrent, int delStatus);
	

}
