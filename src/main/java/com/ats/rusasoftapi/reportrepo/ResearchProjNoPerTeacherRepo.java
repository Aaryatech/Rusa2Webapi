package com.ats.rusasoftapi.reportrepo;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ResearchProjNoPerTeacher;
 
public interface ResearchProjNoPerTeacherRepo extends JpaRepository<ResearchProjNoPerTeacher, String> {

	
	 
	@Query(value="SELECT\n" + 
			" UUID() AS id,\n" + 
			"    m_faculty.faculty_id,\n" + 
			"    m_faculty.faculty_first_name,\n" + 
			"    COUNT(t_faculty_project.proj_id) AS no_of_proj,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year as academicyear\n" + 
			"FROM\n" + 
			"    m_faculty,\n" + 
			"    t_faculty_project,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_faculty.faculty_id = t_faculty_project.faculty_id AND t_faculty_project.year_id = m_academic_year.year_id AND m_faculty.institute_id = m_institute.institute_id AND t_faculty_project.del_status = 1 and m_academic_year.year_id IN(:acYearList) AND m_institute.institute_id=:instId \n" + 
			"GROUP BY\n" + 
			"    m_faculty.faculty_id,\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<ResearchProjNoPerTeacher> getNoOfProjPerFaculty(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

	
	
}
