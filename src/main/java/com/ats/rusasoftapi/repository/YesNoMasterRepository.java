package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.YesNoMaster;

public interface YesNoMasterRepository extends JpaRepository<YesNoMaster, Integer>{

	List<YesNoMaster> findByYesnoPagecodeAndDelStatusAndIsActive(String pageCode, int i, int j);
 

}
