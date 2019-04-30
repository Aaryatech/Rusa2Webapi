package com.ats.rusasoftapi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.ItInfrastructure;

public interface ItInfrastructureRepo extends JpaRepository<ItInfrastructure, Integer> {

	List<ItInfrastructure> findByInstIdAndDelStatusOrderByInstItInfraInfoIdDesc(int instituteId, int i);
	
	ItInfrastructure findByInstItInfraInfoId(int i);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_it_infra_info SET del_status = 0 WHERE inst_it_Infra_info_id =:id",nativeQuery=true)
	int delItInfraStructrById(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_inst_it_infra_info SET del_status=0  WHERE inst_it_Infra_info_id IN (:infraIdList)",nativeQuery=true)
	int deleteItInfraInfo(@Param("infraIdList") List<String> infraIdList);
	

}
