package baseClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import library.ConfigExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


public class CommonMethods extends InitializePages
{
	
	/*
	 * 
	 *  
	 * These method is used for wholesaler login page
	 *  
	 */
	
	
	
	// This method is used to login the page
	public void login()
		{		
			login_locators.email_locator.sendKeys("parthiban@siamcomputing.com");
			login_locators.password_locator.sendKeys("password@123");
		}

	
	// This method is used to check login with bulk set of data 
	public void login(String email, String password) throws Exception
	{
		login_locators.email_locator.clear();
		login_locators.email_locator.sendKeys(email);
		login_locators.password_locator.clear();
		login_locators.password_locator.sendKeys(password);
		login_locators.submit_locator.click();
		getUrl();
		logOut();		
	}
	
	
	// This method is used to click the submit button
	public void clickSubmit()
	{
		
		login_locators.submit_locator.click();
	}
	
	
	// This method is used to logout the application	
	public void logOut() throws Exception
	{
		
		Thread.sleep(9000);
	    dashboard_locators.logDrop_locator.click();;
		dashboard_locators.logOut_locator.click();
        System.out.println("Able to logout the application");
	}
	
		
	// This method is used to wait until expected conditions matches
	public WebDriverWait explicitWait()
	{
		
		WebDriverWait wait=new WebDriverWait(browser_driver, 10);
		return wait;
			
	}
	

	// This method is used to get the dashboard page URL
	public void getUrl()
	{
		
	    String expected_url="http://papermanapp.underdev.in/#/wholesaler";
	    WebDriverWait wait= explicitWait();
	    Boolean url_result=wait.until(ExpectedConditions.urlMatches(expected_url));
	    if (url_result) 
	    {
	    	System.out.println("URL matched - Able to login with valid crdentials");	
		}
	    else
	    {	
	    	System.out.println("URL not matched - Not able to login with invalid crdentials");	    	
	    }
	  }
	
	
	// This method is used to test login page with bulk data
	@DataProvider(name="excel_data")
	public Object[][] multiLogin()
	{
		
		return new Object[][] 
		{
				{"parthiban@siamcomputing.com", "password@123"},
				{"parthiban@siamcomputing.in", "password@123"},
				{"parthiban@siamcomputing.com", "password"}
		};
		
	}
	
	
	// This method is used to click the remember me check box
	public void clickRemember()
	{
		
		boolean result_checkbox=login_locators.rememberMe_locator.isSelected();
		if(result_checkbox)
		{
			
			System.out.println("Remember me checkbox alread checked");
		}
		else
		{
			login_locators.rememberMe_locator.click();
		}
		
	}
	
	
	// This method is used to check the given login details presented in the respective input boxes.
	public void checkLoginTextBox()
	{
		
		String email_value=login_locators.email_locator.getAttribute("value");
		String password_value=login_locators.password_locator.getAttribute("value");
		boolean remember_value =login_locators.rememberMe_locator.isSelected();
		
		if(email_value != null && password_value!= null && remember_value==true)
		{
			
			System.out.println("Entered Email value is: " + email_value);
			System.out.println("Entered Password value is: " + password_value);
			System.out.println("Remember me check-box checked");
							
		}
		
		else
		{
			System.out.println("Email and password field not having an entered email and password");
		}
		
	}
	
	
	// This method is used to refresh the page
	public void refreshPage()
	{
		
		browser_driver.navigate().refresh();
		System.out.println("Page refreshed");
	}
	
	
	public void openBulkLoad()
	{
		
		WebDriverWait wait=explicitWait();
		wait.until(ExpectedConditions.visibilityOf(dashboard_locators.bulkUpload_locator)).click();
	}
	
	
	public ArrayList<String> fileUpload() throws Exception
	{
		
		
		Thread.sleep(3000);
		ArrayList<String> excelValue=excelData();
		dashboard_locators.fileupload_locator.click();
		Runtime.getRuntime().exec("E:\\Parthiban Sys\\selenium files\\AutoIT\\Test script drivers\\TestFileUpload.exe");
		Thread.sleep(6000);
		
		ArrayList<String> uploadDetails=new ArrayList<String>();		
		List<String> extractDetails= dashboard_locators.uploadedDatas_locator.stream().map(ele->ele.getText()).collect(Collectors.toList());
		uploadDetails.addAll(extractDetails);
		uploadDetails.remove(0);
		System.out.println(extractDetails);
		//Assert.assertEquals(excelValue, uploadDetails, "Value not matched - please rasie a bug");
		
		
		dashboard_locators.nextButton_locator.click();	
		return uploadDetails;
		
		
	}
	
	
	public ArrayList<String> excelData() throws Exception
	{
		
	   ConfigExcel excel_new=new ConfigExcel("C:\\Users\\user\\TestExcel.xlsx");
	   int rowTotal=excel_new.getRowCount("Test");	
	   System.out.println("Total row count is: " + rowTotal);
		   
	   int columnTotal=excel_new.getColumnCount("Test");
	   System.out.println("Total column count is: " + columnTotal);
		   
	   ArrayList<String> arrayExcel=new ArrayList<String>();
		  
		   for(int i=0; i<rowTotal; i++ )
		   {
			    
			  for(int j=0; j<columnTotal; j++)
			   {
				  
				 Cell cell_Value= excel_new.getData("Test", i, j);
				 
				 if(cell_Value.getCellType()==Cell.CELL_TYPE_NUMERIC)
				 {
					 
					cell_Value.setCellType(Cell.CELL_TYPE_STRING);
					
				 }
			 
			
		String excel_value=cell_Value.getStringCellValue();
		
		arrayExcel.add(excel_value);
			
	       }
		  		  
	   }

	    return arrayExcel;
		  		
	}
	
	
	public ArrayList<String> getUploadedExcelDetails()
	{
		
		ArrayList<String> uploadDetails=new ArrayList<String>();		
		List<String> extractDetails= dashboard_locators.uploadedDatas_locator.stream().map(ele->ele.getText()).collect(Collectors.toList());
		uploadDetails.addAll(extractDetails);
		uploadDetails.remove(0);
		return uploadDetails;
	}
	
	
	
