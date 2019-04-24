package com.ats.rusasoftapi.mstrepo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.controller.Info;
import com.ats.rusasoftapi.model.UserLogin;

public interface UserService extends JpaRepository<UserLogin, Integer> {

	/*
	 * public UserLogin findUserByUserName(String userName,String pass,int isBlock);
	 */

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_user_login SET pass=:password ,ex_int1=0   WHERE user_id=:userId ", nativeQuery = true)
	int chagePass(@Param("password") String password, @Param("userId") int userId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_user_login SET role_id=:roleId WHERE user_id=:userId ", nativeQuery = true)
	int updateRoleId(@Param("roleId") int roleId, @Param("userId") int userId);

	UserLogin findByRegPrimaryKey(int librarianId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_user_login SET is_block=0 WHERE ex_int2=:instituteId and user_type=:userType", nativeQuery = true)
	int blockPreviousIqacRecord(@Param("instituteId") int instituteId, @Param("userType") int userType);

	@Transactional
	@Modifying
	@Query(value = "UPDATE t_user_login SET is_block=0 WHERE reg_primary_key=:regPrimaryKey and user_type=:userType", nativeQuery = true)
	int blockPreviousHodRecord(@Param("regPrimaryKey") int regPrimaryKey, @Param("userType") int userType);

	UserLogin findByUserNameAndIsBlock(String userName, int isBlock);

}
