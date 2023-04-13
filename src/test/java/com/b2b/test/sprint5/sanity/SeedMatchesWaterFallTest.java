package com.b2b.test.sprint5.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EditScoreAfterValidationPage;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.pages.events.SeedMatchesWaterFallPage;
import com.dupr.pages.home.PreservingPageVisitsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Seed & Reseed WaterFall sanity")
public class SeedMatchesWaterFallTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(SeedMatchesWaterFallTest.class.getName());
	private SeedMatchesPage seedMatchesPage = null;
	private EditScoreAfterValidationPage editScoreAfterValidationPage = null;
	private SeedMatchesWaterFallPage seedMatchesWaterFallPage = null;
	private PreservingPageVisitsPage preservingPageVisitsPage = null;
	private String FirstGameScore = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in SeedMatchesWaterFallPage");

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_WATERFALL_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		this.seedMatchesWaterFallPage = new SeedMatchesWaterFallPage(this.driver);
		this.preservingPageVisitsPage = new PreservingPageVisitsPage(this.driver);
		this.editScoreAfterValidationPage = new EditScoreAfterValidationPage(this.driver);

		logger.info("Ending of initMethod in SeedMatchesWaterFallPage");
	}

	@Test(priority = 1, description = "Verify creating WaterFall Event As Doubles", groups = "sanity")
	@Description("Test case #1, Verify creating WaterFall Event As Doubles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify creating WaterFall Event As Doubles")
	public void verifyCreatingWaterFallEventAsDoubles() {
		logger.info("Starting of verifyCreatingWaterFallEventAsDoubles method");

		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		seedMatchesPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addAMatchPage.hardWait(2);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		addEventPage.clickOnNextStepButton();

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreatingWaterFallEventAsDoubles method");
	}

	// @Test(priority = 2, description = "Verify register for the event", groups =
	// "sanity")
	@Description("Test case #2, Verify register for the event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify register for the event")
	public void verifyRegisterForAnEvent() {
		logger.info("Starting of verifyRegisterForAnEvent method");

		seedMatchesPage.registerEvent();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnHomeMenu();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnMyClubsCard();
		addEventPage.hardWait(5);

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);

		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyRegisterForAnEvent method");
	}

	@Test(priority = 3, description = "Verify Adding Participants in waterfall event", groups = "sanity")
	@Description("Test case #3, Verify Adding Participants in waterfall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Adding Participants in waterfall event")
	public void verifyAddingParticipantsInWaterFallEvent() {
		logger.info("Starting of verifyAddingParticipantsInWaterFallEvent method");

		seedMatchesPage.hardWait(3);
		addparticipantsPage.addMeetPlayerForWaterFallEvent(testDataProp.getProperty("player.name"));
		seedMatchesPage.hardWait(3);
		addparticipantsPage.addParticipantsForWaterFall();

		logger.info("Ending of verifyAddingParticipantsInWaterFallEvent method");
	}

	@Test(priority = 4, description = "Verify Creating teams in waterFall event", groups = "sanity")
	@Description("Test case #4, Verify Creating teams in waterFall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Creating teams in waterFall event")
	public void verifyCreatingTeamInWaterFallEvent() {
		logger.info("Starting of verifyCreatingTeamInWaterFallEvent method");

		seedMatchesPage.hardWait(3);
		createTeams.selectTeamsInWaterFall();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnTeamsTab();

		logger.info("Ending of verifyCreatingTeamInWaterFallEvent method");
	}

	@Test(priority = 5, description = "Verify the results on click of Create matches button in Seed Matches page", groups = "sanity")
	@Description("Test case #5, Verify the results on click of Create matches button in Seed Matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click of Create matches button in Seed Matches page")
	public void verifyCreateMatchesFuntionalityInSeedMatchesPage() {
		logger.info("Starting of verifyCreateMatchesFuntionalityInSeedMatchesPage method");

		seedMatchesPage.hardWait(7);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnCreateMatches();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isRoundOneDisplayed());
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublishButtonEnabled());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreateMatchesFuntionalityInSeedMatchesPage method");
	}

	@Test(priority = 6, description = "Verify the results on click of Save & Publish button in Seed Matches page", groups = "sanity")
	@Description("Test case #6, Verify the results on click of Save & Publish button in Seed Matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on click of Save & Publish button in Seed Matches page")
	public void verifySavePublishFunctionalityInSeedMatchesPage() {
		logger.info("Starting of verifySavePublishFunctionalityInSeedMatchesPage method");

		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifySavePublishFunctionalityInSeedMatchesPage method");
	}

	@Test(priority = 7, description = "Verify the presence of the Queue tab in the bracket home page", groups = "sanity")
	@Description("Test case #7, Verify the presence of the Queue tab in the bracket home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the presence of the Queue tab in the bracket home page")
	public void verifyThePresenceOfQueueTabAfterCreateMatches() {
		logger.info("Starting of verifyThePresenceOfQueueTabAfterCreateMatches method");

		seedMatchesPage.hardWait(4);
		Assert.assertTrue(seedMatchesWaterFallPage.isQueueTabDisplayed());

		logger.info("Ending of verifyThePresenceOfQueueTabAfterCreateMatches method");
	}

	@Test(priority = 8, description = "Verify the results on click of Reseed Matches in the Seed matches page", groups = "sanity")
	@Description("Test case #8, Verify the results on click of Reseed Matches in the Seed matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the results on click of Reseed Matches in the Seed matches page")
	public void verifyReseedFunctionalityInSeedMatchesPage() {
		logger.info("Starting of verifyReseedFunctionalityInSeedMatchesPage method");

		seedMatchesPage.clickOnTeamsTab();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnReseedButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isRoundOneDisplayed());
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublishButtonEnabled());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyReseedFunctionalityInSeedMatchesPage method");
	}

	@Test(priority = 9, description = "Verify the results on click of Matches Tab after Reseeding Matches", groups = "sanity")
	@Description("Test case #9, Verify the results on click of Matches Tab after Reseeding Matches")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the results on click of Matches Tab after Reseeding Matches")
	public void verifyMatchesTabFunctionalityAfterReseedMatches() {
		logger.info("Starting of verifyMatchesTabFunctionalityAfterReseedMatches method");

		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyMatchesTabFunctionalityAfterReseedMatches method");
	}

	@Test(priority = 10, description = "Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation", groups = "sanity")
	@Description("Test case #10, Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation")
	public void verifyBracketPageBeforeValidatingMatch() {
		logger.info("Starting of verifyBracketPageBeforeValidatingMatch method");

		seedMatchesPage.hardWait(5);
		Assert.assertTrue(seedMatchesPage.beforeValidateisBracketPageContains());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyBracketPageBeforeValidatingMatch method");
	}

	@Parameters({ "validEmail", "validPassword" })
	// @Test(priority = 11, description = "Verify My Matches as a player", groups =
	// "sanity")
	@Description("Test case #11, Verify My Matches as a player")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify My Matches as a player")
	public void verifyMyMatchesAsAPlayer(String validEmail, String validPassword) {
		logger.info("Starting of verifyMyMatchesAsAPlayer method");

		seedMatchesPage.hardWait(5);
		userDashboardPage.clickOnOpenSettingsMenu();
		seedMatchesPage.hardWait(3);
		preservingPageVisitsPage.clickOnLogoutButton();
		seedMatchesPage.hardWait(3);
		loginPage.loginToDUPRApplication(validEmail, validPassword);
		seedMatchesPage.hardWait(5);
		userDashboardPage.clickOnMyBracketsButton();
		seedMatchesPage.hardWait(5);
		seedMatchesWaterFallPage.clickOnMyMatchesButton(eventName);
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyMyMatchesAsAPlayer method");
	}

	@Test(priority = 12, description = "Verify Adding score as a player", groups = "sanity")
	@Description("Test case #12, Verify Adding score as a player")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Adding score as a player")
	public void verifyAddingScoreAsAPlayer() {
		logger.info("Starting of verifyAddingScoreAsAPlayer method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnAddScoresButton();
		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnCalenderButton();
		seedMatchesPage.hardWait(5);

		seedMatchesPage.selectingMatchDateAsCurrentDate();
		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnAddIcon();
		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnAddIcon();
		seedMatchesPage.hardWait(3);

		seedMatchesPage.enterFirstGamePlayerPoints(testDataProp.getProperty("valid.game.point"),
				testDataProp.getProperty("first.game.player.two.points"));
		seedMatchesPage.hardWait(3);

		seedMatchesPage.enterSecondGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));
		seedMatchesPage.hardWait(3);

		seedMatchesPage.enterThirdGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));
		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnSubmitButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSubmitButtonOnSubmitScores();
		seedMatchesPage.hardWait(3);

		logger.info("Ending of verifyAddingScoreAsAPlayer method");
	}

	@Parameters({ "directorEmail", "directorPassword" })
	// @Test(priority = 13, description = "Verify the Presence of View Queue button
	// after seeding", groups = "sanity")
	@Description("Test case #13, Verify the Presence of View Queue button after seeding")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify the Presence of View Queue button after seeding")
	public void verifyViewQueueButtonsAfterSeeding(String directorEmail, String directorPassword) {
		logger.info("Starting of verifyViewQueueButtonsAfterSeeding method");

		seedMatchesPage.clickOnHomeMenu();
		seedMatchesPage.hardWait(4);
		userDashboardPage.clickOnOpenSettingsMenu();
		seedMatchesPage.hardWait(3);
		preservingPageVisitsPage.clickOnLogoutButton();
		seedMatchesPage.hardWait(3);
		loginPage.loginToDUPRApplication(directorEmail, directorPassword);
		seedMatchesPage.hardWait(5);
		clubLogoPage.clickOnMyClubsTab();
		editClubInfoPage.clickOnSimbaOrganizerButton();
		// userDashboardPage.clickOnMyBracketsButton();
		seedMatchesPage.hardWait(5);

		// Assert.assertTrue(seedMatchesWaterFallPage.isViewTheQueuebuttonDisplayed());

		logger.info("Ending of verifyViewQueueButtonsAfterSeeding method");
	}

	@Test(priority = 14, description = "Verify the Presence of Exit Queue button in Queue tab after seeding", groups = "sanity")
	@Description("Test case #14, verify Edit scores as director or Organizer")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, verify Edit scores as director or Organizer")
	public void verifyExitQueueButtonsAfterSeeding() {
		logger.info("Starting of verifyExitQueueButtonsAfterSeeding method");

		// addEventPage.clickOnEventsTab();
		// seedMatchesPage.hardWait(5);
		// addEventPage.clickOnRecentlyAddedEvent(eventName);
		// addEventPage.hardWait(5);

		// seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);
		// seedMatchesWaterFallPage.clickOnViewQueueButton(eventName);
		seedMatchesPage.hardWait(3);
		Assert.assertTrue(seedMatchesWaterFallPage.isExitTheQueuebuttonDisplayed());

		logger.info("Ending of verifyExitQueueButtonsAfterSeeding method");
	}

	@Test(priority = 15, description = "verify Edit scores as director or Organizer", groups = "sanity")
	@Description("Test case #15, verify Edit scores as director or Organizer")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, verify Edit scores as director or Organizer")
	public void verifyEditedScoresFunctionlityAsADirector() {
		logger.info("Starting of verifyEditedScoresFunctionlityAsADirector method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnEditScoresButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.enterThirdGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSubmitButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSubmitScoresButton();

		Assert.assertFalse(seedMatchesPage.isEditScoresPopUpContains());

		logger.info("Ending of verifyEditedScoresFunctionlityAsADirector method");
	}

	@Test(priority = 16, description = "verify the presence of View draw button", groups = "sanity")
	@Description("Test case #16, verify the presence of View draw button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, verify the presence of View draw button")
	public void verifyPresenceOfViewDrawButtonAfterValidation() {
		logger.info("Starting of verifyPresenceOfViewDrawButtonAfterValidation method");

		/*
		 * seedMatchesPage.clickOnValidateButton(); seedMatchesPage.hardWait(3);
		 * seedMatchesPage.clickOnValidateInValidateMatchButton();
		 * seedMatchesPage.hardWait(3);
		 * seedMatchesPage.clickOnValidateMatchValidateButton();
		 * 
		 * try { seedMatchesPage.clickOnValidateMatchSuccessCloseButton();
		 * 
		 * } catch (Exception e) { seedMatchesPage.clickOnMatchesTabButton();
		 * seedMatchesPage.hardWait(3);
		 * seedMatchesPage.clickOnValidateMatchSuccessCloseButton(); }
		 */

		Assert.assertTrue(seedMatchesWaterFallPage.isViewDrawButtonDisplayed());

		logger.info("Ending of verifyPresenceOfViewDrawButtonAfterValidation method");
	}

	@Test(priority = 17, description = "Verify View Draws Button Functionality", groups = "sanity")
	@Description("Test case #17, Verify View Draws Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify View Draws Button Functionality")
	public void verifyViewDrawsButtonFunctionalityInBracketPage() {
		logger.info("Starting of verifyViewDrawsButtonFunctionalityInBracketPage method");

		seedMatchesWaterFallPage.clickOnViewDrawsButton();
		seedMatchesPage.hardWait(3);
		Assert.assertEquals(seedMatchesWaterFallPage.getHavingTroubleText(),
				expectedAssertionsProp.getProperty("having.trouble.text"));

		logger.info("Ending of verifyViewDrawsButtonFunctionalityInBracketPage method");
	}

	@Test(priority = 18, description = "Verify the results on click of Having trouble button", groups = "sanity")
	@Description("Test case #18, Verify the results on click of Having trouble button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify the results on click of Having trouble button")
	public void verifyHavingTroubleOptionFunctionality() {
		logger.info("Starting of verifyHavingTroubleOptionFunctionality method");

		seedMatchesWaterFallPage.clickOnHavingTroubleButton();
		seedMatchesPage.hardWait(3);
		Assert.assertEquals(seedMatchesWaterFallPage.getHavingWiFiProblemText(),
				expectedAssertionsProp.get("wifi.problem.text"));

		logger.info("Ending of verifyHavingTroubleOptionFunctionality method");
	}

	@Test(priority = 19, description = "Verify Click Here Link Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #19, Verify Click Here Link Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify Click Here Link Functionality in Having WiFi Problems Popup")
	public void verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup method");

		seedMatchesWaterFallPage.clickOnClickHereLink();
		seedMatchesPage.hardWait(3);
		seedMatchesWaterFallPage.switchToNewTab();
		seedMatchesPage.hardWait(3);

		Assert.assertTrue(driver.getCurrentUrl().contains("Waterfall+Diagram.pdf"));

		seedMatchesWaterFallPage.closeTab();

		logger.info("Ending of verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup method");
	}

	@Test(priority = 20, description = "Verify Ok Button Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #20, Verify Ok Button Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify Ok Button Functionality in Having WiFi Problems Popup")
	public void verifOkButtonFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifOkButtonFunctionalityInHavingWiFiProblemsPopup method");

		// seedMatchesWaterFallPage.clickOnHavingTroubleButton();
		seedMatchesWaterFallPage.clickOnOkButton();
		seedMatchesWaterFallPage.hardWait(2);
		Assert.assertTrue(seedMatchesWaterFallPage.isHavingTroubleButtonDisplayed());

		logger.info("Ending of verifOkButtonFunctionalityInHavingWiFiProblemsPopup method");
	}

	@Test(priority = 21, description = "Verify Download Diagram Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #21, Verify Download Diagram Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify Download Diagram Functionality in Having WiFi Problems Popup")
	public void verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup method");

		seedMatchesWaterFallPage.clickOnHavingTroubleButton();
		seedMatchesWaterFallPage.clickOnDownloadDiagramButton();
		seedMatchesPage.hardWait(3);
		seedMatchesWaterFallPage.switchToNewTab();
		Assert.assertTrue(driver.getCurrentUrl().contains("Waterfall+Diagram.pdf"));

		logger.info("Ending of verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup method");

	}

	@Test(priority = 22, description = "Verify Having Trouble button Is Displayed On VB Diagram", groups = "sanity")
	@Description("Test case #22, Verify Having Trouble button Is Displayed On VB Diagram")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #22, Verify Having Trouble button Is Displayed On VB Diagram")
	public void verifyHavingTroubleButtonIsDisplayedOnVBDiagram() {
		logger.info("Starting of verifyHavingTroubleButtonIsDisplayedOnVBDiagram method");

		seedMatchesWaterFallPage.hardWait(2);
		seedMatchesWaterFallPage.closeTab();

		logger.info("Ending of verifyHavingTroubleButtonIsDisplayedOnVBDiagram method");
	}

	@Test(priority = 23, description = "Verify Whether Having Trouble Button Is Clickable", groups = "sanity")
	@Description("Test case #23, Verify Whether Having Trouble Button Is Clickable")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #23,Verify Whether Having Trouble Button Is Clickable")
	public void verifyWhetherHavingTroubleButtonIsClickable() {
		logger.info("Starting of verifyWhetherHavingTroubleButtonIsClickable method");

		seedMatchesWaterFallPage.hardWait(2);
		seedMatchesWaterFallPage.clickOnOkButton();
		seedMatchesWaterFallPage.hardWait(2);
		seedMatchesWaterFallPage.navigateBack();
		seedMatchesWaterFallPage.hardWait(2);
		seedMatchesPage.clickOnMatchesTab();

		logger.info("Ending of verifyWhetherHavingTroubleButtonIsClickable method");
	}

	@Test(priority = 24, description = "Verify Adding all scores", groups = "sanity")
	@Description("Test case #24, Verify Adding all scores")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #24, Verify Adding all scores")
	public void verifyAddingAllScoresForWaterFallEvent() {
		logger.info("Starting of verifyAddingAllScoresForWaterFallEvent method");

		for (int i = 0; i < seedMatchesWaterFallPage.addScore();) {
			seedMatchesPage.clickOnAddScoresButton();
			seedMatchesPage.hardWait(3);

			seedMatchesPage.clickOnCalenderButton();

			seedMatchesPage.hardWait(5);

			seedMatchesPage.selectingMatchDateAsCurrentDate();
			seedMatchesPage.hardWait(3);

			seedMatchesPage.clickOnAddIcon();
			seedMatchesPage.hardWait(3);

			seedMatchesPage.clickOnAddIcon();
			seedMatchesPage.hardWait(3);

			seedMatchesPage.enterFirstGamePlayerPoints(testDataProp.getProperty("valid.game.point"),
					testDataProp.getProperty("first.game.player.two.points"));
			seedMatchesPage.hardWait(3);

			seedMatchesPage.enterSecondGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
					testDataProp.getProperty("first.game.player.two.points"));
			seedMatchesPage.hardWait(3);

			seedMatchesPage.enterThirdGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
					testDataProp.getProperty("first.game.player.two.points"));
			seedMatchesPage.hardWait(3);

			seedMatchesPage.clickOnSubmitButton();
			seedMatchesPage.hardWait(3);
			seedMatchesPage.clickOnSubmitButtonOnSubmitScores();
			seedMatchesPage.hardWait(4);
		}

		logger.info("Ending of verifyAddingAllScoresForWaterFallEvent method");
	}

	// @Test(priority = 25, description = "Verify Validating all scores", groups =
	// "sanity")
	@Description("Test case #25, Verify Validating all scores")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #25, Verify Validating all scores")
	public void verifyValidatingAllScoresForWaterFallEvent() {
		logger.info("Starting of verifyValidatingAllScoresForWaterFallEvent method");

		for (int i = 0; i < seedMatchesWaterFallPage.validateScore();) {

			seedMatchesPage.clickOnValidateButton();
			seedMatchesPage.hardWait(3);
			seedMatchesPage.clickOnValidateInValidateMatchButton();
			seedMatchesPage.hardWait(3);
			seedMatchesPage.clickOnValidateMatchValidateButton();

			try {
				seedMatchesPage.clickOnValidateMatchSuccessCloseButton();

			} catch (Exception e) {
				seedMatchesPage.clickOnMatchesTabButton();
				seedMatchesPage.hardWait(3);
				seedMatchesPage.clickOnValidateMatchSuccessCloseButton();
			}
		}

		logger.info("Ending of verifyValidatingAllScoresForWaterFallEvent method");
	}

	@Test(priority = 26, description = "Verify the results on click of edit button")
	@Description("Test case #26, Verify the results on click of edit button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #26, Verify the results on click of edit button")
	public void verifyEditScore() {
		logger.info("Starting of verifyEditScore method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(3);

		FirstGameScore = seedMatchesWaterFallPage.getFirstGameScoreText();

		seedMatchesWaterFallPage.clickOnEditScore();

		String matchDateText = this.seedMatchesWaterFallPage.getMatchDateText();
		Assert.assertEquals(matchDateText, expectedAssertionsProp.getProperty("match.date.label"));

		String submitButtonText = this.seedMatchesWaterFallPage.getSubmitButtonText();
		Assert.assertEquals(submitButtonText, expectedAssertionsProp.getProperty("submit.button.label"));

		Assert.assertTrue(seedMatchesWaterFallPage.isCrossIconDisplayed());

		logger.info("Ending of verifyEditScore method");
	}

	@Test(priority = 27, description = "Verify To edit Game Score")
	@Description("Test case #27, Verify To edit Game Score")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #27, Verify To edit Game Score ")
	public void verifyToSetGameScore() {
		logger.info("Starting of verifyToSetGameScore method");

		seedMatchesWaterFallPage.setFirstGameScoreEdit(testDataProp.getProperty("first.game.score"));
		seedMatchesWaterFallPage.setSecondGameScoreEdit(testDataProp.getProperty("second.game.score"));
		seedMatchesWaterFallPage.clickOnSubmitButton();

		logger.info("Ending of verifyToSetGameScore method");
	}

	@Test(priority = 28, description = "Verify to Submit new Score")
	@Description("Test case #28, Verify login to Submit new Score")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #28, Verify to Submit new Score")
	public void verifyToSubmittingNewScore() {
		logger.info("Starting of verifyToSubmittingNewScore method");

		seedMatchesWaterFallPage.hardWait(2);
		// Assert.assertFalse(seedMatchesWaterFallPage.isSubmittingNewScoresLabelDisplayed());

		// seedMatchesWaterFallPage.clickOnSubmitButton();

		seedMatchesWaterFallPage.clickOnSubmitScoreButton();

		logger.info("Ending of verifyToSubmittingNewScore method");
	}

	@Test(priority = 29, description = "Verify Adding and validting scores for All Rounds", groups = "sanity")
	@Description("Test case #29, Verify Adding and validting scores for All Rounds")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #29, Verify Adding and validting scores for All Rounds")
	public void verifyAddingAndValidatingScoreForAllRounds() {
		logger.info("Starting of verifyAddingAndValidatingScoreForAllRounds method");

		for (int i = 0; i < 4; i++) {
			this.verifyAddingAllScoresForWaterFallEvent();
			// this.verifyValidatingAllScoresForWaterFallEvent();
		}

		logger.info("Ending of verifyAddingAndValidatingScoreForAllRounds method");
	}

	@Test(priority = 30, description = "Verify the results on click of edit button After Standing tab is displayed")
	@Description("Test case #30, Verify the results on click of edit button After Standing tab is displayed")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #30, Verify the results on click of edit button After Standing tab is displayed")
	public void verifyEditScoreAfterStandingTabIsDisplayed() {
		logger.info("Starting of verifyEditScoreAfterStandingTabIsDisplayed method");

		seedMatchesWaterFallPage.clickOnEditScore();

		seedMatchesWaterFallPage.setFirstGameScoreEdit(testDataProp.getProperty("first.game.score"));
		seedMatchesWaterFallPage.setSecondGameScoreEdit(testDataProp.getProperty("second.game.score"));
		seedMatchesWaterFallPage.clickOnSubmitButton();
		seedMatchesPage.hardWait(2);
		seedMatchesWaterFallPage.clickOnSubmitScoreButton();

		logger.info("Ending of verifyEditScoreAfterStandingTabIsDisplayed method");
	}

	@Test(priority = 31, description = "Verify three medals in standings tab", groups = "sanity")
	@Description("Test case #31, Verify three medals in standings tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #31, Verify three medals in standings tab")
	public void verifyThreeMedalsInStandingsTab() {
		logger.info("Starting of verifyThreeMedalsInStandingsTab method");
		seedMatchesWaterFallPage.hardWait(5);
		seedMatchesWaterFallPage.clickOnStandingTab();
		seedMatchesWaterFallPage.hardWait(5);
		Assert.assertTrue(seedMatchesWaterFallPage.isAllThreeMedalsDisplayed());

		logger.info("Ending of verifyThreeMedalsInStandingsTab method");
	}

	@Test(priority = 32, description = "Verify matches are edited label is displayed", groups = "sanity")
	@Description("Test case #32, Verify matches are edited label is displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #32, Verify matches are edited label is displayed")
	public void verifyMatcehsEditedLabelIsPresent() {
		logger.info("Starting of verifyMatcehsEditedLabelIsPresent method");

		seedMatchesWaterFallPage.hardWait(3);
		Assert.assertTrue(seedMatchesWaterFallPage.isTheMatchesLabelDisplayed());

		seedMatchesWaterFallPage.clickOnViewDrawsButton();
		seedMatchesWaterFallPage.hardWait(3);

		Assert.assertTrue(seedMatchesWaterFallPage.isTheMatchesLabelDisplayed());

		logger.info("Ending of verifyMatcehsEditedLabelIsPresent method");
	}

	@Test(priority = 33, description = "Verify creating WaterFall Event As Singles", groups = "sanity")
	@Description("Test case #33, Verify creating WaterFall Event As Singles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #33, Verify creating WaterFall Event As Singles")
	public void verifyCreatingWaterFallEventAsSingles() {
		logger.info("Starting of verifyCreatingWaterFallEventAsSingles method");

		seedMatchesPage.hardWait(3);
		// seedMatchesWaterFallPage.navigateBack();
		seedMatchesPage.hardWait(3);
		seedMatchesWaterFallPage.clickOnHomeMenu();
		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectSinglesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		seedMatchesPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		addEventPage.clickOnNextStepButton();

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.verifyPublishEventButton();

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(6);
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		seedMatchesPage.hardWait(3);
		addparticipantsPage.addParticipantsForWaterFall();

		addEventPage.hardWait(5);

		this.verifyCreateMatchesFuntionalityInSeedMatchesPage();

		addEventPage.hardWait(5);

		this.verifySavePublishFunctionalityInSeedMatchesPage();

		logger.info("Ending of verifyCreatingWaterFallEventAsSingles method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SEED_MATCHES_WATERFALL_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
