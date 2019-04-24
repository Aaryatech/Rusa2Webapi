package com.ats.rusasoftapi.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class OrganizedList {
	@Id
	private int	activityId;
	private String typeName;
	//private String activityType;
	private String activityName;
	private String activityLevel;
	private Date activityDate;
	private String	activityParticipants;
	private String	activityFundedBy;
	private String	activityAmountSanctioned	;
	private String	activityAmountUtilised;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	/*
	 * public String getActivityType() { return activityType; } public void
	 * setActivityType(String activityType) { this.activityType = activityType; }
	 */
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityParticipants() {
		return activityParticipants;
	}
	public void setActivityParticipants(String activityParticipants) {
		this.activityParticipants = activityParticipants;
	}
	public String getActivityFundedBy() {
		return activityFundedBy;
	}
	public void setActivityFundedBy(String activityFundedBy) {
		this.activityFundedBy = activityFundedBy;
	}
	public String getActivityAmountSanctioned() {
		return activityAmountSanctioned;
	}
	public void setActivityAmountSanctioned(String activityAmountSanctioned) {
		this.activityAmountSanctioned = activityAmountSanctioned;
	}
	public String getActivityAmountUtilised() {
		return activityAmountUtilised;
	}
	public void setActivityAmountUtilised(String activityAmountUtilised) {
		this.activityAmountUtilised = activityAmountUtilised;
	}
	@Override
	public String toString() {
		return "OrganizedList [typeName=" + typeName + ", activityId=" + activityId + ", activityName=" + activityName + ", activityLevel=" + activityLevel + ", activityDate="
				+ activityDate + ", activityParticipants=" + activityParticipants + ", activityFundedBy="
				+ activityFundedBy + ", activityAmountSanctioned=" + activityAmountSanctioned
				+ ", activityAmountUtilised=" + activityAmountUtilised + "]";
	}
	
	

}
