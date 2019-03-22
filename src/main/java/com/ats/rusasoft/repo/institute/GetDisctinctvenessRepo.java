package com.ats.rusasoft.repo.institute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.instprofile.GetDisctinctveness;

public interface GetDisctinctvenessRepo extends JpaRepository<GetDisctinctveness, Integer> {

	@Query(value = "SELECT * from  institute_distinctiveness  where institute_distinctiveness."
			+ "institute_id =:instId  and  institute_distinctiveness.del_status=1 and "
			+ "institute_distinctiveness.is_active=1  and 	institute_distinctiveness.year_id "
			+ "=:yearId", nativeQuery = true)

	List<GetDisctinctveness> getAllDistList(@Param("instId") int instId, @Param("yearId") int yearId);

}