	public void mapMaterialAndUnits() throws Exception
	{
		
		ArrayList<String>uploadDetails=getUploadedExcelDetails();
		
		String materialValue= uploadDetails.get(0);
		
		for(WebElement ele:dashboard_locators.mapmaterialAndUnit_locator)
		{
			
			String materialText=ele.getText();
			
			if(materialText.equalsIgnoreCase(materialValue))
			{
				
				ele.click();
				
			}	
		}
		
		
		
	
	    // This code is for choose the Material 
		ArrayList<String> materialvalues=new ArrayList<String>();
		
		Select select=new Select(dashboard_locators.selectMaterial_locator);
	
		WebDriverWait wait=explicitWait();
		
	    List<WebElement> listValues=wait.until(ExpectedConditions.visibilityOfAllElements(select.getOptions().stream().map(M->M).collect(Collectors.toList())));
	    
		String listString=listValues.toString();
		
		materialvalues.add(listString);//ArrayList<String> materialList=materialList();
		
		String materialName=materialvalues.get(0);
		
		Select select1=new Select(dashboard_locators.selectMaterial_locator);
		
	    select1.getOptions().stream().filter(M->M.equals(materialName)).forEach(M->M.click());
	    
		System.out.println(materialName);
	
		
		
		// This code is for choose the Unit
		ArrayList<String> unitList=unitList();
		
		String unitName=unitList.get(1);
		
		Select select2=new Select(dashboard_locators.selectUnit_locator);
		
	    select2.getOptions().stream().filter(U->U.equals(unitName)).forEach(U->U.click());
	    
		System.out.println(unitName);
		
	}
	
	
	public ArrayList<String> materialList()
	{
		
		ArrayList<String> materialvalues=new ArrayList<String>();
		
		//dashboard_locators.mapmaterialAndUnit_locator.
		Select select=new Select(dashboard_locators.selectMaterial_locator);
		WebDriverWait wait=explicitWait();
	    List<WebElement> listValues=wait.until(ExpectedConditions.visibilityOfAllElements(select.getOptions().stream().map(M->M).collect(Collectors.toList())));
		String listString=listValues.toString();
		materialvalues.add(listString);
		return materialvalues;
		
	}
	
