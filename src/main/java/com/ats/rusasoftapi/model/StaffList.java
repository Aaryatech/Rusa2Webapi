package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class StaffList {


	@Id
	private int facultyId;
	private String facultyFirstName;
	/*private String facultyMiddelName;
	private String facultyLastName;*/
	private Date joiningDate;
	private Date realivingDate;
	private String contactNo;
	private String email;
	private int currentDesignationId ;
	private String qualificationName;
	private String designationName;
	private String deptName;
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyFirstName() {
		return facultyFirstName;
	}
	public void setFacultyFirstName(String facultyFirstName) {
		this.facultyFirstName = facultyFirstName;
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
	public int getCurrentDesignationId() {
		return currentDesignationId;
	}
	public void setCurrentDesignationId(int currentDesignationId) {
		this.currentDesignationId = currentDesignationId;
	}
	@Override
	public String toString() {
		return "StaffList [facultyId=" + facultyId + ", facultyFirstName=" + facultyFirstName + ", joiningDate="
				+ joiningDate + ", realivingDate=" + realivingDate + ", contactNo=" + contactNo + ", email=" + email
				+ ", currentDesignationId=" + currentDesignationId + ", qualificationName=" + qualificationName
				+ ", designationName=" + designationName + ", deptName=" + deptName + "]";
	}

	
		
}
