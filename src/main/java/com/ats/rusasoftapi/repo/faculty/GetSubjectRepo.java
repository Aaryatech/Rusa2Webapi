package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetSubject;

public interface GetSubjectRepo extends JpaRepository<GetSubject, Integer> {

	@Query(value = " SELECT  concat(ptype.program_name ,'-' , p.name_of_program) as name_of_program,j.*,f.faculty_first_name,d.dept_name FROM t_faculty_subject j,m_faculty f,m_dept d,t_program p,m_program_type ptype WHERE j.del_status=1 AND j.faculty_id IN(:facultyId)\n"
			+ " AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND f.institute_id=:instituteId  AND j.prog_id=p.program_id AND p.program_type=ptype.program_id   ORDER BY j.sub_id DESC ", nativeQuery = true)
	List<GetSubject> getSubList(@Param("facultyId") int facultyId, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId);

	@Query(value = "  SELECT  concat(ptype.program_name ,'-' , p.name_of_program) as name_of_program,j.*,f.faculty_first_name,d.dept_name FROM t_faculty_subject j,m_faculty f,m_dept d ,t_program p,m_program_type ptype WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id AND d.dept_id IN(:deptIdList) AND f.institute_id=:instituteId AND j.prog_id=p.program_id AND p.program_type=ptype.program_id  ORDER BY j.sub_id DESC ", nativeQuery = true)
	List<GetSubject> getSubListByDept(@Param("deptIdList") List<Integer> deptIdList, @Param("yearId") int yearId,
			@Param("instituteId") int instituteId);

	@Query(value = "  SELECT concat(ptype.program_name ,'-' , p.name_of_program) as name_of_program,j.*,f.faculty_first_name,d.dept_name FROM t_faculty_subject j,m_faculty f,m_dept d ,t_program p,m_program_type ptype WHERE j.del_status=1  "
			+ "	  AND j.year_id=:yearId AND j.is_active=1 AND f.faculty_id=j.faculty_id AND f.dept_id=d.dept_id  AND f.institute_id=:instituteId AND j.prog_id=p.program_id AND p.program_type=ptype.program_id  ORDER BY j.sub_id DESC ", nativeQuery = true)
	List<GetSubject> getSubListYear(@Param("yearId") int yearId, @Param("instituteId") int instituteId);

}
