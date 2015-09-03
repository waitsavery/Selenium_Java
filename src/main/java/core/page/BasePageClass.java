package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.test.BaseTestClass;

public class BasePageClass extends Element{

	// ************************
	// * BASE PAGE CLASS FIElDS *
	// ************************

	// ****************************
	// * BASE PAGE CLASS BUILD AREA *
	// ****************************
	/**
	 * Dummy constructor
	 */
	public BasePageClass(){}
	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance to define the driver to use to find elements
	 * @param btc - BaseTestClass, passed from the test level when a page class is instantiated
	 */
	public BasePageClass(BaseTestClass btc){}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// ******************************
	// * BASE PAGE CLASS INTERACTIONS *
	// ******************************
	public void set(String value){
		System.out.println("Sending keys ["+value+"] to element ["+getElement().toString()+"].");
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
		System.out.println("Clicking on element ["+getElement().toString()+"].");
		setElement(element).click();
	}
	
	public void click(By by){
		click(getElementDriver().findElement(by));
	}
	
	public void click(WebDriver driver, By by){
		click(setElementAndDriver(driver, by));
	}
}
