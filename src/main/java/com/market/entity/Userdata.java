package com.market.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userdata {

	private String userName;
	@Id
	private String email;
	private long mobileNo;
	private String password;
	public Userdata(String userName, String email, long mobileNo, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	public Userdata() {
		super();
		
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", mobileNo=" + mobileNo + ", password=" + password
				+ "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
