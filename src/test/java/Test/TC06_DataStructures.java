package Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestPackage.DataStrData;
import utils.ElementUtil;

@Test(groups = { "Get Started", "Sign in" })
public class TC06_DataStructures extends Hooks {

	@Test
	public void navigateToDataStructuresPage() {
		pom.getHomePage().clickGetStarted("Data Structures-Introduction");
		logger.debug("Current page title: {}", ElementUtil.getTitle());
		Assert.assertEquals(ElementUtil.getTitle(), "Data Structures-Introduction",
				"Failed to navigate to Data Structures page");

	}

	@Test(dataProvider = "StaticContent", dataProviderClass = DataStrData.class)
	public void verifyStaticContent(String expectedText) {
		List<String> headings = pom.getDataStructurePage().getheadingtext();
		System.out.println("Headings: " + headings);
		logger.info("Headings: {}", headings);
		boolean found = false;

		for (String heading : headings) {
			if (heading.equalsIgnoreCase(expectedText)) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found, "Expected text '" + expectedText + "' not found in the headings: " + headings);
	}
	
	@Test (dependsOnMethods = "verifyStaticContent")
	public void navigateToTimeComplexityPage() {
		pom.getDataStructurePage().clickTopicLink("Time Complexity");
		System.out.println("Current URL: " + ElementUtil.getURL());
		logger.debug("Current page title: {}", ElementUtil.getTitle());
		String pageurltext = "Data Structures Introduction"; 
			String expected = pageurltext.toLowerCase().replace(" ", "-");
			Assert.assertTrue(ElementUtil.getURL().contains(expected),
					"URL does not contain expected text: " + pageurltext);
			logger.info("User is on the expected page: " + pageurltext);
			
	}
	
	@Test (dependsOnMethods = "navigateToTimeComplexityPage")
	public void verifyTryHereButtonVisibility() {
		
		logger.info("Checking Try Here button visibility on Time Complexity page");
		boolean isDisplayed = pom.getDataStructurePage().checktryherebutton_displayed();
		if (!isDisplayed) {
			logger.error("Try Here button is not visible on Time Complexity page");
		}
		{
			Assert.assertTrue(isDisplayed, "Try Here button is not visible on Time Complexity page");
		logger.info("Verified Try Here button is visible on Time Complexity page");
		}
	}

	
}
