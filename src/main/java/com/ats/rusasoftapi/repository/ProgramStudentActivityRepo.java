package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramActivity;

public interface ProgramStudentActivityRepo extends JpaRepository<ProgramActivity, Integer>{

	List<ProgramActivity> findByTypeAndYearIdOrderByStudentActivityIdDesc(int type, int yearId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_student_activity SET del_status=0 WHERE student_activity_id IN (:activityId) ", nativeQuery = true)
	int deleteActivity(@Param("activityId")int activityId);

}
