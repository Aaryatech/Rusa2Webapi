package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.OrganizedList;

public interface ShowOrganizedListRepo extends JpaRepository<OrganizedList, Integer> {
	
	@Modifying
	@Query(value="SELECT a.activity_id, o.type_name , a.activity_name, a.activity_level, a.activity_date, a.activity_participants, a.activity_funded_by, a.activity_amount_sanctioned,a.activity_amount_utilised FROM t_faculty_activity a, m_outreach_type o WHERE o.type_id=a.activity_type AND a.del_status=:del AND a.year_id=:yrId AND a.faculty_id=:facId Order By a.activity_id Desc",nativeQuery=true)
 	List<OrganizedList> getOrganizedDetailList(@Param("facId") int facId, @Param("yrId") int yrId, @Param("del") int del);

}
