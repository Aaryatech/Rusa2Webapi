package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByStudentId(int studId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_student_reg SET del_status=0 WHERE student_id IN (:studIdList) ",nativeQuery=true)
	int deleteStudents(@Param("studIdList") List<String> studIdList);


	
	List<Student> findByContactNoAndDelStatus(String contactNo, int delStatus);


	List<Student> findByContactNoAndDelStatusAndStudentIdNot(String contactNo, int delStatus, int studentId);


	List<Student> findByEmailAndDelStatus(String email, int delStatus);


	List<Student> findByEmailAndDelStatusAndStudentIdNot(String trim, int delStatus, int studentId);



}
