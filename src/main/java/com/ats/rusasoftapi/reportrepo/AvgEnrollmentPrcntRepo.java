package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.AvgEnrollmentPrcnt;
 
 
public interface AvgEnrollmentPrcntRepo extends JpaRepository<AvgEnrollmentPrcnt, Integer>  {
	
	/*
	 * @Query(value=" SELECT\n" + "    m_academic_year.academic_year,\n" +
	 * "    m_academic_year.year_id,\n" + "    m_institute.institute_name,\n" +
	 * "    COALESCE(\n" + "        (\n" + "        SELECT\n" +
	 * "            SUM(t_program.sanctional_intake)\n" + "        FROM\n" +
	 * "            t_program\n" + "        WHERE\n" +
	 * "            t_program.del_status = 1 AND t_program.is_active = 1 AND t_program.institute_id = :instId AND t_program.year_id = m_academic_year.year_id\n"
	 * + "    ),\n" + "    0\n" + "    ) AS total_sanct_intake,\n" +
	 * "    COALESCE(\n" + "        (\n" + "        SELECT\n" +
	 * "            t_institute_info_detail.no_current_admited_stnt\n" +
	 * "        FROM\n" + "            t_institute_info_detail\n" +
	 * "        WHERE\n" +
	 * "            t_institute_info_detail.institute_id = :instId  AND t_institute_info_detail.year_id = m_academic_year.year_id\n"
	 * + "    ),\n" + "    0\n" + "    ) AS no_current_admited_stnt\n" + "FROM\n" +
	 * "    m_academic_year,m_institute\n" + "WHERE\n" +
	 * "    m_academic_year.year_id IN (:acYearList) AND m_institute.institute_id=:instId "
	 * ,nativeQuery=true)
	 * 
	 * List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@Param("instId") int
	 * instId,@Param("acYearList") List<Integer> acYearList);
	 */
	

	@Query(value="SELECT\n" + 
			"        m_academic_year.academic_year,\n" + 
			"        m_academic_year.year_id,\n" + 
			"        m_institute.institute_name,\n" + 
			"        COALESCE(         (         SELECT\n" + 
			"            SUM(t_program.sanctional_intake)         \n" + 
			"        FROM\n" + 
			"            t_program         \n" + 
			"        WHERE\n" + 
			"            t_program.del_status = 1 \n" + 
			"            AND t_program.is_active = 1 \n" + 
			"            AND t_program.institute_id = m_institute.institute_id\n" + 
			"               ),\n" + 
			"        0     ) AS total_sanct_intake,\n" + 
			"        COALESCE(         (         SELECT\n" + 
			"            t_institute_info_detail.no_current_admited_stnt         \n" + 
			"        FROM\n" + 
			"            t_institute_info_detail         \n" + 
			"        WHERE\n" + 
			"            t_institute_info_detail.institute_id = m_institute.institute_id\n" + 
			"            AND t_institute_info_detail.year_id = m_academic_year.year_id     ),\n" + 
			"        0     ) AS no_current_admited_stnt \n" + 
			"    FROM\n" + 
			"        m_academic_year,\n" + 
			"        m_institute \n" + 
			"    WHERE\n" + 
			"        m_academic_year.year_id IN (\n" + 
			"           :acYearList \n" + 
			"        ) \n" + 
			"        AND m_institute.institute_id=:instId ",nativeQuery=true)

	List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@Param("instId")   int instId,@Param("acYearList")   List<Integer> acYearList);

}
