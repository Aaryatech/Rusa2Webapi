package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.ExtensionActivityReport;

public interface ExtensionActivityReportRepo extends JpaRepository<ExtensionActivityReport, Integer>{

	@Query(value="SELECT\n" + 
			"        t_extension_activity.inst_extension_act_id,\n" + 
			"        CASE           \n" + 
			"            WHEN t_extension_activity.extension_activity_id=0 THEN t_extension_activity.t_activity_title              \n" + 
			"            ELSE (SELECT m_extension_activity.activity_title FROM m_extension_activity\n" + 
			"                  WHERE m_extension_activity.extension_activity_id=t_extension_activity.extension_activity_id)\n" + 
			"        END AS t_activity_title,\n" + 
			"        t_extension_activity.no_of_stud_participated,\n" + 
			"        t_extension_activity.no_of_faculty_participated,\n" + 
			"        t_extension_activity.no_of_stud_in_inst,\n" + 
			"        m_academic_year.academic_year,\n" + 
			"        m_institute.institute_name,\n" + 
			"        ( (t_extension_activity.no_of_stud_participated/ t_extension_activity.no_of_stud_in_inst)*100) as result                \n" + 
			"    FROM\n" + 
			"        t_extension_activity,\n" + 
			"        m_institute,\n" + 
			"        m_academic_year         \n" + 
			"    WHERE\n" + 
			"        m_institute.institute_id = t_extension_activity.inst_id                   \n" + 
			"        AND t_extension_activity.ac_year_id = m_academic_year.year_id                   \n" + 
			"        AND t_extension_activity.inst_id =:instId               \n" + 
			"        AND t_extension_activity.ac_year_id IN(:lastFiveYears) \n" + 
			"        AND t_extension_activity.del_status = 1                   \n" + 
			"        AND t_extension_activity.is_active = 1",nativeQuery=true)
	List<ExtensionActivityReport> getAllExtensionActivity (@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}

/***************************25/10/2019***************************/
/*SELECT\n" + 
			"        t_extension_activity.inst_extension_act_id,\n" + 
			"        CASE \n" + 
			"        	WHEN t_extension_activity.extension_activity_id=0 THEN t_extension_activity.t_activity_title \n" + 
			"            ELSE m_extension_activity.activity_title END AS t_activity_title,\n" + 
			"        t_extension_activity.no_of_stud_participated,\n" + 
			"        t_extension_activity.no_of_faculty_participated,\n" + 
			"        t_extension_activity.no_of_stud_in_inst,\n" + 
			"        m_academic_year.academic_year,\n" + 
			"        m_institute.institute_name,\n" + 
			"        ( (t_extension_activity.no_of_stud_participated/ t_extension_activity.no_of_stud_in_inst)*100) as result           \n" + 
			"    FROM\n" + 
			"        t_extension_activity,\n" + 
			"        m_institute,\n" + 
			"        m_academic_year ,\n" + 
			"        m_extension_activity     \n" + 
			"    WHERE\n" + 
			"        m_institute.institute_id = t_extension_activity.inst_id          \n" + 
			"        AND t_extension_activity.ac_year_id = m_academic_year.year_id          \n" + 
			"        AND t_extension_activity.inst_id =:instId        \n" + 
			"        AND t_extension_activity.ac_year_id IN(:lastFiveYears)          \n" + 
			"        AND t_extension_activity.del_status = 1          \n" + 
			"        AND t_extension_activity.is_active = 1 \n" + 
			"        AND m_extension_activity.extension_activity_id=t_extension_activity.extension_activity_id*/