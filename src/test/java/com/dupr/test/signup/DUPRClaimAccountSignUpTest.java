package com.dupr.test.signup;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.DUPRLoginPage;
import com.dupr.pages.signup.DUPRSignUpPage;
import com.dupr.test.DUPRBaseAutomationTest;

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

	private DUPRSignUpPage duprSignUpPage = null;
	private String searchPlayerName = null;

	private DUPRLoginPage loginPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL" })
	public void initMethod(String browser, String siteURL) throws Exception {
		logger.info("Starting of initMethod in DUPRClaimAccountSignUpTest");

		this.driver = super.getWebDriver(WebDriversEnum.CLAIM_ACCOUNT_DRIVER);
		goToSite(driver);
		this.duprSignUpPage = new DUPRSignUpPage(this.driver);

		this.loginPage = new DUPRLoginPage(this.driver);

		logger.info("Ending of initMethod in DUPRClaimAccountSignUpTest");
	}

	@Test(priority = 1, description = "Verify Claim account signup functionality")
	@Description("Test case #1, Verify account signup functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1, Verify account signup functionality ")
	public void verifySignUpFunctionality() {
		logger.info("Starting of verifySignUpFunctionality method");

		String searchPlayersValidationText = this.duprSignUpPage.getSearchPlayersValidationText();
		Assert.assertEquals(searchPlayersValidationText, expectedAssertionsProp.getProperty("search.players.text"));

		duprSignUpPage.clickOnSignUpButton();

		String claimYourAccountText = this.duprSignUpPage.getClaimYourAccountText();
		Assert.assertEquals(claimYourAccountText, expectedAssertionsProp.getProperty("claim.account.label"));

		Assert.assertTrue(duprSignUpPage.isClaimYourAccountPageContains());

		logger.info("Ending of verifySignUpFunctionality method");
	}

	@Test(priority = 2, description = "Verify Claim account signup functionality")
	@Description("Test case #2, Verify account signup functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2, Verify account signup functionality ")
	public void verifyClaimAccountFunctionality() {
		logger.info("Starting of verifyClaimAccountSignUp method");

		Assert.assertTrue(duprSignUpPage.getPlayerSinglesRating());
		Assert.assertTrue(duprSignUpPage.getPlayerDoublesRating());

		searchPlayerName = duprSignUpPage.clickOnClaimAccountButton();

		Assert.assertFalse(duprSignUpPage.isFinishButtonEnabled());

		String playerDetailsValidationText = this.duprSignUpPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsValidationText, expectedAssertionsProp.getProperty("player.details.label"));
		Assert.assertTrue(duprSignUpPage.isSignUpPageContains());

		logger.info("Ending of verifySignUpFunctionality method");
	}

	@Test(priority = 3, description = "Verify Claim account signup functionality")
	@Description("Test case #3, Verify account signup functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #3, Verify account signup functionality ")
	public void verifyClaimYourAccountFunctionlity() {
		logger.info("Starting of verifySignUpFunctionality method");

		duprSignUpPage.hardWait(3);
		duprSignUpPage.setBirthDate(testDataProp.getProperty("date.of.birth"));
		duprSignUpPage.setMobileNumber(testDataProp.getProperty("invalid.mobile.number"));
		duprSignUpPage.setEmail(testDataProp.getProperty("email"));
		duprSignUpPage.setConfirmEmail();
		duprSignUpPage.clickOnGenderRadioButton();
		duprSignUpPage.hardWait(3);
		duprSignUpPage.setLocation(testDataProp.getProperty("location"));

		duprSignUpPage.setPassword(testDataProp.getProperty("password"));
		duprSignUpPage.setConfirmPassword();

		duprSignUpPage.clickOnReviewDUPRPoliciesCheckBox();
		duprSignUpPage.hardWait(2);

		Assert.assertTrue(duprSignUpPage.isFinishButtonEnabled());

		duprSignUpPage.clickOnFinishButton();

		duprSignUpPage.hardWait(2);
		duprSignUpPage.clickOnOKButton();
		duprSignUpPage.hardWait(5);

		String verifyYourEmailIdLabel = this.duprSignUpPage.getVerifyYourEmailId();
		Assert.assertEquals(verifyYourEmailIdLabel, expectedAssertionsProp.getProperty("verify.your.email.id"));

		Assert.assertTrue(duprSignUpPage.isAlreadyVerifiedButtonDisplayed());

		Assert.assertTrue(duprSignUpPage.isResendLinkButtonDisplayed());

		duprSignUpPage.clickOnCloseIcon();

		logger.info("Ending of verifyClaimYourAccountFunctionlity method");
	}

	@Test(priority = 4, description = "Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account")
	@Description("Test case #4, Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #4, Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account ")
	public void verifyRatingsOfPlayerAfterClaimAccount() {
		logger.info("Starting of verifyRatingsOfPlayerAfterClaimAccount method");

		duprSignUpPage.hardWait(3);
		float singlesActualValue = Float.parseFloat(duprSignUpPage.getPlayerSinglesRatingInPlayerDashBoard());
		float singlesExpectedValue = Float.parseFloat(DUPRSignUpPage.singlesRatings.substring(0, 3));
		Assert.assertEquals(singlesActualValue, singlesExpectedValue);

		duprSignUpPage.hardWait(3);
		float doublesActualValue = Float.parseFloat(duprSignUpPage.getPlayersDoublesRatingInPlayerDashBoard());
		float doublesExpectedValue = Float.parseFloat(DUPRSignUpPage.doublesRatings.substring(0, 3));
		Assert.assertEquals(doublesActualValue, doublesExpectedValue);

		logger.info("Ending of verifyRatingsOfPlayerAfterClaimAccount method");
	}

	@Test(priority = 5, description = "Verify Claim account signup functionality")
	@Description("Test case #5, Verify account signup functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #5, Verify account signup functionality ")
	public void verifyClaimAccountSignUpWithAgeUnderTwelve() {
		logger.info("Starting of verifyClaimAccountSignUpWithAgeUnderTwelve method");

		loginPage.clickOnOpenSettingsMenu();
		loginPage.hardWait(2);
		loginPage.clickOnLogoutButton();

		loginPage.hardWait(2);
		driver.get(testDataProp.getProperty("claim.account.url"));

		duprSignUpPage.hardWait(1);
		duprSignUpPage.setBirthDate(testDataProp.getProperty("date.of.birth.undertwelve"));

		Assert.assertTrue(duprSignUpPage.isDUPRReviewCheckBox());

		logger.info("Ending of verifyClaimAccountSignUpWithAgeUnderTwelve method");
	}

	@Test(priority = 6, description = "Verify Claim button in player card after claimed their account")
	@Description("Test case #6, Verify Claim button in player card after claimed their account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #6,Verify Claim button in player card after claimed their account ")
	public void verifyButtonInPlayerCardAfterClaimedTheirAccount() {
		logger.info("Starting of verifyButtonInPlayerCardAfterClaimedTheirAccount method");

		driver.get(testDataProp.getProperty("claim.your.account.page.url"));

		duprSignUpPage.searchPlayerName(searchPlayerName);
		Assert.assertFalse(duprSignUpPage.isClaimAccountButtonDisplayed());

		logger.info("Ending of verifyButtonInPlayerCardAfterClaimedTheirAccount method");
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
