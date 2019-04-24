package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class DeansList {

	@Id
	private int deanId;
	private String deanName;
	private String contactNo;
	private String email;
	private Date joiningDate;
	private Date realivingDate;
	private String qualificationName;	
	
	public int getDeanId() {
		return deanId;
	}
	public void setDeanId(int deanId) {
		this.deanId = deanId;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	public String getDeanName() {
		return deanName;
	}
	public void setDeanName(String deanName) {
		this.deanName = deanName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRealivingDate() {
		return realivingDate;
	}
	public void setRealivingDate(Date realivingDate) {
		this.realivingDate = realivingDate;
	}
	@Override
	public String toString() {
		return "DeansList [deanId=" + deanId + ", deanName=" + deanName + ", contactNo=" + contactNo + ", email="
				+ email + ", joiningDate=" + joiningDate + ", realivingDate=" + realivingDate + ", qualificationName="
				+ qualificationName + "]";
	}
	
	
	
	
}
