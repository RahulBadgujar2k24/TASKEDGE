package com.Edge196.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class A_01ValidandInvalidData {

	WebDriver localdriver;

	public A_01ValidandInvalidData(WebDriver rdriver) {
		// Initialize webdriver
		localdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Navigate to Edge196 InvestNow
	@FindBy(xpath = "//a[text()='INVEST NOW']")
	WebElement Investnow;
	// click on login link
	@FindBy(xpath = "//a[@id='btn-log-in']")
	WebElement login;
	// Find the Email
	@FindBy(xpath = "//input[@id='login-email']")
	WebElement emailID;
	// Find the password
	@FindBy(xpath = "//input[@id='login-password']")
	WebElement PWD;
	
	//Accept Allow all
	@FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyButtonAccept']")
	WebElement acceptCookiesButton;
	
	// click on the submit
	@FindBy(xpath = "//span[text()='Log In']")
	WebElement submit;
    // validation of Home page
	
	@FindBy(xpath = "//h1[text()='Thank you for your interest']")
	WebElement getmsg;
	
	@FindBy(xpath="//div[@class='securitize-toast__body__content']")
	WebElement getmsg2;
	public void navigateInvestNow() {
		JavascriptExecutor js = (JavascriptExecutor) localdriver;
		js.executeScript("arguments[0].click();", Investnow);

		// Get all window handles
		Set<String> windowHandles = localdriver.getWindowHandles();

		// Convert the set to a list
		List<String> handlesList = new ArrayList<>(windowHandles);

		// Switch to the desired window
		if (handlesList.size() > 1) {
			localdriver.switchTo().window(handlesList.get(1));
		}
	}

	public void clickonlogin() {

		login.click();

	}

	public void entertheEmailId(String EID) {

		emailID.sendKeys(EID);
	}

	public void enterthePassword(String pass) {

		PWD.sendKeys(pass);
	}

	
	public void Cookies() {
		
		if (acceptCookiesButton.isDisplayed()) {
			acceptCookiesButton.click();
		}
	}
	
	public void clickonsubmit() {
		submit.click();

	}
	public String getHomepage()
 	{
 		String text = getmsg.getText();

 		return text;

}
	public void returntowelcomepage() {
		
		localdriver.switchTo().newWindow(WindowType.TAB);

	
		localdriver.manage().window().maximize();
		// Get all window handles
		Set<String> windowHandles = localdriver.getWindowHandles();

		// Convert the set to a list
		List<String> handlesList = new ArrayList<>(windowHandles);

		// Switch to the desired window
		if (handlesList.size() > 1) {
			localdriver.switchTo().window(handlesList.get(1));
		}
		
		}
	
	public String getinvalidMsg()
 	{
 		String text1 = getmsg2.getText();

 		return text1;

}

}
