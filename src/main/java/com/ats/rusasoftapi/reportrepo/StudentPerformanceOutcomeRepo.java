package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.StudentPerformanceOutcome;

public interface StudentPerformanceOutcomeRepo extends JpaRepository<StudentPerformanceOutcome, Integer> {

	
	@Query(value="SELECT\n" + 
			"        t_faculty_subject_co.co_id,\n" + 
			"        t_faculty_subject_co.sub_id,\n" + 
			"        t_faculty_subject.sub_code,\n" + 
			"        t_faculty_subject.sub_name,\n" + 
			"        t_faculty_subject_co.co_name,\n" + 
			"        t_program.name_of_program,\n" + 
			"        m_program_type.program_name,\n" + 
			"        m_institute.institute_name \n" + 
			"FROM\n" + 
			"        t_faculty_subject_co,\n" + 
			"        t_faculty_subject,\n" + 
			"        t_program,\n" + 
			"        m_program_type,\n" + 
			"        m_institute \n" + 
			"WHERE\n" + 
			"    	 t_faculty_subject.del_status=1\n" + 
			"        AND t_faculty_subject.is_active=1\n" + 
			"        AND m_institute.institute_id = t_program.institute_id \n" + 
			"        AND t_program.program_type = m_program_type.program_id \n" + 
			"        AND t_program.program_id = t_faculty_subject.prog_id \n" + 
			"        AND t_faculty_subject.sub_id = t_faculty_subject_co.sub_id \n" + 
			"        AND t_program.institute_id =:instId\n" + 
			"        AND t_program.program_id =:programId",nativeQuery=true)

	List<StudentPerformanceOutcome> getStudPerformanceOutcome(@Param("instId")   int instId,@Param("programId")   int programId);
}


/****************27/07/2019**************/
/*SELECT\n" + 
"    t_faculty_subject_co.co_id,\n" + 
"    t_faculty_subject_co.sub_id,\n" + 
"    t_faculty_subject.sub_code,\n" + 
"    t_faculty_subject.sub_name,\n" + 
"    t_faculty_subject_co.co_name,\n" + 
"    t_program.name_of_program,\n" + 
"    m_program_type.program_name,\n" + 
"    m_institute.institute_name\n" + 
"FROM\n" + 
"    t_faculty_subject_co,\n" + 
"    t_faculty_subject,\n" + 
"    t_program,\n" + 
"    m_program_type,\n" + 
"    m_institute\n" + 
"WHERE\n" + 
"    m_institute.institute_id = t_program.institute_id AND "
+ "t_program.program_type = m_program_type.program_id AND "
+ "t_program.program_id = t_faculty_subject.prog_id AND "
+ "t_faculty_subject.sub_id = t_faculty_subject_co.sub_id AND "
+ "t_program.institute_id =:instId AND t_program.program_id =:programId*/