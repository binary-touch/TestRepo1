package com.dupr.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;

public class ForgotPasswordPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(ForgotPasswordPage.class);

	@B2BFindBy(xpath = "(//a[text()='Search Players'])[1]")
	private WebElement lblSearchPlayers;

	@B2BFindBy(xpath = "(//a[text()='Log In'])[2]")
	private WebElement lnkLogIn;

	@B2BFindBy(xpath = "//h1[text()='Welcome Back']")
	private WebElement lblWelcomeBack;

	@B2BFindBy(xpath = "//button[text()='Forgot Password?']")
	private WebElement btnForgotPassword;

	@B2BFindBy(xpath = "//h1[contains(@class,'MuiTypography-h1') and text()='Forgot Password?']")
	private WebElement lblForgotPassword;

	@B2BFindBy(xpath = "//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement txtBoxEmail;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-root') and text()='Send Email']")
	private WebElement btnSendEmail;

	@B2BFindBy(xpath = "//h1[text()='Create a New Password']")
	private WebElement lblCreateANewPassword;

	@B2BFindBy(xpath = "//h4[text()='Verification code (OTP)*']/parent::div//input[@aria-label='Please enter verification code. Digit 1']")
	private WebElement txtBoxOTPOne;

	@B2BFindBy(xpath = "//h4[text()='Verification code (OTP)*']/parent::div//input[@aria-label='Digit 2']")
	private WebElement txtBoxOTPTwo;

	@B2BFindBy(xpath = "//h4[text()='Verification code (OTP)*']/parent::div//input[@aria-label='Digit 3']")
	private WebElement txtBoxOTPThree;

	@B2BFindBy(xpath = "//h4[text()='Verification code (OTP)*']/parent::div//input[@aria-label='Digit 4']")
	private WebElement txtBoxOTPFour;

	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div/following-sibling::div[1]/*/following-sibling::div//input")
	private WebElement txtBoxPassword;

	@B2BFindBy(xpath = "//h5[text()='Confirm Password']/parent::div/following-sibling::div//input")
	private WebElement txtBoxConfirmPassword;

	// @B2BFindBy(xpath = "//button[contains(@class ,'MuiButton-contained') and
	// text()='Confirm Password']")
	@B2BFindBy(xpath = "//button[text()='Reset Password']")
	private WebElement btnResetPassword;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-sizeMedium') and text()='OK']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//p[text()='Email is invalid.']")
	private WebElement txtValidationEmailInvalid;

	@B2BFindBy(xpath = "//p[text()='Invalid email address']")
	private WebElement txtInvalidEmailAddress;

	@B2BFindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root Mui-error')]")
	private WebElement txtValidationAccountDoesnotExist;

	@B2BFindBy(xpath = "//p[text()='Email is required.']")
	private WebElement txtValidationEmailRequired;

	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div/following-sibling::div/child::div/following-sibling::div/descendant::p")
	private WebElement txtValidationPassword;

	@B2BFindBy(xpath = "//h5[text()='Confirm Password']/parent::div/following-sibling::div//p")
	private WebElement txtValidationConfirmPassword;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-whitecontained') and text()='Resend Code']")
	private WebElement btnResendCode;

	@B2BFindBy(xpath = "//p[text()='OTP sent on your email address']")
	private WebElement txtValidationOTPSent;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public String getSearchPlayersText() {
		log.info("Starting of getSearchPlayersText method");
		log.info("Ending of getSearchPlayersText method");

		return getText(lblSearchPlayers);
	}

	public void clickOnLogInLink() {
		log.info("Starting of clickOnLogInLink method");

		this.lnkLogIn.click();

		log.info("Ending of clickOnLogInLink method");
	}

	public String getWelcomeBackText() {
		log.info("Starting of getWelcomeBackText method");
		log.info("Ending of getWelcomeBackText method");

		return getText(lblWelcomeBack);
	}

	public void clickOnForgotPasswordButton() {
		log.info("Starting of clickOnForgotPasswordButton method");

		this.btnForgotPassword.click();

		log.info("Ending of clickOnForgotPasswordButton method");
	}

	public String getForgotPasswordText() {
		log.info("Starting of getForgotPasswordText method");
		log.info("Ending of getForgotPasswordText method");

		return getText(lblForgotPassword);
	}

	public void setEmail(String strEmail) {
		log.info("Starting of setEmail method");

		this.implicitWait();
		txtBoxEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxEmail.click();
		this.txtBoxEmail.sendKeys(strEmail);

		log.info("Ending of setEmail method");
	}

	public void clickOnSendEmailButton() {
		log.info("Starting of clickOnSendEmailButton method");

		this.clickOnWebElement(btnSendEmail);

		log.info("Ending of clickOnSendEmailButton method");
	}

	public String getCreateANewPasswordText() {
		log.info("Starting of getCreateANewPasswordText method");
		log.info("Ending of getCreateANewPasswordText method");

		return getText(lblCreateANewPassword);
	}

	public void setOTP(String strOTP1, String strOTP2, String strOTP3, String strOTP4) {
		log.info("Starting of setOTP method");

		this.implicitWait();
		sendKeys(txtBoxOTPOne, strOTP1);
		this.txtBoxOTPTwo.sendKeys(strOTP2);
		this.txtBoxOTPThree.sendKeys(strOTP3);
		this.txtBoxOTPFour.sendKeys(strOTP4);

		log.info("Ending of setOTP method");
	}

	public void setPassword(String strPassword) {
		log.info("Starting of setPassword method");

		this.implicitWait();
		this.txtBoxPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxPassword.sendKeys(strPassword);

		log.info("Ending of setPassword method");
	}

	public void setConfirmPassword(String strConfirmPassword) {
		log.info("Starting of setConfirmPassword method");

		this.implicitWait();
		this.txtBoxConfirmPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxConfirmPassword.sendKeys(strConfirmPassword);

		log.info("Ending of setConfirmPassword method");
	}

	public void clickOnResetPasswordButton() {
		log.info("Starting of clickOnResetPasswordButton method");

		this.implicitWait();
		this.btnResetPassword.click();

		log.info("Ending of clickOnResetPasswordButton method");
	}

	public String getSuccessLabel() {
		log.info("Starting of getSuccessLabel method");
		log.info("Ending of getSuccessLabel method");

		return getText(lblSuccess);
	}

	public boolean isOkButtonDisplayed() {
		log.info("Starting of isOkButtonDisplayed method");
		log.info("Ending of isOkButtonDisplayed method");

		return isDisplayed(btnOk);
	}

	public String getEmailValidationText() {
		log.info("Starting of getEmailValidationText method");
		explicitWait(txtInvalidEmailAddress);
		log.info("Ending of getEmailValidationText method");

		return getText(txtInvalidEmailAddress);
	}

	public String getAccountDoesnotExistValidationText() {
		log.info("Starting of getAccountDoesnotExistValidationText method");
		log.info("Ending of getAccountDoesnotExistValidationText method");

		return getText(txtValidationAccountDoesnotExist);
	}

	public String getEmailRequiredValidationText() {
		log.info("Starting of getEmailRequiredValidationText method");
		log.info("Ending of getEmailRequiredValidationText method");

		return getText(txtValidationEmailRequired);
	}

	public String getPasswordValidationText() {
		log.info("Starting of getPasswordValidationText method");
		log.info("Ending of getPasswordValidationText method");

		return getText(txtValidationPassword);
	}

	public String getConfirmPasswordValidationText() {
		log.info("Starting of getConfirmPasswordValidationText method");
		log.info("Ending of getConfirmPasswordValidationText method");

		return getText(txtValidationConfirmPassword);
	}

	public void setPasswordWithWhiteSpaces(String value) {
		log.info("Starting of setPasswordWithWhiteSpaces method");

		this.implicitWait();
		this.txtBoxPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		int i = Integer.parseInt(value);
		if (i >= 6) {
			for (int j = 1; j <= i; j++) {
				txtBoxPassword.sendKeys(Keys.SPACE);
			}

		}

		log.info("Ending of setPasswordWithWhiteSpaces method");
	}

	public void setConfirmPasswordWithWhiteSpaces(String value) {
		log.info("Starting of setConfirmPasswordWithWhiteSpaces method");

		this.implicitWait();
		this.txtBoxConfirmPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		int i = Integer.parseInt(value);
		if (i >= 6) {
			for (int j = 1; j <= i; j++) {
				txtBoxConfirmPassword.sendKeys(Keys.SPACE);
			}
		}

		log.info("Ending of setConfirmPasswordWithWhiteSpaces method");
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		clickOnElement(btnOk);

		log.info("Ending of clickOnOkButton method");
	}

	public void clickOnResendCodeButton() {
		log.info("Starting of clickOnResendCodeButton method");

		clickOnElement(btnResendCode);

		log.info("Ending of clickOnResendCodeButton method");
	}

	public String getOTPSentValidationText() {
		log.info("Starting of getOTPSentValidationText method");
		log.info("Ending of getOTPSentValidationText method");

		return getText(txtValidationOTPSent);
	}
}
