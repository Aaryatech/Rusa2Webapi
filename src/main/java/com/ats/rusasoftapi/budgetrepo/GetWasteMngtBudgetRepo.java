package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.GetWasteMngtBudget;

public interface GetWasteMngtBudgetRepo extends JpaRepository<GetWasteMngtBudget, Integer> {

	@Query(value = " 	SELECT  t_waste_mngt_budget.waste_mngt_budget_id, t_waste_mngt_budget.ex_var1, t_waste_mngt_budget.ex_var2, t_waste_mngt_budget.ex_int1,"
			+ " t_waste_mngt_budget.institute_id, t_waste_mngt_budget.fin_year_id,"
			+ " t_waste_mngt_budget.ac_year_id, t_waste_mngt_budget.waste_mngt_budget_title"
			+ ",t_waste_mngt_budget.budget_allocated, t_waste_mngt_budget.budget_utilized,"
			+ "   m_academic_year.academic_year,  m_financial_year.fin_year  FROM "
			+ "    t_waste_mngt_budget  LEFT JOIN  m_financial_year  "
			+ " ON t_waste_mngt_budget.fin_year_id=m_financial_year.fin_year_id  LEFT JOIN"
			+ "  m_academic_year ON t_waste_mngt_budget.ac_year_id=m_academic_year.year_id  "
			+ " WHERE  t_waste_mngt_budget.del_status=1 AND t_waste_mngt_budget.is_active=1 "
			+ "    AND t_waste_mngt_budget.institute_id=:instId "
			+ " AND t_waste_mngt_budget.ac_year_id=:acYearId ", nativeQuery = true)

	List<GetWasteMngtBudget> getWasteMngtBudgetList(@Param("instId") int instId, @Param("acYearId") int acYearId);

}
