package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AvgPerPlacement;

public interface AvgPerPlacementRepo extends JpaRepository<AvgPerPlacement, Integer> {
	
	@Query(value="SELECT  t_traning_placement.placement_id," + 
			"t_traning_placement.no_student_placed," + 
			"t_traning_placement.empyr_name," + 
			"t_traning_placement.empyr_add," + 
			"t_traning_placement.contact_detail," + 
			"t_traning_placement.pakage_offerd as min_package," + 
			"t_traning_placement.ex_var1 as max_package," + 
			"stud_perform_final_yr.stud_perform_id," + 
			"stud_perform_final_yr.no_stud_pass," + 
			"m_academic_year.academic_year," + 
			"m_institute.institute_name " + 
			"FROM stud_perform_final_yr, t_traning_placement, m_academic_year, m_institute, t_program " + 
			"WHERE t_traning_placement.del_status=1 AND t_traning_placement.is_active=1 AND " + 
			"t_traning_placement.institute_id=m_institute.institute_id AND " + 
			"t_traning_placement.year_id=m_academic_year.year_id AND " + 
			"t_traning_placement.program_name=t_program.program_id AND " + 
			"stud_perform_final_yr.prog_type=t_program.program_id AND " + 
			"stud_perform_final_yr.ex_int1=m_academic_year.year_id AND " + 
			"stud_perform_final_yr.inst_id=m_institute.institute_id AND " + 
			"t_traning_placement.institute_id=:instId AND " + 
			"t_traning_placement.year_id IN (:lastFiveYears) AND "+
			"t_traning_placement.program_name=:prgName",nativeQuery=true)
	List<AvgPerPlacement> getAllAvgPerPlacement(@Param("instId") int instId, @Param("lastFiveYears") List<Integer> lastFiveYears, @Param("prgName") String prgName);

}
