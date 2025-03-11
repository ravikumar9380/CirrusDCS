package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class juspaypageobjects {
	
	private WebDriver driver;
	
	
	
	private	final By searchbutton= By.xpath("//input[@name='q']");
	public By getSearchbutton() {
		return searchbutton;
	}

	
	
	
	private	final By iphone = By.xpath("	//div[.='Apple iPhone 13 (Starlight, 128 GB)']");

	public By getIphone() {
		return iphone;
	}




	private	final By verifybutton = By.xpath("//button[.='Verify']");

	public By getVerifybutton() {
		return verifybutton;
	}


	private	final By  phonenumberField= By.xpath("//div[contains(@class,'I-qZ')]/input"); 
	public WebDriver getDriver() {
		return driver;
	}


	public By getPhonenumberField() {
		return phonenumberField;
	}


	public By getLoginbutton() {
		return loginbutton;
	}


	public By getRequestOtpButton() {
		return RequestOtpButton;
	}


	private	final By loginbutton = By.xpath("//span[.='Login']");
	private	final By RequestOtpButton = By.xpath("//button[.='Request OTP']");
	
	
	public juspaypageobjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	}

//button[.='Verify']
//button[.='Request OTP']