package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudPerformFinalYrList;

public interface StudPerformFinalYrListRepo extends JpaRepository<StudPerformFinalYrList, Integer> {
	
	@Query(value = "select " + 
			"        stud.stud_perform_id, " + 
			"        t.name_of_program as prog_name, " + 
			"        m.program_name as prog_type, " + 
			"        stud.no_stud_appear," + 
			"        stud.no_stud_pass," + 
			"        stud.passing_per," + 
			"        stud.del_status" + 
			"        " + 
			"from " + 
			"        stud_perform_final_yr stud," + 
			"        t_program t," + 
			"        m_program_type m " + 
			"where " + 
			"        stud.prog_name=m.program_id and" + 
			"        stud.prog_type=t.program_id and" + 
			"        stud.inst_id=:instituteId and "+
			"        stud.ex_int1 =:yearId and "+
			"        stud.del_status=1 Order By stud.stud_perform_id Desc",nativeQuery=true)
	List<StudPerformFinalYrList> getStudPassingInfo(@Param("instituteId") int instituteId, @Param("yearId") int yearId);
	
	
}
