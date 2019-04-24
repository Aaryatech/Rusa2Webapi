package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetStudAdmLocwise;

public interface GetStudAdmLocwiseRepo extends JpaRepository<GetStudAdmLocwise, Integer> {

	@Query(value = " SELECT t_program_student_location.student_loc_id,t_program_student_location.location_id, m_location.location_name,"
			+ " t_program_student_location.male_student,t_program_student_location.female_student,"
			+ " t_program_student_location.trans_student,  t_program_student_location.loc_tot_student "
			+ " FROM t_program_student_location LEFT JOIN  m_location "
			+ " ON t_program_student_location.location_id=m_location.location_id "
			+ " WHERE t_program_student_location.is_active=1 AND t_program_student_location.del_status=1 "
			+ " AND t_program_student_location.year_id=:yearId AND t_program_student_location.institute_id=:instId "
			+ " ORDER BY t_program_student_location.student_loc_id DESC  ", nativeQuery = true)
	
	
	List<GetStudAdmLocwise> getStudAdmLocwise(@Param("instId") int instId, @Param("yearId") int yearId);

	@Query(value = " SELECT t_program_student_location.student_loc_id,t_program_student_location.location_id, m_location.location_name,"
			+ " t_program_student_location.male_student,t_program_student_location.female_student,"
			+ " t_program_student_location.trans_student,  t_program_student_location.loc_tot_student "
			+ " FROM t_program_student_location LEFT JOIN  m_location "
			+ " ON t_program_student_location.location_id=m_location.location_id "
			+ " WHERE t_program_student_location.is_active=1 AND t_program_student_location.del_status=1 "
			+ " AND t_program_student_location.year_id=:yearId AND t_program_student_location.institute_id=:instId "
			+ " AND t_program_student_location.program_id=:progType ORDER BY t_program_student_location.student_loc_id DESC  ", nativeQuery = true)
	
	
	List<GetStudAdmLocwise> getStudAdmLocwiseByProgType(@Param("instId") int instId, @Param("yearId") int yearId, @Param("progType") int progType);

}
