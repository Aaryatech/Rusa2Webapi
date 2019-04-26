package com.ats.rusasoftapi.model.infra;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="t_inst_it_infra_info")
public class ItInfrastructure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instItInfraInfoId;
	private int instId;
	private int noOfComputers;
	private Date purchaseDate;
	private int purchaseAmt;
	private int noOfStudUtilizing;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String makerDatetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	public int getInstItInfraInfoId() {
		return instItInfraInfoId;
	}
	public void setInstItInfraInfoId(int instItInfraInfoId) {
		this.instItInfraInfoId = instItInfraInfoId;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public int getNoOfComputers() {
		return noOfComputers;
	}
	public void setNoOfComputers(int noOfComputers) {
		this.noOfComputers = noOfComputers;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPurchaseAmt() {
		return purchaseAmt;
	}
	public void setPurchaseAmt(int purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}
	public int getNoOfStudUtilizing() {
		return noOfStudUtilizing;
	}
	public void setNoOfStudUtilizing(int noOfStudUtilizing) {
		this.noOfStudUtilizing = noOfStudUtilizing;
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
		return "ItInfrastructure [instItInfraInfoId=" + instItInfraInfoId + ", instId=" + instId + ", noOfComputers="
				+ noOfComputers + ", purchaseDate=" + purchaseDate + ", purchaseAmt=" + purchaseAmt
				+ ", noOfStudUtilizing=" + noOfStudUtilizing + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	

}
