package com.ats.rusasoft.model.instprofile;

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

	@Override
	public String toString() {
		return "GetInstituteQuality [qualityId=" + qualityId + ", qualityInitiativeId=" + qualityInitiativeId
				+ ", qualityFromdt=" + qualityFromdt + ", qualityTodt=" + qualityTodt + ", qualityPcount="
				+ qualityPcount + ", qualityInitiativeName=" + qualityInitiativeName + "]";
	} 

}
