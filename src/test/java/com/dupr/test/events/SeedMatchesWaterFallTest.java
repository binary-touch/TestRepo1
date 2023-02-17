package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.pages.events.SeedMatchesWaterFallPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Seed & Reseed WaterFall")
public class SeedMatchesWaterFallTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(SeedMatchesWaterFallTest.class.getName());
	private static String seedsEvents = null;

	private SeedMatchesPage seedMatchesPage = null;
	private SeedMatchesWaterFallPage seedMatchesWaterFallPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in SeedMatchesWaterFallPage");

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_WATERFALL_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		this.seedMatchesWaterFallPage = new SeedMatchesWaterFallPage(this.driver);

		logger.info("Ending of initMethod in SeedMatchesWaterFallPage");
	}

	@Test(priority = 1, description = "Verify creating WaterFall Event", groups = "sanity")
	@Description("Test case #1, Verify creating WaterFall Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify creating WaterFall Event")
	public void verifyCreatingWaterFallEvent() {
		logger.info("Starting of verifyCreatingWaterFallEvent method");

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
		seedMatchesPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("max.rating.range"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();
		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);

		logger.info("Ending of verifyCreatingWaterFallEvent method");
	}

	@Test(priority = 2, description = "Verify registration for the event", groups = "sanity")
	@Description("Test case #2, Verify registration for the event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify registration for the event")
	public void verifyRegistrationForAnEvent() {
		logger.info("Starting of verifyRegistrationForAnEvent method");

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

		logger.info("Ending of verifyRegistrationForAnEvent method");
	}

	@Test(priority = 3, description = "Verify the state of the Seed Matches button with less than 9 teams/players", groups = "sanity")
	@Description("Test case #3, Verify the state of the Seed Matches button with less than 9 teams/players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the state of the Seed Matches button with less than 9 teams/players")
	public void verifyStateOfSeedMatchesWithLessThan9TeamsOrPalyers() {
		logger.info("Starting of verifyStateOfSeedMatchesWithLessThan9TeamsOrPalyers method");

		Assert.assertTrue(seedMatchesWaterFallPage.isSeedMatchesButtonDisabled());

		logger.info("Ending of verifyStateOfSeedMatchesWithLessThan9TeamsOrPalyers method");
	}

	@Test(priority = 4, description = "Verify Adding Participants", groups = "sanity")
	@Description("Test case #4, Verify Adding Participants")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Adding Participants")
	public void verifyAddingParticipants() {
		logger.info("Starting of verifyAddingParticipants method");

		seedMatchesPage.hardWait(3);
		addparticipantsPage.addMeetForWaterFall(testDataProp.getProperty("player.name"));
		seedMatchesPage.hardWait(3);
		addparticipantsPage.addParticipantsForWaterFall();
		
		logger.info("Ending of verifyAddingParticipants method");
	}

	@Test(priority = 5, description = "Verify Adding Participants", groups = "sanity")
	@Description("Test case #5, Verify Adding Participants")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Adding Participants")
	public void verifyCreatingTeamInWaterFall() {
		logger.info("Starting of verifyCreatingTeamInWaterFall method");

		seedMatchesPage.hardWait(3);
		createTeams.selectTeamsInWaterFall();

		logger.info("Ending of verifyCreatingTeamInWaterFall method");
	}

	@Test(priority = 6, description = "Verify the state of the Seed Matches button with a minimum 9 teams/players ", groups = "sanity")
	@Description("Test case #6, Verify the state of the Seed Matches button with a minimum 9 teams/players ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the state of the Seed Matches button with a minimum 9 teams/players ")
	public void verifyStateOfSeedMatchesWithMinimun9TeamsOrPalyers() {
		logger.info("Starting of verifyStateOfSeedMatchesWithMinimun9TeamsOrPalyers method");

		seedMatchesPage.hardWait(3);
		Assert.assertFalse(seedMatchesWaterFallPage.isSeedMatchesButtonDisabled());

		logger.info("Ending of verifyStateOfSeedMatchesWithMinimun9TeamsOrPalyers method");
	}
}
