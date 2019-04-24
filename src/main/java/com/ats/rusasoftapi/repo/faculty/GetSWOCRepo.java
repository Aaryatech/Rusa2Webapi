package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetSWOC;

public interface GetSWOCRepo extends JpaRepository<GetSWOC, Integer> {

	@Query(value = " SELECT j.*,f.faculty_first_name,d.dept_name FROM t_faculty_swoc j,m_faculty f,m_dept d WHERE j.del_status=1 AND j.faculty_id IN(:facultyId)\n"
			+ " AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND f.institute_id=:instituteId AND j.swoc_type=:type  ORDER BY j.swoc_id DESC ", nativeQuery = true)
	List<GetSWOC> getSwocList(@Param("facultyId") int facultyId, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId, @Param("type") int type);

	@Query(value = "  SELECT j.*,f.faculty_first_name,d.dept_name FROM t_faculty_swoc j,m_faculty f,m_dept d WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId  AND j.swoc_type=:type ORDER BY j.swoc_id DESC ", nativeQuery = true)
	List<GetSWOC> getSwocListByDept(@Param("deptIdList") List<Integer> deptIdList, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId, @Param("type") int type);

	@Query(value = "  SELECT j.*,f.faculty_first_name,d.dept_name FROM t_faculty_swoc j,m_faculty f,m_dept d WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id  AND f.institute_id=:instituteId  AND j.swoc_type=:type ORDER BY j.swoc_id DESC ", nativeQuery = true)
	List<GetSWOC> getSwocListYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId,
			@Param("type") int type);

}
