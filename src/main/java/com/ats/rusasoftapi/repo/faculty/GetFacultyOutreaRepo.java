package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetFacultyOutrea;

public interface GetFacultyOutreaRepo extends JpaRepository<GetFacultyOutrea, Integer> {

	@Query(value = " SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_outreach j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1 AND j.faculty_id IN(:facultyId)\n"
			+ " AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND f.institute_id=:instituteId AND  j.outreach_type=m_outreach_type.type_id  ORDER BY j.outreach_id DESC ", nativeQuery = true)
	List<GetFacultyOutrea> getOutReachList(@Param("facultyId") int facultyId, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId);

	@Query(value = "  SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_outreach j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId AND  j.outreach_type=m_outreach_type.type_id  ORDER BY j.outreach_id DESC ", nativeQuery = true)
	List<GetFacultyOutrea> getOutReachListByDept(@Param("deptIdList") List<Integer> deptIdList,
			@Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value = "  SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_outreach j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id  AND f.institute_id=:instituteId AND  j.outreach_type=m_outreach_type.type_id ORDER BY j.outreach_id DESC ", nativeQuery = true)
	List<GetFacultyOutrea> getOutReachListYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);

}
