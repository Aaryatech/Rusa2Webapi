package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FulTimFacultyWithPhd;

public interface FulTimFacultyWithPhdRepo extends JpaRepository<FulTimFacultyWithPhd, Integer> {

	@Query(value="SELECT UUID() as uniq_id,m_institute.institute_name, t_faculty_academic.f_passing_year,COUNT(*) as no_of_phd_fac FROM t_faculty_academic,m_institute,"
			+ "m_faculty,m_qualificatoin WHERE t_faculty_academic.faculty_id=m_faculty.faculty_id AND t_faculty_academic.del_status=1 AND "
			+ "t_faculty_academic.is_active=1 AND t_faculty_academic.f_qualification_id=m_qualificatoin.qualification_id AND "
			+ "m_faculty.institute_id=m_institute.institute_id AND t_faculty_academic.f_qualification_id=:stkId AND m_faculty.institute_id=:instId GROUP by t_faculty_academic.f_passing_year",nativeQuery=true)
	
	List<FulTimFacultyWithPhd> getAllFulTimFacAvalblePhd(@Param("stkId")int stkId, @Param("instId")int instId);

}
