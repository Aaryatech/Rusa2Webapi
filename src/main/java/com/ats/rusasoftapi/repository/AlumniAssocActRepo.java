package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.AlumniAssocAct;

public interface AlumniAssocActRepo extends JpaRepository<AlumniAssocAct, Integer> {

	List<AlumniAssocAct> findByInstIdAndAcYearIdAndDelStatusOrderByAlmAssocActIdDesc(@Param("instituteId") int instituteId, @Param("yId") int yId, @Param("del")int del);

	AlumniAssocAct findByAlmAssocActId(@Param("almniActivityId") int almniActivityId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE alumni_assoc_act SET del_status=0 WHERE alm_assoc_act_id = :almniActivityId",nativeQuery=true)
	int deleteAlmniActivity(@Param("almniActivityId") int almniActivityId);

	@Transactional
	@Modifying
	@Query(value="UPDATE alumni_assoc_act SET del_status=0  WHERE alm_assoc_act_id IN (:alumniList) ",nativeQuery=true)
	int deleteSelAlumniAssoActivitys(@Param("alumniList") List<String> alumniList);

}