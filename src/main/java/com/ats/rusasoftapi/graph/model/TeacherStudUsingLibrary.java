package com.ats.rusasoftapi.graph.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeacherStudUsingLibrary {
	
	@Id
	private int acYearId;
	
	private int libInfoId;
	
	private int avgTeacher;
	
	private int avgStudent;

	public int getAcYearId() {
		return acYearId;
	}

	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
	}

	public int getLibInfoId() {
		return libInfoId;
	}

	public void setLibInfoId(int libInfoId) {
		this.libInfoId = libInfoId;
	}

	public int getAvgTeacher() {
		return avgTeacher;
	}

	public void setAvgTeacher(int avgTeacher) {
		this.avgTeacher = avgTeacher;
	}

	public int getAvgStudent() {
		return avgStudent;
	}

	public void setAvgStudent(int avgStudent) {
		this.avgStudent = avgStudent;
	}

	@Override
	public String toString() {
		return "TeacherStudUsingLibrary [acYearId=" + acYearId + ", libInfoId=" + libInfoId + ", avgTeacher="
				+ avgTeacher + ", avgStudent=" + avgStudent + ", getAcYearId()=" + getAcYearId() + ", getLibInfoId()="
				+ getLibInfoId() + ", getAvgTeacher()=" + getAvgTeacher() + ", getAvgStudent()=" + getAvgStudent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}
