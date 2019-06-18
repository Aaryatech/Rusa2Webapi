package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.LibAutoLMSInfo;

 
public interface LibAutoLMSInfoRepo extends JpaRepository<LibAutoLMSInfo, Integer> {
	

	@Query(value=" SELECT\n" + 
			"    m_library_info.lib_info_id,\n" + 
			"    m_library_info.institute_id,\n" + 
			"    m_library_info.soft_name,\n" + 
			"    YEAR(\n" + 
			"        m_library_info.date_of_purchase_automation\n" + 
			"    )  as year,\n" + 
			"    m_library_info.soft_version,\n" + 
			"    m_library_info.users_of_lms,\n" + 
			"    m_institute.institute_name\n" + 
			"FROM\n" + 
			"    m_library_info,\n" + 
			"    m_institute\n" + 
			"WHERE\n"
			+ "m_library_info.institute_id = m_institute.institute_id AND "
			+ "m_library_info.del_status = 1 AND "
			+ "m_institute.institute_id =:instId AND "
			+ "m_library_info.ac_year_id=:acadYear",nativeQuery=true)

	//List<LibAutoLMSInfo> getLMSInfo(@Param("instId") int instId );

	List<LibAutoLMSInfo> getLMSInfo(int instId, int acadYear);   // on 18-06-2019 Mahendra

}

