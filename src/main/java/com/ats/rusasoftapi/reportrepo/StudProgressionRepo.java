package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudProgression;

public interface StudProgressionRepo extends JpaRepository<StudProgression, Integer> {

	@Query(value="SELECT\n" + 
			"        m_academic_year.year_id,\n" + 
			"        t_higher_education_detail.no_student,\n" + 
			"        stud_perform_final_yr.no_stud_pass,\n" + 
			"        m_institute.institute_name,\n" + 
			"        m_academic_year.academic_year \n" + 
			"    FROM\n" + 
			"        t_higher_education_detail,\n" + 
			"        stud_perform_final_yr,\n" + 
			"        m_institute,\n" + 
			"        m_academic_year \n" + 
			"    WHERE\n" + 
			"   		 stud_perform_final_yr.del_status=1 AND\n" + 
			"   		 stud_perform_final_yr.is_active=1 AND\n" + 
			"        t_higher_education_detail.del_status=1 \n" + 
			"        AND t_higher_education_detail.is_active=1 \n" + 
			"        AND t_higher_education_detail.institute_id=m_institute.institute_id \n" + 
			"        AND t_higher_education_detail.year_id=m_academic_year.year_id \n" + 
			"        AND stud_perform_final_yr.inst_id=m_institute.institute_id \n" + 
			"        AND stud_perform_final_yr.ex_int1=m_academic_year.year_id \n" + 
			"        AND m_institute.institute_id=:instId\n" + 
			"        AND m_academic_year.year_id=:acYear",nativeQuery=true)
	List<StudProgression> getAllStudProgression(@Param("instId") int instId, @Param("acYear") int acYear);
}



/*SELECT m_academic_year.year_id," + 
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
"m_institute.institute_id=:instId AND m_academic_year.year_id=:acYear*/