package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EditAddressTests extends TestBase {
	
	@Test
	public void editSomeAddress(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<AddressData> oldList = app.getContactHelper().getContacts();
		
		//actions
		app.getContactHelper().initRemoveEditContact(1);
		AddressData address = new AddressData();
		address.firstName = "777777";
		app.getContactHelper().fillAddressForm(address);
		app.getContactHelper().submitAddressModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
		  List<AddressData> newList = app.getContactHelper().getContacts();

		  
		  oldList.remove(0);
		  oldList.add(address);
		  Collections.sort(oldList);
		  Collections.sort(newList);
		  assertEquals(newList, oldList);
	  
	}

}
