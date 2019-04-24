package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Dean;
import com.ats.rusasoftapi.model.StudentSchemeList;

public interface StudentSchemeRepo extends JpaRepository<StudentSchemeList, Integer> {

	@Modifying
	@Query(value="SELECT s.sprt_schm_id, s.extra_varchar1, s.scheme_name, s.level, s.type, s.no_student_benifited,s.support_agency_name, s.implementation_year as academic_year "
			+ " FROM t_support_scheme_detail s WHERE s.del_status=1 AND s.is_active=1 AND s.institute_id=:instId  AND s.year_id=:yearId   ORDER BY sprt_schm_id DESC",nativeQuery=true)
	public List<StudentSchemeList> getStudentSchemeList(@Param("yearId") int yearId,@Param("instId") int instId);

	
}
/*
 * SELECT
        s.sprt_schm_id, 
        
        s.level, s.type,
        s.no_student_benifited,
        s.support_agency_name, 
        s.implementation_year as academic_year,
        
        CASE WHEN s.extra_int1=7 THEN(SELECT t_support_scheme_detail.extra_varchar1 FROM t_support_scheme_detail) END
        as scheme_name
FROM 
		t_support_scheme_detail s
 
 WHERE 
 		s.del_status=1 
        AND s.is_active=1 
        AND s.institute_id=2  
        AND s.year_id=4
        ORDER BY sprt_schm_id DESC
 * 
 * */
