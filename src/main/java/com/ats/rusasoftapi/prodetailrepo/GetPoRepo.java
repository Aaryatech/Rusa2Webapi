package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramOutcome;

public interface GetPoRepo extends JpaRepository<ProgramOutcome, Integer>{
	
	@Query(value=" SELECT * FROM t_program_po WHERE t_program_po.program_id=:programId and t_program_po.del_status=1 and t_program_po.is_active=1 "
			+ " ORDER BY t_program_po.po_id Desc ",nativeQuery=true)
	
	List<ProgramOutcome> getProgramOutcomes(@Param("programId") int programId);
	
	
@Query(value=" SELECT * FROM t_program_po WHERE t_program_po.po_id=:poId and t_program_po.del_status=1 and t_program_po.is_active=1 ",nativeQuery=true)
	
	ProgramOutcome getProgramOutcome(@Param("poId") int poId);

}
