package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoOfStudTeachLinkageReport;
 
public interface NoOfStudTeachLinkageReportRepo extends JpaRepository<NoOfStudTeachLinkageReport, Integer> {

	
	@Query(value="SELECT\n" + 
			"    COUNT(\n" + 
			"        t_faculty_stud_linkage.faculty_stud_linkage_id\n" + 
			"    ) AS linkage_count,\n" + 
			"    t_faculty_stud_linkage.ac_year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    t_faculty_stud_linkage,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_faculty_stud_linkage.ac_year_id IN(:acYrList) AND t_faculty_stud_linkage.del_status = 1 AND t_faculty_stud_linkage.ac_year_id = m_academic_year.year_id AND t_faculty_stud_linkage.inst_id = m_institute.institute_id AND t_faculty_stud_linkage.is_active = 1 AND t_faculty_stud_linkage.inst_id=:instId \n" + 
			"GROUP BY\n" + 
			"    t_faculty_stud_linkage.ac_year_id",nativeQuery=true)
	List<NoOfStudTeachLinkageReport> getAllNoOfStudTeachLinkage(@Param("instId")int instId,@Param("acYrList") List<Integer> acYrList);
}
