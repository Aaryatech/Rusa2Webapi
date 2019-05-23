package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetStudAdmCatwiseGrpByProg;

public interface GetStudAdmCatwiseGrpByProgRepo  extends JpaRepository<GetStudAdmCatwiseGrpByProg, Integer>{
	
				
	@Query(value="SELECT" + 
			"       t_program_student_category.program_id," + 
			"        sum(t_program_student_category.male_student) as male_student," + 
			"        sum(t_program_student_category.female_student) as female_student," + 
			"        sum(t_program_student_category.trans_student) as trans_student," + 
			"        sum(t_program_student_category.cat_tot_student) as tot_student," + 
			"        sum(t_program_student_category.ex_int1) as ex_int1," + 
			"        t_program.name_of_program as prog_type," + 
			"        m_program_type.program_name as prog_name" + 
			"    FROM" + 
			"        t_program_student_category,t_program,m_program_type " + 
			"    WHERE" + 
			"        t_program_student_category.is_active=1 " + 
			"        AND t_program_student_category.del_status=1  " + 
			"        AND t_program_student_category.year_id=:yearId" + 
			"        AND t_program_student_category.institute_id=:instId " + 
			"        AND m_program_type.program_id=t_program.program_type" + 
			"        and t_program_student_category.program_id=t_program.program_id" + 
			"        GROUP by t_program_student_category.program_id" + 
			"    ORDER BY" + 
			"        t_program_student_category.student_cat_id DESC", nativeQuery=true)
	List<GetStudAdmCatwiseGrpByProg> getStudAdmCatwiseGrpByProg(@Param("instId") int instId,@Param("yearId") int yearId);
	

}
