package core.test;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSetup {
	//****************
	//* CLASS FIElDS *
	//****************
	//Define a base driver from which all extending classes will inherit
	private WebDriver driver;
	//Define test attributes
	private String browserType;
	private String browserVersion;
	private String operatingSystem;
	private String environment;
	private String runLocation;
	
	//*********************
	//* DRIVER BUILD AREA *
	//*********************
	public WebDriverSetup(){
		setBrowserType("chrome");
		setBrowserVersion("");
		setOperatingSystem("windows");
		setEnvironment("stage");
		setRunLocation("");
		generateDriver();
	}
	
	//***********************
	//* GETTERS AND SETTERS *
	//***********************
	//Define getter/setter for the base driver
	/**
	 * @summary sets the base webdriver for the test
	 * @param driver - WebDriver, current test WebDriver
	 */
	private void setDriver(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * @summary gets the base webdriver for the test
	 * @return WebDriver
	 */
	public WebDriver getDriver(){
		return this.driver;
	}
	
	//Define getter/setter for the browser type
	/**
	 * @summary sets the browser under test
	 * @param browserType - String, browser under test
	 */
	public void setBrowserType(String browserType){
		this.browserType = browserType;
	}
	/**
	 * @summary gets the browser under test
	 * @return 
	 */
	public String getBrowserType(){
		return this.browserType;
	}
	
	//Define getter/setter for the browser version
	public void setBrowserVersion(String browserVersion){
		this.browserVersion = browserVersion;
	}
	public String getBrowserVersion(){
		return this.browserVersion;
	}
	
	//Define getter/setter for the operating system
	public void setOperatingSystem(String operatingSystem){
		this.operatingSystem = operatingSystem;
	}
	public String getOperatingSystem(){
		return this.operatingSystem;
	}
	
	//Define getter/setter for the environment
	public void setEnvironment(String environment){
		this.environment = environment;
	}
	public String getEnvironment(){
		return this.environment;
	}
	
	//Define getter/setter for the run location
	public void setRunLocation(String runLocation){
		this.runLocation = runLocation;
	}
	public String getRunLocation(){
		return this.runLocation;
	}
	
	
	//***********************
	//* DRIVER INTERACTIONS *
	//***********************
	public void closeAllBrowsersAndQuitDriver(WebDriver driver){
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			driver.switchTo().window(handle);
			driver.close();
		}
		driver.quit();
		
		if(getBrowserType().equalsIgnoreCase("chrome")){
			if(getOperatingSystem().equalsIgnoreCase("windows")){
				try {
					Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
					Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
				} catch (IOException ioe) {
					System.out.println("ERROR: Unable to close chrome drivers and browsers.");
				}	
			}
		}
	}
	
	private void generateDriver(){
		switch (getBrowserType().toLowerCase()) {
		case "firefox":
			setDriver(new FirefoxDriver());
			break;
		case "iexplore":
			System.setProperty("webdriver.ie.driver", "C:\\Users\\temp\\workspace\\Selenium_Java\\src\\main\\java\\drivers\\IEDriverServer.exe");
			setDriver(new InternetExplorerDriver());
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\temp\\workspace\\Selenium_Java\\src\\main\\java\\drivers\\chromedriver.exe");
			setDriver(new ChromeDriver());
			break;
		default:
			break;
	}
	}
}
