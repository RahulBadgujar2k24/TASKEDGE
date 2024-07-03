package com.Edge196.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Edge196.pom.A_01ValidandInvalidData;

public class TC02_EDGE_196_Invaliddata extends baseclassEdge196 {
	 @Test()
	    public void VerifywithInvalidData() throws InterruptedException, EncryptedDocumentException, IOException {
	       

	        

	        // Instantiate the ValidandInvalidData page object
	        A_01ValidandInvalidData VI = new A_01ValidandInvalidData(driver);
	 
	      
	        // Navigate to the InvestNow page
	        VI.navigateInvestNow();
	        logger.info("Navigate To InvestNow Page of -Edge196");

	        // Click on the login link
	        
	        VI.clickonlogin();
	        logger.info("Click on login link");

	        // Enter the invalid email address
	        VI.entertheEmailId(readDatafromExcel(7, 1));
	        logger.info("Enter the Invalid Email Address");

	        // Enter the invalid password
	        VI.enterthePassword(readDatafromExcel(7, 2));
	        logger.info("Enter the Invalid Password");

	        // Accept cookies
	        VI.Cookies();
	        logger.info("Accept Cookies Allow all");

	        // Click on the login button
	        VI.clickonsubmit();
	        logger.info("Click on LOGIN button");

	        // Validate the error message
	        String vl = VI.getinvalidMsg();
	        if (vl.equals("Wrong username or password")) {
	            logger.info("get error Msg verify login -passed");
	            Assert.assertTrue(true);
	        } else {
	            logger.info("verify login -failed");
	            Assert.assertTrue(false);
	        }
	    }
}
