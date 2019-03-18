package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.FacultyActivity;

public interface FacultyActivityRepo extends JpaRepository<FacultyActivity, Integer> {
	
	List<FacultyActivity> findByFacultyIdAndYearIdAndDelStatusOrderByActivityId(int facId, int yrId, int del);
	
	FacultyActivity findByActivityIdAndDelStatus(int activityId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_activity SET del_status=0 WHERE activity_id=:activityId",nativeQuery=true)
	int deleteByActivityId(@Param("activityId") int activityId);
}
