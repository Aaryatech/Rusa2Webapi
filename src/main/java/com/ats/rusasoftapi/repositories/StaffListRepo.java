package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StaffList;


public interface StaffListRepo extends JpaRepository<StaffList, Integer> {
	
	/*@Modifying
	@Query(value="SELECT f.faculty_id, f.faculty_first_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.realiving_date ,f.contact_no, f.email, q.qualification_name, dept.dept_name ,d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q, m_dept dept WHERE f.del_status=1 AND f.is_active=1 AND f.current_designation_id=d.designation_id AND f.highest_qualification=q.qualification_id AND dept.dept_id=f.dept_id AND f.institute_id=:facId ORDER BY faculty_id DESC",nativeQuery=true)
	List<StaffList> findByIsActiveAndDelStatus(@Param("facId") int facId);*/

	@Query(value="SELECT f.faculty_id, f.faculty_first_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.realiving_date ,f.contact_no, f.email, q.qualification_name, dept.dept_name ,d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q, m_dept dept WHERE f.del_status=1 AND f.is_active=1 AND f.current_designation_id=d.designation_id AND f.highest_qualification=q.qualification_id AND dept.dept_id=f.dept_id AND f.institute_id=:instituteId AND f.is_faculty=1 AND f.is_blocked=0 ORDER BY faculty_id DESC",nativeQuery=true)
	List<StaffList> getFacultyListYear(@Param("instituteId")int instituteId);

	@Query(value="SELECT f.faculty_id, f.faculty_first_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.realiving_date ,f.contact_no, f.email, q.qualification_name, dept.dept_name ,d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q, m_dept dept WHERE f.del_status=1 AND f.is_active=1 AND f.current_designation_id=d.designation_id AND f.highest_qualification=q.qualification_id AND dept.dept_id=f.dept_id AND dept.dept_id IN(:deptIdList)AND f.institute_id=:instituteId AND f.is_faculty=1 AND f.is_blocked=0 ORDER BY faculty_id DESC",nativeQuery=true)
	List<StaffList> getFacultyListByDept(@Param("deptIdList")List<Integer> deptIdList,@Param("instituteId") int instituteId);

	
	@Query(value="SELECT f.faculty_id, f.faculty_first_name, f.current_designation_id,f.highest_qualification, f.joining_date, f.realiving_date ,f.contact_no, f.email, q.qualification_name, dept.dept_name ,d.designation_name FROM m_faculty f, m_designation d, m_qualificatoin q, m_dept dept WHERE f.del_status=1 AND f.is_active=1 AND f.current_designation_id=d.designation_id AND f.highest_qualification=q.qualification_id AND dept.dept_id=f.dept_id AND f.institute_id=:instituteId AND f.is_faculty=1 AND f.faculty_id=:facultyId AND f.is_blocked=0 ORDER BY faculty_id DESC",nativeQuery=true)
	List<StaffList> getFacultyListById(@Param("facultyId") int facultyId, @Param("instituteId") int instituteId);
}
