package com.ats.rusasoft.budgetrepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoft.model.budget.LibraryBookBudget;

public interface LibraryBookBudgetRepo extends JpaRepository<LibraryBookBudget, Integer>{
	
	LibraryBookBudget findByDelStatusAndIsActiveAndFinYearId(int i, int j, int curFinYear);
	
	
	LibraryBookBudget findByDelStatusAndIsActiveAndLibraryBookBudgetId(int i, int j, int libraryBookBudgetId);

	@Transactional
	@Modifying
	@Query(value = " UPDATE t_library_book_budget SET del_status=0 WHERE library_book_budget_id IN (:libBookBudgetIdList) ", nativeQuery = true)
	int deleteLibBookBudget(@Param("libBookBudgetIdList") List<String> libBookBudgetIdList);
	

}
