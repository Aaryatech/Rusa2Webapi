package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.GenderEquityProg;
 
public interface GenderEquityProgRepo extends JpaRepository<GenderEquityProg, Integer>{

	
	@Query(value="SELECT\n" + 
			"    institute_ivsr_gender_prog.gprog_id,\n" + 
			"    institute_ivsr_gender_prog.gprog_name,\n" + 
			"    institute_ivsr_gender_prog.gprog_fromdt,\n" + 
			"    institute_ivsr_gender_prog.gprog_todt,\n" + 
			"    institute_ivsr_gender_prog.gprog_pcount  as p_count,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    institute_ivsr_gender_prog,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    institute_ivsr_gender_prog.institute_id = m_institute.institute_id AND institute_ivsr_gender_prog.year_id = m_academic_year.year_id AND institute_ivsr_gender_prog.del_status = 1 AND institute_ivsr_gender_prog.is_active = 1 AND institute_ivsr_gender_prog.year_id IN(:acYearList) AND institute_ivsr_gender_prog.institute_id =:instId",nativeQuery=true)
	List<GenderEquityProg> getAllGenderEquityInfo(@Param("instId") int instId,@Param("acYearList")   List<Integer> acYearList);
}
