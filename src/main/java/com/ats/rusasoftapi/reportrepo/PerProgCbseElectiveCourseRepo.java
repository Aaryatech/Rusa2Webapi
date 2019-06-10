package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.PerProgCbseElectiveCourse;

public interface PerProgCbseElectiveCourseRepo extends JpaRepository<PerProgCbseElectiveCourse, Integer> {

	@Query(value="SELECT UUID() uid, COUNT(*) as count1, m_institute.institute_name  " + 
			"FROM t_faculty_subject ,m_faculty,m_institute " + 
			"WHERE t_faculty_subject.faculty_id=m_faculty.faculty_id AND m_faculty.institute_id=m_institute.institute_id " + 
			"AND t_faculty_subject.del_status=1 AND t_faculty_subject.is_active=1 " + 
			"AND (t_faculty_subject.sub_type=1 OR t_faculty_subject.sub_is_cbse=1) " + 
			"UNION ALL SELECT UUID() uid, COUNT(*) as count1, m_institute.institute_name " + 
			"FROM t_program,m_institute " + 
			"WHERE t_program.institute_id=m_institute.institute_id AND t_program.del_status=1 AND t_program.is_active=1 AND m_institute.institute_id=:instId",nativeQuery=true)
	List<PerProgCbseElectiveCourse> getAllPerProgCbseElectiveCourse(@Param("instId")int instId);
}
