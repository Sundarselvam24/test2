package com.mavenSelenium.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApPom {

	public static WebDriver driver;

	public ApPom(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}

	@FindBy(xpath = "//a[@class='login']")
	private WebElement loginButton;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "passwd")
	private WebElement password;

	@FindBy(name = "SubmitLogin")
	private WebElement Submit;

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement women;

	@FindBy(xpath = "(//a[@title='Blouses'])[1]")
	private WebElement blouse;

	@FindBy(xpath = "//img[@itemprop='image']")
	private WebElement productImage;

	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement AddToCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement processToCheckOut;

	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
	private WebElement summaryCheckOut;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement addressCheckOut;

	@FindBy(xpath = "//input[@type='checkbox']") 
	private WebElement checkBox;

	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement shippingCheckOut;

	@FindBy(xpath = "//a[@class='bankwire']")
	private WebElement payByBank;

	@FindBy(xpath = "//span[text()='I confirm my order']")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//i[@class='icon-home']")
	private WebElement home;
	
	

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getWomen() {
		return women;
	}

	public WebElement getBlouse() {
		return blouse;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getProcessToCheckOut() {
		return processToCheckOut;
	}

	public WebElement getSummaryCheckOut() {
		return summaryCheckOut;
	}

	public WebElement getAddressCheckOut() {
		return addressCheckOut;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getShippingCheckOut() {
		return shippingCheckOut;
	}

	public WebElement getPayByBank() {
		return payByBank;
	}

	public WebElement getConfirmOrder() {
		return confirmOrder;
	}

	public WebElement getHome() {
		return home;
	}

}
