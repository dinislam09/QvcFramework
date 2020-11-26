package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver dr=null;
	public static String browserPath=System.getProperty("user.dir");
	public static WebDriver openBrowser(String browser) {
		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			getBrowserForWindows(browser);
		}else{
			getBrowserForMac(browser);
		}
		return dr;
	}
	
	public static void getBrowserForWindows(String browser) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",browserPath+"src\\test\\resources\\Driver\\chromedriver.exe");
		 dr= new ChromeDriver();
		}else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",browserPath+"src\\test\\resources\\Driver\\geckodriver.exe");
			 dr= new FirefoxDriver();	
		}else {
			
		}
	}
	public static void getBrowserForMac(String browser) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",browserPath+"src\\test\\resources\\Driver\\chromedriver.exe");
		 dr= new ChromeDriver();
		}else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",browserPath+"src\\test\\resources\\Driver\\geckodriver.exe");
			 dr= new FirefoxDriver();	
		}else {
			
		}
	}
	
}
