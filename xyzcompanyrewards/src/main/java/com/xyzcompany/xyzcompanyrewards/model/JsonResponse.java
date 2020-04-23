package com.xyzcompany.xyzcompanyrewards.model;

import java.io.Serializable;

public class JsonResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String errorCode;
	private String errorMessage;
	private boolean isAuthenticated;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	@Override
	public String toString() {
		return "JsonResponse [userName=" + userName + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", isAuthenticated=" + isAuthenticated + "]";
	}

}
