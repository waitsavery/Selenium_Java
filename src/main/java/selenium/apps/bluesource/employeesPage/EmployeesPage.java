package selenium.apps.bluesource.employeesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.core.page.BasePageClass;
import selenium.core.test.BaseTestClass;

public class EmployeesPage extends BasePageClass{
	// ******************************
	// * EMPLOYEE PAGE CLASS FIElDS *
	// ******************************
	
	// **********************************
	// * EMPLOYEE PAGE CLASS BUILD AREA *
	// **********************************
//	@FindBy(xpath = "ng-app")
	
	/**
	 * Dummy constructor
	 */
	public EmployeesPage(){}
	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance to define the driver to use to find elements
	 * @param btc - BaseTestClass, passed from the test level when a page class is instantiated
	 */
	public EmployeesPage(BaseTestClass btc){
		setElementBaseTestClass(btc);
		PageFactory.initElements(getElementDriver(), this);
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// ************************************
	// * EMPLOYEE PAGE CLASS INTERACTIONS *
	// ************************************	
}
