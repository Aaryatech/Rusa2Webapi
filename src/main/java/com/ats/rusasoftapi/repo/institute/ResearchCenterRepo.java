package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.ResearchCenter;

public interface ResearchCenterRepo extends JpaRepository<ResearchCenter, Integer> {

	ResearchCenter findByRcIdAndDelStatus(int rcId, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_research_center SET del_status=0 WHERE rc_id IN (:rcIdList) ", nativeQuery = true)
	int deleteResearchCenter(@Param("rcIdList") List<String> rcIdList);
}
