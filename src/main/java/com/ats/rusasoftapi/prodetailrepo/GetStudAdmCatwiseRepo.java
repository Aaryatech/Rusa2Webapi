package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwise;

public interface GetStudAdmCatwiseRepo extends JpaRepository<GetStudAdmCatwise, Integer> {

	@Query(value = " SELECT t_program_student_category.student_cat_id, t_program_student_category.cast_id, m_cast.cast_name,"
			+ " t_program_student_category.male_student,t_program_student_category.female_student,t_program_student_category.trans_student, t_program_student_category.ex_int1 as seats,"
			+ " t_program_student_category.cat_tot_student  FROM t_program_student_category "
			+ " LEFT JOIN  m_cast ON t_program_student_category.cast_id=m_cast.cast_id "
			+ " WHERE t_program_student_category.is_active=1 AND t_program_student_category.del_status=1 "
			+ " AND t_program_student_category.year_id=:yearId AND t_program_student_category.institute_id=:instId"
			+ " ORDER BY t_program_student_category.student_cat_id DESC "
			+ " ", nativeQuery = true)

	List<GetStudAdmCatwise> getStudAdmCatwise(@Param("instId") int instId, @Param("yearId") int yearId);

	
	@Query(value = " SELECT t_program_student_category.student_cat_id, t_program_student_category.cast_id, m_cast.cast_name,"
			+ " t_program_student_category.male_student,t_program_student_category.female_student,t_program_student_category.trans_student, t_program_student_category.ex_int1 as seats,"
			+ " t_program_student_category.cat_tot_student  FROM t_program_student_category "
			+ " LEFT JOIN  m_cast ON t_program_student_category.cast_id=m_cast.cast_id "
			+ " WHERE t_program_student_category.is_active=1 AND t_program_student_category.del_status=1 "
			+ " AND t_program_student_category.year_id=:yearId AND t_program_student_category.institute_id=:instId"
			+ " AND t_program_student_category.program_id=:progType "
			+ " ORDER BY t_program_student_category.student_cat_id DESC "
			+ " ", nativeQuery = true)

	List<GetStudAdmCatwise> getStudAdmCatwiseByProgType(@Param("instId") int instId, @Param("yearId") int yearId,@Param("progType") int progType);

}
