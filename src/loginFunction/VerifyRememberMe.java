package loginFunction;

import org.testng.annotations.Test;

import baseClass.CommonMethods;

public class VerifyRememberMe extends CommonMethods
{
	
	/*
	 * 
	 * This test is to login with remember me option and check given login details displayed correctcly after logout the application.
	 * 
	 */
	

	@Test(priority=0)
	private void validRememberMe() throws Exception
	{
	 
		
		login();
		clickRemember();
		clickSubmit();
		logOut();
		checkLoginTextBox();
	    
	}
	
	@Test(priority=1)
	private void refreshPageCheck()
	{
		
		refreshPage();
		checkLoginTextBox();
	}
}
