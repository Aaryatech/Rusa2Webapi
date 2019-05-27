package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.SpecificLocalAdvntgDisadvntg;

public interface SpecificLocalAdvntgDisadvntgRepo extends JpaRepository<SpecificLocalAdvntgDisadvntg, Integer> {

	List<SpecificLocalAdvntgDisadvntg> findByInstIdAndAcYearIdAndDelStatusOrderBySpciAdvIdDesc(int instituteId, int yId, int i);

	SpecificLocalAdvntgDisadvntg findBySpciAdvId(int inItId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE specific_local_advntg_disadvntg SET del_status = 0 WHERE spci_adv_id=:inItId",nativeQuery=true)
	int deleteInitiative(@Param("inItId") int inItId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE specific_local_advntg_disadvntg SET del_status = 0 WHERE spci_adv_id IN (:initAdvIdList)",nativeQuery=true)
	int deleteInitives(@Param("initAdvIdList") List<String> initAdvIdList);

}
