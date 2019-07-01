package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ProgTypStudPlacedGraph;

public interface ProgTypStudPlacedGraphRepo extends JpaRepository<ProgTypStudPlacedGraph, Integer> {
	
	@Query(value="SELECT" + 
			"		t_program.program_id," + 
			"        m_program_type.program_name as prog_type_name," + 
			"        t_program.name_of_program as program_name," + 
			"        t_traning_placement.no_student_placed," + 
			"        stud_perform_final_yr.no_stud_pass " + 
			"FROM" + 
			"		t_traning_placement," + 
			"        m_program_type," + 
			"        t_program," + 
			"        stud_perform_final_yr," + 
			"        m_institute,m_academic_year " + 
			"WHERE" + 
			"        t_traning_placement.program_type=m_program_type.program_id" + 
			"        AND t_traning_placement.program_name=t_program.program_id" + 
			"        AND t_traning_placement.year_id=m_academic_year.year_id" + 
			"        AND t_traning_placement.institute_id=m_institute.institute_id" + 
			"        AND t_traning_placement.del_status=1" + 
			"        AND t_traning_placement.is_active=1" + 
			"        AND stud_perform_final_yr.inst_id=m_institute.institute_id" + 
			"        AND stud_perform_final_yr.prog_name=t_program.program_id" + 
			"        AND stud_perform_final_yr.del_status=1" + 
			"        AND stud_perform_final_yr.is_active=1" + 
			"        AND stud_perform_final_yr.ex_int1=m_academic_year.year_id" + 
			"        AND m_institute.institute_id=2" + 
			"        AND m_academic_year.is_current=1" + 
			"        AND t_program.maker_user_id=:makerUserId",nativeQuery=true)
	List<ProgTypStudPlacedGraph> getAllProgTypStudPlacedGraph(@Param("makerUserId") int makerUserId);
	
}
