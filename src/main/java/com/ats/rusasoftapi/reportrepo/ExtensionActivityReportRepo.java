package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.ExtensionActivityReport;

public interface ExtensionActivityReportRepo extends JpaRepository<ExtensionActivityReport, Integer>{

	@Query(value="SELECT\n" + 
			"    t_extension_activity.inst_extension_act_id,\n" + 
			"    t_extension_activity.t_activity_title,\n" + 
			"    t_extension_activity.no_of_stud_participated,\n" + 
			"    t_extension_activity.no_of_faculty_participated,\n" + 
			"    t_extension_activity.no_of_stud_in_inst,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    ( (t_extension_activity.no_of_stud_participated/ t_extension_activity.no_of_stud_in_inst)*100) as result\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_extension_activity,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = t_extension_activity.inst_id AND t_extension_activity.ac_year_id = m_academic_year.year_id AND t_extension_activity.inst_id =:instId AND t_extension_activity.ac_year_id IN(:lastFiveYears) AND t_extension_activity.del_status = 1 AND t_extension_activity.is_active = 1",nativeQuery=true)
	List<ExtensionActivityReport> getAllExtensionActivity (@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}