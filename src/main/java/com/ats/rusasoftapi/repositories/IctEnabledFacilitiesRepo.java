package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.IctEnabledFacilities;

public interface IctEnabledFacilitiesRepo extends JpaRepository<IctEnabledFacilities, Integer> {

	List<IctEnabledFacilities> findByInstIdAndDelStatusOrderByIctEnbFacIdDesc(@Param("instituteId") int instituteId, @Param("i") int i);

	IctEnabledFacilities findByIctEnbFacId(@Param("ictId") int ictId);


	@Transactional
	@Modifying
	@Query(value = "UPDATE ict_enabled_facilities SET del_status=0 WHERE ict_enb_fac_id = :ictId",nativeQuery=true)
	int deleteIctEnbFacById(@Param("ictId") int ictId);


	@Transactional
	@Modifying
	@Query(value="UPDATE ict_enabled_facilities SET del_status=0  WHERE ict_enb_fac_id IN (:ictIdList) ",nativeQuery=true)
	int deleteSelIctFac(@Param("ictIdList") List<String> ictIdList);
	

}
