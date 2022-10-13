package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods  {

	public CreateLeadPage enterFirstName(String firstname) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		return this;

	}
	
	public CreateLeadPage enterlastName(String lastname) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		return this;

	}

	public CreateLeadPage enterCompanyName(String companyName) {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		return this;

	}
	
	public ViewLeadPage  clickCreateLeadButton() {
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage();

	}

}
