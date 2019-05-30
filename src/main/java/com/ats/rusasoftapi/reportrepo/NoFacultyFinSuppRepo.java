package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.NoFacultyFinSupp;

public interface NoFacultyFinSuppRepo extends JpaRepository<NoFacultyFinSupp, Integer>{
	@Query(value="SELECT\n" + 
			"m_academic_year.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(*)\n" + 
			"        FROM\n" + 
			"            faculty_empowerment\n" + 
			"        WHERE\n" + 
			"            faculty_empowerment.inst_id = m_institute.institute_id AND faculty_empowerment.ac_year_id = m_academic_year.year_id AND faculty_empowerment.del_status = 1 AND faculty_empowerment.is_active = 1 AND faculty_empowerment.financial_support = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS no_of_fac_support,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_info_detail.no_of_fulltime_faculty\n" + 
			"        FROM\n" + 
			"            t_institute_info_detail\n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id = m_institute.institute_id AND t_institute_info_detail.year_id = m_academic_year.year_id AND t_institute_info_detail.del_status = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS total_faculty\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = :instId AND   m_academic_year.year_id IN(\n" + 
			"            :acYearList \n" + 
			"        )",nativeQuery=true)
	List<NoFacultyFinSupp> getAllNoFacultyFinSupp(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);
	

}
