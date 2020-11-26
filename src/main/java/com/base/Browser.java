package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	static WebDriver dr=null;
	static String basePath=System.getProperty("user.dir");
	public static WebDriver openBrowser(String browser) {

		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			getBrowserForWindows(browser);
		}else{
			getBrowserForMac(browser);
		}
		return dr;
	}
	public static void getBrowserForWindows(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\geckodriver.exe");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
			 dr= new ChromeDriver();
		}else {
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
	}
	
	public static void getBrowserForMac(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\mac\\geckodriver");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\mac\\chromedriver");
			 dr= new ChromeDriver();
		}else {
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
	}
}