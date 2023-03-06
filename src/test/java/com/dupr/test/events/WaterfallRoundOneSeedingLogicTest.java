package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_WATERFALL_ROUND_ONE_LOGIC_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		this.seedMatchesWaterFallPage = new SeedMatchesWaterFallPage(this.driver);
		this.waterfallRoundOneSeedingLogicPage = new WaterfallRoundOneSeedingLogicPage(this.driver);

		logger.info("Ending of initMethod in SeedMatchesWaterFallPage");
	}

	@Test(priority = 1, description = "Verify creating WaterFall Event As Singles", groups = "sanity")
	@Description("Test case #1, Verify creating WaterFall Event As Singles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify creating WaterFall Event As Singles")
	public void verifyCreatingWaterFallEventWithSinglesMatchType() {
		logger.info("Starting of verifyCreatingWaterFallEventWithSinglesMatchType method");

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
		addBracketPage.setWaitlist(testDataProp.getProperty("zero.value"));

		addEventPage.clickOnNextStepButton();

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.verifyPublishEventButton();
		
		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreatingWaterFallEventWithSinglesMatchType method");
	}

	@Test(priority = 2, description = "Verify Adding Participants in waterfall event", groups = "sanity")
	@Description("Test case #2, Verify Adding Participants in waterfall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Adding Participants in waterfall event")
	public void verifyAddingParticipantsInWaterFallEvent() {
		logger.info("Starting of verifyAddingParticipantsInWaterFallEvent method");

		seedMatchesPage.hardWait(3);
		addparticipantsPage.addMeetPlayerForWaterFallEvent(testDataProp.getProperty("player.name"));
		seedMatchesPage.hardWait(3);
		addparticipantsPage.addMeetPlayerForWaterFallEvent(testDataProp.getProperty("provisional.rating.player"));
		seedMatchesPage.hardWait(3);
		waterfallRoundOneSeedingLogicPage.getSinglesRating();

		logger.info("Ending of verifyAddingParticipantsInWaterFallEvent method");
	}

	@Test(priority = 3, description = "Verify Sorting players as High to low rating", groups = "sanity")
	@Description("Test case #3, Verify Sorting players as High to low rating")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Sorting players as High to low rating")
	public void verifySortingplayersAsRatingHighToLow() {
		logger.info("Starting of verifySortingplayersAsRatingHighToLow method");

		waterfallRoundOneSeedingLogicPage.clickOnSortButton();
		waterfallRoundOneSeedingLogicPage.selectHighToLowRadioButton();
		waterfallRoundOneSeedingLogicPage.hardWait(3);
		waterfallRoundOneSeedingLogicPage.getPlayerName();

		logger.info("Ending of verifySortingplayersAsRatingHighToLow method");
	}

	@Test(priority = 4, description = "Verify the results on click of Create matches button in Seed Matches page", groups = "sanity")
	@Description("Test case #4, Verify the results on click of Create matches button in Seed Matches page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of Create matches button in Seed Matches page")
	public void verifyCreateMatchesFuntionalityInSeedMatchesPage() {
		logger.info("Starting of verifyCreateMatchesFuntionalityInSeedMatchesPage method");

		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnSeedMatchesButton();
		seedMatchesPage.hardWait(3);
		seedMatchesPage.clickOnCreateMatches();
		seedMatchesPage.hardWait(4);

		Assert.assertTrue(seedMatchesPage.isRoundOneDisplayed());
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreateMatchesFuntionalityInSeedMatchesPage method");
	}

	@Test(priority = 5, description = "Verify round one seeding logic of Waterfall event", groups = "sanity")
	@Description("Test case #5, Verify round one seeding logic of Waterfall event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify round one seeding logic of Waterfall event")
	public void verifyWaterFallRoundOneSeedingLogic() {
		logger.info("Starting of verifyWaterFallRoundOneSeedingLogic method");

		waterfallRoundOneSeedingLogicPage.getRoundOnePlayersName();
		seedMatchesPage.hardWait(4);
		
		waterfallRoundOneSeedingLogicPage.printnames();

		Assert.assertTrue(waterfallRoundOneSeedingLogicPage.WaterFallRoundOneSeedingLogic());
		seedMatchesPage.hardWait(3);
		
		seedMatchesPage.clickOnSavePublishButton();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyWaterFallRoundOneSeedingLogic method");
	}
	
	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SEED_MATCHES_WATERFALL_ROUND_ONE_LOGIC_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
