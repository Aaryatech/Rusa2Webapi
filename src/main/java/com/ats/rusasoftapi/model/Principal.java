package com.ats.rusasoftapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_principal")
public class Principal {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int principalId;
	
	private String principalName;
	
	private String phoneNo;
	
	private String email;
	
	private int instituteId;
	
	private int isEnroll;
	
	
	

	public int getIsEnroll() {
		return isEnroll;
	}

	public void setIsEnroll(int isEnroll) {
		this.isEnroll = isEnroll;
	}

	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	@Override
	public String toString() {
		return "Principal [principalId=" + principalId + ", principalName=" + principalName + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", instituteId=" + instituteId + ", isEnroll=" + isEnroll + "]";
	}
	
	
	

}
