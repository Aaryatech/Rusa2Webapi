package com.ats.rusasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.GetProgram;

public interface GetProgramRepository extends JpaRepository<GetProgram, Integer>{

	
	@Query(value="select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and p.institute_id=:instituteId and p.del_status=1 and p.is_active=1", nativeQuery=true)
	List<GetProgram> getProgramList(@Param("instituteId") int instituteId);

	@Query(value="select p.*,pt.program_name from m_program_type pt,t_program p where pt.program_id=p.program_type and "
			+ " p.del_status=1 and p.is_active=1 and p.program_id=:programId", nativeQuery=true)
	GetProgram findByProgramId(@Param("programId") int programId);

}
