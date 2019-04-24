package com.ats.rusasoftapi.repo.faculty;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetFacPerDetail;

public interface GetFacPerDetailRepo extends JpaRepository<GetFacPerDetail, Integer> {
	@Query(value="SELECT m_faculty.faculty_id,m_faculty.faculty_first_name AS faculty_name,m_faculty.contact_no,m_faculty.email,m_designation.designation_name,TIMESTAMPDIFF(Month,m_faculty.joining_date,:curDate) as current_experience " + 
			"	 ,m_faculty.f_past_exp " + 
			" FROM m_designation,m_faculty WHERE m_faculty.f_aadhar!='NULL' AND m_designation.designation_id=m_faculty.current_designation_id\n" + 
			" AND m_faculty.institute_id=:instId AND m_faculty.del_status=1 AND m_faculty.is_active=1 ORDER BY m_faculty.faculty_id DESC"
			+ "  ", nativeQuery=true)
	List<GetFacPerDetail> getGetFacPerDetail(@Param("instId") int instId, @Param("curDate") Date curDate);

}
