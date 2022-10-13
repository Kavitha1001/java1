package pages;



import org.openqa.selenium.By;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods  {

	public HomePage verifyHomePage() {
		String exptitle= "Leaftaps - TestLeaf Automation Platform";
		String actualtitle=getDriver().getTitle();
		Assert.assertEquals(actualtitle,exptitle);
		return this;
		
	}
	public MyHomePage clickCRMSFALink()
	{
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}
	

}
