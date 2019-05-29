package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AdmsnAgnstResrvCat;

public interface AdmsnAgnstResrvCatRepo extends JpaRepository<AdmsnAgnstResrvCat, Integer> {

	@Query(value="SELECT UUID() as uniq_id, m_cast.cast_name,m_cast.cast_id,t_program_student_category.student_cat_id,"
			+ "t_program_student_category.cat_tot_student,t_program_student_category.ex_int1 as seats_available,"
			+ "m_academic_year.academic_year,t_program_student_category.year_id,m_institute.institute_name "
			+ "FROM t_program_student_category,m_cast,m_academic_year,m_institute "
			+ "WHERE t_program_student_category.del_status=1 AND t_program_student_category.is_active=1 AND "
			+ "t_program_student_category.cast_id=m_cast.cast_id AND t_program_student_category.year_id=m_academic_year.year_id AND "
			+ "t_program_student_category.institute_id=m_institute.institute_id and t_program_student_category.year_id IN (:acYearList) AND "
			+ "t_program_student_category.institute_id=:instId",nativeQuery=true)
	List<AdmsnAgnstResrvCat> getAllAdmisionAgnstResrvCat(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);

}
