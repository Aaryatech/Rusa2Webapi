package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.HigherEducDetail;

public interface HigherEducDetailRepo extends JpaRepository<HigherEducDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_higher_education_detail SET del_status=0 WHERE education_detail_id  IN (:educationDetailIds)",nativeQuery=true)
	
	int deleteAlumniIds(@Param("educationDetailIds") List<String> educationDetailIds);

	HigherEducDetail findByEducationDetailId(int eduDetailId);

	HigherEducDetail findByInstituteIdAndYearIdAndDelStatus(int instId, int yearId, int del);
}
