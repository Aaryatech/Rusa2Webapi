package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.InstStakeholderFeedbackReport;

public interface InstStakeholderFeedbackReportRepo extends JpaRepository<InstStakeholderFeedbackReport, Integer> {
	
	@Query(value="SELECT t_stakeholder_feedback.stak_fb_id, " + 
			"	 m_institute.institute_name," + 
			"    m_academic_year.academic_year," + 
			"    t_stakeholder_feedback.fb_yesno, " + 
			"    t_stakeholder_feedback.fb_process, " + 
			"    m_stakholder_fb.feedback_from " + 
			"FROM t_stakeholder_feedback," + 
			" 	m_stakholder_fb, m_institute, m_academic_year " + 
			"WHERE t_stakeholder_feedback.institute_id = m_institute.institute_id AND" + 
			"	t_stakeholder_feedback.ac_year_id=m_academic_year.year_id AND" + 
			"	m_institute.institute_id =:instId AND " + 
			"    m_academic_year.year_id IN (:lastFiveYears) AND" + 
			"    t_stakeholder_feedback.del_status = 1 AND " + 
			"    t_stakeholder_feedback.is_active = 1 AND " + 
			"    t_stakeholder_feedback.fb_from_id = m_stakholder_fb.feedback_id ORDER BY m_academic_year.year_id DESC",nativeQuery=true)
	
	List<InstStakeholderFeedbackReport> getAllStkHldrFb(@Param("instId") int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);

}
