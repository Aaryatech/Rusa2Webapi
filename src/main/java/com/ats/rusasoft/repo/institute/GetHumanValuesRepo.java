package com.ats.rusasoft.repo.institute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.instprofile.GetHumanValues;

public interface GetHumanValuesRepo extends JpaRepository<GetHumanValues, Integer> {

	@Query(value = "SELECT * from  institute_values_promotion  where institute_values_promotion."
			+ "institute_id =:instId  and  institute_values_promotion.del_status=1 and "
			+ "institute_values_promotion.is_active=1  and 	institute_values_promotion.year_id "
			+ "=:yearId", nativeQuery = true)

	List<GetHumanValues> getAllHumanValuesList(@Param("instId") int instId, @Param("yearId") int yearId);

}
