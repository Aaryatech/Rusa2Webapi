package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

	Staff findByFacultyIdAndDelStatus(@Param("id") int id,@Param("i") int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_faculty SET del_status=0 WHERE faculty_id=:id",nativeQuery=true)
	int deleteByFacultyId(@Param("id") int id);

	List<Staff> findByContactNoAndDelStatus(String contactNo, int i);

	List<Staff> findByContactNoAndDelStatusAndFacultyIdNot(String contactNo, int i, int facultyId);

	List<Staff> findByEmailAndDelStatus(String email, int i);

	List<Staff> findByEmailAndDelStatusAndFacultyIdNot(String email, int i, int facultyId);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_faculty SET del_status=0  WHERE faculty_id IN (:staffIdList) ",nativeQuery=true)
	int deleteStaffs(@Param("staffIdList")List<String> staffIdList);
	
	Staff findByDelStatusAndIsActiveAndEmailAndPassword(int delStatus,int isActive,String email,String password);

	
	

	
}
