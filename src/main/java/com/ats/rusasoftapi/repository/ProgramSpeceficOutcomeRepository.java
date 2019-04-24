package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramSpeceficOutcome;

public interface ProgramSpeceficOutcomeRepository extends JpaRepository<ProgramSpeceficOutcome, Integer>{

	List<ProgramSpeceficOutcome> findByDelStatusAndIsActiveAndProgramIdOrderByPsoIdDesc(int i, int j, int programId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_pso SET del_status=0 WHERE pso_id IN (:psoId) ", nativeQuery = true)
	int deleteProgramSpeceficOutcome(@Param("psoId") int psoId);

	ProgramSpeceficOutcome findByPsoId(int psoId);

}
