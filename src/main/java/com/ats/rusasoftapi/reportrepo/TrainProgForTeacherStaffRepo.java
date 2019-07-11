package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.TrainProgForTeacherStaff;

public interface TrainProgForTeacherStaffRepo extends JpaRepository<TrainProgForTeacherStaff, Integer>{

	
	@Query(value="SELECT\n" + 
			"    m_academic_year.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(*)\n" + 
			"        FROM\n" + 
			"            t_institute_training\n" + 
			"        WHERE\n" + 
			"            t_institute_training.institute_id = m_institute.institute_id AND t_institute_training.year_id = m_academic_year.year_id AND t_institute_training.del_status = 1 AND t_institute_training.is_active = 1 AND t_institute_training.training_type = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS prof_dev_count,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(*)\n" + 
			"        FROM\n" + 
			"            t_institute_training\n" + 
			"        WHERE\n" + 
			"            t_institute_training.institute_id = m_institute.institute_id AND t_institute_training.year_id = m_academic_year.year_id AND t_institute_training.del_status = 1 AND t_institute_training.is_active = 1 AND t_institute_training.training_type = 2\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS adm_dev_count\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:acYearList) AND m_institute.institute_id =:instId\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id", nativeQuery=true)
	List<TrainProgForTeacherStaff> getTrainProgForTeachStaff(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
}
