package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateLead extends ProjectSpecificMethods{



	@BeforeTest
	public void setup() {
		excelFileName = "CreateLead";
		testName = "CreateLead";
		testDescription ="CreateLead";
		testCategory="functional";
		testAuthor="Divya";
	}

	@Test(dataProvider= "fetch")
	public void runLogin(String username,String password,String firstname,String lastname,String companyName)
	{
		LoginPage lp=new LoginPage();
		lp.enterusername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickLeads()
		.clickCreateLeads()
		.enterFirstName(firstname)
		.enterlastName(lastname)
		.enterCompanyName(companyName)
		.clickCreateLeadButton()
		.verifyfirstname();
	}
}
