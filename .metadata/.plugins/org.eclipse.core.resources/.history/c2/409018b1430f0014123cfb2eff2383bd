
package com.example.tests;



import static com.example.tests.GroupDataGenerator.LoadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.LoadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class MyCreateGroupTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(LoadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
 

@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	
    
    //save old state
	  SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
   
    //actions
    app.getGroupHelper().createGroup(group);
   
    
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();  
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
   
  }
  
}