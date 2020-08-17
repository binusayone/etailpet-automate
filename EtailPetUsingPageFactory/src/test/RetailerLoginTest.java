package test;

import org.testng.annotations.Test;

import retailerDashboardPageFactory.RetailerDashboardLoginPage;
import settings.Constants;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetailerLoginTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty(Constants.DRIVER_KEY, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.WEBSITE_URL);
	}

	/*
	 * TESTCASE – 1 [ Enter Correct Email and Password ]
	 */

	@Test
	public void testValidLogin() {
		RetailerDashboardLoginPage loginPage = new RetailerDashboardLoginPage(driver);
		loginPage.loginCredentials(Constants.EMAILADDRESS, Constants.PASSWORD);
		String username = loginPage.getHomePage();
		if (username.contains(Constants.USER_PROFILE)) {
			System.out.println(Constants.LOGIN_SUCCESS);
		} else {
			System.out.println(Constants.LOGIN_FAILED);
		}
	}

	/*
	 * TESTCASE – 2 [ Invalid Username and invalid password ]
	 */

	@Test(priority = 0)
	public void testInvalidLogin() {
		RetailerDashboardLoginPage loginPage = new RetailerDashboardLoginPage(driver);
		loginPage.loginCredentials(Constants.IN_EMAILADDRESS, Constants.IN_PASSWORD);
		String errorMessage = loginPage.getErrorMessage();
		if (errorMessage.equals(Constants.ERROR_MESSAGE)) {
			System.out.println(Constants.LOGIN_FAILED);
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
