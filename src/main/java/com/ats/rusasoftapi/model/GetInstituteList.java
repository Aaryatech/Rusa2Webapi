package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetInstituteList {
	
	@Id
	private int instituteId;

	private String instituteName;
	
	private String principalName;
	private String contactNo;
	private String email;
	private Date makerEnterDatetime;
	
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm")
	public Date getMakerEnterDatetime() {	
		return makerEnterDatetime;
	}
	public void setMakerEnterDatetime(Date makerEnterDatetime) {
		this.makerEnterDatetime = makerEnterDatetime;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
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
	@Override
	public String toString() {
		return "GetInstituteList [instituteId=" + instituteId + ", instituteName=" + instituteName + ", principalName="
				+ principalName + ", contactNo=" + contactNo + ", email=" + email + ", makerEnterDatetime="
				+ makerEnterDatetime + "]";
	}
	
	
}
