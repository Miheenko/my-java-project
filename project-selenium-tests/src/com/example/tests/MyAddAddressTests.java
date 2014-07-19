package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

//import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

public class MyAddAddressTests extends TestBase {
	

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	


@Test(dataProvider = "contactsFromFile")
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
