package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.GetLibraryBookBudget;

public interface GetLibraryBookBudgetRepo extends JpaRepository<GetLibraryBookBudget, Integer> {

	@Query(value = " 	SELECT t_library_book_budget.library_book_budget_id, t_library_book_budget.ex_var1, t_library_book_budget.ex_var2,t_library_book_budget.ex_int1,"
			+ " t_library_book_budget.institute_id,t_library_book_budget.fin_year_id,t_library_book_budget.ac_year_id,"
			+ " t_library_book_budget.expenditure_on_book_purchase,t_library_book_budget.expenditure_on_journals_purchase,"
			+ " t_library_book_budget.expenditure_on_ejournals_purchase,t_library_book_budget.expenditure_on_eresources_purchase,"
			+ " m_academic_year.academic_year,  m_financial_year.fin_year  FROM "
			+ " t_library_book_budget  LEFT JOIN  m_financial_year  "
			+ " ON t_library_book_budget.fin_year_id=m_financial_year.fin_year_id " + " LEFT JOIN "
			+ "   m_academic_year ON t_library_book_budget.ac_year_id=m_academic_year.year_id  "
			+ "  WHERE  t_library_book_budget.del_status=1 AND t_library_book_budget.is_active=1 "
			+ "   AND t_library_book_budget.institute_id=:instId "
			+ " AND t_library_book_budget.ac_year_id=:acYearId ORDER By t_library_book_budget.library_book_budget_id Desc", nativeQuery = true)

	List<GetLibraryBookBudget> getLibraryBookBudgetList(@Param("instId") int instId, @Param("acYearId") int acYearId);

}
