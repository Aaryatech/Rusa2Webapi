package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudEnrooledForProgramReport;
 
public interface StudEnrooledForProgramReportRepo extends JpaRepository<StudEnrooledForProgramReport, Integer> {

	
	@Query(value=" SELECT\n" + 
			"    m_academic_year.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_program_type.program_name,\n" + 
			"    m_institute.institute_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(\n" + 
			"                t_program_student_category.cat_tot_student\n" + 
			"            )\n" + 
			"        FROM\n" + 
			"            t_program_student_category,\n" + 
			"            t_program\n" + 
			"        WHERE\n" + 
			"            t_program_student_category.program_id = t_program.program_id AND t_program.program_type = m_program_type.program_id AND t_program_student_category.del_status = 1 AND t_program_student_category.is_active = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS prog_stud_enrolled,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_info_detail.no_current_admited_stnt\n" + 
			"        FROM\n" + 
			"            t_institute_info_detail\n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.year_id = m_academic_year.year_id AND t_institute_info_detail.del_status = 1 AND t_institute_info_detail.institute_id = m_institute.institute_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS total_stud\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_program_type,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_program_type.program_id =:programId AND m_academic_year.year_id IN(:acYearList) AND m_institute.institute_id =:instId \n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id",nativeQuery=true)

	List<StudEnrooledForProgramReport> getStudEnrooledForProgramReport(@Param("instId")   int instId,@Param("acYearList") List<Integer> acYearList,@Param("programId")   int programId);
}
