package com.dupr.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.DUPRSignUpPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("SignUp with create an account")
public class SignupTest extends DUPRBaseAutomationTest {
	private WebDriver driver = null;
	DUPRSignUpPage signupPage = null;
	private static final Logger logger = Logger.getLogger(SignupTest.class.getName());

	@BeforeClass
	@Parameters({ "browser" })
	public void initMethod(String browser) throws Exception {
		logger.info("Starting of initMethod method in SignupTest");

		this.driver = super.getWebDriver(WebDriversEnum.SIGNUP_DRIVER);
		goToSite(driver);
		this.signupPage = new DUPRSignUpPage(this.driver);

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
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();
		signupPage.setInvalidLocation(testDataProp.getProperty("invalid.location"));

		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();

		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.clickOnFinishButton();

		String streetAddressText = this.signupPage.getStreetAddressText();
		Assert.assertEquals(streetAddressText, expectedAssertionsProp.getProperty("enter.you.street.address"));

		signupPage.clickOnOKButton();

		logger.info("Ending of verifySignUpFunctionalityWithInvalidLocation method");
	}

	@Test(priority = 2, description = "Verify Sign up funtionality with invalid birth date ", groups = "sanity")
	@Description("Test case #2, Verify Sign up funtionality with invalid birth date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #2, Verify Sign up funtionality with invalid birth date")
	public void verifySignUpWithInvalidBirthDateFormat() {
		logger.info("Starting of verifySignUpWithInvalidBirthDateFormat method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setBirthDate(testDataProp.getProperty("invalid.data.of.birth"));

		String birthDateValidationMessage = this.signupPage.getBirthDateValidationMessage();
		Assert.assertEquals(birthDateValidationMessage, expectedAssertionsProp.getProperty("incorrect.date.format"));

		logger.info("Ending of verifySignUpWithInvalidBirthDateFormat method");
	}

	@Test(priority = 3, description = "Verify Sign up funtionality ", groups = "sanity")
	@Description("Test case #3, Verify Sign up funtionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #3, Verify Sign up funtionality")
	public void verifySignupFunctionality() {
		logger.info("Starting of verifySignupFunctionality method");

		driver.navigate().refresh();

		String playerDetailsText = this.signupPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsText, expectedAssertionsProp.getProperty("player.details.label"));

		Assert.assertFalse(signupPage.isFinishButtonEnabled());

		signupPage.setFullName(testDataProp.getProperty("full.name"));
		signupPage.setBirthDate(testDataProp.getProperty("date.of.birth"));
		signupPage.setEmail(testDataProp.getProperty("email"));
		signupPage.setConfirmEmail();
		signupPage.clickOnGenderRadioButton();
		signupPage.setLocation(testDataProp.getProperty("location"));

		signupPage.setPassword(testDataProp.getProperty("password"));
		signupPage.setConfirmPassword();

		signupPage.clickOnReviewDUPRPoliciesCheckBox();

		Assert.assertTrue(signupPage.isFinishButtonEnabled());

		signupPage.clickOnFinishButton();
		signupPage.hardWait(2);

		String verifyYourEmailIdLabel = this.signupPage.getVerifyYourEmailId();
		Assert.assertEquals(verifyYourEmailIdLabel, expectedAssertionsProp.getProperty("verify.your.email.id"));

		Assert.assertTrue(signupPage.isDisplayedAlreadyVerifiedButton());
		Assert.assertTrue(signupPage.isDisplayedResendLinkButton());

		logger.info("Ending of verifySignupFunctionality method");
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
