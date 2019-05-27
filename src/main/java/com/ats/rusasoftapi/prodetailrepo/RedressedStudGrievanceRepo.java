package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.RedressedStudGrievance;

public interface RedressedStudGrievanceRepo extends JpaRepository<RedressedStudGrievance, Integer> {

	
	List<RedressedStudGrievance> findByInstIdAndAcadYearIdAndDelStatusOrderByRedrsStudGrvncIdDesc(int instId, int yearId, int i);

	RedressedStudGrievance findByRedrsStudGrvncId(int studGrievancId);

	@Transactional
	@Modifying
	@Query(value="UPDATE redressed_stud_grievance SET del_status = 0 WHERE redrs_stud_grvnc_id=:studGrievancId",nativeQuery=true)
	int deleteStudGrivance(@Param("studGrievancId")int studGrievancId);

	@Transactional
	@Modifying
	@Query(value="UPDATE redressed_stud_grievance SET del_status=0 WHERE redrs_stud_grvnc_id IN (:grievanceIdList) ",nativeQuery=true)
	int deleteSelStudGriev(@Param("grievanceIdList")List<String> grievanceIdList);
	
}
