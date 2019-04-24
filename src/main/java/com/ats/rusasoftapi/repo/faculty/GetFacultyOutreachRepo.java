package com.ats.rusasoftapi.repo.faculty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.faculty.GetFacultyOutreach;
import com.ats.rusasoftapi.model.faculty.GetSubject;


public interface GetFacultyOutreachRepo extends JpaRepository<GetFacultyOutreach, Integer>  {
	

	@Query(value = "SELECT t_faculty_outreach.outreach_id,t_faculty_outreach.outreach_name,t_faculty_outreach.outreach_date,"
			+ "t_faculty_outreach.outreach_level ,m_outreach_type.type_name from t_faculty_outreach,m_outreach_type "
			+ " WHERE  t_faculty_outreach.outreach_type=m_outreach_type.type_id and t_faculty_outreach.del_status=1 and "
			+ "t_faculty_outreach.faculty_id=:facultyId and t_faculty_outreach.is_active=1 and  t_faculty_outreach.institute_id=:instituteId ORDER BY t_faculty_outreach.outreach_id DESC", nativeQuery = true)
	List<GetFacultyOutreach> getOutreachList(@Param("facultyId") int facultyId,@Param("instituteId") int instituteId);


}
