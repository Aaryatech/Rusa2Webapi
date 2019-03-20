package com.ats.rusasoft.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_faculty_phdguide")
public class FacultyPhdGuide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phdId;
	private int facultyId;
	private int yearId;
	private int	isPhdGuide;
	private int	isCoGuide;
	private String coGuideName;
	private String phdScholarName;
	private Date phdRegYear;
	private String phdTopic;
	private int isPhdAwarded;
	private Date  phdAwardedYear;
	private int delStatus;
	private int	isActive;
	private int makerUserId;
	private String makerEnterDatetime;
	private int exInt1;
	private String exVar1;
	
	public int getPhdId() {
		return phdId;
	}
	public void setPhdId(int phdId) {
		this.phdId = phdId;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getYearId() {
		return yearId;
	}
	public void setYearId(int yearId) {
		this.yearId = yearId;
	}
	public int getIsPhdGuide() {
		return isPhdGuide;
	}
	public void setIsPhdGuide(int isPhdGuide) {
		this.isPhdGuide = isPhdGuide;
	}
	public int getIsCoGuide() {
		return isCoGuide;
	}
	public void setIsCoGuide(int isCoGuide) {
		this.isCoGuide = isCoGuide;
	}
	public String getCoGuideName() {
		return coGuideName;
	}
	public void setCoGuideName(String coGuideName) {
		this.coGuideName = coGuideName;
	}
	public String getPhdScholarName() {
		return phdScholarName;
	}
	public void setPhdScholarName(String phdScholarName) {
		this.phdScholarName = phdScholarName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPhdRegYear() {
		return phdRegYear;
	}
	public void setPhdRegYear(Date phdRegYear) {
		this.phdRegYear = phdRegYear;
	}
	public String getPhdTopic() {
		return phdTopic;
	}
	public void setPhdTopic(String phdTopic) {
		this.phdTopic = phdTopic;
	}
	public int getIsPhdAwarded() {
		return isPhdAwarded;
	}
	public void setIsPhdAwarded(int isPhdAwarded) {
		this.isPhdAwarded = isPhdAwarded;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPhdAwardedYear() {
		return phdAwardedYear;
	}
	public void setPhdAwardedYear(Date phdAwardedYear) {
		this.phdAwardedYear = phdAwardedYear;
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
	public int getMakerUserId() {
		return makerUserId;
	}
	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}
	public String getMakerEnterDatetime() {
		return makerEnterDatetime;
	}
	public void setMakerEnterDatetime(String makerEnterDatetime) {
		this.makerEnterDatetime = makerEnterDatetime;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	@Override
	public String toString() {
		return "FacultyPhdGuide [phdId=" + phdId + ", facultyId=" + facultyId + ", yearId=" + yearId + ", isPhdGuide="
				+ isPhdGuide + ", isCoGuide=" + isCoGuide + ", coGuideName=" + coGuideName + ", phdScholarName="
				+ phdScholarName + ", phdRegYear=" + phdRegYear + ", phdTopic=" + phdTopic + ", isPhdAwarded="
				+ isPhdAwarded + ", phdAwardedYear=" + phdAwardedYear + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", makerUserId=" + makerUserId + ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1="
				+ exInt1 + ", exVar1=" + exVar1 + "]";
	}
	
	
	
}
