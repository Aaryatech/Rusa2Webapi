package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.GovtScheme;

public interface GovtSchemeRepo extends JpaRepository<GovtScheme, Integer>{
	
	@Query(value="SELECT\n" + 
			"    govt_scholarships.govt_scholar_id,\n" + 
			"    govt_scholarships.name_of_scheme,\n" + 
			"    govt_scholarships.no_of_stud_benftd,\n" + 
			"    govt_scholarships.ac_year_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    t_institute_info_detail.no_current_admited_stnt\n" + 
			"FROM\n" + 
			"    govt_scholarships,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    t_institute_info_detail\n" + 
			"WHERE\n" + 
			"    govt_scholarships.inst_id =:instId AND govt_scholarships.ac_year_id IN(:acYearList) AND m_academic_year.year_id = govt_scholarships.ac_year_id AND m_institute.institute_id = govt_scholarships.inst_id AND govt_scholarships.del_status = 1 AND govt_scholarships.is_active = 1 AND t_institute_info_detail.institute_id = govt_scholarships.inst_id AND t_institute_info_detail.year_id = govt_scholarships.ac_year_id\n" + 
			"ORDER BY\n" + 
			"    govt_scholarships.ac_year_id ASC",nativeQuery=true)
	List<GovtScheme> getAllGovtScheme(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList);

}
