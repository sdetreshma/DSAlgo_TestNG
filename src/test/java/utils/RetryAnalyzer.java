package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);

	
	int counter=0;
	int retrylimit =1;

    @Override
    public boolean retry(ITestResult result) {
        if(counter<retrylimit) {
            counter++;
            logger.info("Retrying test: '{}' | Attempt: {} of {}", result.getName(), counter, retrylimit);
            return true; 
        }
        return false;
    }
}


