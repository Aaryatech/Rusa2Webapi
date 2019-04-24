package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.DeansList;

public interface DeansListRepo extends JpaRepository<DeansList, Integer> {

	@Modifying
	@Query(value = "SELECT d.dean_id,d.dean_name,d.contact_no,d.email, d.joining_date, d.realiving_date, "
			+ "q.qualification_name FROM m_qualificatoin q, m_dean_reg d WHERE d.del_status=1 AND "
			+ "d.qualification_id=q.qualification_id  ORDER BY d.dean_id DESC",nativeQuery=true)
	List<DeansList> findByIsActiveAndDelStatus();

	
}
