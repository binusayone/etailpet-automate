package retailerDashboardPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import settings.Constants;

public class UpdateSubscription {

	WebDriver driver;

	public UpdateSubscription(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='pull-right plan-navbar-info mr-50']//a")
	WebElement changePlanButton;

	@FindBy(xpath = "//h4[text()='Integrated Marketing']")
	WebElement selectPlanName;

	@FindBy(xpath = "//div[@class='hdr']//a[@href='/retailer/plans/2/checkout/']//button")
	WebElement premiumPlan;

	@FindBy(xpath = "//button[@class='multiselect dropdown-toggle btn btn-default']")
	WebElement storesDropdown;

	@FindBy(xpath = "//label[@title='Awesome Florida1']//input")
	WebElement storeName;

	@FindBy(xpath = "//button[@id='updateStores']")
	WebElement selectButton;

	@FindBy(xpath = "//button[@id='startPlan']")
	WebElement startPlanButton;

	@FindBy(xpath = "//div[@class='price-plan']//p")
	WebElement subscriptionMessage;

	public void clickChangePlan() {
		try {
			changePlanButton.click();
		} catch (Throwable e) {
			System.out.println(Constants.CHANGE_PLAN_BUTTON);
		}
	}

	public String selectPremiumPlanName() {
		return selectPlanName.getText();
	}

	public void clickOnPremiumPlan() {
		premiumPlan.click();
	}

	public void clickStoreName() {
		storesDropdown.click();
		storeName.click();
		storesDropdown.click();
		selectButton.click();
	}

	public void clickStartPlan() {
		startPlanButton.click();

	}

	public String getMessage() {
		return subscriptionMessage.getText();
	}

}
