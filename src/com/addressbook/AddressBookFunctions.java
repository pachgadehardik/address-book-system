package com.addressbook;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class AddressBookFunctions implements AddBookInterface {

	Scanner sc = new Scanner(System.in);
	private static final String DATA_FILE = "H:\\Capgemini\\Capg_Training\\address-book-system\\src\\Temp.csv";

	public ContactDetails getDetails(AddressBook addressBook) {
		Scanner sc = new Scanner(System.in);
		ContactDetails contact = new ContactDetails();

		// Take user-input
		System.out.println("Enter the firstName:");
		contact.setfName(sc.next());
		System.out.println("Enter the lastName:");
		contact.setlName(sc.next());
		System.out.println("Enter the Address:");
		contact.setAddress(sc.next());
		System.out.println("Enter the city:");
		contact.setCity(sc.next());
		System.out.println("Enter the state:");
		contact.setState(sc.next());
		System.out.println("Enter the zipcode:");
		contact.setZip(sc.next().trim());
		System.out.println("Phone Number");
		contact.setMobNo(sc.next());
		System.out.println("Enter EmailID: ");
		contact.setEmailId(sc.next());

//		contact.setId(contact_id++);
		// Add to addressBook

		return contact;
	}

	public void addContactsToAddressBook(AddressBook addressBook, ContactDetails contactDetails) {
		Map<String, ContactDetails> contactRecord = new HashMap<String, ContactDetails>();
		contactRecord = addressBook.getContactRecord();
		contactRecord.put(contactDetails.getfName(), contactDetails);
		try {
			writeToFile(contactRecord);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param contactRecord
	 * @throws IOException
	 * Writing Data in CSV FILE
	 */
	public void writeToFile(Map<String, ContactDetails> contactRecord) throws IOException {
		StringBuffer contactBuffer = new StringBuffer();
		for (Map.Entry<String, ContactDetails> entry : contactRecord.entrySet()) {
			String contactString = entry.getKey() + "," + entry.getValue().convertToCSV();
			contactBuffer.append(contactString);
		}
		try {
			Files.write(Paths.get("H:\\Capgemini\\Capg_Training\\address-book-system\\src\\Temp.csv"),
					contactBuffer.toString().getBytes());
		} catch (IOException x) {
			x.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws IOException
	 * Reading CSV File data using OpenCSV
	 */
	public Map<String, ContactDetails> readFile() throws IOException {
		Map<String, ContactDetails> contactRecordData = new HashMap<>();

		Reader reader = Files.newBufferedReader(Paths.get(DATA_FILE));
		CsvToBean<ContactDetails> csvToBean = new CsvToBeanBuilder<ContactDetails>(reader)
				.withType(ContactDetails.class).withIgnoreLeadingWhiteSpace(true).build();

		Iterator<ContactDetails> contactIterator = csvToBean.iterator();
		while (contactIterator.hasNext()) {
			ContactDetails contactDetails = contactIterator.next();
			contactRecordData.put(contactDetails.getfName(),
					new ContactDetails(contactDetails.getfName(), contactDetails.getlName(),
							contactDetails.getAddress(), contactDetails.getCity(), contactDetails.getState(),
							contactDetails.getZip(), contactDetails.getMobNo(), contactDetails.getEmailId()));
		}
		System.out.println(contactRecordData);
		return contactRecordData;
	}


	public String locateNameContactForEditing(AddressBook addressBook) {
		Map<String, ContactDetails> contact = addressBook.getContactRecord();
		System.out.println("Enter the first Name");
		String inputName = sc.nextLine().trim();

		if (contact.containsKey(inputName)) {
			System.out.println("Contact Exists");
			return inputName;
		}
		System.out.println("No such contact Exists");
		return null;
	}

	public void displayContact(AddressBook addressBook) {
		System.out.println(addressBook.getContactRecord().toString());
	}

	public void displayDictionary(Dictionary<String, AddressBook> dictionaryAddressBook) {

	}

	@Override
	public void editContacts(String searchString, AddressBook addressBook, ContactDetails contact) {

		Map<String, ContactDetails> contacts = addressBook.getContactRecord();

		String comparingString = contact.getfName();
		// check if the new data added matches with existing key if yes then edit the
		// value part else add the object and delete the previous key object

		if (searchString.equals(comparingString)) {
			contacts.put(comparingString, contact);
		} else {
			contacts.remove(searchString);
			contacts.put(comparingString, contact);
		}

		addressBook.setContactRecord(contacts);
		System.out.println(contacts);
	}

	public void printAddressBook(AddressBook addressBook) {
		System.out.println(addressBook.getContactRecord().toString());
	}

	public void initializeAddressBook(AddressBook addressBook) {
		addressBook.setContactRecord(new HashMap<>());
	}

	@Override
	public void addContacts(AddressBook addressBook, ContactDetails contact) {
//		 TODO Auto-generated method stub
		Map<String, ContactDetails> contactDetail = addressBook.getContactRecord();
		contactDetail.put(contact.getfName(), contact);
		addressBook.setContactRecord(contactDetail);

	}

	@Override
	public void deleteContacts(String inputName, AddressBook addressBook) {
		// TODO Auto-generated method stub
		Map<String, ContactDetails> contact = addressBook.getContactRecord();
		if (contact.containsKey(inputName)) {
			System.out.println("Contact Exists");
			printAddressBook(addressBook);
			contact.remove(inputName);
			printAddressBook(addressBook);
			System.out.println("deleted Successfully");
		} else
			System.out.println("Contact Does not Exist!!");

	}

	@Override
	public void addMultipleContacts(AddressBook addressBook, int countContact) {
		// TODO Auto-generated method stub
		if (countContact > 0) {
			for (int i = 1; i <= countContact; i++) {
				System.out.println("Enter for " + i + " person");
				ContactDetails contactDetails = getDetails(addressBook);
				addContactsToAddressBook(addressBook, contactDetails);
			}
			System.out.println("Successfully Added All " + countContact + " Contacts!");
		}
		displayContact(addressBook);

	}

	public void addMultipleAddressBooks(int countBooks, AddressBook addressBook,
			Map<String, AddressBook> mapAddressNameToBook) {

		mapAddressNameToBook.put("Hardik", addressBook);

		for (int i = 1; i <= countBooks; i++) {
			System.out.println("Enter name of the addressBook: ");
			String addBookName = sc.next();
			AddressBook newAddressBook = new AddressBook();
			newAddressBook.setContactRecord(new HashMap<String, ContactDetails>());
			mapAddressNameToBook.put(addBookName, newAddressBook);
//			initializeAddressBook(newAddressBook); 
			displayContact(newAddressBook);
		}

		System.out.println(mapAddressNameToBook.get("Hardik"));
		displayContact(addressBook);
		System.out.println("Added multiple addressBooks!!");

	}

	public boolean checkWhetherPersonExistsinAddressBook(ContactDetails contactRecord, AddressBook addressBook) {
		return addressBook.getContactRecord().keySet().stream().anyMatch(e -> e.equals(contactRecord.getfName()));

	}

	public void searchContactByCityOrState(String cityName, String stateName, AddressBook addressBook,
			Map<String, AddressBook> mapAddressNametoBook) {

		int city = 1;
		int state = 2;

		List<AddressBook> listAddressBooks = mapAddressNametoBook.values().stream().collect(Collectors.toList());

		for (AddressBook addBook : listAddressBooks) {
			System.out.println("City or State??");
			int option = sc.nextInt();
			switch (option) {
			// for city
			case 1:
				System.out.println(citySearch(cityName, addBook).toString());
				break;
			case 2:
				stateSearch(stateName, addBook);
				break;
			}

		}

	}

	public List<ContactDetails> citySearch(String cityName, AddressBook addressBook) {

		return addressBook.getContactRecord().values().stream().filter(e -> cityName.equals(e.getCity()))
				.collect(Collectors.toList());
	}

	public List<ContactDetails> stateSearch(String stateName, AddressBook addressBook) {

		return addressBook.getContactRecord().values().stream().filter(e -> stateName.equals(e.getState()))
				.collect(Collectors.toList());

	}

	public void searchContactByName_City_State(String personName, String city1, String state1, AddressBook addressBook,
			Map<String, AddressBook> mapAddressNametoBook) {

		List<AddressBook> listAddressBooks = mapAddressNametoBook.values().stream().collect(Collectors.toList());
		for (AddressBook addBook : listAddressBooks) {
			System.out.println(nameCityStateSearch(personName, city1, state1, addressBook));
		}

	}

	public List<ContactDetails> nameCityStateSearch(String personName, String city1, String state1,
			AddressBook addressBook) {

		return addressBook.getContactRecord().values().stream().filter(
				e -> personName.equals(e.getfName()) && city1.equals(e.getCity()) && state1.equals(e.getState()))
				.collect(Collectors.toList());

	}

	public void countContacts(String city2, String state2, AddressBook addressBook,
			Map<String, AddressBook> mapAddressNametoBook) {
		List<AddressBook> listAddressBooks = mapAddressNametoBook.values().stream().collect(Collectors.toList());
		for (AddressBook addBook : listAddressBooks) {
			System.out.println(addressBook.getContactRecord().values().stream()
					.filter(e -> city2.equals(e.getCity()) && state2.equals(e.getState())).count());
		}
	}

	// Sort the contact details in an AddressBook by person Name
	public void sortContact(AddressBook addressBook) {

		Map<Object, Object> result = addressBook.getContactRecord().entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println(result);
	}

	// Sort the Contact Details in an AddressBook by City, State, Zip
	public void sortContactByCityStateZip(AddressBook addressBook) {
//		addressBook.getContactRecord().values().stream().filter(e->e.getCity())
		List<Map.Entry<String, ContactDetails>> entryList = new ArrayList<Map.Entry<String, ContactDetails>>(
				addressBook.getContactRecord().entrySet());
		System.out.println("Search by what:\\n 1-City 2-State 3-Zip");
		String option;
		int opt = sc.nextInt();
		switch (opt) {
		case 1:
			Collections.sort(entryList, new Comparator<Map.Entry<String, ContactDetails>>() {
				@Override
				public int compare(Map.Entry<String, ContactDetails> contactEntry1,
						Map.Entry<String, ContactDetails> contactEntry2) {
					return contactEntry1.getValue().getCity().compareTo(contactEntry2.getValue().getCity());
				}
			});
			break;
		case 2:
			Collections.sort(entryList, new Comparator<Map.Entry<String, ContactDetails>>() {
				@Override
				public int compare(Map.Entry<String, ContactDetails> contactEntry1,
						Map.Entry<String, ContactDetails> contactEntry2) {
					return contactEntry1.getValue().getZip().compareTo(contactEntry2.getValue().getZip());
				}
			});
			break;
		case 3:
			Collections.sort(entryList, new Comparator<Map.Entry<String, ContactDetails>>() {
				@Override
				public int compare(Map.Entry<String, ContactDetails> contactEntry1,
						Map.Entry<String, ContactDetails> contactEntry2) {
					return contactEntry1.getValue().getState().compareTo(contactEntry2.getValue().getState());
				}
			});
			break;
		default:
			break;
		}
	}

}