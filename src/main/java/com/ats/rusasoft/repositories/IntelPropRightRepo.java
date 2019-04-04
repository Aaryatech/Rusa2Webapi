package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.IntelPrpoRight;

public interface IntelPropRightRepo extends JpaRepository<IntelPrpoRight, Integer> {

	List<IntelPrpoRight> findByInstituteIdAndYearIdAndDelStatusOrderByConIdDesc(int instituteId, int yId, int del);

	IntelPrpoRight findByConId(int conId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_ivsr_contribution SET del_status=0 WHERE con_id = :conId",nativeQuery=true)
	int deleteIntelRightById(int conId);

	@Transactional
	@Modifying
	@Query(value="UPDATE institute_ivsr_contribution SET del_status=0  WHERE con_id IN (:rightIdList) ",nativeQuery=true)
	int deleteSelIntellRight(List<String> rightIdList);
	
	
}
