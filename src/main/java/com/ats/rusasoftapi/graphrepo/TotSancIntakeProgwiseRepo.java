package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.graph.model.TotSancIntakeProgwise;

public interface TotSancIntakeProgwiseRepo extends JpaRepository<TotSancIntakeProgwise, Integer> {

	
	
	@Query(value="SELECT\n" + 
			"    t_program.name_of_program,\n" + 
			"    t_prog_sanc_intake.sanc_intake,\n" + 
			"    m_program_type.program_name,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.loc_tot_student\n" + 
			"    ) AS total_admitted,t_program.program_id\n" + 
			"FROM\n" + 
			"    t_program,\n" + 
			"    t_prog_sanc_intake,\n" + 
			"    t_program_student_location,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    m_program_type\n" + 
			"WHERE\n" + 
			"    m_program_type.program_id = t_program.program_type AND t_program.institute_id = m_institute.institute_id AND t_prog_sanc_intake.inst_id = m_institute.institute_id AND t_prog_sanc_intake.ac_year_id = m_academic_year.year_id AND m_academic_year.is_current = 1 AND t_program.program_id = t_prog_sanc_intake.program_id AND m_institute.institute_id =:instId AND t_program.del_status = 1 AND t_program.is_active = 1 AND t_program_student_location.institute_id = m_institute.institute_id AND t_program_student_location.program_id = t_program.program_id AND t_program_student_location.del_status = 1 AND t_program_student_location.is_active = 1 AND t_program_student_location.year_id = m_academic_year.year_id  \n" + 
			"GROUP BY\n" + 
			"    t_program_student_location.program_id",nativeQuery=true)
	List<TotSancIntakeProgwise> getGraph2Data(@Param("instId")int instId);
	
	
}
