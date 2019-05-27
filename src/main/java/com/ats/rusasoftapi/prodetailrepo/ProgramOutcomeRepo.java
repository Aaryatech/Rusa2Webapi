package com.ats.rusasoftapi.prodetailrepo;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ProgramOutcome;


public interface ProgramOutcomeRepo extends JpaRepository<ProgramOutcome, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_program_po  SET pso_map_id=:psoIdList ,pso_map_satisfying_value=:satValue,pso_mapping=:isMap  WHERE po_id=:poId  ",nativeQuery=true)
	int updatePoMapping(@Param("psoIdList") String psoIdList,@Param("poId") int poId,@Param("isMap") int isMap,@Param("satValue") int satValue);

}
