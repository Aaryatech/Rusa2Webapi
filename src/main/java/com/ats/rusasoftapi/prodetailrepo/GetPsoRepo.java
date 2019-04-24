package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramSpeceficOutcome;

public interface GetPsoRepo extends JpaRepository<ProgramSpeceficOutcome, Integer>{
	
@Query(value=" SELECT * FROM t_program_pso WHERE t_program_pso.program_id=:programId and t_program_pso.del_status=1 "
		+ "and t_program_pso.is_active=1 ORDER BY pso_id DESC ",nativeQuery=true)
	
	List<ProgramSpeceficOutcome> getProgramSpecificOutcomes(@Param("programId") int programId);
	

}
