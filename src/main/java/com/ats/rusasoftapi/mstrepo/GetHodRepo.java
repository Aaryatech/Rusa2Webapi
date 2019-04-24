package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetHod;

public interface GetHodRepo extends JpaRepository<GetHod, Integer> {
	
	@Query(value=" SELECT m_hod.hod_id,m_hod.institute_id,m_hod.dept_id,m_hod.hod_name,m_hod.contact_no,m_hod.email,"
			+ " m_dept.dept_name FROM  m_hod,m_dept WHERE m_hod.dept_id IN (m_dept.dept_id) AND "
			+ "  m_hod.del_status=1 and m_hod.is_active=1 and "
			+ " m_hod.institute_id=:instId ORDER BY m_hod.hod_id DESC ", nativeQuery=true)
	
	List<GetHod> getHodListByInstId(@Param("instId") int instId);
	

}
