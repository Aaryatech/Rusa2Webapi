package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TotSancIntakeProgwise {
	@Id 
	private int programId;
	
	private int totalAdmitted;
	
	private int sancIntake;
	
	private String programName;
	
	private String nameOfProgram;

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public int getTotalAdmitted() {
		return totalAdmitted;
	}

	public void setTotalAdmitted(int totalAdmitted) {
		this.totalAdmitted = totalAdmitted;
	}

	public int getSancIntake() {
		return sancIntake;
	}

	public void setSancIntake(int sancIntake) {
		this.sancIntake = sancIntake;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getNameOfProgram() {
		return nameOfProgram;
	}

	public void setNameOfProgram(String nameOfProgram) {
		this.nameOfProgram = nameOfProgram;
	}

	@Override
	public String toString() {
		return "TotSancIntakeProgwise [programId=" + programId + ", totalAdmitted=" + totalAdmitted + ", sancIntake="
				+ sancIntake + ", programName=" + programName + ", nameOfProgram=" + nameOfProgram + ", getProgramId()="
				+ getProgramId() + ", getTotalAdmitted()=" + getTotalAdmitted() + ", getSancIntake()=" + getSancIntake()
				+ ", getProgramName()=" + getProgramName() + ", getNameOfProgram()=" + getNameOfProgram()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
