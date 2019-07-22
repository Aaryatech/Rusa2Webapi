package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.IQACQualInititive;
 
public interface IQACQualInititiveRepo extends JpaRepository<IQACQualInititive, Integer> {
	
	@Query(value="SELECT\n" + 
			"        m_institute.institute_name,\n" + 
			"        m_quality_initiatives.quality_initiative_id,\n" + 
			"        m_quality_initiatives.quality_initiative_name,\n" + 
			"        COALESCE(         (         SELECT\n" + 
			"            'Yes'          \n" + 
			"        FROM\n" + 
			"            t_institute_quality,m_academic_year         \n" + 
			"        WHERE\n" + 
			"            t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id \n" + 
			"            AND t_institute_quality.institute_id = m_institute.institute_id \n" + 
			"            AND t_institute_quality.del_status = 1 \n" + 
			"            AND t_institute_quality.is_active = 1  and t_institute_quality.year_id=m_academic_year.year_id AND m_academic_year.is_current=1    ),\n" + 
			"        'No'      ) AS q_status \n" + 
			"    FROM\n" + 
			"        m_institute,\n" + 
			"        m_quality_initiatives \n" + 
			"    WHERE\n" + 
			"        m_quality_initiatives.del_status = 1 \n" + 
			"        AND m_quality_initiatives.is_active = 1 "
			+ "		 AND m_institute.institute_id = :instId",nativeQuery=true)

	List<IQACQualInititive> getQualInitiative(@Param("instId")  int instId);

}

/*SELECT\n" + 
"    m_institute.institute_name,\n" + 
"    m_quality_initiatives.quality_initiative_id,\n" + 
"    m_quality_initiatives.quality_initiative_name,\n" + 
"    COALESCE(\n" + 
"        (\n" + 
"        SELECT\n" + 
"            'Yes' \n" + 
"        FROM\n" + 
"            t_institute_quality\n" + 
"        WHERE\n" + 
"            t_institute_quality.quality_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1\n" + 
"    ),\n" + 
"    'No' \n" + 
"    ) AS q_status\n" + 
"FROM\n" + 
"    m_institute,\n" + 
"    m_quality_initiatives\n" + 
"WHERE\n" + 
"    m_quality_initiatives.del_status = 1 AND m_quality_initiatives.is_active = 1 AND m_institute.institute_id = :instId*/