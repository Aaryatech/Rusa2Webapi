package com.ats.rusasoft.repo.faculty;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.faculty.SWOC;

public interface SWOCRepo extends JpaRepository<SWOC, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_swoc SET del_status=0 WHERE swoc_id IN (:swocIdList) ", nativeQuery = true)
	int deleteSWOC(@Param("swocIdList") List<String> swocIdList);

	SWOC findBySwocIdAndDelStatus(int swocId, int i);

	List<SWOC> findByFacultyIdAndDelStatus(int facultyId, int i);

}
