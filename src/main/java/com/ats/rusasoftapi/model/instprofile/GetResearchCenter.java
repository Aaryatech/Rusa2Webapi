package com.ats.rusasoftapi.model.instprofile;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetResearchCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rcId;

	private int instituteId;

	private int yearId;

	private String rcSubjectName;

	private String rcFacultyName;

	private Date rcValidityFromdt;
	private Date rcValidityTodt;

	private int rcGuideCount;

	private int rcStudentCount;

	private int delStatus;
	private int isActive;

	private int makerUserId;
	private String makerDatetime;

	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;

	public int getRcId() {
		return rcId;
	}

	public void setRcId(int rcId) {
		this.rcId = rcId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public String getRcSubjectName() {
		return rcSubjectName;
	}

	public void setRcSubjectName(String rcSubjectName) {
		this.rcSubjectName = rcSubjectName;
	}

	public String getRcFacultyName() {
		return rcFacultyName;
	}

	public void setRcFacultyName(String rcFacultyName) {
		this.rcFacultyName = rcFacultyName;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRcValidityFromdt() {
		return rcValidityFromdt;
	}

	public void setRcValidityFromdt(Date rcValidityFromdt) {
		this.rcValidityFromdt = rcValidityFromdt;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRcValidityTodt() {
		return rcValidityTodt;
	}

	public void setRcValidityTodt(Date rcValidityTodt) {
		this.rcValidityTodt = rcValidityTodt;
	}

	public int getRcGuideCount() {
		return rcGuideCount;
	}

	public void setRcGuideCount(int rcGuideCount) {
		this.rcGuideCount = rcGuideCount;
	}

	public int getRcStudentCount() {
		return rcStudentCount;
	}

	public void setRcStudentCount(int rcStudentCount) {
		this.rcStudentCount = rcStudentCount;
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

	public String getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "GetResearchCenter [rcId=" + rcId + ", instituteId=" + instituteId + ", yearId=" + yearId
				+ ", rcSubjectName=" + rcSubjectName + ", rcFacultyName=" + rcFacultyName + ", rcValidityFromdt="
				+ rcValidityFromdt + ", rcValidityTodt=" + rcValidityTodt + ", rcGuideCount=" + rcGuideCount
				+ ", rcStudentCount=" + rcStudentCount + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}

}
