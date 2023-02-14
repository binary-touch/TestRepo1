package com.dupr.test.players;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.home.ValidateStatsChangeOnNewMatchPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Browse Players")
public class BrowsePlayersTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(BrowsePlayersTest.class.getName());
	private ValidateStatsChangeOnNewMatchPage validateStatsChangeOnNewMatchPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in BrowsePlayersTest");

		this.driver = super.getWebDriver(WebDriversEnum.BROWSE_PLAYERS_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.validateStatsChangeOnNewMatchPage = new ValidateStatsChangeOnNewMatchPage(this.driver);

		logger.info("Ending of initMethod in BrowsePlayersTest");
	}

	@Test(priority = 1, description = "Verify Browse player functionaity", groups = "sanity")
	@Description("Test case #1,Verify Browse player functionaity")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Browse player functionaity")
	public void verifyClickOnPlayersTab() throws InterruptedException {
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

	@Test(priority = 5, description = "Verify full name filed with only special characters", groups = "sanity")
	@Description("Test case #5, Verify full name filed with only special characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify full name filed with only special characters")
	public void verifyFullNameWithSpecialCharacters() {
		logger.info("Starting of verifyFullNameWithSpecialCharacters method");

		addAMatchPage.setFullName(testDataProp.getProperty("full.name.with.special.characters"));
		addAMatchPage.clickOnSendInviteButton();

		String NoNumberOrSpecialCharacterNotAllowedValidation = browsePlayersPage
				.getNoNumbersOrSpecialCharatersAreAllowedRequiredText();
		Assert.assertEquals(NoNumberOrSpecialCharacterNotAllowedValidation,
				expectedAssertionsProp.getProperty("fullname.number.validation"));

		String emailRequiredValidation = browsePlayersPage.getEmailIsRequiredText();
		Assert.assertEquals(emailRequiredValidation, expectedAssertionsProp.getProperty("email.required.validation"));

		logger.info("Ending of verifyFullNameWithSpecialCharacters method");
	}

	@Test(priority = 6, description = "Verify full name filed with only Numbers", groups = "sanity")
	@Description("Test case #6, Verify full name filed with only Numbers")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify full name filed with only Numbers")
	public void verifyFullNameWithNumbers() {
		logger.info("Starting of verifyFullNameWithNumbers method");

		addAMatchPage.setFullName(testDataProp.getProperty("full.name.with.numbers"));

		String NoNumberOrSpecialCharacterNotAllowedValidation = browsePlayersPage
				.getNoNumbersOrSpecialCharatersAreAllowedRequiredText();
		Assert.assertEquals(NoNumberOrSpecialCharacterNotAllowedValidation,
				expectedAssertionsProp.getProperty("fullname.number.validation"));

		logger.info("Ending of verifyFullNameWithNumbers method");
	}

	@Test(priority = 7, description = "Verify email address filed with invalid email", groups = "sanity")
	@Description("Test case #7, Verify email address filed with invalid email")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify email address filed with invalid email")
	public void verifyEmailAddressWithInvalidEmail() {
		logger.info("Starting of verifyEmailAddressWithInvalidEmail method");

		addAMatchPage.hardWait(2);
		addAMatchPage.setFullName(testDataProp.getProperty("full.name"));
		addAMatchPage.setEmailForNegativeScenarios(testDataProp.getProperty("invalid.email.in.signup"));
		addAMatchPage.clickOnSendInviteButton();

		addAMatchPage.hardWait(2);
		String invalidEmailValidation = browsePlayersPage.getInvalidEmailText();
		Assert.assertEquals(invalidEmailValidation, expectedAssertionsProp.getProperty("invalid.email.text"));

		browsePlayersPage.clickOnOkButton();
		logger.info("Ending of verifyEmailAddressWithInvalidEmail method");
	}

	@Test(priority = 8, description = "Verify invite a player in browse functionality", groups = "sanity")
	@Description("Test case #8,Verify invite  player in browse functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8,Verify invite  player in browse functionality")
	public void verifyInvitePlayerInBrowsePlayers() {
		logger.info("Starting of verifyInvitePlayerInBrowsePlayers method");

		addAMatchPage.hardWait(2);
		browsePlayersPage.clickOnInvitePlayerToDUPRTab();
		addAMatchPage.setFullName(testDataProp.getProperty("full.name"));
		addAMatchPage.setEmail(testDataProp.getProperty("invite.email"));
		addAMatchPage.clickOnSendInviteButton();
		addAMatchPage.hardWait(2);
		Assert.assertEquals(addAMatchPage.getInviteSentText(), expectedAssertionsProp.getProperty("invite.sent.label"));

		addAMatchPage.clickOnOkButtonInInviteSentPopup();

		logger.info("Ending of verifyInvitePlayerInBrowsePlayers method");
	}

	@Test(priority = 9, description = "verify Find players near me functionlity", groups = "sanity")
	@Description("Test case #9,verify Find players near me functionlity")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9,verify Find players near me functionlity")
	public void verifyFindPlayerNearMeToggleButton() {
		logger.info("Starting of verifyFindPlayerNearMeToggleButton method");

		driver.navigate().refresh();
		browsePlayersPage.clickOnFindNearMeToggleButton();

		//Assert.assertTrue(browsePlayersPage.getPlayersDistances());

		logger.info("Ending of verifyFindPlayerNearMeToggleButton method");
	}

	@Test(priority = 10, description = "Verify filters functionality", groups = "sanity")
	@Description("Test case #10, Verify filters functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10 ,Verify filters functionality")
	public void verifyFiltersFunctionality() {
		logger.info("Starting of verifyFiltersFunctionality method");

		driver.navigate().refresh();
		browsePlayersPage.clickOnFilterButton();

		Assert.assertTrue(browsePlayersPage.isFiltersPageContains());

		logger.info("Ending of verifyFiltersFunctionality method");
	}

	@Test(priority = 11, description = "Verify browse players functionality by location filter", groups = "sanity")
	@Description("Test case #11, Verify browse players functionality by location filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify browse players functionality by location filter")
	public void verifyPlayersByLocationFilter() throws InterruptedException {
		logger.info("Starting of verifyPlayersByLocationFilter method");

		browsePlayersPage.setLocationInFilters(testDataProp.getProperty("primary.location"));
		
		browsePlayersPage.clickOnlocationOption();
		
		browsePlayersPage.clickOnApplyButton();
		browsePlayersPage.hardWait(2);
		
		Assert.assertTrue(browsePlayersPage.getPlayerLocation());

		logger.info("Ending of verifyPlayersByLocationFilter method");
	}

	@Test(priority = 12, description = "Verify browse players functionality by Distance filter", groups = "sanity")
	@Description("Test case #12,Verify browse players by Distance functionality filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12,Verify browse players functionality by Distance filter")
	public void verifyPlayersByDistanceFilter() {
		logger.info("Starting of verifyPlayersByDistanceFilter method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.moveDistanceSlider();
		browsePlayersPage.clickOnApplyButton();

		//Assert.assertTrue(browsePlayersPage.getPlayersDistance());

		logger.info("Ending of verifyPlayersByDistanceFilter method");
	}

	@Test(priority = 13, description = "Verify browse players functionality by Skill Level Ratings filter", groups = "sanity")
	@Description("Test case #13, Verify browse players functionality by Skill Level Ratings filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify browse players functionality by Skill Level Ratings filter")
	public void verifyPlayersBySkillLevelRatingsFilter() {
		logger.info("Starting of verifyPlayersBySkillLevelRatingsFilter method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.moveRatingSecondSlider();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersRatings());

		logger.info("Ending of verifyPlayersBySkillLevelRatingsFilter method");
	}

	@Test(priority = 14, description = "Verify browse players functionality by Singles filters in type", groups = "sanity")
	@Description("Test case #14, Verify browse players functionality by Singles filters in type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify browse players functionality by Singles filters in type")
	public void verifyPlayersBySingleFilterInType() {
		logger.info("Starting of verifyPlayersBySingleFilterInType method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnDoublesCheckBox();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersSinglesRating());

		logger.info("Ending of verifyPlayersBySingleFilterInType method");
	}

	@Test(priority = 15, description = "Verify browse players functionality by Doubles filter in Type", groups = "sanity")
	@Description("Test case #15, Verify browse players functionality by Doubles filter in Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify browse players functionality by Doubles filter in Type")
	public void verifyPlayersByDoublesFiltersInType() {
		logger.info("Starting of verifyPlayersByDoublesFiltersInType method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnSinglesCheckBox();
		browsePlayersPage.clickOnApplyButton();

		Assert.assertTrue(browsePlayersPage.getPlayersDoublesRating());

		logger.info("Ending of verifyPlayersByDoublesFiltersInType method");
	}

	@Test(priority = 16, description = "Verify browse players functionality by Gender filter", groups = "sanity")
	@Description("Test case #16, Verify browse players functionality by Gender filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify browse players functionality by Gender filter")
	public void verifyPlayersByGender() {
		logger.info("Starting of verifyPlayersByGender method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.selectGender();
		browsePlayersPage.clickOnApplyButton();

		logger.info("Ending of verifyPlayersByGender method");
	}

	@Test(priority = 17, description = "Verify browse players functionality by Age range filter", groups = "sanity")
	@Description("Test case #17, Verify browse players functionality by Age range filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify browse players functionality by Age range filter")
	public void verifyPlayersByAge() {
		logger.info("Starting of verifyPlayersByAge method");

		browsePlayersPage.clickOnClearAllButton();
		browsePlayersPage.clickOnAgeOptionRadioButton();
		browsePlayersPage.clickOnApplyButton();
		
		browsePlayersPage.hardWait(2);
		Assert.assertTrue(browsePlayersPage.getPlayersAge());

		

		logger.info("Ending of verifyPlayersByAge method");
	}

	@Test(priority = 18, description = "Verify Clear All functionality", groups = "sanity")
	@Description("Test case #18,Verify Clear All functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18,Verify Clear All functionality")
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

	@Test(priority = 19, description = "Verify Back Arrow button functionality", groups = "sanity")
	@Description("Test case #19,Verify Back Arrow button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19,Verify Back Arrow button functionality")
	public void verifyBackArrowButtonFunctionality() {
		logger.info("Starting of verifyBackArrowButtonFunctionality method");

		browsePlayersPage.clickOnBackArrowButton();

		String addAMatchValidationText = this.loginPage.getAddAMatchValidationText();
		Assert.assertEquals(addAMatchValidationText, expectedAssertionsProp.getProperty("add.match.label"));

		validateStatsChangeOnNewMatchPage.hardWait(3);
		Assert.assertTrue(validateStatsChangeOnNewMatchPage.isResultOverViewSectionContains());

		logger.info("Ending of verifyBackArrowButtonFunctionality method");
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
