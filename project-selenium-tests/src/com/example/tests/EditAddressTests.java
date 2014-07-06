package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


import static com.example.fw.ContactHelper.MODIFICATION;

public class EditAddressTests extends TestBase {
	
	@Test(dataProvider = "randomAddressGenerator")
	public void editSomeAddress(AddressData address){
				
		//save old state
		SortedListOf<AddressData> oldList = app.getContactHelper().getContacts();
		
		 Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
		    app.getContactHelper().modifyContact(index, address);
		
		//save new state
		    SortedListOf<AddressData> newList = app.getContactHelper().getContacts();
		    
		//compare states
		    assertThat(newList, equalTo(oldList.without(index).withAdded(address)));  
	  
	}

}
