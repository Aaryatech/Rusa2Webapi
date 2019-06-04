package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.OtherThanGovtScheme;
 
public interface OtherThanGovtSchemeRepo extends JpaRepository<OtherThanGovtScheme, Integer> {

	
	@Query(value="SELECT\n" + 
			"    t_institute_schemes.inst_scheme_id,\n" + 
			"    t_institute_schemes.inst_scheme_name,\n" + 
			"    t_institute_schemes.inst_students_benefited,\n" + 
			"    t_institute_schemes.inst_schme_offeredby,\n" + 
			"    t_institute_schemes.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    t_institute_info_detail.no_current_admited_stnt\n" + 
			"FROM\n" + 
			"    t_institute_schemes,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    t_institute_info_detail\n" + 
			"WHERE\n" + 
			"    t_institute_schemes.institute_id =:instId AND t_institute_schemes.year_id IN(:acYrList) AND m_academic_year.year_id = t_institute_schemes.year_id AND m_institute.institute_id = t_institute_schemes.institute_id AND t_institute_schemes.del_status = 1 AND t_institute_schemes.is_active = 1 AND t_institute_info_detail.institute_id = t_institute_schemes.institute_id AND t_institute_info_detail.year_id = t_institute_schemes.year_id\n" + 
			"ORDER BY\n" + 
			"    t_institute_schemes.year_id ASC",nativeQuery=true)
	List<OtherThanGovtScheme> getAllOtherThanGovtScheme(@Param("instId")int instId,@Param("acYrList") List<Integer> acYrList);
}
