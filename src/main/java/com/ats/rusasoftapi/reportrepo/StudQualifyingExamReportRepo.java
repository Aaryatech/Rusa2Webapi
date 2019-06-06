package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.StudQualifyingExam;
import com.ats.rusasoftapi.model.report.StudQualifyingExamReport;
 
public interface StudQualifyingExamReportRepo extends JpaRepository<StudQualifyingExamReport, Integer> {

	
	@Query(value="SELECT\n" + 
			"    stud_qualifying_exam.stud_exm_id,\n" + 
			"    stud_qualifying_exam.name_qualif_exam,\n" + 
			"    stud_qualifying_exam.level_exam,\n" + 
			"    stud_qualifying_exam.no_stud_appeared,\n" + 
			"    stud_qualifying_exam.no_stud_qualified,\n" + 
			"     m_institute.institute_name,\n" + 
			"    ( ( stud_qualifying_exam.no_stud_qualified/stud_qualifying_exam.no_stud_appeared)*100) as prcnt,\n" + 
			"     \n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    stud_qualifying_exam,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    stud_qualifying_exam.inst_id =:instId AND\n" + 
			"    stud_qualifying_exam.ac_year_id In(:acYearList) AND stud_qualifying_exam.inst_id = m_institute.institute_id AND stud_qualifying_exam.ac_year_id = m_academic_year.year_id AND stud_qualifying_exam.del_status = 1 AND stud_qualifying_exam.is_active = 1", nativeQuery=true)
	List<StudQualifyingExamReport> getAllStudQualifyingExam(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
}
