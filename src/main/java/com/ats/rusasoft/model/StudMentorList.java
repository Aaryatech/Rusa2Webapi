package com.ats.rusasoft.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudMentorList {
	
	@Id
	private int menId;
	//private int yearId;
	private int menStuCount;
	private String academicYear;
	public int getMenId() {
		return menId;
	}
	public void setMenId(int menId) {
		this.menId = menId;
	}

	/*
	 * public int getYearId() { return yearId; } public void setYearId(int yearId) {
	 * this.yearId = yearId; }
	 */
	public int getMenStuCount() {
		return menStuCount;
	}
	public void setMenStuCount(int menStuCount) {
		this.menStuCount = menStuCount;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	@Override
	public String toString() {
		return "StudMentorList [menId=" + menId + ", menStuCount=" + menStuCount
				+ ", academicYear=" + academicYear + "]";
	}

}
	
 	
