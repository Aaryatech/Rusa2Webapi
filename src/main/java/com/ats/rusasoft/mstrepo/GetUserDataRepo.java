package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.GetUserDetail;

public interface GetUserDataRepo extends JpaRepository<GetUserDetail, Integer>
{
    @Query(value=" SELECT p.principal_id as userDetailId,p.principal_name as userName1,p.phone_no as userConNumber,"
    		+ "p.email as userEmail from m_principal p ", nativeQuery=true)
    GetUserDetail getUserDetails();
	

}
