package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StakeHolderFBReport;
 
public interface StakeHolderFBReportRepo extends JpaRepository<StakeHolderFBReport, Integer>{

	@Query(value="SELECT\n" + 
			"    t_stakeholder_feedback.stak_fb_id,\n" + 
			"    t_stakeholder_feedback.fb_process,\n" + 
			"    m_stakholder_fb.feedback_from,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    t_stakeholder_feedback.fb_yesno\n" + 
			"FROM\n" + 
			"    t_stakeholder_feedback,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    m_stakholder_fb\n" + 
			"WHERE\n" + 
			"    t_stakeholder_feedback.institute_id = m_institute.institute_id AND m_academic_year.year_id = t_stakeholder_feedback.ac_year_id AND t_stakeholder_feedback.fb_from_id = m_stakholder_fb.feedback_id AND t_stakeholder_feedback.del_status = 1 AND t_stakeholder_feedback.is_active = 1 AND t_stakeholder_feedback.institute_id =:instId AND t_stakeholder_feedback.ac_year_id IN(:acYearList)", nativeQuery=true)
	List<StakeHolderFBReport> getAllStakeHolderFBReport(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
	
}
