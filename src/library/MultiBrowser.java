package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class MultiBrowser 
{

	
    static WebDriver driver;
	
	@Parameters("browser")
	public static WebDriver browser_data(String browsername, String URL)
	{
		
		if(browsername.equalsIgnoreCase("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Parthiban Sys\\selenium files\\browser drivers\\Chrome New\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))	
		{	
			System.setProperty("webdriver.gecko.driver", "E:\\Parthiban Sys\\selenium files\\browser drivers\\firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		}	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;	
	}
}
