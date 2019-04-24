package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstitueMission;
import com.ats.rusasoftapi.model.InstitueVision;

public interface InstituteMissionRepository extends JpaRepository<InstitueMission, Integer>{

	List<InstitueMission> findByDelStatusAndIsActiveAndInstituteIdOrderByInstMissionIdDesc(int i, int j, int instituteId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_mission SET del_status=0 WHERE inst_mission_id IN (:instMissionId) ", nativeQuery = true)
	int deleteInstiuteMission(@Param("instMissionId") int instMissionId);

	InstitueMission findByInstMissionId(int instMissionId);

}