	public ArrayList<String> unitList()
	{
		
        ArrayList<String> unitValues=new ArrayList<String>();
		
		Select select=new Select(dashboard_locators.selectUnit_locator);
		WebDriverWait wait=explicitWait();
	    List<WebElement> listValues=wait.until(ExpectedConditions.visibilityOfAllElements(select.getOptions().stream().map(M->M).collect(Collectors.toList())));
		String listString=listValues.toString();
		unitValues.add(listString);
		return unitValues;
		
	}
	
	
	@DataProvider(name="excelData")
	public Object[][] objExcel() throws Exception
	{
		ConfigExcel excel_new=new ConfigExcel("C:\\Users\\user\\TestExcel.xlsx");
		int rowTotal=excel_new.getRowCount("Test");	
		System.out.println("Total row count is: " + rowTotal);
		   
		int  columnTotal=excel_new.getColumnCount("Test");
		System.out.println("Total column count is: " + columnTotal);
		
		Object[][] dataObj=new Object[rowTotal][1];
		
		for(int i=0; i<rowTotal;i++)
		{
			
			Map<Object, Object> mapData=new HashMap<Object, Object>();
			
			for(int j=0; j<columnTotal;i++)
			{
			
				mapData.put(excel_new.getData("Test", i, j), excel_new.getData("Test", i+1, j));
				
				Cell cellValue=excel_new.getData("Test", i, j);
				
				if(cellValue.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					
					 cellValue.setCellType(Cell.CELL_TYPE_STRING);
					
				}
				
				dataObj[i][0]=mapData;
				
			}
					
		}
		
		return null;
			
	}

	
	public void clickInventory()
	{
		addInventory_loaders.addInventory_locator.click();	
	}
	
	public void clickDatePicker() throws InterruptedException 
	{
        Thread.sleep(3000);
        addInventory_loaders.date_locator.click();
    }
	
	public void selectDate(String userDate)
    {
		int dates=addInventory_loaders.dateSelect_locator.size();
        for (int i=0;i<dates;i++)
        {
            String dateValue=addInventory_loaders.dateSelect_locator.get(i).getText();
            if (dateValue.equalsIgnoreCase(userDate))
            {
            	addInventory_loaders.dateSelect_locator.get(i).click();
                break;
            }
        }
    }
	
	public void clickCheckBox()
	{
	     addInventory_loaders.checkbox_locator.click();
	        
	}
	
	public String getMaterialName()
	{
		 String materialName=addInventory_loaders.txtMaterialName_locator.getText();
		 System.out.println("Material Name is: "+materialName);
		 return materialName;
	}
	 
	public int getCurrentWeight()
	{
	     String currentWeight=addInventory_loaders.txtCurrentStock_locator.getText();
	     int intWeight=Integer.parseInt(currentWeight);
	     System.out.println("Current weight is: "+intWeight);
	     return intWeight;
	}
	
	public void setWeightandWeightType(String weight, String weightType)
	{
		 addInventory_loaders.inWeight_locator.sendKeys(weight);
		 System.out.println("Given weight is: "+weight);
		 Select dropWeight=new Select(addInventory_loaders.selectWeightType_locator);
		 dropWeight.selectByValue(weightType);
	}
	 
	public void clickSaveButton()
	{
		addInventory_loaders.btnSave_locator.click();
	}
	
	public void getMaterialNameandWeightKgs(String materialName, int currentWeight, String givenWeight) throws Exception
	{
		Thread.sleep(3000);
		int gWeight=Integer.parseInt(givenWeight);
		int totalWeight=gWeight+currentWeight;
		int kgs=1000;
		int convertKgs= kgs*totalWeight;
		System.out.println("Total value is: "+totalWeight);
		System.out.println("Converted value is: "+convertKgs);
		
		for (WebElement material: addInventory_loaders.txtmaterialName1_locator)
        {
            String materialText=material.getText();

            if (materialText.equalsIgnoreCase(materialName))
            {
                System.out.println("material name is: "+ materialText);

                for (WebElement weightKgs:addInventory_loaders.txtWeightKgs_locator)
                {
                    String kgsValue = weightKgs.getText();
                    int valueKgs = Integer.parseInt(kgsValue);
                    if (valueKgs == convertKgs)
                    {
                        System.out.println("Kga value matched - Test passed");
                    }

                }

            }
        }
		
	}
		
}
