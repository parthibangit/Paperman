package pages.wholeSaler;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage 
{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	
	/*
	 * 
	 * These locators is used for logout the application
	 * 
	 */
	
	@FindBy(how=How.XPATH, using="//a[@class='nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic color_white dropdown-toggle']//p")
	public WebElement logDrop_locator;
	
	@FindBy(how=How.XPATH, using="//a[@href='#/login']")
	public WebElement logOut_locator;
	
	
	
	
	/*
	 * 
	 * These locators is for "BULK UPLOAD"
	 * 
	 */
	
	
	@FindBy(how=How.XPATH, using="//a[@href='#/wholesaler/bulkupload']")
	public WebElement bulkUpload_locator;
	
	@FindBy(how=How.XPATH, using="//input[@class='custom-file-input']")
	public WebElement fileupload_locator;
	
	@FindBy(how=How.XPATH, using="//div[@class='datatable-body-cell-label']")
	public List<WebElement> uploadedDatas_locator;
	
	@FindBy(how=How.XPATH, using="//div[@class='datatable-body-cell-label']//span[@title='Click to edit']")
	public List<WebElement> mapmaterialAndUnit_locator;
	
	@FindBy(how=How.XPATH, using="//select[@class='form-control custom_bulk_option ng-tns-c4-11 ng-untouched ng-pristine ng-valid ng-star-inserted']")
	public WebElement selectMaterial_locator;
	
	@FindBy(how=How.XPATH, using="//input[@type='number']")
	public WebElement weight_locator;
	
	@FindBy(how=How.XPATH, using="//select[@class='form-control ng-tns-c4-11 ng-star-inserted']")
	public WebElement selectUnit_locator;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement nextButton_locator;
	
}
