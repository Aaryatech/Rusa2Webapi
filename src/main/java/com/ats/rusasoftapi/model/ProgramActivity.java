package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_program_student_activity")
public class ProgramActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_activity_id")
	private int studentActivityId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="year_id")
	private int yearId;
	
	@Column(name="activity_name")
	private String activityName;
	
	@Column(name="other_compitition")
	private String otherCompitition;
	
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="year")
	private String year;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="participated_student")
	private int participatedStudent;
	
	@Column(name="level")
	private String level; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="type")
	private int type;
	
	@Column(name="aadhar_no")
	private String aadharNo;
	
	@Column(name="raw_activity_name")
	private String rawActivityName;
	
	
	
	
	public String getRawActivityName() {
		return rawActivityName;
	}
	public void setRawActivityName(String rawActivityName) {
		this.rawActivityName = rawActivityName;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getStudentActivityId() {
		return studentActivityId;
	}

	public void setStudentActivityId(int studentActivityId) {
		this.studentActivityId = studentActivityId;
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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getOtherCompitition() {
		return otherCompitition;
	}

	public void setOtherCompitition(String otherCompitition) {
		this.otherCompitition = otherCompitition;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBranch() {
		return branch;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getParticipatedStudent() {
		return participatedStudent;
	}

	public void setParticipatedStudent(int participatedStudent) {
		this.participatedStudent = participatedStudent;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProgramActivity [studentActivityId=" + studentActivityId + ", instituteId=" + instituteId + ", yearId="
				+ yearId + ", activityName=" + activityName + ", otherCompitition=" + otherCompitition + ", venue="
				+ venue + ", date=" + date + ", year=" + year + ", branch=" + branch + ", participatedStudent="
				+ participatedStudent + ", level=" + level + ", isActive=" + isActive + ", delStatus=" + delStatus
				+ ", addDate=" + addDate + ", makerUserId=" + makerUserId + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", type=" + type + ", aadharNo=" + aadharNo
				+ ", rawActivityName=" + rawActivityName + ", getRawActivityName()=" + getRawActivityName()
				+ ", getAadharNo()=" + getAadharNo() + ", getStudentActivityId()=" + getStudentActivityId()
				+ ", getInstituteId()=" + getInstituteId() + ", getYearId()=" + getYearId() + ", getActivityName()="
				+ getActivityName() + ", getOtherCompitition()=" + getOtherCompitition() + ", getDate()=" + getDate()
				+ ", getYear()=" + getYear() + ", getBranch()=" + getBranch() + ", getVenue()=" + getVenue()
				+ ", getParticipatedStudent()=" + getParticipatedStudent() + ", getLevel()=" + getLevel()
				+ ", getIsActive()=" + getIsActive() + ", getDelStatus()=" + getDelStatus() + ", getAddDate()="
				+ getAddDate() + ", getMakerUserId()=" + getMakerUserId() + ", getExInt1()=" + getExInt1()
				+ ", getExInt2()=" + getExInt2() + ", getExVar1()=" + getExVar1() + ", getExVar2()=" + getExVar2()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
		
}
