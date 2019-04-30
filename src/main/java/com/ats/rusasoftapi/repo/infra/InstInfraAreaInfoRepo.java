package com.ats.rusasoftapi.repo.infra;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.InstInfraAreaInfo;

public interface InstInfraAreaInfoRepo extends JpaRepository<InstInfraAreaInfo, Integer> {

	InstInfraAreaInfo findByDelStatusAndIsActiveAndInstIdAndInfraAreaId(int delStatus, int isActive, int instId,
			int areaId);
	
	
	InstInfraAreaInfo findByDelStatusAndIsActiveAndInstIdAndInstInfraAreaId(int delStatus, int isActive, int instId,
			int instInfraAreaId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_inst_infra_area_info SET del_status=0 WHERE inst_infra_area_id IN (:instInfraAreaIdList) ", nativeQuery = true)
	int deleteInstInfraArea(@Param("instInfraAreaIdList") List<String> instInfraAreaIdList);
	
	
	
}
