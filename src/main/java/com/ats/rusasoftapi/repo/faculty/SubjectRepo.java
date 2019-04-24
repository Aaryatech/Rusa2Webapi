package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_subject SET del_status=0 WHERE sub_id IN (:subIdList) ", nativeQuery = true)
	int deleteSubjects(@Param("subIdList") List<String> subIdList);

	Subject findBySubIdAndDelStatus(int subId, int i);

	List<Subject> findByDelStatusOrderBySubIdDesc(int i);

}
