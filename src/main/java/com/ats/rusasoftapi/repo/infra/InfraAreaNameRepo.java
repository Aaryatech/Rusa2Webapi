package com.ats.rusasoftapi.repo.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.infra.InfraAreaName;

public interface InfraAreaNameRepo extends JpaRepository<InfraAreaName, Integer> {
	
	List<InfraAreaName> findByDelStatusAndIsActiveAndInfraAreaTypeId(int delStatus, int isActive,int typeId);
	
	InfraAreaName findByDelStatusAndIsActiveAndInfraAreaId(int delStatus, int isActive,int areaId);
	
	
}
