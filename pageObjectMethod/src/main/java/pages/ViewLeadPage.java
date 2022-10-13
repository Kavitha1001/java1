package pages;

import org.testng.Assert;

import base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

	public ViewLeadPage verifyfirstname() {
		String exptitle= "View Lead | opentaps CRM";
		String actualtitle=getDriver().getTitle();
		Assert.assertEquals(actualtitle,exptitle);
		return this;

	}

}
