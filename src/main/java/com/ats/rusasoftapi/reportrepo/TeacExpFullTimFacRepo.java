package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.TeacExpFullTimFac;

public interface TeacExpFullTimFacRepo extends JpaRepository<TeacExpFullTimFac, Integer> {

	@Query(value="SELECT" + 
			"    m_faculty.faculty_id," + 
			"    m_faculty.faculty_first_name," + 
			"    m_faculty.f_pan," + 
			"    m_designation.designation_name," + 
			"    m_dept.dept_name," + 
			"   " + 
			"    m_institute.institute_name," + 
			"    ROUND((m_faculty.f_past_exp / 12)," + 
			"    1)+ ROUND(" + 
			"      (" + 
			"          DATEDIFF(" + 
			"          CURDATE(), m_faculty.joining_date) / 365" + 
			"       )," + 
			"          1" + 
			"        ) AS cur_exp" + 
			"    FROM" + 
			"        m_faculty," + 
			"        m_institute," + 
			"        m_designation," + 
			"        m_dept" + 
			"    WHERE" + 
			"        m_faculty.institute_id = m_institute.institute_id AND m_faculty.current_designation_id = m_designation.designation_id AND "
			+ "m_dept.dept_id = m_faculty.dept_id AND m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.institute_id = :instId",nativeQuery=true)
	List<TeacExpFullTimFac> getAllTeachingExpOfFillTimFac(@Param("instId")int instId);

}
