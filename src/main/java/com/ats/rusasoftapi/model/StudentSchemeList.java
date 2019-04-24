package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class StudentSchemeList {

	@Id
	private int sprtSchmId;
	private Date  academicYear;
	private String schemeName;
	private String level;
	private String type;
	private int noStudentBenifited;
	private String supportAgencyName;
	private String extraVarchar1;
	
	
	public String getExtraVarchar1() {
		return extraVarchar1;
	}
	public void setExtraVarchar1(String extraVarchar1) {
		this.extraVarchar1 = extraVarchar1;
	}
	public int getSprtSchmId() {
		return sprtSchmId;
	}
	public void setSprtSchmId(int sprtSchmId) {
		this.sprtSchmId = sprtSchmId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNoStudentBenifited() {
		return noStudentBenifited;
	}
	public void setNoStudentBenifited(int noStudentBenifited) {
		this.noStudentBenifited = noStudentBenifited;
	}
	public String getSupportAgencyName() {
		return supportAgencyName;
	}
	public void setSupportAgencyName(String supportAgencyName) {
		this.supportAgencyName = supportAgencyName;
	}
	@Override
	public String toString() {
		return "StudentSchemeList [sprtSchmId=" + sprtSchmId + ", academicYear=" + academicYear + ", schemeName="
				+ schemeName + ", level=" + level + ", type=" + type + ", noStudentBenifited=" + noStudentBenifited
				+ ", supportAgencyName=" + supportAgencyName + ", extraVarchar1=" + extraVarchar1 + "]";
	}
	
	
	
	
}
