package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class RemoveAddressTests extends TestBase {
	
	@Test
	public void deleteSomeAddress(){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<AddressData> oldList = app.getContactHelper().getContacts();
				
		//actions
		app.getContactHelper().initRemoveEditContact(3);
		app.getContactHelper().removeContact();
		app.getContactHelper().returnToHomePage(); 
		
		//save new state
		  List<AddressData> newList = app.getContactHelper().getContacts();

		  
		  oldList.remove(3);
		  Collections.sort(oldList);
		  assertEquals(newList, oldList);
	}
}
