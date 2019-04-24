package com.ats.rusasoftapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "e_content_dev_facility")//t_inst_e_content_dev_facility
public class EContentDevFacility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_e_content_dev_facility_id")
	private int instEContentDevFacilityId;
	
	@Column(name="inst_id")
	private int instId;
	
	@Column(name="e_content_dev_facility")
	private String eContentDevFacility;
	
	@Column(name="name_econtent_dev_facility")
	private String nameEcontentDevFacility;
	
	@Column(name="video_link")
	private String videoLink;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@Column(name="maker_datetime")
	private String makerDatetime;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	
	public int getInstEContentDevFacilityId() {
		return instEContentDevFacilityId;
	}
	public void setInstEContentDevFacilityId(int instEContentDevFacilityId) {
		this.instEContentDevFacilityId = instEContentDevFacilityId;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	
	public String geteContentDevFacility() {
		return eContentDevFacility;
	}
	public void seteContentDevFacility(String eContentDevFacility) {
		this.eContentDevFacility = eContentDevFacility;
	}
	public String getNameEcontentDevFacility() {
		return nameEcontentDevFacility;
	}
	public void setNameEcontentDevFacility(String nameEcontentDevFacility) {
		this.nameEcontentDevFacility = nameEcontentDevFacility;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
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
		return "EContentDevFacility [instEContentDevFacilityId=" + instEContentDevFacilityId + ", instId=" + instId
				+ ", eContentDevFacility=" + eContentDevFacility + ", nameEcontentDevFacility="
				+ nameEcontentDevFacility + ", videoLink=" + videoLink + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
