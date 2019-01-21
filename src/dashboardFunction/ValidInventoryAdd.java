package dashboardFunction;

import library.Excel_config;

import org.testng.annotations.Test;

import baseClass.CommonMethods;

public class ValidInventoryAdd extends CommonMethods
{

	/*
	 * 
	 * This test script is to verify the add inventory with weight of tons
	 * 
	 */
	
	
	@Test(priority=0, description="This test case is for add a material weight")
	private void verifyAddInventory() throws Exception
	{
		
		test=extent.createTest("ValidInventoryAdd");
    	childTest=test.createNode("addInventory");
    	login();
    	clickSubmit();
		clickInventory();
		clickDatePicker();
		selectDate("21");
		Object indexValue=setWeightandWeightType("PS (Polystyrene)",Excel_config.getvalue("Weight", "4"), Excel_config.getvalue("Unit","tons"));
	    getCurrentWeight((int) indexValue);
		clickSaveButton();
		
	}
	
	@Test(priority=1, description="This test case is for verify the added material weight into the inventory page")
	private void verifyAddedInventory() throws Exception
	{
		childTest=test.createNode("verifyAddedInventory");
		getMaterialNameandWeightKgs("PS (Polystyrene)",getcurrentStock(),Excel_config.getvalue("Weight", "4"));
		
	}
}
