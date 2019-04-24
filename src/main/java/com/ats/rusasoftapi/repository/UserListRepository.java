package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.rusasoftapi.model.UserList;

public interface UserListRepository extends JpaRepository<UserList, Integer>{

	 @Query(value="select * from t_user_login  where is_block=1  and ex_int2 =:instituteId", nativeQuery=true)
	List<UserList> getuserList(@RequestParam("instituteId") int instituteId);

}
