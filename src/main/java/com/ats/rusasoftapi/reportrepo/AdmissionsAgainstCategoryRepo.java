package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.rusasoftapi.model.report.AdmissionsAgainstCategory;
  @Repository
public interface AdmissionsAgainstCategoryRepo extends JpaRepository<AdmissionsAgainstCategory, Integer>  {

	
	@Query(value="SELECT\n" + 
			"    UUID() as id, m_cast.cast_name,\n" + 
			"    m_cast.cast_id,\n" + 
			"    t_program_student_category.student_cat_id,\n" + 
			"    t_program_student_category.cat_tot_student,\n" + 
			"    t_program_student_category.ex_int1 AS seats_avaailable,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    t_program_student_category.year_id,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    t_program_student_category,\n" + 
			"    m_cast,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    t_program_student_category.del_status = 1 AND "
			+ "t_program_student_category.is_active = 1 AND "
			+ "t_program_student_category.cast_id = m_cast.cast_id AND "
			+ "t_program_student_category.year_id = m_academic_year.year_id AND "
			+ "t_program_student_category.institute_id = m_institute.institute_id AND "
			+ "t_program_student_category.year_id IN(:acYearList) AND "
			+ "t_program_student_category.institute_id =:instId AND "
			+ "t_program_student_category.cast_id =:catId ",nativeQuery=true)
	List<AdmissionsAgainstCategory> getAdmissionsAgainstCat(@Param("instId")int instId, @Param("catId")int catId, @Param("acYearList") List<Integer> acYearList);
	
}
