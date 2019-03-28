package com.ats.rusasoft.instprofilerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.instprofile.GetInstituteQuality;

public interface GetInstituteQualityRepo extends JpaRepository<GetInstituteQuality, Integer> {

	@Query(value = " SELECT t_institute_quality.quality_id, t_institute_quality.quality_initiative_id,	t_institute_quality.quality_fromdt,t_institute_quality.quality_todt,t_institute_quality.quality_pcount,"
			+ " m_quality_initiatives.quality_initiative_name "
			+ " FROM t_institute_quality  LEFT JOIN m_quality_initiatives "
			+ " ON t_institute_quality.quality_initiative_id=m_quality_initiatives.quality_initiative_id\n"
			+ " WHERE t_institute_quality.del_status=1 AND t_institute_quality.is_active=1 AND t_institute_quality.institute_id=:instId "
			+ " AND t_institute_quality.year_id=:yearId ORDER BY t_institute_quality.quality_id DESC ", nativeQuery = true)

	List<GetInstituteQuality> getInstituteQualityList(@Param("instId") int instId, @Param("yearId") int yearId);

	@Query(value = " SELECT t_institute_quality.quality_id, t_institute_quality.quality_initiative_id,	t_institute_quality.quality_fromdt,t_institute_quality.quality_todt , "
			+ "t_institute_quality.quality_pcount,"
			+ " m_quality_initiatives.quality_initiative_name "
			+ " FROM t_institute_quality  LEFT JOIN m_quality_initiatives "
			+ " ON t_institute_quality.quality_initiative_id=m_quality_initiatives.quality_initiative_id "
			+ " WHERE t_institute_quality.quality_id=:qualityId ", nativeQuery = true)
	GetInstituteQuality getInstituteQualityById(@Param("qualityId") int qualityId);

}