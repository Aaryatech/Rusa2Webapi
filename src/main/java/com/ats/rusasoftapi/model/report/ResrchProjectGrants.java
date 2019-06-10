package com.ats.rusasoftapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class ResrchProjectGrants {
@Id
	private int projId;
	private String projName;
	private String projInvName;
	private String projInvDept;
	private String projGrant;
	private Date projFrdt;
	private Date projTodt;
	private String proj_sponsor;
	private String instituteName;
	public int getProjId() {
		return projId;
	}
	public String getProjName() {
		return projName;
	}
	public String getProjInvName() {
		return projInvName;
	}
	public String getProjInvDept() {
		return projInvDept;
	}
	public String getProjGrant() {
		return projGrant;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjFrdt() {
		return projFrdt;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProjTodt() {
		return projTodt;
	}
	public String getProj_sponsor() {
		return proj_sponsor;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public void setProjInvName(String projInvName) {
		this.projInvName = projInvName;
	}
	public void setProjInvDept(String projInvDept) {
		this.projInvDept = projInvDept;
	}
	public void setProjGrant(String projGrant) {
		this.projGrant = projGrant;
	}
	public void setProjFrdt(Date projFrdt) {
		this.projFrdt = projFrdt;
	}
	public void setProjTodt(Date projTodt) {
		this.projTodt = projTodt;
	}
	public void setProj_sponsor(String proj_sponsor) {
		this.proj_sponsor = proj_sponsor;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	@Override
	public String toString() {
		return "ResrchProjectGrants [projId=" + projId + ", projName=" + projName + ", projInvName=" + projInvName
				+ ", projInvDept=" + projInvDept + ", projGrant=" + projGrant + ", projFrdt=" + projFrdt + ", projTodt="
				+ projTodt + ", proj_sponsor=" + proj_sponsor + ", instituteName=" + instituteName + "]";
	}
	
}
