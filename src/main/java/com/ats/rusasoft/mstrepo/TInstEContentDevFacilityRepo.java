package com.ats.rusasoft.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.EContentDevFacility;

public interface TInstEContentDevFacilityRepo extends JpaRepository<EContentDevFacility, Integer> {
	
	List<EContentDevFacility> findByDelStatusAndInstId(@Param("i") int i,@Param("instituteId") int instituteId);
	
	EContentDevFacility findByInstEContentDevFacilityIdAndDelStatus(@Param("contentId") int contentId,@Param("i") int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE e_content_dev_facility SET del_status=0 WHERE inst_e_content_dev_facility_id=:contentId",nativeQuery=true)
	int deleteContentById(@Param("contentId") int contentId);

	@Transactional
	@Modifying
	@Query(value="UPDATE e_content_dev_facility SET del_status=0  WHERE inst_e_content_dev_facility_id IN (:contentIdsList)",nativeQuery=true)
	int deleteEContents(List<String> contentIdsList); 
}
