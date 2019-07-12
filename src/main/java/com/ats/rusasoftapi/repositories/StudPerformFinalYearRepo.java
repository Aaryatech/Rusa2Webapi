package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudPerformFinalYr;

public interface StudPerformFinalYearRepo extends JpaRepository<StudPerformFinalYr, Integer> {
	
	StudPerformFinalYr findByStudPerformIdAndDelStatus(int studperId, int del);
	
	
	
	@Transactional
	@Modifying
	@Query(value=" UPDATE  stud_perform_final_yr SET del_status = 0 WHERE stud_perform_id=:studperId",nativeQuery=true)
	int	deletetStudFinalYearPerformance(@Param("studperId") int studperId);


	@Transactional
	@Modifying
	@Query(value="UPDATE stud_perform_final_yr SET del_status=0  WHERE stud_perform_id IN (:studInfoList)",nativeQuery=true)
	int deletetSelStudInfo(@Param("studInfoList") List<String> studInfoList);



	StudPerformFinalYr findByInstIdAndExInt1AndDelStatus(int instituteId, int yearId, int del);

}
