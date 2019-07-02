package com.ats.rusasoftapi.graphrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.GetCountsForDash;

public interface TempDashBoardGraphRepo extends JpaRepository<GetCountsForDash, Integer>{

	//For Total Student Passed And Student Appeared for Subject Taughted By Facilty
	
	//Research Project Title
	@Query(value="SELECT UUID() AS id," + 
			"	0 as count," + 
			"   0 as count1," + 
			"	t_faculty_project.proj_name as data1," + 
			"	0 as data2 " + 
			"FROM " + 
			"	t_faculty_project, m_academic_year, m_faculty " + 
			"WHERE" + 
			"	t_faculty_project.faculty_id=m_faculty.faculty_id AND " + 
			"	t_faculty_project.year_id=m_academic_year.year_id AND" + 
			"   t_faculty_project.del_status=1 AND" + 
			"   m_academic_year.is_current=1 AND" + 
			"   m_faculty.institute_id=:instId" + 
			"	ORDER BY t_faculty_project.proj_id LIMIT 1", nativeQuery=true)
	GetCountsForDash getCurrentResrchProjrectTitle(@Param("instId") int instId);

	
	//No. of Research Publication
	@Query(value="SELECT UUID() AS id, COUNT(t_faculty_conference.conf_id) as count," + 
			"	 0 as count1 ," + 
			"    0 as data1," + 
			"    0 as data2 " + 
			"FROM" + 
			"	 t_faculty_conference," + 
			"    m_academic_year," + 
			"    m_faculty " + 
			"WHERE"+
			"	  t_faculty_conference.faculty_id=m_faculty.faculty_id AND" + 
			"	  t_faculty_conference.year_id=m_academic_year.year_id AND" + 
			"     t_faculty_conference.del_status=1 AND" + 
			"     m_academic_year.is_current=1 AND" + 
			"     m_faculty.institute_id=:instId " + 
			"     ORDER BY t_faculty_conference.conf_id LIMIT 1",nativeQuery=true)
	GetCountsForDash getNoResrchPubDetail(@Param("instId") int instId);


	//No. of Research Publication
	
	@Query(value="SELECT UUID() AS id, " + 
			"		COUNT(t_faculty_book.book_id) as count," + 
			"        0 as count1 ," + 
			"        0 as data1," + 
			"        0 as data2 " + 
			"FROM " + 
			"		t_faculty_book, " + 
			"		m_academic_year," + 
			"		m_faculty " + 
			"WHERE " + 
			"		t_faculty_book.faculty_id=m_faculty.faculty_id AND" + 
			"        t_faculty_book.year_id=m_academic_year.year_id AND" + 
			"        t_faculty_book.del_status=1 AND" + 
			"        m_academic_year.is_current=1 AND" + 
			"        m_faculty.institute_id=:instId" + 
			"        ORDER BY t_faculty_book.book_id LIMIT 1", nativeQuery=true)
	GetCountsForDash getNoBookPublished(@Param("instId") int instId);

// No. of Patent Filed
	@Query(value="SELECT UUID() AS id, " + 
			"	COUNT(t_faculty_patent.patent_id) as count," + 
			"   0 as count1 ," + 
			"   0 as data1," + 
			"   0 as data2 " + 
			"FROM " + 
			"	t_faculty_patent, " + 
			"	m_academic_year," + 
			"	m_faculty " + 
			"WHERE " + 
			"	t_faculty_patent.faculty_id=m_faculty.faculty_id AND" + 
			"    t_faculty_patent.year_id=m_academic_year.year_id AND" + 
			"    t_faculty_patent.del_status=1 AND" + 
			"    m_academic_year.is_current=1 AND" + 
			"    m_faculty.institute_id=:instId" + 
			"    ORDER BY t_faculty_patent.patent_id LIMIT 1",nativeQuery=true)
	GetCountsForDash getNoPatentFiled(@Param("instId") int instId);	
	
}
