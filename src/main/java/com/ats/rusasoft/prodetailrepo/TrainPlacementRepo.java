package com.ats.rusasoft.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.progdetail.TrainPlacement;

public interface TrainPlacementRepo extends JpaRepository<TrainPlacement, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_traning_placement SET del_status=0 WHERE placement_id  IN (:placementIds)  ",nativeQuery=true)
	
	int deleteTrainPlace(@Param("placementIds") List<String> placementIds);
	
	
	TrainPlacement findByPlacementIdAndDelStatusAndIsActive(int placementId, int delStatus,int isActive);
	

}
