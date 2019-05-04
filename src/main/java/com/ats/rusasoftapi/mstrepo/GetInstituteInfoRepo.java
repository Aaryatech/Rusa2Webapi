package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetInstituteInfo;


public interface GetInstituteInfoRepo  extends JpaRepository<GetInstituteInfo, Integer>  {

	
	@Query(value=" SELECT t_institute_info_detail.info_detail_id,t_institute_info_detail.institute_id, t_institute_info_detail.ex_int1,"
			+ " t_institute_info_detail.no_of_fulltime_faculty, " 
			+ " t_institute_info_detail.no_nonteaching_including_office_staff,t_institute_info_detail.no_support_staff, "
			+ " t_institute_info_detail.no_current_admited_stnt,t_institute_info_detail.treasury_code, "
			+ " t_institute_info_detail.rusa_id_no,m_academic_year.academic_year from t_institute_info_detail, "
			+ " m_academic_year where t_institute_info_detail.del_status=1 and "
			+ " t_institute_info_detail.year_id=m_academic_year.year_id and t_institute_info_detail.institute_id=:instituteId "
			+ " AND t_institute_info_detail.year_id=:acadmicYear ORDER BY  t_institute_info_detail.info_detail_id DESC",
			nativeQuery=true)
	List<GetInstituteInfo> getAllInstituteList(@Param("instituteId") int instituteId, @Param("acadmicYear") int acadmicYear);
	

}
