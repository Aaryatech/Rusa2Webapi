package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="m_iqac")
public class MIqac {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iqacId;
	private String iqacName;
	private int desgntnId;
	private int instituteId;
	private Date joiningDate;
	private String contactNo;
	private String email;
	private int delStatus;
	private int isActive;
	private int isEnrollSystem;
	private int makerUserId;
	private String makerEnterDatetime;
	private int checkerUserId;
	private String checkerDatetime;
	private String lastUpdatedDatetime;
	private int type;
	
	public int getIqacId() {
		return iqacId;
	}
	public void setIqacId(int iqacId) {
		this.iqacId = iqacId;
	}
	public String getIqacName() {
		return iqacName;
	}
	public void setIqacName(String iqacName) {
		this.iqacName = iqacName;
	}
	public int getDesgntnId() {
		return desgntnId;
	}
	public void setDesgntnId(int desgntnId) {
		this.desgntnId = desgntnId;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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
	public int getIsEnrollSystem() {
		return isEnrollSystem;
	}
	public void setIsEnrollSystem(int isEnrollSystem) {
		this.isEnrollSystem = isEnrollSystem;
	}
	public int getMakerUserId() {
		return makerUserId;
	}
	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}
	
	public String getMakerEnterDatetime() {
		return makerEnterDatetime;
	}
	public int getCheckerUserId() {
		return checkerUserId;
	}
	public void setCheckerUserId(int checkerUserId) {
		this.checkerUserId = checkerUserId;
	}
	
	public String getCheckerDatetime() {
		return checkerDatetime;
	}
	public void setCheckerDatetime(String checkerDatetime) {
		this.checkerDatetime = checkerDatetime;
	}
	public String getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}
	public void setLastUpdatedDatetime(String lastUpdatedDatetime) {
		this.lastUpdatedDatetime = lastUpdatedDatetime;
	}
	public void setMakerEnterDatetime(String makerEnterDatetime) {
		this.makerEnterDatetime = makerEnterDatetime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MIqac [iqacId=" + iqacId + ", iqacName=" + iqacName + ", desgntnId=" + desgntnId + ", instituteId="
				+ instituteId + ", joiningDate=" + joiningDate + ", contactNo=" + contactNo + ", email=" + email
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", isEnrollSystem=" + isEnrollSystem
				+ ", makerUserId=" + makerUserId + ", makerEnterDatetime=" + makerEnterDatetime + ", checkerUserId="
				+ checkerUserId + ", checkerDatetime=" + checkerDatetime + ", lastUpdatedDatetime="
				+ lastUpdatedDatetime + ", type=" + type + "]";
	}
	
	
	
}
