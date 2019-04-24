package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwiseGrpByProg;

public interface GetStudAdmLocwiseGrpByProgRepo extends JpaRepository<GetStudAdmLocwiseGrpByProg, Integer> {

    
    @Query(value=" SELECT t_program_student_location.program_id, sum(t_program_student_location.male_student) AS male_student, " + 
    		"    sum(t_program_student_location.female_student) AS female_student, " + 
    		"    sum(t_program_student_location.trans_student) AS trans_student, " + 
    		"   sum(t_program_student_location.loc_tot_student) AS tot_student, " + 
    		"     t_program.name_of_program AS prog_type," + 
    		"    m_program_type.program_name AS prog_name " + 
    		" FROM  t_program_student_location,t_program,m_program_type,m_location " + 
    		" WHERE " + 
    		"  t_program_student_location.location_id=m_location.location_id AND  " + 
    		"    t_program_student_location.is_active=1 " + 
    		"    AND t_program_student_location.del_status=1  " + 
    		"    AND t_program_student_location.year_id=:yearId " + 
    		"    AND t_program_student_location.institute_id=:instId  " + 
    		"      AND m_program_type.program_id=t_program.program_type " + 
    		"    AND t_program_student_location.program_id=t_program.program_id " + 
    		"    GROUP by t_program_student_location.program_id " + 
    		" ORDER BY " + 
    		"    t_program_student_location.student_loc_id DESC ", nativeQuery=true)
	List<GetStudAdmLocwiseGrpByProg> getStudAdmLocwiseGrpByProg(@Param("instId") int instId,@Param("yearId") int yearId);
	
    
    
    
}
