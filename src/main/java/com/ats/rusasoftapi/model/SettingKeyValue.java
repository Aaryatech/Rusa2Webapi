package com.ats.rusasoftapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_setting_key_value")
public class SettingKeyValue {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int settingId;
	
	private String settingKey ;
	
	private int intValue;
	
	private String stringValue ;
	
	private int delStatus;

	public int getSettingId() {
		return settingId;
	}

	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "SettingKeyValue [settingId=" + settingId + ", settingKey=" + settingKey + ", intValue=" + intValue
				+ ", stringValue=" + stringValue + ", delStatus=" + delStatus + ", getSettingId()=" + getSettingId()
				+ ", getSettingKey()=" + getSettingKey() + ", getIntValue()=" + getIntValue() + ", getStringValue()="
				+ getStringValue() + ", getDelStatus()=" + getDelStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
