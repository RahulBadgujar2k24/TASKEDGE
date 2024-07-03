package com.Edge196.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class NeostoxUTILITYCLASS {
	static File myFile;
	static Sheet mysheet;
	// excel
	// screenshot
	// scrolling
	// wait

		
	public static String readDatafromExcel(int row, int cell) throws EncryptedDocumentException, IOException // 0,0
	{
		File myFile = new File("C:\\Users\\Renuka\\eclipse-workspace\\Edge196\\src\\test\\java\\DataFile\\dataFILE.XLS.xlsx");
		Sheet mysheet = WorkbookFactory.create(myFile).getSheet("Sheet2");
		String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	

	public static void screenShotMethod(WebDriver driver, String TCname) throws IOException // without main method we call
																							// generalization method

	{
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desti = new File("C:\\Users\\Desktop\\Desktop\\thh\\upstox"+TCname+".png");
		FileHandler.copy(source, desti);
		System.out.println("screenshot Done");

	}

	
}