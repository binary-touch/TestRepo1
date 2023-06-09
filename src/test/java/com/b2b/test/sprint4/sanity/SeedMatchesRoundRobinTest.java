package com.b2b.test.sprint4.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Seed & Reseed Sanity")
public class SeedMatchesRoundRobinTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(SeedMatchesRoundRobinTest.class.getName());
	private static String seedsEvents = null;
	private SeedMatchesPage seedMatchesPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in SeedAndReseedTest");

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);

		logger.info("Ending of initMethod in SeedAndReseedTest");
	}

	@Test(priority = 1, description = "Verify the results on Click of seed Matches", groups = "sanity")
	@Description("Test case #1, Verify the results on Click of seed Matches")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the results on Click of seed Matches")
	public void verifyAddBracketWithRoundRobinEventType() {
		logger.info("Starting of verifyAddBracketWithRoundRobinEventType method");

		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		this.verifyFreeBracketDoublesTypeWithRoundRobinEventType();

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(seedsEvents);

		logger.info("Ending of verifyAddBracketWithRoundRobinEventType method");
	}

	@Test(priority = 2, description = "Verify Adding Participants", groups = "sanity")
	@Description("Test case #2, Verify Adding Participants")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Adding Participants")
	public void verifyAddingParticipantsFunctionality() {
		logger.info("Starting of verifyAddingParticipantsFunctionality method");

		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);
		addparticipantsPage.addParticipants();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyAddingParticipantsFunctionality method");
	}

	@Test(priority = 3, description = "Verify creating teams", groups = "sanity")
	@Description("Test case #3, Verify creating teams")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify creating teams")
	public void verifyCreatingTeamForAnRoundRobinEvent() {
		logger.info("Starting of verifyCreatingTeamForAnRoundRobinEvent method");

		createTeams.selectTeams();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnTeamsTab();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isSeedMatchesPageContains());
		seedMatchesPage.hardWait(5);
		logger.info("Ending of verifyCreatingTeamForAnRoundRobinEvent method");
	}

	@Test(priority = 4, description = "Verify the results on click of Create matches button", groups = "sanity")
	@Description("Test case #4, Verify the results on click of Create matches button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of Create matches button")
	public void verifyCreateMatchesFuntionality() {
		logger.info("Starting of verifyCreateMatchesFuntionality method");

		seedMatchesPage.hardWait(5);

		seedMatchesPage.clickOnCreateMatches();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublishButtonEnabled());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreateMatchesFuntionality method");
	}

	@Test(priority = 5, description = "Verify the results on click of Save & Publish button", groups = "sanity")
	@Description("Test case #5, Verify the results on click of Save & Publish button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click of Save & Publish button")
	public void verifySavePublishFunctionality() {
		logger.info("Starting of verifySavePublishFunctionality method");

		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifySavePublishFunctionality method");
	}

	@Test(priority = 6, description = "Verify the results on click of Reseed Matches", groups = "sanity")
	@Description("Test case #6, Verify the results on click of Reseed Matches")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on click of Reseed Matches")
	public void verifyReseedFunctionality() {
		logger.info("Starting of verifyReseedFunctionality method");

		seedMatchesPage.clickOnTeamsTab();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.withdrawTeam();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnReseedButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isRoundsDisplayed());
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublishButtonEnabled());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyReseedFunctionality method");
	}

	@Test(priority = 7, description = "Verify the results on click of Matches Tab", groups = "sanity")
	@Description("Test case #7, Verify the results on click of Matches Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the results on click of Matches Tab")
	public void verifyMatchesTabFunctionality() {
		logger.info("Starting of verifyMatchesTabFunctionality method");

		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isBracketHomePageDisplayed());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyMatchesTabFunctionality method");
	}

	@Test(priority = 8, description = "Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation", groups = "sanity")
	@Description("Test case #8, Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the Seed matches, Forfeit, Spit Team,& withdrawl/refund buttons are displyed before match validation")
	public void verifyBracketPageBeforeValidatingMatch() {
		logger.info("Starting of verifyBracketPageBeforeValidatingMatch method");

		seedMatchesPage.hardWait(5);
		Assert.assertTrue(seedMatchesPage.beforeValidateisBracketPageContains());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyBracketPageBeforeValidatingMatch method");
	}

	@Test(priority = 9, description = "Verify the results on click on Add Score in my matches page", groups = "sanity")
	@Description("Test case #9, Verify the results on click on Add Score in my matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the results on click on Add Score in my matches page")
	public void verifyAddScoreFunctionality() {
		logger.info("Starting of verifyAddScoreFunctionality method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.hardWait(120);
		seedMatchesPage.clickOnAddScoresButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isAddScoresPopUpContains());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyAddScoreFunctionality method");
	}

	@Test(priority = 10, description = "Verify the results of selecting the competition date", groups = "sanity")
	@Description("Test case #10, Verify the results of selecting the competition date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify the results of selecting the competition date")
	public void verifySelectingDateFunctionality() {
		logger.info("Starting of VerifySelectingDateFunctionality method");

		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnCalenderButton();

		seedMatchesPage.selectingMatchDate();

		Assert.assertTrue(seedMatchesPage.isDateSelected());

		logger.info("Ending of VerifySelectingDateFunctionality method");
	}

	@Test(priority = 11, description = "Verify the validation message by entering less than six in both the points fields", groups = "sanity")
	@Description("Test case #11, Verify the validation message by entering less than six in both the points fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify the validation message by entering less than six in both the points fields")
	public void verifyValidationMessageBySubmitingLessThanSixPoints() {
		logger.info("Starting of VerifyValidationMessageBySubmitingLessThanSixPoints method");

		seedMatchesPage.enterFirstGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));

		seedMatchesPage.clickOnSubmitButton();

		Assert.assertEquals(seedMatchesPage.getPointsValidationTxt(),
				expectedAssertionsProp.getProperty("points.validation.text"));

		logger.info("Ending of VerifyValidationMessageBySubmitingLessThanSixPoints method");
	}

	@Test(priority = 12, description = "Verify the results on click of Add Icon", groups = "sanity")
	@Description("Test case #12, Verify the results on click of Add Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify the results on click of Add Icon")
	public void verifyAddIconFunctionality() {
		logger.info("Starting of VerifyAddIconFunctionality method");

		seedMatchesPage.clickOnAddIcon();

		Assert.assertTrue(seedMatchesPage.isGameTwoDisplayed());

		logger.info("Ending of VerifyAddIconFunctionality method");
	}

	@Test(priority = 13, description = "Verify the Add Icon by adding three points fields", groups = "sanity")
	@Description("Test case #13, Verify the validation message by entering all zeros for one of the player")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify the validation message by entering all zeros for one of the player")
	public void verifyAddIconByAddingAllPointFields() {
		logger.info("Starting of verifyAddIconByAddingAllPointFields method");

		seedMatchesPage.enterFirstGamePlayerPoints(testDataProp.getProperty("valid.game.point"),
				testDataProp.getProperty("first.game.player.two.points"));

		seedMatchesPage.enterSecondGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));

		seedMatchesPage.clickOnAddIcon();

		seedMatchesPage.hardWait(3);

		seedMatchesPage.enterThirdGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));

		Assert.assertTrue(seedMatchesPage.isRemoveIconDisplayed());

		logger.info("Ending of verifyAddIconByAddingAllPointFields method");
	}

	@Test(priority = 14, description = "Verify the winners tag for winning players", groups = "sanity")
	@Description("Test case #14, Verify the winners tag for winning players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify the winners tag for winning players")
	public void verifyWinnersTagForWinningPlayes() {
		logger.info("Starting of verifyWinnersTagForWinningPlayes method");

		Assert.assertTrue(seedMatchesPage.isWinnerTagDisplayed());

		logger.info("Ending of verifyWinnersTagForWinningPlayes method");
	}

	@Test(priority = 15, description = "Verify the results on click of submit button by adding all three points field", groups = "sanity")
	@Description("Test case #15, Verify the results on click of submit button by adding all three points field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify the results on click of submit button by adding all three points field")
	public void verifySubmitFunctionality() {
		logger.info("Starting of VerifySubmitFunctionality method");

		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnSubmitButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSubmitButtonOnSubmitScores();

		logger.info("Ending of VerifySubmitFunctionality method");

	}

	@Test(priority = 16, description = "Verify the results on click on Edit Score button", groups = "sanity")
	@Description("Test case #16, Verify the results on click on Edit Score button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify the results on click on Edit Score button")
	public void verifyEditScoreFunctionality() {
		logger.info("Starting of VerifyEditScoreFunctionality method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnEditScoresButton();

		Assert.assertTrue(seedMatchesPage.isEditScoresPopUpContains());

		logger.info("Ending of VerifyEditScoreFunctionality method");
	}

	@Test(priority = 17, description = "Verify the results by editing the points of the players", groups = "sanity")
	@Description("Test case #17, Verify the results by editing the points of the players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify the results by editing the points of the players")
	public void verifyEditingScoresOfPlayers() {
		logger.info("Starting of VerifyEditingScoresOfPlayers method");

		seedMatchesPage.enterThirdGamePlayerPoints(testDataProp.getProperty("first.game.player.one.points"),
				testDataProp.getProperty("first.game.player.two.points"));

		Assert.assertTrue(seedMatchesPage.isWinnerTagDisplayed());

		logger.info("Ending of VerifyEditingScoresOfPlayers method");
	}

	@Test(priority = 18, description = "Verify the results on click on submit button", groups = "sanity")
	@Description("Test case #18, Verify the results on click on submit button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify the results on click on submit button")
	public void verifySubmitFunctionalityOnEditScores() {
		logger.info("Starting of VerifySubmitFunctionalityOnEditScores method");

		seedMatchesPage.clickOnSubmitButton();
		seedMatchesPage.clickOnSubmitScoresButton();

		Assert.assertFalse(seedMatchesPage.isEditScoresPopUpContains());

		logger.info("Ending of VerifySubmitFunctionalityOnEditScores method");
	}


	@Test(priority = 19, description = "Verifying the presence of the Standing Tab after validating match", groups = "sanity")
	@Description("Test case #19, Verifying the presence of the Standing Tab after validating match")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verifying the presence of the Standing Tab after validating match")
	public void verifyStandingTab() {
		logger.info("Starting of verifyStandingTab method");

		Assert.assertTrue(seedMatchesPage.isStandingsTabDisplayed());

		logger.info("Ending of verifyStandingTab method");
	}

	@Test(priority = 20, description = "Verify the results on click on the Forfeit Button", groups = "sanity")
	@Description("Test case #20, Verify the results on click on the Forfeit Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify the results on click on the Forfeit Button")
	public void verifyForfeitFunctionality() {
		logger.info("Starting of verifyForfeitFunctionality method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(2);
		seedMatchesPage.clickOnForfeitButon();

		Assert.assertTrue(seedMatchesPage.isForfeitMatchPopupContains());

		logger.info("Ending of verifyForfeitFunctionality method");
	}

	@Test(priority = 21, description = "Verify the results on selecting radio buttons of a team", groups = "sanity")
	@Description("Test case #21, Verify the results on selecting radio buttons of a team")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify the results on click on the Forfeit Button")
	public void verifyRadioButtonFunctionality() {
		logger.info("Starting of verifyRadioButtonFunctionality method");
		seedMatchesPage.hardWait(2);
		seedMatchesPage.clickOnFirstTeamRadioButton();

		Assert.assertTrue(seedMatchesPage.isFirstTeamRadioButtonSelected());

		logger.info("Ending of verifyRadioButtonFunctionality method");
	}

	@Test(priority = 22, description = "Verify results on the click of Mark as Forfeit button by selecting a radio buttons", groups = "sanity")
	@Description("Test case #22, Verify results on the click of Mark as Forfeit button by selecting a radio buttons")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #22, Verify results on the click of Mark as Forfeit button by selecting a radio buttons")
	public void verifyMarkAsForfeitButtonFunctionality() {
		logger.info("Starting of verifyMarkAsForfeitButtonFunctionality method");

		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnMarkAsForfeitButton();

		Assert.assertTrue(seedMatchesPage.isForfeitLabelDisabled());

		Assert.assertFalse(seedMatchesPage.isForfeitMatchPopupContains());

		logger.info("Ending of verifyMarkAsForfeitButtonFunctionality method");
	}

	@Test(priority = 23, description = "Verify Seed matches functionality with singles match type", groups = "sanity")
	@Description("Test case #23, Verify Seed matches functionality with singles match type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #23, Verify Seed matches functionality with singles match type")
	public void verifySeedMatchesFunctionalityWithSinglesMatchType() {
		logger.info("Starting of verifySeedMatchesFunctionalityWithSinglesMatchType method");

		seedMatchesPage.clickOnHomeMenu();

		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		seedMatchesPage.hardWait(3);
		seedsEvents = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectSinglesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());
		
		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("team.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		//seedMatchesPage.scrollUp();

		addBracketPage.hardWait(2);

		addEventPage.clickOnNextStepButton();
		addBracketPage.clickOnNoContinueToSummary();
		addBracketPage.clickOnPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(3);
		addEventPage.clickOnRecentlyAddedEvent(seedsEvents);
		seedMatchesPage.hardWait(3);

		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(3);

		addparticipantsPage.addParticipantsIntoRoundRobinSinglesMatch();
		seedMatchesPage.hardWait(3);

		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);

		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnCreateMatches();
		seedMatchesPage.hardWait(5);

		this.verifySavePublishFunctionality();

		logger.info("Ending of verifySeedMatchesFunctionalityWithSinglesMatchType method");
	}

	public void verifyFreeBracketDoublesTypeWithRoundRobinEventType() {
		logger.info("Starting of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");

		seedsEvents = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());
		
		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("team.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		//seedMatchesPage.scrollUp();

		addBracketPage.hardWait(2);

		addEventPage.clickOnNextStepButton();
		addBracketPage.clickOnNoContinueToSummary();
		addBracketPage.clickOnPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");
	}

	public void editRegistrationEndDate() {
		logger.info("Starting of editRegistrationEndDate method");

		seedMatchesPage.clickOnBracketCard();

		seedMatchesPage.clickOnEditBracketButton();

		seedMatchesPage.setRegistrationEndDate();

		seedMatchesPage.clickOnSaveChangesButon();

		seedMatchesPage.clickOnSimbaClub();

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(seedsEvents);
		
		logger.info("Ending of editRegistrationEndDate method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SEED_MATCHES_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
