package com.ats.rusasoftapi.master.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.infra.PlagiarismCodeEthics;

public interface PlagiarismCodeEthicsRepo extends JpaRepository<PlagiarismCodeEthics, Integer> {

	List<PlagiarismCodeEthics> findByInstIdAndDelStatusOrderByPlagCodeEthcIdDesc(@Param("instituteId")int instituteId,@Param("i") int i);

	PlagiarismCodeEthics findByPlagCodeEthcId(int plagId);
	
	 @Transactional
	 @Modifying
	 @Query(value="update  plagiarism_code_ethics set del_status = 0 where plag_code_ethc_id=:plagId",nativeQuery=true)
	int deletePlagrismEthicSCodeById(@Param("plagId")int plagId);

	 @Transactional
	 @Modifying
	 @Query(value="UPDATE plagiarism_code_ethics SET del_status=0  WHERE plag_code_ethc_id IN (:plagIdList)",nativeQuery=true)
	int deletePlagEthcCodes(@Param("plagIdList")List<String> plagIdList);
}

