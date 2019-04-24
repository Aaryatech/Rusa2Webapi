package com.ats.rusasoftapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.IqacList;
import com.ats.rusasoftapi.model.MIqac;

public interface IqacRepo extends JpaRepository<MIqac, Integer> {

	MIqac findByIqacIdAndDelStatus(@Param("id") int id,@Param("i") int i);

	

	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_iqac SET del_status=0 WHERE iqac_id=:id",nativeQuery=true)
	int deleteByIqacId(@Param("id") int id);




	List<MIqac> findByContactNoAndDelStatusAndIsActive(String contactNo, int i, int j);




	List<MIqac> findByContactNoAndDelStatusAndIsActiveAndIqacIdNot(String contactNo, int i, int j, int iqacId);




	List<MIqac> findByEmailAndDelStatusAndIsActive(String email, int i, int j);




	List<MIqac> findByEmailAndDelStatusAndIsActiveAndIqacIdNot(String email, int i, int j, int iqacId);




	MIqac findByInstituteIdAndDelStatusAndIsActive(int instituteId, int i, int j);

	

}
