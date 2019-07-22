package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FacAgnstSanctnPostOthrState;

public interface FacAgnstSanctnPostOthrStateRepo extends JpaRepository<FacAgnstSanctnPostOthrState, Integer> {

	@Query(value="SELECT UUID() as uniq_id, m_institute.institute_name,m_academic_year.year_id,m_academic_year.academic_year,\n" + 
			"COALESCE(( SELECT COUNT(*) FROM m_faculty WHERE m_faculty.institute_id=m_institute.institute_id AND m_faculty.is_same=0 AND m_faculty.del_status=1 and m_faculty.is_active=1),0) as no_of_other_state_fac,\n" + 
			"COALESCE(( SELECT t_institute_info_detail.ex_int1 from t_institute_info_detail\n" + 
			"WHERE t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.del_status=1 AND t_institute_info_detail.year_id=m_academic_year.year_id),0) as sanctioned_post                  \n" + 
			"FROM m_institute,m_academic_year WHERE m_institute.institute_id=:instId and m_academic_year.year_id=:acYear",nativeQuery=true)
	List<FacAgnstSanctnPostOthrState> getAllFacultyAgnstSanctionPostOthrState(@Param("instId")int instId,@Param("acYear") int acYear);

}


/*SELECT UUID() as uniq_id, m_institute.institute_name,m_academic_year.year_id,m_academic_year.academic_year,\n" + 
"COALESCE(( SELECT COUNT(*) FROM m_faculty WHERE m_faculty.institute_id=m_institute.institute_id AND m_faculty.is_same=0 AND m_faculty.highest_qualification=:stkId AND m_faculty.del_status=1 and m_faculty.is_active=1),0) as no_of_other_state_fac,\n" + 
"COALESCE(( SELECT t_institute_info_detail.ex_int1 from t_institute_info_detail\n" + 
"WHERE t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.del_status=1 AND t_institute_info_detail.year_id=m_academic_year.year_id),0) as sanctioned_post                  \n" + 
"FROM m_institute,m_academic_year WHERE m_institute.institute_id=:instId and m_academic_year.year_id=:acYear*/