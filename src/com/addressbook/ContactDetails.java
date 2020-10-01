package com.addressbook;

import java.util.List;

public class ContactDetails {

	private String fName;
	private String lName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String mobNo;
	private String emailId;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return fName+" "+"ContactDetails [fName=" + fName + ", lName=" + lName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", mobNo=" + mobNo + ", emailId=" + emailId + "]";
	}
	
	
}
