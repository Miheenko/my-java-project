package com.example.tests;

public class AddressData {
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
}