package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GovtScholarships;

public interface GovtScholarshipsRepo extends JpaRepository<GovtScholarships, Integer> {

	List<GovtScholarships> findByInstIdAndAcYearIdAndDelStatusOrderByGovtScholarIdDesc(int instituteId, int yId, int del);

	GovtScholarships findByGovtScholarId(int schmId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE govt_scholarships SET del_status=0 WHERE govt_scholar_id = :schmId",nativeQuery=true)
	int deleteGovtSchem(@Param("schmId") int schmId);

	

	@Transactional
	@Modifying
	@Query(value="UPDATE govt_scholarships SET del_status=0  WHERE govt_scholar_id IN (:schmIdList) ",nativeQuery=true)
	int deleteGovtSchm(@Param("schmIdList") List<String> schmIdList);

}
