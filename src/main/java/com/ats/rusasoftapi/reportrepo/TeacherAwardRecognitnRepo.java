package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.TeacherAwardRecognitn;

public interface TeacherAwardRecognitnRepo extends JpaRepository<TeacherAwardRecognitn, Integer> {
	
	@Query(value="SELECT  t_faculty_award.award_id," + 
			"	m_faculty.faculty_first_name," + 
			"    m_faculty.contact_no," + 
			"    m_faculty.f_address," + 
			"    t_faculty_award.award_name," + 
			"    t_faculty_award.award_authority," + 
			"    t_faculty_award.award_date," + 
			"    t_faculty_award.ex_var1 as incentive," + 
			"    m_academic_year.academic_year," + 
			"    m_institute.institute_name " + 
			"FROM t_faculty_award, m_academic_year, m_institute, m_faculty " + 
			"WHERE t_faculty_award.del_status=1 AND t_faculty_award.is_active=1 AND " + 
			"	t_faculty_award.faculty_id=m_faculty.faculty_id AND " + 
			"   t_faculty_award.year_id=m_academic_year.year_id AND " + 
			"   m_faculty.institute_id=m_institute.institute_id AND " + 
			"	m_faculty.institute_id=:instId AND " + 
			"   t_faculty_award.year_id=:acYear",nativeQuery=true)
	List<TeacherAwardRecognitn> getAllTeacherAwardRecognitn(@Param("acYear") int acYear,@Param("instId") int instId);

}
