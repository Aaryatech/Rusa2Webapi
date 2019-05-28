package com.ats.rusasoftapi.model.report;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IntrnetConnInfo {
	@Id
	private String instituteName;
	private String libBandwidth;
	private String leaseLineBandwidth;
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getLibBandwidth() {
		return libBandwidth;
	}
	public void setLibBandwidth(String libBandwidth) {
		this.libBandwidth = libBandwidth;
	}
	public String getLeaseLineBandwidth() {
		return leaseLineBandwidth;
	}
	public void setLeaseLineBandwidth(String leaseLineBandwidth) {
		this.leaseLineBandwidth = leaseLineBandwidth;
	}
	@Override
	public String toString() {
		return "IntrnetConnInfo [instituteName=" + instituteName + ", libBandwidth=" + libBandwidth
				+ ", leaseLineBandwidth=" + leaseLineBandwidth + "]";
	}
	
	
}
