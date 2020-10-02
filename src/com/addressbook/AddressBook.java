package com.addressbook;

import java.util.Map;

public class AddressBook {

	
	 Map<String,ContactDetails> contactRecord;

	public Map<String, ContactDetails> getContactRecord() {
		return contactRecord;
	}

	public void setContactRecord(Map<String, ContactDetails> contactRecord) {
		this.contactRecord = contactRecord;
	}
	
	
}
