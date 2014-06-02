package com.example.tests;

import org.testng.annotations.Test;

public class MyAddAddressTests extends TestBase {
  
  @Test
  public void testAddressCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewAddressCreation();
    AddressData address = new AddressData();
    address.firstName = "first_Name";
    address.lastName = "last_Name";
    address.addressFirst = "First_address";
    address.phoneHome = "2-26-33";
    address.phoneMobile = "+7 906 356 89 51";
    address.phoneWork = "8(8634)256-963";
    address.email = "test@mail.com";
    address.birthDay = "15";
    address.birthMonth = "March";
    address.birthYear = "2000";
    address.newGroup = "555";
    address.addressSecond = "Second_address";
    address.phoneHomeSecond = "";
	app.getContactHelper().fillAddressForm(address);
    app.getContactHelper().submitAddressCreation();
    app.getContactHelper().returnToHomePage();
  }
}
