package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.GetUserDetail;

public interface GetUserDataRepo extends JpaRepository<GetUserDetail, Integer>
{
    @Query(value="  ", nativeQuery=true)
    GetUserDetail getUserDetails(@Param("typeId") int typeId);
	

}
