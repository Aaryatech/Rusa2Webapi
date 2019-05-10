package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.ActCndctPrmtngUnivrslVal;

public interface ActCndctPrmtngUnivrslValRepo extends JpaRepository<ActCndctPrmtngUnivrslVal, Integer> {

	List<ActCndctPrmtngUnivrslVal> findByInstIdAndAcYearIdAndDelStatusOrderByActCndctIdDesc(@Param("instituteId") int instituteId, @Param("yId")int yId, @Param("i") int i);

	ActCndctPrmtngUnivrslVal findByActCndctId(@Param("actId") int actId);

	@Transactional
	@Modifying
	@Query(value="UPDATE act_cndct_prmtng_univrsl_val SET del_status = 0 WHERE act_cndct_id=:actId", nativeQuery=true)
	int deleteActCndct(@Param("actId") int actId);

	@Transactional
	@Modifying
	@Query(value="UPDATE act_cndct_prmtng_univrsl_val SET del_status=0  WHERE act_cndct_id IN (:activityIdlist) ",nativeQuery=true)
	int deleteActCndct(@Param("activityIdlist") List<String> activityIdlist);
	
}
