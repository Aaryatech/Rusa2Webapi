package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudCompRatioReport;

public interface StudCompRatioReportRepo extends JpaRepository<StudCompRatioReport, Integer> {

	@Query(value="SELECT t_inst_it_infra_info.inst_it_Infra_info_id," + 
			"  t_inst_it_infra_info.no_of_computers," + 
			"  t_inst_it_infra_info.purchase_date," + 
			"  t_inst_it_infra_info.purchase_amt," + 
			"  t_inst_it_infra_info.no_of_stud_utilizing," + 
			"  m_institute.institute_name " + 
			"FROM t_inst_it_infra_info, m_institute " + 
			"WHERE m_institute.institute_id=t_inst_it_infra_info.inst_id AND" + 
			"  t_inst_it_infra_info.del_status=1 AND t_inst_it_infra_info.is_active=1 AND" + 
			"  t_inst_it_infra_info.inst_id=:instId",nativeQuery=true)
	List<StudCompRatioReport> getAllStudentCompterRatio(@Param("instId")int instId);

}
