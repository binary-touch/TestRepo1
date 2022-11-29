package com.dupr.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.ForgotPasswordPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Forgot Password")
public class ForgotPasswordTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ForgotPasswordTest.class.getName());

	private ForgotPasswordPage forgotPasswordPage = null;
	private WebDriver driver = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL" })
	public void initMethod(String browser, String siteURL) throws Exception {
		logger.info("Starting of initMethod in ForgotPasswordTest");

		this.driver = super.getWebDriver(WebDriversEnum.FORGOT_PASSWORD_DRIVER);
		goToSite(driver);
		this.forgotPasswordPage = new ForgotPasswordPage(this.driver);

		logger.info("Ending of initMethod in ForgotPasswordTest");
	}

	@Test(priority = 1, description = "Verify login link functionality")
	@Description("Test case #1,Verify login link functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1,Verify login link functionality ")
	public void verifyLogInLinkFunctionality() {
		logger.info("Starting of verifyLogInLinkFunctionality method");

		String searchPlayersValidationText = this.forgotPasswordPage.getSearchPlayersText();
		Assert.assertEquals(searchPlayersValidationText, expectedAssertionsProp.getProperty("search.players.text"));

		forgotPasswordPage.clickOnLogInLink();

		String welcomeBackValidationText = this.forgotPasswordPage.getWelcomeBackText();
		Assert.assertEquals(welcomeBackValidationText, expectedAssertionsProp.getProperty("welcome.back.label"));

		logger.info("Ending of verifyLogInLinkFunctionality method");
	}

	@Test(priority = 2, description = "Verify forgot password link functionality")
	@Description("Test case #2,Verify forgot password link functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2,Verify forgot password link functionality ")
	public void verifyForgotPasswordLinkFunctionality() {
		logger.info("Starting of verifyForgotPasswordLinkFunctionality method");

		forgotPasswordPage.clickOnForgotPasswordButton();

		String forgotPasswordValidationText = this.forgotPasswordPage.getForgotPasswordText();
		Assert.assertEquals(forgotPasswordValidationText, expectedAssertionsProp.getProperty("forgot.password"));

		logger.info("Ending of verifyForgotPasswordLinkFunctionality method");
	}

	@Test(priority = 3, description = "Verify send Email functionality")
	@Description("Test case #3,Verify Send Email functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #3,Verify Send Email functionality ")
	public void verifySendEmail() {
		logger.info("Starting of verifySendEmail method");

		forgotPasswordPage.setEmail(testDataProp.getProperty("valid.email"));
		forgotPasswordPage.clickOnSendEmailButton();

		String createANewPasswordValidationText = this.forgotPasswordPage.getCreateANewPasswordText();
		Assert.assertEquals(createANewPasswordValidationText,
				expectedAssertionsProp.getProperty("create.a.new.password"));

		logger.info("Ending of verifySendEmail method");
	}

	@Test(priority = 4, description = "Verify Resend passcode functionality")
	@Description("Test case #4,Verify Resend passcode functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #4,Verify Resend passcode functionality ")
	public void verifyResendCode() {
		logger.info("Ending of verifyResendCode method");

		forgotPasswordPage.clickOnResendCodeButton();
		
		String otpSentValidationText = this.forgotPasswordPage.getOTPSentValidationText();
		Assert.assertEquals(otpSentValidationText,
				expectedAssertionsProp.getProperty("otp.sent.on.your.email.address"));

		logger.info("Ending of verifyResendCode method");
	}

	@Test(priority = 5, description = "Verify Confirm Password functionality")
	@Description("Test case #5,Verify Confirm Password functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #5,Verify Confirm Password functionality ")
	public void verifyConfirmPassword() {
		logger.info("Ending of verifyConfirmPassword method");

		String textOne = testDataProp.getProperty("otp.text.one");
		String textTwo = testDataProp.getProperty("otp.text.two");
		String textThree = testDataProp.getProperty("otp.text.three");
		String textFour = testDataProp.getProperty("otp.text.four");

		forgotPasswordPage.setOTP(textOne, textTwo, textThree, textFour);

		forgotPasswordPage.setPassword(testDataProp.getProperty("password"));

		forgotPasswordPage.setConfirmPassword(testDataProp.getProperty("password"));

		forgotPasswordPage.clickOnConfirmPasswordButton();

		String successValidationText = this.forgotPasswordPage.getSuccessLabel();
		Assert.assertEquals(successValidationText, expectedAssertionsProp.getProperty("success"));

		Assert.assertTrue(forgotPasswordPage.isOkButtonDisplayed());
		forgotPasswordPage.clickOnOkButton();

		logger.info("Ending of verifyConfirmPassword method");
	}

	@Test(priority = 6, description = "Verify Send Email functionality with invalid email id ")
	@Description("Test case #6,Verify Send Email functionality with invalid email id")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6,Verify Send Email functionality with invalid email id")
	public void verifySendEmailWithInvalidEmailID() {
		logger.info("Starting of verifySendEmailWithInvalidEmailID method");
		
		driver.navigate().refresh();

		String welcomeBackValidationText = this.forgotPasswordPage.getWelcomeBackText();
		Assert.assertEquals(welcomeBackValidationText, expectedAssertionsProp.getProperty("welcome.back.label"));

		this.verifyForgotPasswordLinkFunctionality();

		forgotPasswordPage.setEmail(testDataProp.getProperty("invalid.email"));

		forgotPasswordPage.clickOnSendEmailButton();

		String emailValidationText = this.forgotPasswordPage.getEmailValidationText();
		Assert.assertEquals(emailValidationText, expectedAssertionsProp.getProperty("invalid.email.text"));

		logger.info("Ending of verifySendEmailWithInvalidEmailID method");
	}

	@Test(priority = 7, description = "Verify Send Email functionality with empty email id ")
	@Description("Test case #7 ,Verify Send Email functionality with empty email id")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7 ,Verify Send Email functionality with empty email id")
	public void verifySendEmailWithEmptyPassword() {
		logger.info("Starting of verifySendEmailWithEmptyPassword method");

		driver.navigate().refresh();
		
		forgotPasswordPage.clickOnSendEmailButton();

		String emailRequiredValidationText = this.forgotPasswordPage.getEmailrequiredValidationText();
		Assert.assertEquals(emailRequiredValidationText,
				expectedAssertionsProp.getProperty("email.required.validation"));

		logger.info("Ending of verifySendEmailWithEmptyPassword method");
	}

	@Test(priority = 8, description = "Verify Send Email functionality with email which is not registered in dupr application ")
	@Description("Test case #8 ,Verify Send Email functionality with email which is not registered in dupr application")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8 ,Verify Send Email functionality with email which is not registered in dupr application")
	public void verifySendEmailWithNotRegisteredEmailDupr() {

		logger.info("Starting of verifySendEmailWithNotRegisteredEmailDupr method");
		
		forgotPasswordPage.setEmail(testDataProp.getProperty("not.registered.email"));
		forgotPasswordPage.clickOnSendEmailButton();
		forgotPasswordPage.hardWait(3);

		String emailValidationText = this.forgotPasswordPage.getEmailValidationText();
		Assert.assertEquals(emailValidationText, expectedAssertionsProp.getProperty("account.not.existed"));

		logger.info("Ending of verifySendEmailWithNotRegisteredEmailDupr method");
	}

	@Test(priority = 9, description = "Verify confirm password functionality with empty fields ")
	@Description("Test case #9, Verify confirm password functionality with empty fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify confirm password functionality with empty fields")
	public void verifyConfirmPasswordWithEmptyFields() {

		logger.info("Starting of verifyConfirmPasswordWithEmptyFields method");

		forgotPasswordPage.setEmail(testDataProp.getProperty("valid.email"));
		forgotPasswordPage.clickOnSendEmailButton();

		String createANewPasswordValidationText = this.forgotPasswordPage.getCreateANewPasswordText();
		Assert.assertEquals(createANewPasswordValidationText,
				expectedAssertionsProp.getProperty("create.a.new.password"));

		forgotPasswordPage.clickOnConfirmPasswordButton();

		String passwordValidationText = this.forgotPasswordPage.getPasswordValidationText();
		Assert.assertEquals(passwordValidationText, expectedAssertionsProp.getProperty("password.required.validation"));

		logger.info("Ending of verifyConfirmPasswordWithEmptyFields method");
	}

	@Test(priority = 10, description = "Verify password and confirm password fields without entering minimum characters ")
	@Description("Test case #10, Verify password and confirm password fields without entering minimum characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify password and confirm password fields without entering minimum characters")
	public void verifyConfirmPasswordWithoutMinimumCharacters() {
		logger.info("Starting of verifyConfirmPasswordWithoutMinimumCharacters method");

		forgotPasswordPage.setPassword(testDataProp.getProperty("password.lessthan.minimum.char"));
		forgotPasswordPage.setConfirmPassword(testDataProp.getProperty("confirmpassword.lessthan.minimum.char"));
		forgotPasswordPage.clickOnConfirmPasswordButton();

		String passwordValidationMessage = this.forgotPasswordPage.getPasswordValidationText();
		Assert.assertEquals(passwordValidationMessage,
				expectedAssertionsProp.getProperty("password.atleast.six.characters"));

		String confirmPasswordValidationMessage = this.forgotPasswordPage.getConfirmPasswordValidationText();
		Assert.assertEquals(confirmPasswordValidationMessage,
				expectedAssertionsProp.getProperty("please.enter.matching.password"));

		logger.info("Ending of verifyConfirmPasswordWithoutMinimumCharacters method");
	}

	@Test(priority = 11, description = "Verify password and confirm password fields with out numbers ")
	@Description("Test case #11, Verify password and confirm password fields with out numbers ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify password and confirm password fields with out numbers ")
	public void verifyConfirmPasswordWithoutNumbers() {
		logger.info("Starting of verifyConfirmPasswordWithoutNumbers method");

		String textOne = testDataProp.getProperty("otp.text.one");
		String textTwo = testDataProp.getProperty("otp.text.two");
		String textThree = testDataProp.getProperty("otp.text.three");
		String textFour = testDataProp.getProperty("otp.text.four");

		forgotPasswordPage.setOTP(textFour, textThree, textTwo, textOne);

		forgotPasswordPage.setPassword(testDataProp.getProperty("password.without.numbers"));
		forgotPasswordPage.setConfirmPassword(testDataProp.getProperty("confirmpassword.without.numbers"));
		forgotPasswordPage.clickOnConfirmPasswordButton();

		String passwordValidationMessage = this.forgotPasswordPage.getPasswordValidationText();
		Assert.assertEquals(passwordValidationMessage,
				expectedAssertionsProp.getProperty("password.instruction.validation.message"));

		logger.info("Ending of verifyConfirmPasswordWithoutNumbers method");
	}

	@Test(priority = 12, description = "Verify password and confirm password with unmatched data ")
	@Description("Test case #12, Verify password and confirm password with unmatched data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify password and confirm password with unmatched data")
	public void verifyConfirmPasswordWithUnmatchedPasswords() {
		logger.info("Starting of verifyConfirmPasswordWithUnmatchedPasswords method");

		forgotPasswordPage.setPassword(testDataProp.getProperty("password.unmatched"));
		forgotPasswordPage.setConfirmPassword(testDataProp.getProperty("confirmpassword.unmatched"));
		forgotPasswordPage.clickOnConfirmPasswordButton();

		String confirmPasswordValidationMessage = this.forgotPasswordPage.getConfirmPasswordValidationText();
		Assert.assertEquals(confirmPasswordValidationMessage,
				expectedAssertionsProp.getProperty("please.enter.matching.password"));

		logger.info("Ending of verifyConfirmPasswordWithUnmatchedPasswords method");
	}

	@Test(priority = 13, description = "Verify password and confirm password with white spaces ")
	@Description("Test case #13, Verify password and confirm password with white spaces")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify password and confirm password with white spaces")
	public void verifyConfirmPasswordWithWhiteSpaces() {
		logger.info("Starting of verifyConfirmPasswordWithWhiteSpaces method");

		forgotPasswordPage.setPasswordFieldWhiteSpaces(testDataProp.getProperty("spaces.value"));
		forgotPasswordPage.setConfirmPasswordFieldWhiteSpaces(testDataProp.getProperty("spaces.value"));
		forgotPasswordPage.clickOnConfirmPasswordButton();

		logger.info("Ending of verifyConfirmPasswordWithWhiteSpaces method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.FORGOT_PASSWORD_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
