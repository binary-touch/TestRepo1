package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Events")
@Feature(value = "Director Event Registration Sanity")
public class DirectorEventRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(DirectorEventRegistrationTest.class.getName());
	private EventRegistrationPage eventRegistrationPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in DirectorEventRegistrationTest");

		this.driver = super.getWebDriver(WebDriversEnum.EVENT_REGISTRATION_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.eventRegistrationPage = new EventRegistrationPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);

		logger.info("Ending of initMethod in DirectorEventRegistrationTest");
	}

	/*
	 * @Test(priority = 1, description = "Verify Events Tab for Open Status Event",
	 * groups = "sanity")
	 * 
	 * @Description("Test case #1, Verify Events Tab for Open Status Event")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #1, Verify Events Tab for Open Status Event") public void
	 * verifyEventsTabForOpenStatusEvent() {
	 * logger.info("Starting of verifyEventsTabForOpenStatusEvent method");
	 * 
	 * super.verifyAddEventFunctionality();
	 * super.verifyFreeBracketWithSinglesTypeAndRoundRobinEvent();
	 * addEventPage.hardWait(3); addEventPage.clickOnEventsTab();
	 * addEventPage.hardWait(3);
	 * 
	 * Assert.assertTrue(this.eventRegistrationPage.isEventLogosDisplayed());
	 * Assert.assertTrue(this.eventRegistrationPage.isEventNameDisplayed());
	 * Assert.assertTrue(this.eventRegistrationPage.isEventLocationDisplayed());
	 * Assert.assertTrue(this.eventRegistrationPage.isEventCompetitionDatesDisplayed
	 * ()); addEventPage.hardWait(3);
	 * Assert.assertTrue(this.eventRegistrationPage.isEventStatusesDisplayed());
	 * Assert.assertTrue(this.eventRegistrationPage.isDeleteEventDisplayed());
	 * 
	 * logger.info("Ending of verifyEventsTabForOpenStatusEvent method"); }
	 * 
	 * @Test(priority = 2, description =
	 * "Verify Details displayerd on Event Card With Open Status", groups =
	 * "sanity")
	 * 
	 * @Description("Test case #2, Verify Details displayerd on Event Card With Open Status"
	 * )
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #2, Verify Details displayerd on Event Card With Open Status"
	 * ) public void verifyDetailsDisplayedOnEventCardWithOpenStatus() { logger.
	 * info("Starting of verifyDetailsDisplayedOnEventCardWithOpenStatus method");
	 * 
	 * addEventPage.clickOnEventName(eventName);
	 * 
	 * Assert.assertTrue(eventRegistrationPage.isEventPageContains());
	 * 
	 * logger.
	 * info("Ending of verifyDetailsDisplayedOnEventCardWithOpenStatus method"); }
	 * 
	 * @Test(priority = 3, description = "Verify Register Functionality", groups =
	 * "sanity")
	 * 
	 * @Description("Test case #3, Verify Register Functionality")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #3, Verify Register Functionality") public void
	 * verifyRegisterFunctionality() {
	 * logger.info("Starting of verifyRegisterFunctionality method");
	 * 
	 * eventRegistrationPage.clickOnRegisterButton();
	 * 
	 * Assert.assertTrue(eventRegistrationPage.isBracketsCheckBoxesDisplayed());
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getEventRegistrationLabel(),
	 * expectedAssertionsProp.getProperty("event.registration.text"));
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getRefundPolicyLabel(),
	 * expectedAssertionsProp.getProperty("refund.policy"));
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getHealthAndSafetyLabel(),
	 * expectedAssertionsProp.getProperty("health.and.safety"));
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getLiabiltyPolicyLabel(),
	 * expectedAssertionsProp.getProperty("liabilty.policies"));
	 * 
	 * Assert.assertTrue(eventRegistrationPage.isDisableRegisterButtonDisplayed());
	 * 
	 * logger.info("Ending of verifyRegisterFunctionality method"); }
	 * 
	 * @Test(priority = 4, description =
	 * "Verify Event Registration Back Button Functionality", groups = "sanity")
	 * 
	 * @Description("Test case #4, Verify Event Registration Back Button Functionality"
	 * )
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #4, Verify Event Registration Back Button Functionality")
	 * public void verifyEventRegistrationBackButtonFunctionality() { logger.
	 * info("Starting of verifyEventRegistrationBackButtonFunctionality method");
	 * 
	 * eventRegistrationPage.clickOnEventRegistrationBackButton();
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getEventLabel(),
	 * expectedAssertionsProp.getProperty("event.text"));
	 * 
	 * Assert.assertTrue(eventRegistrationPage.isEventPageContains());
	 * 
	 * eventRegistrationPage.clickOnRegisterButton();
	 * 
	 * logger.info("Ending of verifyEventRegistrationBackButtonFunctionality method"
	 * ); }
	 * 
	 * @Test(priority = 5, description =
	 * "Verify the results on selecting Bracket checkbox functionality under Select your Brackets for Singles Bracket"
	 * , groups = "sanity")
	 * 
	 * @Description("Test case #5, Verify the results on selecting Bracket checkbox functionality under Select your Brackets for Singles Bracket"
	 * )
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #5, Verify the results on selecting Bracket checkbox functionality under Select your Brackets for Singles Bracket"
	 * ) public void verifySelectYourBracketCheckboxFunctionality() {
	 * logger.info("Starting of verifySelectYourBracketCheckboxFunctionality method"
	 * );
	 * 
	 * eventRegistrationPage.clickOnSelectYourBracketCheckbox();
	 * 
	 * Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());
	 * 
	 * eventRegistrationPage.clickOnSelectYourBracketCheckbox();
	 * 
	 * Assert.assertFalse(eventRegistrationPage.isBracketCheckboxSelected());
	 * 
	 * logger.info("Ending of verifySelectYourBracketCheckboxFunctionality method");
	 * }
	 * 
	 * @Test(priority = 6, description =
	 * "Verify League Policy Checkbox Functionality", groups = "sanity")
	 * 
	 * @Description("Test case #6, Verify League Policy Checkbox Functionality")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #6, Verify League Policy Checkbox Functionality") public
	 * void verifyLeaguePolicyCheckboxFunctionality() {
	 * logger.info("Starting of verifyLeaguePolicyCheckboxFunctionality method");
	 * 
	 * eventRegistrationPage.clickOnSelectYourBracketCheckbox();
	 * Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());
	 * 
	 * eventRegistrationPage.clickOnRefundPolicyCheckbox();
	 * Assert.assertTrue(eventRegistrationPage.isRefundPolicyCheckboxSelected());
	 * 
	 * eventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
	 * Assert.assertTrue(eventRegistrationPage.isHealthSafetyPolicyCheckboxSelected(
	 * ));
	 * 
	 * eventRegistrationPage.clickOnLiabilityCheckbox();
	 * Assert.assertTrue(eventRegistrationPage.isLiabilityPolicyCheckboxSelected());
	 * 
	 * logger.info("Ending of verifyLeaguePolicyCheckboxFunctionality method"); }
	 * 
	 * @Test(priority = 7, description =
	 * "Verify Register Functionality in Event Registration Page", groups =
	 * "sanity")
	 * 
	 * @Description("Test case #7, Verify Register Functionality in Event Registration Page"
	 * )
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #7, Verify Register Functionality in Event Registration Page"
	 * ) public void verifyRegisterFunctionalityInEventRegistrationPage() { logger.
	 * info("Starting of verifyRegisterFunctionalityInEventRegistrationPage method"
	 * );
	 * 
	 * eventRegistrationPage.clickOnRegisterButton();
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getSuccessLabel(),
	 * expectedAssertionsProp.getProperty("success.text"));
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getRegistrationCompletedLabel(),
	 * expectedAssertionsProp.getProperty("registration.completed"));
	 * 
	 * Assert.assertEquals(eventRegistrationPage.getOkLabel(),
	 * expectedAssertionsProp.getProperty("ok.text"));
	 * 
	 * eventRegistrationPage.clickOnOkButton();
	 * 
	 * logger.
	 * info("Ending of verifyRegisterFunctionalityInEventRegistrationPage method");
	 * }
	 */

	@Test(priority = 8, description = "Verify Register Functionality in Registration Closed Event", groups = "sanity")
	@Description("Test case #8, Verify Register Functionality in Registration Closed Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Register Functionality in Registration Closed Event")
	public void verifyRegisterFunctionalityInRegistrationClosedEvent() {
		logger.info("Starting of verifyRegisterFunctionalityInRegistrationClosedEvent method");

		super.verifyAddEventFunctionality();

		super.verifyFreeBracketWithSinglesTypeAndRoundRobinEvent();

		addEventPage.clickOnEventsTab();

		Assert.assertFalse(eventRegistrationPage.isRegisterButtonDisplayedForRegistrationClosedEventCard());

		logger.info("Ending of verifyRegisterFunctionalityInRegistrationClosedEvent method");
	}

	@Test(priority = 9, description = "Verify Register Functionality in Upcoming Event", groups = "sanity")
	@Description("Test case #9, Verify Register Functionality in Upcoming Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Register Functionality in Upcoming Event")
	public void verifyRegisterFunctionalityInUpcomingEvent() {
		logger.info("Starting of verifyRegisterFunctionalityInUpcomingEvent method");

		addBracketPage.hardWait(3);
		addBracketPage.clickOnBackButton();
		addBracketPage.hardWait(3);

		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

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

		eventRegistrationPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		eventRegistrationPage.setRegistrationEndDate();

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

		super.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		super.verifyPublishEventButton();

		addBracketPage.hardWait(3);
		addEventPage.clickOnEventsTab();

		Assert.assertFalse(eventRegistrationPage.isRegisterButtonDisplayedForUpcomingEventCard());

		logger.info("Ending of verifyRegisterFunctionalityInUpcomingEvent method");
	}

	// @Test(priority = 10, description = "Verify Register Functionality In Ongoing
	// Event", groups = "sanity")
	@Description("Test case #10, Verify Register Functionality In Ongoing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Register Functionality In Ongoing Event")
	public void verifyRegisterFunctionalityInOngoingEvent() {
		logger.info("Starting of verifyRegisterFunctionalityInOngoingEvent method");

		addBracketPage.hardWait(3);

		Assert.assertFalse(eventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard());

		logger.info("Ending of verifyRegisterFunctionalityInOngoingEvent method");
	}

	@Test(priority = 11, description = "Verify Register Functionality In Complete status Event", groups = "sanity")
	@Description("Test case #11, Verify Register Functionality In Complete status Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Register Functionality In Complete status Event")
	public void verifyRegisterFunctionalityInCompletedStatusEvent() {
		logger.info("Starting of verifyRegisterFunctionalityInCompletedStatusEvent method");

		addBracketPage.hardWait(3);
		Assert.assertFalse(eventRegistrationPage.isRegisterButtonDisplayedForCompletedEventCard());

		logger.info("Ending of verifyRegisterFunctionalityInCompletedStatusEvent method");
	}

	@Test(priority = 12, description = "Verify Register Functionality In Open Registered Player Event", groups = "sanity")
	@Description("Test case #12, Verify Register Functionality In Complete EventVerify Register Functionality In Open Registered Player Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12 , Verify Register Functionality In Open Registered Player Event")
	public void verifyRegisterFunctionalityInOpenRegisteredPlayerEvent() {
		logger.info("Starting of verifyRegisterFunctionalityInOpenRegisteredPlayerEvent method");

		addBracketPage.hardWait(3);
		Assert.assertFalse(eventRegistrationPage.isRegisterButtonDisplayedForOpenEventCard());

		logger.info("Ending of verifyRegisterFunctionalityInOpenRegisteredPlayerEvent method");
	}

	/*
	 * @Test(priority = 13, description =
	 * "Verify Register Functionality with Open Double Bracket", groups = "sanity")
	 * 
	 * @Description("Test case #13, Verify Register Functionality with Open Double Bracket"
	 * )
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Test case #13, Verify Register Functionality with Open Double Bracket"
	 * ) public void verifyRegisterFunctionalityWithOpenDoubleBracket() { logger.
	 * info("Starting of verifyRegisterFunctionalityWithOpenDoubleBracket method");
	 * 
	 * addBracketPage.hardWait(3); super.verifyAddEventFunctionality();
	 * super.verifyFreeBracketWithRoundRobinEventType();
	 * 
	 * addEventPage.clickOnEventsTab();
	 * Assert.assertTrue(addEventPage.isRecentlyAddedEventDisplayed(eventName));
	 * 
	 * this.verifyRegisterFunctionality();
	 * this.verifyEventRegistrationBackButtonFunctionality();
	 * this.verifySelectYourBracketCheckboxFunctionality();
	 * this.verifyLeaguePolicyCheckboxFunctionality();
	 * this.verifyRegisterFunctionalityInEventRegistrationPage();
	 * this.verifyRegisterFunctionalityInRegistrationClosedEvent();
	 * 
	 * logger.
	 * info("Ending of verifyRegisterFunctionalityWithOpenDoubleBracket method"); }
	 */

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EVENT_REGISTRATION_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
