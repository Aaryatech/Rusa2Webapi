package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.InstituteLinkage;


public interface InstituteLinkageRepo extends JpaRepository<InstituteLinkage, Integer> {
	
	
	@Query(value=" SELECT * from  t_institute_linkage  where t_institute_linkage.institute_id =:instId  and "
			+ "t_institute_linkage.del_status=1 and t_institute_linkage.is_active=1  and t_institute_linkage.year_id =:yearId"
			+ " ORDER BY t_institute_linkage.link_id DESC", nativeQuery=true)
	
	List<InstituteLinkage> getAllInstKinkagesList(@Param("instId") int instId,@Param("yearId") int yearId);

	InstituteLinkage findByDelStatusAndIsActiveAndLinkId(int delStatus, int isActive, int linkId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_institute_linkage SET del_status=0  WHERE link_id IN (:linkIdList) ",nativeQuery=true)
	int deleteLinkages(@Param("linkIdList") List<String> linkIdList);
	
}
