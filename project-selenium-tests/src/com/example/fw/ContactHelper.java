package com.example.fw;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import com.example.tests.AddressData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewAddressCreation() {
		click(By.linkText("add new"));
	}

	public void fillAddressForm(AddressData address) {
	    type(By.name("firstname"),address.firstName);
	    type(By.name("lastname"), address.lastName);
	    type(By.name("address"), address.addressFirst);
	    type(By.name("home"), address.phoneHome);
	    type(By.name("mobile"), address.phoneMobile);
	    type(By.name("work"), address.phoneWork);
	    type(By.name("email"), address.email);
	    selectByText(By.name("bday"), address.birthDay);
	    selectByText(By.name("bmonth"), address.birthMonth);
	    type(By.name("byear"), address.birthYear);
	   // selectByText(By.name("new_group"), address.newGroup);
	    type(By.name("address2"), address.addressSecond);
	    type(By.name("phone2"), address.phoneHomeSecond);
	}

	public void submitAddressCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//input[@name='selected[]'])[" + index +"]"));
	}

	public void initRemoveEditContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("(//a[contains(@href,'edit.php?id=')])[" + index + "]"));
	}

	public void removeContact() {
	   click(By.xpath("//input[@name='update' and @value='Delete']"));	
	}

	public void submitAddressModification() {
		click(By.xpath("//input[@name='update' and @value='Update']"));
	}
	
	public List<AddressData> getContacts() {
		List<AddressData> contacts = new ArrayList<AddressData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for ( WebElement checkbox : checkboxes) {
		AddressData contact = new AddressData();
		String title = checkbox.getAttribute("title");
		int len = "Select (".length();
		contact.firstName = title.substring(len, title.indexOf(" ", len));
		contacts.add(contact);
		}
		return contacts;
	}
}