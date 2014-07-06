package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

//import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;

public class MyAddAddressTests extends TestBase {
	

  @Test(dataProvider = "randomAddressGenerator")
  public void testAddressCreation(AddressData address) throws Exception {
	
	
	//save old state
	  SortedListOf<AddressData> oldList = app.getContactHelper().getContacts();
		
	//actions
	app.getContactHelper().createContact(address);	
    
    
    //save new state
	SortedListOf<AddressData> newList = app.getContactHelper().getContacts();
    
	
	//compare states
	  assertThat(newList, equalTo(oldList.withAdded(address)));
    
  }
}
