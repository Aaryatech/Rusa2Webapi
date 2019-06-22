package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.GetLibraryBudget;

public interface GetLibraryBudgetRepo extends JpaRepository<GetLibraryBudget, Integer> {
	
	
	@Query(value = " SELECT t_library_budget.lib_budget_id,t_library_budget.ex_var1, t_library_budget.ex_var2,t_library_budget.fin_year_id,t_library_budget.institute_id,t_library_budget.ac_year_id,t_library_budget.lib_budget_title,t_library_budget.budget_allocated,t_library_budget.budget_utilized," + 
			" m_academic_year.academic_year,m_financial_year.fin_year,t_library_budget.ex_int1 " + 
			" FROM t_library_budget " + 
			" LEFT JOIN m_financial_year " + 
			" ON t_library_budget.fin_year_id=m_financial_year.fin_year_id " + 
			" LEFT JOIN m_academic_year " + 
			" ON t_library_budget.ac_year_id=m_academic_year.year_id " + 
			" WHERE t_library_budget.del_status=1 AND t_library_budget.is_active=1 AND t_library_budget.institute_id=:instId "
			+ " AND  t_library_budget.ac_year_id=:acYearId ", nativeQuery = true)
	List<GetLibraryBudget> getInfraStructureBudgetList(@Param("instId") int instId,
			@Param("acYearId") int acYearId);
	

}
