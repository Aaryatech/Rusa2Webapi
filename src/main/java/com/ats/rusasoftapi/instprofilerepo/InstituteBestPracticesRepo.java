package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteBestPractices;


public interface InstituteBestPracticesRepo extends JpaRepository<InstituteBestPractices, Integer>{

	
	
	@Query(value=" SELECT * from  institute_best_practices  where institute_best_practices.institute_id =:instId  and "
			+ " institute_best_practices.del_status=1 and institute_best_practices.is_active=1  and institute_best_practices.year_id =:yearId "
			+ "  ORDER BY institute_best_practices.practices_id DESC ", nativeQuery=true)
	
	List<InstituteBestPractices> getAllBestPracList(@Param("instId") int instId,@Param("yearId") int yearId);

	InstituteBestPractices findByDelStatusAndIsActiveAndPracticesId(int delStatus, int isActive, int practicesId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE institute_best_practices SET del_status=0 WHERE practices_id IN (:practIdList) ",nativeQuery=true)
	int deleteBestPractices(@Param("practIdList") List<String> practIdList);
	
}
