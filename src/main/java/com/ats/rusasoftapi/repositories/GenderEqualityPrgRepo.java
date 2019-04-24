package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.GenderEqalityPrg;
import com.ats.rusasoftapi.model.IntelPrpoRight;

public interface GenderEqualityPrgRepo extends JpaRepository<GenderEqalityPrg, Integer> {

	List<GenderEqalityPrg> findByInstituteIdAndYearIdAndDelStatusOrderByGprogIdDesc(int instituteId, int yId, int del);
	
	GenderEqalityPrg findBygprogId(int gndrDataId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_ivsr_gender_prog SET del_status=0 WHERE gprog_id = :gndrDataId",nativeQuery=true)
	int deleteGendrEqltyById(int gndrDataId);

	@Transactional
	@Modifying
	@Query(value="UPDATE institute_ivsr_gender_prog SET del_status=0  WHERE gprog_id IN (:gndreqtyIdList) ",nativeQuery=true)
	int deleteSelGenderEquitys(List<String> gndreqtyIdList);
	
}
