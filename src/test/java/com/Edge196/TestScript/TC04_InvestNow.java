package com.Edge196.TestScript;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC04_InvestNow {public String baseUrl = "https://www.edge196.com/";
public EdgeDriver driver;

@BeforeTest
public void setup() {
	System.out.println("Before Test executed");
	// TODO Auto-generated method stub
	driver = new EdgeDriver();

	// Maximize windows
	driver.manage().window().maximize();

	// open curl
	driver.get(baseUrl);

	// timer i kept as 60 you can keep 40
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // 60 seconds
}

@Test(priority = 1, enabled = true)
public void doLoginWithInvalidCredential() throws InterruptedException {

	// navigate to EDGE-QInvest
	// Use JavaScript Executor to click the button
	WebElement InvestButton = driver.findElement(By.xpath("//a[text()='INVEST NOW']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", InvestButton);
	
	Set<String> windowHandles = driver.getWindowHandles();

	// Convert the set to a list
	//List<String> handlesList = new ArrayList<String>(windowHandles);

	// Switch to the desired window
//	driver.switchTo().window(handlesList.get(1));

	WebElement create_securitizeidbtn = driver.findElement(By.xpath("//span[text()='Create a Securitize ID']"));
	create_securitizeidbtn.click();
	// handle the cookies
	WebElement acceptCookiesButton = driver
			.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonAccept']"));
	if (acceptCookiesButton.isDisplayed()) {
		acceptCookiesButton.click();
	}

	// find First name Enter First name
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("RAHUL");

	// find Last name Enter Last name
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("BADGUJAR");

	// Next button click
	driver.findElement(By.xpath("//button[@id='registration-next']")).click();

	driver.findElement(By.xpath("//span[@class='Select-arrow']")).click();
	Thread.sleep(5000);
	// find the phone number
	driver.findElement(By.xpath("//input[@name='phone-number']")).sendKeys("07559127923");
	System.out.println("done");

	driver.findElement(By.xpath("//button[@id='registration-next']")).click();

}

}
