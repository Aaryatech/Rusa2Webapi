package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoInitivAddrsLoctnAdvDisadv;

public interface NoInitivAddrsLoctnAdvDisadvRepo extends JpaRepository<NoInitivAddrsLoctnAdvDisadv, Integer> {
	
	@Query(value="SELECT COUNT(specific_local_advntg_disadvntg.spci_adv_id) as ttl_initives," + 
			" m_academic_year.academic_year," + 
			" m_institute.institute_name " + 
			"FROM specific_local_advntg_disadvntg, m_academic_year, m_institute " + 
			"WHERE specific_local_advntg_disadvntg.del_status=1 AND" + 
			" specific_local_advntg_disadvntg.is_active=1 AND" + 
			" specific_local_advntg_disadvntg.ac_year_id=m_academic_year.year_id AND" + 
			" specific_local_advntg_disadvntg.inst_id=m_institute.institute_id AND" + 
			" specific_local_advntg_disadvntg.inst_id=:instId" + 
			" GROUP BY specific_local_advntg_disadvntg.ac_year_id",nativeQuery=true)
	List<NoInitivAddrsLoctnAdvDisadv> getAllNoInitivAddrsLoctnAdvDisadvRepo(@Param("instId") int instId);
}
