package com.ats.rusasoftapi.mstrepo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetStudentDetail;



public interface GetStudentDetailRepo extends JpaRepository<GetStudentDetail, Integer> {
	
	
	@Query(value="SELECT m_student_reg.institute_id ,m_student_reg.student_id,m_student_reg.dept_id,m_student_reg.student_name, m_student_reg.id_no,m_student_reg.contact_no,m_student_reg.email, m_dept.dept_name ,  m_student_reg.acadamic_year as academic_year  from m_student_reg,m_dept where m_student_reg.del_status=1 AND   m_dept.dept_id=m_student_reg.dept_id and   m_student_reg.institute_id =:instituteId ORDER BY m_student_reg.student_id DESC",nativeQuery=true)
	List<GetStudentDetail> getAllStudentList1(@Param("instituteId") int instituteId);
	
/*
  SELECT m_student_reg.institute_id ,m_student_reg.student_id,m_student_reg.dept_id,m_student_reg.student_name, "
			+ " m_student_reg.id_no,m_student_reg.contact_no,m_student_reg.email,m_institute.institute_name,m_dept.dept_name , "
			+ " m_academic_year.academic_year " + 
			" from m_student_reg,m_institute,m_dept,m_academic_year where m_student_reg.del_status=1 AND " + 
			" m_student_reg.institute_id=m_institute.institute_id AND m_dept.dept_id=m_student_reg.dept_id and "
			+ " m_student_reg.acadamic_year=m_academic_year.year_id AND m_student_reg.institute_id =:instituteId "
			+ "ORDER BY m_student_reg.student_id DESC
*/
}
