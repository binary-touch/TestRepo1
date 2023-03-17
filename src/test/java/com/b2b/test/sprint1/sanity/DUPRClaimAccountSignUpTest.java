package com.b2b.test.sprint1.sanity;

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
@Feature("Claim Account Sanity")
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

	@Test(priority = 1, description = "Verify Claim account page details")
	@Description("Test case #1, Verify Claim account page details")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1, Verify Claim account page details")
	public void verifyTheDetailsDisplayedOnClaimAccountPage() {
		logger.info("Starting of verifyTheDetailsDisplayedOnClaimAccountPage method");

		String searchPlayersValidationText = this.duprSignUpPage.getSearchPlayersValidationText();
		Assert.assertEquals(searchPlayersValidationText, expectedAssertionsProp.getProperty("search.players.text"));

		duprSignUpPage.clickOnSignUpButton();

		String claimYourAccountText = this.duprSignUpPage.getClaimYourAccountText();
		Assert.assertEquals(claimYourAccountText, expectedAssertionsProp.getProperty("claim.account.label"));

		Assert.assertTrue(duprSignUpPage.isClaimYourAccountPageContains());

		logger.info("Ending of verifyTheDetailsDisplayedOnClaimAccountPage method");
	}

	@Test(priority = 2, description = "Verify Claim account button functionality in Claim Account Page")
	@Description("Test case #2, Verify Claim account button functionality in Claim Account Page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2, Verify Claim account button functionality in Claim Account Page")
	public void verifyClaimAccountButtonFunctionality() {
		logger.info("Starting of verifyClaimAccountButtonFunctionality method");

		searchPlayerName = duprSignUpPage.clickOnClaimAccountButton();

		Assert.assertFalse(duprSignUpPage.isFinishButtonEnabled());

		String playerDetailsValidationText = this.duprSignUpPage.getPlayerDetailsText();
		Assert.assertEquals(playerDetailsValidationText, expectedAssertionsProp.getProperty("player.details.label"));
		Assert.assertTrue(duprSignUpPage.isSignUpPageContains());

		logger.info("Ending of verifyClaimAccountButtonFunctionality method");
	}

	@Test(priority = 3, description = "Verify Claim your account functionality with valid details")
	@Description("Test case #3, Verify Claim your account functionality with valid details")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #3, Verify Claim your account functionality with valid details")
	public void verifyClaimYourAccountWithValidDetails() {
		logger.info("Starting of verifyClaimYourAccountWithValidDetails method");

		duprSignUpPage.hardWait(3);
		duprSignUpPage.setBirthDate();
		duprSignUpPage.setMobileNumber(testDataProp.getProperty("invalid.mobile.number"));
		duprSignUpPage.setEmail(testDataProp.getProperty("email"));
		duprSignUpPage.setConfirmEmail();
		duprSignUpPage.clickOnGenderRadioButton();
		duprSignUpPage.hardWait(3);
		duprSignUpPage.setLocation(testDataProp.getProperty("location"));

		duprSignUpPage.setPassword(testDataProp.getProperty("password"));
		duprSignUpPage.setConfirmPassword();

		duprSignUpPage.clickOnReviewDUPRPoliciesCheckBox();
		try {
			if (duprSignUpPage.isManageProfileCheckBoxDisplayed()) {
				logger.info("****Manage Profile checkbox displayed****");
				duprSignUpPage.clickOnManageProfileCheckBox();
			}
		} catch (Exception e) {
			logger.info("****Manage Profile checkbox haven't displayed****");
		}

		duprSignUpPage.hardWait(3);

		Assert.assertTrue(duprSignUpPage.isFinishButtonEnabled());

		duprSignUpPage.clickOnFinishButton();

		duprSignUpPage.hardWait(2);
		duprSignUpPage.clickOnOKButton();
		duprSignUpPage.hardWait(5);

		String verifyYourEmailIdLabel = this.duprSignUpPage.getVerifyYourEmailId();
		Assert.assertEquals(verifyYourEmailIdLabel, expectedAssertionsProp.getProperty("verify.your.email"));

		Assert.assertTrue(duprSignUpPage.isAlreadyVerifiedButtonDisplayed());

		Assert.assertTrue(duprSignUpPage.isResendLinkButtonDisplayed());

		duprSignUpPage.clickOnCloseIcon();

		logger.info("Ending of verifyClaimYourAccountWithValidDetails method");
	}

	@Test(priority = 4, description = "Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account")
	@Description("Test case #4, Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #4, Verify singles and doubles ratings of a player on home page of DUPR application after claiming an account ")
	public void verifyRatingsOfPlayerAfterClaimAccount() {
		logger.info("Starting of verifyRatingsOfPlayerAfterClaimAccount method");

		try {
			duprSignUpPage.hardWait(3);

			float singlesActualValue = Float.parseFloat(duprSignUpPage.getPlayerSinglesRatingInPlayerDashBoard());
			float singlesExpectedValue = Float.parseFloat(DUPRSignUpPage.singlesRatings.substring(0, 3));
			Assert.assertEquals(singlesActualValue, singlesExpectedValue);

			duprSignUpPage.hardWait(3);
			float doublesActualValue = Float.parseFloat(duprSignUpPage.getPlayersDoublesRatingInPlayerDashBoard());
			float doublesExpectedValue = Float.parseFloat(DUPRSignUpPage.doublesRatings.substring(0, 3));
			Assert.assertEquals(doublesActualValue, doublesExpectedValue);
		} catch (Exception e) {
			duprSignUpPage.hardWait(3);
			String singlesActualValue = duprSignUpPage.getPlayerSinglesRatingInPlayerDashBoard();
			String singlesExpectedValue = DUPRSignUpPage.singlesRatings;
			Assert.assertEquals(singlesActualValue, singlesExpectedValue);

			duprSignUpPage.hardWait(3);
			String doublesActualValue = duprSignUpPage.getPlayersDoublesRatingInPlayerDashBoard();
			String doublesExpectedValue = DUPRSignUpPage.doublesRatings;
			Assert.assertEquals(doublesActualValue, doublesExpectedValue);
		}

		logger.info("Ending of verifyRatingsOfPlayerAfterClaimAccount method");
	}

	@Test(priority = 5, description = "Verify Claim account functionality for players under Twelve Age")
	@Description("Test case #5, Verify Claim account functionality for players under Twelve Age")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #5, Verify Claim account functionality for players under Twelve Age")
	public void verifyClaimAccountSignUpWithAgeUnderTwelve() {
		logger.info("Starting of verifyClaimAccountSignUpWithAgeUnderTwelve method");
		duprSignUpPage.hardWait(3);

		loginPage.clickOnOpenSettingsMenu();
		loginPage.hardWait(2);
		loginPage.clickOnLogoutButton();

		loginPage.hardWait(2);
		driver.get(testDataProp.getProperty("claim.account.url"));

		duprSignUpPage.hardWait(1);
		duprSignUpPage.setDateOfBirthWithBelow12Years();

		Assert.assertTrue(duprSignUpPage.isDUPRReviewCheckBox());

		logger.info("Ending of verifyClaimAccountSignUpWithAgeUnderTwelve method");
	}

	@Test(priority = 6, description = "Verify Claim button in player card after claiming their account")
	@Description("Test case #6, Verify Claim button in player card after claiming their account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #6,Verify Claim button in player card after claiming their account")
	public void verifyButtonInPlayerCardAfterClaimedTheirAccount() {
		logger.info("Starting of verifyButtonInPlayerCardAfterClaimedTheirAccount method");

		driver.get(testDataProp.getProperty("claim.your.account.page.url"));

		duprSignUpPage.searchPlayerName(searchPlayerName);
		duprSignUpPage.hardWait(3);
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
