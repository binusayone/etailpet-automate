package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import retailerDashboardPageFactory.RetailerDashboardLoginPage;
import retailerDashboardPageFactory.UpdateSubscription;
import settings.Constants;

public class UpdateSubscriptionTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty(Constants.DRIVER_KEY, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.WEBSITE_URL);
	}

	@Test(priority = 0)
	public void retailerLogin() {
		RetailerDashboardLoginPage loginPage = new RetailerDashboardLoginPage(driver);
		loginPage.loginCredentials(Constants.EMAILADDRESS, Constants.PASSWORD);
		String username = loginPage.getHomePage();
		if (username.contains(Constants.USER_PROFILE)) {
			System.out.println(Constants.LOGIN_SUCCESS);
		} else {
			System.out.println(Constants.LOGIN_FAILED);
		}
	}

	@Test(priority = 1)
	public void updatePlan() {
		try {
			UpdateSubscription subscription = new UpdateSubscription(driver);
			subscription.clickChangePlan();
			String planName = subscription.selectPremiumPlanName();
			if (planName.equals(Constants.INTEGRATED_PREMIUM_PLAN)) {
				subscription.clickOnPremiumPlan();
				subscription.clickStoreName();
				subscription.clickStartPlan();
			}
			String message = subscription.getMessage();
			//System.out.println(message);
			if(message.contains(Constants.SUBSCRIPTION_SUCCESS)) {
				System.out.println("Subscription changed successfully!!!");
			} else {
				System.out.println("Failed!!!");
			}
		
		} catch (Throwable e) {
			System.out.println("Error Log: " + e.getMessage());
		}
	}
}
