package core.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass extends WebDriverSetup{
	private long implicitWaitTimeout;
	private long pageLoadTimeout;
	private long scriptTimeout;
	private int defaultTestTimeout;
	private String application;
	private String userRole;
	
	enum classTypes {String, Int, Double};
	
	public BaseTestClass(){
		setApplication("bluesource");
		setUserRole("company admin");
		manageDriver();
	}
	
	public void setImplicitWaitTimeout(long timeout){
		this.implicitWaitTimeout = timeout;
		getDriver().manage().timeouts().implicitlyWait( getImplicitWaitTimeout(), TimeUnit.SECONDS);
	}
	
	public long getImplicitWaitTimeout(){
		return this.implicitWaitTimeout;
	}
	
	public void setPageLoadTimeout(long timeout){
		this.pageLoadTimeout = timeout;
		getDriver().manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
	}
	
	public long getPageLoadTimeout(){
		return this.pageLoadTimeout;
	}
	
	public void setScriptTimeout(long timeout){
		this.pageLoadTimeout = timeout;
		getDriver().manage().timeouts().setScriptTimeout(getScriptTimeout(), TimeUnit.SECONDS);
	}
	
	public long getScriptTimeout(){
		return this.scriptTimeout;
	}
	
	public void setDefaultTestTimeout(int timeout){
		this.defaultTestTimeout = timeout;
	}
	
	public int getDefaultTestTimeout(){
		return this.defaultTestTimeout;
	}
	
	private void setTestTimeouts(){
		setImplicitWaitTimeout(Constants.getImplicitWaitTimeout());
		setPageLoadTimeout(Constants.getPageLoadTimeout());
		setScriptTimeout(Constants.getScriptTimeout());
		setDefaultTestTimeout(Constants.getDefaultTestTimeout());
	}
	
	private void manageDriver(){
		setTestTimeouts();
		getDriver().manage().timeouts().implicitlyWait(getImplicitWaitTimeout(), TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
		getDriver().manage().timeouts().setScriptTimeout(getScriptTimeout(), TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}
	
	public void setApplication(String application){
		this.application = application;
	}
	
	public String getApplication(){
		return this.application;
	}
	
	public void setUserRole(String role){
		this.userRole = role;
	}
	
	public String getuserRole(){
		return this.userRole;
	}
	
	@BeforeTest
	public void beforeTest(){
		getDriver().get(Constants.getURL(getApplication(), getEnvironment()));
	}
	
	@AfterTest
	public void afterTest(){
		closeAllBrowsersAndQuitDriver(getDriver());
	}
}
