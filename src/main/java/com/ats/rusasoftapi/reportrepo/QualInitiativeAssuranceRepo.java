package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.QualInitiativeAssurance;
 
public interface QualInitiativeAssuranceRepo extends JpaRepository<QualInitiativeAssurance, Integer> {

	
	
	@Query(value="SELECT\n" + 
			"    t_institute_quality.quality_id,\n" + 
			"    t_institute_quality.quality_fromdt,\n" + 
			"    t_institute_quality.quality_todt,\n" + 
			"    t_institute_quality.quality_pcount,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_quality_initiatives.quality_initiative_name\n" + 
			"FROM\n" + 
			"    t_institute_quality,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    m_quality_initiatives\n" + 
			"WHERE\n" + 
			"    t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.institute_id AND t_institute_quality.institute_id =:instId AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.year_id IN(:acYearList)",nativeQuery=true)
List<QualInitiativeAssurance> getAllQualAssurance(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);
	
}
