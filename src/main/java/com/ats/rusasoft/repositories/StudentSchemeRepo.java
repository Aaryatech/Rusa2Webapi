package com.ats.rusasoft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.Dean;
import com.ats.rusasoft.model.StudentSchemeList;

public interface StudentSchemeRepo extends JpaRepository<StudentSchemeList, Integer> {

	@Modifying
	@Query(value="SELECT s.sprt_schm_id, s.scheme_name, s.level, s.type, s.no_student_benifited,s.support_agency_name, m.academic_year FROM t_support_scheme_detail s, m_academic_year m WHERE s.del_status=1 AND s.is_active=1 AND s.year_id=m.year_id ORDER BY sprt_schm_id DESC",nativeQuery=true)
	public List<StudentSchemeList> getStudentSchemeList();

	
}
