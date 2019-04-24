package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.SubjectCo;

public interface SubjectCoRepo extends JpaRepository<SubjectCo, Integer>{

	List<SubjectCo> findBySubIdAndDelStatusAndIsActiveAndFacultyIdOrderByCoIdDesc(int subId, int i, int j, int facultyId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_subject_co SET del_status=0 WHERE co_id IN (:coId) ", nativeQuery = true)
	int deleteSubjects(@Param("coId") int coId);

	SubjectCo findByCoIdAndDelStatusAndIsActive(int coId, int i, int j);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_subject_co SET co_name=:coName WHERE co_id IN (:coId) ", nativeQuery = true)
	int updateSubjeCoName(@Param("coName") String coName,@Param("coId") int coId);

}
