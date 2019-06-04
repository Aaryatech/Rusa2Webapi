package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.UniversalValPromot;

public interface UniversalValPromotRepo extends JpaRepository<UniversalValPromot, Integer>{
	@Query(value="SELECT\n" + 
			"    act_cndct_prmtng_univrsl_val.act_cndct_id,\n" + 
			"    act_cndct_prmtng_univrsl_val.from_date,\n" + 
			"    act_cndct_prmtng_univrsl_val.to_date,\n" + 
			"    act_cndct_prmtng_univrsl_val.no_of_participant,\n" + 
			"    act_cndct_prmtng_univrsl_val.ttle_progrm_act,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.year_id\n" + 
			"FROM\n" + 
			"    act_cndct_prmtng_univrsl_val,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    act_cndct_prmtng_univrsl_val.ac_year_id In(:acYrList) AND act_cndct_prmtng_univrsl_val.inst_id =:instId AND act_cndct_prmtng_univrsl_val.del_status = 1 AND act_cndct_prmtng_univrsl_val.is_active = 1 AND act_cndct_prmtng_univrsl_val.ac_year_id = m_academic_year.year_id AND act_cndct_prmtng_univrsl_val.inst_id = m_institute.institute_id",nativeQuery=true)
	List<UniversalValPromot> getAllUniversalVal(@Param("instId")int instId,@Param("acYrList") List<Integer> acYrList);
}
