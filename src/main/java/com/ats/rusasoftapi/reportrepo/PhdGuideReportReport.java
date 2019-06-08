package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.PhdGuideReport;
 
public interface PhdGuideReportReport extends JpaRepository<PhdGuideReport, Integer> {
	
	@Query(value="SELECT\n" + 
			"        t_faculty_phdguide.phd_id,\n" + 
			"        t_faculty_phdguide.phd_scholar_name,\n" + 
			"        t_faculty_phdguide.co_guide_name,\n" + 
			"        t_faculty_phdguide.university,\n" + 
			"        (     SELECT\n" + 
			"            m_academic_year.academic_year     \n" + 
			"        FROM\n" + 
			"            m_academic_year     \n" + 
			"        WHERE\n" + 
			"            t_faculty_phdguide.phd_reg_year = m_academic_year.year_id ) AS reg_year,\n" + 
			"        (     SELECT\n" + 
			"            m_academic_year.academic_year      \n" + 
			"         \n" + 
			"        FROM\n" + 
			"            m_academic_year     \n" + 
			"        WHERE\n" + 
			"            t_faculty_phdguide.phd_awarded_year = m_academic_year.year_id ) AS awd_year,\n" + 
			"        m_faculty.faculty_first_name AS guide_name,\n" + 
			"        m_institute.institute_name,\n" + 
			"        m_academic_year.academic_year \n" + 
			"    FROM\n" + 
			"        t_faculty_phdguide,\n" + 
			"        m_faculty,\n" + 
			"        m_academic_year,\n" + 
			"        m_institute \n" + 
			"    WHERE\n" + 
			"        t_faculty_phdguide.faculty_id = m_faculty.faculty_id\n" + 
			"          AND m_faculty.institute_id =:instId \n" + 
			"               AND t_faculty_phdguide.year_id IN\n" + 
			"            (\n" + 
			"                :acYearList \n" + 
			"            ) \n" + 
			"            AND t_faculty_phdguide.del_status = 1 \n" + 
			"            AND t_faculty_phdguide.is_active = 1 \n" + 
			"            AND m_faculty.institute_id = m_institute.institute_id \n" + 
			"            AND t_faculty_phdguide.year_id=m_academic_year.year_id",nativeQuery=true)
List<PhdGuideReport> getAllPhdGuideR(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}