package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

	Staff findByFacultyIdAndDelStatusAndIsBlocked(@Param("id") int id, @Param("i") int i,@Param("j") int j);

	Staff findByFacultyIdAndDelStatusAndIsPrincipalAndIsActive(@Param("facultyId") int facultyId, @Param("i") int i,
			@Param("j") int j, @Param("k") int k);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET del_status=0 WHERE faculty_id=:id", nativeQuery = true)
	int deleteByFacultyId(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET is_blocked=1 WHERE faculty_id=:userId", nativeQuery = true)
	int blockUser(@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET password=:password ,is_enrolled=1   WHERE faculty_id=:userId ", nativeQuery = true)
	int chagePass(@Param("password") String password, @Param("userId") int userId);

	List<Staff> findByContactNoAndDelStatus(String contactNo, int i);

	List<Staff> findByContactNoAndDelStatusAndFacultyIdNot(String contactNo, int i, int facultyId);

	List<Staff> findByEmailAndDelStatus(String email, int i);

	List<Staff> findByEmailAndDelStatusAndFacultyIdNot(String email, int i, int facultyId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET del_status=0  WHERE faculty_id IN (:staffIdList) ", nativeQuery = true)
	int deleteStaffs(@Param("staffIdList") List<String> staffIdList);

	Staff findByDelStatusAndIsActiveAndEmailAndPasswordContainingAndIsBlocked(int delStatus, int isActive, String email,
			String password,int isBlocked);

	Staff findByDelStatusAndIsActiveAndEmailAndIsBlocked(int delStatus, int isActive, String email,int blocked);

	Staff findByDelStatusAndIsActiveAndIsBlockedAndInstituteIdAndEmailIgnoreCase(int delStatus, int isActive,
			int isBlocked, int instId, String email);

	Staff findByDelStatusAndIsActiveAndIsBlockedAndInstituteIdAndContactNo(int delStatus, int isActive, int isBlocked,
			int instId, String contactNo);
	Staff findByDelStatusAndIsActiveAndIsBlockedAndInstituteId(int delStatus, int isActive,int isBlocked,int instId);

	Staff findByDelStatusAndIsActiveAndContactNo(int delStatus, int isActive, String contact);
	
	Staff findByDelStatusAndIsActiveAndContactNoAndFacultyId(int delStatus, int isActive, String contact,int facultyId);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET contact_no=:no  WHERE faculty_id =:id", nativeQuery = true)
	int updateNewNo(@Param("id") int id,@Param("no") String no);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_faculty SET email=:email WHERE faculty_id =:id", nativeQuery = true)
	int updateNewEmail(@Param("id") int id,@Param("email") String email);
	
	
	List<Staff> findByContactNoAndDelStatusAndIsBlocked(String inputValue, int del, int isBlocked);
	
	List<Staff> findByEmailAndDelStatusAndIsBlocked(String inputValue, int del, int isBlocked);

	Staff findByDelStatusAndIsActiveAndEmail(int i, int j, String emailId);
}
