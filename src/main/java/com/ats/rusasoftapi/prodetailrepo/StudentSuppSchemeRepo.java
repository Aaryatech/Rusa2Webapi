package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudentSupprtScheme;

public interface StudentSuppSchemeRepo  extends JpaRepository<StudentSupprtScheme, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_support_scheme_detail SET del_status=0 WHERE sprt_schm_id IN (:id) ", nativeQuery = true)
	int deleteSchemes(@Param("id") List<String> id);
	

}
