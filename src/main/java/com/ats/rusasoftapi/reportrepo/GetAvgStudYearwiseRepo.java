package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.GetAvgStudYearwise;

public interface GetAvgStudYearwiseRepo extends JpaRepository<GetAvgStudYearwise, Integer> {
	
	@Query(value=" select m_location.location_id ,COALESCE((SELECT sum(t_program_student_location.loc_tot_student) from t_program_student_location WHERE t_program_student_location.institute_id=m_institute.institute_id  \n" + 
			"            AND t_program_student_location.del_status=1 AND t_program_student_location.is_active=1\n" + 
			"           AND t_program_student_location.location_id=m_location.location_id AND t_program_student_location.year_id=:acId1),0) as ac_year_admi_stud1,\n" + 
			"           \n" + 
			"            COALESCE((SELECT sum(t_program_student_location.loc_tot_student) from t_program_student_location WHERE t_program_student_location.institute_id=m_institute.institute_id AND t_program_student_location.del_status=1 AND t_program_student_location.is_active=1\n" + 
			"           AND t_program_student_location.location_id=m_location.location_id AND t_program_student_location.year_id=:acId2),0) as ac_year_admi_stud2,\n" + 
			"           \n" + 
			"           COALESCE((SELECT sum(t_program_student_location.loc_tot_student) from t_program_student_location WHERE t_program_student_location.institute_id=m_institute.institute_id AND t_program_student_location.del_status=1 AND t_program_student_location.is_active=1\n" + 
			"           AND t_program_student_location.location_id=m_location.location_id AND t_program_student_location.year_id=:acId3),0) as ac_year_admi_stud3,\n" + 
			"           \n" + 
			"           COALESCE((SELECT sum(t_program_student_location.loc_tot_student) from t_program_student_location WHERE t_program_student_location.institute_id=m_institute.institute_id AND t_program_student_location.del_status=1 AND t_program_student_location.is_active=1\n" + 
			"           AND t_program_student_location.location_id=m_location.location_id AND t_program_student_location.year_id=:acId4),0) as ac_year_admi_stud4,\n" + 
			"           \n" + 
			"           COALESCE((SELECT sum(t_program_student_location.loc_tot_student) from t_program_student_location WHERE t_program_student_location.institute_id=m_institute.institute_id AND t_program_student_location.del_status=1 AND t_program_student_location.is_active=1\n" + 
			"           AND t_program_student_location.location_id=m_location.location_id AND t_program_student_location.year_id=:acId5),0) as ac_year_admi_stud5,\n" + 
			"         \n" + 
			"          m_institute.institute_name,m_location.location_name\n" + 
			"          FROM m_institute,m_location\n" + 
			"          WHERE m_institute.institute_id=:instId AND m_location.location_id IN (:stkId) group by m_location.location_id ORDER by m_location.location_id desc",nativeQuery=true)

	List<GetAvgStudYearwise> getAvgStudYearwiseLocWise(@Param("instId")   int instId,@Param("stkId")   String stkId,@Param("acId1")   String acId1,@Param("acId2")   String acId2,@Param("acId3")   String acId3,@Param("acId4")   String acId4,@Param("acId5")   String acId5);

}
