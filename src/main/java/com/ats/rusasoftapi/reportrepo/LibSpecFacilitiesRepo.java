package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.LibSpecFacilities;
 
public interface LibSpecFacilitiesRepo extends JpaRepository<LibSpecFacilities, Integer>{


	@Query(value="SELECT\n" + 
			"    md_yesno.yesno_title,\n" + 
			"    md_yesno.yesno_id,\n" + 
			"    t_institute_yesno.del_status as yesno_value,\n" + 
			"    t_institute_yesno.inst_yesno_response,\n" + 
			"    m_academic_year.academic_year, m_institute.institute_name\n" + 
			"FROM\n" + 
			"    t_institute_yesno,\n" + 
			"    md_yesno,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_institute_yesno.yesno_id = md_yesno.yesno_id AND m_institute.institute_id = t_institute_yesno.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND md_yesno.yesno_pagecode = 'PAGE6' AND t_institute_yesno.institute_id =:instId AND t_institute_yesno.year_id IN(:acYearList) AND m_academic_year.year_id = t_institute_yesno.year_id",nativeQuery=true)

	List<LibSpecFacilities> getLibSpecialFacilities(@Param("instId")   int instId,@Param("acYearList")   List<Integer> acYearList);

	
	/********************Mahendra 05/09/2019**********************/
	/*SELECT\n" + 
	"    md_yesno.yesno_title,\n" + 
	"    md_yesno.yesno_id,\n" + 
	"    t_institute_yesno.yesno_value,\n" + 
	"    t_institute_yesno.inst_yesno_response,\n" + 
	"    m_academic_year.academic_year, m_institute.institute_name\n" + 
	"FROM\n" + 
	"    t_institute_yesno,\n" + 
	"    md_yesno,\n" + 
	"    m_institute,\n" + 
	"    m_academic_year\n" + 
	"WHERE\n" + 
	"    t_institute_yesno.yesno_id = md_yesno.yesno_id AND m_institute.institute_id = t_institute_yesno.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND md_yesno.yesno_pagecode = 'PAGE6' AND t_institute_yesno.institute_id =:instId AND t_institute_yesno.year_id IN(:acYearList) AND m_academic_year.year_id = t_institute_yesno.year_id
	*/
}
