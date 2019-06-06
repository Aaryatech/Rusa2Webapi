package com.ats.rusasoftapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AluminiAssoMeetReport {
	
	@Id
	private int almAssocActId;

	private Date dateOfMeeting;
	
	private String nameAlumniAssoc;

	private int acYearId;
	
	private String instituteName;
	
	private String academicYear;

	public int getAlmAssocActId() {
		return almAssocActId;
	}

	public void setAlmAssocActId(int almAssocActId) {
		this.almAssocActId = almAssocActId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getDateOfMeeting() {
		return dateOfMeeting;
	}

	public void setDateOfMeeting(Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}

	public String getNameAlumniAssoc() {
		return nameAlumniAssoc;
	}

	public void setNameAlumniAssoc(String nameAlumniAssoc) {
		this.nameAlumniAssoc = nameAlumniAssoc;
	}

	public int getAcYearId() {
		return acYearId;
	}

	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String toString() {
		return "AluminiAssoMeetReport [almAssocActId=" + almAssocActId + ", dateOfMeeting=" + dateOfMeeting
				+ ", nameAlumniAssoc=" + nameAlumniAssoc + ", acYearId=" + acYearId + ", instituteName=" + instituteName
				+ ", academicYear=" + academicYear + ", getAlmAssocActId()=" + getAlmAssocActId()
				+ ", getDateOfMeeting()=" + getDateOfMeeting() + ", getNameAlumniAssoc()=" + getNameAlumniAssoc()
				+ ", getAcYearId()=" + getAcYearId() + ", getInstituteName()=" + getInstituteName()
				+ ", getAcademicYear()=" + getAcademicYear() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	


}
