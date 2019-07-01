package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.GetTotStudentPassedAndAppearInFinYr;
 
public interface GetTotStudentPassedAndAppearInFinYrRepo  extends JpaRepository<GetTotStudentPassedAndAppearInFinYr, Integer>{

	
	@Query(value="SELECT stud_perform_final_yr\n" + 
			"    .stud_perform_id,\n" + 
			"    stud_perform_final_yr.no_stud_appear,\n" + 
			"    stud_perform_final_yr.no_stud_pass,\n" + 
			"    t_program.name_of_program,\n" + 
			"    m_program_type.program_name\n" + 
			"FROM\n" + 
			"    stud_perform_final_yr,\n" + 
			"    t_program,\n" + 
			"    m_program_type,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    stud_perform_final_yr.prog_type = t_program.program_id AND t_program.program_type = m_program_type.program_id AND stud_perform_final_yr.inst_id = m_institute.institute_id AND stud_perform_final_yr.ex_int1 = m_academic_year.year_id AND m_academic_year.is_current = 1 AND t_program.maker_user_id =:facultyId AND stud_perform_final_yr.del_status = 1 AND stud_perform_final_yr.is_active = 1 AND m_institute.institute_id =:instId",nativeQuery=true)
	List<GetTotStudentPassedAndAppearInFinYr> getGetTotStudentPassedAndAppearInFinYrDet(@Param("instId")int instId,@Param("facultyId")int facultyId);
	
	
}
