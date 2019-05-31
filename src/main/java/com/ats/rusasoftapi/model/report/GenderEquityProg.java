package com.ats.rusasoftapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GenderEquityProg {

	@Id
	private int gprogId;

	private String gprogName;

	private String academicYear;

	private Date gprogFromdt;

	private Date gprogTodt;

	private int pCount;

	private String instituteName;

	public int getGprogId() {
		return gprogId;
	}

	public void setGprogId(int gprogId) {
		this.gprogId = gprogId;
	}

	public String getGprogName() {
		return gprogName;
	}

	public void setGprogName(String gprogName) {
		this.gprogName = gprogName;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getGprogFromdt() {
		return gprogFromdt;
	}

	public void setGprogFromdt(Date gprogFromdt) {
		this.gprogFromdt = gprogFromdt;
	}

	public Date getGprogTodt() {
		return gprogTodt;
	}
	 
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public void setGprogTodt(Date gprogTodt) {
		this.gprogTodt = gprogTodt;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	@Override
	public String toString() {
		return "GenderEquityProg [gprogId=" + gprogId + ", gprogName=" + gprogName + ", academicYear=" + academicYear
				+ ", gprogFromdt=" + gprogFromdt + ", gprogTodt=" + gprogTodt + ", pCount=" + pCount
				+ ", instituteName=" + instituteName + ", getGprogId()=" + getGprogId() + ", getGprogName()="
				+ getGprogName() + ", getAcademicYear()=" + getAcademicYear() + ", getGprogFromdt()=" + getGprogFromdt()
				+ ", getGprogTodt()=" + getGprogTodt() + ", getpCount()=" + getpCount() + ", getInstituteName()="
				+ getInstituteName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
