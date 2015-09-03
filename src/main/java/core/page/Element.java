package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.test.BaseTestClass;

public class Element {
	private WebElement element;
	private WebDriver elementDriver;
	
	private Element(BaseTestClass btc){
		setElementDriver(btc.getDriver());
	}
	
	private void setElementDriver(WebDriver driver){
		this.elementDriver = driver;
	}
	
	private WebDriver getElementDriver(){
		return this.elementDriver;
	}
	
	public WebElement setElement(WebElement element){
		this.element = element;
		return getElement();
	}
	
	public WebElement setElement(By by){
		this.element = getElementDriver().findElement(by);
		return getElement();
	}
	
	public WebElement setElement(WebDriver driver, By by){
		setElementDriver(driver);
		setElement(by);
		return getElement();
	}
	
	public WebElement getElement(){
		return this.element;
	}
	
	public void set(String value){
		System.out.println("Sending keys ["+value+"] to element ["+getElement().toString()+"].");
		getElement().clear();
		getElement().sendKeys(value);
	}
	
	public void set(By by, String value){
		setElement(by);
		set(value);
	}
	
	public void set(WebDriver driver, By by, String value){
		setElement(driver, by);
		set(value);
	}
}
