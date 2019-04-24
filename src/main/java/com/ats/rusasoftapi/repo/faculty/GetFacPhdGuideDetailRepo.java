package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetFacPhdGuideDetail;

public interface GetFacPhdGuideDetailRepo  extends JpaRepository<GetFacPhdGuideDetail, Integer>{
	
	@Query(value=" SELECT m_faculty.faculty_id,m_faculty.faculty_first_name,m_faculty.phd_recognition_dt,"
			+ " m_faculty.phd_stu_pg+m_faculty.phd_stu_mphill+m_faculty.phd_stu_phd AS "
			+ " no_of_stud, m_faculty.phd_valid_dt, m_faculty.is_ict_used  " + 
			" FROM m_faculty WHERE m_faculty.institute_id=:instId AND m_faculty.del_status=1 AND m_faculty.is_active=1 AND m_faculty.is_phd_guide=1 ORDER BY m_faculty.faculty_id DESC  ", nativeQuery=true)
	
	List<GetFacPhdGuideDetail> getFacPhdGuideDetail(@Param("instId") int instId);

}
