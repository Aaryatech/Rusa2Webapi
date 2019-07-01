package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudSupprtSchemGraph;

public interface StudSupprtSchemGraphRepo extends JpaRepository<StudSupprtSchemGraph, Integer> {

	@Query(value="SELECT " + 
			"	t_support_scheme_detail.sprt_schm_id," + 
			"		CASE" + 
			"        	WHEN t_support_scheme_detail.extra_int1=0 THEN" + 
			"           		  t_support_scheme_detail.scheme_name" + 
			"            WHEN t_support_scheme_detail.extra_int1=7 THEN" + 
			"        		 t_support_scheme_detail.extra_varchar1" + 
			"		END AS scheme_name," + 
			"	t_support_scheme_detail.no_student_benifited," + 
			"    t_support_scheme_detail.support_agency_name," + 
			"    t_institute_info_detail.no_current_admited_stnt " + 
			"FROM" + 
			"	m_institute,m_academic_year," + 
			"    t_support_scheme_detail," + 
			"    t_institute_info_detail " + 
			"WHERE" + 
			"    t_support_scheme_detail.institute_id=m_institute.institute_id AND " + 
			"    t_institute_info_detail.institute_id=m_institute.institute_id AND" + 
			"    t_support_scheme_detail.year_id=m_academic_year.year_id AND " + 
			"    t_institute_info_detail.year_id =m_academic_year.year_id AND " + 
			"    t_institute_info_detail.del_status=1 AND " + 
			"    t_support_scheme_detail.del_status=1 AND " + 
			"    t_support_scheme_detail.is_active=1 AND" + 
			"    m_institute.institute_id=:instId AND " + 
			"    m_academic_year.is_current=1",nativeQuery=true)
	List<StudSupprtSchemGraph> getAllStudSupprtSchemGraphByInstId(@Param("instId") int instId);

}
