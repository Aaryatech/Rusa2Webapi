package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.GetAluminiEngagementReport;
 
public interface GetAluminiEngagementReportRepo extends JpaRepository<GetAluminiEngagementReport, Integer> {

	@Query(value="SELECT\n" + 
			"\n" + 
			"    alumni_assoc_act.alm_assoc_act_id,\n" + 
			"    alumni_assoc_act.name_alumni_assoc,\n" + 
			"    YEAR(\n" + 
			"        alumni_assoc_act.date_alumni_reg\n" + 
			"    ) AS est_year,\n" + 
			"    alumni_assoc_act.alumni_reg_no,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    alumni_assoc_act,m_institute\n" + 
			"WHERE\n" + 
			"    alumni_assoc_act.inst_id =:instId AND   alumni_assoc_act.inst_id=m_institute.institute_id\n" + 
			"ORDER BY\n" + 
			"    alumni_assoc_act.alm_assoc_act_id\n" + 
			"DESC\n" + 
			"LIMIT 1",nativeQuery=true)
	GetAluminiEngagementReport getAllAluminiEnggReportDetails(@Param("instId") int instId);
	
 	
	
}
