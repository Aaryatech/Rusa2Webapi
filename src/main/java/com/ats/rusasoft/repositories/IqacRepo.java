package com.ats.rusasoft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.IqacList;
import com.ats.rusasoft.model.MIqac;

public interface IqacRepo extends JpaRepository<MIqac, Integer> {

	MIqac findByIqacIdAndDelStatus(@Param("id") int id,@Param("i") int i);

	

	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_iqac SET del_status=0 WHERE iqac_id=:id",nativeQuery=true)
	int deleteByIqacId(@Param("id") int id);

	

}
