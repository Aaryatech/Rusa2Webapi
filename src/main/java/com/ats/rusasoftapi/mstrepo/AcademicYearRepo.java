package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.AcademicYear;
import com.ats.rusasoftapi.model.report.FacParticipationInBodies;



public interface AcademicYearRepo extends JpaRepository<AcademicYear, Integer>  {

	List<AcademicYear> findByTypeAndDelStatusOrderByYearIdDesc(int type, int i);
	
	AcademicYear findByYearIdAndDelStatus(int yearId, int delStatus);

	AcademicYear findByIsCurrentAndDelStatus(int isCurrent, int delStatus);
	
	@Query(value=" SELECT * FROM m_academic_year where m_academic_year.seq_no <= " + 
			" (select m_academic_year.seq_no from m_academic_year where m_academic_year.is_current=1)" + 
			" AND m_academic_year.del_status=1 order by seq_no desc limit 5",nativeQuery=true)

	List<AcademicYear> getLastFiveYears();
}
