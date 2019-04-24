package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.Disctinctveness;

public interface DisctinctvenessRepo extends JpaRepository<Disctinctveness, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_distinctiveness SET del_status=0 WHERE dist_id IN (:distIdList) ", nativeQuery = true)
	int deleteDists(@Param("distIdList") List<String> distIdList);

	Disctinctveness findByDistIdAndDelStatus(int distId, int i);

}
