package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoOfBookReport;
 
public interface NoOfBookReportRepo extends JpaRepository<NoOfBookReport, Integer> {
	
	@Query(value="SELECT COALESCE((SELECT COUNT( t_faculty_conference.conf_id) FROM  t_faculty_conference,m_faculty WHERE\n" + 
			"                t_faculty_conference.faculty_id = m_faculty.faculty_id AND t_faculty_conference.year_id=m_academic_year.year_id AND   t_faculty_conference.del_status = 1 AND t_faculty_conference.is_active = 1  AND m_faculty.institute_id=m_institute.institute_id\n" + 
			"            \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS paper_count,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(\n" + 
			"                t_faculty_book.book_id)\n" + 
			"            FROM\n" + 
			"                t_faculty_book,m_faculty\n" + 
			"               \n" + 
			"            WHERE t_faculty_book.faculty_id=m_faculty.faculty_id AND t_faculty_book.year_id=m_academic_year.year_id AND t_faculty_book.del_status=1 and t_faculty_book.is_active=1  AND m_faculty.institute_id=m_institute.institute_id),0) as book_count,\n" + 
			"            \n" + 
			"            COALESCE((SELECT t_institute_info_detail.no_of_fulltime_faculty FROM t_institute_info_detail\n" + 
			"                      WHERE t_institute_info_detail.year_id=m_academic_year.year_id AND t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.del_status=1),0) as no_of_fulltime_faculty,\n" + 
			"                       \n" + 
			"    \n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year, m_academic_year.year_id\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"  \n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id In(:lastFiveYears)  AND m_institute.institute_id=:instId \n" + 
			"    GROUP by m_academic_year.year_id",nativeQuery=true)
	List<NoOfBookReport> getAllNoOfBookReport(@Param("instId") int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);

}
