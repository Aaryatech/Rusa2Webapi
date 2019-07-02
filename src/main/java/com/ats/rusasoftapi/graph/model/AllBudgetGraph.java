package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AllBudgetGraph {
	
	@Id
	private int acYearId;
	
	private String budgetAllocated;
	
	private String budgetUtilized;
	
	private String academicYear;

	public int getAcYearId() {
		return acYearId;
	}

	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
	}

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

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String toString() {
		return "AllBudgetGraph [acYearId=" + acYearId + ", budgetAllocated=" + budgetAllocated + ", budgetUtilized="
				+ budgetUtilized + ", academicYear=" + academicYear + ", getAcYearId()=" + getAcYearId()
				+ ", getBudgetAllocated()=" + getBudgetAllocated() + ", getBudgetUtilized()=" + getBudgetUtilized()
				+ ", getAcademicYear()=" + getAcademicYear() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
