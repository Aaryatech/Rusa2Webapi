package com.ats.rusasoftapi.repositories;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.TExtensionActivity;

public interface TExtensionActivityRepo extends JpaRepository<TExtensionActivity, Integer> {

	TExtensionActivity findByinstExtensionActId(int extActId);

	@Transactional
	@Modifying
	@Query(value=" UPDATE  t_extension_activity SET del_status = 0 WHERE inst_extension_act_id=:extActId",nativeQuery=true)
	int deleteExtActInfoById(int extActId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_extension_activity SET del_status=0  WHERE inst_extension_act_id IN (:exActIdsList)",nativeQuery=true)
	int deletetExtAct(List<String> exActIdsList);

	
	
}
