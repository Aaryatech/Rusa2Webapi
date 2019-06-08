package com.ats.rusasoftapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhdGuideReport {
	
	@Id
	private int phdId;
	
	private String phdScholarName;
 	
	private String coGuideName;
	
 	private String regYear;
	
	private String guideName;
	
 	private String instituteName;
 	
	private String academicYear;
	
	private String university;
	
	private String awdYear;

	public int getPhdId() {
		return phdId;
	}

	public void setPhdId(int phdId) {
		this.phdId = phdId;
	}

	public String getPhdScholarName() {
		return phdScholarName;
	}

	public void setPhdScholarName(String phdScholarName) {
		this.phdScholarName = phdScholarName;
	}

	public String getCoGuideName() {
		return coGuideName;
	}

	public void setCoGuideName(String coGuideName) {
		this.coGuideName = coGuideName;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
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

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getAwdYear() {
		return awdYear;
	}

	public void setAwdYear(String awdYear) {
		this.awdYear = awdYear;
	}

	@Override
	public String toString() {
		return "PhdGuideReport [phdId=" + phdId + ", phdScholarName=" + phdScholarName + ", coGuideName=" + coGuideName
				+ ", regYear=" + regYear + ", guideName=" + guideName + ", instituteName=" + instituteName
				+ ", academicYear=" + academicYear + ", university=" + university + ", awdYear=" + awdYear + "]";
	}
	
	
	
	
	
	

}
