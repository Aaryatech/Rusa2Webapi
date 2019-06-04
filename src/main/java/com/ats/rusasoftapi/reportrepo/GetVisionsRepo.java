package com.ats.rusasoftapi.reportrepo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.GetVisions;
 
public interface GetVisionsRepo extends JpaRepository<GetVisions, Integer> {
	
	

	@Query(value="SELECT m_institute.institute_name, t_institute_vision.inst_vision_text,"
			+ "t_institute_vision.inst_vision_id FROM t_institute_vision,m_institute WHERE "
			+ "t_institute_vision.institute_id=m_institute.institute_id AND "
			+ "m_institute.institute_id=:instId and t_institute_vision.del_status=1 "
			+ "AND t_institute_vision.is_active=1 ORDER by t_institute_vision.inst_vision_id "
			+ "DESC LIMIT 1 ",nativeQuery=true)
	List<GetVisions> getInstVision(@Param("instId") int instId);

}
