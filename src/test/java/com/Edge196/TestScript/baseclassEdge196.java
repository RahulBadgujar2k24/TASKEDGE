package com.Edge196.TestScript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import com.Edge196.utilities.Readconfig3;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclassEdge196 {
	Readconfig3 read=new Readconfig3();
	public String browser = read.getbrowser();
	public String url = read.getApplicationurl();

	// create webdriver setup
	public static WebDriver driver;
	public static Logger logger;

	// provide annotaion
	@BeforeClass
	public void setup() {
		// with the help of switch case switch the driver
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			ChromeDriver opt = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;

		}

		// for logging
		logger = LogManager.getLogger("Edge196");
		// implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		// open url
		driver.get(url);
		logger.info("url opened");
		
	}


public static String readDatafromExcel(int row, int cell) throws EncryptedDocumentException, IOException // 0,0
{
	File myFile = new File("C:\\Users\\Renuka\\OneDrive\\Desktop\\dataFILE.XLS.xlsx");
	Sheet mysheet = WorkbookFactory.create(myFile).getSheet("Sheet2");
	String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
	return value;
}

	@AfterMethod
	public void tearup() throws InterruptedException {
		//driver.close();
		
		driver.quit();
	}

	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}

}
