package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetFacAcademic;

public interface GetFacAcademicRepo extends JpaRepository<GetFacAcademic, Integer>{

	@Query(value=" SELECT t_faculty_academic.f_aca_id, m_faculty.faculty_id,m_faculty.faculty_first_name as faculty_name,m_qualificatoin.qualification_name, " + 
			" t_faculty_academic.f_class,t_faculty_academic.f_university,t_faculty_academic.f_passing_year " + 
			" FROM m_faculty,t_faculty_academic,m_qualificatoin " + 
			" WHERE m_faculty.faculty_id=t_faculty_academic.faculty_id AND t_faculty_academic.f_qualification_id=m_qualificatoin.qualification_id " + 
			" AND t_faculty_academic.del_status=1 AND t_faculty_academic.is_active=1 AND m_faculty.institute_id=:instId ORDER BY t_faculty_academic.f_aca_id DESC   " + 
			" ", nativeQuery=true)
	
	List<GetFacAcademic> getFacAcademic(@Param("instId") int instId);

}
