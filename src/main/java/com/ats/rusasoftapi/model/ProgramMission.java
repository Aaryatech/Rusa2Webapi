package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program_mission")
public class ProgramMission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mission_id")
	private int missionId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="program_id")
	private int programId;
	
	@Column(name="mission_text")
	private String missionText;
	
	@Column(name="mission_remark")
	private String missionRemark; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
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

	public String getMissionText() {
		return missionText;
	}

	public void setMissionText(String missionText) {
		this.missionText = missionText;
	}

	public String getMissionRemark() {
		return missionRemark;
	}

	public void setMissionRemark(String missionRemark) {
		this.missionRemark = missionRemark;
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
		return "ProgramMission [missionId=" + missionId + ", instituteId=" + instituteId + ", programId=" + programId
				+ ", missionText=" + missionText + ", missionRemark=" + missionRemark + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId
				+ "]";
	}
	
	

}
