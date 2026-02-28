package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestPackage.LaunchData;
import utils.ElementUtil;

@Test(groups = { "Get Started", "Sign in" })
public class TC04_Home_withSignin extends Hooks {
	
	@Test(dataProvider = "HomeLinkText", dataProviderClass = LaunchData.class)
	public void verifyHomeLinkText(String Links) {
		Assert.assertEquals(pom.getHomePage().getRightCornerLink(Links), Links, "Link name mismatch");
		logger.info("Link name displayed: " + pom.getHomePage().getRightCornerLink(Links));
	
	}
	
	@Test(dataProvider = "HomeOptionsWithSignin", dataProviderClass = LaunchData.class)
	public void verifyPagedetails_OnClickingOptions(String OptionName, String PageHeading) {
		pom.getHomePage().selectOption(OptionName);
		Assert.assertEquals(pom.getHomePage().getPageHeading(OptionName), PageHeading, "Page heading mismatch");
		logger.info("Page heading displayed: " + pom.getHomePage().getPageHeading(OptionName));
		
	}	

	@Test(dataProvider = "TabNameWithSignin", dataProviderClass = LaunchData.class)
	public void verifyPagedetails_OnClickingTabs(String TabName, String PageHeading) {
		ElementUtil.navigatetoHomePage();
		pom.getHomePage().clickTitlePage(TabName);
		Assert.assertEquals(pom.getHomePage().getPageHeading(TabName), PageHeading, "Page heading mismatch");
		logger.info("Page heading displayed: " + pom.getHomePage().getPageHeading(TabName));
		ElementUtil.navigateBack();
	}	

}
