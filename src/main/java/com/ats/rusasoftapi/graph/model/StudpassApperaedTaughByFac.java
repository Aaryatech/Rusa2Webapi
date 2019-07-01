package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudpassApperaedTaughByFac {
	@Id
	private int subId;

	private String subName;

	private int subStuAppear;

	private int subStuPassed;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getSubStuAppear() {
		return subStuAppear;
	}

	public void setSubStuAppear(int subStuAppear) {
		this.subStuAppear = subStuAppear;
	}

	public int getSubStuPassed() {
		return subStuPassed;
	}

	public void setSubStuPassed(int subStuPassed) {
		this.subStuPassed = subStuPassed;
	}

	@Override
	public String toString() {
		return "StudpassApperaedTaughByFac [subId=" + subId + ", subName=" + subName + ", subStuAppear=" + subStuAppear
				+ ", subStuPassed=" + subStuPassed + ", getSubId()=" + getSubId() + ", getSubName()=" + getSubName()
				+ ", getSubStuAppear()=" + getSubStuAppear() + ", getSubStuPassed()=" + getSubStuPassed()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	

}
