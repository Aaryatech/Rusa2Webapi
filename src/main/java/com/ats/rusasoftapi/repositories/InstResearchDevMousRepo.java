package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstResearchDevMous;

public interface InstResearchDevMousRepo extends JpaRepository<InstResearchDevMous, Integer> {

	@Query(value="SELECT\n" + 
			"		t_inst_research_dev_mous.inst_reasearch_dev_mou_id,\n" + 
			"        t_inst_research_dev_mous.ac_year_id,\n" + 
			"        t_inst_research_dev_mous.inst_id,\n" + 
			"        t_inst_research_dev_mous.research_dev_mou_id,\n" + 
			"        t_inst_research_dev_mous.org_name,\n" + 
			"        t_inst_research_dev_mous.mou_signed_year,\n" + 
			"        t_inst_research_dev_mous.del_status,\n" + 
			"        t_inst_research_dev_mous.dur_fromdt,\n" + 
			"        t_inst_research_dev_mous.dur_todt,\n" + 
			"        t_inst_research_dev_mous.activities_mou,\n" + 
			"        t_inst_research_dev_mous.no_of_stud_benif,\n" + 
			"        t_inst_research_dev_mous.no_of_staff_benif,\n" + 
			"        t_inst_research_dev_mous.del_status,\n" + 
			"        t_inst_research_dev_mous.is_active,\n" + 
			"        t_inst_research_dev_mous.maker_user_id,\n" + 
			"        t_inst_research_dev_mous.maker_datetime,\n" + 
			"        t_inst_research_dev_mous.ex_int1,\n" + 
			"        t_inst_research_dev_mous.ex_var1,\n" + 
			"        t_inst_research_dev_mous.ex_int2,\n" + 
			"        t_inst_research_dev_mous.ex_var2,\n" + 
			"        \n" + 
			"CASE WHEN t_inst_research_dev_mous.research_dev_mou_id = 0\n" + 
			" THEN\n" + 
			"     (SELECT t.mou_title\n" + 
			"       FROM t_inst_research_dev_mous t\n" + 
			"         WHERE t.inst_reasearch_dev_mou_id=t_inst_research_dev_mous.inst_reasearch_dev_mou_id)\n" + 
			"         ELSE\n" + 
			"         (SELECT m_research_dev_mou.mou_title\n" + 
			"          FROM m_research_dev_mou\n" + 
			"          WHERE m_research_dev_mou.research_dev_mou_id=t_inst_research_dev_mous.research_dev_mou_id)END AS mou_title\n" + 
			"         \n" + 
			"\n" + 
			"FROM t_inst_research_dev_mous\n" + 
			"WHERE t_inst_research_dev_mous.del_status=1 AND\n" + 
			"          t_inst_research_dev_mous.inst_id=:instituteId Order By t_inst_research_dev_mous.inst_reasearch_dev_mou_id Desc",nativeQuery=true)
	List<InstResearchDevMous> getAllRsrchDevMousByInstId(@Param("instituteId") int instituteId);

	InstResearchDevMous findByInstReasearchDevMouIdAndDelStatus(int mouRsrchDevId, int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_research_dev_mous SET del_status  = 0 WHERE  inst_reasearch_dev_mou_id =:mouRsrchDevId",nativeQuery=true)
	int deleteMouRsrchDevById(@Param("mouRsrchDevId") int mouRsrchDevId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_research_dev_mous SET del_status=0  WHERE inst_reasearch_dev_mou_id IN (:mouRsrchDevIdList)",nativeQuery=true)
	int deletetRsrchMous(@Param("mouRsrchDevIdList")List<String> mouRsrchDevIdList);
	
	

}
