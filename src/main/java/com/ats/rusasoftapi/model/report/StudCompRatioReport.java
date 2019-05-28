package com.ats.rusasoftapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class StudCompRatioReport {
@Id
	private int instItInfraInfoId;
	private int noOfComputers;
	private Date purchaseDate;
	private int purchaseAmt;
	private int noOfStudUtilizing;
	private String instituteName;
	public int getInstItInfraInfoId() {
		return instItInfraInfoId;
	}
	public void setInstItInfraInfoId(int instItInfraInfoId) {
		this.instItInfraInfoId = instItInfraInfoId;
	}
	public int getNoOfComputers() {
		return noOfComputers;
	}
	public void setNoOfComputers(int noOfComputers) {
		this.noOfComputers = noOfComputers;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPurchaseAmt() {
		return purchaseAmt;
	}
	public void setPurchaseAmt(int purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}
	public int getNoOfStudUtilizing() {
		return noOfStudUtilizing;
	}
	public void setNoOfStudUtilizing(int noOfStudUtilizing) {
		this.noOfStudUtilizing = noOfStudUtilizing;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	@Override
	public String toString() {
		return "StudCompRatioReport [instItInfraInfoId=" + instItInfraInfoId + ", noOfComputers=" + noOfComputers
				+ ", purchaseDate=" + purchaseDate + ", purchaseAmt=" + purchaseAmt + ", noOfStudUtilizing="
				+ noOfStudUtilizing + ", instituteName=" + instituteName + "]";
	}
	
	
}
