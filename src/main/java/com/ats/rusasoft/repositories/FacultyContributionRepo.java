package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.FacultyContribution;

public interface FacultyContributionRepo extends JpaRepository<FacultyContribution, Integer> {
	
	List<FacultyContribution> findByFacultyIdAndYearIdAndDelStatusOrderByConIdDesc(int facId, int yrId, int del);
	
	FacultyContribution findByConId(int conId);
	

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_contribution SET del_status=0 WHERE con_id=:conId",nativeQuery=true)
	int deleteFContributionByconId(int conId);
}
