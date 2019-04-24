package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstitueVision;

public interface IntituteisionRepository extends JpaRepository<InstitueVision, Integer>{

	List<InstitueVision> findByDelStatusAndIsActiveAndInstituteIdOrderByInstVisionIdDesc(int i, int j, int instituteId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_institute_vision SET del_status=0 WHERE inst_vision_id IN (:instVisionId) ", nativeQuery = true)
	int deleteInstiuteVision(@Param("instVisionId") int instVisionId);

	InstitueVision findByInstVisionId(int instVisionId);

}
