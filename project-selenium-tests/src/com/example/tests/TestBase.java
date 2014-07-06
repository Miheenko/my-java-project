package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	private String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};

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
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 2; i++){
			GroupData group = new GroupData()
			.withGroupname(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			
			list.add(new Object[]{group});
		}
			return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomAddressGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 2; i++){
			AddressData address = new AddressData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddressFirst(generateRandomString())
			.withPhoneHome(generateRandomString())
			.withPhoneMobile(generateRandomString())
			.withPhoneWork(generateRandomString())
			.withEmail(generateRandomString())
			.withBirthDay(Integer.toString(generateRandomString(15, 7)))
			.withBirthMonth(month[generateRandomString(12,1)])
			.withBirthYear(Integer.toString(generateRandomString(100,80) + 1900))
			.withNewGroup("")
			.withAddressSecond(generateRandomString())
			.withPhoneHomeSecond(generateRandomString());
			System.out.println(address);
			
			list.add(new Object[]{address});
		}
			return list.iterator();
	}
	
	
	
	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	public int generateRandomString(int limit, int delta){
		Random rnd = new Random();
		int res = rnd.nextInt(limit);
		if (res == 0){
			res = delta;
		}
		return res;
	}
}