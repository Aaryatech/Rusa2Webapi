package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.NewDeanList;


public interface NewDeanListRepo extends JpaRepository<NewDeanList, Integer> {
	@Query(value="SELECT f.faculty_id,f.faculty_first_name,f.dept_id,f.highest_qualification,f.teaching_to,"
			+ "f.current_designation_id,f.joining_date,f.realiving_date,f.contact_no,f.email,f.maker_user_id,"
			+ "d.dept_name,q.qualification_name,des.designation_name FROM m_faculty f, m_designation des,m_qualificatoin q ,m_dept d "
			+ "WHERE f.dept_id=d.dept_id AND des.designation_id=f.current_designation_id AND "
			+ "q.qualification_id=f.highest_qualification AND f.del_status=1 AND f.is_active=1 "
			+ "AND f.institute_id=:instituteId AND f.is_dean=1 AND f.is_blocked=0 ORDER BY f.faculty_id DESC",nativeQuery=true)
	List<NewDeanList> getDeanByInst(@Param("instituteId") int instituteId);

	@Query(value="SELECT f.faculty_id,f.faculty_first_name,f.dept_id,f.highest_qualification,f.teaching_to,"
			+ "f.current_designation_id,f.joining_date,f.realiving_date,f.contact_no,f.email,f.maker_user_id,"
			+ "d.dept_name,q.qualification_name,des.designation_name FROM m_faculty f, m_designation des,m_qualificatoin q ,m_dept d "
			+ "WHERE f.dept_id=d.dept_id AND des.designation_id=f.current_designation_id AND "
			+ "q.qualification_id=f.highest_qualification AND f.del_status=1 AND f.is_active=1  "
			+ "AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId AND f.is_dean=1 AND f.is_blocked=0 ORDER BY f.faculty_id DESC",nativeQuery=true)
	List<NewDeanList> getDeanByDept(@Param("deptIdList")List<Integer> deptIdList, @Param("instituteId") int instituteId);

			@Query(value="SELECT f.faculty_id,f.faculty_first_name,f.dept_id,f.highest_qualification,f.teaching_to,"
				+ "f.current_designation_id,f.joining_date,f.realiving_date,f.contact_no,f.email,f.maker_user_id,"
				+ "d.dept_name,q.qualification_name,des.designation_name FROM m_faculty f, m_designation des,m_qualificatoin q ,m_dept d "
				+ "WHERE f.dept_id=d.dept_id AND des.designation_id=f.current_designation_id AND "
				+ "q.qualification_id=f.highest_qualification AND f.institute_id=:instituteId AND f.del_status=1 AND f.is_active=1  "
				+ "AND f.institute_id=:instituteId AND m_faculty.faculty_id=:facultyId AND f.is_dean=1 AND f.is_blocked=0 ORDER BY f.faculty_id DESC",nativeQuery=true)
	List<NewDeanList> getDeanRepo(@Param("facultyId")int facultyId,  @Param("instituteId") int instituteId);

}
