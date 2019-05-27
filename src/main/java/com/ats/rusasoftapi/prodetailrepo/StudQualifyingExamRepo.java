package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.StudQualifyingExam;

public interface StudQualifyingExamRepo extends JpaRepository<StudQualifyingExam, Integer> {

	
	List<StudQualifyingExam> findByInstIdAndAcYearIdAndDelStatusOrderByStudExmIdDesc(int instituteId,  int yearId, int i);


	StudQualifyingExam findByStudExmId(int studExmId);

	@Transactional
	@Modifying
	@Query(value=" UPDATE  stud_qualifying_exam SET del_status = 0 WHERE stud_exm_id=:studExmId",nativeQuery=true)
	int deletetStudQualifiedExamDetail(@Param("studExmId") int studExmId);

	@Transactional
	@Modifying
	@Query(value="UPDATE stud_qualifying_exam SET del_status=0  WHERE stud_exm_id IN (:studQlfExmIdList)",nativeQuery=true)
	int deletetSelStudQlifExmInfo(@Param("studQlfExmIdList") List<String> studQlfExmIdList);
	
}
