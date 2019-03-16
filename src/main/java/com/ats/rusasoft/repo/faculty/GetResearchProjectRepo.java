package com.ats.rusasoft.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.faculty.GetResearchProject;

public interface GetResearchProjectRepo extends JpaRepository<GetResearchProject, Integer> {

	@Query(value = " SELECT * FROM t_faculty_project WHERE t_faculty_project.del_status=1 AND t_faculty_project.faculty_id=:facultyId AND t_faculty_project.is_active=1 ORDER BY t_faculty_project.proj_id DESC   ", nativeQuery = true)
	List<GetResearchProject> getProjectList(@Param("facultyId") int facultyId);

}
