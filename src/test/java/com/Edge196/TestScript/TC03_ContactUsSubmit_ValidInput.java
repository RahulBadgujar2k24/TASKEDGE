package com.Edge196.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import com.Edge196.pom.B_02ContactUs;

public class TC03_ContactUsSubmit_ValidInput extends baseclassEdge196 {

	@Test
	public void submitFormwithvalidInput() throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		
		
		driver.manage().window().maximize();
		
		B_02ContactUs CU=new B_02ContactUs(driver);
		CU.navigateContact();
		logger.info("Naviage To Contact US Page of Edge196");
		
		CU.enterfirstname(readDatafromExcel(3, 1));
		logger.info("Enter the First name ");
		
		CU.enterlastname(readDatafromExcel(3, 2));
		logger.info("Enter the Last name ");
		
		CU.enteremail(readDatafromExcel(3, 3));
		logger.info("Enter the Email Address ");
		
		CU.enterContact(readDatafromExcel(3, 4));
		logger.info("Enter the Contact Number ");
		
		CU.selectCountry();
		logger.info("Select the Country ");
		
		CU.writecountry();
		logger.info("type name of  Country ");
		
		CU.DescribeyourRequest("hello sir");
		logger.info("Write a Message ");
		
		
	}
	
	
	
	
	
}
