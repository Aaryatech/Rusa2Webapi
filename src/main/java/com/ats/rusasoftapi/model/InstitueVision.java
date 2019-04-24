package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_institute_vision")
public class InstitueVision {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_vision_id")
	private int instVisionId;
	
	@Column(name="institute_id")
	private int instituteId;
	 
	@Column(name="inst_vision_text")
	private String instVisionText;
	
	@Column(name="inst_vision_remark")
	private String instVisionRemark; 
	
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

	public int getInstVisionId() {
		return instVisionId;
	}

	public void setInstVisionId(int instVisionId) {
		this.instVisionId = instVisionId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstVisionText() {
		return instVisionText;
	}

	public void setInstVisionText(String instVisionText) {
		this.instVisionText = instVisionText;
	}

	public String getInstVisionRemark() {
		return instVisionRemark;
	}

	public void setInstVisionRemark(String instVisionRemark) {
		this.instVisionRemark = instVisionRemark;
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
		return "InstitueVision [instVisionId=" + instVisionId + ", instituteId=" + instituteId + ", instVisionText="
				+ instVisionText + ", instVisionRemark=" + instVisionRemark + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	

}
