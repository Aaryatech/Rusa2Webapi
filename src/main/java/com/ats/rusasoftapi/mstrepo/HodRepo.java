package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.Hod;

public interface HodRepo extends JpaRepository<Hod, Integer> {

	Hod findByHodId(int hodId);

	List<Hod> findByInstituteIdAndIsActiveAndDelStatusOrderByHodIdDesc(int instId, int isActive, int delStatus);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_hod SET del_status=0 WHERE hod_id IN (:hodIdList) ", nativeQuery = true)
	int deleteHods(@Param("hodIdList") List<String> hodIdList);

	List<Hod> findByContactNoAndDelStatusAndIsActive(String contactNo, int delStatus, int isActive);

	List<Hod> findByContactNoAndDelStatusAndIsActiveAndHodIdNot(String contactNo, int delStatus, int isActive,
			int hodId);

	List<Hod> findByEmailAndDelStatusAndIsActive(String email, int delStatus, int isActive);

	List<Hod> findByEmailAndDelStatusAndIsActiveAndHodIdNot(String email, int delStatus, int isActive, int hodId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_hod SET is_active=0 WHERE hod_id =:hodId ", nativeQuery = true)
	int updateHod(@Param("hodId") int hodId);

}
