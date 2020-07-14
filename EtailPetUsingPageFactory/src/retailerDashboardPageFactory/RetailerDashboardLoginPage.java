package retailerDashboardPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerDashboardLoginPage {

	WebDriver driver;

	public RetailerDashboardLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='signin-username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id='signin-password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath = "//span[@class='user-name']")
	WebElement userProfile;
	
	@FindBy(xpath = "//p[@class='text-danger']")
	WebElement errorMessage;

	public void loginCredentials(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLoginButton();

	}

	private void clickLoginButton() {
		signInButton.click();

	}

	private void setPassword(String password) {
		passwordField.sendKeys(password);

	}

	private void setUsername(String username) {
		usernameField.sendKeys(username);
	}

	public String getHomePage() {
		return userProfile.getText();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
