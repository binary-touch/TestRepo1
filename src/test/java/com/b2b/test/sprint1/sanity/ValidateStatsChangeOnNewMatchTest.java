package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.home.ValidateRecentlyAddedMatchPage;
import com.dupr.pages.home.ValidateStatsChangeOnNewMatchPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Validate stats change on new match sanity")
public class ValidateStatsChangeOnNewMatchTest extends CommonBaseTest {

	private static final Logger log = Logger.getLogger(ValidateStatsChangeOnNewMatchTest.class.getName());

	private ValidateStatsChangeOnNewMatchPage validateStats = null;
	private ValidateRecentlyAddedMatchPage validateMatch = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		log.info("Starting of initMethod in ValidateStatsChangeOnNewMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.VALIDATE_STATS_CHANGE_ON_NEW_MATCH_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.validateStats = new ValidateStatsChangeOnNewMatchPage(this.driver);
		this.validateMatch = new ValidateRecentlyAddedMatchPage(this.driver);

		log.info("Ending of initMethod in ValidateStatsChangeOnNewMatchTest");
	}

	@Test(priority = 1, description = "Verify Result overview section", groups = "sanity")
	@Description("Test case #1,Verify Result overview section")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Result overview section")
	public void verifyResultOverView() {
		log.info("Starting of verifyResultOverView method");

		validateStats.hardWait(3);
		Assert.assertTrue(validateStats.isResultOverViewSectionContains());

		log.info("Ending of verifyResultOverView method");
	}

	@Test(priority = 2, description = "Verify pending stats change functionality", groups = "sanity")
	@Description("Test case #2,Verify pending stats change functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify pending stats change functionality")
	public void verifyPendingStatsChange() {
		log.info("Starting of verifyPendingStatsChange method");

		String pendingCount = validateStats.getPendingCountLabelText();

		addAMatchPage.clickOnAddAMatchTab();

		verifySetMatchDetails();
		validateStats.hardWait(3);
		verifyAddAMatchInSinglesWonGame();

		addAMatchPage.clickOnOkButton();

		String newPendingCount = validateStats.getPendingCountLabelText();

		int oldPendingCount = Integer.parseInt(pendingCount);
		oldPendingCount = oldPendingCount + 1;

		String strOldPendingCount = Integer.toString(oldPendingCount);
		Assert.assertEquals(newPendingCount, strOldPendingCount);

		log.info("Ending of verifyPendingStatsChange method");
	}

	@Parameters({ "opponent1Email", "partnerPassword", "validEmail", "validPassword" })
	@Test(priority = 3, description = "Verify wins stats change functionality", groups = "sanity")
	@Description("Test case #3,Verify wins stats change functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify wins stats change functionality")
	public void verifyWinsStatsChange(String opponentEmail, String opponentPassword, String validEmail,
			String validPassword) {
		log.info("Starting of verifyWinsStatsChange method");

		String winsCount = validateStats.getWinsCountLabelText();
		String pendingCount = validateStats.getPendingCountLabelText();

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(opponentEmail, opponentPassword);

		validateMatch.clickOnMatchHistoryTab();
		validateMatch.clickOnPendingButton();

		validateMatch.clickOnValidateButton(matchEvent);

		Assert.assertTrue(validateMatch.isValidateMatchPopupContains());

		validateMatch.clickOnValidateButtonOnValidateMatchPopup();

		validateMatch.hardWait(2);
		Assert.assertTrue(validateMatch.isConfirmValidateMatchPopupContains());

		validateMatch.clickOnValidateButtonOnConfirmValidatePopup();

		validateMatch.hardWait(3);
		String successText = validateMatch.getSuccessText();
		Assert.assertEquals(successText, expectedAssertionsProp.getProperty("success.label"));

		validateMatch.clickOnCloseIcon();

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(validEmail, validPassword);

		String newWinsCount = validateStats.getWinsCountLabelText();

		int oldWinsCount = Integer.parseInt(winsCount);
		oldWinsCount = oldWinsCount + 1;
		String strOldWinsCount = Integer.toString(oldWinsCount);

		Assert.assertEquals(newWinsCount, strOldWinsCount);

		String newPendingCount = validateStats.getPendingCountLabelText();

		int oldPendingCount = Integer.parseInt(pendingCount);
		oldPendingCount = oldPendingCount - 1;
		String strOldPendingCount = Integer.toString(oldPendingCount);

		Assert.assertEquals(newPendingCount, strOldPendingCount);

		log.info("Ending of verifyWinsStatsChange method");
	}

