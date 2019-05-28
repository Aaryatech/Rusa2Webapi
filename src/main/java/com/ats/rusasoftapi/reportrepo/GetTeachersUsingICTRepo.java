package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.GetTeachersUsingICT;

 
public interface GetTeachersUsingICTRepo  extends JpaRepository<GetTeachersUsingICT, Integer> {
	
	
	
	@Query(value=" SELECT\n" + 
			"    m_academic_year.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(*)\n" + 
			"        FROM\n" + 
			"            m_faculty\n" + 
			"        WHERE\n" + 
			"            m_faculty.institute_id = m_institute.institute_id AND m_faculty.is_ict_used = 1 AND m_faculty.del_status = 1 AND m_faculty.is_active = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS techers_using_ict,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_institute_info_detail.no_of_fulltime_faculty\n" + 
			"        FROM\n" + 
			"            t_institute_info_detail\n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id = m_institute.institute_id AND t_institute_info_detail.year_id = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS total_faculty\n" + 
			"FROM\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:acYearList) AND m_institute.institute_id = :instId",nativeQuery=true)

	List<GetTeachersUsingICT> getTeachersUsingICT(@Param("instId") int instId,@Param("acYearList")   List<Integer> acYearList);

}
