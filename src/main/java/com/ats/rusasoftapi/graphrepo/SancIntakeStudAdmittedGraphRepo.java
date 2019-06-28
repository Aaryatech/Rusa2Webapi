package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.SancIntakeStudAdmittedGraph;
 
public interface SancIntakeStudAdmittedGraphRepo extends JpaRepository<SancIntakeStudAdmittedGraph, Integer>{

	
	@Query(value="SELECT\n" + 
			"    SUM(t_prog_sanc_intake.sanc_intake) AS total_sanc_intake,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    t_institute_info_detail.no_current_admited_stnt,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.year_id\n" + 
			"FROM\n" + 
			"    t_prog_sanc_intake,\n" + 
			"    t_institute_info_detail,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_prog_sanc_intake.ac_year_id = m_academic_year.year_id AND t_institute_info_detail.year_id = m_academic_year.year_id AND t_institute_info_detail.institute_id = m_institute.institute_id AND t_prog_sanc_intake.inst_id = m_institute.institute_id AND t_prog_sanc_intake.del_status = 1 AND t_prog_sanc_intake.is_active = 1 AND t_institute_info_detail.del_status = 1 AND m_institute.institute_id =:instId AND m_academic_year.year_id IN(:lastFiveYears)\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<SancIntakeStudAdmittedGraph> getGraph1Data(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}
