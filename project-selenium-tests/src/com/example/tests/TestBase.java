package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;;

public class TestBase {
	
	protected static ApplicationManager app;
//	private String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	 
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(2)).iterator();
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups){
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomAddressGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(1)).iterator();
	}
	
	public static List<Object[]> wrapContactsForDataProvider(List<AddressData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (AddressData address : contacts){
			list.add(new Object[]{address});
		}
		return list;
	}
	
}