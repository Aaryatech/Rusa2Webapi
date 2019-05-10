package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.GetInstTrainTeachDetail;

public interface GetInstTrainTeachDetailRepo extends JpaRepository<GetInstTrainTeachDetail, Integer> {

	@Query(value = " SELECT t_institute_training.training_id,t_institute_training.training_title,"
			+ " t_institute_training.training_fromdt, t_institute_training.ex_var1,"
			+ " t_institute_training.training_todt,t_institute_training.training_pcount,"
			+ " t_institute_training.year_id,t_institute_training.training_type "
			+ " FROM t_institute_training  "
			+ " WHERE t_institute_training.is_active=1 AND t_institute_training.del_status=1 "
			+ " AND t_institute_training.institute_id=:instId AND t_institute_training.year_id=:yearId "
			+ " AND t_institute_training.training_type=:trainningType ORDER BY t_institute_training.training_id DESC  ", nativeQuery = true)

	List<GetInstTrainTeachDetail> getInstTrainTeachDetail(@Param("instId") int instId,@Param("yearId") int yearId,
			@Param("trainningType") int trainningType);
	
	@Query(value = " SELECT t_institute_training.training_id,t_institute_training.training_title,"
			+ " t_institute_training.training_fromdt, t_institute_training.ex_var1,"
			+ " t_institute_training.training_todt,t_institute_training.training_pcount,"
			+ " t_institute_training.year_id,t_institute_training.training_type "
			+ " FROM t_institute_training  "
			+ " WHERE "
			+ "  t_institute_training.training_id=:trainingId  ", nativeQuery = true)

	GetInstTrainTeachDetail getInstTrainTeachDetailById(@Param("trainingId") int trainingId);

}
