package com.ats.rusasoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.SubjectCo;

public interface SubjectCoRepo extends JpaRepository<SubjectCo, Integer>{

	List<SubjectCo> findBySubIdAndDelStatusAndIsActiveAndFacultyId(int subId, int i, int j, int facultyId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_subject_co SET del_status=0 WHERE co_id IN (:coId) ", nativeQuery = true)
	int deleteSubjects(@Param("coId") int coId);

	SubjectCo findByCoIdAndDelStatusAndIsActive(int coId, int i, int j);

}