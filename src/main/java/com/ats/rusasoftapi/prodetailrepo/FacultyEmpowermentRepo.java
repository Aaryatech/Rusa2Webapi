package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.FacultyEmpowerment;

public interface FacultyEmpowermentRepo extends JpaRepository<FacultyEmpowerment, Integer> {

	List<FacultyEmpowerment> findByInstIdAndAcYearIdAndDelStatusOrderByFacultyEmpwrmntIdDesc(int instituteId, int yearId,int i);

	FacultyEmpowerment findByFacultyEmpwrmntId(int facEmpwrId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE faculty_empowerment SET del_status=0 WHERE faculty_empwrmnt_id =:facEmpwrId", nativeQuery = true)
	int deleteFacultyEmpowr(@Param("facEmpwrId") int facEmpwrId);

	/*@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_outreach SET del_status=0 WHERE faculty_empwrmnt_id IN (:facEmpwrId) ", nativeQuery = true)*/
}
