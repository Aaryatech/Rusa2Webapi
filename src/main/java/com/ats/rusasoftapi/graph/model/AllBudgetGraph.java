package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AllBudgetGraph {
	
	@Id
	private int finYearId;
	
	private String budgetAllocated;
	
	private String budgetUtilized;
	
	private String finYear;

	 

	public String getBudgetAllocated() {
		return budgetAllocated;
	}

	public void setBudgetAllocated(String budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}

	public String getBudgetUtilized() {
		return budgetUtilized;
	}

	public void setBudgetUtilized(String budgetUtilized) {
		this.budgetUtilized = budgetUtilized;
	}

	 
	public int getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(int finYearId) {
		this.finYearId = finYearId;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	 
}
