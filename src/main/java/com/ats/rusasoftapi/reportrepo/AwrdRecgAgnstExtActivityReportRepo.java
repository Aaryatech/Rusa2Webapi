package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AwrdRecgAgnstExtActivityReport;

public interface AwrdRecgAgnstExtActivityReportRepo extends JpaRepository<AwrdRecgAgnstExtActivityReport, Integer> {

	@Query(value="SELECT t_awd_rec_agn_exact.awrd_recg_agnst_ext_act_id," + 
			"	t_awd_rec_agn_exact.act_name," + 
			"	t_awd_rec_agn_exact.name_awarding_body," + 
			"	t_awd_rec_agn_exact.award_year," + 
			"	m_academic_year.academic_year," + 
			"	m_institute.institute_name " + 
			"	FROM t_awd_rec_agn_exact, m_academic_year, m_institute " + 
			"	WHERE t_awd_rec_agn_exact.del_status=1 AND" + 
			"	t_awd_rec_agn_exact.is_active=1 AND" + 
			"	t_awd_rec_agn_exact.inst_id=m_institute.institute_id AND" + 
			"	t_awd_rec_agn_exact.ac_year_id=m_academic_year.year_id AND" + 
			"	t_awd_rec_agn_exact.inst_id=:instId AND" + 
			"	t_awd_rec_agn_exact.ac_year_id IN (:lastFiveYears)",nativeQuery=true)
	List<AwrdRecgAgnstExtActivityReport> getAllAwardRecog(@Param("instId")int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);
	
}
