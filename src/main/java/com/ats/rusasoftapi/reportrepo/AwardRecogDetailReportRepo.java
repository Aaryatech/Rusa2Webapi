package com.ats.rusasoftapi.reportrepo;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AwardRecogDetailReport;
 
 public interface AwardRecogDetailReportRepo extends JpaRepository<AwardRecogDetailReport, Integer> {

	 @Query(value="SELECT\n" + 
	 		"     COUNT(\n" + 
	 		"        t_faculty_award.award_id\n" + 
	 		"    ) AS award_count,\n" + 
	 		"    t_faculty_award.year_id,\n" + 
	 		"    m_academic_year.academic_year,\n" + 
	 		"    m_institute.institute_name,\n" + 
	 		"    t_institute_info_detail.no_of_fulltime_faculty\n" + 
	 		"FROM\n" + 
	 		"    t_faculty_award,\n" + 
	 		"    m_institute,\n" + 
	 		"    m_academic_year,\n" + 
	 		"    t_institute_info_detail,\n" + 
	 		"    m_faculty\n" + 
	 		"WHERE\n" + 
	 		"    t_faculty_award.faculty_id= m_faculty.faculty_id AND \n" + 
	 		"    t_faculty_award.year_id IN(:lastFiveYears) AND \n" + 
	 		"    m_academic_year.year_id =  t_faculty_award.year_id AND\n" + 
	 		"     m_institute.institute_id = m_faculty.institute_id AND \n" + 
	 		"    t_faculty_award.del_status = 1 AND\n" + 
	 		"    t_faculty_award.is_active = 1 AND \n" + 
	 		"    t_institute_info_detail.institute_id = m_faculty.institute_id  AND\n" + 
	 		"    t_institute_info_detail.year_id = t_faculty_award.year_id  AND m_faculty.institute_id=:instId\n" + 
	 		"Group BY\n" + 
	 		"    t_faculty_award.year_id",nativeQuery=true)
		List<AwardRecogDetailReport> getAllAwardRecogDetailReport(@Param("instId") int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);
	 
	
 }
