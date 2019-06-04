package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.IntelPrpoRight;

public interface IntelPropRightRepo extends JpaRepository<IntelPrpoRight, Integer> {

	List<IntelPrpoRight> findByInstituteIdAndYearIdAndDelStatusOrderByConIdDesc(int instituteId, int yId, int del);

	IntelPrpoRight findByConId(int conId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_ivsr_contribution SET del_status=0 WHERE con_id = :conId",nativeQuery=true)
	int deleteIntelRightById(@Param("conId") int conId);

	@Transactional
	@Modifying
	@Query(value="UPDATE institute_ivsr_contribution SET del_status=0  WHERE con_id IN (:rightIdList) ",nativeQuery=true)
	int deleteSelIntellRight(@Param("rightIdList")List<String> rightIdList);
	
	
}
