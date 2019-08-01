package com.ats.rusasoftapi.model.instprofile;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetInstituteQuality {
	
	@Id
	private int qualityId;
	
	private int qualityInitiativeId; 
	
	private Date qualityFromdt;
	private Date qualityTodt;
	
	private int qualityPcount;
	
	private String qualityInitiativeName;
	
	private int exInt1;	
	private String exVar1;
	private String exVar2;
	
	
	private int isApplicable;
	private int isApplied;
	private int isCertiObt;	
	private String autonomyValidity;	
	
	
	public String getAutonomyValidity() {
		return autonomyValidity;
	}

	public void setAutonomyValidity(String autonomyValidity) {
		this.autonomyValidity = autonomyValidity;
	}

	public int getIsApplicable() {
		return isApplicable;
	}

	public void setIsApplicable(int isApplicable) {
		this.isApplicable = isApplicable;
	}

	public int getIsApplied() {
		return isApplied;
	}

	public void setIsApplied(int isApplied) {
		this.isApplied = isApplied;
	}

	public int getIsCertiObt() {
		return isCertiObt;
	}

	public void setIsCertiObt(int isCertiObt) {
		this.isCertiObt = isCertiObt;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getQualityId() {
		return qualityId;
	}

	public void setQualityId(int qualityId) {
		this.qualityId = qualityId;
	}

	public int getQualityInitiativeId() {
		return qualityInitiativeId;
	}

	public void setQualityInitiativeId(int qualityInitiativeId) {
		this.qualityInitiativeId = qualityInitiativeId;
	}

	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getQualityFromdt() {
		return qualityFromdt;
	}

	public void setQualityFromdt(Date qualityFromdt) {
		this.qualityFromdt = qualityFromdt;
	}

	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getQualityTodt() {
		return qualityTodt;
	}

	public void setQualityTodt(Date qualityTodt) {
		this.qualityTodt = qualityTodt;
	}

	public int getQualityPcount() {
		return qualityPcount;
	}

	public void setQualityPcount(int qualityPcount) {
		this.qualityPcount = qualityPcount;
	}

	public String getQualityInitiativeName() {
		return qualityInitiativeName;
	}

	public void setQualityInitiativeName(String qualityInitiativeName) {
		this.qualityInitiativeName = qualityInitiativeName;
	}
	

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}
	
	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	@Override
	public String toString() {
		return "GetInstituteQuality [qualityId=" + qualityId + ", qualityInitiativeId=" + qualityInitiativeId
				+ ", qualityFromdt=" + qualityFromdt + ", qualityTodt=" + qualityTodt + ", qualityPcount="
				+ qualityPcount + ", qualityInitiativeName=" + qualityInitiativeName + ", exInt1=" + exInt1
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", isApplicable=" + isApplicable + ", isApplied="
				+ isApplied + ", isCertiObt=" + isCertiObt + ", autonomyValidity=" + autonomyValidity + "]";
	}

	
}
