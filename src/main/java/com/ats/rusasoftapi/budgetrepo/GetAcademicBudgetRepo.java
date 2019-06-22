package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.GetAcademicBudget;

public interface GetAcademicBudgetRepo extends JpaRepository<GetAcademicBudget, Integer> {

	@Query(value = " SELECT\n" + "    t_academic_budget.academic_budget_id, t_academic_budget.ex_var1, t_academic_budget.ex_var2, t_academic_budget.ex_int1,\n" + "    t_academic_budget.fin_year_id,\n"
			+ "    t_academic_budget.institute_id,\n" + "    t_academic_budget.ac_year_id,\n"
			+ "    t_academic_budget.academic_budget_title,\n" + "    t_academic_budget.budget_allocated,\n"
			+ "    t_academic_budget.budget_utilized,\n" + "    m_academic_year.academic_year,\n"
			+ "    m_financial_year.fin_year\n" + "FROM\n" + "    t_academic_budget\n"
			+ "LEFT JOIN m_financial_year ON t_academic_budget.fin_year_id = m_financial_year.fin_year_id\n"
			+ "LEFT JOIN m_academic_year ON t_academic_budget.ac_year_id = m_academic_year.year_id\n" + "WHERE\n"
			+ "    t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.institute_id =:instId AND t_academic_budget.ac_year_id =:acYearId", nativeQuery = true)

	List<GetAcademicBudget> getBudgetList(@Param("instId") int instId, @Param("acYearId") int acYearId);

}
