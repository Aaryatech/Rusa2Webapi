package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.EGovernenceOperation;

public interface EGovernenceOperationRepo extends JpaRepository<EGovernenceOperation, String> {

	@Query(value="SELECT\n" + 
			"    UUID() as id , md_yesno.yesno_id, md_yesno.yesno_title, m_academic_year.academic_year, m_institute.institute_name, COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            1\n" + 
			"        FROM\n" + 
			"            t_institute_yesno\n" + 
			"        WHERE\n" + 
			"            t_institute_yesno.yesno_id = md_yesno.yesno_id AND t_institute_yesno.year_id = m_academic_year.year_id AND t_institute_yesno.institute_id = m_institute.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND t_institute_yesno.yesno_pagecode = md_yesno.yesno_pagecode\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS yesno_value,\n" + 
			"    \n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_yesno.inst_yesno_response\n" + 
			"        FROM\n" + 
			"            t_institute_yesno\n" + 
			"        WHERE\n" + 
			"            t_institute_yesno.yesno_id = md_yesno.yesno_id AND t_institute_yesno.year_id = m_academic_year.year_id AND t_institute_yesno.institute_id = m_institute.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND t_institute_yesno.yesno_pagecode = md_yesno.yesno_pagecode\n" + 
			"    ),\n" + 
			"   'NA'\n" + 
			"    ) AS inst_yesno_response\n" + 
			"FROM\n" + 
			"    md_yesno,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id =:instId AND m_academic_year.year_id IN(:acYearList) AND md_yesno.yesno_seccode =:seccode AND md_yesno.yesno_pagecode =:pagecode AND md_yesno.del_status = 1 AND md_yesno.is_active = 1",nativeQuery=true)
	List<EGovernenceOperation> getEGovernanceOpt(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("seccode") String seccode,@Param("pagecode") String pagecode);
	
	
	/*
	 * @Query(value="SELECT\n" +
	 * "    UUID() AS id, md_yesno.yesno_id, md_yesno.yesno_title, m_institute.institute_name, m_academic_year.academic_year, t_institute_yesno.yesno_dynamic_title, t_institute_yesno.inst_yesno_response,t_institute_yesno.yesno_value \n"
	 * + "FROM\n" +
	 * "    t_institute_yesno, md_yesno, m_institute, m_academic_year\n" + "WHERE\n"
	 * +
	 * "    t_institute_yesno.institute_id = m_institute.institute_id AND t_institute_yesno.yesno_id = md_yesno.yesno_id AND t_institute_yesno.year_id = m_academic_year.year_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND t_institute_yesno.institute_id =:instId  AND md_yesno.yesno_seccode = :seccode AND md_yesno.yesno_pagecode =:pagecode AND  m_academic_year.year_id IN (:acYearList)  AND   md_yesno.yesno_id IN(:temp)"
	 * ,nativeQuery=true) List<EGovernenceOperation>
	 * getEGovernanceOpt41(@Param("instId") int instId,@Param("acYearList")
	 * List<Integer> acYearList,@Param("seccode") String seccode,@Param("pagecode")
	 * String pagecode,@Param("temp") List<Integer> temp);
	 */
	@Query(value="SELECT\n" + 
			"    UUID() as id , md_yesno.yesno_id, md_yesno.yesno_title, m_academic_year.academic_year, m_institute.institute_name, COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            1\n" + 
			"        FROM\n" + 
			"            t_institute_yesno\n" + 
			"        WHERE\n" + 
			"            t_institute_yesno.yesno_id = md_yesno.yesno_id AND t_institute_yesno.year_id = m_academic_year.year_id AND t_institute_yesno.institute_id = m_institute.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND t_institute_yesno.yesno_pagecode = md_yesno.yesno_pagecode\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS yesno_value,\n" + 
			"    \n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_yesno.inst_yesno_response\n" + 
			"        FROM\n" + 
			"            t_institute_yesno\n" + 
			"        WHERE\n" + 
			"            t_institute_yesno.yesno_id = md_yesno.yesno_id AND t_institute_yesno.year_id = m_academic_year.year_id AND t_institute_yesno.institute_id = m_institute.institute_id AND t_institute_yesno.del_status = 1 AND t_institute_yesno.is_active = 1 AND t_institute_yesno.yesno_pagecode = md_yesno.yesno_pagecode\n" + 
			"    ),\n" + 
			"   'NA'\n" + 
			"    ) AS inst_yesno_response\n" + 
			"FROM\n" + 
			"    md_yesno,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id =:instId AND m_academic_year.year_id IN(:acYearList) AND md_yesno.yesno_seccode =:seccode AND md_yesno.yesno_pagecode =:pagecode AND md_yesno.del_status = 1 AND md_yesno.is_active = 1 AND md_yesno.yesno_id IN(:temp)",nativeQuery=true)
	List<EGovernenceOperation> getEGovernanceOpt4(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("seccode") String seccode,@Param("pagecode") String pagecode,@Param("temp") List<Integer> temp);
}
