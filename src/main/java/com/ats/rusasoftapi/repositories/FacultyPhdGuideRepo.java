package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyPhdGuide;

public interface FacultyPhdGuideRepo extends JpaRepository<FacultyPhdGuide, Integer>{

	
	FacultyPhdGuide findByPhdId(int phdId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_phdguide SET del_status=0 WHERE phd_id=:phdId",nativeQuery=true)
	int deletePhdGuideByPhdId(@Param("phdId") int phdId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_phdguide SET del_status=0  WHERE phd_id IN (:phdIdsList) ",nativeQuery=true)
	int delPhds(@Param("phdIdsList") List<String> phdIdsList);
}
