package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetAlumni;

public interface GetAlumniRepo  extends JpaRepository<GetAlumni, Integer>{
	
	@Query(value=" SELECT t_alumni_detail.alumni_detail_id,t_alumni_detail.institute_id,t_alumni_detail.alumni_name, t_alumni_detail.ex_var1,"
			+ " t_alumni_detail.passing_year,t_alumni_detail.contribution_type,t_alumni_detail.contribution_year, "
			+ " t_alumni_detail.benefit_to FROM t_alumni_detail"
			+ " WHERE t_alumni_detail.institute_id=:instId AND t_alumni_detail.year_id=:yearId AND t_alumni_detail.del_status=1 AND t_alumni_detail.is_active=1 ORDER BY t_alumni_detail.alumni_detail_id DESC ", nativeQuery=true)
	List<GetAlumni> getGetAlumniByInstAndYearId(@Param("instId") int instId, @Param("yearId") int yearId);
}
