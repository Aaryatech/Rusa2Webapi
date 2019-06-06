package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.IntelectulPropRightReport;

public interface IntelectulPropRightReportRepo extends JpaRepository<IntelectulPropRightReport, Integer> {

	@Query(value="SELECT institute_ivsr_contribution.con_id, " + 
			" institute_ivsr_contribution.con_name," + 
			" institute_ivsr_contribution.con_fromdt," + 
			" institute_ivsr_contribution.con_todt," + 
			" institute_ivsr_contribution.con_pcount," + 
			" m_academic_year.academic_year," + 
			" m_institute.institute_name " + 
			"FROM institute_ivsr_contribution, m_academic_year, m_institute " + 
			"WHERE m_institute.institute_id=institute_ivsr_contribution.institute_id AND" + 
			" institute_ivsr_contribution.year_id=m_academic_year.year_id AND" + 
			" institute_ivsr_contribution.del_status=1 AND institute_ivsr_contribution.is_active=1 AND" + 
			" institute_ivsr_contribution.year_id IN (:lastFiveYears) AND institute_ivsr_contribution.institute_id=:instId",nativeQuery=true)
	List<IntelectulPropRightReport> getAllIntelPropRght(@Param("instId") int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
}
