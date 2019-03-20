package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.FacultyPhdGuide;

public interface FacultyPhdGuideRepo extends JpaRepository<FacultyPhdGuide, Integer>{

	List<FacultyPhdGuide> findByFacultyIdAndYearIdAndDelStatusOrderByPhdIdDesc(int facId, int yId, int del);
	
	FacultyPhdGuide findByPhdId(int phdId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_phdguide SET del_status=0 WHERE phd_id=:phdId",nativeQuery=true)
	int deletePhdGuideByPhdId(int phdId);
}
