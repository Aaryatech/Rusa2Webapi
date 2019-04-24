package com.ats.rusasoftapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.TFacultyStudLinkage;

public interface TFacultyStudLinkageRepo extends JpaRepository<TFacultyStudLinkage, Integer> {
	
	List<TFacultyStudLinkage> findByInstIdAndDelStatusOrderByFacultyStudLinkageIdDesc(@Param("instituteId") int instituteId, @Param("i") int i);
	
	TFacultyStudLinkage findByFacultyStudLinkageId(@Param("linkId")int linkId);


	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_stud_linkage SET del_status = 0 WHERE faculty_stud_linkage_id=:linkId",nativeQuery=true)
	int deleteFacStudLinkById(@Param("linkId")int linkId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_faculty_stud_linkage SET del_status=0  WHERE faculty_stud_linkage_id IN (:linkageIdsList)",nativeQuery=true)
	int deleteLinks(List<String> linkageIdsList);
	
}
