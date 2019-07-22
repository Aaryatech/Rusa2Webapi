package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.DifferentlyAbldStudReport;

public interface DifferentlyAbldStudReportRepo extends JpaRepository<DifferentlyAbldStudReport, Integer> {

	@Query(value="SELECT UUID() as uniq_id," + 
			"	 m_institute.institute_name," + 
			"    m_academic_year.academic_year," + 
			"    t_institute_info_detail.no_current_admited_stnt AS total_stud_enrolled ," + 
			"    SUM(t_program_student_location.loc_tot_student)AS no_of_pwd_stud  " + 			
			"FROM " + 
			"	t_program_student_location, t_institute_info_detail, m_institute, m_academic_year " + 
			"WHERE" + 
			"	t_program_student_location.location_id =:stkId AND" + 
			"	t_program_student_location.institute_id = t_institute_info_detail.institute_id AND" + 
			"   t_program_student_location.year_id = t_institute_info_detail.year_id AND" + 
			"   t_program_student_location.is_active=1 AND" + 
			"   t_program_student_location.del_status=1 AND" + 
			"   m_institute.institute_id = t_program_student_location.institute_id AND" + 
			"   m_academic_year.year_id = t_program_student_location.year_id AND" + 
			"   m_institute.institute_id =:instId AND" + 
			"   m_academic_year.year_id =:acYear" + 
			"   GROUP BY t_program_student_location.year_id",nativeQuery=true)
	List<DifferentlyAbldStudReport> getAllDifferentlyAbledStud(@Param("instId")int instId, @Param("acYear")int acYear, @Param("stkId") int stkId);

}

//Last Query//

/*SELECT UUID() AS uniq_id,m_academic_year.academic_year,m_institute.institute_name," + 
"COALESCE((SELECT t_program_student_category.cat_tot_student FROM t_program_student_category WHERE t_program_student_category.year_id=m_academic_year.year_id AND t_program_student_category.institute_id=m_institute.institute_id AND t_program_student_category.cast_id=:stkId AND t_program_student_category.del_status=1 AND t_program_student_category.is_active=1),0) as no_of_pwd_stud," + 
"  COALESCE((SELECT t_institute_info_detail.no_current_admited_stnt FROM t_institute_info_detail" + 
"  WHERE t_institute_info_detail.year_id=m_academic_year.year_id AND t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.del_status=1),0) AS total_stud_enrolled" + 
"  FROM m_academic_year,m_institute" + 
"  WHERE m_academic_year.year_id=:acYear AND m_institute.institute_id=:instId*/