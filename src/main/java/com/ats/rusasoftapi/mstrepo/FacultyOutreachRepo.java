package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyOutreach;

public interface FacultyOutreachRepo extends JpaRepository<FacultyOutreach, Integer> {

	List<FacultyOutreach> findByDelStatusAndIsActive(int i, int j);

	FacultyOutreach findByOutreachIdAndDelStatus(int outreachId, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_outreach SET del_status=0 WHERE outreach_id IN (:outreachId) ", nativeQuery = true)
	int deleteOutReach(@Param("outreachId") int outreachId);

	@Query(value = " SELECT * FROM t_faculty_outreach o WHERE o.del_status=1 AND o.faculty_id=:facultyId AND o.is_active=1 ORDER BY o.outreach_id DESC ", nativeQuery = true)
	List<FacultyOutreach> getOutReachRepo(@Param("facultyId") int facultyId);

}
