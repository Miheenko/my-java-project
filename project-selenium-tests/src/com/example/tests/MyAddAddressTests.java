package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MyAddAddressTests extends TestBase {
	

  @Test(dataProvider = "randomAddressGenerator")
  public void testAddressCreation(AddressData address) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
		List<AddressData> oldList = app.getContactHelper().getContacts();
		
	//actions
    app.getContactHelper().initNewAddressCreation();
   	app.getContactHelper().fillAddressForm(address);
    app.getContactHelper().submitAddressCreation();
    app.getContactHelper().returnToHomePage();
    
    
    //save new state
    List<AddressData> newList = app.getContactHelper().getContacts();
       
    oldList.add(address);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
