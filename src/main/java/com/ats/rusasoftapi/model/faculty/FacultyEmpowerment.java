package com.ats.rusasoftapi.model.faculty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "faculty_empowerment")
public class FacultyEmpowerment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facultyEmpwrmntId;
	private String nameOfAcitvity;
	private String title;
	private int financialSupport;
	private String amt_recvd_from;
	private Date fromDate;
	private Date toDate;
	private int instId;
	private int acYearId;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String makerEnterDatetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	public int getFacultyEmpwrmntId() {
		return facultyEmpwrmntId;
	}
	public void setFacultyEmpwrmntId(int facultyEmpwrmntId) {
		this.facultyEmpwrmntId = facultyEmpwrmntId;
	}
	public String getNameOfAcitvity() {
		return nameOfAcitvity;
	}
	public void setNameOfAcitvity(String nameOfAcitvity) {
		this.nameOfAcitvity = nameOfAcitvity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFinancialSupport() {
		return financialSupport;
	}
	public void setFinancialSupport(int financialSupport) {
		this.financialSupport = financialSupport;
	}
	public String getAmt_recvd_from() {
		return amt_recvd_from;
	}
	public void setAmt_recvd_from(String amt_recvd_from) {
		this.amt_recvd_from = amt_recvd_from;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public int getAcYearId() {
		return acYearId;
	}
	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
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
		return "FacultyEmpowerment [facultyEmpwrmntId=" + facultyEmpwrmntId + ", nameOfAcitvity=" + nameOfAcitvity
				+ ", title=" + title + ", financialSupport=" + financialSupport + ", amt_recvd_from=" + amt_recvd_from
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", instId=" + instId + ", acYearId=" + acYearId
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
