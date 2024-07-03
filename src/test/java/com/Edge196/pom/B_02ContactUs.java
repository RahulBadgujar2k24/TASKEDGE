package com.Edge196.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class B_02ContactUs {
	WebDriver localdriver;

	public B_02ContactUs(WebDriver rdriver) {
		// intialise webdriver
		localdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// navigate to Edge196 ContactUs
	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement Contactuspage;

	// identify Element
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement FN;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement LN;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='contact']")
	WebElement contact;

	@FindBy(css = "[class=' css-13cymwt-control']")//class=" css-13cymwt-control"// css-1xc3v61-indicatorContainer
	WebElement CountrySelect;

	@FindBy(css = "[class=' css-1jqq78o-placeholder'")
	List <WebElement>  selectCon;
	
	//

   
	//
	@FindBy(xpath = "//button[@class='btn btn-success btn-lg']")
	WebElement submit;

	@FindBy(xpath = "//textarea[@placeholder='Describe here']")
	WebElement Describe;

	public void navigateContact() {

		JavascriptExecutor js = (JavascriptExecutor) localdriver;
		js.executeScript("window.scrollBy(0,3000)", "");
		Contactuspage.click();
	}

	public void enterfirstname(String fn) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) localdriver;
		js.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(3000);
		FN.sendKeys(fn);

	}

	public void enterlastname(String ln) {
		LN.sendKeys(ln);
	}

	public void enteremail(String eml) {
		email.sendKeys(eml);
	}

	public void enterContact(String CoNo) {
		contact.sendKeys(CoNo);
	}

	public void selectCountry() throws InterruptedException {

		CountrySelect.click();

	Thread.sleep(6000);

	}

	public void writecountry() {
		
		CountrySelect.click();

        // Iterate through the options and select the matching one
        for (WebElement option : selectCon) {
        	if (option.getText().equals("India")) {
                option.click();
                break;
        	}}
	}

	public void DescribeyourRequest(String Message) {
		Describe.sendKeys(Message);

	}

	public void clickonSubmitbtn() {
		submit.click();
	}

}
