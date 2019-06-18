package com.ats.rusasoftapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="m_library_info")
public class LibraryInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int libInfoId;
	private int instituteId;
	private int isLibAutomated;
	private String softName;
 	private String softVersion;
	private int usersOfLms;
	private Date dateOfPurchaseAutomation; //Date
	private int noCompLan;
	private String 	bandwidthForAccessingEresources;
	private int isEresourceRemotly;
	private float avgTeacher;
	private float avgStudent;
	private int addBy;
	private String addDatetime;  
	private int editBy;
	private String editDatetime;
	private int isPlanning;
	private Date dateOfPlanningEstablishment;  //Date
	private int isAdministration;
	private Date dateOfAdministrationEstablishment;  //Date 
	private int isFinanceAcc;
	private Date dateOfFinanceEstablishment;  //Date;
	private int isStudentAdmition;
	private Date dateOfStudentEstablishment;  //Date
	private int isExamination;
	private Date dateOfExaminationEstablishment;  //Date
	private int delStatus;
	private int exInt1;
	private String exVar1;
	private int acYearId;
	public int getLibInfoId() {
		return libInfoId;
	}
	public void setLibInfoId(int libInfoId) {
		this.libInfoId = libInfoId;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public int getIsLibAutomated() {
		return isLibAutomated;
	}
	public void setIsLibAutomated(int isLibAutomated) {
		this.isLibAutomated = isLibAutomated;
	}
	public String getSoftName() {
		return softName;
	}
	public void setSoftName(String softName) {
		this.softName = softName;
	}
	public String getSoftVersion() {
		return softVersion;
	}
	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
	public int getUsersOfLms() {
		return usersOfLms;
	}
	public void setUsersOfLms(int usersOfLms) {
		this.usersOfLms = usersOfLms;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfPurchaseAutomation() {
		return dateOfPurchaseAutomation;
	}
	public void setDateOfPurchaseAutomation(Date dateOfPurchaseAutomation) {
		this.dateOfPurchaseAutomation = dateOfPurchaseAutomation;
	}
	public int getNoCompLan() {
		return noCompLan;
	}
	public void setNoCompLan(int noCompLan) {
		this.noCompLan = noCompLan;
	}
	public String getBandwidthForAccessingEresources() {
		return bandwidthForAccessingEresources;
	}
	public void setBandwidthForAccessingEresources(String bandwidthForAccessingEresources) {
		this.bandwidthForAccessingEresources = bandwidthForAccessingEresources;
	}
	public int getIsEresourceRemotly() {
		return isEresourceRemotly;
	}
	public void setIsEresourceRemotly(int isEresourceRemotly) {
		this.isEresourceRemotly = isEresourceRemotly;
	}
	public float getAvgTeacher() {
		return avgTeacher;
	}
	public void setAvgTeacher(float avgTeacher) {
		this.avgTeacher = avgTeacher;
	}
	public float getAvgStudent() {
		return avgStudent;
	}
	public void setAvgStudent(float avgStudent) {
		this.avgStudent = avgStudent;
	}
	public int getAddBy() {
		return addBy;
	}
	public void setAddBy(int addBy) {
		this.addBy = addBy;
	}
	public String getAddDatetime() {
		return addDatetime;
	}
	public void setAddDatetime(String addDatetime) {
		this.addDatetime = addDatetime;
	}
	public int getEditBy() {
		return editBy;
	}
	public void setEditBy(int editBy) {
		this.editBy = editBy;
	}
	public String getEditDatetime() {
		return editDatetime;
	}
	public void setEditDatetime(String editDatetime) {
		this.editDatetime = editDatetime;
	}
	public int getIsPlanning() {
		return isPlanning;
	}
	public void setIsPlanning(int isPlanning) {
		this.isPlanning = isPlanning;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfPlanningEstablishment() {
		return dateOfPlanningEstablishment;
	}
	public void setDateOfPlanningEstablishment(Date dateOfPlanningEstablishment) {
		this.dateOfPlanningEstablishment = dateOfPlanningEstablishment;
	}
	public int getIsAdministration() {
		return isAdministration;
	}
	public void setIsAdministration(int isAdministration) {
		this.isAdministration = isAdministration;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfAdministrationEstablishment() {
		return dateOfAdministrationEstablishment;
	}
	public void setDateOfAdministrationEstablishment(Date dateOfAdministrationEstablishment) {
		this.dateOfAdministrationEstablishment = dateOfAdministrationEstablishment;
	}
	public int getIsFinanceAcc() {
		return isFinanceAcc;
	}
	public void setIsFinanceAcc(int isFinanceAcc) {
		this.isFinanceAcc = isFinanceAcc;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfFinanceEstablishment() {
		return dateOfFinanceEstablishment;
	}
	public void setDateOfFinanceEstablishment(Date dateOfFinanceEstablishment) {
		this.dateOfFinanceEstablishment = dateOfFinanceEstablishment;
	}
	public int getIsStudentAdmition() {
		return isStudentAdmition;
	}
	public void setIsStudentAdmition(int isStudentAdmition) {
		this.isStudentAdmition = isStudentAdmition;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfStudentEstablishment() {
		return dateOfStudentEstablishment;
	}
	public void setDateOfStudentEstablishment(Date dateOfStudentEstablishment) {
		this.dateOfStudentEstablishment = dateOfStudentEstablishment;
	}
	public int getIsExamination() {
		return isExamination;
	}
	public void setIsExamination(int isExamination) {
		this.isExamination = isExamination;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDateOfExaminationEstablishment() {
		return dateOfExaminationEstablishment;
	}
	public void setDateOfExaminationEstablishment(Date dateOfExaminationEstablishment) {
		this.dateOfExaminationEstablishment = dateOfExaminationEstablishment;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getExInt1() {
		return exInt1;
	}
	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	
	public int getAcYearId() {
		return acYearId;
	}
	public void setAcYearId(int acYearId) {
		this.acYearId = acYearId;
	}
	@Override
	public String toString() {
		return "LibraryInfo [libInfoId=" + libInfoId + ", instituteId=" + instituteId + ", isLibAutomated="
				+ isLibAutomated + ", softName=" + softName + ", softVersion=" + softVersion + ", usersOfLms="
				+ usersOfLms + ", dateOfPurchaseAutomation=" + dateOfPurchaseAutomation + ", noCompLan=" + noCompLan
				+ ", bandwidthForAccessingEresources=" + bandwidthForAccessingEresources + ", isEresourceRemotly="
				+ isEresourceRemotly + ", avgTeacher=" + avgTeacher + ", avgStudent=" + avgStudent + ", addBy=" + addBy
				+ ", addDatetime=" + addDatetime + ", editBy=" + editBy + ", editDatetime=" + editDatetime
				+ ", isPlanning=" + isPlanning + ", dateOfPlanningEstablishment=" + dateOfPlanningEstablishment
				+ ", isAdministration=" + isAdministration + ", dateOfAdministrationEstablishment="
				+ dateOfAdministrationEstablishment + ", isFinanceAcc=" + isFinanceAcc + ", dateOfFinanceEstablishment="
				+ dateOfFinanceEstablishment + ", isStudentAdmition=" + isStudentAdmition
				+ ", dateOfStudentEstablishment=" + dateOfStudentEstablishment + ", isExamination=" + isExamination
				+ ", dateOfExaminationEstablishment=" + dateOfExaminationEstablishment + ", delStatus=" + delStatus
				+ ", exInt1=" + exInt1 + ", exVar1=" + exVar1 + "]";
	}
}