	@Parameters({ "opponent1Email", "partnerPassword", "validEmail", "validPassword" })
	@Test(priority = 4, description = "Verify Losses stats change functionality", groups = "sanity")
	@Description("Test case #4,Verify Losses stats change functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Losses stats change functionality")
	public void verifyLossesStatsChange(String opponentEmail, String opponentPassword, String validEmail,
			String validPassword) {
		log.info("Starting of verifyLossesStatsChange method");

		String lossesCount = validateStats.getLossesCountLabelText();
		String pendingCount = validateStats.getPendingCountLabelText();

		driver.navigate().refresh();
		addAMatchPage.clickOnAddAMatchTab();

		verifySetMatchDetails();

		verifyAddAMatchInSinglesLossGame();

		addAMatchPage.clickOnOkButton();

		String lossesCountAfterAddingNewMatch = validateStats.getLossesCountLabelText();
		Assert.assertEquals(lossesCount, lossesCountAfterAddingNewMatch);

		String pendingCountAfterAddingNewMatch = validateStats.getPendingCountLabelText();

		int intPendingCountAfterAddingNewMatch = Integer.parseInt(pendingCountAfterAddingNewMatch);
		intPendingCountAfterAddingNewMatch = intPendingCountAfterAddingNewMatch - 1;
		String strPendingCountAfterAddingNewMatch = Integer.toString(intPendingCountAfterAddingNewMatch);

		Assert.assertEquals(pendingCount, strPendingCountAfterAddingNewMatch);

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(opponentEmail, opponentPassword);

		validateMatch.clickOnMatchHistoryTab();
		validateMatch.clickOnPendingButton();

		validateMatch.clickOnValidateButton(matchEvent);

		Assert.assertTrue(validateMatch.isValidateMatchPopupContains());

		validateMatch.clickOnValidateButtonOnValidateMatchPopup();

		validateMatch.hardWait(2);
		Assert.assertTrue(validateMatch.isConfirmValidateMatchPopupContains());

		validateMatch.clickOnValidateButtonOnConfirmValidatePopup();

		validateMatch.hardWait(3);
		String successText = validateMatch.getSuccessText();
		Assert.assertEquals(successText, expectedAssertionsProp.getProperty("success.label"));

		validateMatch.clickOnCloseIcon();

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(validEmail, validPassword);

		String updatedlossesCount = validateStats.getLossesCountLabelText();
		int intUpdatedlossesCount = Integer.parseInt(updatedlossesCount);
		intUpdatedlossesCount = intUpdatedlossesCount - 1;
		String strUpdatedlossesCount = Integer.toString(intUpdatedlossesCount);

		Assert.assertEquals(lossesCount, strUpdatedlossesCount);

		String updatedpendingCount = validateStats.getPendingCountLabelText();

		Assert.assertEquals(pendingCount, updatedpendingCount);

		log.info("Ending of verifyLossesStatsChange method");
	}

	@Test(priority = 5, description = "Verify wins check box functionality", groups = "sanity")
	@Description("Test case #5, Verify wins check box functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify wins check box functionality")
	public void verifyWinsCheckBoxFunctionality() {
		log.info("Starting of verifyWinsCheckBoxFunctionality method");

		validateStats.clickOnWinsCheckBox();

		validateStats.hardWait(2);
		String winsCount = validateStats.getWinsCountLabelText();
		String totalMatchesAfterWinsSelect = validateStats.getTotalMatchesText();
		validateStats.hardWait(3);

		Assert.assertEquals(winsCount, totalMatchesAfterWinsSelect);

		validateStats.clickOnWinsCheckBox();

		log.info("Ending of verifyWinsCheckBoxFunctionality method");
	}

	@Test(priority = 6, description = "Verify losses check box functionality", groups = "sanity")
	@Description("Test case #6, Verify losses check box functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify losses check box functionality")
	public void verifyLossesCheckBoxFunctionality() {
		log.info("Starting of verifyLossesCheckBoxFunctionality method");

		validateStats.clickOnLossesCheckBox();

		validateStats.hardWait(2);
		String lossesCount = validateStats.getLossesCountLabelText();
		String totalMatchesAfterLossesSelect = validateStats.getTotalMatchesText();
		validateStats.hardWait(3);

		Assert.assertEquals(lossesCount, totalMatchesAfterLossesSelect);

		validateStats.clickOnLossesCheckBox();

		log.info("Ending of verifyLossesCheckBoxFunctionality method");
	}

	@Test(priority = 7, description = "Verify pending check box functionality", groups = "sanity")
	@Description("Test case #7, Verify pending check box functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify pending check box functionality")
	public void verifyPendingCheckBoxFunctionality() {
		log.info("Starting of verifyPendingCheckBoxFunctionality method");

		validateStats.hardWait(2);
		validateStats.clickOnPendingCheckBox();

		validateStats.hardWait(2);
		String pendingCount = validateStats.getPendingCountLabelText();
		String totalMatchesAfterPendingSelect = validateStats.getTotalMatchesText();
		validateStats.hardWait(3);

		Assert.assertEquals(pendingCount, totalMatchesAfterPendingSelect);

		validateStats.clickOnPendingCheckBox();

		log.info("Ending of verifyPendingCheckBoxFunctionality method");
	}

