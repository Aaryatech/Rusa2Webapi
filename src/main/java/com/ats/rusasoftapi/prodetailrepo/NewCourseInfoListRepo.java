package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.NewCourseInfoList;

public interface NewCourseInfoListRepo extends JpaRepository<NewCourseInfoList, Integer> {
	@Query(value="SELECT course.course_id," + 
			"	t.name_of_program as prog_name," + 
			"    prgType.program_name as prog_type," + 
			"	course.applicable_year," + 
			"    course.course_name," + 
			"    course.course_code," + 
			"    acdYear.academic_year as introduce_from," + 
			"    course.document" + 
			"    " + 
			"FROM new_course_info course," + 
			"	m_program_type prgType," + 
			"    t_program t," + 
			"    m_academic_year acdYear" + 
			"        " + 
			"WHERE course.inst_id=:instId AND course.del_status=1 AND" + 
			"	course.prog_type=prgType.program_id AND" + 
			"    course.prog_name=t.program_id AND" + 
			"    course.introduce_from=acdYear.year_id" + 
			"    AND course.introduce_from=:yearId" + 
			"    ORDER BY course.course_id DESC",nativeQuery=true)
	List<NewCourseInfoList> getAllByInstituteAndAcadmicYear(int instId, int yearId);

}
