package stepDefnition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.juspaypageobjects;



public class jusypay {
	
	WebDriver driver;
	
	juspaypageobjects jsp;
	
	Properties property;
	
	
	@Before()
	public void i_initialize_drivers_for_DCS_automation() throws Throwable {
		
		WebDriverManager.edgedriver().arch64().win().setup();
		 driver = new EdgeDriver();
		jsp=new juspaypageobjects(driver);
 
		property = new Properties();
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//java//utility//juspay.properties");
		property.load(fis1);
	}
	

	
	
	
	@Given("navigate to flipcart Login page")
	public void navigate_to_flipcart_Login_page() {
		
      driver.get("https://www.flipkart.com/");
    driver.findElement(jsp.getLoginbutton()).click();
   
		
	}

	@Then("enter mobile number")
	public void enter_mobile_number() {
	    
		driver.findElement(jsp.getPhonenumberField()).sendKeys(property.getProperty("phoneNumber"));	
		
	}

	@Then("and click on continue")
	public void and_click_on_continue() {
	    
		 driver.findElement(jsp.getRequestOtpButton()).click();
		
	}

	@Then("login to home page")
	public void login_to_home_page() throws InterruptedException {
	    
		Thread.sleep(5000);
		
		 driver.findElement(jsp.getVerifybutton()).click();
		 
		 Thread.sleep(2000);
		 
	//	 driver.findElement(jsp.getSearchbutton()).click();
		 
		 Thread.sleep(2000);
		 
		
		 
		 
		 
		 driver.findElement(jsp.getSearchbutton()).sendKeys("iphone");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(jsp.getIphone()).click();
		 Thread.sleep(2000);
		 
		 
	}



}
