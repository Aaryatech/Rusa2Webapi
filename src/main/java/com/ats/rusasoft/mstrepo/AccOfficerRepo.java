package com.ats.rusasoft.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.AccOfficer;

public interface AccOfficerRepo extends JpaRepository<AccOfficer, Integer> {

	AccOfficer findByOfficerId(int officerId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_acc_officer_reg SET del_status=0 WHERE officer_id IN (:accOffIds) ", nativeQuery = true)
	int deleteAccOfficers(@Param("accOffIds") List<String> accOffIds);
	
}
