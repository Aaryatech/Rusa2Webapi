package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.DifferentlyAbldStudReport;

public interface DifferentlyAbldStudReportRepo extends JpaRepository<DifferentlyAbldStudReport, Integer> {

	@Query(value="SELECT UUID() AS uniq_id,m_academic_year.academic_year,m_institute.institute_name," + 
			"COALESCE((SELECT t_program_student_category.cat_tot_student FROM t_program_student_category WHERE t_program_student_category.year_id=m_academic_year.year_id AND t_program_student_category.institute_id=m_institute.institute_id AND t_program_student_category.cast_id=:stkId AND t_program_student_category.del_status=1 AND t_program_student_category.is_active=1),0) as no_of_pwd_stud," + 
			"  COALESCE((SELECT t_institute_info_detail.no_current_admited_stnt FROM t_institute_info_detail" + 
			"  WHERE t_institute_info_detail.year_id=m_academic_year.year_id AND t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.del_status=1),0) AS total_stud_enrolled" + 
			"  FROM m_academic_year,m_institute" + 
			"  WHERE m_academic_year.year_id=:acYear AND m_institute.institute_id=:instId",nativeQuery=true)
	List<DifferentlyAbldStudReport> getAllDifferentlyAbledStud(@Param("instId")int instId, @Param("acYear")int acYear, @Param("stkId") int stkId);

}
