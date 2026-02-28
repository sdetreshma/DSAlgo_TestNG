package Test;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestPackage.LaunchData;
import utils.ElementUtil;

@Test(groups = "Get Started")
public class TC02_Home extends Hooks {
	
	@Test
	public void verifyCompanyName() {
		logger.info("Verify company name : {}", pom.getHomePage().getCompanyName());
		Assert.assertEquals(pom.getHomePage().getCompanyName(), "NumpyNinja", "Company name mismatch");
	}
	
	@Test(dataProvider = "LinkName", dataProviderClass = LaunchData.class)
	public void verifyLinkNames(String linkName) {
		Assert.assertEquals(pom.getHomePage().getLinkName(linkName), linkName, "Link name mismatch");
		logger.info("Link name displayed: " + pom.getHomePage().getLinkName(linkName));
	}
	
	@Test(dataProvider = "OptionName", dataProviderClass = LaunchData.class)
	public void verifyDropdownOptions(List<String> expectedOptions) {
		pom.getHomePage().clickDataStructureDropdown();
		logger.info("Expected dropdown options: " + expectedOptions);

		List<String> actualOptions = pom.getHomePage().getDataStructureOptionsText();
		logger.info("Actual dropdown options: " + actualOptions);

		Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch");
	
	}
	
	@Test(dataProvider = "OptionsWithoutSignIn", dataProviderClass = LaunchData.class)
	public void verifyWarningMessageWithoutSignIn(String Option) {
		ElementUtil.refreshPage();
		pom.getHomePage().selectOption(Option);
		Assert.assertEquals(pom.getHomePage().getErrMsg(), "You are not logged in", "Warning message mismatch");
		logger.info("Warning message displayed: " + pom.getHomePage().getErrMsg());

	}
	
	@Test(dataProvider = "TabNameWithoutSignIn", dataProviderClass = LaunchData.class)
	public void verifyWarningMessageWithoutSignIn_Tabs(String TabName) {
		pom.getHomePage().clickTitlePage(TabName);
		Assert.assertEquals(pom.getHomePage().getErrMsg(), "You are not logged in", "Warning message mismatch");
		logger.info("Warning message displayed: " + pom.getHomePage().getErrMsg());
	}

}
