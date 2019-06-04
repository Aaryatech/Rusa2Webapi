package com.ats.rusasoftapi.reportrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.report.ExpndGreenInitveWsteMgmt;

public interface ExpndGreenInitveWsteMgmtRepo extends JpaRepository<ExpndGreenInitveWsteMgmt, Integer> {
 
 @Query(value="SELECT t_waste_mngt_budget.waste_mngt_budget_id, t_waste_mngt_budget.budget_allocated, t_waste_mngt_budget.budget_utilized, "
 		+ "t_waste_mngt_budget.ex_int1 as ttl_expnd, m_financial_year.fin_year, m_institute.institute_name, m_academic_year.academic_year "
 		+ "FROM t_waste_mngt_budget,m_institute,m_financial_year,m_academic_year "
 		+ "WHERE t_waste_mngt_budget.fin_year_id=m_financial_year.fin_year_id AND t_waste_mngt_budget.institute_id=m_institute.institute_id AND "
 		+ "t_waste_mngt_budget.del_status=1 AND t_waste_mngt_budget.is_active=1 AND t_waste_mngt_budget.ac_year_id IN (:lastFiveYears) AND "
 		+ "t_waste_mngt_budget.institute_id=:instId AND t_waste_mngt_budget.ac_year_id=m_academic_year.year_id",nativeQuery=true)
 List<ExpndGreenInitveWsteMgmt> getAllExpndGreenInitveWsteMgmt(@Param("instId") int instId, @Param("lastFiveYears") List<Integer> lastFiveYears);

}
