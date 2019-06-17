package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramEducationObjective;

public interface ProgramEducationObjectiveRepository extends JpaRepository<ProgramEducationObjective, Integer>{

	List<ProgramEducationObjective> findByDelStatusAndIsActiveAndProgramIdOrderByPeoIdDesc(int i, int j, int programId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_peo SET del_status=0 WHERE peo_id IN (:peoId) ", nativeQuery = true)
	int deleteProgramEducationObjective(@Param("peoId")int peoId);

	ProgramEducationObjective findByPeoId(int peoId);

}
