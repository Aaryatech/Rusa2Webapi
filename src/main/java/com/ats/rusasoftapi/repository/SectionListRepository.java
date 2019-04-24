package com.ats.rusasoftapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.SectionList;

public interface SectionListRepository extends JpaRepository<SectionList, Integer>{
	

	@Query(value="select yesno_id,yesno_pagecode,yesno_seccode,yesno_secname from md_yesno where yesno_pagecode=:pageCode group by yesno_seccode", nativeQuery=true)
	List<SectionList> getSectionListByPageCode(@Param("pageCode") String pageCode);

}
