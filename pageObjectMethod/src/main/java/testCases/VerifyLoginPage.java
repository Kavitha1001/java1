package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VerifyLoginPage extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setup() {
		 excelFileName = "Login";
		 testName = "VerifyLogin";
		 testDescription ="Login test for leaftaps application";
		 testCategory="smoke";
		 testAuthor="Kavitha";
	}

	@Test(dataProvider= "fetch")
	public void runLogin(String username,String password) {
		
		
		LoginPage lp= new LoginPage();
		lp.enterusername(username)
		.enterPassword(password)
		.clickLoginButton()
		.verifyHomePage();
	}
}
