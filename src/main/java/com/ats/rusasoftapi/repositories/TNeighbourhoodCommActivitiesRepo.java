package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.TNeighbourhoodCommActivities;

public interface TNeighbourhoodCommActivitiesRepo extends JpaRepository<TNeighbourhoodCommActivities, Integer> {
	
	List<TNeighbourhoodCommActivities> findByInstIdAndDelStatusOrderByInstNeighbourhoodCommActIdDesc(int instituteId, int i);
	
	TNeighbourhoodCommActivities findByInstNeighbourhoodCommActIdAndDelStatus(@Param("neighbCommActId") int neighbCommActId, @Param("i") int i);

	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_neighbourhood_comm_activities SET del_status = 0 WHERE inst_neighbourhood_comm_act_id=:neighbCommActId",nativeQuery=true)
	int deleteNeghbCommActivityById(@Param("neighbCommActId") int neighbCommActId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_neighbourhood_comm_activities SET del_status=0  WHERE inst_neighbourhood_comm_act_id IN (:actIdList)",nativeQuery=true)
	int deleteActivities(@Param("actIdList")List<String> actIdList);
}
