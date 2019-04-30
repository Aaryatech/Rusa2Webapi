package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.TInstInternetInfo;

public interface TInstInternetInfoRepo extends JpaRepository<TInstInternetInfo, Integer> {

	List<TInstInternetInfo> findByInstIdAndDelStatusOrderByInstInternetInfoIdDesc(int instituteId, int i);

	TInstInternetInfo findByInstInternetInfoId(int connectionId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_internet_info SET del_status = 0 WHERE inst_internet_info_id=:connectionId",nativeQuery=true)
	int delNetConnectionById(@Param("connectionId") int connectionId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_internet_info SET del_status=0  WHERE inst_internet_info_id IN (:lanInfoIdslList)",nativeQuery=true)
	int deleteLanConnectiion(@Param("lanInfoIdslList")List<String> lanInfoIdslList);

}
