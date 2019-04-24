package com.ats.rusasoftapi.repo.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.infra.InfraAreaType;

public interface InfraAreaTypeRepo extends JpaRepository<InfraAreaType, Integer> {
	
	List<InfraAreaType> findByDelStatus(int delStatus);
	

}
