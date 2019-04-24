package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramMission;

public interface ProgramMissionRepository extends JpaRepository<ProgramMission, Integer>{

	List<ProgramMission> findByDelStatusAndIsActiveAndProgramIdOrderByMissionIdDesc(int i, int j, int programId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_mission SET del_status=0 WHERE mission_id IN (:missionId) ", nativeQuery = true)
	int deleteProgramMission(@Param("missionId") int missionId);

	ProgramMission findByMissionId(int missionId);

}
