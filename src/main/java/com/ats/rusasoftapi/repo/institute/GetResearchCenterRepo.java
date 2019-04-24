package com.ats.rusasoftapi.repo.institute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.GetResearchCenter;

public interface GetResearchCenterRepo extends JpaRepository<GetResearchCenter, Integer> {

	@Query(value = "SELECT * from  institute_research_center  where institute_research_center."
			+ "institute_id =:instId  and  institute_research_center.del_status=1 and "
			+ "institute_research_center.is_active=1  and 	institute_research_center.year_id "
			+ "=:yearId ORDER BY institute_research_center.rc_id DESC ", nativeQuery = true)

	List<GetResearchCenter> getAllRecearchCenterList(@Param("instId") int instId, @Param("yearId") int yearId);

}
