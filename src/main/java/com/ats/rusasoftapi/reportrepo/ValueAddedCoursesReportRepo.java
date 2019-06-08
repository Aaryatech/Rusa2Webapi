package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.ValueAddedCoursesReport;

public interface ValueAddedCoursesReportRepo extends JpaRepository<ValueAddedCoursesReport, Integer>{
	 
	@Query(value="SELECT\n" + 
			"    value_added_courses.value_added_course_id,\n" + 
			"    value_added_courses.value_added_course_name,\n" + 
			"    value_added_courses.course_code,\n" + 
			"    value_added_courses.year_of_offering,\n" + 
			"    value_added_courses.year_of_discontinuation,\n" + 
			"    value_added_courses.no_of_students_enrolled,\n" + 
			"    value_added_courses.no_of_students_completed_course,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    value_added_courses,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    value_added_courses.inst_id = m_institute.institute_id AND m_academic_year.year_id = value_added_courses.academic_year_id AND value_added_courses.academic_year_id IN(:acYearList) AND value_added_courses.inst_id =:instId \n" + 
			"",nativeQuery=true)
	List<ValueAddedCoursesReport> getAllValueAddedCoursesReport(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);
}
