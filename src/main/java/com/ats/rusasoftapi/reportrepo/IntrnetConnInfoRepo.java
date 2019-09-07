package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.IntrnetConnInfo;

public interface IntrnetConnInfoRepo extends JpaRepository<IntrnetConnInfo, Integer> {

	@Query(value="SELECT\n" + 
			"        m_institute.institute_name,\n" + 
			"        COALESCE((SELECT\n" + 
			"            m_library_info.bandwidth_for_accessing_eresources  \n" + 
			"        FROM\n" + 
			"            m_library_info  \n" + 
			"        WHERE\n" + 
			"            m_institute.institute_id=m_library_info.institute_id \n" + 
			"            AND   m_library_info.del_status=1 \n" + 
			"            AND m_library_info.ac_year_id=m_academic_year.year_id),\n" + 
			"        0) AS lib_bandwidth,\n" + 
			"        COALESCE((SELECT\n" + 
			"            t_inst_internet_info.leased_line_bandwidth    \n" + 
			"        FROM\n" + 
			"            t_inst_internet_info   \n" + 
			"        WHERE\n" + 
			"            t_inst_internet_info.del_status=1 \n" + 
			"            AND t_inst_internet_info.inst_id=m_institute.institute_id\n" + 
			"            Order By t_inst_internet_info.inst_internet_info_id DESC LIMIT 1 ),\n" + 
			"        0) AS lease_line_bandwidth \n" + 
			"    FROM\n" + 
			"        m_institute ,m_academic_year\n" + 
			"    WHERE\n" + 
			"        m_institute.institute_id=:instId\n" + 
			"        AND m_academic_year.year_id=:ac_year",nativeQuery=true)
	
	List<IntrnetConnInfo> getAllInternetConnInfo(@Param("instId") int instId,@Param("ac_year") int ac_year);

}



/******************Mahendra 07/09/2019********************/
/*SELECT m_institute.institute_name, COALESCE((SELECT m_library_info.bandwidth_for_accessing_eresources" + 
		"  FROM m_library_info" + 
		"  WHERE m_institute.institute_id=m_library_info.institute_id AND" + 
		"   m_library_info.del_status=1 AND m_library_info.ac_year_id=:ac_year),0) AS lib_bandwidth," + 
		"   COALESCE((SELECT t_inst_internet_info.leased_line_bandwidth " + 
		"   FROM t_inst_internet_info" + 
		"   WHERE t_inst_internet_info.del_status=1 AND t_inst_internet_info.inst_id=m_institute.institute_id),0) AS lease_line_bandwidth " + 
		"FROM m_institute " + 
		"WHERE m_institute.institute_id=:instId*/