package apps.bluesource;

import org.testng.annotations.Test;

import selenium.apps.bluesource.loginPage.LoginPage;

public class BlueSource_Login extends selenium.core.test.BaseTestClass {
	public BlueSource_Login() {
	}

	@Test
	public void test() {

		LoginPage login = new LoginPage(getBaseTestClass());
		login.login();
	}
}
