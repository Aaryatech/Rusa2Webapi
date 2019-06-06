package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.GetTrainPlace;

public interface GetTrainPlaceRepo extends JpaRepository<GetTrainPlace, Integer> {

	@Query(value="SELECT \n" + 
			"        t_traning_placement.placement_id,\n" + 
			"        t_traning_placement.empyr_name,\n" + 
			"        m_program_type.program_name as prog_type_name, \n" + 
			"        t_program.name_of_program as program_name, \n" + 
			"        t_traning_placement.no_student_placed,\n" + 
			"        t_traning_placement.empyr_add,  \n" + 
			"        t_traning_placement.contact_detail,\n" + 
			"        t_traning_placement.ex_var1,\n" + 
			"        t_traning_placement.pakage_offerd\n" + 
			"FROM \n" + 
			"		t_traning_placement, m_program_type, t_program  \n" + 
			"WHERE \n" + 
			"		t_traning_placement.program_type=m_program_type.program_id\n" + 
			"        AND t_traning_placement.program_name=t_program.program_id\n" + 
			"        AND t_traning_placement.year_id=:yearId \n" + 
			"        AND t_traning_placement.institute_id=:instId \n" + 
			"        AND t_traning_placement.del_status=1 \n" + 
			"        AND t_traning_placement.is_active=1 \n" + 
			"        ORDER BY t_traning_placement.placement_id DESC ", nativeQuery=true)
	List<GetTrainPlace> getGetTrainPlace(@Param("instId") int instId, @Param("yearId") int yearId);
	
/*SELECT t_traning_placement.placement_id,t_traning_placement.empyr_name,"
+ " m_program_type.program_name as prog_type_name, t_traning_placement.program_name,"
+ " t_traning_placement.no_student_placed,t_traning_placement.empyr_add, "
+ " t_traning_placement.contact_detail,t_traning_placement.pakage_offerd "
+ " FROM t_traning_placement INNER JOIN m_program_type ON "
+ " t_traning_placement.program_type=m_program_type.program_id "
+ " WHERE t_traning_placement.year_id=:yearId AND t_traning_placement.institute_id=:instId "
+ " AND t_traning_placement.del_status=1 AND t_traning_placement.is_active=1 ORDER BY t_traning_placement.placement_id DESC    */
}
