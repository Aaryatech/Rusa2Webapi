package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoOfLinkages;

public interface NoOfLinkagesRepo extends JpaRepository<NoOfLinkages, Integer> {

	@Query(value="SELECT t_faculty_stud_linkage.faculty_stud_linkage_id," + 
			"	t_faculty_stud_linkage.linkage_title," + 
			"    t_faculty_stud_linkage.partnering_institute," + 
			"    t_faculty_stud_linkage.lab_from_year as estb_year," + 
			"    t_faculty_stud_linkage.nature_of_linkage," + 
			"    m_academic_year.academic_year," + 
			"    m_institute.institute_name " + 
			"FROM t_faculty_stud_linkage, m_academic_year, m_institute " + 
			"WHERE t_faculty_stud_linkage.del_status=1 AND" + 
			"	t_faculty_stud_linkage.is_active=1 AND" + 
			"    t_faculty_stud_linkage.inst_id=m_institute.institute_id AND" + 
			"    t_faculty_stud_linkage.ac_year_id=m_academic_year.year_id AND" + 
			"   	t_faculty_stud_linkage.inst_id=:instId AND" + 
			"    t_faculty_stud_linkage.ac_year_id IN (:lastFiveYears)",nativeQuery=true)
	List<NoOfLinkages> getAllNoOfLinkages(@Param("instId") int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);


}
