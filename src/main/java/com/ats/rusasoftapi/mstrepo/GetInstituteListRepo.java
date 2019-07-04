package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.GetInstituteList;

public interface GetInstituteListRepo extends JpaRepository<GetInstituteList, Integer> {
	/*
	 * @Query(value =
	 * " SELECT m_institute.institute_id, m_institute.institute_name, m_institute.maker_enter_datetime, m_institute.principal_name,m_institute.email,m_institute.contact_no from m_institute,t_user_login WHERE m_institute.is_active=1 "
	 * +
	 * " AND m_institute.del_status=1 AND t_user_login.ex_int2=m_institute.institute_id AND t_user_login.user_type=1 ORDER BY m_institute.institute_id DESC "
	 * , nativeQuery = true)
	 * 
	 * List<GetInstituteList> getAllInstituteList();
	 * 
	 * @Query(value =
	 * " SELECT  m_institute.institute_id,  m_institute.institute_name, m_institute.maker_enter_datetime, "
	 * + "        m_institute.principal_name,  m_institute.email,  " +
	 * "        m_institute.contact_no   from   m_institute  WHERE " +
	 * "        m_institute.is_active=1   AND m_institute.del_status=1   " +
	 * "        and m_institute.institute_id NOT IN ( SELECT t_user_login.ex_int2 from t_user_login WHERE t_user_login.user_type=1) "
	 * + "    ORDER BY   m_institute.institute_id DESC ", nativeQuery = true)
	 * 
	 * List<GetInstituteList> getAllPendingInstituteList();
	 */
	
	
	@Query(value = " SELECT m_institute.institute_id, m_institute.institute_name, m_institute.maker_enter_datetime, m_institute.principal_name,m_institute.email,m_institute.contact_no from m_institute WHERE m_institute.is_active=1 "
			+ " AND m_institute.del_status=1 AND m_institute.ex_int2=1  ORDER BY m_institute.institute_id DESC ", nativeQuery = true)

	List<GetInstituteList> getAllInstituteList();

	@Query(value = " SELECT  m_institute.institute_id,  m_institute.institute_name, m_institute.maker_enter_datetime, "
			+ "        m_institute.principal_name,  m_institute.email,  "
			+ "        m_institute.contact_no   from   m_institute  WHERE "
			+ "        m_institute.is_active=1   AND m_institute.del_status=1   "
			+ "        and m_institute.ex_int2=0 "
			+ "    ORDER BY   m_institute.institute_id DESC ", nativeQuery = true)

	List<GetInstituteList> getAllPendingInstituteList();

}
