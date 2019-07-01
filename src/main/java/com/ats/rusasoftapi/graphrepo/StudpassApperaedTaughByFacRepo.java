package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.GetTotStudentPassedAndAppearInFinYr;
import com.ats.rusasoftapi.graph.model.StudpassApperaedTaughByFac;

public interface StudpassApperaedTaughByFacRepo extends JpaRepository<StudpassApperaedTaughByFac, Integer>{

	
	@Query(value="SELECT\n" + 
			"    t_faculty_subject.sub_id,\n" + 
			"    t_faculty_subject.sub_name,\n" + 
			"    t_faculty_subject.sub_stu_appear,\n" + 
			"    t_faculty_subject.sub_stu_passed\n" + 
			"FROM\n" + 
			"    t_faculty_subject,\n" + 
			"    m_faculty\n" + 
			"WHERE\n" + 
			"    m_faculty.institute_id =:instId AND t_faculty_subject.del_status = 1 AND t_faculty_subject.is_active = 1 AND t_faculty_subject.year_id =(\n" + 
			"    SELECT\n" + 
			"        m_academic_year.year_id\n" + 
			"    FROM\n" + 
			"        m_academic_year\n" + 
			"    WHERE\n" + 
			"        m_academic_year.is_current = 1\n" + 
			") AND t_faculty_subject.faculty_id =:facultyId AND t_faculty_subject.faculty_id = m_faculty.faculty_id ",nativeQuery=true)
	List<StudpassApperaedTaughByFac> getStudpassApperaedTaughByFacDet(@Param("instId")int instId,@Param("facultyId")int facultyId);
	
}
