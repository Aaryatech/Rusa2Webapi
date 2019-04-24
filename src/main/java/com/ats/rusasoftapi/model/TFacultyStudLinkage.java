package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_faculty_stud_linkage")
public class TFacultyStudLinkage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facultyStudLinkageId;
	private int instId;
	private int acYearId;
	private String linkageTitle;
	private String partneringInstitute;
	private String industryName;
	private String industryFromYear;
	private String researchLabName;
	private String labFromYear;
	private Date durationFrom;
	private Date durationTo;
	private String natureOfLinkage;
	private int noStudentParticipated;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String maker_datetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	public int getFacultyStudLinkageId() {
		return facultyStudLinkageId;
	}
	public void setFacultyStudLinkageId(int facultyStudLinkageId) {
		this.facultyStudLinkageId = facultyStudLinkageId;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public int getAcYearId() {
		return acYearId;
	}
	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
	}
	public String getLinkageTitle() {
		return linkageTitle;
	}
	public void setLinkageTitle(String linkageTitle) {
		this.linkageTitle = linkageTitle;
	}
	public String getPartneringInstitute() {
		return partneringInstitute;
	}
	public void setPartneringInstitute(String partneringInstitute) {
		this.partneringInstitute = partneringInstitute;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getIndustryFromYear() {
		return industryFromYear;
	}
	public void setIndustryFromYear(String industryFromYear) {
		this.industryFromYear = industryFromYear;
	}
	public String getResearchLabName() {
		return researchLabName;
	}
	public void setResearchLabName(String researchLabName) {
		this.researchLabName = researchLabName;
	}
	public String getLabFromYear() {
		return labFromYear;
	}
	public void setLabFromYear(String labFromYear) {
		this.labFromYear = labFromYear;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDurationFrom() {
		return durationFrom;
	}
	public void setDurationFrom(Date durationFrom) {
		this.durationFrom = durationFrom;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDurationTo() {
		return durationTo;
	}
	public void setDurationTo(Date durationTo) {
		this.durationTo = durationTo;
	}
	public String getNatureOfLinkage() {
		return natureOfLinkage;
	}
	public void setNatureOfLinkage(String natureOfLinkage) {
		this.natureOfLinkage = natureOfLinkage;
	}
	public int getNoStudentParticipated() {
		return noStudentParticipated;
	}
	public void setNoStudentParticipated(int noStudentParticipated) {
		this.noStudentParticipated = noStudentParticipated;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getMakerUserId() {
		return makerUserId;
	}
	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}
	public String getMaker_datetime() {
		return maker_datetime;
	}
	public void setMaker_datetime(String maker_datetime) {
		this.maker_datetime = maker_datetime;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public int getExInt2() {
		return exInt2;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public String getExVar2() {
		return exVar2;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	@Override
	public String toString() {
		return "TFacultyStudLinkage [facultyStudLinkageId=" + facultyStudLinkageId + ", instId=" + instId
				+ ", acYearId=" + acYearId + ", linkageTitle=" + linkageTitle + ", partneringInstitute="
				+ partneringInstitute + ", industryName=" + industryName + ", industryFromYear=" + industryFromYear
				+ ", researchLabName=" + researchLabName + ", labFromYear=" + labFromYear + ", durationFrom="
				+ durationFrom + ", durationTo=" + durationTo + ", natureOfLinkage=" + natureOfLinkage
				+ ", noStudentParticipated=" + noStudentParticipated + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", makerUserId=" + makerUserId + ", maker_datetime=" + maker_datetime + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
