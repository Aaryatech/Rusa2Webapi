package com.ats.rusasoftapi.reportrepo;

import java.util.List;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.IniToEngageLocComm;

public interface IniToEngageLocCommRepo extends JpaRepository<IniToEngageLocComm, Integer> {
	
	@Query(value="SELECT\n" + 
			"    COUNT(\n" + 
			"        institute_values_promotion.value_id\n" + 
			"    ) AS ini_count,\n" + 
			"    institute_values_promotion.year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    institute_values_promotion,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    institute_values_promotion.year_id IN(:acYearList) AND institute_values_promotion.del_status = 1 AND institute_values_promotion.year_id = m_academic_year.year_id AND institute_values_promotion.institute_id = m_institute.institute_id AND institute_values_promotion.is_active = 1 AND institute_values_promotion.institute_id =:instId \n" + 
			"GROUP BY\n" + 
			"    institute_values_promotion.year_id",nativeQuery=true)
	List<IniToEngageLocComm> getIniToEngageLocCommunity(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}
