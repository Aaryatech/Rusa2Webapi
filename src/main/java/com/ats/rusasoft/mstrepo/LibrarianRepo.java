package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.GetInstituteList;
import com.ats.rusasoft.model.Librarian;


public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {
	
	@Query(value=" SELECT institute_id, institute_name,principal_name,email,contact_no from m_institute,t_user_login WHERE is_active=1 "
			+ " AND del_status=1 AND t_user_login.reg_primary_key=institute_id  ", nativeQuery=true)
		
		List<GetInstituteList> getAllLibList();


}
