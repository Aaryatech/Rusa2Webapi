package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.AllBudgetGraph;
 
public interface AllBudgetGraphRepo extends JpaRepository<AllBudgetGraph, Integer> {
	
	
	@Query(value="SELECT\n" + 
			"t_library_budget.fin_year_id,\n" + 
			"   t_library_budget.budget_allocated,\n" + 
			"   t_library_budget.budget_utilized,\n" + 
			"  m_financial_year.fin_year\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_library_budget,\n" + 
			"    m_financial_year\n" + 
			"WHERE\n" + 
			"    t_library_budget.del_status = 1 AND t_library_budget.is_active = 1 AND t_library_budget.institute_id =:instId AND  m_financial_year.fin_year_id = t_library_budget.fin_year_id ORDER BY t_library_budget.lib_budget_id DESC LIMIT 5" + 
			"",nativeQuery=true)
	List<AllBudgetGraph> getLibraryBudget(@Param("instId")int instId);
	
	
	@Query(value="SELECT\n" + 
			"    t_library_book_budget.fin_year_id,\n" + 
			"    t_library_book_budget.ex_int2 AS budget_allocated,\n" + 
			"    t_library_book_budget.ex_int1 AS budget_utilized,\n" + 
			"    m_financial_year.fin_year\n" + 
			"FROM\n" + 
			"    t_library_book_budget,\n" + 
			"    m_financial_year\n" + 
			"WHERE\n" + 
			"    t_library_book_budget.del_status = 1 AND t_library_book_budget.is_active = 1 AND t_library_book_budget.institute_id =:instId AND m_financial_year.fin_year_id = t_library_book_budget.fin_year_id ORDER BY t_library_book_budget.library_book_budget_id DESC LIMIT 5" + 
			"",nativeQuery=true)
	List<AllBudgetGraph> getBookBudget(@Param("instId")int instId);
	
 	
	@Query(value="SELECT\n" + 
			"    t_infrastructure_budget.fin_year_id,\n" + 
			"    t_infrastructure_budget.budget_allocated,\n" + 
			"    t_infrastructure_budget.budget_utilized,\n" + 
			"    m_financial_year.fin_year\n" + 
			"FROM\n" + 
			"    t_infrastructure_budget,\n" + 
			"    m_financial_year\n" + 
			"WHERE\n" + 
			"    t_infrastructure_budget.del_status = 1 AND t_infrastructure_budget.is_active = 1 AND t_infrastructure_budget.institute_id =:instId AND m_financial_year.fin_year_id = t_infrastructure_budget.fin_year_id\n" + 
			"    \n" + 
			"    ORDER BY t_infrastructure_budget.infra_budget_id DESC LIMIT 5",nativeQuery=true)
	List<AllBudgetGraph> getInfrastructureBudget(@Param("instId")int instId);
	
	@Query(value="SELECT\n" + 
			"t_academic_budget.fin_year_id,\n" + 
			"   t_academic_budget.budget_allocated,\n" + 
			"   t_academic_budget.budget_utilized,\n" + 
			"  m_financial_year.fin_year\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_academic_budget,\n" + 
			"    m_financial_year\n" + 
			"WHERE\n" + 
			"    t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.institute_id =:instId AND    m_financial_year.fin_year_id = t_academic_budget.fin_year_id ORDER BY t_academic_budget.academic_budget_id DESC LIMIT 5",nativeQuery=true)
	List<AllBudgetGraph> getAcademicBudget(@Param("instId")int instId);
	
	

}
