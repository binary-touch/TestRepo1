package com.dupr.test;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.pages.players.SearchPlayersPage;

public class CommonBaseTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CommonBaseTest.class.getName());

	protected AddAMatchPage addAMatchPage = null;
	protected SearchPlayersPage searchPlayersPage = null;
	protected BrowsePlayersPage browsePlayersPage = null;
	protected static String eventName = null;
	protected AddEventPage addEventPage = null;
	protected AddBracketPage addBracketPage = null;
	protected ClubLogoPage clubLogoPage = null;
	protected EditClubInfoPage editClubInfoPage = null;
	protected static String event = null;

	public void initCommonBaseTest(String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initTest in CommonBaseTest");

		this.siteLogin(siteURL, email, password, this.driver);

		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.browsePlayersPage = new BrowsePlayersPage(this.driver);
		this.searchPlayersPage = new SearchPlayersPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		logger.info("Ending of initTest in CommonBaseTest");
	}

	public void verifySetMatchDetails() {
		logger.info("Starting of verifySetMatchDetails method");

		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));

		eventName = addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifySetMatchDetails method");
	}

	public void verifyAddAMatchInDoubles() {
		logger.info("Starting of verifyAddAMatchInDoubles method");

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.partner.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.second.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Starting of verifyAddAMatchInDoubles method");
	}

	public void verifyAddAMatchInSinglesWonGame() {
		logger.info("Starting of verifyAddAMatchInSinglesWonGame method");

		addAMatchPage.clickOnSinglesButton();

		addAMatchPage.clickOnAddOpponentButton();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamtwo.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.hardWait(2);

		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		logger.info("Starting of verifyAddAMatchInDoubles method");
	}

	public void verifyAddAMatchInSinglesLossGame() {
		logger.info("Starting of verifyAddAMatchInSinglesLossGame method");

		addAMatchPage.clickOnSinglesButton();

		addAMatchPage.clickOnAddOpponentButton();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		logger.info("Starting of verifyAddAMatchInSinglesLossGame method");
	}

	public void VerifyAddEventFunctionality() {
		logger.info("Starting of VerifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		editClubInfoPage.clickOnSimbaOrganizerButton();
		addEventPage.clickonAddEventButton();

	 Assert.assertTrue(addEventPage.isEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
	}

	public void verifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of VerifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage
				.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));

		 Assert.assertTrue(addEventPage.isRemoveAndReplaceOptionsDisplayed());

		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("refund.policy"));

		addEventPage.setHealthAndSafetyPolicyEdit(testDataProp.getProperty("health.and.safety"));

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of VerifyEventPoliciesPageByEnteringValidDetails method");
	}

	public void VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");

		addBracketPage.clickOnNoContinueToSummary();

		// driver.navigate().refresh();
		Assert.assertTrue(addBracketPage.isEventDetailsSectionDisplayed());
		Assert.assertTrue(addBracketPage.isEventPoliciesSectionDisplayed());
		Assert.assertTrue(addBracketPage.isBracketsSectionDisplayed());

		logger.info("Ending of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");
	}

	public void VerifyPublishEventButton() {
		logger.info("Starting of VerifyPublishEventButton method");

		addBracketPage.clickOnPublishEventButton();

		Assert.assertTrue(addBracketPage.isPublishSuccessPopUpContains());

		logger.info("Ending of VerifyPublishEventButton method");
	}

	public void verifyFreeBracketWithRoundRobinEventType() {
		logger.info("Starting of verifyFreeBracketWithRoundRobinEventType method");

		event = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		// Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		// addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("number.of.courts"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketWithRoundRobinEventType method");
	}

	public void verifyFreeBracketWithSinglesTypeAndRoundRobinEvent() {
		logger.info("Starting of verifyFreeBracketWithSinglesTypeAndRoundRobinEvent method");

		event = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectOpenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		// Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		// addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("number.of.courts"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();
		
		logger.info("Ending of verifyFreeBracketWithSinglesTypeAndRoundRobinEvent method");
	}
}
