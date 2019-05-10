package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="specific_local_advntg_disadvntg")
public class SpecificLocalAdvntgDisadvntg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int spciAdvId;
	private String nameOfInitiatives;
	private String issueAddress;
	private Date fromDate;
	private Date toDate;
	private int noStudPart;
	private int instId;
	private int acYearId;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String makerDatetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	public int getSpciAdvId() {
		return spciAdvId;
	}
	public void setSpciAdvId(int spciAdvId) {
		this.spciAdvId = spciAdvId;
	}
	public String getNameOfInitiatives() {
		return nameOfInitiatives;
	}
	public void setNameOfInitiatives(String nameOfInitiatives) {
		this.nameOfInitiatives = nameOfInitiatives;
	}
	public String getIssueAddress() {
		return issueAddress;
	}
	public void setIssueAddress(String issueAddress) {
		this.issueAddress = issueAddress;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getNoStudPart() {
		return noStudPart;
	}
	public void setNoStudPart(int noStudPart) {
		this.noStudPart = noStudPart;
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
		return "SpecificLocalAdvntgDisadvntg [spciAdvId=" + spciAdvId + ", nameOfInitiatives=" + nameOfInitiatives
				+ ", issueAddress=" + issueAddress + ", fromDate=" + fromDate + ", toDate=" + toDate + ", noStudPart="
				+ noStudPart + ", instId=" + instId + ", acYearId=" + acYearId + ", delStatus=" + delStatus
				+ ", isActive=" + isActive + ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	

}
