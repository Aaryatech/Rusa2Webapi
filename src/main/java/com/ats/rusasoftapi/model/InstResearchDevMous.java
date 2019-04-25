package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_inst_research_dev_mous")
public class InstResearchDevMous {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instReasearchDevMouId;
	private int researchDevMouId;
	private int instId;
	private int acYearId;
	private String mouTitle;
	private String orgName;
	private String mouSignedYear;
	private Date durFromdt;
	private Date durTodt;
	private String activitiesMou;
	private int noOfStudBenif;
	private int noOfStaffBenif;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String makerDatetime;
	private int exInt1;
	private String exVar1;
	private int exInt2;
	private String exVar2;
	public int getInstReasearchDevMouId() {
		return instReasearchDevMouId;
	}
	public void setInstReasearchDevMouId(int instReasearchDevMouId) {
		this.instReasearchDevMouId = instReasearchDevMouId;
	}
	public int getResearchDevMouId() {
		return researchDevMouId;
	}
	public void setResearchDevMouId(int researchDevMouId) {
		this.researchDevMouId = researchDevMouId;
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
	
	public String getMouTitle() {
		return mouTitle;
	}
	public void setMouTitle(String mouTitle) {
		this.mouTitle = mouTitle;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMouSignedYear() {
		return mouSignedYear;
	}
	public void setMouSignedYear(String mouSignedYear) {
		this.mouSignedYear = mouSignedYear;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDurFromdt() {
		return durFromdt;
	}
	public void setDurFromdt(Date durFromdt) {
		this.durFromdt = durFromdt;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDurTodt() {
		return durTodt;
	}
	public void setDurTodt(Date durTodt) {
		this.durTodt = durTodt;
	}
	public String getActivitiesMou() {
		return activitiesMou;
	}
	public void setActivitiesMou(String activitiesMou) {
		this.activitiesMou = activitiesMou;
	}
	public int getNoOfStudBenif() {
		return noOfStudBenif;
	}
	public void setNoOfStudBenif(int noOfStudBenif) {
		this.noOfStudBenif = noOfStudBenif;
	}
	public int getNoOfStaffBenif() {
		return noOfStaffBenif;
	}
	public void setNoOfStaffBenif(int noOfStaffBenif) {
		this.noOfStaffBenif = noOfStaffBenif;
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
	public String getMakerDatetime() {
		return makerDatetime;
	}
	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	public int getExInt2() {
		return exInt2;
	}
	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}
	public String getExVar2() {
		return exVar2;
	}
	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	@Override
	public String toString() {
		return "InstResearchDevMous [instReasearchDevMouId=" + instReasearchDevMouId + ", researchDevMouId="
				+ researchDevMouId + ", instId=" + instId + ", acYearId=" + acYearId + ", mouTitle=" + mouTitle
				+ ", orgName=" + orgName + ", mouSignedYear=" + mouSignedYear + ", durFromdt=" + durFromdt
				+ ", durTodt=" + durTodt + ", activitiesMou=" + activitiesMou + ", noOfStudBenif=" + noOfStudBenif
				+ ", noOfStaffBenif=" + noOfStaffBenif + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exVar1=" + exVar1 + ", exInt2=" + exInt2 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
