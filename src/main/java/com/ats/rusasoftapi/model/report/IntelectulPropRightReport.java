package com.ats.rusasoftapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IntelectulPropRightReport {
	@Id
	private int conId;
	private String conName;
	private Date conFromdt;
	private Date conTodt;
	private int conPcount;
	private String academicYear;
	private String instituteName;
	public int getConId() {
		return conId;
	}
	public void setConId(int conId) {
		this.conId = conId;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getConFromdt() {
		return conFromdt;
	}
	public void setConFromdt(Date conFromdt) {
		this.conFromdt = conFromdt;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getConTodt() {
		return conTodt;
	}
	public void setConTodt(Date conTodt) {
		this.conTodt = conTodt;
	}
	public int getConPcount() {
		return conPcount;
	}
	public void setConPcount(int conPcount) {
		this.conPcount = conPcount;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	@Override
	public String toString() {
		return "IntelectulPropRightReport [conId=" + conId + ", conName=" + conName + ", conFromdt=" + conFromdt
				+ ", conTodt=" + conTodt + ", conPcount=" + conPcount + ", academicYear=" + academicYear
				+ ", instituteName=" + instituteName + "]";
	}
	
	
}
