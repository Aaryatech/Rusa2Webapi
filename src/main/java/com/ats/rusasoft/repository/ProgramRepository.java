package com.ats.rusasoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{
 
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program SET del_status=0 WHERE program_id IN (:programId) ", nativeQuery = true)
	int deleteProgram(@Param("programId") int programId);

	Program findByProgramId(int programId);

	List<Program> findByDelStatusAndIsActiveAndInstituteIdOrderByProgramIdDesc(int i, int j, int instituteId);

}
