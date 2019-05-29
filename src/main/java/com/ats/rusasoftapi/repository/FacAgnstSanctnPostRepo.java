package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FacAgnstSanctnPost;

public interface FacAgnstSanctnPostRepo extends JpaRepository<FacAgnstSanctnPost, Integer> {

	@Query(value="SELECT UUID() as uniq_id, m_institute.institute_name, m_academic_year.academic_year,t_institute_info_detail.year_id,t_institute_info_detail.info_detail_id,"
			+ "t_institute_info_detail.no_of_fulltime_faculty,t_institute_info_detail.ex_int1 as sanctioned_post FROM t_institute_info_detail,m_institute,"
			+ "m_academic_year WHERE t_institute_info_detail.institute_id=m_institute.institute_id and t_institute_info_detail.del_status=1 and "
			+ "t_institute_info_detail.year_id=m_academic_year.year_id AND t_institute_info_detail.institute_id=:instId AND m_academic_year.year_id IN (:acYearList)",
			nativeQuery=true)
	List<FacAgnstSanctnPost> getAllFacAgnstSanctnPost(int instId, @Param("acYearList") List<Integer> acYearList);
}
