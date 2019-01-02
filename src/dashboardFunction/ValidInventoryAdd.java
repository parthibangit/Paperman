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
	
	public String materialName;
	public int currentWeight;
	
	@Test(priority=0)
	public void verifyAddInventory() throws Exception
	{
		
		test=extent.createTest("ValidInventoryAdd");
    	childTest=test.createNode("addInventory");
    	login();
    	clickSubmit();
		clickInventory();
		clickDatePicker();
		selectDate("21");
		Object indexValue=setWeightandWeightType("PS (Polystyrene)",Excel_config.getvalue("Weight", "4"), Excel_config.getvalue("Unit","tons"));
		currentWeight= (int) getCurrentWeight((int) indexValue);
		clickSaveButton();
		
	}
	
	@Test(priority=1)
	public void verifyAddedInventory() throws Exception
	{
		childTest=test.createNode("verifyAddedInventory");
		getMaterialNameandWeightKgs("PS (Polystyrene)",currentWeight,Excel_config.getvalue("Weight", "4"));
		
	}
}
