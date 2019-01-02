package pages.wholeSaler;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashAddInventoryPage 
{
	
	public WebDriver driver;
	
	public DashAddInventoryPage(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	
	/*
	 * 
	 * These locators is used for inventory add
	 * 
	 */
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Add to Inventory')]")
	public WebElement addInventory_locator;
	
	@FindBy(how=How.XPATH, using="//button[@type='button']")
	public WebElement date_locator;
	
	@FindBy(how=How.XPATH, using="//div[@role='gridcell']")
	public List<WebElement> dateSelect_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper[1]//input[@type='checkbox']")
	public WebElement checkbox_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper//input[@type='checkbox']")
	public List<WebElement> checkboxCollections_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper[1]//datatable-body-cell[3]")
	public WebElement txtMaterialName_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper//datatable-body-cell[3]")
	public List<WebElement> txtMaterialNameCollections_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper[1]//datatable-body-cell[4]")
	public WebElement txtCurrentStock_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper//datatable-body-cell[4]")
	public List<WebElement> txtCurrentStockCollections_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper[1]//input[@type='number']")
	public WebElement inWeight_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper//input[@type='number']")
	public List<WebElement> inWeightCollections_locator;

	@FindBy(how=How.XPATH, using="//datatable-row-wrapper[1]//select[@class='custom-select selector_select']")
	public WebElement selectWeightType_locator;
	
	@FindBy(how=How.XPATH, using="//datatable-row-wrapper//select[@class='custom-select selector_select']")
	public List<WebElement> selectWeightTypeCollections_locator;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement btnSave_locator;
	
	@FindBy(how= How.XPATH,using = "//datatable-row-wrapper//datatable-body-cell[2]")
    public List<WebElement> txtmaterialName1_locator;
	
	@FindBy(how= How.XPATH,using = "//datatable-row-wrapper//datatable-body-cell[3]")
    public List<WebElement> txtWeightKgs_locator;
	
	@FindBy(how= How.XPATH,using = "//datatable-row-wrapper//datatable-body-cell[4]")
    public List<WebElement> txtWeightTons_locator;
	
}
