package apps.bluesource;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.thoughtworks.selenium.ScreenshotListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class simple {
	@FindBy(id = "employee_username")
	private WebElement username;
	
	@FindBy(id = "employee_password")
	private WebElement password;
	
	@FindBy(name = "commit")
	private WebElement login;
	
	By byUsername = By.id("employee_username");
	By byPassword = By.id("employee_password");
	By byLogin = By.name("commit");
	
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://bluesourcestaging.herokuapp.com");
		driver.findElement(By.id("employee_username")).sendKeys("company.admin");
		driver.findElement(By.id("employee_password")).sendKeys("test");
		driver.findElement(By.name("commit")).click();
	}
	
	@Test
	public void test2(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://bluesourcestaging.herokuapp.com");
		username.sendKeys("company.admin");
		password.sendKeys("test");
		login.click();
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	}
	
	@Test
	public void test3(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://bluesourcestaging.herokuapp.com");
		driver.findElement(byUsername).sendKeys("company.admin");
		driver.findElement(byPassword).sendKeys("test");
		driver.findElement(byLogin).click();
		
		Assert.
	}
}
