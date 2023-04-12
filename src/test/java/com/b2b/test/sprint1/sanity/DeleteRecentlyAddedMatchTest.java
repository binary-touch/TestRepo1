package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.home.DeleteRecentlyAddedMatchPage;
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
@Feature("Delete Recently Added Match-Sanity")
public class DeleteRecentlyAddedMatchTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(DeleteRecentlyAddedMatchTest.class.getName());

	private ValidateStatsChangeOnNewMatchPage validateStatsChangeOnNewMatchPage = null;
	private DeleteRecentlyAddedMatchPage deleteRecentlyAddedMatchPage = null;
	private ValidateRecentlyAddedMatchPage validateRecentlyAddedMatchPage = null;

	private int OldTotalCount;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in DeleteRecentlyAddedMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.DELETE_RECENTLY_ADDED_MATCH_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.deleteRecentlyAddedMatchPage = new DeleteRecentlyAddedMatchPage(this.driver);
		this.validateRecentlyAddedMatchPage = new ValidateRecentlyAddedMatchPage(this.driver);
		this.validateStatsChangeOnNewMatchPage = new ValidateStatsChangeOnNewMatchPage(this.driver);

		logger.info("Ending of initMethod inDeleteRecentlyAddedMatchTest");
	}

	@Test(priority = 1, description = "Verify Match History tab", groups = "sanity")
	@Description("Test case #1, Verify Match History tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Match History tab")
	public void verifyMatchHistoryTab() {
		logger.info("Starting of verifyMatchHistoryTab method");

		addAMatchPage.clickOnAddAMatchTab();

		super.verifySetMatchDetails();
		validateRecentlyAddedMatchPage.hardWait(2);
		super.verifyAddAMatchInDoubles();

		validateRecentlyAddedMatchPage.hardWait(4);
		driver.navigate().refresh();

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();

		validateRecentlyAddedMatchPage.hardWait(2);
		Assert.assertTrue(validateRecentlyAddedMatchPage.isMatchHistoryOptionsPageContains());

		logger.info("Ending of verifyMatchHistoryTab method");
	}

	@Test(priority = 2, description = "Verify Recently Added Match status in player view who added a match", groups = "sanity")
	@Description("Test case #2, Verify Recently Added Match status in player view who added  a match")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Recently Added Match status in player view who added a match")
	public void verifyRecentlyAddedMatchStatusInPlayerView() {
		logger.info("Starting of verifyRecentlyAddedMatchStatusInPlayerView method");

		validateRecentlyAddedMatchPage.hardWait(4);
		Assert.assertTrue(validateRecentlyAddedMatchPage.isDeleteButtonDisplayed(matchEvent));

		logger.info("Ending of verifyRecentlyAddedMatchStatusInPlayerView method");
	}

	@Parameters({ "partnerEmail", "partnerPassword" })
	@Test(priority = 3, description = "Verify Recently Added Match status in Team1 partner view ", groups = "sanity")
	@Description("Test case #3, Verify Recently Added Match status in Team1 partner view")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Recently Added Match status in  Team1 partner view ")
	public void verifyRecentlyAddedMatchStatusInPartnerView(String partnerEmail, String partnerPassword) {
		logger.info("Starting of verifyRecentlyAddedMatchStatusInPartnerView method");

		loginPage.clickOnOpenSettingsMenu();
		validateRecentlyAddedMatchPage.hardWait(2);
		loginPage.clickOnLogoutButton();
		validateRecentlyAddedMatchPage.hardWait(5);
		loginPage.loginToDUPRApplication(partnerEmail, partnerPassword);

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(6);
		Assert.assertTrue(deleteRecentlyAddedMatchPage.isPendingLabelDisplayed(matchEvent));

		logger.info("Ending of verifyRecentlyAddedMatchStatusInPartnerView method");
	}

	@Parameters({ "opponent1Email", "partnerPassword" })
	@Test(priority = 4, description = "Verify Recently  Added Match  status in Oppenent1 view", groups = "sanity")
	@Description("Test case #4, Verify Recently  Added Match  status in Oppenent1 view")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Recently Added Match status in Oppenent1 view")
	public void verifyRecentlyAddedMatchStatusInFirstOpponentView(String opponentEmail, String partnerPassword) {
		logger.info("Starting of verifyRecentlyAddedMatchStatusInFirstOpponentView method");

		loginPage.clickOnOpenSettingsMenu();
		loginPage.hardWait(2);
		loginPage.clickOnLogoutButton();
		loginPage.hardWait(3);
		loginPage.loginToDUPRApplication(opponentEmail, partnerPassword);

		loginPage.hardWait(5);

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(3);
		Assert.assertTrue(validateRecentlyAddedMatchPage.isValidateButtonDisplayed(matchEvent));

		logger.info("Ending of verifyRecentlyAddedMatchStatusInFirstOpponentView method");
	}

	@Parameters({ "opponent2Email", "partnerPassword" })
	@Test(priority = 5, description = "Verify Recently  Added Match status in Oppenent2 view", groups = "sanity")
	@Description("Test case #5, Verify Recently  Added Match status in Oppenent2 view")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Recently  Added Match  status in Oppenent2 view")
	public void verifyRecentlyAddedMatchStatusInSecondOpponentView(String opponent2Email, String partnerPassword) {
		logger.info("Starting of verifyRecentlyAddedMatchStatusInSecondOpponentView method");

		loginPage.clickOnOpenSettingsMenu();
		loginPage.hardWait(2);
		loginPage.clickOnLogoutButton();
		loginPage.hardWait(3);
		loginPage.loginToDUPRApplication(opponent2Email, partnerPassword);

		loginPage.hardWait(5);

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(4);
		Assert.assertTrue(validateRecentlyAddedMatchPage.isValidateButtonDisplayed(matchEvent));

		logger.info("Ending of verifyRecentlyAddedMatchStatusInSecondOpponentView method");
	}

	@Parameters({ "validEmail", "validPassword" })
	@Test(priority = 6, description = "Verify delete a match in the match history page", groups = "sanity")
	@Description("Test case #6, Verify delete a match in the match history page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify delete a match in the match history page")
	public void verifyDeleteMatchFunctionality(String validEmail, String validPassword) {
		logger.info("Starting of verifyDeleteMatchFunctionality method");

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(validEmail, validPassword);
		deleteRecentlyAddedMatchPage.hardWait(3);
		String totalMatches = validateStatsChangeOnNewMatchPage.getTotalMatchesText();
		OldTotalCount = Integer.parseInt(totalMatches);

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(3);
		validateRecentlyAddedMatchPage.clickOnDeleteButton(matchEvent);

		deleteRecentlyAddedMatchPage.hardWait(2);

		String deleteMatchPopupText = deleteRecentlyAddedMatchPage.getDeleteMatchText();
		Assert.assertEquals(deleteMatchPopupText, expectedAssertionsProp.getProperty("delete.match.label"));

		Assert.assertTrue(deleteRecentlyAddedMatchPage.isDeleteMatchPopupContains());

		logger.info("Ending of verifyDeleteMatchFunctionality method");
	}

	@Test(priority = 7, description = "Verify delete button functionality in the delete match popup page ", groups = "sanity")
	@Description("Test case #7, Verify delete button functionality in the delete match popup page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify delete button functionality in the delete match popup page")
	public void verifyDeleteButtonInDeleteMatchPopup() {
		logger.info("Starting of verifyClickOnDeleteInDeleteMatchPopup method");

		validateRecentlyAddedMatchPage.hardWait(5);
		deleteRecentlyAddedMatchPage.clickOnDeleteButtonInDeleteMatchPopup();
		deleteRecentlyAddedMatchPage.hardWait(5);
		String successTextInSuccessPopup = deleteRecentlyAddedMatchPage.getSuccessText();
		Assert.assertEquals(successTextInSuccessPopup, expectedAssertionsProp.getProperty("success.label"));

		Assert.assertTrue(deleteRecentlyAddedMatchPage.isSuccessPopupContains());
		validateRecentlyAddedMatchPage.hardWait(3);
		deleteRecentlyAddedMatchPage.clickOnCloseIcon();
		logger.info("Ending of verifyClickOnDeleteInDeleteMatchPopup method");
	}

	@Test(priority = 8, description = "Verify deleted match that has been removed from the player profile", groups = "sanity")
	@Description("Test case #8, Verify deleted match that has been removed from the player profile")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Total matches count after deleting a match ")
	public void verifyMatchCountInPlayerProfile() {
		logger.info("Starting of verifyMatchCountInPlayerProfile method");

		deleteRecentlyAddedMatchPage.clickOnHomeTab();

		deleteRecentlyAddedMatchPage.hardWait(3);
		String totalMatches = validateStatsChangeOnNewMatchPage.getTotalMatchesText();

		int newTotalCount = Integer.parseInt(totalMatches);
		OldTotalCount = OldTotalCount - 1;

		Assert.assertEquals(newTotalCount, OldTotalCount);

		logger.info("Ending of verifyMatchCountInPlayerProfile method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.DELETE_RECENTLY_ADDED_MATCH_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
