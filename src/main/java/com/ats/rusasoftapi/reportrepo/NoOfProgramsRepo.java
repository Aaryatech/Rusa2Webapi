package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.NoOfPrograms;

public interface NoOfProgramsRepo extends JpaRepository<NoOfPrograms, Integer> {
	
	
	@Query(value=" SELECT t_program.program_id,t_program.institute_id,t_program.name_of_program,t_program.month_duration,t_program.approved_by ,YEAR(t_program.date_of_introduction) as year_of_introd, " + 
			" m_program_type.program_name as level_of_program,m_institute.institute_name " + 
			" FROM t_program,m_program_type,m_institute " + 
			" WHERE t_program.del_status=1 AND t_program.is_active=1 and m_program_type.program_id IN (:locIds)  AND m_program_type.program_id=t_program.program_type " + 
			" AND  t_program.institute_id=m_institute.institute_id AND t_program.institute_id=:instId ",nativeQuery=true)

	List<NoOfPrograms> getNoOfPrograms(@Param("instId") int instId,@Param("locIds") List<Integer> locIds);
	

}
