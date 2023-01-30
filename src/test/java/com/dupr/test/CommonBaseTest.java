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

	 Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
	}

	public void verifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of VerifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));

		addEventPage.isDisplayedRemoveAndReplaceContains();

		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("refund.policy"));

		addEventPage.setHealthandSafetyPolicyEdit(testDataProp.getProperty("health.and.safety"));

		addEventPage.clickonNextButton();

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

	public void VerifyFreeBracketWithEventTypeAsRoundRobin() {
		logger.info("Starting of VerifyFreeBracketWithEventTypeAsRoundRobin method");

		// addEventPage.clickonAddEventButton();

		event = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketListDisplayed());
		addBracketPage.clickOnDoublesBracketTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedBracketTypeDisplayed());

		addBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.clickOnMixedMatchGroupButton();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("age.range.minimum")));

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerate();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListDisplayed());
		addBracketPage.clickOnRoundRobinEventTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		// Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		// addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));

		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of VerifyFreeBracketWithEventTypeAsRoundRobin method");
	}

	public void VerifyFreeBracketWithEventSinglesTypeAsRoundRobin() {
		logger.info("Starting of VerifyFreeBracketWithEventSinglesTypeAsRoundRobin method");

		// addEventPage.clickonAddEventButton();

		event = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketListDisplayed());
		addBracketPage.clickOnSinglesBracketTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedBracketTypeDisplayed());

		addBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.clickOnOpenMatchButton();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("age.range.minimum")));

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerate();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListDisplayed());
		addBracketPage.clickOnRoundRobinEventTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		// Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		// addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));

		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();
		logger.info("Ending of VerifyFreeBracketWithEventSinglesTypeAsRoundRobin method");
	}

}
