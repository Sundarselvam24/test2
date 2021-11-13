package com.mavenSelenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static Actions action; // object for actions
	public static JavascriptExecutor js;  // object for javascript
 
	public static WebDriver driver; // driver installation

	public static WebDriver getDriver(String browser) {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else {

				System.out.println("Invalid browser");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return driver;
	}

	// ------------------------------------------------------ URL
	public static void url(String url) {

		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// ----------------------------------------------------- Click by Xpath
	public static void clkbyXpath(String element) {
		try {
			driver.findElement(By.xpath(element)).click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// ---------------------------------------- Click by Name

	public static void clkbyName(String element) {
		try {
			driver.findElement(By.name(element)).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// ------------------------------------ Send input by Xpath
	public static void sendbyXpath(String element, String input) {
		try {
			driver.findElement(By.xpath(element)).sendKeys(input);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// ------------------------------------- Send input by Name

	public static void sendbyName(String element, String input) {
		try {
			driver.findElement(By.name(element)).sendKeys(input);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// --------------------------------------- find element by Xpath

	public static WebElement findbyXpath(String element) {
		WebElement e = driver.findElement(By.xpath(element));
		return e;

	}

	// ------------------------------------------ find element by Name
	public static WebElement findbyName(String element) {
		WebElement e = driver.findElement(By.name(element));
		return e;
	}
	// -------------------------------------------- send keys by element(Locator)

	public static void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	// ----------------------------------------------//clk element by (Locator)

	public static void clkElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// ---------------------------------------------------- DropDown Select

	public static void dropDownSelect(WebElement element, String option, String value) {

		try {
			if (option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				Select s = new Select(element);
				s.selectByIndex(index);
			} else if (option.equalsIgnoreCase("ByValue")) {

				Select s = new Select(element);
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("byVisibleText")) {
				Select s = new Select(element);
				s.selectByVisibleText(value);
			} else {
				System.out.println("Invalid Option or format");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

	}

	// ----------------------------------------------------- drop Down deselect
	public static void dropDownDeselect(WebElement element, String option, String value) {

		try {
			if (option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				Select s = new Select(element);
				s.deselectByIndex(index);
			} else if (option.equalsIgnoreCase("ByValue")) {

				Select s = new Select(element);
				s.deselectByValue(value);
			} else if (option.equalsIgnoreCase("byVisibleText")) {
				Select s = new Select(element);
				s.deselectByVisibleText(value);

			} else {
				System.out.println("Invalid Option or format");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

	}

	// ------------------------------------------------------ Drop Down select All

	public static void dropDownSelectAl(WebElement element) {

		try {
			Select s = new Select(element);
			s.deselectAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	// --------------------------------------------------DropDown De select All

	public static void dropDownDeSelectAl(WebElement element) {

		try {
			Select s = new Select(element);
			s.deselectAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	// -------------------------------------------------------ScreenShot

	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(path);
		FileUtils.copyFile(src, desc);

	}
	// -------------------------------------------------Mouse Hover on element

	public static void mouseOnElement(WebElement element) {

		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	//-----------------------------------------jsClick
	
	public static void jsClick(WebElement element) {
		
	js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
	}
}
