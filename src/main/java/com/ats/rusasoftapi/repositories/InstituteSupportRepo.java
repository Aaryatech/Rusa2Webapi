package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstituteSupport;

public interface InstituteSupportRepo extends JpaRepository<InstituteSupport, Integer> {
	
	List<InstituteSupport> findByInstituteIdAndYearIdAndDelStatusOrderByInstSchemeIdDesc(int instituteId, int yId, int del);

	InstituteSupport findByInstSchemeId(int schmId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_schemes SET del_status=0 WHERE inst_scheme_id = :schmId",nativeQuery=true)
	int deleteByInstSuprtSchmId(@Param("schmId") int schmId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_institute_schemes SET del_status=0  WHERE inst_scheme_id IN (:instIdList) ",nativeQuery=true)
	int deleteSelInstSupport(@Param("instIdList")List<String> instIdList);
	
}


