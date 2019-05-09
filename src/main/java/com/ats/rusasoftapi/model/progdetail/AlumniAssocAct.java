package com.ats.rusasoftapi.model.progdetail;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="alumni_assoc_act")
public class AlumniAssocAct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int almAssocActId;
	private String alumniMeetngAgnda;
	private Date dateOfMeeting;
	private String nameAlumniAssoc;
	private int alumniRegNo;
	private Date dateAlumniReg;
	private int noAlumniReg;
	private int noMemberAttended;
	private int ttlNoAlumniEnrolled;
	private int instId;
	private int acYearId;
	private int delStatus;
	private int isActive;
	private int makerUserId;
	private String makerEnterDatetime;
	private int exInt1;
	private int exInt2;
	private String exVar1;
	private String exVar2;
	public int getAlmAssocActId() {
		return almAssocActId;
	}
	public void setAlmAssocActId(int almAssocActId) {
		this.almAssocActId = almAssocActId;
	}
	public String getAlumniMeetngAgnda() {
		return alumniMeetngAgnda;
	}
	public void setAlumniMeetngAgnda(String alumniMeetngAgnda) {
		this.alumniMeetngAgnda = alumniMeetngAgnda;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfMeeting() {
		return dateOfMeeting;
	}
	public void setDateOfMeeting(Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}
	public String getNameAlumniAssoc() {
		return nameAlumniAssoc;
	}
	public void setNameAlumniAssoc(String nameAlumniAssoc) {
		this.nameAlumniAssoc = nameAlumniAssoc;
	}
	public int getAlumniRegNo() {
		return alumniRegNo;
	}
	public void setAlumniRegNo(int alumniRegNo) {
		this.alumniRegNo = alumniRegNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateAlumniReg() {
		return dateAlumniReg;
	}
	public void setDateAlumniReg(Date dateAlumniReg) {
		this.dateAlumniReg = dateAlumniReg;
	}
	public int getNoAlumniReg() {
		return noAlumniReg;
	}
	public void setNoAlumniReg(int noAlumniReg) {
		this.noAlumniReg = noAlumniReg;
	}
	public int getNoMemberAttended() {
		return noMemberAttended;
	}
	public void setNoMemberAttended(int noMemberAttended) {
		this.noMemberAttended = noMemberAttended;
	}
	public int getTtlNoAlumniEnrolled() {
		return ttlNoAlumniEnrolled;
	}
	public void setTtlNoAlumniEnrolled(int ttlNoAlumniEnrolled) {
		this.ttlNoAlumniEnrolled = ttlNoAlumniEnrolled;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public int getAcYearId() {
		return acYearId;
	}
	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
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
	@Override
	public String toString() {
		return "AlumniAssocAct [almAssocActId=" + almAssocActId + ", alumniMeetngAgnda=" + alumniMeetngAgnda
				+ ", dateOfMeeting=" + dateOfMeeting + ", nameAlumniAssoc=" + nameAlumniAssoc + ", alumniRegNo="
				+ alumniRegNo + ", dateAlumniReg=" + dateAlumniReg + ", noAlumniReg=" + noAlumniReg
				+ ", noMemberAttended=" + noMemberAttended + ", ttlNoAlumniEnrolled=" + ttlNoAlumniEnrolled
				+ ", instId=" + instId + ", acYearId=" + acYearId + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", makerUserId=" + makerUserId + ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	
}
