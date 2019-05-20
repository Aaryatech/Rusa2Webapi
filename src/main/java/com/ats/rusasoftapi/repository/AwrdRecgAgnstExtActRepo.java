package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.AwrdRecgAgnstExtActivity;

public interface AwrdRecgAgnstExtActRepo extends JpaRepository<AwrdRecgAgnstExtActivity, Integer> {

	List<AwrdRecgAgnstExtActivity> findByInstIdAndDelStatusOrderByAwrdRecgAgnstExtActIdDesc(@Param("instituteId") int instituteId,@Param("i") int i);

	AwrdRecgAgnstExtActivity findByAwrdRecgAgnstExtActIdAndDelStatus(@Param("awrdRecgid") int awrdRecgid,@Param("i") int i);

	@Transactional
	@Modifying
	@Query(value="update t_awd_rec_agn_exact set del_status = 0 where awrd_recg_agnst_ext_act_id=:awrdRecgid",nativeQuery=true)
	int deleteAwrdRecgExtActById(@Param("awrdRecgid") int awrdRecgid);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_awd_rec_agn_exact SET del_status=0  WHERE awrd_recg_agnst_ext_act_id IN (:exActIdList)",nativeQuery=true)
	int delAwrdRecgAct(List<String> exActIdList);

	
	
}
