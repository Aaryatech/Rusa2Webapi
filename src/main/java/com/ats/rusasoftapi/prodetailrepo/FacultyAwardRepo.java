package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.FacultyAward;

public interface FacultyAwardRepo extends JpaRepository<FacultyAward, Integer>{

	List<FacultyAward> findByDelStatusAndIsActive(int i, int j);

	FacultyAward findByAwardIdAndDelStatus(int patentId, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_faculty_award SET del_status=0 WHERE award_id IN (:awardId) ", nativeQuery = true)
	int deleteAward(@Param("awardId") int awardId);

	@Query(value = " SELECT * FROM t_faculty_award a WHERE a.del_status=1 AND a.faculty_id=:facultyId AND a.is_active=1 ORDER BY a.award_id DESC ", nativeQuery = true)
	List<FacultyAward> getAwardRepo(@Param("facultyId") int facultyId);

}
