package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetProgramActivity;

public interface GetProgramActivityRepo extends JpaRepository<GetProgramActivity, Integer>{

	@Query(value="select p.*,y.academic_year as year_name from t_program_student_activity p, m_academic_year y where y.year_id=p.year_id"
			+ " and p.del_status=1 and p.type=:type and p.year_id=:yearId and p.institute_id=:instituteId Order By p.student_activity_id Desc ", nativeQuery=true)
	List<GetProgramActivity> getStudentAcitivityList(@Param("type") int type,@Param("yearId") int yearId,@Param("instituteId") int instituteId);

	@Query(value="select p.*,y.academic_year as year_name from t_program_student_activity p, m_academic_year y where y.year_id=p.year_id"
			+ " and p.del_status=1 and p.type=:type and p.year_id=:yearId and p.student_activity_id=:activityId", nativeQuery=true)
	GetProgramActivity getStudentAcitivityByActivityId(@Param("activityId")int activityId,@Param("type") int type,@Param("yearId") int yearId);

}
