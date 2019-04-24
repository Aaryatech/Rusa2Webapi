package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.ProgramType;

public interface ProgramTypeRepo extends JpaRepository<ProgramType, Integer> {
	
	List<ProgramType> findByDelStatusAndIsActiveAndSequenceNotIn(int delStatus, int isActive, String seq);
	
	/*@Query(value=" SELECT * FROM m_program_type WHERE m_program_type.sequence > "
			+ "( SELECT sequence FROM m_program_type WHERE program_id=:progTypeId ) "
			+ " AND m_program_type.del_status=1 AND m_program_type.is_active=1  ", nativeQuery=true)
	List<ProgramType> getHigherProg(@Param("progTypeId") int progTypeId);
	*/
	
	@Query(value=" SELECT * FROM m_program_type WHERE FIND_IN_SET(m_program_type.program_id , "
			+ " (SELECT sequence FROM m_program_type WHERE program_id=:progTypeId) ) " + 
			"	AND m_program_type.del_status=1 AND m_program_type.is_active=1  ", nativeQuery=true)
	List<ProgramType> getHigherProg(@Param("progTypeId") int progTypeId);
	
}
