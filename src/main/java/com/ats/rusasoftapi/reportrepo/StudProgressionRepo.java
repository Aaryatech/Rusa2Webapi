package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudProgression;

public interface StudProgressionRepo extends JpaRepository<StudProgression, Integer> {

	@Query(value="SELECT m_academic_year.year_id," + 
			"t_higher_education_detail.no_student," + 
			"stud_perform_final_yr.no_stud_pass," + 
			"m_institute.institute_name," + 
			"m_academic_year.academic_year " + 
			"FROM t_higher_education_detail, stud_perform_final_yr, m_institute, m_academic_year " + 
			"WHERE t_higher_education_detail.del_status=1 AND t_higher_education_detail.is_active=1 AND " + 
			"t_higher_education_detail.institute_id=m_institute.institute_id AND " + 
			"t_higher_education_detail.year_id=m_academic_year.year_id AND " + 
			"stud_perform_final_yr.inst_id=m_institute.institute_id AND " + 
			"stud_perform_final_yr.ex_int1=m_academic_year.year_id AND " + 
			"m_institute.institute_id=:instId AND m_academic_year.year_id=:acYear",nativeQuery=true)
	List<StudProgression> getAllStudProgression(@Param("instId") int instId, @Param("acYear") int acYear);
}
