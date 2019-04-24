package com.ats.rusasoftapi.instprofilerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.instprofile.GetInstituteLinkage;

public interface GetInstituteLinkageRepo extends JpaRepository<GetInstituteLinkage, Integer>  {
	
	

	@Query(value = " Select t_institute_linkage.link_id,t_institute_linkage.link_agency,t_institute_linkage.link_nature, "
			+ " t_institute_linkage.link_beneficiary,t_institute_linkage.link_beneficiary_nos, "
			+ " t_institute_linkage.link_agency,mi_institute_linkage_master.linkname_text "
			+ " from t_institute_linkage,mi_institute_linkage_master where t_institute_linkage.linkname_id "
			+ " =mi_institute_linkage_master.linkname_id and t_institute_linkage.del_status=1 and "
			+ " t_institute_linkage.is_active=1 and t_institute_linkage.institute_id=:instId and t_institute_linkage.year_id=:yearId "
			+ " ORDER BY  t_institute_linkage.link_id DESC  ", nativeQuery = true)

	List<GetInstituteLinkage> getAllInstituteLinkage(@Param("instId") int instId,@Param("yearId") int yearId
	);
	
	

}
