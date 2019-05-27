package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.NoOfMentorsAssignedStudent;

public interface NoOfMentorsAssignedStudentRepo extends JpaRepository<NoOfMentorsAssignedStudent, Integer> {

	
	
	@Query(value="SELECT\n" + 
			"m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(*)\n" + 
			"        FROM\n" + 
			"            t_faculty_mentoring,\n" + 
			"            m_faculty\n" + 
			"        WHERE\n" + 
			"            t_faculty_mentoring.faculty_id = m_faculty.faculty_id AND m_faculty.institute_id = m_institute.institute_id AND t_faculty_mentoring.del_status = 1 AND t_faculty_mentoring.is_active = 1 AND t_faculty_mentoring.year_id=(SELECT m_academic_year.year_id from m_academic_year where m_academic_year.is_current=1)\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS total_fac_mentor,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(\n" + 
			"                t_faculty_mentoring.men_stu_count\n" + 
			"            )\n" + 
			"        FROM\n" + 
			"            t_faculty_mentoring,\n" + 
			"            m_faculty\n" + 
			"        WHERE\n" + 
			"            t_faculty_mentoring.faculty_id = m_faculty.faculty_id AND m_faculty.institute_id = m_institute.institute_id AND t_faculty_mentoring.del_status = 1 AND t_faculty_mentoring.is_active = 1 AND t_faculty_mentoring.year_id=(SELECT m_academic_year.year_id from m_academic_year where m_academic_year.is_current=1)\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS total_stud_mentoring\n" + 
			"FROM\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = :instId",nativeQuery=true)

	List<NoOfMentorsAssignedStudent> getNoOfMentorsAssignedStudent(@Param("instId") int instId);
}
