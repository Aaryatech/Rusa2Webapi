package com.ats.rusasoftapi.model.instprofile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "md_values_master")
public class ValuesMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int valMastId;

	private String valText;

	private int delStatus;
	private int isActive;

	private int makerUserId;
	private String makerDatetime;

	public int getValMastId() {
		return valMastId;
	}

	public void setValMastId(int valMastId) {
		this.valMastId = valMastId;
	}

	public String getValText() {
		return valText;
	}

	public void setValText(String valText) {
		this.valText = valText;
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

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public String getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
	}

	@Override
	public String toString() {
		return "ValuesMaster [valMastId=" + valMastId + ", valText=" + valText + ", delStatus=" + delStatus
				+ ", isActive=" + isActive + ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + "]";
	}

}
