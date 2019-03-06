package com.ats.rusasoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetUserDetail {
	
	@Id
	private int userDeatilId;
	
	private String userName1;
	
	private String userConNumber;
	
	private String userEmail;
	
	private int userDesnId;
	
	private int userQualId;

	

	public int getUserDeatilId() {
		return userDeatilId;
	}

	public void setUserDeatilId(int userDeatilId) {
		this.userDeatilId = userDeatilId;
	}

	
	public String getUserConNumber() {
		return userConNumber;
	}

	public void setUserConNumber(String userConNumber) {
		this.userConNumber = userConNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserDesnId() {
		return userDesnId;
	}

	public void setUserDesnId(int userDesnId) {
		this.userDesnId = userDesnId;
	}

	public int getUserQualId() {
		return userQualId;
	}

	public void setUserQualId(int userQualId) {
		this.userQualId = userQualId;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	@Override
	public String toString() {
		return "GetUserDetail [userDeatilId=" + userDeatilId + ", userName1=" + userName1 + ", userConNumber="
				+ userConNumber + ", userEmail=" + userEmail + ", userDesnId=" + userDesnId + ", userQualId="
				+ userQualId + "]";
	}

	

	
}
