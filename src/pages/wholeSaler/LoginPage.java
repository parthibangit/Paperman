package pages.wholeSaler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='email_id']")
	public WebElement email_locator;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement password_locator;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement submit_locator;
	
	@FindBy(how=How.XPATH, using="//div[@class='toast-message ng-star-inserted']")
	public WebElement successMessage_locator;
	
	@FindBy(how=How.XPATH, using="//input[@name='remember']")
	public WebElement rememberMe_locator;
	

	
	
	
}
