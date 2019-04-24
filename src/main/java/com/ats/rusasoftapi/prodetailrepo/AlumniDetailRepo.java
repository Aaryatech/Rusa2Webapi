package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.AlumniDetail;

public interface AlumniDetailRepo extends JpaRepository<AlumniDetail, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_alumni_detail SET del_status=0 WHERE alumni_detail_id  IN (:alumniIds)  ",nativeQuery=true)
	
	int deleteAlumniIds(@Param("alumniIds") List<String> alumniIds);

	AlumniDetail findByAlumniDetailIdAndDelStatusAndIsActive(int aluId,int delStatus,int isActive);

}
