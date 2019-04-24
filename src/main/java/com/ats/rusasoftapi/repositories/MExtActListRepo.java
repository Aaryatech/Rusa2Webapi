package com.ats.rusasoftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusasoftapi.model.MExtActList;
public interface MExtActListRepo extends JpaRepository<MExtActList, Integer> {
	
	@Query(value="SELECT \n" + 
			"	tExt.inst_extension_act_id, \n" + 
			"	tExt.extension_activity_id,\n" + 
			"    tExt.inst_id,\n" + 
			"    tExt.ac_year_id,\n" + 
			"    tExt.t_activity_title,\n" + 
			"    tExt.no_of_stud_participated,\n" + 
			"    tExt.no_of_stud_in_inst,\n" + 
			"    tExt.no_of_faculty_participated,\n" + 
			"    tExt.no_of_faculty_in_inst,\n" + 
			"    tExt.del_status,\n" + 
			"    tExt.is_active,\n" + 
			"    tExt.maker_user_id,\n" + 
			"    tExt.maker_datetime,\n" + 
			"    tExt.ex_int1,\n" + 
			"    tExt.ex_var1,\n" + 
			"    tExt.ex_int2,\n" + 
			"    tExt.ex_var2,\n" + 
			"    mExt.activity_title\n" + 
			"FROM \n" + 
			"		t_extension_activity tExt, m_extension_activity mExt\n" + 
			"WHERE \n" + 
			"	tExt.inst_extension_act_id=mExt.extension_activity_id AND\n" + 
			"    tExt.del_status=1 AND\n" + 
			"    tExt.inst_id=:instituteId",nativeQuery=true)
	List<MExtActList> getAllExtActByInstId(int instituteId);

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
