package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudPrfrmInFinlYr;

public interface StudPrfrmInFinlYrRepo extends JpaRepository<StudPrfrmInFinlYr, Integer> {

	@Query(value="SELECT stud_perform_final_yr.stud_perform_id, stud_perform_final_yr.no_stud_appear, stud_perform_final_yr.no_stud_pass,stud_perform_final_yr.passing_per,"
			+ " t_program.name_of_program,m_program_type.program_name,m_institute.institute_name FROM stud_perform_final_yr,t_program,"
			+ "m_program_type,m_institute WHERE stud_perform_final_yr.inst_id=m_institute.institute_id AND stud_perform_final_yr.prog_type=t_program.program_id "
			+ "AND stud_perform_final_yr.ex_int1 IN(:acYearList) AND stud_perform_final_yr.prog_name=m_program_type.program_id AND stud_perform_final_yr.del_status=1 "
			+ "AND stud_perform_final_yr.is_active=1  AND m_institute.institute_id=:instId",nativeQuery=true)
	List<StudPrfrmInFinlYr> getAllStudPerformInFinalYear(@Param("instId") int instId,@Param("acYearList") List<String> acYearList);

}
