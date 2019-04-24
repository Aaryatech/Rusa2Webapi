package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.AccOfficer;

public interface AccOfficerRepo extends JpaRepository<AccOfficer, Integer> {

	AccOfficer findByOfficerId(int officerId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_acc_officer_reg SET del_status=0 WHERE officer_id IN (:accOffIds) ", nativeQuery = true)
	int deleteAccOfficers(@Param("accOffIds") List<String> accOffIds);
	
	long countByContactNoAndDelStatusAndIsActive(String contactNo,int delStatus, int isActive);
	
	List<AccOfficer> findByContactNoAndDelStatusAndIsActive(String contactNo,int delStatus, int isActive);
	List<AccOfficer> findByContactNoAndDelStatusAndIsActiveAndOfficerIdNot(String contactNo,int delStatus, int isActive,int officerId);
	
	List<AccOfficer>  findByEmailAndDelStatusAndIsActive(String email,int delStatus, int isActive);
	List<AccOfficer>  findByEmailAndDelStatusAndIsActiveAndOfficerIdNot(String email,int delStatus, int isActive,int officerId);
	
	
}
