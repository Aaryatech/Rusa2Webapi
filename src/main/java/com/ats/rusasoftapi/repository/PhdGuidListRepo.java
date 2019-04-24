package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.PhdGuidList;

public interface PhdGuidListRepo extends JpaRepository<PhdGuidList, Integer>{
	@Modifying
	@Query(value=" SELECT phd.phd_id, phd.co_guide_name, phd.phd_scholar_name, phd.phd_topic,\n" + 
			" COALESCE((SELECT m_academic_year.academic_year FROM m_academic_year WHERE phd.phd_reg_year=m_academic_year.year_id),null) as phd_reg_year,\n" + 
			" COALESCE((SELECT m_academic_year.academic_year FROM m_academic_year WHERE phd.phd_awarded_year=m_academic_year.year_id),null) as phd_awarded_year\n" + 
			" FROM t_faculty_phdguide phd where phd.faculty_id=:facId  and phd.year_id=:yId and phd.del_status=:del ORDER BY phd.phd_id DESC",nativeQuery=true)
	List<PhdGuidList> findByFacultyIdAndYearIdAndDelStatusOrderByPhdIdDesc(@Param("facId")int facId, @Param("yId")int yId, @Param("del")int del);
	
}
