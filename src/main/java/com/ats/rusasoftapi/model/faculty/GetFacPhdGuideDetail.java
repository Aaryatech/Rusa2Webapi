package com.ats.rusasoftapi.model.faculty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetFacPhdGuideDetail {
	
	@Id
	private int facultyId;
	
	private String facultyFirstName; 
	
	private Date phdRecognitionDt; //date
	private Date phdValidDt;//date
	
	private int noOfStud ;
	
	private int isIctUsed;

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
	public Date getPhdRecognitionDt() {
		return phdRecognitionDt;
	}

	public void setPhdRecognitionDt(Date phdRecognitionDt) {
		this.phdRecognitionDt = phdRecognitionDt;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPhdValidDt() {
		return phdValidDt;
	}

	public void setPhdValidDt(Date phdValidDt) {
		this.phdValidDt = phdValidDt;
	}

	public int getNoOfStud() {
		return noOfStud;
	}

	public void setNoOfStud(int noOfStud) {
		this.noOfStud = noOfStud;
	}

	public int getIsIctUsed() {
		return isIctUsed;
	}

	public void setIsIctUsed(int isIctUsed) {
		this.isIctUsed = isIctUsed;
	}

	@Override
	public String toString() {
		return "GetFacPhdGuideDetail [facultyId=" + facultyId + ", facultyFirstName=" + facultyFirstName
				+ ", phdRecognitionDt=" + phdRecognitionDt + ", phdValidDt=" + phdValidDt + ", noOfStud=" + noOfStud
				+ ", isIctUsed=" + isIctUsed + "]";
	} 
/*
 SELECT m_faculty.faculty_id,m_faculty.faculty_first_name,m_faculty.phd_recognition_dt,m_faculty.phd_stu_pg+m_faculty.phd_stu_mphill+m_faculty.phd_stu_phd as no_of_stud, m_faculty.phd_valid_dt, m_faculty.is_ict_used 
FROM m_faculty WHERE m_faculty.institute_id=2 AND m_faculty.del_status=1 AND m_faculty.is_active=1 AND m_faculty.is_phd_guide=1
 */
}
