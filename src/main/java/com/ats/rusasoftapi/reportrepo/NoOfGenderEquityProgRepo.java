package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.NoOfGenderEquityProg;

public interface NoOfGenderEquityProgRepo extends JpaRepository< NoOfGenderEquityProg, Integer> {

	
	@Query(value="SELECT\n" + 
			"    COUNT(\n" + 
			"        institute_ivsr_gender_prog.gprog_id\n" + 
			"    ) AS no_of_prog,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"     m_academic_year.year_id\n" + 
			"    \n" + 
			"FROM\n" + 
			"    institute_ivsr_gender_prog,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    institute_ivsr_gender_prog.institute_id = m_institute.institute_id AND institute_ivsr_gender_prog.year_id = m_academic_year.year_id AND institute_ivsr_gender_prog.del_status = 1 AND institute_ivsr_gender_prog.is_active = 1 AND institute_ivsr_gender_prog.year_id IN(:acYearList) AND institute_ivsr_gender_prog.institute_id =:instId\n" + 
			"GROUP BY\n" + 
			"    institute_ivsr_gender_prog.year_id",nativeQuery=true)
	List<NoOfGenderEquityProg> getAllNoOfGenderEquityProg(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
}
