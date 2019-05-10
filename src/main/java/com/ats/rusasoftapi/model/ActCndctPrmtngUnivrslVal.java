package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="act_cndct_prmtng_univrsl_val")
public class ActCndctPrmtngUnivrslVal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actCndctId;
	private String ttleProgrmAct;	
	private Date fromDate;
	private Date toDate;
	private int noOfParticipant;
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
	public int getActCndctId() {
		return actCndctId;
	}
	public void setActCndctId(int actCndctId) {
		this.actCndctId = actCndctId;
	}
	public String getTtleProgrmAct() {
		return ttleProgrmAct;
	}
	public void setTtleProgrmAct(String ttleProgrmAct) {
		this.ttleProgrmAct = ttleProgrmAct;
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
	public int getNoOfParticipant() {
		return noOfParticipant;
	}
	public void setNoOfParticipant(int noOfParticipant) {
		this.noOfParticipant = noOfParticipant;
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
		return "ActCndctPrmtngUnivrslVal [actCndctId=" + actCndctId + ", ttleProgrmAct=" + ttleProgrmAct + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", noOfParticipant=" + noOfParticipant + ", instId=" + instId
				+ ", acYearId=" + acYearId + ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId="
				+ makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
