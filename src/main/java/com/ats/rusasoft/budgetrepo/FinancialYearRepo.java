package com.ats.rusasoft.budgetrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoft.model.budget.FinancialYear;

public interface FinancialYearRepo extends JpaRepository<FinancialYear, Integer> {
	
	FinancialYear findByDelStatusAndIsActiveAndIsCurrentFy(int d,int i,int cFy);
	
	List<FinancialYear> findByDelStatusAndIsActive(int delStaus, int isActive);
	

}
