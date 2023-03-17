package com.b2b.test.sprint1.sanity;

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
@Feature("SignUp Sanity")
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

	@Test(priority = 1, description = "Verify Sign up funtionality with invalid location details")
	@Description("Test case #1, Verify Sign up funtionality with invalid location details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #1, Verify Sign up funtionality with invalid location details")
	public void verifySignUpFunctionalityWithInvalidLocation() {
		logger.info("Starting of verifySignUpFunctionalityWithInvalidLocation method");

		signupPage.clickOnSignUpButton();

		String claimYourAccountText = this.signupPage.getClaimYourAccountText();
		Assert.assertEquals(claimYourAccountText, expectedAssertionsProp.getProperty("claim.account.label"));

		signupPage.clickOnCreateAccountButton();

		String playerDetailsText = signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setFullName(testDataProp.getProperty("full.name"));
		signupPage.setBirthDate();
		signupPage.setMobileNumber(testDataProp.getProperty("invalid.mobile.number"));
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();
		signupPage.hardWait(3);
		signupPage.setInvalidLocation(testDataProp.getProperty("location"));
		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();
		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		try {
			if (signupPage.isManageProfileCheckBoxDisplayed()==true) {
				logger.info("****Manage Profile checkbox displayed****");
				signupPage.clickOnManageProfileCheckBox();
			}
		} catch (Exception e) {
			logger.info("****Manage Profile checkbox haven't displayed****");
		}

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.hardWait(3);
		signupPage.clickOnFinishButton();
		signupPage.hardWait(2);

		String streetAddressText = this.signupPage.getStreetAddressText();
		Assert.assertEquals(streetAddressText, expectedAssertionsProp.getProperty("invalid.parameters"));

		signupPage.clickOnOKButton();

		logger.info("Ending of verifySignUpFunctionalityWithInvalidLocation method");
	}

	//@Test(priority = 2, description = "Verify Sign up functionality with invalid birth date format")
	@Description("Test case #2, Verify Sign up functionality with invalid birth date format")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Sign up functionality with invalid birth date format")
	public void verifySignUpWithInvalidBirthDateFormat() {
		logger.info("Starting of verifySignUpWithInvalidBirthDateFormat method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setBirthDate();
		signupPage.hardWait(3);

		String birthDateValidationMessage = this.signupPage.getBirthDateValidationMessage();
		Assert.assertEquals(birthDateValidationMessage,
				expectedAssertionsProp.getProperty("incorrect.date.format.validation"));

		logger.info("Ending of verifySignUpWithInvalidBirthDateFormat method");
	}

	//@Test(priority = 3, description = "Verify birth date functionality with current date")
	@Description("Test case #3, Verify birth date functionality with current date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify birth date functionality with current date")
	public void verifyBirthdateWithCurrentDate() {
		logger.info("Starting of verifyBirthdateWithCurrentDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithCurrentYear();
		signupPage.hardWait(3);

		Assert.assertEquals(signupPage.getDateOfBirthValidationMessage(),
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthdateWithCurrentDate method");
	}

	//@Test(priority = 4, description = "Verify birth date functionality with previous year date")
	@Description("Test case #4, Verify birth date functionality with previous year date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify birth date functionality with previous year date")
	public void verifyBirthdateWithPreviousYearDate() {
		logger.info("Starting of verifyBirthdateWithPreviousYearDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithPreviousYear();
		signupPage.hardWait(3);

		Assert.assertEquals(signupPage.getDateOfBirthValidationMessage(),
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthdateWithPreviousYearDate method");
	}

	@Test(priority = 5, description = "Verify birth date functionality with before two years date")
	@Description("Test case #5,Verify birth date functionality with before two years date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #5,Verify birth date functionality with before two years date")
	public void setDateOfBirthWithBeforeTwoYear() {
		logger.info("Starting of verifyBirthdateWithBeforeTwoYearDate method");

		driver.navigate().refresh();
		signupPage.setDateOfBirthWithBeforeTwoYears();

		Assert.assertFalse(signupPage.isBirthDateSelected());

		logger.info("Ending of verifyBirthdateWithBeforeTwoYearDate method");
	}

	@Test(priority = 6, description = "Verify Sign up funtionality with valid details")
	@Description("Test case #6, Verify Sign up funtionality with valid details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #6, Verify Sign up funtionality with valid details")
	public void verifySignupFunctionalityWithValidDetails() {
		logger.info("Starting of verifySignupFunctionalityWithValidDetails method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setFullName(testDataProp.getProperty("full.name"));
		signupPage.setBirthDate();
		signupPage.setMobileNumber(testDataProp.getProperty("mobile.number"));
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();
		signupPage.hardWait(3);
		signupPage.setLocation(testDataProp.getProperty("location"));
		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();
		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		try {
			if (signupPage.isManageProfileCheckBoxDisplayed()==true) {
				logger.info("****Manage Profile checkbox displayed****");
				signupPage.clickOnManageProfileCheckBox();
			}
		} catch (Exception e) {
			logger.info("****Manage Profile checkbox haven't displayed****");
		}
		signupPage.hardWait(3);

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.clickOnFinishButton();
		signupPage.hardWait(2);

		Assert.assertEquals(signupPage.getSuccessLabel(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertEquals(signupPage.getWelcomeToDuprText(), expectedAssertionsProp.getProperty("welcome.to.dupr"));

		signupPage.clickOnOKButton();

		String verifyYourEmailIdLabel = this.signupPage.getVerifyYourEmailId();
		signupPage.hardWait(3);

		Assert.assertEquals(verifyYourEmailIdLabel, expectedAssertionsProp.getProperty("verify.your.email"));
		signupPage.hardWait(5);
		Assert.assertTrue(signupPage.isAlreadyVerifiedButtonDisplayed());

		Assert.assertTrue(signupPage.isResendLinkButtonDisplayed());

		logger.info("Ending of verifySignupFunctionalityWithValidDetails method");
	}

	@Test(priority = 7, description = "Verify Resend link button functionality by clearing email text field data")
	@Description("Test case #7, Verify Resend link button functionality by clearing email text field data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #7, Verify Resend link button functionality by clearing email text field data")
	public void verifyResendLinkButtonWithoutEmail() {
		logger.info("Starting of verifyResendLinkButtonWithoutEmail method");

		signupPage.clickOnEditButton();
		signupPage.hardWait(5);

		emailid = testDataProp.getProperty("email") + signupPage.randomNumber(4) + "@gmail.com";

		signupPage.setEmailTextBox(emailid);
		signupPage.hardWait(3);
		signupPage.clickOnResendLinkButton();

		signupPage.hardWait(3);
		String linkSentEmailValidation = signupPage.getlinkSentEmailValidation();
		Assert.assertEquals(linkSentEmailValidation, expectedAssertionsProp.getProperty("link.was.sent.mail"));

		signupPage.clickOnLogoutButton();

		signupPage.hardWait(3);

		logger.info("Ending of verifyResendLinkButtonWithoutEmail method");
	}

	@Test(priority = 8, description = "Verify Email address in edit profile page")
	@Description("Test case #8, Verify Email address in edit profile page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #8, Verify Email address in edit profile page")
	public void verifyEmailAddress() {
		logger.info("Starting of verifyEmailAddress method");

		loginPage.loginToDUPRApplication(emailid, testDataProp.getProperty("password"));

		signupPage.hardWait(2);
		Assert.assertEquals(signupPage.getEmailText(), emailid);

		signupPage.clickOnCloseIcon();

		editProfilePage.clickOnOpenSettingMenu();

		editProfilePage.clickOnEditProfileButton();

		signupPage.clickOnVerifyButton();
		signupPage.hardWait(3);

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
