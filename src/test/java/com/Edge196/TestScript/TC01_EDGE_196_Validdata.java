package com.Edge196.TestScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Edge196.pom.A_01ValidandInvalidData;

public class TC01_EDGE_196_Validdata extends baseclassEdge196 {
	

    @Test()
    public void VerifyValidData() throws EncryptedDocumentException, IOException, InterruptedException {
        // Maximize the browser window
        driver.manage().window().maximize();

        // Instantiate the ValidandInvalidData page object
        A_01ValidandInvalidData VI = new A_01ValidandInvalidData(driver);

        // Navigate to the InvestNow page
        VI.navigateInvestNow();
        logger.info("Navigate To InvestNow Page of Edge196");

        // Click on the login link
        VI.clickonlogin();
        logger.info("Click on login link");

        // Enter the valid email address
        VI.entertheEmailId(readDatafromExcel(5, 1));
        logger.info("Enter the Valid Email Address");

        // Enter the valid password
        VI.enterthePassword(readDatafromExcel(5, 2));
        logger.info("Enter the Valid Password");

        // Accept cookies
        VI.Cookies();
        logger.info("Accept Cookies Allow all");

        // Click on the login button
        VI.clickonsubmit();
        logger.info("Click on LOGIN button");

        // Validate the login
        String vl = VI.getHomepage();
        if (vl.equals("Thank you for your interest")) {
            logger.info("verify login -passed");
            Assert.assertTrue(true);
        } else {
            logger.info("verify login -failed");
            captureScreenShot(driver, "verifyLogin");
            Assert.assertTrue(false);
        }
       
     
    }

   
}