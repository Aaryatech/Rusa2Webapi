package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.InstituteActivity;

public interface InstituteActivityRepo extends JpaRepository<InstituteActivity, Integer> {

	List<InstituteActivity> findByInstituteIdAndYearIdAndDelStatusOrderByInstActivityId(int instituteId, int yId, int i);

	InstituteActivity findByInstActivityId(int instActvId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_activity SET del_status=0 WHERE inst_activity_id = :instActvId",nativeQuery=true)
	int deleteByInstActivityId(int instActvId);

}
