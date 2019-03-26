package com.ats.rusasoft.budgetrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.budget.LibraryBudget;

public interface LibraryBudgetRepo extends JpaRepository<LibraryBudget, Integer>{

	LibraryBudget findByDelStatusAndIsActiveAndFinYearId(int i, int j, int curFinYear);
	
	
	LibraryBudget findByDelStatusAndIsActiveAndLibBudgetId(int i, int j, int libBudgetId);

	
	
	

}
