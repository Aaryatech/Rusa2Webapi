package com.ats.rusasoftapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.StudentSupprtScheme;

public interface StudentSupprtSchemeRepo extends JpaRepository<StudentSupprtScheme, Integer> {

	StudentSupprtScheme findBySprtSchmIdAndDelStatus(int sssId,int delStatus);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_support_scheme_detail SET del_status = 0 WHERE sprt_schm_id=:id",nativeQuery=true)
	int deleteBySprtSchmId(@Param("id") int id);

}
