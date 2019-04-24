package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteTraining;

public interface InstituteTrainingRepo extends JpaRepository<InstituteTraining, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_training SET del_status=0 WHERE training_id IN (:trainingIdList) ", nativeQuery = true)
	int deleteInstTraining(@Param("trainingIdList") List<String> trainingIdList);

}
