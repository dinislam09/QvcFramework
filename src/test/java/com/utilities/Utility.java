package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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

	
}
