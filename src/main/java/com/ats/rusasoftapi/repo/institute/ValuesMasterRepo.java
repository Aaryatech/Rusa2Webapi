package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.ValuesMaster;

public interface ValuesMasterRepo extends JpaRepository<ValuesMaster, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE md_values_master SET del_status=0 WHERE val_mast_id IN (:valIdList) ", nativeQuery = true)
	int deleteValuesMaster(@Param("valIdList") List<String> valIdList);

	ValuesMaster findByValMastIdAndDelStatus(int valMstId, int i);

	List<ValuesMaster> findByDelStatusAndIsActiveOrderByValMastIdDesc(int i, int j);

}
