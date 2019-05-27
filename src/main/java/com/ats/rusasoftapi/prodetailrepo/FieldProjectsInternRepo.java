package com.ats.rusasoftapi.prodetailrepo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.FieldProjectsIntern;

public interface FieldProjectsInternRepo extends JpaRepository<FieldProjectsIntern, Integer> {

	FieldProjectsIntern findByFieldProjectInternId(int fieldId);

	@Transactional
	@Modifying
	@Query(value="UPDATE field_projects_intern SET del_status = 0 WHERE field_project_intern_id=:fieldId",nativeQuery=true)
	int deleteInternProjectField(@Param("fieldId")int fieldId);
	
}
