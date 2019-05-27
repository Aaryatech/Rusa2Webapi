package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.ValueAddedCourses;

public interface ValueAddedCoursesRepo extends JpaRepository<ValueAddedCourses, Integer> {


	List<ValueAddedCourses> findByInstIdAndAcademicYearIdAndDelStatusOrderByValueAddedCourseIdDesc(int instId, int yearId, int i);

	ValueAddedCourses findByValueAddedCourseId(int courseId);

	@Transactional
	@Modifying
	@Query(value="UPDATE value_added_courses set del_status=0 WHERE value_added_course_id=:courseId",nativeQuery=true)
	int deleteValueAddedCourse(@Param("courseId") int courseId);
}
