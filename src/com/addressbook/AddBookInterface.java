package com.addressbook;

public interface AddBookInterface {

	public void createAddressBook(AddressBook addressBook);
	
	public void initializeAddressBook(AddressBook addressBook);

	public void addContacts(AddressBook addressBook, ContactDetails contact);

	public void editContacts(String serachString, AddressBook addressBook, ContactDetails contact);

	public void deleteContacts(String searchString, AddressBook addressBook);

	public void printAddressBook(AddressBook addressBook);
	public void addMultipleContacts(AddressBook addressBook,  int countContact);
	
}
