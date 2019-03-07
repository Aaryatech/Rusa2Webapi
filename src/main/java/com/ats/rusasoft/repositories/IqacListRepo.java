package com.ats.rusasoft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoft.model.IqacList;

public interface IqacListRepo extends JpaRepository<IqacList, Integer> {

	@Modifying
	@Query(value="SELECT i.iqac_id, i.iqac_name, i.joining_date, i.contact_no, i.email, d.designation_name FROM m_iqac i, m_designation d WHERE  i.del_status=1 AND i.desgntn_id=d.designation_id",nativeQuery=true)
	List<IqacList> findByIsActiveAndDelStatus();
}
