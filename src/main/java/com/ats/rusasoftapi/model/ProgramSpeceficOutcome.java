package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program_pso")
public class ProgramSpeceficOutcome {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pso_id")
	private int psoId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="program_id")
	private int programId;
	
	@Column(name="pso_text")
	private String psoText;
	
	@Column(name="pso_remark")
	private String psoRemark; 
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;

	public int getPsoId() {
		return psoId;
	}

	public void setPsoId(int psoId) {
		this.psoId = psoId;
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

	public String getPsoText() {
		return psoText;
	}

	public void setPsoText(String psoText) {
		this.psoText = psoText;
	}

	public String getPsoRemark() {
		return psoRemark;
	}

	public void setPsoRemark(String psoRemark) {
		this.psoRemark = psoRemark;
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
		return "ProgramSpeceficOutcome [psoId=" + psoId + ", instituteId=" + instituteId + ", programId=" + programId
				+ ", psoText=" + psoText + ", psoRemark=" + psoRemark + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId=" + makerUserId + "]";
	}
	
	
	
}
