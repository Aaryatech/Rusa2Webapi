package com.ats.rusasoft.model;


public class LoginResponse {
	
	UserLogin user;
	
	ErrorMessage errorMessage;

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LoginResponse [user=" + user + ", errorMessage=" + errorMessage + ", getUser()=" + getUser()
				+ ", getErrorMessage()=" + getErrorMessage() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
