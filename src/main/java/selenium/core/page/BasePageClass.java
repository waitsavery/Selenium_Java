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
	String message;

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
		syncVisible();
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
	
	//*******************************
	//*			SYNC VISIBLE		*
	//*******************************
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
		isVisible = syncVisible(timeout);
		if(failOnFalse && !isVisible){
			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return isVisible;
	}
	
	public Boolean syncVisible(Boolean failOnFalse){
		Boolean isVisible = false;
		isVisible = syncVisible();
		if(failOnFalse && !isVisible){
			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return isVisible;
	}
	
	public Boolean syncVisible(WebElement element){
		setElement(element);
		return syncVisible();
	}
	
	public Boolean syncVisible(WebElement element, long timeout){
		setElement(element);
		return syncVisible(timeout);
	}

	public Boolean syncVisible(WebElement element, long timeout, Boolean failOnFalse){
		setElement(element);
		return syncVisible(timeout, failOnFalse);
	}

	public Boolean syncVisible(WebElement element, Boolean failOnFalse){
		setElement(element);
		return syncVisible(failOnFalse);
	}	
	
	public Boolean syncVisible(By by){
		setElement(by);
		return syncVisible();
	}
	
	public Boolean syncVisible(By by, long timeout){
		setElement(by);
		return syncVisible(timeout);
	}

	public Boolean syncVisible(By by, long timeout, Boolean failOnFalse){
		setElement(by);
		return syncVisible(timeout, failOnFalse);
	}

	public Boolean syncVisible(By by, Boolean failOnFalse){
		setElement(by);
		return syncVisible(failOnFalse);
	}
	
	//*******************************
	//*			SYNC HIDDEN			*
	//*******************************
	public Boolean syncHidden(){return !syncVisible();}
	public Boolean syncHidden(long timeout){return !syncVisible(timeout);}
	public Boolean syncHidden(long timeout, Boolean failOnFalse){return !syncVisible(timeout, failOnFalse);}
	public Boolean syncHidden(Boolean failOnFalse){return !syncVisible(failOnFalse);}
	public Boolean syncHidden(WebElement element){return !syncVisible(element);}
	public Boolean syncHidden(WebElement element, long timeout){return !syncVisible(element,timeout);}
	public Boolean syncHidden(WebElement element, long timeout, Boolean failOnFalse){return !syncVisible(element, timeout, failOnFalse);}
	public Boolean syncHidden(WebElement element, Boolean failOnFalse){return !syncVisible(element, failOnFalse);}
	public Boolean syncHidden(By by){return !syncVisible(by);}
	public Boolean syncHidden(By by, long timeout){return !syncVisible(by,timeout);}
	public Boolean syncHidden(By by, long timeout, Boolean failOnFalse){return !syncVisible(by, timeout, failOnFalse);}
	public Boolean syncHidden(By by, Boolean failOnFalse){return !syncVisible(by, failOnFalse);}

	//*******************************
	//*			SYNC ENABLED		*
	//*******************************
	public Boolean syncEnabled(){
		Boolean isEnabled = false;
		if(this.timeout == 0.0) this.timeout = Constants.getImplicitWaitTimeout();
		System.out.println("Syncing to element ["+getElementLocator()+"] to be enabled within ["+String.valueOf(timeout)+"] seconds.");
		getElementDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		isEnabled = getElement().isEnabled();
		this.timeout = (long) 0.0;
		getElementDriver().manage().timeouts().implicitlyWait(Constants.getImplicitWaitTimeout(), TimeUnit.SECONDS);
		return isEnabled;
	}
	
	public Boolean syncEnabled(long timeout){
		Boolean isEnabled = false;
		this.timeout = timeout;
		isEnabled = syncEnabled();
		return isEnabled;
	}
	
	public Boolean syncEnabled(long timeout, Boolean failOnFalse){
		Boolean isEnabled = false;
		isEnabled = syncEnabled(timeout);
		if(failOnFalse && !isEnabled){
			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return isEnabled;
	}
	
	public Boolean syncEnabled(Boolean failOnFalse){
		Boolean isEnabled = false;
		isEnabled = syncEnabled();
		if(failOnFalse && !isEnabled){
			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return isEnabled;
	}
	
	public Boolean syncEnabled(WebElement element){
		setElement(element);
		return syncEnabled();
	}
	
	public Boolean syncEnabled(WebElement element, long timeout){
		setElement(element);
		return syncEnabled(timeout);
	}

	public Boolean syncEnabled(WebElement element, long timeout, Boolean failOnFalse){
		setElement(element);
		return syncEnabled(timeout, failOnFalse);
	}

	public Boolean syncEnabled(WebElement element, Boolean failOnFalse){
		setElement(element);
		return syncEnabled(failOnFalse);
	}	
	
	public Boolean syncEnabled(By by){
		setElement(by);
		return syncEnabled();
	}
	
	public Boolean syncEnabled(By by, long timeout){
		setElement(by);
		return syncEnabled(timeout);
	}

	public Boolean syncEnabled(By by, long timeout, Boolean failOnFalse){
		setElement(by);
		return syncEnabled(timeout, failOnFalse);
	}

	public Boolean syncEnabled(By by, Boolean failOnFalse){
		setElement(by);
		return syncEnabled(failOnFalse);
	}
	
	//*******************************
	//*			SYNC DISABLED			*
	//*******************************
	public Boolean syncDisabled(){return !syncEnabled();}
	public Boolean syncDisabled(long timeout){return !syncEnabled(timeout);}
	public Boolean syncDisabled(long timeout, Boolean failOnFalse){return !syncEnabled(timeout, failOnFalse);}
	public Boolean syncDisabled(Boolean failOnFalse){return !syncEnabled(failOnFalse);}
	public Boolean syncDisabled(WebElement element){return !syncEnabled(element);}
	public Boolean syncDisabled(WebElement element, long timeout){return !syncEnabled(element,timeout);}
	public Boolean syncDisabled(WebElement element, long timeout, Boolean failOnFalse){return !syncEnabled(element, timeout, failOnFalse);}
	public Boolean syncDisabled(WebElement element, Boolean failOnFalse){return !syncEnabled(element, failOnFalse);}
	public Boolean syncDisabled(By by){return !syncEnabled(by);}
	public Boolean syncDisabled(By by, long timeout){return !syncEnabled(by,timeout);}
	public Boolean syncDisabled(By by, long timeout, Boolean failOnFalse){return !syncEnabled(by, timeout, failOnFalse);}
	public Boolean syncDisabled(By by, Boolean failOnFalse){return !syncEnabled(by, failOnFalse);}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Boolean sync(String visibleHiddenEnabledDisabled){
		Boolean isTrue = false;
		String[] validSyncs = {"visible", "hidden", "enabled", "disabled"};
		if(this.timeout == 0.0) this.timeout = Constants.getImplicitWaitTimeout();
		getElementDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		System.out.println("Syncing to element ["+getElementLocator()+"] to be "+visibleHiddenEnabledDisabled+" within ["+String.valueOf(timeout)+"] seconds.");
		
		switch (visibleHiddenEnabledDisabled.toLowerCase()) {
			case "visible":
				isTrue = getElement().isDisplayed();
				break;
			case "hidden":
				isTrue = !(getElement().isDisplayed());
				break;
			case "enabled":
				isTrue = getElement().isEnabled();
				break;
			case "disabled":
				isTrue = !(getElement().isEnabled());
				break;
			default:
				message = "The sync type ["+visibleHiddenEnabledDisabled+"] is not valid. Valid values are: ["+validSyncs.toString()+"]";
				break;
		}
		
		this.timeout = (long) 0.0;
		getElementDriver().manage().timeouts().implicitlyWait(Constants.getImplicitWaitTimeout(), TimeUnit.SECONDS);
		return isTrue;
	}
//	
//	public Boolean syncVisible(long timeout){
//		Boolean isVisible = false;
//		this.timeout = timeout;
//		isVisible = syncVisible();
//		return isVisible;
//	}
//	
//	public Boolean syncVisible(long timeout, Boolean failOnFalse){
//		Boolean isVisible = false;
//		isVisible = syncVisible(timeout);
//		if(failOnFalse && !isVisible){
//			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
//			System.out.println(message);
//			throw new RuntimeException(message);
//		}
//		return isVisible;
//	}
//	
//	public Boolean syncVisible(Boolean failOnFalse){
//		Boolean isVisible = false;
//		isVisible = syncVisible();
//		if(failOnFalse && !isVisible){
//			String message = "The element ["+getElementLocator()+"] was not located within ["+String.valueOf(this.timeout)+"] seconds.";
//			System.out.println(message);
//			throw new RuntimeException(message);
//		}
//		return isVisible;
//	}
//	
//	public Boolean syncVisible(WebElement element){
//		setElement(element);
//		return syncVisible();
//	}
//	
//	public Boolean syncVisible(WebElement element, long timeout){
//		setElement(element);
//		return syncVisible(timeout);
//	}
//
//	public Boolean syncVisible(WebElement element, long timeout, Boolean failOnFalse){
//		setElement(element);
//		return syncVisible(timeout, failOnFalse);
//	}
//
//	public Boolean syncVisible(WebElement element, Boolean failOnFalse){
//		setElement(element);
//		return syncVisible(failOnFalse);
//	}	
//	
//	public Boolean syncVisible(By by){
//		setElement(by);
//		return syncVisible();
//	}
//	
//	public Boolean syncVisible(By by, long timeout){
//		setElement(by);
//		return syncVisible(timeout);
//	}
//
//	public Boolean syncVisible(By by, long timeout, Boolean failOnFalse){
//		setElement(by);
//		return syncVisible(timeout, failOnFalse);
//	}
//
//	public Boolean syncVisible(By by, Boolean failOnFalse){
//		setElement(by);
//		return syncVisible(failOnFalse);
//	}
//	
//	//*******************************
//	//*			SYNC HIDDEN			*
//	//*******************************
//	public Boolean syncHidden(){return !syncVisible();}
//	public Boolean syncHidden(long timeout){return !syncVisible(timeout);}
//	public Boolean syncHidden(long timeout, Boolean failOnFalse){return !syncVisible(timeout, failOnFalse);}
//	public Boolean syncHidden(Boolean failOnFalse){return !syncVisible(failOnFalse);}
//	public Boolean syncHidden(WebElement element){return !syncVisible(element);}
//	public Boolean syncHidden(WebElement element, long timeout){return !syncVisible(element,timeout);}
//	public Boolean syncHidden(WebElement element, long timeout, Boolean failOnFalse){return !syncVisible(element, timeout, failOnFalse);}
//	public Boolean syncHidden(WebElement element, Boolean failOnFalse){return !syncVisible(element, failOnFalse);}
//	public Boolean syncHidden(By by){return !syncVisible(by);}
//	public Boolean syncHidden(By by, long timeout){return !syncVisible(by,timeout);}
//	public Boolean syncHidden(By by, long timeout, Boolean failOnFalse){return !syncVisible(by, timeout, failOnFalse);}
//	public Boolean syncHidden(By by, Boolean failOnFalse){return !syncVisible(by, failOnFalse);}
}
