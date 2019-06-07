package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.TechrResrchPaprJournlRatio;

public interface TechrResrchPaprJournlRatioRepo extends JpaRepository<TechrResrchPaprJournlRatio, Integer> {

	@Query(value="SELECT t_faculty_journal.year_id," + 
			"t_institute_info_detail.no_of_fulltime_faculty as full_time_teacher," + 
			"COUNT(t_faculty_journal.journal_type) AS published_in_ugc," + 
			"m_academic_year.academic_year," + 
			"m_institute.institute_name " + 
			"FROM t_faculty_journal, m_institute, m_academic_year, t_institute_info_detail,m_faculty " + 
			"WHERE t_faculty_journal.del_status=1 AND t_faculty_journal.is_active=1 AND " + 
			"t_institute_info_detail.del_status=1 AND " + 
			"t_faculty_journal.year_id=m_academic_year.year_id AND " + 
			"t_institute_info_detail.year_id=m_academic_year.year_id AND " + 
			"t_institute_info_detail.institute_id=m_institute.institute_id AND " + 
			"m_institute.institute_id=:instId AND " + 
			"m_academic_year.year_id IN (:lastFiveYears) AND " + 
			"t_faculty_journal.journal_type=0 AND " + 
			"t_faculty_journal.faculty_id=m_faculty.faculty_id AND m_faculty.institute_id=m_institute.institute_id " + 
			"GROUP BY t_faculty_journal.year_id",nativeQuery=true)
	
	List<TechrResrchPaprJournlRatio> getAllTechrResrchPaprJournlRatio(@Param("instId")int instId, @Param("lastFiveYears") List<Integer> lastFiveYears);
}
