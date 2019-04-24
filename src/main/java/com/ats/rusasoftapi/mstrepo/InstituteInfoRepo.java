package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.InstituteInfo;

public interface InstituteInfoRepo  extends JpaRepository<InstituteInfo, Integer>{

	InstituteInfo findByInfoDetailId(int infoDetailId);

	

	@Transactional
	@Modifying
	@Query(value="UPDATE t_institute_info_detail SET del_status=0 WHERE info_detail_id IN (:instIdList) ",nativeQuery=true)
	int deleteInstitutes(@Param("instIdList") List<String> instIdList);

	
	

}
