package dashboardFunction;

import library.Excel_config;

import org.testng.annotations.Test;

import baseClass.CommonMethods;

public class ValidInventoryAdd extends CommonMethods
{
	
	
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
		clickCheckBox();
	    materialName=getMaterialName();
	    currentWeight= getCurrentWeight();
		setWeightandWeightType(Excel_config.getvalue("Weight"), Excel_config.getvalue("Unit"));
		clickSaveButton();
		
	}
	
	@Test(priority=1)
	public void verifyAddedInventory() throws Exception
	{
		childTest=test.createNode("verifyAddedInventory");
		getMaterialNameandWeightKgs(materialName,currentWeight,Excel_config.getvalue("Weight"));
		
	}
}
