package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{
 
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_program SET del_status=0 WHERE program_id IN (:programId) ", nativeQuery = true)
	int deleteProgram(@Param("programId") int programId);

	Program findByProgramId(int programId);

	List<Program> findByDelStatusAndIsActiveAndInstituteIdOrderByProgramIdDesc(int i, int j, int instituteId);

	List<Program> findByProgramTypeAndDelStatusAndInstituteId(int programTypeId, int i,int instId);
	
	@Query(value="SELECT t_program.program_id," + 
			"	t_program.institute_id," + 
			"    t_program.name_of_program," + 
			"    t_program.program_type," + 
			"    t_program.month_duration," + 
			"    t_program.sanctional_intake," + 
			"    t_program.date_of_introduction," + 
			"    t_program.approved_by," + 
			"    t_program.del_status," + 
			"    t_program.is_active," + 
			"    t_program.maker_user_id," + 
			"    t_program.maker_datetime," + 
			"    t_program.ex_int1," + 
			"    t_program.ex_int2," + 
			"    t_program.ex_var1," + 
			"    t_program.year_id," + 
			"    m_program_type.program_name AS ex_var2 " + 
			"FROM t_program, m_program_type " + 
			"WHERE   t_program.del_status=1 AND " + 
			"    	t_program.is_active=1 AND" + 
			"        t_program.institute_id=:instituteId AND" + 
			"        m_program_type.program_id=t_program.program_type",nativeQuery=true)
	List<Program> getAllProgTypeAndProgram(@Param("instituteId") int instituteId);

}
