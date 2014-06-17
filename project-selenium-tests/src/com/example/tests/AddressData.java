package com.example.tests;

public class AddressData implements Comparable<AddressData>{
	public String firstName;
	public String lastName;
	public String addressFirst;
	public String phoneHome;
	public String phoneMobile;
	public String phoneWork;
	public String email;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String newGroup;
	public String addressSecond;
	public String phoneHomeSecond;

	public AddressData(String firstName, String lastName, String addressFirst,
			String phoneHome, String phoneMobile, String phoneWork,
			String email, String birthDay, String birthMonth, String birthYear,
			String newGroup, String addressSecond, String phoneHomeSecond) {
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.addressFirst = addressFirst;
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneWork = phoneWork;
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
	public String toString() {
		return "AddressData [firstName=" + firstName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
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
	
}