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

	@Query(value="SELECT alumni_assoc_act.alm_assoc_act_id," + 
			"	 alumni_assoc_act.alumni_meetng_agnda," + 
			"    alumni_assoc_act.date_of_meeting," + 
			"    alumni_assoc_act.name_alumni_assoc," + 
			"    alumni_assoc_act.alumni_reg_no," + 
			"    alumni_assoc_act.date_alumni_reg," + 
			"    alumni_assoc_act.no_alumni_reg," + 
			"    alumni_assoc_act.no_member_attended," + 
			"    alumni_assoc_act.ttl_no_alumni_enrolled," + 
			"    alumni_assoc_act.inst_id," + 
			"    alumni_assoc_act.ac_year_id," + 
			"    alumni_assoc_act.del_status," + 
			"    alumni_assoc_act.is_active," + 
			"    alumni_assoc_act.maker_user_id," + 
			"    alumni_assoc_act.maker_enter_datetime," + 
			"    alumni_assoc_act.ex_int1," + 
			"    alumni_assoc_act.ex_int2," + 
			"    alumni_assoc_act.ex_var1," + 
			"    alumni_assoc_act.ex_var2" + 
			"   " + 
			"FROM alumni_assoc_act " + 
			"WHERE alumni_assoc_act.ac_year_id=:yId AND" + 
			"	alumni_assoc_act.del_status=1 AND" + 
			"   alumni_assoc_act.is_active=1 AND" + 
			"	alumni_assoc_act.inst_id=:instituteId ORDER by alumni_assoc_act.alm_assoc_act_id DESC LIMIT 1",nativeQuery=true)
	AlumniAssocAct findLastRecordByInstIdAndAcYearId(@Param("instituteId") int instituteId,@Param("yId") int yId);

}