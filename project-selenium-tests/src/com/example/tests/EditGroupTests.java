package com.example.tests;

import org.testng.annotations.Test;

public class EditGroupTests extends TestBase {
	
	@Test
	public void editSomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().initGroupModification(1);
	    GroupData group = new GroupData();
	    group.groupname = "new name";
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupsPage();
	}

}