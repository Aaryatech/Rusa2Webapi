package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.TeacherStudUsingLib;

public interface TeacherStudUsingLibRepo extends JpaRepository<TeacherStudUsingLib, Integer>{

	
	@Query(value="SELECT\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_info_detail.no_of_fulltime_faculty\n" + 
			"        FROM\n" + 
			"            t_institute_info_detail\n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.year_id = m_academic_year.year_id AND t_institute_info_detail.institute_id = m_institute.institute_id AND t_institute_info_detail.del_status = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS no_of_full_time_faculty  ,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_info_detail.no_current_admited_stnt\n" + 
			"        FROM\n" + 
			"            t_institute_info_detail\n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.year_id = m_academic_year.year_id AND t_institute_info_detail.institute_id = m_institute.institute_id AND t_institute_info_detail.del_status = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS no_of_current_admited_stnt,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            m_library_info.avg_teacher\n" + 
			"        FROM\n" + 
			"            m_library_info\n" + 
			"        WHERE\n" + 
			"            m_institute.institute_id = m_library_info.institute_id AND m_library_info.del_status = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS avg_teacher,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            m_library_info.avg_student\n" + 
			"        FROM\n" + 
			"            m_library_info\n" + 
			"        WHERE\n" + 
			"            m_institute.institute_id = m_library_info.institute_id AND m_library_info.del_status = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS avg_student,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_academic_year.year_id,m_academic_year.academic_year \n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id =:instId  AND m_academic_year.year_id IN (:acYearList)",nativeQuery=true)
	List<TeacherStudUsingLib> getTechStudUsingLib(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}
