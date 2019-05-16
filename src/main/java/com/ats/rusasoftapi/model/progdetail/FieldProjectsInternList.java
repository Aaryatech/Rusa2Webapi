package com.ats.rusasoftapi.model.progdetail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FieldProjectsInternList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fieldProjectInternId;
	private String programName;
	private String programType;
	private String provisionForUndertaking;
	private int noOfStudUndertaking;
	private String document;
	public int getFieldProjectInternId() {
		return fieldProjectInternId;
	}
	public void setFieldProjectInternId(int fieldProjectInternId) {
		this.fieldProjectInternId = fieldProjectInternId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getProvisionForUndertaking() {
		return provisionForUndertaking;
	}
	public void setProvisionForUndertaking(String provisionForUndertaking) {
		this.provisionForUndertaking = provisionForUndertaking;
	}
	public int getNoOfStudUndertaking() {
		return noOfStudUndertaking;
	}
	public void setNoOfStudUndertaking(int noOfStudUndertaking) {
		this.noOfStudUndertaking = noOfStudUndertaking;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	@Override
	public String toString() {
		return "FieldProjectsInternList [fieldProjectInternId=" + fieldProjectInternId + ", programName=" + programName
				+ ", programType=" + programType + ", provisionForUndertaking=" + provisionForUndertaking
				+ ", noOfStudUndertaking=" + noOfStudUndertaking + ", document=" + document + "]";
	}
	
	
}
