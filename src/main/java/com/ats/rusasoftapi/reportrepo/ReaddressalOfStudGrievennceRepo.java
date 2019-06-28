package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 import com.ats.rusasoftapi.model.report.ReaddressalOfStudGrievennce;
 
public interface ReaddressalOfStudGrievennceRepo extends JpaRepository<ReaddressalOfStudGrievennce, String> {

	
	@Query(value="SELECT\n" + 
			"    UUID() AS id, redressed_stud_grievance.stud_grievnce, SUM(\n" + 
			"        redressed_stud_grievance.no_trnsprnt_grievnce_appeld + redressed_stud_grievance.no_time_grievnce_appeld + redressed_stud_grievance.no_efficnt_grievnce_appeld\n" + 
			"    ) AS total_appealed,\n" + 
			"    SUM(\n" + 
			"        redressed_stud_grievance.no_trnsprnt_redrsed + redressed_stud_grievance.no_time_redrsed + redressed_stud_grievance.no_efficnt_redrsed\n" + 
			"    ) AS total_redresed,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    redressed_stud_grievance,\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    redressed_stud_grievance.inst_id = m_institute.institute_id AND redressed_stud_grievance.acad_year_id = m_academic_year.year_id AND redressed_stud_grievance.del_status = 1 AND m_institute.institute_id =:instId AND m_academic_year.year_id IN(:acYearList)\n" + 
			"GROUP BY\n" + 
			"    redressed_stud_grievance.stud_grievnce,\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<ReaddressalOfStudGrievennce> getAllStudGrievanceReport(@Param("instId")int instId,@Param("acYearList") List<Integer> acYearList);

	
}
