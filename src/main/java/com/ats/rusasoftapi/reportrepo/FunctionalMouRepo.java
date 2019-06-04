package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FunctionalMou;

public interface FunctionalMouRepo extends JpaRepository<FunctionalMou, Integer> {

	
	@Query(value="SELECT t_inst_research_dev_mous.inst_reasearch_dev_mou_id," + 
			"	t_inst_research_dev_mous.org_name," + 
			"    t_inst_research_dev_mous.dur_fromdt," + 
			"    t_inst_research_dev_mous.dur_todt," + 
			"    (t_inst_research_dev_mous.no_of_stud_benif+t_inst_research_dev_mous.no_of_staff_benif) as no_benif," + 
			"    m_academic_year.academic_year," + 
			"    m_institute.institute_name	" + 
			"FROM t_inst_research_dev_mous, m_academic_year, m_institute " + 
			"WHERE t_inst_research_dev_mous.del_status=1 AND" + 
			"	t_inst_research_dev_mous.is_active=1 AND" + 
			"    t_inst_research_dev_mous.ac_year_id=m_academic_year.year_id AND" + 
			"    t_inst_research_dev_mous.inst_id=m_institute.institute_id AND" + 
			"    t_inst_research_dev_mous.inst_id=:instId AND" + 
			"    t_inst_research_dev_mous.ac_year_id IN (:lastFiveYears)",nativeQuery=true)
	List<FunctionalMou> getAllFunctnlMou(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);

}
