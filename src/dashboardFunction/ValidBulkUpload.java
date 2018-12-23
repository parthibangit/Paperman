package dashboardFunction;

import org.testng.annotations.Test;

import baseClass.CommonMethods;

public class ValidBulkUpload extends CommonMethods

{
	
	/*
	 * 
	 * <------Test script is under construction------>
	 * 
	 */
	
	
    @Test(priority=0)
	public void bulkExcelUpload() throws Exception
	{
		
    	test=extent.createTest("ValidBulkUpload");
    	childTest=test.createNode("bulkExcelUpload");
		login();
		clickSubmit();
		openBulkLoad();
		fileUpload();	
	}

    @Test(priority=1)
	public void mapDetails() throws Exception
	{
		
    	childTest=test.createNode("mapDetails");
    	//materialList();
    	//unitList();
    	mapMaterialAndUnits();
    	
		
	}

    
    
}
