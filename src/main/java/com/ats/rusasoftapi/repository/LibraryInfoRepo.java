package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.LibraryInfo;

public interface LibraryInfoRepo extends JpaRepository<LibraryInfo, Integer> {
	
	List<LibraryInfo> findByInstituteIdAndDelStatusOrderByLibInfoIdDesc(int instituteId, int del);

	LibraryInfo findByLibInfoId(int libInfoId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_library_info SET del_status=0 WHERE lib_info_id=:libInfoId",nativeQuery = true)
	int deleteLibraryBasicInfoById(@Param("libInfoId") int libInfoId);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_library_info SET del_status=0  WHERE lib_info_id IN (:libIdList) ",nativeQuery=true)
	int deleteLibInfo(@Param("libIdList") List<String> libIdList);

	LibraryInfo findByInstituteIdAndAcYearIdAndDelStatus(int instituteId, int acadYear, int del);

	@Query(value="SELECT * FROM m_library_info WHERE institute_id=:instituteId AND del_status=1 ORDER BY lib_info_id DESC LIMIT 1",nativeQuery=true)
	LibraryInfo getLastYerRecord(@Param("instituteId") int instituteId);
}
