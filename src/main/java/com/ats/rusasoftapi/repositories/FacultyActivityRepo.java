package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyActivity;

public interface FacultyActivityRepo extends JpaRepository<FacultyActivity, Integer> {
	

	FacultyActivity findByActivityIdAndDelStatus(int activityId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_activity SET del_status=0 WHERE activity_id=:activityId",nativeQuery=true)
	int deleteByActivityId(@Param("activityId") int activityId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_activity SET del_status=0  WHERE activity_id IN (:activityIdList) ",nativeQuery=true)
	int delOrgActivity(@Param("activityIdList") List<String> activityIdList);
}
