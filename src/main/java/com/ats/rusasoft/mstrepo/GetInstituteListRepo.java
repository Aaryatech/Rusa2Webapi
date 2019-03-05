package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.GetInstituteList;

public interface GetInstituteListRepo extends JpaRepository<GetInstituteList, Integer> {
@Query(value=" SELECT institute_id, institute_name,principal_name,email,contact_no from m_institute WHERE is_active=1 AND del_status=1", nativeQuery=true)
	
	List<GetInstituteList> getAllInstituteList();


}
