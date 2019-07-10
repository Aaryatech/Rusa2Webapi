package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ResrchProjectGrants;

public interface ResrchProjectGrantsRepo extends JpaRepository<ResrchProjectGrants, Integer> {
	
	@Query(value="SELECT t_faculty_project.proj_id," + 
			"			t_faculty_project.proj_name, " + 
			"                CASE" + 
			"                    WHEN t_faculty_project.proj_inv_name='' THEN m_faculty.faculty_first_name " + 
			"                    ELSE t_faculty_project.proj_inv_name " + 
			"                    END AS proj_inv_name, " + 
			"" + 
			"                CASE " + 
			"                    WHEN t_faculty_project.proj_inv_dept2='' THEN m_dept.dept_name " + 
			"                    ELSE t_faculty_project.proj_inv_dept2 " + 
			"                    END AS proj_inv_dept, " + 
			"" + 
			"			t_faculty_project.proj_inv_dept," + 
			"			t_faculty_project.proj_grant," + 
			"			t_faculty_project.proj_frdt," + 
			"			t_faculty_project.proj_todt," + 
			"			t_faculty_project.proj_sponsor," + 
			"			m_institute.institute_name," + 
			"			m_academic_year.academic_year " + 
			"            " + 
			"FROM t_faculty_project, m_academic_year, m_institute,m_faculty, m_dept " + 
			"WHERE t_faculty_project.del_status=1 AND t_faculty_project.is_active=1 AND" + 
			"	m_faculty.dept_id=m_dept.dept_id AND" + 
			"	m_faculty.institute_id=m_institute.institute_id AND" + 
			"	m_faculty.faculty_id=t_faculty_project.faculty_id AND" + 
			"	t_faculty_project.year_id=m_academic_year.year_id AND " + 
			"	m_academic_year.year_id=:acYear AND" + 
			"	m_institute.institute_id=:instId",nativeQuery=true)
	List<ResrchProjectGrants> getAllResrchProjectGrants(@Param("acYear")int acYear,@Param("instId") int instId);

}
