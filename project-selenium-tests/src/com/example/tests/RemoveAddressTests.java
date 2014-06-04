package com.example.tests;

import org.testng.annotations.Test;

public class RemoveAddressTests extends TestBase {
	
	@Test
	public void deleteSomeAddress(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initRemoveEditContact(3);
		app.getContactHelper().removeContact();
		app.getContactHelper().returnToHomePage();
	  
	    
	}

}