	@Test(priority = 8, description = "Verify Total matches count by selecting wins and losses", groups = "sanity")
	@Description("Test case #8, Verify Total matches count by selecting wins and losses")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8 , Verify Total matches count by selecting wins and losses")
	public void verifyTotalMatchesCombinationOfWinsAndLosses() {
		log.info("Starting of verifyTotalMatchesCombinationOfWinsAndLosses method");

		validateStats.clickOnWinsCheckBox();
		validateStats.clickOnLossesCheckBox();

		validateStats.hardWait(5);
		String totalMatches = validateStats.getTotalMatchesText();

		validateStats.hardWait(2);
		String winsCount = validateStats.getWinsCountLabelText();
		String lossesCount = validateStats.getLossesCountLabelText();

		int wins = Integer.parseInt(winsCount);
		int losses = Integer.parseInt(lossesCount);

		int winsAndLosses = wins + losses;

		String winsAndLossesCount = Integer.toString(winsAndLosses);
		validateStats.hardWait(3);

		Assert.assertEquals(totalMatches, winsAndLossesCount);

		validateStats.clickOnWinsCheckBox();
		validateStats.clickOnLossesCheckBox();

		log.info("Ending of verifyTotalMatchesCombinationOfWinsAndLosses method");
	}

	@Test(priority = 9, description = "Verify Total matches count by selecting wins and pending", groups = "sanity")
	@Description("Test case #9, Verify Total matches count by selecting wins and pending")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9 , Verify Total matches count by selecting wins and pending")
	public void verifyTotalMatchesCombinationOfWinsAndPending() {
		log.info("Starting of verifyTotalMatchesCombinationOfWinsAndPending method");

		validateStats.clickOnWinsCheckBox();
		validateStats.clickOnPendingCheckBox();

		validateStats.hardWait(5);
		String totalMatches = validateStats.getTotalMatchesText();

		validateStats.hardWait(2);
		String winsCount = validateStats.getWinsCountLabelText();
		String pendingCount = validateStats.getPendingCountLabelText();

		int wins = Integer.parseInt(winsCount);
		int pending = Integer.parseInt(pendingCount);

		int winsAndPending = wins + pending;

		String winsAndPendingCount = Integer.toString(winsAndPending);
		validateStats.hardWait(3);

		Assert.assertEquals(totalMatches, winsAndPendingCount);

		validateStats.clickOnWinsCheckBox();
		validateStats.clickOnPendingCheckBox();

		log.info("Ending of verifyTotalMatchesCombinationOfWinsAndPending method");
	}

	@Test(priority = 10, description = "Verify Total matches count by selecting losses and pending", groups = "sanity")
	@Description("Test case #10, Verify Total matches count by selecting losses and pending")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10 , Verify Total matches count by selecting losses and pending")
	public void verifyTotalMatchesCombinationOfLossesAndPending() {
		log.info("Starting of verifyTotalMatchesCombinationOfLossesAndPending method");

		validateStats.clickOnLossesCheckBox();
		validateStats.clickOnPendingCheckBox();

		validateStats.hardWait(5);
		String totalMatches = validateStats.getTotalMatchesText();

		validateStats.hardWait(2);
		String lossesCount = validateStats.getLossesCountLabelText();
		String pendingCount = validateStats.getPendingCountLabelText();

		int losses = Integer.parseInt(lossesCount);
		int pending = Integer.parseInt(pendingCount);

		int lossesAndPending = losses + pending;

		String lossesAndPendingCount = Integer.toString(lossesAndPending);
		validateStats.hardWait(3);

		Assert.assertEquals(totalMatches, lossesAndPendingCount);

		validateStats.clickOnLossesCheckBox();
		validateStats.clickOnPendingCheckBox();

		log.info("Ending of verifyTotalMatchesCombinationOfLossesAndPending method");
	}

	@Test(priority = 11, description = "Verify info icon functionality", groups = "sanity")
	@Description("Test case #11, Verify info icon functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11 , Verify info icon functionality")
	public void verifyInfoIconFunctionality() {
		log.info("Starting of verifyInfoIconFunctionality method");

		validateStats.clickOnInfoIcon();

		Assert.assertTrue(validateStats.isResultOverViewPopupContains());

		validateStats.clickOnOKButton();

		log.info("Ending of verifyInfoIconFunctionality method");
	}

	@Test(priority = 12, description = "Verify View profile button functionality", groups = "sanity")
	@Description("Test case #12, Verify View profile functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12 , Verify View profile functionality")
	public void verifyViewProfileFunctionality() throws InterruptedException {
		log.info("Starting of verifyViewProfileFunctionality method");

		validateStats.clickOnViewProfileButton();

		Assert.assertTrue(validateStats.isPlayerProfilePageContains());

		log.info("Ending of verifyViewProfileFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.VALIDATE_STATS_CHANGE_ON_NEW_MATCH_DRIVER);

				log.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
}