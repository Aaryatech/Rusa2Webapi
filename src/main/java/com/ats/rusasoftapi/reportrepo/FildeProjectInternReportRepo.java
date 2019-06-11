package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.FildeProjectInternReport;

public interface FildeProjectInternReportRepo extends JpaRepository<FildeProjectInternReport, Integer> {

	@Query(value="SELECT field_projects_intern.field_project_intern_id, field_projects_intern.provision_for_undertaking," + 
			"field_projects_intern.no_of_stud_undertaking," + 
			"field_projects_intern.document," + 
			"t_program.name_of_program AS program_type," + 
			"m_institute.institute_name," + 
			"m_academic_year.academic_year " + 
			"FROM field_projects_intern, m_institute, m_academic_year, t_program " + 
			"WHERE field_projects_intern.del_status=1 AND field_projects_intern.is_active=1 AND " + 
			"field_projects_intern.inst_Id=m_institute.institute_id AND " + 
			"field_projects_intern.ac_year_id=m_academic_year.year_id AND " + 
			"field_projects_intern.program_type=t_program.program_id AND " + 
			"field_projects_intern.program_type=:prog_name AND " + 
			"field_projects_intern.inst_Id=:instId AND " + 
			"field_projects_intern.ac_year_id=:acYear",nativeQuery=true)
	List<FildeProjectInternReport> getAllFildeProjectInternReport(@Param("instId")int instId, @Param("prog_name")int prog_name, @Param("acYear")int acYear);
}
