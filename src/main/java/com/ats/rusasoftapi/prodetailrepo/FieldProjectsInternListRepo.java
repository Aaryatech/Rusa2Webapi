package com.ats.rusasoftapi.prodetailrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.progdetail.FieldProjectsInternList;

public interface FieldProjectsInternListRepo extends JpaRepository<FieldProjectsInternList, Integer> {
	
	@Query(value="SELECT field.field_project_intern_id," + 
				" prgName.program_name as program_name," + 
				" prgType.name_of_program as program_type," + 
				" field.provision_for_undertaking," + 
				" field.no_of_stud_undertaking,  " + 
				" field.document"+			
			" FROM field_projects_intern field," + 
				" m_program_type prgName," + 
				" t_program prgType," + 
				" m_academic_year acad " + 
			" WHERE field.inst_Id=:instId AND" + 
				" field.del_status=1 AND" + 
				" field.program_name=prgName.program_id AND" + 
				" field.program_type=prgType.program_id AND" + 
				" field.ac_year_id=acad.year_id AND" + 
				" field.ac_year_id=:yearId" + 
				" ORDER BY field.field_project_intern_id DESC",nativeQuery=true)
	
	List<FieldProjectsInternList> getAllByIntituteIdYrIdAndDelStatus(@Param("instId") int instId, @Param("yearId") int yearId);

}
