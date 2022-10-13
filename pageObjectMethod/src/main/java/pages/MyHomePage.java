package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods  {

	
	public MyLeadPage clickLeads() {
		getDriver().findElement(By.linkText("Leads")).click();
		return new MyLeadPage();
	}
	
}
