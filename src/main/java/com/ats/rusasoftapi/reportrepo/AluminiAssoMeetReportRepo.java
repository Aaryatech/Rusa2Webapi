package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 import com.ats.rusasoftapi.model.report.AluminiAssoMeetReport;
 
public interface AluminiAssoMeetReportRepo extends JpaRepository<AluminiAssoMeetReport, Integer>{

	

	@Query(value="SELECT\n" + 
			"    alumni_assoc_act.alm_assoc_act_id,\n" + 
			"    alumni_assoc_act.name_alumni_assoc,\n" + 
			"    alumni_assoc_act.date_of_meeting,\n" + 
			"    alumni_assoc_act.ac_year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    alumni_assoc_act,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = alumni_assoc_act.inst_id AND alumni_assoc_act.ac_year_id = m_academic_year.year_id AND alumni_assoc_act.inst_id =:instId AND alumni_assoc_act.ac_year_id IN(:lastFiveYears) AND alumni_assoc_act.del_status=1 AND alumni_assoc_act.is_active=1",nativeQuery=true)
	List<AluminiAssoMeetReport> getAllAluminiAsso(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}
