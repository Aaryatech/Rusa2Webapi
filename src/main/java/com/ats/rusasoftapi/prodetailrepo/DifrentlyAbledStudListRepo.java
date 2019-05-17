package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.DifrentlyAbledStudList;

public interface DifrentlyAbledStudListRepo extends JpaRepository<DifrentlyAbledStudList, Integer> {

	@Query(value="SELECT  stud.dif_able_stud_id," + 
			" prgType.program_name," + 
			" tPrg.name_of_program," + 
			" stud.name_of_stud," + 
			" stud.gender," + 
			" stud.udid_card_no," + 
			" stud.type_of_disability," + 
			" stud.percnt_of_disability," + 
			" stud.year_of_enrollement " + 
			"FROM difrently_abled_stud stud," + 
			" m_program_type prgType," + 
			" t_program tPrg " + 
			"WHERE stud.program_id=prgType.program_id AND" + 
			" stud.prog_type_id=tPrg.program_id AND" + 
			" stud.acad_year_id=:yearId AND" + 
			" stud.inst_id=:instId AND" + 
			" stud.del_status=1" + 
			" ORDER BY stud.dif_able_stud_id DESC",nativeQuery=true)
	List<DifrentlyAbledStudList> getAllByIntituteIdYrIdAndDelStatus(@Param("instId")int instId,@Param("yearId") int yearId);
}
