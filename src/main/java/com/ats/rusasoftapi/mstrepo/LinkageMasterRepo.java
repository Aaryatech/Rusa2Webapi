package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.LinkageMaster;

public interface LinkageMasterRepo extends JpaRepository<LinkageMaster, Integer> {

	
	@Query(value=" SELECT * from  mi_institute_linkage_master  where mi_institute_linkage_master.institute_id =:instId  and "
			+ "mi_institute_linkage_master.del_status=1 and mi_institute_linkage_master.is_active=1 ORDER BY mi_institute_linkage_master.linkname_id DESC   ", nativeQuery=true)
	
	List<LinkageMaster> getAllInstKinkagesList(@Param("instId") int instId);

	
	LinkageMaster findByLinknameId(int linknameId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE mi_institute_linkage_master SET del_status=0 WHERE linkname_id IN (:linknameIdList) ",nativeQuery=true)
	int deleteLinkName(@Param("linknameIdList") List<String> linknameIdList);
	

}
