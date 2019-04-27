package com.ats.rusasoftapi.model.infra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_infra_area_name")
public class InfraAreaName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int  infraAreaId;
	private int infraAreaTypeId;
	private String infraAreaName;
	
	private int  delStatus;
	private int isActive;
	
	public int getInfraAreaId() {
		return infraAreaId;
	}
	public void setInfraAreaId(int infraAreaId) {
		this.infraAreaId = infraAreaId;
	}
	public int getInfraAreaTypeId() {
		return infraAreaTypeId;
	}
	public void setInfraAreaTypeId(int infraAreaTypeId) {
		this.infraAreaTypeId = infraAreaTypeId;
	}
	public String getInfraAreaName() {
		return infraAreaName;
	}
	public void setInfraAreaName(String infraAreaName) {
		this.infraAreaName = infraAreaName;
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
		return "InfraAreaName [infraAreaId=" + infraAreaId + ", infraAreaTypeId=" + infraAreaTypeId + ", infraAreaName="
				+ infraAreaName + ", delStatus=" + delStatus + ", isActive=" + isActive + "]";
	}

}
