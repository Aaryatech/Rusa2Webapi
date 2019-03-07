package com.ats.rusasoft.mstrepo;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.controller.Info;
import com.ats.rusasoft.model.UserLogin;

public interface UserService extends JpaRepository<UserLogin, Integer>  {
	
	
	/*public UserLogin findUserByUserName(String userName,String pass,int isBlock);*/
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_user_login SET pass=:password ,ex_int1=1   WHERE user_id=:userId ",nativeQuery=true)
	int chagePass(@Param("password") String password,@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_user_login SET role_id=:roleId WHERE user_id=:userId ",nativeQuery=true)
	int updateRoleId(@Param("roleId")int roleId,@Param("userId") int userId);

	UserLogin findByRegPrimaryKey(int librarianId);
	
	
}
