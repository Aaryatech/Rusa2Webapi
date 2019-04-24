package com.ats.rusasoftapi.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.LoginResponse;



public interface LoginResponseRepo extends JpaRepository<LoginResponse, Integer>  {
	
	

    @Query(value=" SELECT u.user_id,u.user_type,u.user_name,u.pass,u.is_block,u.reg_primary_key,u.role_id,u.ex_int1,u.ex_int2"
    		+ " from t_user_login u WHERE user_name=:username AND pass=:pass AND is_block=:isBlock", nativeQuery=true)
    LoginResponse getUser(@Param("username") String userName  ,@Param("pass") String pass,@Param("isBlock") int isBlock);

}
 