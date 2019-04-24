package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramVision;

public interface ProgramVisionRepository extends JpaRepository<ProgramVision, Integer>{
 
	List<ProgramVision> findByDelStatusAndIsActiveAndProgramIdOrderByVisionIdDesc(int i, int j, int programId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_vision SET del_status=0 WHERE vision_id IN (:visionId) ", nativeQuery = true)
	int deleteProgramVision(@Param("visionId") int visionId);

	ProgramVision findByVisionId(int visionId);

}
