package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_institute_mission")
public class InstitueMission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_mission_id")
	private int instMissionId;
	
	@Column(name="institute_id")
	private int instituteId;
	 
	@Column(name="inst_mission_text")
	private String instMissionText;
	
	@Column(name="inst_mission_remark")
	private String instMissionRemark; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;

	public int getInstMissionId() {
		return instMissionId;
	}

	public void setInstMissionId(int instMissionId) {
		this.instMissionId = instMissionId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstMissionText() {
		return instMissionText;
	}

	public void setInstMissionText(String instMissionText) {
		this.instMissionText = instMissionText;
	}

	public String getInstMissionRemark() {
		return instMissionRemark;
	}

	public void setInstMissionRemark(String instMissionRemark) {
		this.instMissionRemark = instMissionRemark;
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

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "InstitueMission [instMissionId=" + instMissionId + ", instituteId=" + instituteId + ", instMissionText="
				+ instMissionText + ", instMissionRemark=" + instMissionRemark + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	

}
