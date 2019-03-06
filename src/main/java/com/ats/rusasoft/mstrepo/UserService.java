package com.ats.rusasoft.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.rusasoft.model.UserLogin;

public interface UserService extends JpaRepository<UserLogin, Integer>  {
	
	
	/*public UserLogin findUserByUserName(String userName,String pass,int isBlock);*/
	

}
