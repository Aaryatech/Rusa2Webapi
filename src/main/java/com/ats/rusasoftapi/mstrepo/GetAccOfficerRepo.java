package com.ats.rusasoftapi.mstrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetAccOfficer;

public interface GetAccOfficerRepo  extends JpaRepository<GetAccOfficer, Integer>{
	
	
	@Query( value=" SELECT m_acc_officer_reg.officer_id,m_acc_officer_reg.acc_officer_name,"
			+ "m_acc_officer_reg.joining_date,"
			+ " m_acc_officer_reg.contact_no,m_acc_officer_reg.email,m_qualificatoin.qualification_name " + 
			" FROM m_qualificatoin,m_acc_officer_reg,m_institute " + 
			" WHERE m_acc_officer_reg.institute_id=m_institute.institute_id AND "
			+ " m_acc_officer_reg.qualification_id=m_qualificatoin.qualification_id AND m_acc_officer_reg.is_active=1 "
			+ " AND m_acc_officer_reg.del_status=1 "
			+ " AND m_acc_officer_reg.institute_id=:instId  ORDER BY m_acc_officer_reg.officer_id DESC ", nativeQuery=true)
	
	
	List<GetAccOfficer> getGetAccOfficer(@Param("instId") int instId);

}
