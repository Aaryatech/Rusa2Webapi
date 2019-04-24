package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_program_po")
public class ProgramOutcome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="po_id")
	private int poId;
	
	@Column(name="institute_id")
	private int instituteId;
	
	@Column(name="program_id")
	private int programId;
	
	@Column(name="po_text")
	private String poText;
	
	@Column(name="po_remark")
	private String poRemark; 
	
	@Column(name="pso_map_id")
	private String psoMapId; 
	
	@Column(name="pso_map_satisfying_value")
	private String psoMapSatisfyingValue; 
	
	@Column(name="pso_mapping")
	private int psoMapping;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="maker_datetime")
	private String makerdatetime;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="map_datetime")
	private String mapDatetime;
	
	@Column(name="map_user_id")
	private int mapUserId;

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
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

	public String getPoText() {
		return poText;
	}

	public void setPoText(String poText) {
		this.poText = poText;
	}

	public String getPoRemark() {
		return poRemark;
	}

	public void setPoRemark(String poRemark) {
		this.poRemark = poRemark;
	}

	public String getPsoMapId() {
		return psoMapId;
	}

	public void setPsoMapId(String psoMapId) {
		this.psoMapId = psoMapId;
	}

	public String getPsoMapSatisfyingValue() {
		return psoMapSatisfyingValue;
	}

	public void setPsoMapSatisfyingValue(String psoMapSatisfyingValue) {
		this.psoMapSatisfyingValue = psoMapSatisfyingValue;
	}

	public int getPsoMapping() {
		return psoMapping;
	}

	public void setPsoMapping(int psoMapping) {
		this.psoMapping = psoMapping;
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

	public String getMapDatetime() {
		return mapDatetime;
	}

	public void setMapDatetime(String mapDatetime) {
		this.mapDatetime = mapDatetime;
	}

	public int getMapUserId() {
		return mapUserId;
	}

	public void setMapUserId(int mapUserId) {
		this.mapUserId = mapUserId;
	}

	@Override
	public String toString() {
		return "ProgramOutcome [poId=" + poId + ", instituteId=" + instituteId + ", programId=" + programId
				+ ", poText=" + poText + ", poRemark=" + poRemark + ", psoMapId=" + psoMapId
				+ ", psoMapSatisfyingValue=" + psoMapSatisfyingValue + ", psoMapping=" + psoMapping + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", makerdatetime=" + makerdatetime + ", makerUserId="
				+ makerUserId + ", mapDatetime=" + mapDatetime + ", mapUserId=" + mapUserId + "]";
	}
	
	

}
