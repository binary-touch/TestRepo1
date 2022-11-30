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

	@B2BFindBy(xpath = "//a[contains(@class,'mt-4') and text()='Search Players']")
	private WebElement lblSearchPlayers;

	@B2BFindBy(xpath = "//a[contains(@class, 'md:block') and text()='Log In']")
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

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-148fdm8']")
	private WebElement iconProfile;

	@B2BFindBy(xpath = "//div[text()='Logout']")
	private WebElement btnLogout;

	// Negative login scenarios xpaths

	@B2BFindBy(xpath = "//p[text()='Email is invalid.']")
	private WebElement txtEmailInvalid;

	@B2BFindBy(xpath = "//p[text()='Password must be at least 6 characters.']")
	private WebElement txtPasswordLengthValidationMessage;

	@B2BFindBy(xpath = "//p[text()='Email is required.']")
	private WebElement txtEmailRequiredMessage;

	@B2BFindBy(xpath = "//p[text()='Password is required.']")
	private WebElement txtPasswordRequiredMessege;

	@B2BFindBy(xpath = "//p[text()='Whitespace is not allowed.']")
	private WebElement txtPasswordWhitespacesNotAllowedMessage;

	@B2BFindBy(xpath = "//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-contained MuiFormHelperText-filled css-tcj1fs']")
	private WebElement txtPasswordInvalid;
	
	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div/following-sibling::div//p")
	private WebElement txtPasswordMustNotExceedMaxCharacters;


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

		this.txtBoxEmail.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		this.txtBoxEmail.sendKeys(strEmail);

		log.info("Ending of setEmail method");
	}

	public void setPassword(String strPassword) {
		log.info("Starting of setPassword method");

		this.txtBoxPassword.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		this.txtBoxPassword.sendKeys(strPassword);

		log.info("Ending of setPassword method");
	}

	public void clickOnSignInButton() {
		log.info("Starting of clickOnSignInButton method");

		this.clickOnWebElement(btnSignIn);

		log.info("Ending of clickOnSignInButton method");
	}

	public void loginToDUPRApplication(String userName, String password) {
		log.info("Starting of loginToDUPRApplication method");

		this.setEmail(userName);
		this.setPassword(password);
		
		this.clickOnSignInButton();

		log.info("Ending of loginToDUPRApplication method");
	}

	public String getAddAMatchValidationText() {
		log.info("Starting of getAddAMatchValidationText method");
		log.info("Ending of getAddAMatchValidationText method");

		return getText(lblAddaMatch);
	}

	// Negative login methods

	public String getInvalidEmailText() {
		log.info("Starting of getInvalidEmailText");
		log.info("Ending of getInvalidEmailText");

		return getText(txtEmailInvalid);
	}

	public String getPasswordErrorMessageText() {
		log.info("Starting of getPasswordErrorMessageText");
		this.impicitWait();
		log.info("Ending of getPasswordErrorMessageText");

		return getText(txtPasswordLengthValidationMessage);
	}

	public String getEmailRequiredText() {
		log.info("Starting of getEmailRequiredText method");
		this.impicitWait();
		log.info("Ending of getEmailRequiredText method");

		return getText(txtEmailRequiredMessage);
	}

	public String getPasswordRequiredText() {
		log.info("Starting of getPasswordRequiredText method");

		this.impicitWait();

		log.info("Ending of getPasswordRequiredText method");

		return getText(txtPasswordRequiredMessege);
	}

	public String getWhiteSpacesNotAllowedValidationText() {
		log.info("Starting of getWhiteSpacesNotAllowedValidationText method");
		this.impicitWait();
		log.info("Ending of getWhiteSpacesNotAllowedValidationText method");

		return getText(txtPasswordWhitespacesNotAllowedMessage);
	}

	public String getInvalidPasswordValidationText() {
		log.info("starting of getInvalidPasswordValidationText method");
		this.impicitWait();
		log.info("Ending of getInvalidPasswordValidationText method");

		return getText(txtPasswordInvalid);
	}

	public void clickOnProfileIcon() {
		log.info("Starting of clickOnProfileIcon method");
		
		clickOnElement(iconProfile);

		log.info("Ending of clickOnProfileIcon method");
	}

	public void clickOnLogoutButton() {
		log.info("Starting of clickOnLogoutButton method");

		try {
			this.clickOnWebElement(btnLogout);
		}
		catch(Exception e) {
			this.clickOnElement(btnLogout);
		}

		log.info("Ending of clickOnLogoutButton method");
	}
	
	public String getPasswordMustNotExceedMaxCharactersValidationText() {		
		log.info("Starting of getPasswordMustNotExceedMaxCharactersText method");
		log.info("Ending of getPasswordMustNotExceedMaxCharactersText method");
		
		return getText(txtPasswordMustNotExceedMaxCharacters);
		
	}
}
