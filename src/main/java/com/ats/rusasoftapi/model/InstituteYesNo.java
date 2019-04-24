package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_institute_yesno")
public class InstituteYesNo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_yesno_id")
    private int instYesnoId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="year_id")
	private int yearId;
	
	@Column(name="yesno_id")
	private int yesnoId;
	
	@Column(name="yesno_pagecode")
	private String yesnoPagecode;
	
	@Column(name="yesno_dynamic_title")
	private String yesnoDynamicTitle;
	 
	@Column(name="inst_yesno_response")
	private String instYesnoResponse;  
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="maker_datetime")
	private String makerDatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="yesno_value")
	private int yesnoValue;
	
	@Column(name="section_code")
	private String sectionCode;
	
	public int getInstYesnoId() {
		return instYesnoId;
	}

	public void setInstYesnoId(int instYesnoId) {
		this.instYesnoId = instYesnoId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getYesnoId() {
		return yesnoId;
	}

	public void setYesnoId(int yesnoId) {
		this.yesnoId = yesnoId;
	}

	public String getYesnoPagecode() {
		return yesnoPagecode;
	}

	public void setYesnoPagecode(String yesnoPagecode) {
		this.yesnoPagecode = yesnoPagecode;
	}

	public String getYesnoDynamicTitle() {
		return yesnoDynamicTitle;
	}

	public void setYesnoDynamicTitle(String yesnoDynamicTitle) {
		this.yesnoDynamicTitle = yesnoDynamicTitle;
	}

	public String getInstYesnoResponse() {
		return instYesnoResponse;
	}

	public void setInstYesnoResponse(String instYesnoResponse) {
		this.instYesnoResponse = instYesnoResponse;
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

	public String getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public int getYesnoValue() {
		return yesnoValue;
	}

	public void setYesnoValue(int yesnoValue) {
		this.yesnoValue = yesnoValue;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	@Override
	public String toString() {
		return "InstituteYesNo [instYesnoId=" + instYesnoId + ", instituteId=" + instituteId + ", yearId=" + yearId
				+ ", yesnoId=" + yesnoId + ", yesnoPagecode=" + yesnoPagecode + ", yesnoDynamicTitle="
				+ yesnoDynamicTitle + ", instYesnoResponse=" + instYesnoResponse + ", delStatus=" + delStatus
				+ ", isActive=" + isActive + ", makerDatetime=" + makerDatetime + ", makerUserId=" + makerUserId
				+ ", yesnoValue=" + yesnoValue + ", sectionCode=" + sectionCode + "]";
	}
	
	
	
}
