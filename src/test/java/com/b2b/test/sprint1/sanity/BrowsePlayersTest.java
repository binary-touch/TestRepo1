package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Browse Player-Sanity")
public class BrowsePlayersTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(BrowsePlayersTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of initMethod in BrowsePlayersTest");

		this.driver = super.getWebDriver(WebDriversEnum.BROWSE_PLAYERS_DRIVER);
		super.initCommonBaseTest(siteURL, validEmail, validPassword);

		logger.info("Ending of initMethod in BrowsePlayersTest");
	}

	@Test(priority = 1, description = "Verify Browse player functionaity", groups = "sanity")
	@Description("Test case #1,Verify Browse player functionaity")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Browse player functionaity")
	public void verifyClickOnPlayersTab() {
		logger.info("Starting of verifyClickOnPlayersTab method");

		addAMatchPage.clickOnPlayersTab();
		Assert.assertTrue(browsePlayersPage.isBrowsePlayersPageContains());

		logger.info("Ending of verifyClickOnPlayersTab method");
	}

	@Test(priority = 2, description = "Verify Browse player functionaity by name", groups = "sanity")
	@Description("Test case #2, Verify Browse player  functionaity by name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Browse player functionaity by name")
	public void verifyBrowsePlayerByName() {
		logger.info("Starting of verifyBrowsePlayerByName method");

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.name.in.browse.players"));

		String PlayerName = browsePlayersPage.getPlayerName();
		Assert.assertEquals(PlayerName, expectedAssertionsProp.getProperty("search.player.name.in.browse.players"));

		logger.info("Ending of verifyBrowsePlayerByName method");
	}

	@Test(priority = 3, description = "Verify Invite Player to DUPR Tab in browse players functionality", groups = "sanity")
	@Description("Test case #3, Verify Invite Player to DUPR Tab in browse players functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Invite Player to DUPR Tab in browse players functionality")
	public void verifyInvitePlayerToDUPRTab() {
		logger.info("Starting of verifyClickOnInvitePlayerToDUPRTab method");

		browsePlayersPage.clickOnInvitePlayerToDUPRTab();
		Assert.assertTrue(browsePlayersPage.isInvitePlayerPageContains());

		logger.info("Ending of verifyClickOnInvitePlayerToDUPRTab method");
	}

	@Test(priority = 4, description = "Verify full name filed and email field without entering any data", groups = "sanity")
	@Description("Test case #4, Verify full name filed and email field without entering any data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify full name filed and email field without entering any data")
	public void verifyFullNameAndEmailAsEmpty() {
		logger.info("Starting of verifyFullNameAndEmailAsEmpty method");

		addAMatchPage.clickOnSendInviteButton();

		String fullNameRequiredValidation = browsePlayersPage.getFullNameIsRequiredText();
		Assert.assertEquals(fullNameRequiredValidation,
				expectedAssertionsProp.getProperty("full.name.required.validation"));

		String emailRequiredValidation = browsePlayersPage.getEmailIsRequiredText();
		Assert.assertEquals(emailRequiredValidation, expectedAssertionsProp.getProperty("email.required.validation"));

		logger.info("Ending of verifyFullNameAndEmailAsEmpty method");
	}

	@Test(priority = 5, description = "Verify invite a player in browse functionality", groups = "sanity")
	@Description("Test case #5,Verify invite  player in browse functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5,Verify invite  player in browse functionality")
	public void verifyInvitePlayerInBrowsePlayers() {
		logger.info("Starting of verifyInvitePlayerInBrowsePlayers method");

		addAMatchPage.hardWait(2);
		addAMatchPage.setFullName(testDataProp.getProperty("full.name"));
		addAMatchPage.setEmail(testDataProp.getProperty("invite.email"));
		addAMatchPage.clickOnSendInviteButton();
		addAMatchPage.hardWait(2);
		Assert.assertEquals(addAMatchPage.getInviteSentText(), expectedAssertionsProp.getProperty("invite.sent.label"));

		addAMatchPage.clickOnOkButtonInInviteSentPopup();

		logger.info("Ending of verifyInvitePlayerInBrowsePlayers method");
	}

	@Test(priority = 6, description = "verify Find players near me Toggle functionlity", groups = "sanity")
	@Description("Test case #6, verify Find players near me Toggle functionlity")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6,verify Find players near me Toggle functionlity")
	public void verifyFindPlayerNearMeToggleButton() {
		logger.info("Starting of verifyFindPlayerNearMeToggleButton method");

		driver.navigate().refresh();
		browsePlayersPage.clickOnFindNearMeToggleButton();
		browsePlayersPage.hardWait(3);

		try {
			if (browsePlayersPage.isLocationPermissionsPopupDisplayed()) {
				Assert.assertTrue(browsePlayersPage.isLocationPermissionsPopupDisplayed());
				browsePlayersPage.clickOnOKButton();
			}
		} catch (Exception e) {
			logger.info("***Near Me Toggle button enabled***");
		}

		logger.info("Ending of verifyFindPlayerNearMeToggleButton method");
	}

	@Test(priority = 7, description = "Verify browse players functionality by location filter", groups = "sanity")
	@Description("Test case #7, Verify browse players functionality by location filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify browse players functionality by location filter")
	public void verifyPlayersByLocationFilter() {
		logger.info("Starting of verifyPlayersByLocationFilter method");

		driver.navigate().refresh();
		browsePlayersPage.clickOnFilterButton();

		Assert.assertTrue(browsePlayersPage.isFiltersPageContains());

		browsePlayersPage.setLocationInFilters(testDataProp.getProperty("primary.location"));

		browsePlayersPage.clickOnlocationOption();

		browsePlayersPage.clickOnApplyButton();
		browsePlayersPage.hardWait(2);

		Assert.assertTrue(browsePlayersPage.getPlayerLocation());

		logger.info("Ending of verifyPlayersByLocationFilter method");
	}

	@Test(priority = 8, description = "Verify browse players functionality by Distance filter", groups = "sanity")
	@Description("Test case #8, Verify browse players by Distance functionality filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify browse players functionality by Distance filter")
	public void verifyPlayersByDistanceFilter() {
		logger.info("Starting of verifyPlayersByDistanceFilter method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.moveDistanceSlider();
		browsePlayersPage.clickOnApplyButton();

		logger.info("Ending of verifyPlayersByDistanceFilter method");
	}

	@Test(priority = 9, description = "Verify browse players functionality by Skill Level Ratings filter", groups = "sanity")
	@Description("Test case #9, Verify browse players functionality by Skill Level Ratings filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify browse players functionality by Skill Level Ratings filter")
	public void verifyPlayersBySkillLevelRatingsFilter() {
		logger.info("Starting of verifyPlayersBySkillLevelRatingsFilter method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.moveRatingSecondSlider();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersRatings());

		logger.info("Ending of verifyPlayersBySkillLevelRatingsFilter method");
	}

	@Test(priority = 10, description = "Verify browse players functionality by Singles filters in type", groups = "sanity")
	@Description("Test case #10, Verify browse players functionality by Singles filters in type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify browse players functionality by Singles filters in type")
	public void verifyPlayersBySingleFilterInType() {
		logger.info("Starting of verifyPlayersBySingleFilterInType method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnDoublesCheckBox();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersSinglesRating());

		logger.info("Ending of verifyPlayersBySingleFilterInType method");
	}

	@Test(priority = 11, description = "Verify browse players functionality by Doubles filter in Type", groups = "sanity")
	@Description("Test case #11, Verify browse players functionality by Doubles filter in Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify browse players functionality by Doubles filter in Type")
	public void verifyPlayersByDoublesFiltersInType() {
		logger.info("Starting of verifyPlayersByDoublesFiltersInType method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnSinglesCheckBox();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersDoublesRating());

		logger.info("Ending of verifyPlayersByDoublesFiltersInType method");
	}

	@Test(priority = 12, description = "Verify browse players functionality by Gender filter", groups = "sanity")
	@Description("Test case #12, Verify browse players functionality by Gender filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify browse players functionality by Gender filter")
	public void verifyPlayersByGender() {
		logger.info("Starting of verifyPlayersByGender method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.selectGender();
		browsePlayersPage.clickOnApplyButton();

		logger.info("Ending of verifyPlayersByGender method");
	}

	@Test(priority = 13, description = "Verify browse players functionality by Age range filter", groups = "sanity")
	@Description("Test case #13, Verify browse players functionality by Age range filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify browse players functionality by Age range filter")
	public void verifyPlayersByAge() {
		logger.info("Starting of verifyPlayersByAge method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnAgeOptionRadioButton();
		browsePlayersPage.clickOnApplyButton();

		browsePlayersPage.hardWait(2);
		Assert.assertTrue(browsePlayersPage.getPlayersAge());

		logger.info("Ending of verifyPlayersByAge method");
	}

	@Test(priority = 14, description = "Verify Clear All functionality", groups = "sanity")
	@Description("Test case #14,Verify Clear All functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14,Verify Clear All functionality")
	public void verifyClearAllfunctionality() throws InterruptedException {
		logger.info("Starting of verifyClearAllfunctionality method");

		driver.navigate().refresh();
		addAMatchPage.clickOnPlayersTab();

		browsePlayersPage.clickOnFilterButton();

		browsePlayersPage.clickOnAgeOptionRadioButton();

		browsePlayersPage.selectGender();

		browsePlayersPage.clickOnDoublesCheckBox();

		browsePlayersPage.moveDistanceSlider();

		browsePlayersPage.clickOnClearAllButton();

		Assert.assertTrue(browsePlayersPage.isViewAllRadioButtonSeleceted());
		Assert.assertFalse(browsePlayersPage.isUnder19RadioButtonSeleceted());

		logger.info("Ending of verifyClearAllfunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.BROWSE_PLAYERS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
