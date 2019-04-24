package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyConference;

public interface FacultyConferenceRepo extends JpaRepository<FacultyConference, Integer> {

	/*@Modifying
	@Query(value="SELECT conf_id, conf_name, year_id, faculty_id, conf_name, conf_type, conf_date, conf_venue, conf_fund_from, conf_fund_amt, del_status, is_active, maker_user_id, maker_enter_datetime, ex_int1, ex_var1  FROM t_faculty_conference WHERE del_status=1 AND faculty_id=:facId Order By conf_id Desc",nativeQuery=true)
	List<FacultyConference> getListFacultyConference(@Param("facId") int facId);*/

	public FacultyConference findByConfIdAndDelStatus(int facId, int del);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_conference SET del_status=0 WHERE conf_id=:facId",nativeQuery=true)
	int deleteByFacId(@Param("facId") int facId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_conference SET del_status=0  WHERE conf_id IN (:confIdList)",nativeQuery=true)
	int deletePubDetails(@Param("confIdList") List<String> confIdList);


	
}
