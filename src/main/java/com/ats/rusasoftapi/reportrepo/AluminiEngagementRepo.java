package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AluminiEngagement;
 
public interface AluminiEngagementRepo extends JpaRepository<AluminiEngagement, Integer>{
	
	
	@Query(value="SELECT\n" + 
			"    t_alumni_detail.year_id,\n" + 
			"    SUM(t_alumni_detail.ex_int1) AS contri,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    0 as alumini_asso,\n" + 
			"    0 as estb_year\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    t_alumni_detail\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = t_alumni_detail.institute_id AND m_academic_year.year_id = t_alumni_detail.year_id AND t_alumni_detail.del_status = 1 AND t_alumni_detail.is_active = 1 AND t_alumni_detail.institute_id =:instId AND t_alumni_detail.year_id IN(:acYearList)\n" + 
			"GROUP BY\n" + 
			"    t_alumni_detail.year_id",nativeQuery=true)
	List<AluminiEngagement> getAllAluminiEngg(@Param("instId") int instId,@Param("acYearList")   List<Integer> acYearList);

}
