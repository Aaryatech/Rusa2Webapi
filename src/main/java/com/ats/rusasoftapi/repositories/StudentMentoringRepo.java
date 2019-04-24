package com.ats.rusasoftapi.repositories;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudentMentoring;

public interface StudentMentoringRepo extends JpaRepository<StudentMentoring, Integer> {

	public StudentMentoring findByFacultyIdAndDelStatus(@Param("facId") int facId, @Param("del") int del);

	public StudentMentoring findByMenIdAndDelStatus(@Param("mId") int facId, @Param("del") int del);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_mentoring SET del_status=0 WHERE men_id=:mId",nativeQuery=true)
	public int deleteByMenId(int mId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_mentoring SET del_status=0  WHERE men_id IN (:menIdList) ",nativeQuery=true)
	public int deleteSelStudMentor(@Param("menIdList") List<String> menIdList);

	
	
}
