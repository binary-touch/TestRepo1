package com.dupr.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;

public class DUPRLoginPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(DUPRLoginPage.class);

	@B2BFindBy(xpath = "(//a[text()='Search Players'])[1]")
	private WebElement lblSearchPlayers;

	@B2BFindBy(xpath = "(//a[text()='Log In'])[2]")
	private WebElement lnkLogIn;

	@B2BFindBy(xpath = "//h1[text()='Welcome Back']")
	private WebElement lblWelcomeBack;

	@B2BFindBy(xpath = "//h5[text()='Email']/parent::div/following-sibling::div//input")
	private WebElement txtBoxEmail;

	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div/following-sibling::div//input")
	private WebElement txtBoxPassword;

	@B2BFindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignIn;

	@B2BFindBy(xpath = "//h6[text()='Add a Match']")
	private WebElement lblAddaMatch;

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement mnuOpenSettings;

	@B2BFindBy(xpath = "//div[text()='Logout']")
	private WebElement btnLogout;

	// Negative login scenarios xpaths

	@B2BFindBy(xpath = "//h5[text()='Email']/../following-sibling::div//p")
	private WebElement txtEmailValidation;

	@B2BFindBy(xpath = "//p[text()='Invalid email address']")
	private WebElement txtInvalidEmail;

	@B2BFindBy(xpath = "//h5[text()='Password']/../following-sibling::div//p")
	private WebElement txtPasswordValidation;

	@B2BFindBy(xpath = "//p[contains(text(),'Oops! Something went wrong, try again later.')]")
	private WebElement txtLoginFailed;

	public DUPRLoginPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public String getSearchPlayersValidationText() {
		log.info("Starting of getSearchPlayersValidationText method");
		log.info("Ending of getSearchPlayersValidationText method");

		return getText(lblSearchPlayers);
	}

	public void clickOnLogInLink() {
		log.info("Starting of clickOnLogInLink method");

		explicitWait(lnkLogIn);
		this.lnkLogIn.click();

		log.info("Ending of clickOnLogInLink method");
	}

	public String getWelcomeBackValidationText() {
		log.info("Starting of getWelcomeBackValidationText method");
		log.info("Ending of getWelcomeBackValidationText method");

		return getText(lblWelcomeBack);
	}

	public void setEmail(String strEmail) {
		log.info("Starting of setEmail method");

		this.txtBoxEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxEmail.sendKeys(strEmail);

		log.info("Ending of setEmail method");
	}

	public void setPassword(String strPassword) {
		log.info("Starting of setPassword method");

		this.txtBoxPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxPassword.sendKeys(strPassword);

		log.info("Ending of setPassword method");
	}

	public void clickOnSignInButton() {
		log.info("Starting of clickOnSignInButton method");

		try {
			waitForElementToBeVisible(btnSignIn);
			this.clickOnWebElement(btnSignIn);
		} catch (Exception e) {
			waitForElementToBeVisible(btnSignIn);
			clickUsingActionsClass(btnSignIn);
		}

		log.info("Ending of clickOnSignInButton method");
	}

	public void loginToDUPRApplication(String userName, String password) {
		log.info("Starting of loginToDUPRApplication method");

		this.setEmail(userName);
		this.setPassword(password);

		this.hardWait(5);
		this.clickOnSignInButton();
		this.hardWait(10);
		log.info("Ending of loginToDUPRApplication method");
	}

	public String getAddAMatchValidationText() {
		log.info("Starting of getAddAMatchValidationText method");
		log.info("Ending of getAddAMatchValidationText method");

		return getText(lblAddaMatch);
	}

	// Negative login methods

	public String getInvalidEmailText() {
		log.info("Starting of getInvalidEmailText method");
		log.info("Ending of getInvalidEmailText method");

		return getText(txtEmailValidation);
	}

	public String getInvalidEmailValidationText() {
		log.info("Starting of getInvalidEmailValidationText method");
		log.info("Ending of getInvalidEmailValidationText method");

		return getText(txtInvalidEmail);
	}

	public String getPasswordErrorMessageText() {
		log.info("Starting of getPasswordErrorMessageText method");
		this.implicitWait();
		log.info("Ending of getPasswordErrorMessageText method");

		return getText(txtPasswordValidation);
	}

	public String getEmailRequiredText() {
		log.info("Starting of getEmailRequiredText method");
		this.implicitWait();
		log.info("Ending of getEmailRequiredText method");

		return getText(txtEmailValidation);
	}

	public String getPasswordRequiredText() {
		log.info("Starting of getPasswordRequiredText method");
		this.implicitWait();
		log.info("Ending of getPasswordRequiredText method");

		return getText(txtPasswordValidation);
	}

	public String getWhiteSpacesNotAllowedValidationText() {
		log.info("Starting of getWhiteSpacesNotAllowedValidationText method");
		this.implicitWait();
		log.info("Ending of getWhiteSpacesNotAllowedValidationText method");

		return getText(txtPasswordValidation);
	}

	public String getInvalidPasswordValidationText() {
		log.info("starting of getInvalidPasswordValidationText method");
		this.implicitWait();
		log.info("Ending of getInvalidPasswordValidationText method");

		return getText(txtPasswordValidation);
	}

	public void clickOnOpenSettingsMenu() {
		log.info("Starting of clickOnOpenSettingsMenu method");

		clickOnWebElement(mnuOpenSettings);

		log.info("Ending of clickOnOpenSettingsMenu method");
	}

	public void clickOnLogoutButton() {
		log.info("Starting of clickOnLogoutButton method");

		elementClick(btnLogout);

		log.info("Ending of clickOnLogoutButton method");
	}

	public String getPasswordMustNotExceedMaxCharactersValidationText() {
		log.info("Starting of getPasswordMustNotExceedMaxCharactersValidationText method");
		log.info("Ending of getPasswordMustNotExceedMaxCharactersValidationText method");

		return getText(txtPasswordValidation);
	}

	public boolean isLoginFailedValidationText() {
		log.info("Starting of isLoginFailedValidationText method");
		log.info("Ending of isLoginFailedValidationText method");

		return isDisplayed(txtLoginFailed);
	}
}
