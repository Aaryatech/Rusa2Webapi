package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_faculty_patent")
public class FacultyPatent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patent_id")
	private int patentId;
	
	@Column(name="faculty_id ")
	private int facultyId ;
	
	@Column(name="year_id")
	private int yearId;
	
	@Column(name="patent_file_no")
	private String patentFileNo;
	
	@Column(name="patent_title")
	private String patentTitle;
	
	@Column(name="patent_filing_date")
	private String patentFilingDate;
	
	@Column(name="patent_guide_name")
	private String patentGuideName;
	
	@Column(name="patent_pub_date")
	private String patentPubDate;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active ")
	private int isActive ;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="maker_enter_datetime")
	private String makerEnterDatetime;
	
	@Column(name=" 	ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;

	public int getPatentId() {
		return patentId;
	}

	public void setPatentId(int patentId) {
		this.patentId = patentId;
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

	public String getPatentFileNo() {
		return patentFileNo;
	}

	public void setPatentFileNo(String patentFileNo) {
		this.patentFileNo = patentFileNo;
	}

	public String getPatentTitle() {
		return patentTitle;
	}

	public void setPatentTitle(String patentTitle) {
		this.patentTitle = patentTitle;
	}

	public String getPatentFilingDate() {
		return patentFilingDate;
	}

	public void setPatentFilingDate(String patentFilingDate) {
		this.patentFilingDate = patentFilingDate;
	}

	public String getPatentGuideName() {
		return patentGuideName;
	}

	public void setPatentGuideName(String patentGuideName) {
		this.patentGuideName = patentGuideName;
	}

	public String getPatentPubDate() {
		return patentPubDate;
	}

	public void setPatentPubDate(String patentPubDate) {
		this.patentPubDate = patentPubDate;
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
		return "FacultyPatent [patentId=" + patentId + ", facultyId=" + facultyId + ", yearId=" + yearId
				+ ", patentFileNo=" + patentFileNo + ", patentTitle=" + patentTitle + ", patentFilingDate="
				+ patentFilingDate + ", patentGuideName=" + patentGuideName + ", patentPubDate=" + patentPubDate
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	

}
