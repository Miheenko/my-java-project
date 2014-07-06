package com.example.tests;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class RemoveAddressTests extends TestBase {
	
	@Test
	public void deleteSomeAddress(){
		
		//save old state
		SortedListOf<AddressData> oldList = app.getContactHelper().getContacts();

		//actions
		app.getContactHelper().deleteContact(0);
		 

		//save new state
		SortedListOf<AddressData> newList = app.getContactHelper().getContacts();
		
		//compare states
		assertThat(newList, equalTo(oldList.without(0)));
		 
	}
}
