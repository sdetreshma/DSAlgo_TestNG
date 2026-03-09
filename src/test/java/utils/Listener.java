package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import DriverManager.DriverFactory;
import pages.ArrayPage;


public class Listener implements ITestListener{
	
	private static final Logger logger = LogManager.getLogger(Listener.class);

	
	 @Override
	    public void onTestStart(ITestResult result) {
	        logger.info("TEST STARTED : '{}'",
	            result.getName());
	        
	    }
	 
	 @Override
	    public void onTestSuccess(ITestResult result) {
	        logger.info("TEST PASSED : '{}'",
	            result.getName());
	    }
	 
	 @Override
	    public void onTestFailure(ITestResult result) {
	        logger.error("TEST FAILED : '{}' | Reason: {}",
	            result.getName(),
	            result.getThrowable().getMessage());
	        logger.info("Failed: {} " , result.getName());
			String testName = result.getName();
		    WebDriver driver = DriverFactory.getDriver();

		    String screenshotPath = ScreenShot.takeScreenshot(driver, testName);
		    logger.info("Screenshot saved at: {}" , screenshotPath);
	    }
	 
	 @Override
	    public void onTestSkipped(ITestResult result) {
	        logger.warn("TEST SKIPPED : '{}'",
	            result.getName());
	    }

	 @Override
	    public void onStart(ITestContext context) {
	        logger.info("SUITE STARTED : '{}'",
	            context.getName());
	    }
	 
	 @Override
	    public void onFinish(ITestContext context) {
	        logger.info("SUITE FINISHED : '{}'",
	            context.getName());
	        logger.info("Passed  : {}",
	            context.getPassedTests().size());
	        logger.info("Failed  : {}",
	            context.getFailedTests().size());
	        logger.info("Skipped : {}",
	            context.getSkippedTests().size());
	    }
	

}
