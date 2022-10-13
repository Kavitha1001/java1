package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyLeadPage extends ProjectSpecificMethods {

	public CreateLeadPage clickCreateLeads() {
		getDriver().findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}

}
