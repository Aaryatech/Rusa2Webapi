package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetAccOfficer {
	@Id
	private int officerId;

	private String accOfficerName;

	private String contactNo;
	private String email;
	
	private Date joiningDate; 
	
	private String  qualificationName ;

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
	}

	public String getAccOfficerName() {
		return accOfficerName;
	}

	public void setAccOfficerName(String accOfficerName) {
		this.accOfficerName = accOfficerName;
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

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	@Override
	public String toString() {
		return "GetAccOfficer [officerId=" + officerId + ", accOfficerName=" + accOfficerName + ", contactNo="
				+ contactNo + ", email=" + email + ", joiningDate=" + joiningDate + ", qualificationName="
				+ qualificationName + "]";
	}
	
	
	

}
