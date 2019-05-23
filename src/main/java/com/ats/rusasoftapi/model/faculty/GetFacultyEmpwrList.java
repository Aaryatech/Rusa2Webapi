package com.ats.rusasoftapi.model.faculty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetFacultyEmpwrList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facultyEmpwrmntId;
	private String nameOfAcitvity;
	private String title;
	private String amt_recvd_from;
	private Date fromDate;
	private Date toDate;
	private String amount;
	private String facultyName;
	private String department;
	//private int yearId;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "GetFacultyEmpwrList [facultyEmpwrmntId=" + facultyEmpwrmntId + ", nameOfAcitvity=" + nameOfAcitvity
				+ ", title=" + title + ", amt_recvd_from=" + amt_recvd_from + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", amount=" + amount + ", facultyName=" + facultyName + ", department=" + department + "]";
	}
	
	
	
}
