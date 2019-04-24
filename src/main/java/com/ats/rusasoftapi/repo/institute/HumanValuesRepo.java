package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.HumanValues;

public interface HumanValuesRepo extends JpaRepository<HumanValues, Integer> {

	HumanValues findByValueIdAndDelStatus(int valueId, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE institute_values_promotion SET del_status=0 WHERE value_id IN (:valueIdList) ", nativeQuery = true)
	int deleteHumanValues(@Param("valueIdList") List<String> valueIdList);

}
