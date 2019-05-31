package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.GetMissions;

public interface GetMissionsRepo extends JpaRepository<GetMissions, Integer>{

	

	@Query(value="SELECT t_institute_mission.inst_mission_id,t_institute_mission.inst_mission_text,m_institute.institute_name,\n" + 
			"t_institute_mission.institute_id FROM t_institute_mission,m_institute \n" + 
			"WHERE t_institute_mission.institute_id=m_institute.institute_id AND t_institute_mission.del_status=1 and t_institute_mission.is_active=1 AND m_institute.institute_id=:instId",nativeQuery=true) 
		
 	List<GetMissions> getInstMission(@Param("instId") int instId);
}
