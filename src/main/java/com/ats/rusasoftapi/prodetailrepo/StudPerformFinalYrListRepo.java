package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudPerformFinalYr;
import com.ats.rusasoftapi.model.StudPerformFinalYrList;

public interface StudPerformFinalYrListRepo extends JpaRepository<StudPerformFinalYrList, Integer> {
	
	@Query(value = "select \n" + 
			"        stud.stud_perform_id, \n" + 
			"        t.name_of_program as prog_name, \n" + 
			"         m.program_name as prog_type, \n" + 
			"         stud.no_stud_appear,\n" + 
			"        stud.no_stud_pass,\n" + 
			"        stud.passing_per,\n" + 
			"        stud.del_status\n" + 
			"        \n" + 
			"from \n" + 
			"        stud_perform_final_yr stud,\n" + 
			"        t_program t,\n" + 
			"        m_program_type m\n" + 
			"where \n" + 
			"        stud.prog_name=m.program_id and\n" + 
			"        stud.prog_type=t.program_id and\n" + 
			"        stud.inst_id=:instituteId and "
			+ "stud.del_status=1 Order By stud.stud_perform_id Desc",nativeQuery=true)
	List<StudPerformFinalYrList> getStudPassingInfo(@Param("instituteId") int instituteId);
	
	
	
/*	@Query(value = "select \n" + 
			"        stud.stud_perform_id, \n" + 
			"        t.name_of_program as prog_name, \n" + 
			"        m.program_name as prog_type, \n" + 
			"        stud.no_stud_appear,\n" + 
			"        stud.no_stud_pass,\n" + 
			"        stud.passing_per,\n" + 
			"        stud.del_status,\n" + 
			"        stud.is_active,\n" + 
			"        stud.inst_id,\n" + 
			"        stud.maker_user_id,\n" + 
			"        stud.making_time,\n" + 
			"        stud.ex_int1,\n" + 
			"        stud.ex_int2,\n" + 
			"        stud.ex_var1,\n" + 
			"        stud.ex_var2\n" + 
			"from \n" + 
			"        stud_perform_final_yr stud,\n" + 
			"        t_program t,\n" + 
			"        m_program_type m\n" + 
			"where \n" + 
			"        stud.prog_name=m.program_id and\n" + 
			"        stud.prog_type=t.program_id and\n" + 
			"        stud.inst_id=:instituteId",nativeQuery=true)
	List<StudPerformFinalYr> getStudPassingInfo(@Param("instituteId") int instituteId);*/

}
