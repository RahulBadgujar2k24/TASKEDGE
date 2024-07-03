package com.Edge196.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig3 {
	// create object of properties class
	Properties prot;
	// get the path of config file
	String path = "C:\\Users\\Renuka\\eclipse-workspace\\Edge196\\configuration\\config.properties";

	// create constructor of readconfig class
	public Readconfig3() {
		File src = new File(path);

		try {
			FileInputStream fis = new FileInputStream(src);
			prot = new Properties();
			prot.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("the given exception is " + e.getMessage());
		}

	}

	// get browser
	public String getbrowser() {
		String value1 = prot.getProperty("browser");
		if (value1 != null)
			return value1;
		else
			throw new RuntimeException("browser not specified in properties file");
	}

	// get url
	public String getApplicationurl() {
		String value2 = prot.getProperty("baseurl");
		if (value2 != null)
			return value2;
		else
			throw new RuntimeException("apllication url not specified in properties file");
	}

	// get chromepath
	public String getChromepath() {
		String chromepathdriver = prot.getProperty("chromepath");
		return chromepathdriver;

	}

	// get Firefoxpth
	public String getFirefoxpath() {
		String geckodriver = prot.getProperty("firefoxpath");
		return geckodriver;
	}

}
