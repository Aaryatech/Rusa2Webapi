package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.SportsCulturalActivityComp;
 
public interface SportsCulturalActivityCompRepo extends JpaRepository<SportsCulturalActivityComp, Integer> {

	@Query(value="SELECT\n" + 
			"    t_program_student_activity.student_activity_id,\n" + 
			"    t_program_student_activity.activity_name,\n" + 
			"    t_program_student_activity.level,\n" + 
			"    t_program_student_activity.date,\n" + 
			"    t_program_student_activity.year_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    t_program_student_activity,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_program_student_activity.type =:typeId AND t_program_student_activity.institute_id =:instId AND t_program_student_activity.year_id IN(:acYearList) AND t_program_student_activity.del_status = 1 AND t_program_student_activity.is_active = 1 AND t_program_student_activity.year_id = m_academic_year.year_id AND m_institute.institute_id = t_program_student_activity.institute_id",nativeQuery=true)
List<SportsCulturalActivityComp> getAllSportsCulturalActivityComp(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("typeId") int typeId);
}
