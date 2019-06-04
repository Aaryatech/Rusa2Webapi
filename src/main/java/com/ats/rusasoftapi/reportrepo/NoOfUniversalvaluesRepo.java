package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoOfUniversalvalues;
 
public interface NoOfUniversalvaluesRepo extends JpaRepository<NoOfUniversalvalues, Integer> {

	@Query(value="SELECT\n" + 
			"    COUNT(\n" + 
			"        act_cndct_prmtng_univrsl_val.act_cndct_id\n" + 
			"    ) AS act_count,\n" + 
			"    act_cndct_prmtng_univrsl_val.ac_year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    act_cndct_prmtng_univrsl_val,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    act_cndct_prmtng_univrsl_val.ac_year_id IN(:acYearList) AND act_cndct_prmtng_univrsl_val.inst_id =:instId AND act_cndct_prmtng_univrsl_val.del_status = 1 AND act_cndct_prmtng_univrsl_val.is_active = 1 AND act_cndct_prmtng_univrsl_val.ac_year_id = m_academic_year.year_id AND act_cndct_prmtng_univrsl_val.inst_id = m_institute.institute_id\n" + 
			"GROUP BY\n" + 
			"    act_cndct_prmtng_univrsl_val.ac_year_id",nativeQuery=true)
List<NoOfUniversalvalues> getNoOfUniversalValues(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);
	
}
