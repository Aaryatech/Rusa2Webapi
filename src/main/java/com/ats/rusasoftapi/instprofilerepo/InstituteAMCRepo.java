package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteAMC;
import com.ats.rusasoftapi.model.instprofile.InstituteFunctionalMOU;


public interface InstituteAMCRepo extends JpaRepository<InstituteAMC, Integer> {
	
	
	@Query(value=" SELECT * from  institute_amc  where institute_amc.institute_id =:instId  and "
			+ "institute_amc.del_status=1 and institute_amc.is_active=1  and 	institute_amc.year_id =:yearId ORDER BY institute_amc.amc_id DESC ", nativeQuery=true)
	
	List<InstituteAMC> getAllInstituteAMC(@Param("instId") int instId,@Param("yearId") int yearId);

	InstituteAMC findByDelStatusAndIsActiveAndAmcId(int delStatus, int isActive, int amcId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE institute_amc SET del_status=0 WHERE amc_id IN (:amcIdList) ",nativeQuery=true)
	int deleteAMCs(@Param("amcIdList") List<String> amcIdList);
	

}
