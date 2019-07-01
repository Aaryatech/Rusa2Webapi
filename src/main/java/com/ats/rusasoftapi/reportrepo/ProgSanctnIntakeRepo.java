package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.report.ProgSanctnIntake;

public interface ProgSanctnIntakeRepo extends JpaRepository<ProgSanctnIntake, Integer> {
	
	@Query(value="SELECT" + 
			"    t_program.name_of_program," + 
			"    t_prog_sanc_intake.sanc_intake," + 
			"    m_program_type.program_name," + 
			"	SUM(t_program_student_location.loc_tot_student) as total_admitted " + 
			"FROM " + 
			"	t_program,t_prog_sanc_intake,t_program_student_location,m_institute,m_academic_year,m_program_type " + 
			"WHERE" + 
			"    m_program_type.program_id=t_program.program_type AND " + 
			"    t_program.institute_id=m_institute.institute_id AND " + 
			"    t_prog_sanc_intake.inst_id=m_institute.institute_id AND " + 
			"    t_prog_sanc_intake.ac_year_id=m_academic_year.year_id AND " + 
			"    m_academic_year.is_current=1 AND " + 
			"    t_program.program_id=t_prog_sanc_intake.program_id",nativeQuery=true)
	
	List<ProgSanctnIntake> getAllProgSanctnIntake();	

}
