package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ICtEnbldFaclitiesReport;

public interface ICtEnbldFaclitiesReportRepo extends JpaRepository<ICtEnbldFaclitiesReport, Integer> {

	@Query(value="SELECT" + 
			"        ict_enabled_facilities.ict_enb_fac_id," + 
			"        ict_enabled_facilities.no_classrom_lcd," + 
			"        ict_enabled_facilities.no_classroom_wifi," + 
			"        ict_enabled_facilities.ict_seminar_hall," + 
			"        m_institute.institute_name," + 
			"        m_academic_year.academic_year," + 
			"        ict_enabled_facilities.inst_id " + 
			"    FROM" + 
			"        ict_enabled_facilities," + 
			"        m_academic_year," + 
			"        m_institute " + 
			"    WHERE" + 
			"        ict_enabled_facilities.inst_id=m_institute.institute_id " + 
			"        AND ict_enabled_facilities.del_status=1 " + 
			"        AND ict_enabled_facilities.is_active=1 " + 
			"        AND  m_institute.institute_id=:instId" + 
			"        AND  ict_enabled_facilities.year_id=m_academic_year.year_id" + 
			"        AND ict_enabled_facilities.year_id IN (:acYearList)", nativeQuery=true)
	List<ICtEnbldFaclitiesReport> getAllICTEnbldFaclties(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
}
