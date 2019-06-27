package com.ats.rusasoftapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stateId;
	private String stateName;
	private String region;
	private String exVar1;
	private int delStatus;
	
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getExVar1() {
		return exVar1;
	}
	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}
	
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", region=" + region + ", exVar1=" + exVar1
				+ ", delStatus=" + delStatus + "]";
	}
	
}
