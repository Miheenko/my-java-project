package com.example.tests;

import org.testng.annotations.Test;

public class EditAddressTests extends TestBase {
	
	@Test
	public void editSomeAddress(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initRemoveEditContact(1);
		AddressData address = new AddressData();
		address.email = "test@yandex.com";
		address.addressFirst = "first_edit_address";
		app.getContactHelper().fillAddressForm(address);
		app.getContactHelper().submitAddressModification();
		app.getContactHelper().returnToHomePage();
	  
	}

}
