package com.ats.rusasoft.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Institute;

public interface InstituteRepo extends JpaRepository<Institute, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_institute SET del_status=0 WHERE institute_id IN (:instIdList) ",nativeQuery=true)
	int deleteInstitutes(@Param("instIdList") List<String> instIdList);
	
	Institute findByInstituteId(int instituteId);
	
	
	List<Institute> findByContactNoAndEmail(String contactNo,String email );
	
	List<Institute> findByContactNoAndEmailAndInstituteIdNot(String contactNo,String email,int instId );
	
}
