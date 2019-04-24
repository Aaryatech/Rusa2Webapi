package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_faculty_subject_co")
public class SubjectCo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="co_id")
	private int coId;

	@Column(name="sub_id")
	private int subId;
	
	@Column(name="faculty_id")
	private int facultyId;
	
	@Column(name="co_name")
	private String coName;
	
	@Column(name="co_po_map")
	private String coPoMap;
	
	@Column(name="co_po_satisfying_value")
	private String coPoSatisfyingValue;
	
	@Column(name="co_pso_map")
	private String coPsoMap;
	
	@Column(name="co_pso_satisfying_value")
	private String coPsoSatisfyingValue;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="maker_enter_datetime")
	private String makerEnterDatetime;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;

	public int getCoId() {
		return coId;
	}

	public void setCoId(int coId) {
		this.coId = coId;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getCoPoMap() {
		return coPoMap;
	}

	public void setCoPoMap(String coPoMap) {
		this.coPoMap = coPoMap;
	}

	public String getCoPoSatisfyingValue() {
		return coPoSatisfyingValue;
	}

	public void setCoPoSatisfyingValue(String coPoSatisfyingValue) {
		this.coPoSatisfyingValue = coPoSatisfyingValue;
	}

	public String getCoPsoMap() {
		return coPsoMap;
	}

	public void setCoPsoMap(String coPsoMap) {
		this.coPsoMap = coPsoMap;
	}

	public String getCoPsoSatisfyingValue() {
		return coPsoSatisfyingValue;
	}

	public void setCoPsoSatisfyingValue(String coPsoSatisfyingValue) {
		this.coPsoSatisfyingValue = coPsoSatisfyingValue;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public String getMakerEnterDatetime() {
		return makerEnterDatetime;
	}

	public void setMakerEnterDatetime(String makerEnterDatetime) {
		this.makerEnterDatetime = makerEnterDatetime;
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

	@Override
	public String toString() {
		return "SubjectCo [coId=" + coId + ", subId=" + subId + ", facultyId=" + facultyId + ", coName=" + coName
				+ ", coPoMap=" + coPoMap + ", coPoSatisfyingValue=" + coPoSatisfyingValue + ", coPsoMap=" + coPsoMap
				+ ", coPsoSatisfyingValue=" + coPsoSatisfyingValue + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", makerUserId=" + makerUserId + ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	

}
