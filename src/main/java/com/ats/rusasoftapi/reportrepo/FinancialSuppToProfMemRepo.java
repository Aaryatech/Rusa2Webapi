package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusasoftapi.model.report.FinancialSuppToProfMem;

public interface FinancialSuppToProfMemRepo extends JpaRepository<FinancialSuppToProfMem , Integer> {

	

	@Query(value="SELECT\n" + 
			"    faculty_empowerment.faculty_empwrmnt_id,\n" + 
			"    faculty_empowerment.name_of_acitvity,\n" + 
			"    m_dept.dept_name,\n" + 
			"    faculty_empowerment.title,\n" + 
			"    faculty_empowerment.amt_recvd_from,\n" + 
			"    faculty_empowerment.financial_support,\n" + 
			"    faculty_empowerment.ac_year_id,\n" + 
			"    faculty_empowerment.inst_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    faculty_empowerment.ex_var1 AS amt_received,  m_faculty.faculty_first_name, m_faculty.faculty_last_name \n" + 
			"FROM\n" + 
			"    faculty_empowerment,\n" + 
			"    m_institute,\n" + 
			"    m_faculty,\n" + 
			"    m_dept,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    faculty_empowerment.inst_id = m_institute.institute_id AND faculty_empowerment.ac_year_id = m_academic_year.year_id AND faculty_empowerment.ex_int1 = m_faculty.faculty_id AND m_faculty.dept_id = m_dept.dept_id AND faculty_empowerment.inst_id =:instId AND faculty_empowerment.ac_year_id IN(:acYearList) AND faculty_empowerment.financial_support = 1  AND  faculty_empowerment.amt_recvd_from=:keyVal \n" + 
			"ORDER BY `faculty_empowerment`.`faculty_empwrmnt_id` ASC",nativeQuery=true)
	List<FinancialSuppToProfMem> getAllFinancialSuppToProfMemInst(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("keyVal") String keyVal);


	@Query(value="SELECT\n" + 
			"    faculty_empowerment.faculty_empwrmnt_id,\n" + 
			"    faculty_empowerment.name_of_acitvity,\n" + 
			"    m_dept.dept_name,\n" + 
			"    faculty_empowerment.title,\n" + 
			"    faculty_empowerment.amt_recvd_from,\n" + 
			"    faculty_empowerment.financial_support,\n" + 
			"    faculty_empowerment.ac_year_id,\n" + 
			"    faculty_empowerment.inst_id,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    m_institute.institute_name,\n" + 
			"    faculty_empowerment.ex_var1 AS amt_received,  m_faculty.faculty_first_name, m_faculty.faculty_last_name \n" + 
			"FROM\n" + 
			"    faculty_empowerment,\n" + 
			"    m_institute,\n" + 
			"    m_faculty,\n" + 
			"    m_dept,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    faculty_empowerment.inst_id = m_institute.institute_id AND faculty_empowerment.ac_year_id = m_academic_year.year_id AND faculty_empowerment.ex_int1 = m_faculty.faculty_id AND m_faculty.dept_id = m_dept.dept_id AND faculty_empowerment.inst_id =:instId AND faculty_empowerment.ac_year_id IN(:acYearList) AND faculty_empowerment.financial_support = 1  AND  faculty_empowerment.amt_recvd_from !=:keyVal \n" + 
			"ORDER BY `faculty_empowerment`.`faculty_empwrmnt_id` ASC",nativeQuery=true)
	List<FinancialSuppToProfMem> getAllFinancialSuppToProfMem(@Param("instId") int instId,@Param("acYearList") List<Integer> acYearList,@Param("keyVal") String keyVal);

}
