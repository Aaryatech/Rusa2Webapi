package com.ats.rusasoftapi.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.StudTeachrRatio;

public interface StudTeachrRatioRepo extends JpaRepository<StudTeachrRatio, Integer> {

	@Query(value="SELECT UUID() AS uniq_id,t_institute_info_detail.info_detail_id, t_institute_info_detail.no_of_fulltime_faculty,t_institute_info_detail.no_current_admited_stnt, m_academic_year.academic_year,"
			+ "m_institute.institute_name From m_institute, t_institute_info_detail, m_academic_year "
			+ "WHERE t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.year_id=m_academic_year.year_id "
			+ "AND t_institute_info_detail.del_status=1 AND t_institute_info_detail.institute_id=:instId AND t_institute_info_detail.year_id=:acYear",nativeQuery=true)
	List<StudTeachrRatio> getAllStudentTeacherRatioData(@Param("instId") int instId, @Param("acYear") int acYear);

}
