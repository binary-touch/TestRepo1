package com.dupr.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.DUPRLoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Negative Login")
public class NegativeLoginTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(NegativeLoginTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "siteURL", "language", "headless" })
	public void initMethod(String browser, String siteURL, String language, String headless) throws Exception {
		logger.info("Starting of initMethod in NegativeLoginTest");

		this.driver = super.getWebDriver(WebDriversEnum.NEGATIVE_LOGIN_DRIVER);
		goToSite(driver);
		this.loginPage = new DUPRLoginPage(this.driver);

		logger.info("Ending of initMethod in NegativeLoginTest");
	}

	@Test(priority = 1, description = "Verify Login with single character in email and password fields", groups = "sanity")
	@Description("Test case #1, Verify Login with single character in email and password fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Login with single character in email and password")
	public void verifyEmailAndPasswordFieldWithSingleCharacter() {
		logger.info("Starting of verifyEmailAndPasswordFieldWithSingleCharacter method");

		loginPage.clickOnLogInLink();
		loginPage.loginToDUPRApplication(testDataProp.getProperty("invalid.email"),
				testDataProp.getProperty("invalid.email"));

		//Assert.assertEquals(loginPage.getInvalidEmailText(), expectedAssertionsProp.getProperty("invalid.email.text"));
		Assert.assertEquals(loginPage.getPasswordErrorMessageText(),
				expectedAssertionsProp.getProperty("password.length.validation"));

		logger.info("Ending of verifyEmailAndPasswordFieldWithSingleCharacter method");
	}

	@Test(priority = 2, description = "Verify Login with space characters in email and password fields", groups = "sanity")
	@Description("Test case #2, Verify Login with space characters in email and password fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Login with space characters in email and password fields")
	public void verifyEmailAndPasswordFieldsWithSpaceCharacters() {
		logger.info("Starting of verifyEmailAndPasswordFieldsWithSpaceCharacters method");

		driver.navigate().refresh();

		loginPage.loginToDUPRApplication(testDataProp.getProperty("incorrect.value"),
				testDataProp.getProperty("incorrect.value"));
		loginPage.hardWait(2);

		//Assert.assertEquals(loginPage.getInvalidEmailText(), expectedAssertionsProp.getProperty("invalid.email.text"));
		Assert.assertEquals(loginPage.getWhiteSpacesNotAllowedValidationText(),
				expectedAssertionsProp.getProperty("white.space.password.validation"));

		logger.info("Ending of verifyEmailAndPasswordFieldsWithSpaceCharacters method");
	}

	@Test(priority = 3, description = "Verify Login with empty email and password fields", groups = "sanity")
	@Description("Test case #3, Verify Login with empty email and password fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Login with empty email and password fields")
	public void verifyLoginWithEmptyCredentails() {
		logger.info("Starting of verifyLoginWithEmptyCredentails method");

		driver.navigate().refresh();
		loginPage.clickOnSignInButton();

		Assert.assertEquals(loginPage.getEmailRequiredText(),
				expectedAssertionsProp.getProperty("email.required.validation"));
		Assert.assertEquals(loginPage.getPasswordRequiredText(),
				expectedAssertionsProp.getProperty("password.required.validation"));

		logger.info("Ending of verifyLoginWithEmptyCredentails method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 4, description = "Verify Login with Invalid Email and Valid Password", groups = "sanity")
	@Description("Test case #4, Verify Login with invalid Email and valid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Login with Invalid Email and Valid Password")
	public void verifyLoginWithInvalidEmailValidPassword(String validPassword) {
		logger.info("Starting of verifyLoginWithInvalidEmailValidPassword method");

		driver.navigate().refresh();
		loginPage.loginToDUPRApplication(testDataProp.getProperty("invalid.email.in.signup"), validPassword);

		Assert.assertEquals(loginPage.getInvalidEmailValidationText(), expectedAssertionsProp.getProperty("invalid.email.text"));

		logger.info("Ending of verifyLoginWithInvalidEmailValidPassword method");
	}

	@Parameters({ "validEmail" })
	@Test(priority = 5, description = "Verify Login with Valid Email and Invalid Password", groups = "sanity")
	@Description("Test case #5, Verify Login with Valid Email and Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Login with Valid Email and Invalid Password")
	public void verifyLoginWithValidEmailInvalidPassword(String validEmail) {
		logger.info("Starting of verifyLoginWithValidEmailInvalidPassword method");

		driver.navigate().refresh();
		loginPage.loginToDUPRApplication(validEmail, testDataProp.getProperty("incorrect.password"));

		loginPage.hardWait(2);
		Assert.assertEquals(loginPage.getInvalidPasswordValidationText(),
				expectedAssertionsProp.getProperty("incorrect.password.validation"));

		logger.info("Ending of verifyLoginWithValidEmailInvalidPassword method");
	}

	@Test(priority = 6, description = "Verify Login with Incorrect Email and Invalid Password", groups = "sanity")
	@Description("Test case #6, Verify Login with Incorrect Email and Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Login with Incorrect Email and Invalid Password")
	public void verifyLoginWithIncorrectEmailInvalidPassword() {
		logger.info("Starting of verifyLoginWithIncorrectEmailInvalidPassword method");

		driver.navigate().refresh();
		loginPage.loginToDUPRApplication(testDataProp.getProperty("invalid.email.in.signup"),
				testDataProp.getProperty("incorrect.password"));

		Assert.assertEquals(loginPage.getInvalidEmailValidationText(), expectedAssertionsProp.getProperty("invalid.email.text"));

		logger.info("Ending of verifyLoginWithIncorrectEmailInvalidPassword method");
	}

	@Parameters({ "validEmail" })
	@Test(priority = 7, description = "Verify password filed by entering more than 40 characters", groups = "sanity")
	@Description("Test case #7, Verify password filed by entering more than 40 characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify password filed by entering more than 40 characters")
	public void verifyLoginWithMoreThanMaxCharactersInPassword(String validEmail) {
		logger.info("Starting of verifyLoginWithMoreThanMaxCharactersInPassword method");

		driver.navigate().refresh();

		loginPage.loginToDUPRApplication(validEmail, testDataProp.getProperty("more.than.max.characters.password"));
		loginPage.hardWait(2);

		Assert.assertEquals(loginPage.getPasswordMustNotExceedMaxCharactersValidationText(),
				expectedAssertionsProp.getProperty("password.mustnot.exceed.max.characters"));

		logger.info("Ending of verifyLoginWithMoreThanMaxCharactersInPassword method");
	}

	@Test(priority = 8, description = "Verify Login with Invalid Email and Invalid Password", groups = "sanity")
	@Description("Test case #8, Verify Login with Invalid Email and Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Login with Invalid Email and Invalid Password")
	public void verifyLoginWithInvalidEmailAndInvalidPassword() {
		logger.info("Starting of verifyLoginWithInvalidEmailAndInvalidPassword method");

		driver.navigate().refresh();

		loginPage.loginToDUPRApplication(testDataProp.getProperty("invalid.email.in.negative.login"),
				testDataProp.getProperty("incorrect.password"));

		loginPage.hardWait(5);

		Assert.assertEquals(loginPage.getInvalidPasswordValidationText(),
				expectedAssertionsProp.getProperty("incorrect.password.validation"));

		logger.info("Ending of verifyLoginWithInvalidEmailAndInvalidPassword method");
	}

	@Parameters({ "validEmail" })
	@Test(priority = 9, description = "Verify Login with Valid Email and Invalid Password", groups = "sanity")
	@Description("Test case #9,Verify Login with Valid Email and Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Login with Valid Email and Invalid Password")
	public void verifyLoginWithValidEmailAndInvalidPassword(String validEmail) {
		logger.info("Starting of verifyLoginWithValidEmailAndInvalidPassword method");

		driver.navigate().refresh();
		loginPage.loginToDUPRApplication(validEmail, testDataProp.getProperty("incorrect.password"));

		loginPage.hardWait(4);
		Assert.assertEquals(loginPage.getInvalidPasswordValidationText(),
				expectedAssertionsProp.getProperty("incorrect.password.validation"));

		logger.info("Ending of verifyLoginWithValidEmailAndInvalidPassword method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.NEGATIVE_LOGIN_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
