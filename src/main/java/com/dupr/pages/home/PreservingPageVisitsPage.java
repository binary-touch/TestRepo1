package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class PreservingPageVisitsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(UserDashboardPage.class);

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearchField;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement txtName;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//input[@placeholder='Location']")
	private WebElement txtLocationField;

	@B2BFindBy(xpath = "//span[contains(text(),'Bellampalli, Telangana, India')]")
	private WebElement txtLocation;

	@B2BFindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement btnLogout;

	@B2BFindBy(xpath = "//p[contains(text(),'Sign up')]")
	private WebElement btnSignUp;

	@B2BFindBy(xpath = "//button[contains(text(),'Claim Account')]")
	private WebElement btnClamAccount;

	@B2BFindBy(xpath = "//button[contains(text(),'Go Back')]")
	private WebElement btnGoBack;

	public PreservingPageVisitsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnPlayersSearch(String Name) {
		log.info("Starting of clickOnDashboardMenu method");

		clickOnWebElement(txtSearchField);
		this.txtSearchField.sendKeys(Name);

		log.info("Ending of clickOnDashboardMenu method");
	}

	public void clearSearchField() {
		log.info("Starting of clearSearchField method");

		driver.navigate().refresh();
		/*
		 * try { this.hardWait(3); this.txtSearchField.sendKeys(Keys.CONTROL + "a" +
		 * Keys.BACK_SPACE);
		 * 
		 * } catch (Exception e) { this.txtSearchField.clear(); }
		 */

		log.info("Ending of clearSearchField method");
	}

	public void clickOnName() {
		log.info("Starting of clickOnDashboardMenu method");

		clickOnWebElement(txtName);

		log.info("Ending of clickOnDashboardMenu method");
	}

	public void clickOnSignUpButton() {
		log.info("Starting of clickOnSignUpButton method");

		clickOnWebElement(btnSignUp);

		log.info("Ending of clickOnSignUpButton method");
	}

	public void clickOnLogoutButton() {
		log.info("Starting of clickOnLogoutButton method");

		clickOnWebElement(btnLogout);

		log.info("Ending of clickOnLogoutButton method");
	}

	public void clickOnBackButton() {
		log.info("Starting of clickOnBackButton method");
		try {
			elementClick(btnBack);

		} catch (Exception e) {
			clickOnWebElement(btnBack);
		}

		log.info("Ending of clickOnBackButton method");
	}

	public boolean getPlayerName(String name) {
		log.info("Starting of clickOnBackButton method");
		log.info("Ending of clickOnBackButton method");

		return txtSearchField.getAttribute("Value").equals(name);
	}

	public boolean getLocation(String Location) {
		log.info("Starting of clickOnBackButton method");
		log.info("Ending of clickOnBackButton method");

		return txtLocationField.getAttribute("Value").contains(Location);
	}

	public void clickOnLocationField(String Location) {
		log.info("Starting of clickOnLocationField method");

		clickOnWebElement(txtLocationField);
		this.txtLocationField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		this.txtLocationField.sendKeys(Location);

		log.info("Ending of clickOnLocationField method");
	}

	public void clickOnLocation() {
		log.info("Starting of clickOnLocation method");

		clickOnWebElement(txtLocation);

		log.info("Ending of clickOnLocation method");
	}

	public void clickOnClamAccount() {
		log.info("Starting of clickOnDashboardMenu method");

		clickOnWebElement(btnClamAccount);

		log.info("Ending of clickOnDashboardMenu method");
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnLogoutButton method");

		clickOnWebElement(btnGoBack);

		log.info("Ending of clickOnLogoutButton method");
	}
}
