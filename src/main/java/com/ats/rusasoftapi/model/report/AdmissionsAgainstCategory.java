package com.ats.rusasoftapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdmissionsAgainstCategory {

	@Id
	private String id;
	
	private int castId;

	private int studentCatId;

	private int catTotStudent;

	private int seatsAvaailable;
	
	private String castName;
	
	private String academicYear;
	
	private String instituteName;
	
	private int yearId;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public int getStudentCatId() {
		return studentCatId;
	}

	public void setStudentCatId(int studentCatId) {
		this.studentCatId = studentCatId;
	}

	public int getCatTotStudent() {
		return catTotStudent;
	}

	public void setCatTotStudent(int catTotStudent) {
		this.catTotStudent = catTotStudent;
	}

	public int getSeatsAvaailable() {
		return seatsAvaailable;
	}

	public void setSeatsAvaailable(int seatsAvaailable) {
		this.seatsAvaailable = seatsAvaailable;
	}

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	@Override
	public String toString() {
		return "AdmissionsAgainstCategory [id=" + id + ", castId=" + castId + ", studentCatId=" + studentCatId
				+ ", catTotStudent=" + catTotStudent + ", seatsAvaailable=" + seatsAvaailable + ", castName=" + castName
				+ ", academicYear=" + academicYear + ", instituteName=" + instituteName + ", yearId=" + yearId + "]";
	}

	
}
