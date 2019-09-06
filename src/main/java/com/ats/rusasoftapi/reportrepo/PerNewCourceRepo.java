package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.PerNewCource;

public interface PerNewCourceRepo extends JpaRepository<PerNewCource, Integer> {
	
	@Query(value="SELECT UUID() as id1, COUNT(*) as no_courses_in_last5, m_institute.institute_name,  m_academic_year.academic_year " + 
			"FROM new_course_info,m_institute,m_academic_year " + 
			"WHERE new_course_info.inst_id=m_institute.institute_id AND new_course_info.del_status=1 and new_course_info.is_active=1 " + 
			"AND new_course_info.introduce_from=m_academic_year.year_id " + 
			"AND m_institute.institute_id=:instId AND m_academic_year.year_id in(:lastFiveYears) " + 
			"UNION all  SELECT UUID() as id2, COUNT(*) as no_courses_in_last5, m_institute.institute_name,  m_academic_year.academic_year "+
			"FROM new_course_info,m_institute,m_academic_year " + 
			"WHERE new_course_info.inst_id=m_institute.institute_id AND new_course_info.del_status=1 and new_course_info.is_active=1 " + 
			"AND new_course_info.introduce_from=m_academic_year.year_id " + 
			"AND m_institute.institute_id=:instId",nativeQuery=true)
	List<PerNewCource> getAllPerNewCource(@Param("instId")int instId, @Param("lastFiveYears")List<Integer> lastFiveYears);

}
