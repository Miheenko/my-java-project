package com.example.tests;

public class AddressData implements Comparable<AddressData> {
	private String firstName;
	private String lastName;
	private String addressFirst;
	private String phoneHome;
	private String phoneMobile;
	private String phoneWork;
	private String email;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String newGroup;
	private String addressSecond;
	private String phoneHomeSecond;
	

	public AddressData(String firstName, String lastName, String addressFirst,
			String phoneHome, String phoneMobile, String phoneWork,
			String email, String birthDay, String birthMonth, String birthYear,
			String newGroup, String addressSecond, String phoneHomeSecond) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressFirst = addressFirst;
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneWork = phoneWork;
		this.email = email;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.newGroup = newGroup;
		this.addressSecond = addressSecond;
		this.phoneHomeSecond = phoneHomeSecond;
	}
	
	public AddressData() {
		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AddressData [firstName=" + firstName + ", lastName=" + lastName
				+ ", addressFirst=" + addressFirst + ", phoneHome=" + phoneHome
				+ ", phoneMobile=" + phoneMobile + ", phoneWork=" + phoneWork
				+ ", email=" + email + ", birthDay=" + birthDay
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear
				+ ", newGroup=" + newGroup + ", addressSecond=" + addressSecond
				+ ", phoneHomeSecond=" + phoneHomeSecond + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressData other = (AddressData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}

	@Override
	public int compareTo(AddressData other) {
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}

	public AddressData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public AddressData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public AddressData withAddressFirst(String addressFirst) {
		this.addressFirst = addressFirst;
		return this;
	}

	public AddressData withPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
		return this;
	}

	public AddressData withPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
		return this;
	}

	public AddressData withPhoneWork(String phoneWork) {
		
		this.phoneWork = phoneWork;
		return this;
	}

	public AddressData withEmail(String email) {
		
		this.email = email;
		return this;
	}

	public AddressData withBirthDay(String birthDay) {
	
		this.birthDay = birthDay;
		return this;
	}

	public AddressData withBirthMonth(String birthMonth) {
		
		this.birthMonth = birthMonth;
		return this;
	}

	public AddressData withBirthYear(String birthYear) {
		
		this.birthYear = birthYear;
		return this;
	}

	public AddressData withNewGroup(String newGroup) {
		
		this.newGroup = newGroup;
		return this;
	}

	public AddressData withAddressSecond(String addressSecond) {
		
		this.addressSecond = addressSecond;
		return this;
	}

	public AddressData withPhoneHomeSecond(String phoneHomeSecond) {
		
		this.phoneHomeSecond = phoneHomeSecond;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddressFirst() {
		return addressFirst;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getNewGroup() {
		return newGroup;
	}

	public String getAddressSecond() {
		return addressSecond;
	}

	public String getPhoneHomeSecond() {
		return phoneHomeSecond;
	}

}