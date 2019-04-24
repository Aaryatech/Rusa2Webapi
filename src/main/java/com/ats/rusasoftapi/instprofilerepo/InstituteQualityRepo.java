package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteQuality;

public interface InstituteQualityRepo extends JpaRepository<InstituteQuality, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_quality SET del_status=0 WHERE quality_id IN (:qualityIdList) ", nativeQuery = true)
	int deleteInstQualities(@Param("qualityIdList") List<String> qualityIdList);

}
