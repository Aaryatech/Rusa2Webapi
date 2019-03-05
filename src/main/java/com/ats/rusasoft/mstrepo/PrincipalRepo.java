package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.Principal;

public interface PrincipalRepo extends JpaRepository<Principal, Integer> {
	
	Principal findByInstituteId(int instId);
	

}
