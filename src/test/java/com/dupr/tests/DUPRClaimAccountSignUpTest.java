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
@Feature("Claim Account")
public class DUPRClaimAccountSignUpTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(DUPRClaimAccountSignUpTest.class.getName());

	private DUPRSignUpPage signUpPage = null;
	private WebDriver driver = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL" })
	public void initMethod(String browser, String siteURL) throws Exception {
		logger.info("Starting of initMethod in DUPRClaimAccountSignUpTest");

		this.driver = super.getWebDriver(WebDriversEnum.CLAIM_ACCOUNT_DRIVER);
		goToSite(driver);
		this.signUpPage = new DUPRSignUpPage(this.driver);

		logger.info("Ending of initMethod in DUPRClaimAccountSignUpTest");
	}

	@Test(priority = 1, description = "Verify Claim account signup functionality")
	@Description("Test case #1, Verify account signup functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1, Verify account signup functionality ")
	public void verifyClaimAccountSignUp() {
		logger.info("Starting of verifyClaimAccountSignUp method");

		String searchPlayersValidationText = this.signUpPage.getSearchPlayersValidationText();
		Assert.assertEquals(searchPlayersValidationText, expectedAssertionsProp.getProperty("search.players.text"));

		signUpPage.clickOnSignUpButton();

		String claimYourAccountValidationText = this.signUpPage.getClaimYourAccountText();
		Assert.assertEquals(claimYourAccountValidationText, expectedAssertionsProp.getProperty("claim.account.label"));

		signUpPage.searchPlayerName();

		signUpPage.clickOnClaimAccountButton();

		Assert.assertFalse(signUpPage.isFinishButtonEnabled());

		String playerDetailsValidationText = this.signUpPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsValidationText, expectedAssertionsProp.getProperty("player.details.label"));

		// Assert.assertTrue(signUpPage.isFullNameAutoPopulated());
		signUpPage.hardWait(3);

		signUpPage.setBirthDate(testDataProp.getProperty("date.of.birth"));
		signUpPage.setEmail(testDataProp.getProperty("email"));
		signUpPage.setConfirmEmail();
		signUpPage.clickOnGenderRadioButton();
		signUpPage.setLocation(testDataProp.getProperty("location"));

		signUpPage.setPassword(testDataProp.getProperty("password"));
		signUpPage.setConfirmPassword();

		signUpPage.clickOnReviewDUPRPoliciesCheckBox();
		signUpPage.hardWait(2);

		Assert.assertTrue(signUpPage.isFinishButtonEnabled());

		signUpPage.clickOnFinishButton();

		logger.info("Ending of verifyClaimAccountSignUp method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.CLAIM_ACCOUNT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
