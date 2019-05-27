package com.ats.rusasoftapi.prodetailrepo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.NewCourseInfo;

public interface NewCourseInfoRepo extends JpaRepository<NewCourseInfo, Integer> {

	NewCourseInfo findByCourseId(int courseId);

	@Transactional
	@Modifying
	@Query(value="UPDATE new_course_info SET del_status = 0 WHERE course_id=:courseId",nativeQuery=true)
	int deleteCourseInfo(@Param("courseId")int courseId);

	

}
