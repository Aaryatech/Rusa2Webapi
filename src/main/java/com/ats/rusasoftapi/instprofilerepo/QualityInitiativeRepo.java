package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.validator.constraints.Mod10Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.QualityInitiative;

public interface QualityInitiativeRepo extends JpaRepository<QualityInitiative, Integer>{
	
	QualityInitiative findByQualityInitiativeId(int qualityInitiativeId);
	
	List<QualityInitiative> findByDelStatusAndIsActiveOrderByQualityInitiativeIdDesc(int delStatus, int isActive);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE m_quality_initiatives SET del_status=0 WHERE quality_initiative_id IN (:qualityInitiativeIdList) ", nativeQuery = true)
	int deleteQualInititives(@Param("qualityInitiativeIdList") List<String> qualityInitiativeIdList);
	
}
