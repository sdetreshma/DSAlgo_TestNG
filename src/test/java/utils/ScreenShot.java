package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

    // Capture screenshot as byte[] for attaching directly to Cucumber reports
   /* public static byte[] takeScreenshotAsBytes(WebDriver driver, String scenarioName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        */
        public static String takeScreenshot(WebDriver driver, String testName) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            File dest = new File(destPath);

            try {
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return destPath;
        }
    }

