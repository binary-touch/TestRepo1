package com.b2b.test.sprint4.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.CombinationOfMatchTypeAndPlayerGroupPage;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic(value = "Events")
@Feature(value = "Combination Of Match Type And Player Group Sanity")
public class CombinationOfMatchTypeAndPlayerGroupTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(CombinationOfMatchTypeAndPlayerGroupTest.class.getName());
	private CombinationOfMatchTypeAndPlayerGroupPage combinationOfMatchTypeAndPlayerGroupPage = null;
	private SeedMatchesPage seedMatchesPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in CombinationOfMatchTypeAndPlayerGroupTest");

		this.driver = super.getWebDriver(WebDriversEnum.COMBINATION_OF_MATCHTYPE_AND_PLAYERGROUP_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		this.timeZonePage = new TimeZonePage(this.driver);
		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		this.combinationOfMatchTypeAndPlayerGroupPage = new CombinationOfMatchTypeAndPlayerGroupPage(this.driver);

		logger.info("Ending of initMethod in CombinationOfMatchTypeAndPlayerGroupTest");
	}

	@Test(priority = 1, description = "Verify Bracket With Match Type Single And Mixed Player Group", groups = "sanity")
	@Description("Test case #1, Verify Bracket With Match Type Single And Mixed Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Bracket With Match Type Single And Mixed Player Group")
	public void verifyBracketWithMatchTypeSingleAndMixedPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndMixedPlayerGroup method");

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isPlayerGroupWithSingleAndMixedDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndMixedPlayerGroup method");
	}

	@Test(priority = 2, description = "Verify Bracket With Match Type Single And Open Player Group", groups = "sanity")
	@Description("Test case #2, Verify Bracket With Match Type Single And Open Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Bracket With Match Type Single And Open Player Group")
	public void verifyBracketWithMatchTypeSingleAndOpenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");

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

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
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
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();

		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isOpenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");
	}

	@Test(priority = 3, description = "Verify Bracket With Match Type Single And Men Player Group", groups = "sanity")
	@Description("Test case #3, Verify Bracket With Match Type Single And Men Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Bracket With Match Type Single And Men Player Group")
	public void verifyBracketWithMatchTypeSingleAndMenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndMenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isMenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndMenPlayerGroup method");
	}

	@Test(priority = 4, description = "Verify Bracket With Match Type Single And Women Player Group", groups = "sanity")
	@Description("Test case #4, Verify Bracket With Match Type Single And Women Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Bracket With Match Type Single And Women Player Group")
	public void verifyBracketWithMatchTypeSingleAndWomenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndWomenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectWomenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isWomenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndWomenPlayerGroup method");
	}

	@Test(priority = 5, description = "Verify Bracket With Match Type Doubles And Mixed Player Group", groups = "sanity")
	@Description("Test case #5, Verify Bracket With Match Type Doubles And Mixed Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Bracket With Match Type Doubles And Mixed Player Group")
	public void verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesMixedCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup method");
	}

	@Test(priority = 6, description = "Verify Bracket With Match Type Doubles And Open Player Group", groups = "sanity")
	@Description("Test case #6, Verify Bracket With Match Type Doubles And Open Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Bracket With Match Type Doubles And Open Player Group")
	public void verifyBracketWithMatchTypeDoublesAndOpenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesAndOpenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectOpenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesOpenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesAndOpenPlayerGroup method");
	}

	@Test(priority = 7, description = "Verify Bracket With Match Type Doubles Men Player Group", groups = "sanity")
	@Description("Test case #7, Verify Bracket With Match Type Doubles Men Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Bracket With Match Type Doubles Men Player Group")
	public void verifyBracketWithMatchTypeDoublesMenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesMenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();

		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesMenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesMenPlayerGroup method");
	}

	@Test(priority = 8, description = "Verify Bracket With Match Type Doubles Women Player Group", groups = "sanity")
	@Description("Test case #8, Verify Bracket With Match Type Doubles Women Player Group")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Bracket With Match Type Doubles Women Player Group")
	public void verifyBracketWithMatchTypeDoublesWomenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesWomenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectWomenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());
//
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();
		//super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();

		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesWomenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesWomenPlayerGroup method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.COMBINATION_OF_MATCHTYPE_AND_PLAYERGROUP_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
