package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramOutcome;

public interface ProgramOutcomeRepository extends JpaRepository<ProgramOutcome, Integer>{

	List<ProgramOutcome> findByDelStatusAndIsActiveAndProgramIdOrderByPoIdDesc(int i, int j, int programId);
			
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program_po SET del_status=0 WHERE po_id IN (:poId) ", nativeQuery = true)
	int deleteProgramOutcome(@Param("poId") int poId);

	ProgramOutcome findByPoId(int poId);

}
