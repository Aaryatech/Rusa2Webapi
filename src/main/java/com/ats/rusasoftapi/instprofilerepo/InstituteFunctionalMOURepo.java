package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteFunctionalMOU;


public interface InstituteFunctionalMOURepo extends JpaRepository<InstituteFunctionalMOU, Integer> {
	
	@Query(value=" SELECT * from  t_institute_mou  where t_institute_mou.institute_id =:instId  and "
			+ "t_institute_mou.del_status=1 and t_institute_mou.is_active=1  and 	t_institute_mou.year_id =:yearId"
			+ "  ORDER BY t_institute_mou.mou_id DESC ", nativeQuery=true)
	
	List<InstituteFunctionalMOU> getAllMOUList(@Param("instId") int instId,@Param("yearId") int yearId);

	InstituteFunctionalMOU findByDelStatusAndIsActiveAndMouId(int delStatus, int isActive, int mouId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_institute_mou SET del_status=0 WHERE mou_id IN (:mouIdList) ",nativeQuery=true)
	int deleteMous(@Param("mouIdList") List<String> mouIdList);
	

}
