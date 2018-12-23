package loginFunction;

import org.testng.annotations.Test;

import baseClass.CommonMethods;

public class VerifyValidLogin extends CommonMethods
{
	
	/*
	 * 
	 * This is used to check login the application with valid credentials and check logout the application
	 * 
	 */
	
	@Test(priority=0)
	public void validLogin()
	{
	  	
	   login();
	   clickSubmit();
	   getUrl();
	   		
	}
	
	@Test(priority=1)
	public void validLogout() throws Exception
	{
		
		logOut();
		
	}
	
	
	
//    @Test(dataProvider="excel_data", dataProviderClass=CommonMethods.class)
//	private void validLogin(String email1, String password1) throws Exception
//	{

//	  login(email1, password1);
	
//	}
		
}
