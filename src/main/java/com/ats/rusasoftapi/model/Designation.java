package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_designation")
public class Designation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int designationId;
	private String designationName;
	private int delStatus;
	private int isActive;
	private Date addDate;
	private int markerUserId;
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public int getMarkerUserId() {
		return markerUserId;
	}
	public void setMarkerUserId(int markerUserId) {
		this.markerUserId = markerUserId;
	}
	@Override
	public String toString() {
		return "Designation [designationId=" + designationId + ", designationName=" + designationName + ", delStatus="
				+ delStatus + ", isActive=" + isActive + ", addDate=" + addDate + ", markerUserId=" + markerUserId
				+ "]";
	}
	
	
	
}
