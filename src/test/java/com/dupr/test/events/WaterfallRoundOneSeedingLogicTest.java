package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.pages.events.SeedMatchesWaterFallPage;
import com.dupr.pages.events.WaterfallRoundOneSeedingLogicPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WaterfallRoundOneSeedingLogicTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(SeedMatchesWaterFallTest.class.getName());
	private SeedMatchesPage seedMatchesPage = null;
	private SeedMatchesWaterFallPage seedMatchesWaterFallPage = null;
	private WaterfallRoundOneSeedingLogicPage waterfallRoundOneSeedingLogicPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in SeedMatchesWaterFallPage");

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_WATERFALL_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		this.seedMatchesWaterFallPage = new SeedMatchesWaterFallPage(this.driver);
		this.waterfallRoundOneSeedingLogicPage = new WaterfallRoundOneSeedingLogicPage(this.driver);

		logger.info("Ending of initMethod in SeedMatchesWaterFallPage");
	}

	// @Test(priority = 1, description = "Verify creating WaterFall Event As
	// Singles", groups = "sanity")
	@Description("Test case #1, Verify creating WaterFall Event As Singles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify creating WaterFall Event As Singles")
	public void verifyCreatingWaterFallEventAsSingles() {
		logger.info("Starting of verifyCreatingWaterFallEventAsSingles method");

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
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();
		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreatingWaterFallEventAsSingles method");
	}

	@Test(priority = 2, description = "Verify Adding Participants in waterfall event", groups = "sanity")
	@Description("Test case #2, Verify Adding Participants in waterfall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Adding Participants in waterfall event")
	public void verifyAddingParticipantsInWaterFallEvent() {
		logger.info("Starting of verifyAddingParticipantsInWaterFallEvent method");

		seedMatchesPage.hardWait(3);
		// addparticipantsPage.addMeetForWaterFall(testDataProp.getProperty("player.name"));
		// seedMatchesPage.hardWait(3);
		waterfallRoundOneSeedingLogicPage.getSinglesRating();

		logger.info("Ending of verifyAddingParticipantsInWaterFallEvent method");
	}

	@Test(priority = 3, description = "Verify Adding Participants in waterfall event", groups = "sanity")
	@Description("Test case #2, Verify Adding Participants in waterfall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Adding Participants in waterfall event")
	public void verifyAddingPacipantsInWaterFallEvent() {
		logger.info("Starting of verifyAddingParticipantsInWaterFallEvent method");

		seedMatchesPage.hardWait(3);
		addparticipantsPage.addMeetForWaterFall(testDataProp.getProperty("player.name"));
		// seedMatchesPage.hardWait(3);
		waterfallRoundOneSeedingLogicPage.getSinglesRating();

		logger.info("Ending of verifyAddingParticipantsInWaterFallEvent method");
	}
}
