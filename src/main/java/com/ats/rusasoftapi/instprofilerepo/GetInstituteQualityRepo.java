package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.GetInstituteQuality;

public interface GetInstituteQualityRepo extends JpaRepository<GetInstituteQuality, Integer> {

	@Query(value = " SELECT\n" + 
			"        t_institute_quality.quality_id," + 
			"        t_institute_quality.quality_initiative_id," + 
			"        t_institute_quality.ex_int1," +	//cycle 
			"        t_institute_quality.ex_var1," + 
			"        t_institute_quality.ex_var2," + 	//NAAC Score
			"        t_institute_quality.quality_fromdt," + 
			"        t_institute_quality.quality_todt," + 
			"        t_institute_quality.quality_pcount," + 
			"        t_institute_quality.is_applicable," + 
			"        t_institute_quality.is_applied," + 
			"        t_institute_quality. is_certi_obt ," + 
			"        t_institute_quality.autonomy_validity," +
			"        case WHEN t_institute_quality.quality_initiative_id=0 THEN (SELECT t.ex_var1 FROM t_institute_quality t WHERE t.quality_id=t_institute_quality.quality_id) ELSE \n" + 
			"        (SELECT m_quality_initiatives.quality_initiative_name FROM m_quality_initiatives WHERE m_quality_initiatives.quality_initiative_id=t_institute_quality.quality_initiative_id) end as quality_initiative_name" + 		
			"    FROM" + 
			"        t_institute_quality" + 
		
			"    WHERE" + 
			"        t_institute_quality.del_status=1" + 
			"        AND t_institute_quality.is_active=1" + 
			"        AND t_institute_quality.institute_id=:instId" + 
			"        AND t_institute_quality.year_id=:yearId" + 
			"    ORDER BY\n" + 
			"        t_institute_quality.quality_id DESC", nativeQuery = true)

	List<GetInstituteQuality> getInstituteQualityList(@Param("instId") int instId, @Param("yearId") int yearId);

	/*" SELECT t_institute_quality.quality_id, t_institute_quality.quality_initiative_id,t_institute_quality.ex_var1,	t_institute_quality.quality_fromdt,t_institute_quality.quality_todt,t_institute_quality.quality_pcount,"
			+ " m_quality_initiatives.quality_initiative_name "
			+ " FROM t_institute_quality  LEFT JOIN m_quality_initiatives "
			+ " ON t_institute_quality.quality_initiative_id=m_quality_initiatives.quality_initiative_id\n"
			+ " WHERE t_institute_quality.del_status=1 AND t_institute_quality.is_active=1 AND t_institute_quality.institute_id=:instId "
			+ " AND t_institute_quality.year_id=:yearId ORDER BY t_institute_quality.quality_id DESC "*/
	
	
	
	
	/*--------------------------------------------------------------------------------------------------------------*/ 
	@Query(value = "  SELECT" + 
			"        t_institute_quality.quality_id," + 
			"        t_institute_quality.quality_initiative_id," + 
			"        t_institute_quality.ex_var1," + 
			"        t_institute_quality.ex_var2," + 	//NAAC Score
			"        t_institute_quality.ex_int1," + 	// Cycle
			"        t_institute_quality.quality_fromdt," + 
			"        t_institute_quality.quality_todt ," + 
			"        t_institute_quality.quality_pcount," + 
			"        t_institute_quality.is_applicable," + 
			"        t_institute_quality.is_applied," + 
			"        t_institute_quality. is_certi_obt ," + 
			"        t_institute_quality.autonomy_validity ," + 
			"        m_quality_initiatives.quality_initiative_name  " + 
			"    FROM" + 
			"        t_institute_quality  " + 
			"    LEFT JOIN" + 
			"        m_quality_initiatives  " + 
			"        ON t_institute_quality.quality_initiative_id=m_quality_initiatives.quality_initiative_id  " + 
			"    WHERE" + 
			"       t_institute_quality.quality_id=:qualityId ", nativeQuery = true)
	GetInstituteQuality getInstituteQualityById(@Param("qualityId") int qualityId);

}
