package com.ats.rusasoftapi.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.Principal;

public interface PrincipalRepo extends JpaRepository<Principal, Integer> {
	
	Principal findByInstituteId(int instId);
	

}
