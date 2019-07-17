package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Institute;

public interface InstituteRepo extends JpaRepository<Institute, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_institute SET del_status=0 WHERE institute_id IN (:instIdList) ",nativeQuery=true)
	int deleteInstitutes(@Param("instIdList") List<String> instIdList);
	
	Institute findByInstituteId(int instituteId);
	
	
	List<Institute> findByContactNoAndDelStatusAndIsActive(String contactNo,int delStatus,int isActive);//call when it is insert call
	List<Institute> findByContactNoAndDelStatusAndIsActiveAndInstituteIdNot(String contactNo,int delStatus,int isActive,int instId);//call when it is edit call
	
	List<Institute> findByEmailAndDelStatusAndIsActive(String email,int delStatus,int isActive);//call when it is insert call
	List<Institute> findByEmailAndDelStatusAndIsActiveAndAndInstituteIdNot(String email,int delStatus, int isActive,int instId);//call when it is edit call
	
	List<Institute> findByContactNoAndEmailAndInstituteIdNot(String contactNo,String email,int instId );
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_institute SET del_status=0 WHERE institute_id=:instId",nativeQuery=true)
	int delPendingInst(int instId);
	
	Institute findByAisheCodeAndDelStatus(String aisheCode,int delStatus);

	Institute findByAisheCode(String aisheCode);

	Institute findByAisheCodeAndDelStatusAndIsActiveAndExInt2(String aisheCode, int i, int j, int k);

 	
	
}
