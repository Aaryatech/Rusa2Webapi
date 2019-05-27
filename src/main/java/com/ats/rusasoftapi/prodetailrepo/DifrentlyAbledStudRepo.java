package com.ats.rusasoftapi.prodetailrepo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.DifrentlyAbledStud;

public interface DifrentlyAbledStudRepo extends JpaRepository<DifrentlyAbledStud, Integer> {

	DifrentlyAbledStud findByDifAbleStudId(int studId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE difrently_abled_stud SET del_status = 0 WHERE dif_able_stud_id=:studId",nativeQuery=true)
	int deleteDiferentlyDisabledStudent(@Param("studId")int studId);

}
