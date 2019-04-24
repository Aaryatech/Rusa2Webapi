package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudMentorList;

public interface StuedentMentorListRepo extends JpaRepository<StudMentorList, Integer> {
	
	@Query(value="SELECT m.men_id, m.faculty_id, m.year_id, m.men_stu_count, f.faculty_first_name, d.dept_name FROM m_faculty f,m_dept d, t_faculty_mentoring m WHERE m.del_status=1 AND m.is_active=1 AND f.faculty_id=m.faculty_id  AND f.dept_id=d.dept_id AND m.year_id=:yearId AND f.institute_id=:instituteId AND m.faculty_id=:facultyId ORDER BY m.men_id DESC",nativeQuery=true)
	public List<StudMentorList> getStudMentrByYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId, @Param("facultyId") int facultyId);
	
	
	@Query(value="SELECT m.men_id, m.faculty_id, m.year_id, m.men_stu_count, f.faculty_first_name, d.dept_name FROM m_faculty f,m_dept d,t_faculty_mentoring m WHERE m.del_status=1 AND m.is_active=1  AND f.faculty_id=m.faculty_id AND f.dept_id=d.dept_id AND m.year_id=:yearId AND f.institute_id=:instituteId AND d.dept_id IN(:deptIdList) ORDER BY m.men_id DESC",nativeQuery=true)
	public List<StudMentorList> getStudMentrByDept(@Param("deptIdList") List<Integer> deptIdList, @Param("yearId") int yearId, 
		@Param("instituteId") int instituteId);

	 @Query(value="SELECT m.men_id, m.faculty_id, m.year_id, m.men_stu_count, f.faculty_first_name, d.dept_name FROM m_faculty f,m_dept d,t_faculty_mentoring m WHERE m.del_status=1 AND m.is_active=1 AND f.faculty_id=m.faculty_id AND f.dept_id=d.dept_id AND m.year_id=:yearId AND f.institute_id=:instituteId AND m.faculty_id=:facultyId ORDER BY m.men_id DESC ",nativeQuery=true)
	 public List<StudMentorList> getListStudMentor(@Param("facultyId")int facultyId, @Param("yearId") int  yearId, @Param("instituteId") int instituteId);
	 
}



//public List<StudMentorList> getListFacultyMonitor(int facId,int yearId);
//SELECT m.men_id, m.men_stu_count, a.academic_year FROM t_faculty_mentoring m, m_academic_year a WHERE m.year_id=a.year_id AND faculty_id=:facId AND m.del_status=1 AND m.year_id=:yearId ORDER BY m.men_id DESC",nativeQuery=true)
