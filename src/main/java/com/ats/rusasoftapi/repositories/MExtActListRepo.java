package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.MExtActList;
public interface MExtActListRepo extends JpaRepository<MExtActList, Integer> {
	
	@Query(value="SELECT\n" + 
			"	\n" + 
			"	t_extension_activity.inst_extension_act_id, \n" + 
			"	t_extension_activity.extension_activity_id,\n" + 
			"    t_extension_activity.inst_id,\n" + 
			"    t_extension_activity.ac_year_id,\n" + 
			"    t_extension_activity.no_of_stud_participated,\n" + 
			"    t_extension_activity.no_of_stud_in_inst,\n" + 
			"    t_extension_activity.no_of_faculty_participated,\n" + 
			"    t_extension_activity.no_of_faculty_in_inst,\n" + 
			"    t_extension_activity.del_status,\n" + 
			"    t_extension_activity.is_active,\n" + 
			"    t_extension_activity.maker_user_id,\n" + 
			"    t_extension_activity.maker_datetime,\n" + 
			"    t_extension_activity.ex_int1,\n" + 
			"    t_extension_activity.ex_var1,\n" + 
			"    t_extension_activity.ex_int2,\n" + 
			"    t_extension_activity.ex_var2, t_extension_activity.from_date, t_extension_activity.to_date,\n" + 
			"CASE \n" + 
			"	WHEN t_extension_activity.extension_activity_id=0\n" + 
			"    THEN (SELECT t.t_activity_title\n" + 
			"          FROM t_extension_activity t\n" + 
			"          WHERE t.inst_extension_act_id=t_extension_activity.inst_extension_act_id)\n" + 
			"          ELSE (SELECT m_extension_activity.activity_title\n" + 
			"          FROM m_extension_activity\n" + 
			"          WHERE m_extension_activity.extension_activity_id=t_extension_activity.extension_activity_id)END as t_activity_title\n" + 
			"FROM \n" + 
			"		t_extension_activity\n" + 
			"WHERE \n" + 
			"\n" + 
			"    t_extension_activity.del_status=1 AND\n" + 
			"    t_extension_activity.inst_id=:instituteId Order By t_extension_activity.inst_extension_act_id Desc",nativeQuery=true)
	List<MExtActList> getAllExtActByInstId(@Param("instituteId") int instituteId);

	
	

	
	
	
	/*SELECT
	DISTINCT
	tExt.inst_extension_act_id, 
	tExt.extension_activity_id,
    tExt.inst_id,
    tExt.ac_year_id,
    tExt.t_activity_title,
    tExt.no_of_stud_participated,
    tExt.no_of_stud_in_inst,
    tExt.no_of_faculty_participated,
    tExt.no_of_faculty_in_inst,
    tExt.del_status,
    tExt.is_active,
    tExt.maker_user_id,
    tExt.maker_datetime,
    tExt.ex_int1,
    tExt.ex_var1,
    tExt.ex_int2,
    tExt.ex_var2,
    mExt.activity_title
FROM 
		t_extension_activity tExt, m_extension_activity mExt
WHERE 
	tExt.inst_extension_act_id=mExt.extension_activity_id AND
    tExt.del_status=1 AND
    
    tExt.inst_id=2*/

}
