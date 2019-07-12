package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.InitivAddrsLoctnAdvDisadv;

public interface InitivAddrsLoctnAdvDisadvRepo extends JpaRepository<InitivAddrsLoctnAdvDisadv, Integer> {

	

	@Query(value="SELECT specific_local_advntg_disadvntg.spci_adv_id," + 
			"specific_local_advntg_disadvntg.name_of_initiatives," + 
			"specific_local_advntg_disadvntg.no_stud_part," + 
			"m_academic_year.academic_year," + 
			"m_institute.institute_name " + 
			"FROM specific_local_advntg_disadvntg,m_academic_year,m_institute " + 
			"WHERE specific_local_advntg_disadvntg.inst_id=m_institute.institute_id AND " + 
			"specific_local_advntg_disadvntg.ac_year_id=m_academic_year.year_id AND " + 
			"specific_local_advntg_disadvntg.del_status=1 AND specific_local_advntg_disadvntg.is_active=1 AND " + 
			"specific_local_advntg_disadvntg.inst_id=:instId AND m_academic_year.year_id=:acYearId",nativeQuery=true)
	
			List<InitivAddrsLoctnAdvDisadv> getAllInitivAddrsLoctnAdvDisadv(@Param("instId") int instId,@Param ("acYearId") int acYearId);
}
