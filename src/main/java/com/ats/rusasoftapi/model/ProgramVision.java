package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program_vision")
public class ProgramVision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vision_id")
	private int visionId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="program_id")
	private int programId;
	
	@Column(name="vision_text")
	private String visionText;
	
	@Column(name="vision_remark")
	private String visionRemark; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;

	public int getVisionId() {
		return visionId;
	}

	public void setVisionId(int visionId) {
		this.visionId = visionId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getVisionText() {
		return visionText;
	}

	public void setVisionText(String visionText) {
		this.visionText = visionText;
	}

	public String getVisionRemark() {
		return visionRemark;
	}

	public void setVisionRemark(String visionRemark) {
		this.visionRemark = visionRemark;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getMakerdatetime() {
		return makerdatetime;
	}

	public void setMakerdatetime(String makerdatetime) {
		this.makerdatetime = makerdatetime;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	@Override
	public String toString() {
		return "ProgramVision [visionId=" + visionId + ", instituteId=" + instituteId + ", programId=" + programId
				+ ", visionText=" + visionText + ", visionRemark=" + visionRemark + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId
				+ "]";
	}
	
	

}
