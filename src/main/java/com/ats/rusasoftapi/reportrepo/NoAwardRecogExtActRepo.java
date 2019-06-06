package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.report.NoAwardRecogExtAct;

public interface NoAwardRecogExtActRepo extends JpaRepository<NoAwardRecogExtAct, Integer> {
	
	@Query(value="SELECT 	UUID() AS uniq_id," + 
			" t_awd_rec_agn_exact.award_year," + 
			" COUNT(t_awd_rec_agn_exact.awrd_recg_agnst_ext_act_id) AS no_award," + 
			" m_institute.institute_name," + 
			" m_academic_year.academic_year " + 
			"FROM t_awd_rec_agn_exact, m_academic_year, m_institute " + 
			"WHERE t_awd_rec_agn_exact.del_status=1 AND t_awd_rec_agn_exact.is_active=1 AND" + 
			" m_institute.institute_id=t_awd_rec_agn_exact.inst_id AND" + 
			" t_awd_rec_agn_exact.ac_year_id=m_academic_year.year_id AND" + 
			" t_awd_rec_agn_exact.inst_id=:instId AND " + 
			" t_awd_rec_agn_exact.ac_year_id IN (:lastFiveYears)" + 
			" GROUP BY t_awd_rec_agn_exact.award_year",nativeQuery=true)
		List<NoAwardRecogExtAct> getAllNoAwardRecogExtAct(int instId, List<Integer> lastFiveYears);

}
