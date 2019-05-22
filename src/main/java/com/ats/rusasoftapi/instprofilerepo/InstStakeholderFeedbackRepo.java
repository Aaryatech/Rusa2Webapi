package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstStakeholderFeedback;
 
public interface InstStakeholderFeedbackRepo extends JpaRepository<InstStakeholderFeedback, Integer>  {
	
	
	@Query(value="SELECT\n" + 
			"    t_stakeholder_feedback.stak_fb_id,\n" + 
			"    t_stakeholder_feedback.institute_id,\n" + 
			"    t_stakeholder_feedback.ac_year_id,\n" + 
			"    t_stakeholder_feedback.fb_from_id,\n" + 
			"    t_stakeholder_feedback.fb_yesno,\n" + 
			"    t_stakeholder_feedback.yr_sem,\n" + 
			"    t_stakeholder_feedback.fb_process,\n" + 
			"    t_stakeholder_feedback.del_status,\n" + 
			"    t_stakeholder_feedback.is_active,\n" + 
			"    t_stakeholder_feedback.maker_user_id,\n" + 
			"    t_stakeholder_feedback.maker_datetime,\n" + 
			"    t_stakeholder_feedback.ex_int1,\n" + 
			"    t_stakeholder_feedback .ex_int2,\n" + 
			"    t_stakeholder_feedback.ex_var2,\n" + 
			"    m_stakholder_fb.feedback_from AS ex_var1\n" + 
			"FROM\n" + 
			"    t_stakeholder_feedback,\n" + 
			"    m_stakholder_fb\n" + 
			"WHERE\n" + 
			"    t_stakeholder_feedback.institute_id =:instId AND t_stakeholder_feedback.ac_year_id =:yearId AND t_stakeholder_feedback.del_status = 1 AND t_stakeholder_feedback.is_active = 1 AND t_stakeholder_feedback.fb_from_id = m_stakholder_fb.feedback_id",nativeQuery=true)

	List<InstStakeholderFeedback> getAllStlFb(@Param("instId")int instId,@Param("yearId") int yearId
			);

	 
}
