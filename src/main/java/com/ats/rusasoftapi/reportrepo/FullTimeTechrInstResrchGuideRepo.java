package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FullTimeTechrInstResrchGuide;

public interface FullTimeTechrInstResrchGuideRepo extends JpaRepository<FullTimeTechrInstResrchGuide, Integer> {

	@Query(value="SELECT UUID() AS uniq_id," + 
			"COUNT(m_faculty.is_phd_guide) as no_research_guide," + 
			"t_institute_info_detail.no_of_fulltime_faculty as full_time_teacher," + 
			"m_academic_year.academic_year," + 
			"m_institute.institute_name " + 
			"FROM m_faculty, t_institute_info_detail, m_academic_year, m_institute " + 
			"WHERE m_faculty.del_status=1 AND m_faculty.is_active=1 AND " + 
			"t_institute_info_detail.del_status=1 AND " + 
			"m_institute.institute_id=m_faculty.institute_id AND " + 
			"t_institute_info_detail.institute_id=m_institute.institute_id AND " + 
			"t_institute_info_detail.year_id=m_academic_year.year_id AND " + 
			"m_faculty.is_phd_guide=1 AND " + 
			"m_academic_year.year_id=:acYear AND " + 
			"m_institute.institute_id=:instId",nativeQuery=true)
	List<FullTimeTechrInstResrchGuide> getAllFullTimeTechrInstResrchGuide(@Param("acYear") int acYear, @Param("instId")int instId);
}
