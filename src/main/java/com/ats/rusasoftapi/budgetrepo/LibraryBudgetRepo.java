package com.ats.rusasoftapi.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.budget.LibraryBudget;

public interface LibraryBudgetRepo extends JpaRepository<LibraryBudget, Integer>{

	LibraryBudget findByDelStatusAndIsActiveAndFinYearIdAndInstituteId(int i, int j, int curFinYear, int instId);
	
	
	LibraryBudget findByDelStatusAndIsActiveAndLibBudgetId(int i, int j, int libBudgetId);

	@Transactional
	@Modifying
	@Query(value = " UPDATE t_library_budget SET del_status=0 WHERE lib_budget_id IN (:libBudgetIdList) ", nativeQuery = true)
	int deleteLibBudget(@Param("libBudgetIdList") List<String> libBudgetIdList);
	
	//int deleteLibBudget(List<String> libBudgetIdList);

}
