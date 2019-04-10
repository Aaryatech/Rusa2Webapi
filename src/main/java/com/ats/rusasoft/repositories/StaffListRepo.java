package com.ats.rusasoft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.StaffList;

public interface StaffListRepo extends JpaRepository<StaffList, Integer> {
	
	@Modifying
	@Query(value="SELECT f.faculty_id, f.faculty_first_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.realiving_date ,f.contact_no, f.email, q.qualification_name, dept.dept_name ,d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q, m_dept dept WHERE f.del_status=1 AND f.is_active=1 AND f.current_designation_id=d.designation_id AND f.highest_qualification=q.qualification_id AND dept.dept_id=f.dept_id AND f.institute_id=:facId ORDER BY faculty_id DESC",nativeQuery=true)
	List<StaffList> findByIsActiveAndDelStatus(@Param("facId") int facId);
}
//SELECT f.faculty_id, f.faculty_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.contact_no, f.email, q.qualification_name, d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q WHERE f.del_status=1 AND f.current_designation_id=d.designation_id AND "
	//	+ "f.highest_qualification=q.qualification_id  ORDER BY faculty_id DESC