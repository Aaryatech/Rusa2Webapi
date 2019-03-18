package com.ats.rusasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.GetProgram;

public interface GetProgramRepository extends JpaRepository<GetProgram, Integer> {

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and p.institute_id=:instituteId and p.del_status=1 and p.is_active=1", nativeQuery = true)
	List<GetProgram> getProgramList(@Param("instituteId") int instituteId);

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and "
			+ " p.del_status=1 and p.is_active=1 and p.program_id=:programId", nativeQuery = true)
	GetProgram findByProgramId(@Param("programId") int programId);

	@Query(value = "select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and p.del_status=1 and p.is_active=1", nativeQuery = true)
	List<GetProgram> getAllProgramList();
	
	
	
	@Query(value=" SELECT t_program.*,0 as program_name  FROM t_program   WHERE t_program.program_id=:programId and t_program.del_status=1 and t_program.is_active=1 ", nativeQuery=true)
	
	GetProgram getProgramDetail(@Param("programId") int programId);

}
