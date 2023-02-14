package com.dupr.test.signup;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.DUPRLoginPage;
import com.dupr.pages.profile.EditProfilePage;
import com.dupr.pages.signup.DUPRSignUpPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("SignUp with create an account")
public class SignupTest extends DUPRBaseAutomationTest {

	private DUPRSignUpPage signupPage = null;
	private EditProfilePage editProfilePage = null;
	private String emailid = null;

	private static final Logger logger = Logger.getLogger(SignupTest.class.getName());

	@BeforeClass
	@Parameters({ "browser" })
	public void initMethod(String browser) throws Exception {
		logger.info("Starting of initMethod method in SignupTest");

		this.driver = super.getWebDriver(WebDriversEnum.SIGNUP_DRIVER);
		goToSite(driver);

		this.signupPage = new DUPRSignUpPage(this.driver);
		this.editProfilePage = new EditProfilePage(this.driver);
		this.loginPage = new DUPRLoginPage(driver);

		logger.info("Ending of initMethod method in SignupTest");
	}

	@Test(priority = 1, description = "Verify Sign up funtionality with invalid location ", groups = "sanity")
	@Description("Test case #1, Verify Sign up funtionality with invalid location")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #1, Verify Sign up funtionality with invalid location")
	public void verifySignUpFunctionalityWithInvalidLocation() {
		logger.info("Starting of verifySignUpFunctionalityWithInvalidLocation method");

		signupPage.clickOnSignUpButton();

		String claimYourAccountText = this.signupPage.getClaimYourAccountText();
		Assert.assertEquals(claimYourAccountText, expectedAssertionsProp.getProperty("claim.account.label"));

		Assert.assertTrue(signupPage.isCreateAccountButtonDisplayed());
		Assert.assertTrue(signupPage.isGoBackButtonDisplayed());

		signupPage.clickOnCreateAccountButton();

		String playerDetailsText = signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setFullName(testDataProp.getProperty("full.name"));
		signupPage.setBirthDate(testDataProp.getProperty("date.of.birth"));
		signupPage.setMobileNumber(testDataProp.getProperty("invalid.mobile.number"));
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();signupPage.hardWait(3);
		signupPage.setInvalidLocation(testDataProp.getProperty("location"));
		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();
		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.clickOnFinishButton();signupPage.hardWait(2);

		String streetAddressText = this.signupPage.getStreetAddressText();
		Assert.assertEquals(streetAddressText, expectedAssertionsProp.getProperty("invalid.parameters"));

		signupPage.clickOnOKButton();

		logger.info("Ending of verifySignUpFunctionalityWithInvalidLocation method");
	}

	@Test(priority = 2, description = "Verify Full name functionality with numbers", groups = "sanity")
	@Description("Test case #2, Verify Full name functionality with numbers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #2, Verify Full name functionality with numbers")
	public void verifyFullNameWithNumbers() {
		logger.info("Starting of verifyFullNameWithNumbers method");

		driver.navigate().refresh();
		signupPage.setFullName(testDataProp.getProperty("full.name.with.numbers"));

		String FullnameIncorrectText = this.signupPage.getFullNameValidationText();
		Assert.assertEquals(FullnameIncorrectText, expectedAssertionsProp.getProperty("fullname.number.validation"));

		logger.info("Starting of verifyFullNameWithNumbers method");
	}

	@Test(priority = 3, description = "Verify email filed with inavalid email", groups = "sanity")
	@Description("Test case #3, Verify email filed with inavalid email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #3, Verify email filed with inavalid email")
	public void verifyEmailWithInvalidEmail() {
		logger.info("Starting of verifyEmailWithInvalidEmail method");

		driver.navigate().refresh();
		signupPage.setInvalidEmail(testDataProp.getProperty("invalid.email.in.signup"));

		String FullnameIncorrectText = loginPage.getInvalidEmailText();
		Assert.assertEquals(FullnameIncorrectText, expectedAssertionsProp.getProperty("invalid.email"));

		logger.info("Starting of verifyEmailWithInvalidEmail method");
	}

