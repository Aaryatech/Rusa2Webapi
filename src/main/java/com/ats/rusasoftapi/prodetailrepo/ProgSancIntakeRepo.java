package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.ProgSancIntake;

public interface ProgSancIntakeRepo extends JpaRepository<ProgSancIntake, Integer> {

	
	@Query(value="SELECT t_prog_sanc_intake.prog_sanc_intake_id," + 
			"			t_prog_sanc_intake.program_id," + 
			"            t_prog_sanc_intake.sanc_intake," + 
			"            t_prog_sanc_intake.inst_id," + 
			"            t_prog_sanc_intake.ac_year_id,  " + 
			"            t_prog_sanc_intake.del_status, " + 
			"            t_prog_sanc_intake.is_active,  " + 
			"            t_prog_sanc_intake.maker_user_id," + 
			"            t_prog_sanc_intake.maker_enter_datetime, " + 
			"            t_prog_sanc_intake.ex_int1,          " + 
			"            CONCAT( m_program_type.program_name,' - ', t_program.name_of_program)  AS ex_var1, " + 
			"            m_program_type.program_name " + 
			"FROM t_prog_sanc_intake, t_program, m_program_type " + 
			"WHERE t_prog_sanc_intake.del_status=1 AND" + 
			"            t_prog_sanc_intake.inst_id=:instId AND" + 
			"            t_prog_sanc_intake.ac_year_id=:yearId AND" + 
			"            t_prog_sanc_intake.program_id=t_program.program_id AND" + 
			"            m_program_type.program_id=t_program.program_type",nativeQuery=true)
	List<ProgSancIntake> findByInstIdAndAcYearIdAndDelStatus(@Param("instId") int instId, @Param("yearId")int yearId); 
}
/*SELECT t_prog_sanc_intake.prog_sanc_intake_id," + 
			"			t_prog_sanc_intake.program_id," + 
			"            t_prog_sanc_intake.sanc_intake," + 
			"            t_prog_sanc_intake.inst_id," + 
			"            t_prog_sanc_intake.ac_year_id,  " + 
			"            t_prog_sanc_intake.del_status, " + 
			"            t_prog_sanc_intake.is_active,  " + 
			"            t_prog_sanc_intake.maker_user_id," + 
			"            t_prog_sanc_intake.maker_enter_datetime, " + 
			"            t_prog_sanc_intake.ex_int1,          " + 
			"            CONCAT( m_program_type.program_name,' - ', t_program.name_of_program)  AS ex_var1, " + 
			"            m_program_type.program_name " + 
			"FROM t_prog_sanc_intake, t_program, m_program_type " + 
			"WHERE t_prog_sanc_intake.del_status=1 AND" + 
			"            t_prog_sanc_intake.inst_id=:instId AND" + 
			"            t_prog_sanc_intake.ac_year_id=:yearId AND" + 
			"            t_prog_sanc_intake.program_id=t_program.program_id AND" + 
			"            m_program_type.program_id=t_program.program_type*/