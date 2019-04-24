package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program_peo")
public class ProgramEducationObjective {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="peo_id")
	private int peoId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="program_id")
	private int programId;
	
	@Column(name="peo_text")
	private String peoText;
	
	@Column(name="peo_remark")
	private String peoRemark; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;

	public int getPeoId() {
		return peoId;
	}

	public void setPeoId(int peoId) {
		this.peoId = peoId;
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

	public String getPeoText() {
		return peoText;
	}

	public void setPeoText(String peoText) {
		this.peoText = peoText;
	}

	public String getPeoRemark() {
		return peoRemark;
	}

	public void setPeoRemark(String peoRemark) {
		this.peoRemark = peoRemark;
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
		return "ProgramEducationObjective [peoId=" + peoId + ", instituteId=" + instituteId + ", programId=" + programId
				+ ", peoText=" + peoText + ", peoRemark=" + peoRemark + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId + "]";
	}
	
	


}
