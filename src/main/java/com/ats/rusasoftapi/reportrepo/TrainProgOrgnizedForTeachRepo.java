package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.TrainProgOrgnizedForTeach;

public interface TrainProgOrgnizedForTeachRepo extends JpaRepository<TrainProgOrgnizedForTeach, Integer> {

	
	@Query(value="SELECT\n" + 
			"    t_institute_training.training_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"      m_academic_year.year_id,\n" + 
			"    t_institute_training.training_title,\n" + 
			"    t_institute_training.training_fromdt,\n" + 
			"    t_institute_training.training_todt,\n" + 
			"    m_institute.institute_name,\n" + 
			"    t_institute_training.ex_var1 AS fin_support_from,\n" + 
			"    t_institute_training.training_pcount,0 as tot_count\n" + 
			"FROM\n" + 
			"    t_institute_training,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_institute_training.institute_id = m_institute.institute_id AND t_institute_training.year_id = m_academic_year.year_id AND t_institute_training.del_status = 1 AND t_institute_training.is_active = 1 AND m_institute.institute_id = :instId AND m_academic_year.year_id IN(:acYearList) AND t_institute_training.training_type = :typeId",nativeQuery=true)
List<TrainProgOrgnizedForTeach> getAllTrainProgOrgnizedForTeach(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("typeId") int typeId);
}
