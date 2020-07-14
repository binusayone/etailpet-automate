package test;

import org.testng.annotations.Test;

import retailerDashboardPageFactory.RetailerDashboardLoginPage;

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
		System.setProperty("webdriver.chrome.driver",
				"C://Users//binuababu//Downloads//Chrome Driver Version 83//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://awesomepets.dev.etailpet.com/site-admin/login/");
	}

	/*
	 * TESTCASE – 1 [ Enter Correct Email and Password ]
	 */
	
	@Test
	public void testValidLogin() {
		RetailerDashboardLoginPage loginPage = new RetailerDashboardLoginPage(driver);
		loginPage.loginCredentials("refodazaa@getnada.com", "test@100");
		String username = driver.findElement(By.xpath("//span[@class='user-name']")).getText();
		if (username.contains("Hi")) {
			System.out.println("Login Successfull");
		} else {
			System.out.println("Login Failed");
		}
	}
	
	
	/*
	 * TESTCASE – 2 [ Invalid Username and invalid password ]
	 */
	
	@Test (priority = 0)
	public void testInvalidLogin() {
		RetailerDashboardLoginPage loginPage = new RetailerDashboardLoginPage(driver);
		loginPage.loginCredentials("test@gmail.com", "test@100");
		String errorMessage = driver.findElement(By.xpath("//p[@class='text-danger']")).getText();
		if (errorMessage.equals("Please enter correct email and password.")) {
			System.out.println("Invalid Login");
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
