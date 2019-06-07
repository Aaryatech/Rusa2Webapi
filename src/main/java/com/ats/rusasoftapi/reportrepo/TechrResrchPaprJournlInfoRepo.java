package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.TechrResrchPaprJournlInfo;

public interface TechrResrchPaprJournlInfoRepo extends JpaRepository<TechrResrchPaprJournlInfo, Integer> {

	
	@Query(value="SELECT t_faculty_journal.journal_id," + 
			"t_faculty_journal.ex_var2 AS co_author," + 
			"t_faculty_journal.ex_var1 AS title," + 
			"t_faculty_journal.journal_name," + 
			"t_faculty_journal.journal_year AS publication_year," + 
			"t_faculty_journal.journal_type," + 
			"m_faculty.faculty_first_name," + 
			"m_dept.dept_name, " + 
			"m_academic_year.academic_year," + 
			"m_institute.institute_name " + 
			"FROM t_faculty_journal ,m_faculty ,m_dept , m_academic_year, m_institute " + 
			"WHERE t_faculty_journal.del_status=1 AND " + 
			"t_faculty_journal.is_active=1 AND " + 
			"m_faculty.institute_id=m_institute.institute_id AND " + 
			"m_faculty.faculty_id=t_faculty_journal.faculty_id AND " + 
			"t_faculty_journal.year_id=m_academic_year.year_id AND " + 
			"m_faculty.dept_id=m_dept.dept_id AND " + 
			"m_faculty.institute_id=:instId AND " + 
			"t_faculty_journal.year_id=:acYear",nativeQuery=true)
	List<TechrResrchPaprJournlInfo> getAllTechrResrchPaprJournlInfo(@Param("acYear")int acYear, @Param("instId")int instId);

}
