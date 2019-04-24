package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetFacultyActivity;

public interface GetFacultyActivityRepo extends JpaRepository<GetFacultyActivity, Integer> {

	@Query(value = " SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_activity j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1 AND j.faculty_id IN(:facultyId)\n"
			+ " AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND f.institute_id=:instituteId AND  j.activity_type=m_outreach_type.type_id  ORDER BY j.activity_id DESC ", nativeQuery = true)
	List<GetFacultyActivity> getActivityList(@Param("facultyId") int facultyId, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId);

	@Query(value = "  SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_activity j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId AND  j.activity_type=m_outreach_type.type_id  ORDER BY j.activity_id DESC ", nativeQuery = true)
	List<GetFacultyActivity> getActivityListByDept(@Param("deptIdList") List<Integer> deptIdList,
			@Param("yearId") int yearId, @Param("instituteId") int instituteId);

	@Query(value = "  SELECT j.*,m_outreach_type.type_name,f.faculty_first_name,d.dept_name FROM t_faculty_activity j,m_faculty f,m_dept d,m_outreach_type WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id  AND f.institute_id=:instituteId AND  j.activity_type=m_outreach_type.type_id ORDER BY j.activity_id DESC ", nativeQuery = true)
	List<GetFacultyActivity> getActivityListYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);

}
