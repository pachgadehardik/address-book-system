package com.addressbook;

import com.opencsv.bean.CsvBindByPosition;

public class ContactDetails {

	@CsvBindByPosition(position =1)
	private String fName;
	@CsvBindByPosition(position =2)
	private String lName;
	@CsvBindByPosition(position =3)
	private String address;
	@CsvBindByPosition(position =4)
	private String city;
	@CsvBindByPosition(position =5)
	private String state;
	@CsvBindByPosition(position =6)
	private String zip;
	@CsvBindByPosition(position =7)
	private String mobNo;
	@CsvBindByPosition(position =8)
	private String emailId;

	
	
	public ContactDetails() {
	}

	public ContactDetails(String fName, String lName, String address, String city, String state, String zip,
			String mobNo, String emailId) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.mobNo = mobNo;
		this.emailId = emailId;
	}

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
		return "fName= " + fName + ", lName= " + lName + ", address= " + address + ", city= " + city + ", state= "
				+ state + ", zip= " + zip + ", mobNo= " + mobNo + ", emailId= " + emailId;
	}

	public String convertToCSV() {
		return fName + "," + lName + "," + address + "," + city + "," + state + "," + zip + "," + mobNo + "," + emailId+'\n';
	}

}
