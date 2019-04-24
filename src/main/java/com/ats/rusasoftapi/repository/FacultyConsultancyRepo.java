package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyConsultancy;

public interface FacultyConsultancyRepo extends JpaRepository<FacultyConsultancy, Integer>{

	List<FacultyConsultancy> findByFacultyIdAndDelStatusAndIsActiveAndYearIdOrderByConsIdDesc(int facultyId, int i, int j, int yearId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_consultancy SET del_status=0 WHERE cons_id IN (:consId) ", nativeQuery = true)
	int deleteConsultancy(@Param("consId") int consId);

	FacultyConsultancy findByConsId(int consId);

}
