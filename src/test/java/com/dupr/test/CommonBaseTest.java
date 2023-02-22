package com.dupr.test;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.pages.events.Create_Edit_Split_TeamPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.PaidEventPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.pages.home.ChatPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.pages.players.SearchPlayersPage;

public class CommonBaseTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CommonBaseTest.class.getName());

	protected AddAMatchPage addAMatchPage = null;
	protected SearchPlayersPage searchPlayersPage = null;
	protected BrowsePlayersPage browsePlayersPage = null;

	protected static String eventName = null;
	protected static String event = null;
	protected static String matchEvent = null;
	protected static float memberPrice;
	protected static float nonmemberPrice;
	protected static float bracketMember;
	protected static float bracketNonMember;
	protected static float totalNonMemberPrice;
	protected static float totalMemberPrice;

	protected AddEventPage addEventPage = null;
	protected AddBracketPage addBracketPage = null;
	protected ClubLogoPage clubLogoPage = null;
	protected MyClubsPage myClubsPage = null;
	protected BrowseClubsPage browseClubsPage = null;
	protected TimeZonePage timeZonePage = null;
	protected EditClubInfoPage editClubInfoPage = null;

	protected AddParticipantsInBracketsPage addparticipantsPage = null;
	protected Create_Edit_Split_TeamPage createTeams = null;
	protected ChatPage chatpage = null;
	protected UserDashboardPage userDashboardPage = null;
	protected EventRegistrationPage eventRegistrationPage = null;
	protected EventRegistrationPage directorEventRegistrationPage = null;
	protected PlayerEventRegistrationPage playerEventRegistrationPage = null;
	protected PaidEventPage paidEventPage = null;

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
		this.addparticipantsPage = new AddParticipantsInBracketsPage(this.driver);
		this.createTeams = new Create_Edit_Split_TeamPage(this.driver);
		this.chatpage = new ChatPage(this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		logger.info("Ending of initTest in CommonBaseTest");
	}

	public void verifySetMatchDetails() {
		logger.info("Starting of verifySetMatchDetails method");

		addAMatchPage.hardWait(3);
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));

		matchEvent = addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifySetMatchDetails method");
	}

	public void verifyAddAMatchInDoubles() {
		logger.info("Starting of verifyAddAMatchInDoubles method");

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.partner.name"));
		addAMatchPage.hardWait(3);
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.hardWait(3);
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.second.opponent.name"));
		addAMatchPage.hardWait(3);
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
		addAMatchPage.hardWait(3);
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
		addAMatchPage.hardWait(3);
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		logger.info("Starting of verifyAddAMatchInSinglesLossGame method");
	}

	public void verifyAddEventFunctionality() {
		logger.info("Starting of verifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		editClubInfoPage.clickOnSimbaOrganizerButton();
		addEventPage.clickOnAddEventButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		logger.info("Ending of verifyAddEventFunctionality method");
	}

	public void verifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of VerifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));

		Assert.assertTrue(addEventPage.isRemoveAndReplaceOptionsDisplayed());

		addEventPage.setRefundPolicy(testDataProp.getProperty("refund.policy"));
		addEventPage.setHealthAndSafetyPolicy(testDataProp.getProperty("health.policy"));

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

		addEventPage.clickOnAddEventButton();

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		memberPrice = addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		nonmemberPrice = addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
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
		addBracketPage.selectMixedPlayerGroup();

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
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		bracketMember = addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("paid.value"));
		bracketNonMember = addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("paid.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

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
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		bracketMember = addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("paid.value"));
		bracketNonMember = addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("paid.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketWithSinglesTypeAndRoundRobinEvent method");
	}

	public void verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup() {
		logger.info("Starting of verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup method");

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

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.setRegistrationStartDate();
		addBracketPage.setRegistrationEndDate();
		addBracketPage.setCompetitionStartDate();
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		bracketMember = addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("paid.value"));
		bracketNonMember = addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("paid.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setWaitlist(testDataProp.getProperty("number.of.courts"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("number.of.courts")));

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup method");
	}

	public void VerifyRecentlyAddedEventUnderEventsTab() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	public void verifyAddBracketsFunctionalityWithValidDetails() {
		logger.info("Starting of verifyAddBracketsFunctionalityWithValidDetails method");

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("min.age.range"));
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

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.setRegistrationStartDate();
		addBracketPage.setRegistrationEndDate();
		addBracketPage.setCompetitionStartDate();
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("wait.list")));

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyAddBracketsFunctionalityWithValidDetails method");
	}

	public void verifyEventInformationPageWithValidDetails() {
		logger.info("Starting of verifyEventInformationPageWithValidDetails method");

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));

		System.out.println("event name in Common base test: " + eventName);

		addEventPage.hardWait(2);
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(2);
		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of verifyEventInformationPageWithValidDetails method");
	}

	public void verifySelectAddParticipantFunctionality() {
		logger.info("Starting of verifySelectAddParticipantFunctionality method");

		addparticipantsPage.clickOnSelectParticipantRadioButton();

		Assert.assertTrue(addparticipantsPage.isParticipantSelected());

		addparticipantsPage.hardWait(3);
		addparticipantsPage.clickOnAddParticipantButton();
		addparticipantsPage.clickOnNoRadioButton();

		addparticipantsPage.clickOnAddButtonInClubMembershipPopup();

		logger.info("Ending of verifySelectAddParticipantFunctionality method");
	}

	public void verifyPaidEventInformationPageWithValidDetails() {
		logger.info("Starting of verifyPaidEventInformationPageWithValidDetails method");

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));

		System.out.println("event name in Common base test: " + eventName);

		addEventPage.hardWait(2);
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		memberPrice = addEventPage.setMemberPrice(testDataProp.getProperty("paid.value"));
		nonmemberPrice = addEventPage.setNonMemberPrice(testDataProp.getProperty("paid.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(4);
		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of verifyPaidEventInformationPageWithValidDetails method");
	}

	public void verifyPaidBracketWithEventTypeAsWateFallInDoublesMatchType() {
		logger.info("Starting of verifyPaidBracketWithEventTypeAsWateFall method");

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();

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

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));

		addBracketPage.hardWait(2);
		timeZonePage.setRegistrationStartDateBeforeOneDay();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("paid.value1"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("paid.value2"));

		Assert.assertTrue(addBracketPage.isNumberOfTeamsDisabledState());
		addBracketPage.hardWait(2);
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addEventPage.clickOnNextStepButton();

		addBracketPage.hardWait(3);
		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.VerifyPublishEventButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyPaidBracketWithEventTypeAsWateFall method");
	}

	public void verifyPaidBracketWithEventTypeAsWateFallInSinglesMatchType() {
		logger.info("Starting of verifyPaidBracketWithEventTypeAsWateFallInSinglesMatchType method");

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
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

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));

		addBracketPage.hardWait(2);
		timeZonePage.setRegistrationStartDateBeforeOneDay();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		bracketMember = addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("paid.value1"));
		bracketNonMember = addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("paid.value2"));
		totalMemberPrice = memberPrice + bracketMember;
		totalNonMemberPrice = nonmemberPrice + bracketNonMember;
		Assert.assertTrue(addBracketPage.isNumberOfTeamsDisabledState());
		addBracketPage.hardWait(2);
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addEventPage.clickOnNextStepButton();

		addBracketPage.hardWait(3);
		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.VerifyPublishEventButton();

		addBracketPage.hardWait(2);
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyPaidBracketWithEventTypeAsWateFallInSinglesMatchType method");
	}

	public void verifyRegisterFunctionality() {
		logger.info("Starting of verifyRegisterFunctionality method");

		eventRegistrationPage.clickOnRegisterButton();

		Assert.assertTrue(eventRegistrationPage.isBracketsCheckBoxesDisplayed());

		Assert.assertEquals(eventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(eventRegistrationPage.getRefundPolicyLabel(),
				expectedAssertionsProp.getProperty("refund.policy"));

		Assert.assertEquals(eventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		Assert.assertEquals(eventRegistrationPage.getLiabiltyPolicyLabel(),
				expectedAssertionsProp.getProperty("liabilty.policies"));

		Assert.assertTrue(eventRegistrationPage.isDisableRegisterButtonDisplayed());

		eventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(eventRegistrationPage.isRefundPolicyCheckboxSelected());

		eventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(eventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());

		eventRegistrationPage.clickOnLiabilityCheckbox();
		Assert.assertTrue(eventRegistrationPage.isLiabilityPolicyCheckboxSelected());

		Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnRegisterButton();

		Assert.assertEquals(eventRegistrationPage.getSuccessLabel(),
				expectedAssertionsProp.getProperty("success.text"));

		Assert.assertEquals(eventRegistrationPage.getRegistrationCompletedLabel(),
				expectedAssertionsProp.getProperty("registration.completed"));

		Assert.assertEquals(eventRegistrationPage.getOkLabel(), expectedAssertionsProp.getProperty("ok.text"));

		eventRegistrationPage.clickOnOkButton();

		logger.info("Ending of verifyRegisterFunctionality method");
	}

	public void verifyRegisterFunctionalityWithMemberInPlayerAccount() {
		logger.info("Starting of verifyRegisterFunctionalityWithMemberInPlayerAccount method");

		playerEventRegistrationPage.clickOnRegisterButtonInEventPage();

		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(playerEventRegistrationPage.getClubMembershipLabel(),
				expectedAssertionsProp.getProperty("club.membership"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		playerEventRegistrationPage.clickOnClubMemberYesButton();
		Assert.assertTrue(playerEventRegistrationPage.isClubMemberYesRadioButtonSelected());

		directorEventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		directorEventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnLiabilityCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());

		logger.info("Ending of verifyRegisterFunctionalityWithMemberInPlayerAccount method");
	}

	public void verifyRegisterFunctionalityWithNonMemberInPlayerAccount() {
		logger.info("Starting of verifyRegisterFunctionalityWithNonMemberInPlayerAccount method");

		playerEventRegistrationPage.clickOnRegisterButtonInEventPage();

		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(playerEventRegistrationPage.getClubMembershipLabel(),
				expectedAssertionsProp.getProperty("club.membership"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		playerEventRegistrationPage.clickOnClubMemberNoButton();

		directorEventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		directorEventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());
		try {
			directorEventRegistrationPage.clickOnLiabilityCheckbox();
			Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Ending of verifyRegisterFunctionalityWithNonMemberInPlayerAccount method");
	}
}
