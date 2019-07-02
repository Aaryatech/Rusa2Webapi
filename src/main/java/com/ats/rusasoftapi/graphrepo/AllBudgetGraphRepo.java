package com.ats.rusasoftapi.graphrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.graph.model.AllBudgetGraph;
 
public interface AllBudgetGraphRepo extends JpaRepository<AllBudgetGraph, Integer> {
	
	
	@Query(value="SELECT\n" + 
			"t_library_budget.ac_year_id,\n" + 
			"   t_library_budget.budget_allocated,\n" + 
			"   t_library_budget.budget_utilized,\n" + 
			"    m_academic_year.academic_year\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_library_budget,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_library_budget.del_status = 1 AND t_library_budget.is_active = 1 AND t_library_budget.institute_id =:instId AND t_library_budget.ac_year_id IN (:lastFiveYears) AND m_academic_year.year_id = t_library_budget.ac_year_id\n" + 
			"",nativeQuery=true)
	List<AllBudgetGraph> getLibraryBudget(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	
	@Query(value="SELECT\n" + 
			"t_library_book_budget.ac_year_id,\n" + 
			"    t_library_book_budget.ex_int2 as budget_allocated,\n" + 
			"    t_library_book_budget.ex_int1 as budget_utilized,\n" + 
			"    m_academic_year.academic_year\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_library_book_budget,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_library_book_budget.del_status = 1 AND t_library_book_budget.is_active = 1 AND t_library_book_budget.institute_id =:instId AND t_library_book_budget.ac_year_id IN (:lastFiveYears) AND m_academic_year.year_id = t_library_book_budget.ac_year_id\n" + 
			"",nativeQuery=true)
	List<AllBudgetGraph> getBookBudget(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
 	
	@Query(value="SELECT\n" + 
			"    t_infrastructure_budget.ac_year_id,\n" + 
			"    t_infrastructure_budget.budget_allocated,\n" + 
			"    t_infrastructure_budget.budget_utilized,\n" + 
			"    m_academic_year.academic_year\n" + 
			"FROM\n" + 
			"    t_infrastructure_budget,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_infrastructure_budget.del_status = 1 AND t_infrastructure_budget.is_active = 1 AND t_infrastructure_budget.institute_id =:instId AND t_infrastructure_budget.ac_year_id IN (:lastFiveYears) AND m_academic_year.year_id = t_infrastructure_budget.ac_year_id",nativeQuery=true)
	List<AllBudgetGraph> getInfrastructureBudget(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	@Query(value="SELECT\n" + 
			"t_academic_budget.ac_year_id,\n" + 
			"   t_academic_budget.budget_allocated,\n" + 
			"   t_academic_budget.budget_utilized,\n" + 
			"    m_academic_year.academic_year\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_academic_budget,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    t_academic_budget.del_status = 1 AND t_academic_budget.is_active = 1 AND t_academic_budget.institute_id =:instId AND t_academic_budget.ac_year_id IN (:lastFiveYears) AND m_academic_year.year_id = t_academic_budget.ac_year_id",nativeQuery=true)
	List<AllBudgetGraph> getAcademicBudget(@Param("instId")int instId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	

}
