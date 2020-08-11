package org.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class CICDDemo {

	static WebDriver driver = null;
	static String url = "https://automationtalks.com";
	static Logger LOG = Logger.getLogger(CICDDemo.class);
	static String nodeURL = "http://192.168.42.16:4444/wd/hub";

	@BeforeTest
	public static void launchDriver() throws MalformedURLException {

		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);

		driver = new RemoteWebDriver(new URL(nodeURL), dc);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		PropertyConfigurator.configure("log4j.properties");
	}

	@Test
	public static void test1() {

		driver.get(url);

		LOG.info("Test 1 Title  is " + driver.getCurrentUrl());

	}

	@Test
	public static void test2() {

		driver.navigate().to(url);

		LOG.info("Test 2 Title  is " + driver.getCurrentUrl());

	}

	@Test
	public static void test3() {

		driver.navigate().to(url);

		LOG.info("Test 3 Title  is " + driver.getCurrentUrl());
	}

	@AfterTest
	public static void test4() {
		driver.quit();

	}

}
