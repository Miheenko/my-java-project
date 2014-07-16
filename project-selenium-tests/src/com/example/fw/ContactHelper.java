package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;

import org.openqa.selenium.By;

import java.util.List;
import org.openqa.selenium.WebElement;

import com.example.tests.AddressData;

import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
private SortedListOf<AddressData> cachedContacts;
	
	public SortedListOf<AddressData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<AddressData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver
				.findElements(By.xpath(".//tr[@name='entry']"));

		for (WebElement row : rows) {
			AddressData address = new AddressData()
			 .withFirstName(row.findElement(By.xpath(".//td[2]")).getText())
		     .withLastName(row.findElement(By.xpath(".//td[3]")).getText());
			cachedContacts.add(address);
		}
		
	}

	public ContactHelper createContact(AddressData address) {
		manager.navigateTo().mainPage();
		initNewAddressCreation();
		fillAddressForm(address, CREATION);
		submitAddressCreation();
		returnToHomePage();
		rebuildCache();
		return this;

	}
	
	public ContactHelper modifyContact(int index, AddressData address) {
		manager.navigateTo().mainPage();
		initRemoveEditContact(index);
		fillAddressForm(address, MODIFICATION);
		submitAddressModification();
		returnToHomePage();
		rebuildCache();
		return this;

	}
	
	public ContactHelper deleteContact(int i) {
		manager.navigateTo().mainPage();
		initRemoveEditContact(i);
	    removeContact();
		returnToHomePage(); 
		rebuildCache();
		return this;
	}
	
	//-----------------------------------------------------------------------

	public ContactHelper initNewAddressCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillAddressForm(AddressData address, boolean formType) {
		type(By.name("firstname"), address.getFirstName());
		type(By.name("lastname"), address.getLastName());
		type(By.name("address"), address.getAddressFirst());
		type(By.name("home"), address.getPhoneHome());
		type(By.name("mobile"), address.getPhoneMobile());
		type(By.name("work"), address.getPhoneWork());
		type(By.name("email"), address.getEmail());
		selectByText(By.name("bday"), address.getBirthDay());
		selectByText(By.name("bmonth"), address.getBirthMonth());
		type(By.name("byear"), address.getBirthYear());
		// selectByText(By.name("new_group"), address.getNewGroup());
		if (formType == CREATION) {

		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error(
						"Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), address.getAddressSecond());
		type(By.name("phone2"), address.getPhoneHomeSecond());
		return this;
	}

	public ContactHelper submitAddressCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//input[@name='selected[]'])[" + (index+1) + "]"));
	}

	public ContactHelper initRemoveEditContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("(//a[contains(@href,'edit.php?id=')])[" + (index+1) + "]"));

		return this;

	}

	public ContactHelper removeContact() {
		click(By.xpath("//input[@name='update' and @value='Delete']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitAddressModification() {
		click(By.xpath("//input[@name='update' and @value='Update']"));
		cachedContacts = null;
		return this;
	}

}