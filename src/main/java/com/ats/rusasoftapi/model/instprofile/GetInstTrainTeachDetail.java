package com.ats.rusasoftapi.model.instprofile;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetInstTrainTeachDetail {

	@Id
	private int trainingId;

	private int yearId;

	private int trainingType;
	private String trainingTitle;

	private Date trainingFromdt;
	private Date trainingTodt;
	private String exVar1;
	private int trainingPcount;

	
	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(int trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingTitle() {
		return trainingTitle;
	}

	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}

	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTrainingFromdt() {
		return trainingFromdt;
	}

	public void setTrainingFromdt(Date trainingFromdt) {
		this.trainingFromdt = trainingFromdt;
	}

	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTrainingTodt() {
		return trainingTodt;
	}

	public void setTrainingTodt(Date trainingTodt) {
		this.trainingTodt = trainingTodt;
	}

	public int getTrainingPcount() {
		return trainingPcount;
	}

	public void setTrainingPcount(int trainingPcount) {
		this.trainingPcount = trainingPcount;
	}

	@Override
	public String toString() {
		return "GetInstTrainTeachDetail [trainingId=" + trainingId + ", yearId=" + yearId + ", trainingType="
				+ trainingType + ", trainingTitle=" + trainingTitle + ", trainingFromdt=" + trainingFromdt
				+ ", trainingTodt=" + trainingTodt + ", exVar1=" + exVar1 + ", trainingPcount=" + trainingPcount + "]";
	}

	
}
