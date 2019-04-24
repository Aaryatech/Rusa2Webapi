package com.ats.rusasoftapi.repo.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.GetInstInfraAreaInfo;

public interface GetInstInfraAreaInfoRepo extends JpaRepository<GetInstInfraAreaInfo, Integer>{
	
	
	@Query(value = " SELECT t_inst_infra_area_info.inst_infra_area_id,"
			+ " t_inst_infra_area_info.inst_id,  t_inst_infra_area_info.infra_area_type_id,"
			+ " t_inst_infra_area_info.infra_area_id,  t_inst_infra_area_info.area_loc,"
			+ " t_inst_infra_area_info.area_sq_mtr,  t_inst_infra_area_info.maker_user_id,"
			+ " m_infra_area_type.area_type_name,  CASE WHEN t_inst_infra_area_info.infra_area_id=0 THEN (SELECT "
			+ " t_inst.area_name   from  t_inst_infra_area_info t_inst   WHERE"
			+ " t_inst_infra_area_info.inst_infra_area_id=t_inst.inst_infra_area_id) "
			+ "  ELSE (SELECT  m_infra_area_name.infra_area_name from   m_infra_area_name "
			+ " WHERE t_inst_infra_area_info.infra_area_id=m_infra_area_name.infra_area_id) "
			+ " END as area_name  FROM t_inst_infra_area_info ,m_infra_area_type "
			+ " WHERE t_inst_infra_area_info.inst_id=:instId AND t_inst_infra_area_info.del_status=1 "
			+ " AND t_inst_infra_area_info.is_active=1 "
			+ " AND m_infra_area_type.infra_area_type_id=t_inst_infra_area_info.infra_area_type_id ORDER BY t_inst_infra_area_info.inst_infra_area_id DESC ", nativeQuery = true)

	List<GetInstInfraAreaInfo> getInstInfraAreaInfoByInstId(@Param("instId") int instId);

	

}
