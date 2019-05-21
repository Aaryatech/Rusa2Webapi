package com.ats.rusasoftapi.repository;

import java.util.List;


//import org.junit.runners.Parameterized.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetProgram;

public interface GetProgramRepository extends JpaRepository<GetProgram, Integer> {

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and p.institute_id=:instituteId and p.del_status=1 and p.is_active=1"
			+ " ORDER BY p.program_id DESC ", nativeQuery = true)
	List<GetProgram> getProgramList(@Param("instituteId") int instituteId);

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and "
			+ " p.del_status=1 and p.is_active=1 and p.program_id=:programId", nativeQuery = true)
	GetProgram findByProgramId(@Param("programId") int programId);

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and p.del_status=1 and p.is_active=1 AND p.institute_id=:instId ORDER BY p.program_id DESC", nativeQuery = true)
	List<GetProgram> getAllProgramList(@Param("instId") int instId);
	
	
	
	@Query(value="SELECT t_program.*, pt.program_name as program_name  FROM t_program, m_program_type pt  WHERE t_program.program_id=:programId and t_program.program_type=pt.program_id and t_program.del_status=1 and t_program.is_active=1", nativeQuery=true)
	
	GetProgram getProgramDetail(@Param("programId") int programId);
// SELECT t_program.*,0 as program_name  FROM t_program   WHERE t_program.program_id=:programId and t_program.del_status=1 and t_program.is_active=1 
}
