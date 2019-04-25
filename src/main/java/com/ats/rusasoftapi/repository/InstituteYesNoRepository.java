package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstituteYesNo;

public interface InstituteYesNoRepository extends JpaRepository<InstituteYesNo, Integer>{

	List<InstituteYesNo> findByInstituteIdAndDelStatusAndIsActiveAndYearId(int instituteId, int i, int j, int yearId);

	List<InstituteYesNo> findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndYesnoPagecode(int instituteId, int i,
			int j, int yearId, String pageCode);

	List<InstituteYesNo> findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndSectionCodeOrderByInstYesnoIdDesc(int instituteId, int i, int j,
			int yearId, String secCode);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_yesno SET del_status=0 WHERE inst_yesno_id IN (:id) ", nativeQuery = true)
	int deleteYesNoRecord(@Param("id") int id);

	InstituteYesNo findByInstituteIdAndDelStatusAndIsActiveAndYearIdAndInstYesnoId(int instituteId, int i,
			int j, int yearId, int id);
	
}