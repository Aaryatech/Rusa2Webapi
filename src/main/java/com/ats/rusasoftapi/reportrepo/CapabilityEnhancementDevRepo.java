package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.CapabilityEnhancementDev;
 
public interface CapabilityEnhancementDevRepo extends JpaRepository<CapabilityEnhancementDev, Integer> {

	@Query(value="SELECT\n" + 
			"    t_support_scheme_detail.sprt_schm_id,\n" + 
			"    t_support_scheme_detail.scheme_name,\n" + 
			"    t_support_scheme_detail.support_agency_name,\n" + 
			"    t_support_scheme_detail.no_student_benifited,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_institute,\n" + 
			"    t_support_scheme_detail\n" + 
			"WHERE\n" + 
			"    t_support_scheme_detail.institute_id =:instId AND t_support_scheme_detail.year_id IN(:acYrList) AND t_support_scheme_detail.institute_id = m_institute.institute_id AND t_support_scheme_detail.year_id = m_academic_year.year_id",nativeQuery=true)
	List<CapabilityEnhancementDev> getAllCapabilityEnhancementDev(@Param("instId")int instId,@Param("acYrList") List<Integer> acYrList);
	
	
	@Query(value="SELECT\n" + 
			"    t_support_scheme_detail.sprt_schm_id,\n" + 
			"    t_support_scheme_detail.scheme_name,\n" + 
			"    t_support_scheme_detail.support_agency_name,\n" + 
			"    t_support_scheme_detail.no_student_benifited,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_institute,\n" + 
			"    t_support_scheme_detail\n" + 
			"WHERE\n" + 
			"    t_support_scheme_detail.institute_id =:instId AND t_support_scheme_detail.institute_id = m_institute.institute_id AND t_support_scheme_detail.year_id = m_academic_year.year_id AND t_support_scheme_detail.scheme_name='Vocational Education Training'",nativeQuery=true)
	List<CapabilityEnhancementDev> getAllCapabilityEnhancementDevVET(@Param("instId")int instId);
	
}
