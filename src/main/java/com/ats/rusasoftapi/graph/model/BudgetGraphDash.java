package com.ats.rusasoftapi.graph.model;

public class BudgetGraphDash {

	private int allocAmt;
	private int utilAmt;
	private String budgetTitle;

	public int getAllocAmt() {
		return allocAmt;
	}

	public int getUtilAmt() {
		return utilAmt;
	}

	public String getBudgetTitle() {
		return budgetTitle;
	}

	public void setAllocAmt(int allocAmt) {
		this.allocAmt = allocAmt;
	}

	public void setUtilAmt(int utilAmt) {
		this.utilAmt = utilAmt;
	}

	public void setBudgetTitle(String budgetTitle) {
		this.budgetTitle = budgetTitle;
	}

	@Override
	public String toString() {
		return "BudgetGraphDash [allocAmt=" + allocAmt + ", utilAmt=" + utilAmt + ", budgetTitle=" + budgetTitle + "]";
	}

}
