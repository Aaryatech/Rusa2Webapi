package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.LibraryInfo;

public interface LibraryInfoRepo extends JpaRepository<LibraryInfo, Integer> {
	
	List<LibraryInfo> findByInstituteIdAndDelStatusOrderByLibInfoIdDesc(int instituteId, int del);

	LibraryInfo findByLibInfoId(int libInfoId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_library_info SET del_status=0 WHERE lib_info_id=:libInfoId ",nativeQuery = true)
	int deleteLibraryBasicInfoById(int libInfoId);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_library_info SET del_status=0  WHERE lib_info_id IN (:libIdList) ",nativeQuery=true)
	int deleteLibInfo(List<String> libIdList);
}
