package com.zkteco.cirrusdcs.Resources;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



@SuppressWarnings("ALL")
public class base
{

	public WebDriver driver;
	public static final String downloadPath = System.getProperty("user.dir") + "\\DownloadedFiles";

	public WebDriver initializeDriver(String browser, String processor, String oS)
	{

		switch (processor)
		{
		case "x32":
		case "X32":
			switch (oS.toLowerCase())
			{
			case "windows":

				switch (browser.toLowerCase())
				{

				case "chrome":
					WebDriverManager.chromedriver().arch32().win().setup();
					HashMap<String, Object> chromePrefs = new HashMap<>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadPath);
					chromePrefs.put("safebrowsing.enabled", "true");
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePrefs);
					driver = new ChromeDriver(options);
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().arch32().win().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().arch32().win().setup();
					driver = new EdgeDriver();
					break;
				case "opera":
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
							+ "/src/main/java/Resources/Drivers/32bitDrivers/windows/opera driver/operadriver.exe");
					driver = new ChromeDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
							+ "/src/main/java/Resources/Drivers/32bitDrivers/windows/chromedriver.exe");
					HashMap<String, Object> chromePrefs1 = new HashMap<>();
					chromePrefs1.put("profile.default_content_settings.popups", 0);
					chromePrefs1.put("download.default_directory", downloadPath);

					chromePrefs1.put("safebrowsing.enabled", "true");
					ChromeOptions options1 = new ChromeOptions();
					options1.setExperimentalOption("prefs", chromePrefs1);
					driver = new ChromeDriver(options1);

				}
				break;

			case "linux":

				switch (browser.toLowerCase())
				{

				case "chrome":
					WebDriverManager.chromedriver().arch32().linux().setup();
					HashMap<String, Object> chromePrefs = new HashMap<>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadPath);

					chromePrefs.put("safebrowsing.enabled", "true");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--no-sandbox");
					options.addArguments("--headless"); // should be enabled for Jenkins
					options.addArguments("--disable-dev-shm-usage"); // should be enabled for Jenkins
					options.addArguments("--window-size=1920x1080");
					options.setExperimentalOption("prefs", chromePrefs);
					driver = new ChromeDriver(options);
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().arch32().linux().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().arch32().linux().setup();
					driver = new EdgeDriver();
					break;
				case "opera":
					WebDriverManager.operadriver().arch32().linux().setup();
					driver = new ChromeDriver();
					break;
				default:
					WebDriverManager.chromedriver().arch32().linux().setup();
					HashMap<String, Object> chromePrefs1 = new HashMap<>();
					chromePrefs1.put("profile.default_content_settings.popups", 0);
					chromePrefs1.put("download.default_directory", downloadPath);

					chromePrefs1.put("safebrowsing.enabled", "true");
					ChromeOptions options1 = new ChromeOptions();
					options1.setExperimentalOption("prefs", chromePrefs1);
					driver = new ChromeDriver(options1);

				}
			}
			break;

		case "x64":
		case "X64":
			switch (oS.toLowerCase())
			{
			case "windows":

				switch (browser.toLowerCase())
				{

				case "chrome":
					WebDriverManager.chromedriver().arch64().win().setup();
					ChromeOptions options = new ChromeOptions();

					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("safebrowsing.enabled", "true");
					options.addArguments("--headless");
					options.addArguments("--no-sandbox");
					options.addArguments(Arrays.asList("--window-position=0,0"));
					options.addArguments(Arrays.asList("--window-size=1840,1080"));
                    options.setExperimentalOption("prefs", chromePrefs);
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = new ChromeDriver(cap);
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().arch64().win().setup();

					//WebDriverManager.firefoxdriver().driverVersion("0.26.0").arch64().win().setup();

					FirefoxOptions firefoxopt =new FirefoxOptions();
					firefoxopt.addArguments("--headless");
					driver = new FirefoxDriver(firefoxopt);
					break;
				case "edge":
					WebDriverManager.edgedriver().arch64().win().setup();
					driver = new EdgeDriver();
					break;
				case "opera":
					WebDriverManager.operadriver().arch64().win().setup();
					driver = new ChromeDriver();
					break;
				default:
					WebDriverManager.chromedriver().arch64().win().setup();
					HashMap<String, Object> chromePrefs1 = new HashMap<>();
					chromePrefs1.put("profile.default_content_settings.popups", 0);
					chromePrefs1.put("download.default_directory", downloadPath);

					chromePrefs1.put("safebrowsing.enabled", "true");
					ChromeOptions options1 = new ChromeOptions();
					options1.setExperimentalOption("prefs", chromePrefs1);
					driver = new ChromeDriver(options1);
				}
				break;

			case "linux":

				switch (browser.toLowerCase()) {

				case "chrome":
					WebDriverManager.chromedriver().arch64().linux().setup();
//					HashMap<String, Object> chromePrefs = new HashMap<>();
//					chromePrefs.put("profile.default_content_settings.popups", 0);
//					chromePrefs.put("download.default_directory", downloadPath);
//					chromePrefs.put("safebrowsing.enabled", "true");
//					ChromeOptions options = new ChromeOptions();
//					options.setExperimentalOption("prefs", chromePrefs);
//					options.addArguments("--headless");
//					driver = new ChromeDriver(options);
					ChromeOptions options = new ChromeOptions();

					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadPath);
					chromePrefs.put("safebrowsing.enabled", "true");
					options.addArguments("--headless");
					options.addArguments("--no-sandbox");
					options.addArguments(Arrays.asList("--window-position=0,0"));
					options.addArguments(Arrays.asList("--window-size=1840,1080"));
                    options.setExperimentalOption("prefs", chromePrefs);
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = new ChromeDriver(cap);
					
					break;


				case "firefox":
					WebDriverManager.firefoxdriver().arch64().linux().setup();
					driver = new FirefoxDriver();
					FirefoxOptions firefoxopt =new FirefoxOptions();
					//firefoxopt.addArguments("--headless");
					break;
				case "edge":
					WebDriverManager.edgedriver().arch64().linux().setup();
					driver = new EdgeDriver();
					break;
				case "opera":
					WebDriverManager.operadriver().arch64().linux().setup();
					driver = new ChromeDriver();
					break;
				default:
					WebDriverManager.chromedriver().arch64().linux().setup();
					HashMap<String, Object> chromePrefs1 = new HashMap<>();
					chromePrefs1.put("profile.default_content_settings.popups", 0);
					chromePrefs1.put("download.default_directory", downloadPath);

					chromePrefs1.put("safebrowsing.enabled", "true");
					ChromeOptions options1 = new ChromeOptions();
					options1.setExperimentalOption("prefs", chromePrefs1);
					driver = new ChromeDriver(options1);

				}
				break;

			default:
				WebDriverManager.chromedriver().arch64().linux().setup();
				HashMap<String, Object> chromePrefs = new HashMap<>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadPath);

				chromePrefs.put("safebrowsing.enabled", "true");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(options);
			}
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	 public byte[] getScreenshot(WebDriver driver) throws IOException
	 {
	    	
	    	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        byte[] filecontent = FileUtils.readFileToByteArray(src);
	        return filecontent;
	    }

}
