package com.mavenSelenium.automationPracice;

import org.openqa.selenium.WebDriver;

import com.mavenSelenium.BaseClass;
import com.mavenSelenium.automationPractice.ApPom;

public class AutomationPractice extends BaseClass {
	public static WebDriver driver = getDriver("chrome");
	static ApPom ap = new ApPom(driver);

	public static void main(String[] args) {
		login();
		purchaseBlouse();
	}
	public static void login() {

		url("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		clkElement(ap.getLoginButton());
		sendKeys(ap.getEmail(), "sundar@gmail.com");
		sendKeys(ap.getPassword(), "Sundar@123");
		clkElement(ap.getSubmit());
	}
	public static void purchaseBlouse() {

		mouseOnElement(ap.getWomen());
		clkElement(ap.getBlouse());
		mouseOnElement(ap.getProductImage());
		clkElement(ap.getAddToCart());
		clkElement(ap.getProcessToCheckOut());
		clkElement(ap.getSummaryCheckOut());
		clkElement(ap.getAddressCheckOut());
		clkElement(ap.getCheckBox());
		clkElement(ap.getShippingCheckOut());
		clkElement(ap.getPayByBank());
		clkElement(ap.getConfirmOrder());
		clkElement(ap.getHome());
	}
}
