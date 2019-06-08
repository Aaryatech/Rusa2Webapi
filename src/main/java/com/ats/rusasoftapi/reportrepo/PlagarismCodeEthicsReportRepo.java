package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.PlagarismCodeEthicsReport;
 
public interface PlagarismCodeEthicsReportRepo extends JpaRepository<PlagarismCodeEthicsReport, Integer> {

	
	@Query(value="SELECT\n" + 
			"    plagiarism_code_ethics.plag_code_ethc_id,\n" + 
			"    plagiarism_code_ethics.is_softwr_avabl,\n" + 
			"    plagiarism_code_ethics.url_link,\n" + 
			"    plagiarism_code_ethics.mech_detect_plag,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    plagiarism_code_ethics,\n" + 
			"    m_academic_year,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.institute_id = plagiarism_code_ethics.inst_id AND m_academic_year.year_id = plagiarism_code_ethics.ac_year_id AND plagiarism_code_ethics.ac_year_id IN(:acYearList)  AND plagiarism_code_ethics.inst_id =:instId \n" + 
			"\n" + 
			"", nativeQuery=true)
	List<PlagarismCodeEthicsReport> getAllPlagarismCodeEthicsReport(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);
	
}
