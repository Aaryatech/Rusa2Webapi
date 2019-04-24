package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstituteActivity;

public interface InstituteActivityRepo extends JpaRepository<InstituteActivity, Integer> {

	List<InstituteActivity> findByInstituteIdAndYearIdAndDelStatusOrderByInstActivityIdDesc(int instituteId, int yId, int i);

	InstituteActivity findByInstActivityId(int instActvId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_activity SET del_status=0 WHERE inst_activity_id = :instActvId",nativeQuery=true)
	int deleteByInstActivityId(int instActvId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_institute_activity SET del_status=0  WHERE inst_activity_id IN (:activityIdList) ",nativeQuery=true)
	int deleteSelOrgActivity(@Param("activityIdList") List<String> activityIdList);

}
