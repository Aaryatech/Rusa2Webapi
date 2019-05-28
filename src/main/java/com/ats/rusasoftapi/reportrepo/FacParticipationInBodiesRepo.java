package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FacParticipationInBodies;
import com.ats.rusasoftapi.model.report.NoOfPrograms;

public interface FacParticipationInBodiesRepo extends JpaRepository<FacParticipationInBodies, Integer> {
	
	
	
	@Query(value=" SELECT t_faculty_contribution.con_id,m_academic_year.academic_year,m_faculty.faculty_first_name, t_faculty_contribution.con_level,t_faculty_contribution.con_name,t_faculty_contribution.con_university,t_faculty_contribution.con_to," + 
			" t_faculty_contribution.con_from,m_institute.institute_name,m_institute.institute_id,t_faculty_contribution.year_id " + 
			" from t_faculty_contribution,m_academic_year,m_faculty,m_institute " + 
			" WHERE t_faculty_contribution.faculty_id=m_faculty.faculty_id AND t_faculty_contribution.year_id=m_academic_year.year_id AND " + 
			" m_faculty.institute_id=m_institute.institute_id " + 
			" AND m_institute.institute_id=:instId AND t_faculty_contribution.year_id IN (:acYearList)",nativeQuery=true)

	List<FacParticipationInBodies> getFacParticipationInBodies(@Param("instId")   int instId,@Param("acYearList")   List<Integer> acYearList);
	

}
 