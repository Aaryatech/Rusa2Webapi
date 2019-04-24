package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.IqacBasicInfo;


public interface IqacBasicInfoRepo extends JpaRepository<IqacBasicInfo, Integer> {
	
	
    @Query(value=" SELECT * FROM m_iqac_basic_info   WHERE m_iqac_basic_info.institute_id=:instituteId"
    		+ " and m_iqac_basic_info.del_status=1 and m_iqac_basic_info.is_active=1  ", nativeQuery=true)
	
      IqacBasicInfo getIqacInfo(@Param("instituteId") int instituteId);

    
    
	IqacBasicInfo findByDelStatusAndIsActiveAndIqacInfoId(int delStatus, int isActive, int iqacInfoId);
	
	

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_iqac_basic_info SET del_status=0 WHERE m_iqac_basic_info.iqac_info_id=:iqacInfoId ", nativeQuery = true)
	int deleteSchemes(@Param("iqacInfoId") int  iqacInfoId);

}
