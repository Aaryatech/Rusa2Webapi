package com.ats.rusasoftapi.repo.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.InstInfraAreaInfo;

public interface InstInfraAreaInfoRepo extends JpaRepository<InstInfraAreaInfo, Integer> {

	InstInfraAreaInfo findByDelStatusAndIsActiveAndInstIdAndInfraAreaId(int delStatus, int isActive, int instId,
			int areaId);
	
	
	InstInfraAreaInfo findByDelStatusAndIsActiveAndInstIdAndInstInfraAreaId(int delStatus, int isActive, int instId,
			int instInfraAreaId);

	
}
