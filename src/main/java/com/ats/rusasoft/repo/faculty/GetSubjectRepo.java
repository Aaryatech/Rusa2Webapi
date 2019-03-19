package com.ats.rusasoft.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.faculty.GetSubject;

public interface GetSubjectRepo extends JpaRepository<GetSubject, Integer> {

	@Query(value = "select p.name_of_program,s.* from t_program p,t_faculty_subject s where s.prog_id=p.program_id and s.del_status=1 and s.is_active=1 and s.faculty_id=:facultyId "
			+ " and s.year_id=:yearId ORDER BY s.sub_id DESC ", nativeQuery = true)
	List<GetSubject> getProjectList(@Param("facultyId") int facultyId,@Param("yearId") int yearId);

}
