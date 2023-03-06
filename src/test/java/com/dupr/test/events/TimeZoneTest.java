package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.pages.events.AddAnotherBracketPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TimeZoneTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(TimeZoneTest.class.getName());

	private MyClubsPage myClubsPage = null;
	private TimeZonePage timeZonePage = null;
	private static String RegStartDateTime = null;
	private static String RegEndDateTime = null;
	private static String CompStartDateTime = null;
	private static String CompEndDateTime = null;
	private static String TimeZone = null;
	private static String TimeZone2 = null;

	private static String s1 = null;
	private static String s2 = null;
	private static String s3 = null;
	private static String s4 = null;
	private AddAnotherBracketPage addAnotherBracketPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in TimeZoneTest");

		this.driver = super.getWebDriver(WebDriversEnum.TIME_ZONE_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.myClubsPage = new MyClubsPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);
		this.addAnotherBracketPage = new AddAnotherBracketPage(this.driver);

		logger.info("Ending of initMethod in TimeZoneTest");
	}

	@Test(priority = 1, description = "verifyRegistrationCompetitionDateFields", groups = "sanity")
	@Description("Test case #1, verifyRegistrationCompetitionDateFields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, verifyRegistrationCompetitionDateFields")
	public void verifyRegistrationCompetitionDateFields() {
		logger.info("Starting of verifyRegistrationCompetitionDateFields method");

		super.verifyAddEventFunctionality();
		addBracketPage.hardWait(3);
		super.verifyEventInformationPageWithValidDetails();
		System.out.println("event name in Timezone test: " + eventName);
		addBracketPage.hardWait(3);
		this.verifyEventPoliciesPageByEnteringValidDetails();

		Assert.assertTrue(timeZonePage.isDisplayedRegistrationandCompetitionFieldslContains());

		logger.info("Ending of verifyRegistrationCompetitionDateFields method");
	}

	@Test(priority = 2, description = "verifySelectRegistrationDateAndTime", groups = "sanity")
	@Description("Test case #2, verifySelectRegistrationDateAndTime")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, verifySelectRegistrationDateAndTime")
	public void verifySelectRegistrationDateAndTime() {
		logger.info("Starting of verifySelectRegistrationDateAndTime method");

		addBracketPage.setRegistrationStartDate();
		RegStartDateTime = timeZonePage.getRegistrationStartDateTimeText();

		addBracketPage.setRegistrationEndDate();
		RegEndDateTime = timeZonePage.getRegistrationEndDateTimeValue();

		addBracketPage.setCompetitionStartDate();
		CompStartDateTime = timeZonePage.getCompetitionStartDateTimeValue();

		addBracketPage.setCompetitionEndDate();
		CompEndDateTime = timeZonePage.getCompetitionEndDateTimeValue();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();
		TimeZone = timeZonePage.getIndianTimeZoneText();

		logger.info("Ending of verifySelectRegistrationDateAndTime method");
	}

	@Test(priority = 3, description = "verifyRegistrationCompetitionDateAndTimeInSummeryPage", groups = "sanity")
	@Description("Test case #3, verifyRegistrationCompetitionDateAndTimeInSummeryPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verifyRegistrationCompetitionDateAndTimeInSummeryPage")
	public void verifyRegistrationCompetitionDateAndTimeInSummaryPage() {
		logger.info("Starting of verifyRegistrationCompetitionDateAndTimeInSummaryPage method");

		super.verifyAddBracketsFunctionalityWithValidDetails();

		super.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		logger.info("Ending of verifyRegistrationCompetitionDateAndTimeInSummaryPage method");
	}

	@Test(priority = 4, description = "verifyPublishedEventInEventTabAndBrowseEvents", groups = "sanity")
	@Description("Test case #4, verifyPublishedEventInEventTabAndBrowseEvents")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verifyPublishedEventInEventTabAndBrowseEvents")
	public void verifyPublishedEventInEventTabAndBrowseEvents() {
		logger.info("Starting of verifyPublishedEventInEventTabAndBrowseEvents method");

		String RegStartDateTimeInEventDetails = timeZonePage.getRegStartInEventDetails();

		System.out.println(RegStartDateTime);
		System.out.println(RegStartDateTimeInEventDetails);

		Assert.assertSame(RegStartDateTime, RegStartDateTimeInEventDetails);

		String RegEndDateTimeInEventDetails = timeZonePage.getRegEndDateInEventDetails();

		System.out.println(RegEndDateTime);
		System.out.println(RegEndDateTimeInEventDetails);

		Assert.assertEquals(RegEndDateTime, RegEndDateTimeInEventDetails);

		String ComStartDateTimeInEventDetails = timeZonePage.getCompStartDaeInEventDetails();

		System.out.println(CompStartDateTime);
		System.out.println(ComStartDateTimeInEventDetails);

		Assert.assertEquals(CompStartDateTime, ComStartDateTimeInEventDetails);

		String CompEndDateTimeInEventDetails = timeZonePage.getCompEndDateInEventDetails();

		System.out.println(CompEndDateTime);
		System.out.println(CompEndDateTimeInEventDetails);

		Assert.assertEquals(CompEndDateTime, CompEndDateTimeInEventDetails);

		String TimeZoneInEventDetails = timeZonePage.getIndianTimeZoneInEventDetails();
		Assert.assertEquals(TimeZone, TimeZoneInEventDetails);

		this.verifyPublishEventButton();

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		myClubsPage.clickOnBackArrowIcon();

		logger.info("Ending of verifyPublishedEventInEventTabAndBrowseEvents method");
	}

	@Test(priority = 5, description = "verifyAddAnotherBracketInAddEventFunctionality", groups = "sanity")
	@Description("Test case #5, verifyAddAnotherBracketInAddEventFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verifyAddAnotherBracketInAddEventFunctionality")
	public void verifyAddAnotherBracketInAddEventFunctionality() {
		logger.info("Starting of verifyAddAnotherBracketInAddEventFunctionality method");

		addEventPage.clickOnAddEventButton();
		addBracketPage.hardWait(3);
		super.verifyEventInformationPageWithValidDetails();
		addBracketPage.hardWait(3);
		this.verifyEventPoliciesPageByEnteringValidDetails();
		super.verifyAddBracketsFunctionalityWithValidDetails();

		addBracketPage.clickOnAddAnotherBracketButton();

		addAnotherBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addAnotherBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addAnotherBracketPage.setAgeRangeMinimum(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addAnotherBracketPage.setAgeRangeMaximum(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addAnotherBracketPage.setRatingRangeMinimum(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addAnotherBracketPage.setRatingRangeMaximum(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		addAnotherBracketPage.clickOnAutoGenerate();

		addAnotherBracketPage.clickOnEventTypeDropdown();
		addAnotherBracketPage.hardWait(3);
		addBracketPage.selectRoundRobinEvent();
		addAnotherBracketPage.hardWait(3);

		addAnotherBracketPage.clickOnRegistrationStartDate();

		addAnotherBracketPage.hardWait(3);
		addAnotherBracketPage.clickOnRegistrationEndDate();

		addAnotherBracketPage.hardWait(3);
		addAnotherBracketPage.clickOnCompetitionStartDate();

		addAnotherBracketPage.hardWait(3);
		addAnotherBracketPage.clickOnCompetitionEndDate();

		addAnotherBracketPage.hardWait(3);
		addAnotherBracketPage.clickOnTimeZoneDropdown();
		String TimeZoneInEventDetails = addAnotherBracketPage.getTimeZoneText();

		addAnotherBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("zero.value"));
		addAnotherBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addAnotherBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.courts"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed(testDataProp.getProperty("number.of.courts")));

		addAnotherBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("wait.list")));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddAnotherBracketPopUpContains());

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		TimeZone2 = timeZonePage.getArizonaTimeZoneInEventDetails();
		Assert.assertEquals(TimeZone2, TimeZoneInEventDetails);

		logger.info("Ending of verifyAddAnotherBracketInAddEventFunctionality method");
	}

	@Test(priority = 6, description = "verifyAddABracketInAddEventFunctionality", groups = "sanity")
	@Description("Test case #6, verifyAddABracketInAddEventFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verifyAddABracketInAddEventFunctionality")
	public void verifyAddABracketInAddEventFunctionality() {
		logger.info("Starting of verifyAddABracketInAddEventFunctionality method");

		this.verifyPublishEventButton();

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		timeZonePage.clickOnAddABracketButton();
		Assert.assertTrue(timeZonePage.isDisplayedRegistrationandCompetitionFieldslContains());

		logger.info("Ending of verifyAddABracketInAddEventFunctionality method");
	}

	@Test(priority = 7, description = "verifyRegistrationFieldsWithAddABracketFunctionality", groups = "sanity")
	@Description("Test case #7, verifyRegistrationFieldsWithAddABracketFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, verifyRegistrationFieldsWithAddABracketFunctionality")
	public void verifyRegistrationFieldsWithAddABracketFunctionality() {
		logger.info("Starting of verifyRegistrationFieldsWithAddABracketFunctionality method");

		addBracketPage.setRegistrationStartDate();
		RegStartDateTime = timeZonePage.getRegistrationStartDateTimeText();

		addBracketPage.setRegistrationEndDate();
		RegEndDateTime = timeZonePage.getRegistrationEndDateTimeValue();

		logger.info("Ending of verifyRegistrationFieldsWithAddABracketFunctionality method");
	}

	@Test(priority = 8, description = "verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality", groups = "sanity")
	@Description("Test case #8, verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality")
	public void verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality() {
		logger.info("Starting of verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality method");

		addBracketPage.clickOnMatchTypeDropDownInAddABracket();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();

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
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("wait.list")));

		timeZonePage.clickOnPublishButton();
		timeZonePage.isDisplayedSuccessPopUpInAddABracketContains();
		timeZonePage.clickOnSuccessPopUpCloseButton();
		timeZonePage.isMixedDoubleBracketBracketDisplayed();

		logger.info("Ending of verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality method");
	}

	@Test(priority = 9, description = "verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality", groups = "sanity")
	@Description("Test case #9, verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality")
	public void verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality() {
		logger.info(
				"Starting of verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality method");

		timeZonePage.clickOnAddABracketButton();

		addBracketPage.clickOnMatchTypeDropDownInAddABracket();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();

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
		addBracketPage.hardWait(2);
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		addBracketPage.hardWait(3);
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));

		timeZonePage.clickOnPublishButton();

		Assert.assertTrue(addBracketPage.isRegCompAndTimeFieldsWithEmptyDetailsDisplayed());

		logger.info(
				"Ending of verifyRegistraionAndCompetitionAndTimeZoneFieldsWithEmptyAddABracketFunctionality method");
	}

	@Test(priority = 10, description = "verifyRegistraionFieldsInEditBracketFunctionality", groups = "sanity")
	@Description("Test case #10, verifyRegistraionFieldsInEditBracketFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, verifyRegistraionFieldsInEditBracketFunctionality")
	public void verifyRegistraionFieldsInEditBracketFunctionality() {
		logger.info("Starting of verifyRegistraionFieldsInEditBracketFunctionality method");

		addEventPage.clickonExitButton();

		timeZonePage.clickOnMixedDoubleBracket();

		timeZonePage.clickOnEditBracketButton();

		Assert.assertTrue(addBracketPage.isRegstartDateDisplayed());
		Assert.assertTrue(addBracketPage.isRegEndDateDisplayed());
		Assert.assertTrue(addBracketPage.isCompstartDateDisplayed());
		Assert.assertTrue(addBracketPage.isCompEndDateDisplayed());
		Assert.assertTrue(addBracketPage.isTimeZoneDropdownDisplayed());

		s1 = addBracketPage.getRegistrationStartDateText();
		System.out.println((s1));
		addBracketPage.setRegistrationEndDate();
		s3 = addBracketPage.getRegistrationEndDateText();
		System.out.println((s3));
		addBracketPage.setRegistrationStartDate();

		addBracketPage.clickOnSaveChangesButton();
		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateBeforeTwoDays();
		
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionEndDateBeforeOneDay();

		s2 = addBracketPage.getRegistrationStartDateText();
		System.out.println((s2));
		Assert.assertNotSame(s1, s2);

		addBracketPage.clickOnSaveChangesButton();
		timeZonePage.clickOnEditBracketButton();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateBeforeTwoDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateBeforeOneDay();

		s4 = addBracketPage.getRegistrationEndDateText();
		System.out.println((s4));
		Assert.assertNotSame(s3, s4);

		timeZonePage.clickOnSaveChangesButton();

		logger.info("Ending of verifyRegistraionFieldsInEditBracketFunctionality method");
	}

	@Test(priority = 11, description = "Verify Competition and TimeZone fields in Edit Bracket functionality", groups = "sanity")
	@Description("Test case #11, Verify Competition and TimeZone fields in Edit Bracket functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Competition and TimeZone fields in Edit Bracket functionality")
	public void verifyCompetitionAndTimeZoneFieldsInEditBracketFunctionality() {
		logger.info("Starting of verifyCompetitionAndTimeZoneFieldsInEditBracketFunctionality method");

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDate();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDate();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDate();
	
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.setTimeZone();

		Assert.assertTrue(addBracketPage.isRegstartDateDisplayed());
		Assert.assertTrue(addBracketPage.isRegEndDateDisplayed());
		Assert.assertTrue(addBracketPage.isCompstartDateDisplayed());
		Assert.assertTrue(addBracketPage.isCompEndDateDisplayed());
		Assert.assertTrue(addBracketPage.isTimeZoneDropdownDisplayed());

		String s5 = addBracketPage.getCompetitionStartDateText();
		addBracketPage.setCompetitionStartDate();
		String s7 = addBracketPage.getCompetitionEndDateText();
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnSaveChangesButton();
		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateBeforeTwoDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateBeforeOneDay();

		String s6 = addBracketPage.getCompetitionStartDateText();
		Assert.assertNotSame(s5, s6);

		addBracketPage.clickOnSaveChangesButton();
		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateBeforeTwoDays();
		
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionEndDateBeforeOneDay();

		String s8 = addBracketPage.getCompetitionEndDateText();
		Assert.assertNotSame(s7, s8);

		addBracketPage.setTimeZone();
		String s9 = addBracketPage.getTimeZoneText();

		addBracketPage.clickOnSaveChangesButton();
		timeZonePage.clickOnEditBracketButton();

		addBracketPage.setArizonaTimeZone();
		String s10 = addBracketPage.getTimeZoneText();
		Assert.assertNotSame(s9, s10);

		timeZonePage.clickOnSaveChangesButton();

		logger.info("Ending of verifyCompetitionAndTimeZoneFieldsInEditBracketFunctionality method");
	}

	
	@Test(priority = 12, description = "Verify Registration Local Date Range in Bracket Page", groups = "sanity")
	@Description("Test case #12, Verify Registration Local Date Range in Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Registration Local Date Range in Bracket Page")
	public void verifyRegistrationLocalDateRangeInBracketPage() {
		logger.info("Starting of verifyRegistrationLocalDateRangeInBracketPage method");

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationStartDateBeforeOneDay();
		
		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationEndDate();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		timeZonePage.clickOnSaveChangesButton();

		Assert.assertTrue(timeZonePage.isLocalRangeDisplayed());

		Assert.assertTrue(timeZonePage.isLessthenSevenRelativeDaysDisplayed());

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		
		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationEndDateBeforeThreeDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		timeZonePage.clickOnSaveChangesButton();
		timeZonePage.hardWait(4);
		Assert.assertFalse(timeZonePage.isLessthenSevenRelativeDaysDisplayed());

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDate();
		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationEndDateInHour();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		timeZonePage.clickOnSaveChangesButton();

		Assert.assertTrue(timeZonePage.ishoursAndMinsDisplayed());

		Assert.assertTrue(timeZonePage.isOpenUpcommingRegistrationClosedStatusDisplayed());

		logger.info("Ending of verifyRegistrationLocalDateRangeInBracketPage method");
	}

	@Test(priority = 13, description = "Verify Competition Local date range in Bracket page", groups = "sanity")
	@Description("Test case #13, Verify Competition Local date range in Bracket page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Competition Local date range in Bracket page")
	public void verifyCompetitionLocalDateRangeInBracketPage() {
		logger.info("Starting of verifyCompetitionLocalDateRangeInBracketPage method");

		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentEndDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionEndDateInHour();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		timeZonePage.clickOnSaveChangesButton();

		Assert.assertTrue(timeZonePage.isLocalRangeDisplayed());
		Assert.assertTrue(timeZonePage.isLessthenSevenRelativeDaysDisplayed());

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		timeZonePage.clickOnSaveChangesButton();
		timeZonePage.hardWait(4);
		Assert.assertFalse(timeZonePage.isLessthenSevenRelativeDaysDisplayed());

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentEndDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionEndDateInHour();
		addBracketPage.hardWait(3);
		timeZonePage.clickOnSaveChangesButton();
		Assert.assertTrue(timeZonePage.ishoursAndMinsDisplayed());

		Assert.assertTrue(timeZonePage.isOpenUpcommingRegistrationClosedStatusDisplayed());

		logger.info("Ending of verifyCompetitionLocalDateRangeInBracketPage method");
	}

	@Test(priority = 14, description = "VerifyRegOPenUpcommingRegistrationClosedStatuInBracketPage", groups = "sanity")
	@Description("Test case #14, verifyRegOPenUpcommingRegistrationClosedStatuInBracketPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, verifyRegOPenUpcommingRegistrationClosedStatuInBracketPage")
	public void verifyRegistrationOpenUpcomingClosedStatuInBracketPage() {
		logger.info("Starting of verifyRegistrationOpenUpcomingClosedStatuInBracketPage method");

		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDate();
		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationEndDateInHour();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		timeZonePage.clickOnSaveChangesButton();

		Assert.assertTrue(timeZonePage.isLocalRangeDisplayed());
		Assert.assertTrue(timeZonePage.isLessthenSevenRelativeDaysDisplayed());

		timeZonePage.clickOnEditBracketButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		timeZonePage.clickOnSaveChangesButton();
		timeZonePage.hardWait(4);
		Assert.assertFalse(timeZonePage.isLessthenSevenRelativeDaysDisplayed());
		
		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDate();
		addBracketPage.hardWait(3);
		timeZonePage.setRegistrationEndDateInHour();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(3);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		timeZonePage.clickOnSaveChangesButton();

		Assert.assertTrue(timeZonePage.ishoursAndMinsDisplayed());
		Assert.assertTrue(timeZonePage.isOpenUpcommingRegistrationClosedStatusDisplayed());

		logger.info("Ending of verifyRegistrationOpenUpcomingClosedStatuInBracketPage method");
	}

	@Test(priority = 15, description = "verifyCompOPenUpcommingRegistrationClosedStatuInBracketPage", groups = "sanity")
	@Description("Test case #15, verifyCompOPenUpcommingRegistrationClosedStatuInBracketPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, verifyCompOPenUpcommingRegistrationClosedStatuInBracketPage")
	public void verifyCompOpenUpcomingRegistrationClosedStatusInBracketPage() {
		logger.info("Starting of verifyCompOpenUpcommingRegistrationClosedStatuInBracketPage method");

		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentEndDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionEndDateInHour();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.clickOnNewDelhiTimeZone();

		timeZonePage.clickOnSaveChangesButton();
		Assert.assertTrue(timeZonePage.isLocalRangeDisplayed());
		Assert.assertTrue(timeZonePage.isLessthenSevenRelativeDaysDisplayed());
		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionStartDateMoreThenSevenDays();
		addBracketPage.hardWait(4);
		addBracketPage.setCompetitionEndDateMoreThenSevenDays();

		timeZonePage.clickOnSaveChangesButton();
		timeZonePage.hardWait(4);
		Assert.assertFalse(timeZonePage.isLessthenSevenRelativeDaysDisplayed());


		timeZonePage.clickOnEditBracketButton();
		addBracketPage.hardWait(3);
		
		addBracketPage.setRegistrationStartDateBeforeFourDays();
		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationEndDateBeforeThreeDays();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionCurrentEndDate();
		addBracketPage.hardWait(3);
		timeZonePage.setCompetitionEndDateInHour();
		addBracketPage.hardWait(3);
		timeZonePage.clickOnSaveChangesButton();
		Assert.assertTrue(timeZonePage.ishoursAndMinsDisplayed());

		Assert.assertTrue(timeZonePage.isOpenUpcommingRegistrationClosedStatusDisplayed());

		logger.info("Ending of verifyCompOpenUpcommingRegistrationClosedStatuInBracketPage method");
	}

	@Test(priority = 16, description = "Verify Important Dates in Information Tab", groups = "sanity")
	@Description("Test case #16, Verify Important Dates in Information Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify Important Dates in Information Tab")
	public void verifyImportantDatesInInformationTab() {
		logger.info("Starting of verifyImportantDatesInInformationTab method");
		
		addBracketPage.hardWait(3);
		timeZonePage.clickOnInformationButton();
		Assert.assertTrue(timeZonePage.isTimeZoneInformationDisplayed());
		Assert.assertTrue(timeZonePage.isRegistrationInformationDisplayed());
		Assert.assertTrue(timeZonePage.isCompetitionInformationDisplayed());

		logger.info("Ending of verifyImportantDatesInInformationTab method");
	}

	@Test(priority = 17, description = "Verify Competition Date Range in Event Card", groups = "sanity")
	@Description("Test case #17, Verify Competition Date Range in Event Card")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify Competition Date Range in Event Card")
	public void verifyCompetitionDateRangeInEventCard() {
		logger.info("Starting of verifyCompetitionDateRangeInEventCard method");
		
		addBracketPage.hardWait(3);
		timeZonePage.clickOnHomeButton();
		addBracketPage.hardWait(3);
		timeZonePage.clickOnMyEventsButton();

		Assert.assertTrue(timeZonePage.isCompRangeDisplayed());

		logger.info("Ending of verifyCompetitionDateRangeInEventCard method");
	}

	@Test(priority = 18, description = "Verify Register Button According to Relative Days", groups = "sanity")
	@Description("Test case #18, Verify Register Button According to Relative Days")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify Register Button According to Relative Days")
	public void verifyRegisterButtonAccordingToRelativeDays() {
		logger.info("Starting of verifyRegisterButtonAccordingToRelativeDays method");

		addBracketPage.hardWait(3);
		timeZonePage.clickOnCompRangeEventCard();
		addBracketPage.hardWait(3);
		timeZonePage.clickOnAddABracketButton();
		addBracketPage.hardWait(3);
		this.verifyCompetitionAndTimeZoneFieldsWithAddABracketFunctionality();

		Assert.assertTrue(timeZonePage.isRegisterDisplayed());

		logger.info("Ending of verifyRegisterButtonAccordingToRelativeDays method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.TIME_ZONE_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
