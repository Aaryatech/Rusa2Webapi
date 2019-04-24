package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.ResearchProject;

public interface ResearchProjectRepo extends JpaRepository<ResearchProject, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_project SET del_status=0 WHERE proj_id IN (:projIdList) ", nativeQuery = true)
	int deleteResearchDetails(@Param("projIdList") List<String> projIdList);

	List<ResearchProject> findByFacultyIdAndDelStatusOrderByProjIdDesc(int facultyId, int i);

	ResearchProject findByProjIdAndDelStatus(int projectId, int i);

}
