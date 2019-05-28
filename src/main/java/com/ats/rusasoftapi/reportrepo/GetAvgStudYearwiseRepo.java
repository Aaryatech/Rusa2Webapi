package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.GetAvgStudYearwise;

public interface GetAvgStudYearwiseRepo extends JpaRepository<GetAvgStudYearwise, Integer> {
	
	@Query(value=" \n" + 
			"select\n" + 
			"        m_location.location_id ,\n" + 
			"        COALESCE((SELECT\n" + 
			"            sum(t_program_student_location.loc_tot_student) \n" + 
			"        from\n" + 
			"            t_program_student_location \n" + 
			"        WHERE\n" + 
			"            t_program_student_location.institute_id=m_institute.institute_id               \n" + 
			"            AND t_program_student_location.del_status=1 \n" + 
			"            AND t_program_student_location.is_active=1            \n" + 
			"            AND t_program_student_location.location_id=m_location.location_id \n" + 
			"            AND t_program_student_location.year_id=:acId1),\n" + 
			"        0) as ac_year_admi_stud1, \n" + 
			"        COALESCE((SELECT\n" + 
			"           t_institute_info_detail.no_current_admited_stnt \n" + 
			"        from\n" + 
			"            t_institute_info_detail \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id=m_institute.institute_id               \n" + 
			"            AND t_institute_info_detail.del_status=1 \n" + 
			"              AND t_institute_info_detail.year_id=:acId1 )   ,         \n" + 
			"           \n" + 
			"        0) as tot_stud1,\n" + 
			"        COALESCE((SELECT\n" + 
			"            sum(t_program_student_location.loc_tot_student)\n" + 
			"        from\n" + 
			"            t_program_student_location \n" + 
			"        WHERE\n" + 
			"            t_program_student_location.institute_id=m_institute.institute_id \n" + 
			"            AND t_program_student_location.del_status=1 \n" + 
			"            AND t_program_student_location.is_active=1            \n" + 
			"            AND t_program_student_location.location_id=m_location.location_id \n" + 
			"            AND t_program_student_location.year_id=:acId2),\n" + 
			"        0) as ac_year_admi_stud2,\n" + 
			"         COALESCE((SELECT\n" + 
			"           t_institute_info_detail.no_current_admited_stnt \n" + 
			"        from\n" + 
			"            t_institute_info_detail \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id=m_institute.institute_id               \n" + 
			"            AND t_institute_info_detail.del_status=1 \n" + 
			"             AND t_institute_info_detail.year_id=:acId2 )   ,         \n" + 
			"           \n" + 
			"        0) as tot_stud2,\n" + 
			"        COALESCE((SELECT\n" + 
			"            sum(t_program_student_location.loc_tot_student) \n" + 
			"        from\n" + 
			"            t_program_student_location \n" + 
			"        WHERE\n" + 
			"            t_program_student_location.institute_id=m_institute.institute_id \n" + 
			"            AND t_program_student_location.del_status=1 \n" + 
			"            AND t_program_student_location.location_id=m_location.location_id \n" + 
			"            AND t_program_student_location.year_id=:acId3),\n" + 
			"        0) as ac_year_admi_stud3,\n" + 
			"         COALESCE((SELECT\n" + 
			"           t_institute_info_detail.no_current_admited_stnt \n" + 
			"        from\n" + 
			"            t_institute_info_detail \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id=m_institute.institute_id               \n" + 
			"            AND t_institute_info_detail.del_status=1 \n" + 
			"             AND t_institute_info_detail.year_id=:acId3 )   ,         \n" + 
			"           \n" + 
			"        0) as tot_stud3,\n" + 
			"        COALESCE((SELECT\n" + 
			"            sum(t_program_student_location.loc_tot_student) \n" + 
			"        from\n" + 
			"            t_program_student_location \n" + 
			"        WHERE\n" + 
			"            t_program_student_location.institute_id=m_institute.institute_id \n" + 
			"            AND t_program_student_location.del_status=1 \n" + 
			"            AND t_program_student_location.is_active=1            \n" + 
			"            AND t_program_student_location.location_id=m_location.location_id \n" + 
			"            AND t_program_student_location.year_id=:acId4),\n" + 
			"        0) as ac_year_admi_stud4,\n" + 
			"         COALESCE((SELECT\n" + 
			"           t_institute_info_detail.no_current_admited_stnt \n" + 
			"        from\n" + 
			"            t_institute_info_detail \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id=m_institute.institute_id               \n" + 
			"            AND t_institute_info_detail.del_status=1 \n" + 
			"             AND t_institute_info_detail.year_id=:acId4)   ,         \n" + 
			"           \n" + 
			"        0) as tot_stud4,\n" + 
			"        COALESCE((SELECT\n" + 
			"            sum(t_program_student_location.loc_tot_student) \n" + 
			"        from\n" + 
			"            t_program_student_location \n" + 
			"        WHERE\n" + 
			"            t_program_student_location.institute_id=m_institute.institute_id \n" + 
			"            AND t_program_student_location.del_status=1 \n" + 
			"            AND t_program_student_location.is_active=1            \n" + 
			"            AND t_program_student_location.location_id=m_location.location_id \n" + 
			"            AND t_program_student_location.year_id=:acId5),\n" + 
			"        0) as ac_year_admi_stud5, COALESCE((SELECT\n" + 
			"           t_institute_info_detail.no_current_admited_stnt \n" + 
			"        from\n" + 
			"            t_institute_info_detail \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id=m_institute.institute_id               \n" + 
			"            AND t_institute_info_detail.del_status=1 \n" + 
			"             AND t_institute_info_detail.year_id=:acId5 )   ,         \n" + 
			"           \n" + 
			"        0) as tot_stud5,\n" + 
			"        m_institute.institute_name,\n" + 
			"        m_location.location_name  \n" + 
			"    FROM\n" + 
			"        m_institute,\n" + 
			"        m_location     \n" + 
			"    WHERE\n" + 
			"        m_institute.institute_id=:instId\n" + 
			"        AND m_location.location_id IN (\n" + 
			"            :locIds \n" + 
			"        ) \n" + 
			"    group by\n" + 
			"        m_location.location_id \n" + 
			"    ORDER by\n" + 
			"        m_location.location_id desc",nativeQuery=true)

	List<GetAvgStudYearwise> getAvgStudYearwiseLocWise(@Param("instId") int instId,@Param("locIds")   List<Integer> locIds,@Param("acId1")   int acId1,@Param("acId2")   int acId2,@Param("acId3")   int acId3,@Param("acId4")   int acId4,@Param("acId5")   int acId5);

}
