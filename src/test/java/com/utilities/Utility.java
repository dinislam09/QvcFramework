package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	public static Logger getLog(Class clazz) {
		Logger log = Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/File/log4j.properties");
		return log;

	}

	public static Properties readPropFile() {
		Properties p = new Properties();
			try {
		FileInputStream f = new FileInputStream("src/test/resources/Driver/chromedriver.exe");
			p.load(f);
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		return p;
	}
	
	public static void verify(String expected,String actual) {
		if(expected.equals(actual)) {
			System.out.println("Pass");
		
		}else {
			System.out.println("Fail");
			System.out.println("The expected: "+expected);
			System.out.println("The actual: "+actual);
			Assert.assertEquals(expected, actual);
		}
	}
	
	public static WebElement getValue(WebDriver dr,String locatorType,String locatorValue ) {
		By by = null;
		if(locatorType.equals("xpath")) {
			by=By.xpath(locatorValue);
		}else if (locatorType.equals("id")) {
			by=By.id(locatorValue);
		}else if(locatorType.equals("name")) {
			by=By.name(locatorValue);
		}
			
		
		return dr.findElement(by);
	}
	
	
	
}
