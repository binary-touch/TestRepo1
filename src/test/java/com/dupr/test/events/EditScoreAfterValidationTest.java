package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EditScoreAfterValidationPage;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EditScoreAfterValidationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(EditScoreAfterValidationTest.class.getName());

	private EditScoreAfterValidationPage editScoreAfterValidationPage = null;
	private SeedMatchesPage seedMatchesPage = null;
	private String FirstGameScore = null;
	private String SecondGameScore = null;
	private static String seedEvents = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EditScoreAfterValidationTest");

		this.driver = super.getWebDriver(WebDriversEnum.CHAT_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		this.editScoreAfterValidationPage = new EditScoreAfterValidationPage(this.driver);
		this.seedMatchesPage = new SeedMatchesPage(this.driver);

		logger.info("Ending of initMethod in EditScoreAfterValidationTest");
	}

	// @Test(priority = 1, description = "Verify the results on click of edit
	// button")
	@Description("Test case #1, Verify the results on click of edit button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1, Verify the results on click of edit button")
	public void verifyEditScore() {
		logger.info("Starting of verifyEditScore method");

		FirstGameScore = editScoreAfterValidationPage.getFirstGameScoreText();
		SecondGameScore = editScoreAfterValidationPage.getSecondGameScoreText();

		// editScoreAfterValidationPage.clickOnEditScore();

		String editScoresText = this.editScoreAfterValidationPage.getEditScoreText();
		Assert.assertEquals(editScoresText, expectedAssertionsProp.getProperty("edit.score.label"));

		String matchDateText = this.editScoreAfterValidationPage.getMatchDateText();
		Assert.assertEquals(matchDateText, expectedAssertionsProp.getProperty("match.date.label"));

		String submitButtonText = this.editScoreAfterValidationPage.getSubmitButtonText();
		Assert.assertEquals(submitButtonText, expectedAssertionsProp.getProperty("submit.button.label"));

		Assert.assertTrue(editScoreAfterValidationPage.isCrossIconDisplayed());

		logger.info("Ending of verifyEditScore method");
	}

	// @Test(priority = 2, description = "Verify To edit Game Score")
	@Description("Test case #2, Verify To edit Game Score")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2, Verify To edit Game Score ")
	public void verifyToSetGameScore() {
		logger.info("Starting of verifyToSetGameScore method");

		editScoreAfterValidationPage.setFirstGameScoreEdit(testDataProp.getProperty("first.game.score"));
		editScoreAfterValidationPage.setSecondGameScoreEdit(testDataProp.getProperty("second.game.score"));
		editScoreAfterValidationPage.clickOnSubmitButton();

		logger.info("Ending of verifyToSetGameScore method");
	}

	// @Test(priority = 3, description = "Verify the results on click of Go Back
	// button")
	@Description("Test case #3, Verify the results on click of Go Back button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #3, Verify the results on click of Go Back button")
	public void verifyGoBackFeature() {
		logger.info("Starting of verifyGoBackFeature method");

		String editScoresText = this.editScoreAfterValidationPage.getSubmittingNewScoresText();
		Assert.assertEquals(editScoresText, expectedAssertionsProp.getProperty("submitting.new.scores"));

		String matchDateText = this.editScoreAfterValidationPage.getSubmitScoresButtonText();
		Assert.assertEquals(matchDateText, expectedAssertionsProp.getProperty("submit.scores.button.label"));

		String submitButtonText = this.editScoreAfterValidationPage.getGoBackText();
		Assert.assertEquals(submitButtonText, expectedAssertionsProp.getProperty("go.back.label"));

		Assert.assertTrue(editScoreAfterValidationPage.isCrossIconDisplayed());

		editScoreAfterValidationPage.clickOnGoBack();

		logger.info("Ending of verifyGoBackFeature method");
	}

	// @Test(priority = 4, description = "Verify to Submit new Score")
	@Description("Test case #4, Verify login to Submit new Score")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify to Submit new Score")
	public void verifyToSubmittingNewScore() {
		logger.info("Starting of verifyToSubmittingNewScore method");

		editScoreAfterValidationPage.hardWait(2);
		Assert.assertFalse(editScoreAfterValidationPage.isSubmittingNewScoresLabelDisplayed());

		editScoreAfterValidationPage.clickOnSubmitButton();

		editScoreAfterValidationPage.clickOnSubmitScoreButton();

		logger.info("Ending of verifyToSubmittingNewScore method");
	}

	// @Test(priority = 5, description = "Verify to validate Game Score after the
	// edit")
	@Description("Test case #5, Verify to validate Game Score after the edit")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify to validate Game Score after the edit")
	public void verifyToValidateGameScore() {
		logger.info("Starting of verifyToValidateGameScore method");

		Assert.assertFalse(editScoreAfterValidationPage.isEditScoreDisplayed());

		String firstGameScore = this.editScoreAfterValidationPage.getFirstGameScoreText();
		Assert.assertNotEquals(firstGameScore, FirstGameScore);

		String secondScore = this.editScoreAfterValidationPage.getSecondGameScoreText();
		Assert.assertNotEquals(secondScore, SecondGameScore);

		logger.info("Ending of verifyToValidateGameScore method");
	}

	public void verifyFreeBracketDoublesTypeWithRoundRobinEventType() {
		logger.info("Starting of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");

		seedEvents = addEventPage.setEventName(testDataProp.getProperty("event.name"));
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
		seedMatchesPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("team.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		addEventPage.clickOnNextStepButton();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNoContinueToSummary();
		addBracketPage.clickOnPublishEventButton();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnEventSuccessClosePopupButton();
		addBracketPage.hardWait(2);

		logger.info("Ending of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");
	}

	@Test(priority = 6, description = "Verify the results on Click of seed Matches", groups = "sanity")
	@Description("Test case #6, Verify the results on Click of seed Matches")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on Click of seed Matches")
	public void verifySeedMatchesFuntionality() {
		logger.info("Starting of verifySeedMatchesFuntionality method");

		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		this.verifyFreeBracketDoublesTypeWithRoundRobinEventType();

		seedMatchesPage.hardWait(2);
		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(2);
		addEventPage.clickOnRecentlyAddedEvent(seedEvents);
		seedMatchesPage.hardWait(3);

		// Register to an Free Bracket
		seedMatchesPage.registerEvent();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnHomeMenu();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnMyClubsCard();
		addEventPage.hardWait(5);

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(seedEvents);
		addEventPage.hardWait(5);

		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);
		addparticipantsPage.addParticipants();
		seedMatchesPage.hardWait(5);
		createTeams.selectTeams();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifySeedMatchesFuntionality method");
	}

	@Test(priority = 7, description = "Verify the results on click of Create matches button", groups = "sanity")
	@Description("Test case #7, Verify the results on click of Create matches button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the results on click of Create matches button")
	public void verifyCreateMatchesFuntionality() {
		logger.info("Starting of verifyCreateMatchesFuntionality method");

		seedMatchesPage.clickOnTeamsTab();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(5);
		Assert.assertTrue(seedMatchesPage.isSeedMatchesPageContains());
		seedMatchesPage.hardWait(5);

		Assert.assertEquals(seedMatchesPage.getClickText(), expectedAssertionsProp.getProperty("click.text"));
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublisbButtonDisabled());
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnCreateMatches();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isRoundsDisplayed());
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isPublishButtonEnabled());
		seedMatchesPage.hardWait(5);

		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isBracketHomePageDisplayed());

		logger.info("Ending of verifyCreateMatchesFuntionality method");
	}

	@Test(priority = 8, description = "Verify the results on click on Add Score in my matches page", groups = "sanity")
	@Description("Test case #8, Verify the results on click on Add Score in my matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the results on click on Add Score in my matches page")
	public void verifyAddScoreFunctionality() {
		logger.info("Starting of verifyAddScoreFunctionality method");

		seedMatchesPage.hardWait(60);
		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.clickOnAddScoresButton();
		seedMatchesPage.hardWait(5);

		Assert.assertTrue(seedMatchesPage.isAddScoresPopUpContains());
		seedMatchesPage.hardWait(5);

		Assert.assertEquals(seedMatchesPage.getAddScoresTxt(), expectedAssertionsProp.getProperty("add.scores.text"));
		seedMatchesPage.hardWait(5);
		Assert.assertEquals(seedMatchesPage.getMatchDateTxt(), expectedAssertionsProp.getProperty("match.date.text"));
		seedMatchesPage.hardWait(5);

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

		logger.info("Ending of verifyAddScoreFunctionality method");
	}

	@Test(priority = 9, description = "Verify To Validate Edit and Forfeit buttons", groups = "sanity")
	@Description("Test case #9, Verify To Validate Edit and Forfeit buttons")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify To Validate Edit and Forfeit buttons")
	public void verifyValidateEditAndForfeit() {
		logger.info("Starting of verifyValidateEditAndForfeit method");

		Assert.assertTrue(editScoreAfterValidationPage.isEditButtonDisplayed());
		Assert.assertTrue(editScoreAfterValidationPage.isForfeitButtonDisplayed());

		logger.info("Ending of verifyValidateEditAndForfeit method");
	}

	@Test(priority = 10, description = "Verify To edit Game Score")
	@Description("Test case #10, Verify To edit Game Score")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #10, Verify To edit Game Score ")
	public void verifyEditGameScore() {
		logger.info("Starting of verifyToSetGameScore method");

		this.verifyEditScore();
		this.verifyToSetGameScore();
		this.verifyGoBackFeature();
		this.verifyToValidateGameScore();

		logger.info("Ending of verifyToSetGameScore method");
	}

	@Test(priority = 11, description = "Verify the results on click on the Forfeit Button", groups = "sanity")
	@Description("Test case #11, Verify the results on click on the Forfeit Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify the results on click on the Forfeit Button")
	public void verifyForfeitFunctionality() {
		logger.info("Starting of verifyForfeitFunctionality method");

		seedMatchesPage.clickOnMatchesTab();
		seedMatchesPage.hardWait(5);
		seedMatchesPage.clickOnForfeitButon();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnFirstTeamRadioButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnMarkAsForfeitButton();

		logger.info("Ending of verifyForfeitFunctionality method");
	}

	@Test(priority = 12, description = "Verify to validate Game Score after the edit")
	@Description("Test case #12, Verify to validate Game Score after the edit")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify to validate Game Score after the edit")
	public void verifyTobValidateGameScore() {

		logger.info("Starting of verifyToValidateGameScore method");
		String firstGameScore = this.editScoreAfterValidationPage.getFirstGameScoreText();
		Assert.assertNotEquals(firstGameScore, FirstGameScore);
		String secondScore = this.editScoreAfterValidationPage.getSecondGameScoreText();
		Assert.assertNotEquals(secondScore, SecondGameScore);

		logger.info("Ending of verifyToValidateGameScore method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADDAMATCH_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
