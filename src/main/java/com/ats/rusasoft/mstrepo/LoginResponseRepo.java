package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.LoginResponse;



public interface LoginResponseRepo extends JpaRepository<LoginResponse, Integer>  {
	
	

    @Query(value=" SELECT u.user_id,u.user_type,u.user_name,u.pass,u.is_block,u.reg_primary_key,u.role_id  "
    		+ " CASE WHEN u.user_type=1  THEN (SELECT p.principal_id as userDeatilId,p.principal_name as userName1,"
    		+ "p.phone_no as userConNumber,p.email as userEmail from m_principal)"
    		+ "from t_user_login u WHERE "
	+ " user_name=:username AND pass=:pass AND is_block=:isBlock ", nativeQuery=true)
    LoginResponse getUser(@Param("username") String userName  ,@Param("pass") String pass,@Param("isBlock") int isBlock);

}
 