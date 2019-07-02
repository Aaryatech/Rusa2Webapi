package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.NoOfResearchPubGraphDean;
 
public interface NoOfResearchPubGraphDeanRepo  extends JpaRepository<NoOfResearchPubGraphDean, Integer> {

	@Query(value="\n" + 
			"SELECT\n" + 
			"    COUNT(t_faculty_conference.conf_id) AS no_of_publication,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    t_faculty_conference.year_id\n" + 
			"  \n" + 
			"FROM\n" + 
			"    t_faculty_conference,m_faculty,m_academic_year\n" + 
			"WHERE\n" + 
			"    t_faculty_conference.del_status = 1 AND t_faculty_conference.is_active = 1 AND t_faculty_conference.year_id IN(:lastFiveYears) AND t_faculty_conference.faculty_id = m_faculty.faculty_id AND m_faculty.institute_id =:instId  AND m_academic_year.year_id=t_faculty_conference.year_id GROUP BY t_faculty_conference.year_id \n" + 
			"",nativeQuery=true)
	List<NoOfResearchPubGraphDean> getNoOfResearchPubGraphDeanDet(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
}
