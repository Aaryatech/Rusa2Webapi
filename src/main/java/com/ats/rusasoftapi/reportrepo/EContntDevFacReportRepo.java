package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.report.EContntDevFacReport;

public interface EContntDevFacReportRepo extends JpaRepository<EContntDevFacReport, Integer> {

	@Query(value="SELECT e_content_dev_facility.inst_e_content_dev_facility_id," + 
			"	e_content_dev_facility.e_content_dev_facility," + 
			"    e_content_dev_facility.name_econtent_dev_facility," + 
			"    e_content_dev_facility.video_link," + 
			"    e_content_dev_facility.ex_var1," + 
			"    m_institute.institute_name " + 
			"FROM e_content_dev_facility, m_institute " + 
			"WHERE m_institute.institute_id=e_content_dev_facility.inst_id AND" + 
			"	e_content_dev_facility.inst_id=:instId AND e_content_dev_facility.del_status=1 AND" + 
			"    e_content_dev_facility.is_active=1 AND e_content_dev_facility.e_content_dev_facility  LIKE :eContFacility",nativeQuery=true)
	List<EContntDevFacReport> getAllEContntDevFac(int instId, String eContFacility);

}
