package selenium.core.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.core.Constants;
import selenium.core.test.BaseTestClass;

public class BasePageClass extends Element{

	// **************************
	// * BASE PAGE CLASS FIElDS *
	// **************************
	long timeout;

	// ******************************
	// * BASE PAGE CLASS BUILD AREA *
	// ******************************
	/**
	 * Dummy constructor
	 */
	public BasePageClass(){}
	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance to define the driver to use to find elements
	 * @param btc - BaseTestClass, passed from the test level when a page class is instantiated
	 */
	public BasePageClass(BaseTestClass btc){
		System.out.println("Entering BasePageClass");
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// ********************************
	// * BASE PAGE CLASS INTERACTIONS *
	// ********************************
	public void set(String value){
		System.out.println("Sending keys ["+value+"] to element ["+getElementLocator()+"].");
		getElement().clear();
		getElement().sendKeys(value);
	}
	
	public void set(WebElement element, String value){
		setElement(element);
		set(value);
	}
	
	public void set(By by, String value){
		setElement(by);
		set(value);
	}
	
	public void set(WebDriver driver, By by, String value){
		setElementAndDriver(driver, by);
		set(value);
	}
	
	public void click(){
		getElement().click();
	}
	
	public void click(WebElement element){
		System.out.println("Clicking on element ["+getElementLocator()+"].");
		setElement(element).click();
	}
	
	public void click(By by){
		click(getElementDriver().findElement(by));
	}
	
	public void click(WebDriver driver, By by){
		click(setElementAndDriver(driver, by));
	}
	
	//***************************
	//***************************
	//*			SYNCS			*
	//***************************
	//***************************
	public Boolean syncVisible(){
		Boolean isVisible = false;
		if(this.timeout == 0.0) this.timeout = Constants.getImplicitWaitTimeout();
		System.out.println("Syncing to element ["+getElementLocator()+"] to be visible within ["+String.valueOf(timeout)+"] seconds.");
		getElementDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		isVisible = getElement().isDisplayed();
		this.timeout = (long) 0.0;
		getElementDriver().manage().timeouts().implicitlyWait(Constants.getImplicitWaitTimeout(), TimeUnit.SECONDS);
		return isVisible;
	}
	
	public Boolean syncVisible(long timeout){
		Boolean isVisible = false;
		this.timeout = timeout;
		isVisible = syncVisible();
		return isVisible;
	}
	
	public Boolean syncVisible(long timeout, Boolean failOnFalse){
		Boolean isVisible = false;
		this.timeout = timeout;
		isVisible = syncVisible();
		if(failOnFalse && !isVisible){
			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return isVisible;
	}
}