	@Test(priority = 4, description = "Verify Sign up functionality with out filling any mandatory fields", groups = "sanity")
	@Description("Test case #4, Verify Sign up functionality with out filling any mandatory fields")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #4,Verify Sign up functionality with out filling any mandatory fields")
	public void verifySignWithFillingMandatoryFields() {
		logger.info("Starting of verifySignWithFillingMandatoryFields method");

		driver.navigate().refresh();

		signupPage.setMobileNumber(testDataProp.getProperty("mobile.number"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		logger.info("Starting of verifySignWithFillingMandatoryFields method");
	}

	@Test(priority = 5, description = "Verify Sign up funtionality with invalid birth date ", groups = "sanity")
	@Description("Test case #5, Verify Sign up funtionality with invalid birth date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #5, Verify Sign up funtionality with invalid birth date")
	public void verifySignUpWithInvalidBirthDateFormat() {
		logger.info("Starting of verifySignUpWithInvalidBirthDateFormat method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setBirthDate(testDataProp.getProperty("invalid.data.of.birth"));

		String birthDateValidationMessage = this.signupPage.getBirthDateValidationMessage();
		Assert.assertEquals(birthDateValidationMessage,
				expectedAssertionsProp.getProperty("incorrect.date.format.validation"));

		logger.info("Ending of verifySignUpWithInvalidBirthDateFormat method");
	}

	@Test(priority = 6, description = "Verify birth date funtionality with current date ", groups = "sanity")
	@Description("Test case #6, Verify birth date funtionality with current date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #6, Verify birth date funtionality with current date")
	public void verifyBirthdateWithCurrentDate() {
		logger.info("Starting of verifyBirthdateWithCurrentDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithCurrentYear();

		Assert.assertEquals(signupPage.getDateOfBirthValidationMessage(),
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthdateWithCurrentDate method");
	}

	@Test(priority = 7, description = "Verify birth date funtionality with previous year date", groups = "sanity")
	@Description("Test case #7,Verify birth date funtionality with previous year date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #7, Verify birth date funtionality with previous year date")
	public void verifyBirthdateWithPreviousYearDate() {
		logger.info("Starting of verifyBirthdateWithPreviousYearDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithPreviousYear();

		Assert.assertEquals(signupPage.getDateOfBirthValidationMessage(),
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthdateWithPreviousYearDate method");
	}

	@Test(priority = 8, description = "Verify birth date funtionality with before two years date ", groups = "sanity")
	@Description("Test case #8,Verify birth date funtionality with before two years date ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #8,Verify birth date funtionality with before two years date ")
	public void setDateOfBirthWithBeforeTwoYear() {
		logger.info("Starting of verifyBirthdateWithBeforeTwoYearDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithBeforeTwoYear();

		Assert.assertFalse(signupPage.isDateOfBirthValidationMessageDisplayed());

		logger.info("Ending of verifyBirthdateWithBeforeTwoYearDate method");
	}

	@Test(priority = 9, description = "Verify Sign up funtionality ", groups = "sanity")
	@Description("Test case #9, Verify Sign up funtionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #9, Verify Sign up funtionality")
	public void verifySignupFunctionality() {
		logger.info("Starting of verifySignupFunctionality method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setFullName(testDataProp.getProperty("full.name"));
		signupPage.setBirthDate(testDataProp.getProperty("date.of.birth"));
		signupPage.setMobileNumber(testDataProp.getProperty("mobile.number"));
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();signupPage.hardWait(3);
		signupPage.setLocation(testDataProp.getProperty("location"));
		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();
		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.clickOnFinishButton();
		signupPage.hardWait(2);

		Assert.assertEquals(signupPage.getSuccessLabel(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertEquals(signupPage.getWelcomeToDuprText(), expectedAssertionsProp.getProperty("welcome.to.dupr"));

		signupPage.clickOnOKButton();

		String verifyYourEmailIdLabel = this.signupPage.getVerifyYourEmailId();
		Assert.assertEquals(verifyYourEmailIdLabel, expectedAssertionsProp.getProperty("verify.your.email.id"));

		Assert.assertTrue(signupPage.isAlreadyVerifiedButtonDisplayed());

		Assert.assertTrue(signupPage.isResendLinkButtonDisplayed());

		logger.info("Ending of verifySignupFunctionality method");
	}

	@Test(priority = 10, description = "Verify Already verified button without verifying email account through link which was sent to respected email ", groups = "sanity")
	@Description("Test case #8,Verify Already verified button without verifying email account through link which was sent to respected email  ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #8, Verify resend link button without verifying email account through link which was sent to respected email ")
	public void verifyAlreadyVerifiedButtonWithoutVerifyingAccount() {
		logger.info("Starting of verifyAlreadyVerifiedButtonWithoutVerifyingAccount method");
		signupPage.clickOnAlreadyVerifiedButton();

		signupPage.hardWait(2);
		String verifyYourEmailValidation = signupPage.getVerifyYourEmailValidationText();
		Assert.assertEquals(verifyYourEmailValidation,
				expectedAssertionsProp.getProperty("verify.your.email.to.access"));

		logger.info("Ending of verifyAlreadyVerifiedButtonWithoutVerifyingAccount method");
	}

	@Test(priority = 11, description = "Verify Resend link  button functionality by clearing email in the text field", groups = "sanity")
	@Description("Test case #11, Verify Resend link  button functionality by clearing email in the text field")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #11, Verify Resend link  button functionality by clearing email in the text field ")
	public void verifyResendLinkButtonWithoutEmail() {
		logger.info("Starting of verifyResendLinkButtonWithoutEmail method");

		signupPage.clickOnEditButton();
		signupPage.hardWait(5);
		signupPage.clickOnEmailTextBox();

		signupPage.hardWait(3);

		Assert.assertTrue(signupPage.isResendButtonDisplayed());

		logger.info("Ending of verifyResendLinkButtonWithoutEmail method");
	}

	@Test(priority = 12, description = "Verify Resend link  button functionality with DUPR account already exists", groups = "sanity")
	@Description("Test case #12, Verify Resend link  button functionality with DUPR account already exists")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #12, Verify Resend link  button functionality with DUPR account already exists")
	public void verifyResendLinkWithExistedDUPRAccount() {
		logger.info("Starting of verifyResendLinkWithExistedDUPRAccount method");

		signupPage.setEmailTextBox(testDataProp.getProperty("existed.dupr.account.email"));
		signupPage.hardWait(3);
		signupPage.clickOnResendLinkButton();

		signupPage.hardWait(3);
		String duprAccountExistsValidation = signupPage.getAlreadyExistDuprAccountValidationText();
		Assert.assertEquals(duprAccountExistsValidation,
				expectedAssertionsProp.getProperty("dupr.account.already.exists"));

		logger.info("Ending of verifyResendLinkWithExistedDUPRAccount method");
	}

	@Test(priority = 13, description = "Verify email field with numbers", groups = "sanity")
	@Description("Test case #13, Verify email field with numbers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #13, Verify email field with numbers")
	public void verifyEmailFieldWithNumbers() {
		logger.info("Starting of verifyEmailFieldWithNumbers method");

		signupPage.setEmailTextBox(testDataProp.getProperty("full.name.with.numbers"));
		signupPage.hardWait(3);
		signupPage.clickOnResendLinkButton();

		signupPage.hardWait(3);
		String duprAccountExistsValidation = signupPage.getInvalidEmailValidationText();
		Assert.assertEquals(duprAccountExistsValidation, expectedAssertionsProp.getProperty("invalid.email.address"));

		logger.info("Ending of verifyEmailFieldWithNumbers method");
	}

	@Test(priority = 14, description = "Verify Resend link  button functionality for the user email who doesn't exist DUPR account", groups = "sanity")
	@Description("Test case #14, Verify Resend link  button functionality with DUPR account already exists")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #14, Verify Resend link  button functionality with DUPR account already exists")
	public void verifyResendLinkWithEmailNotExistedDUPRAccount() {
		logger.info("Starting of verifyResendLinkWithEmailNotExistedDUPRAccount method");
		emailid = testDataProp.getProperty("email") + signupPage.randomNumber(4) + "@gmail.com";

		signupPage.setEmailTextBox(emailid);
		signupPage.hardWait(3);
		signupPage.clickOnResendLinkButton();

		signupPage.hardWait(3);
		String linkSentEmailValidation = signupPage.getlinkSentEmailValidation();
		Assert.assertEquals(linkSentEmailValidation, expectedAssertionsProp.getProperty("link.was.sent.mail"));

		signupPage.clickOnLogoutButton();

		logger.info("Ending of verifyResendLinkWithEmailNotExistedDUPRAccount method");
	}

	@Test(priority = 15, description = "Verify Email address in edit profile page", groups = "sanity")
	@Description("Test case #15, Verify Email address in edit profile page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #15, Verify Email address in edit profile page")
	public void verifyEmailAddress() {
		logger.info("Starting of verifyEmailAddress method");

		loginPage.loginToDUPRApplication(emailid, testDataProp.getProperty("password"));

		signupPage.hardWait(2);
		Assert.assertEquals(signupPage.getEmailText(), emailid);

		signupPage.clickOnCloseIcon();

		editProfilePage.clickOnOpenSettingMenu();

		editProfilePage.clickOnEditProfileButton();

		signupPage.clickOnVerifyButton();signupPage.hardWait(3);

		Assert.assertEquals(signupPage.getlinkSentEmailValidation(),
				expectedAssertionsProp.getProperty("link.was.sent.mail"));

		logger.info("Ending of verifyEmailAddress method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SIGNUP_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
