package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetHigherEduDetail;

public interface GetHigherEduDetailRepo extends JpaRepository<GetHigherEduDetail, Integer> {

	@Query(value = " SELECT t_higher_education_detail.education_detail_id, t_higher_education_detail.no_student, "
			+ " COALESCE((SELECT m_program_type.program_name from m_program_type WHERE m_program_type.program_id=t_higher_education_detail.program_type AND m_program_type.del_status=1 AND m_program_type.is_active=1 ),null) AS from_prog_type,"
			+ " COALESCE((SELECT m_program_type.program_name FROM m_program_type WHERE m_program_type.program_id=t_higher_education_detail.proceeding_to AND m_program_type.del_status=1 AND m_program_type.is_active=1 ),null) AS to_prog_type "
			+ " FROM t_higher_education_detail WHERE t_higher_education_detail.year_id=:yearId AND t_higher_education_detail.institute_id=:instId AND t_higher_education_detail.del_status=1 AND t_higher_education_detail.is_active=1 ORDER BY t_higher_education_detail.education_detail_id DESC ", nativeQuery = true)

	List<GetHigherEduDetail> getHigherEduDetail(@Param("instId") int instId, @Param("yearId") int yearId);

}
