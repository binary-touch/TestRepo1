package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.DirectorEventRegistrationPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class DirectorEventRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(DirectorEventRegistrationTest.class.getName());
	DirectorEventRegistrationPage directorEventRegistrationPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in EditClubInfoTest");

		this.driver = super.getWebDriver(WebDriversEnum.EVENT_REGISTRATION_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.directorEventRegistrationPage = new DirectorEventRegistrationPage(this.driver);

		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Register Functionality With FreeEvent And Bracket", groups = "sanity")
	@Description("Test case #1, Verify Register Functionality With FreeEvent And Bracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Register Functionality With FreeEvent And Bracket")
	public void VerifyRegisterFunctionalityWithFreeEventAndBracket() {
		logger.info("Starting of VerifyRegisterFunctionalityWithFreeEventAndBracket method");

		this.VerifyAddEventFunctionality();
		this.verifyFreeBracketWithSinglesTypeAndRoundRobinEvent();

		addEventPage.clickOnEventsTab();

		logger.info("Ending of VerifyRegisterFunctionalityWithFreeEventAndBracket method");
	}

	@Test(priority = 2, description = "Verify Event Card Functionality With Open Status", groups = "sanity")
	@Description("Test case #2, Verify Event Card Functionality With Open Status")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Event Card Functionality With Open Status")
	public void VerifyEventCardFunctionalityWithOpenStatus() {
		logger.info("Starting of VerifyEventCardFunctionalityWithOpenStatus method");

		addEventPage.clickOnEventName(event);

		// Assert.assertEquals(directorEventRegistrationPage.getEventLabel(),expectedAssertionsProp.getProperty("event.text"));

		Assert.assertTrue(directorEventRegistrationPage.isDisplayedEventPageContains());

		logger.info("Ending of VerifyEventCardFunctionalityWithOpenStatus method");
	}

	@Test(priority = 3, description = "Verify Register Functionality", groups = "sanity")
	@Description("Test case #3, Verify Register Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Register Functionality")
	public void VerifyRegisterFunctionality() {
		logger.info("Starting of VerifyRegisterFunctionality method");

		directorEventRegistrationPage.clickonRegisterButton();

		Assert.assertTrue(directorEventRegistrationPage.isCheckBoxDisplayed());

		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("Event.registration"));
		Assert.assertEquals(directorEventRegistrationPage.getRefundPolicyLabel(),
				expectedAssertionsProp.getProperty("refund.policy"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));
		Assert.assertEquals(directorEventRegistrationPage.getLiabiltyPolicyLabel(),
				expectedAssertionsProp.getProperty("liabilty.policies"));

		Assert.assertTrue(directorEventRegistrationPage.isRegisterButtonDisplayed());

		logger.info("Ending of VerifyRegisterFunctionality method");
	}

	@Test(priority = 4, description = "Verify Event Registration Back Button Functionality", groups = "sanity")
	@Description("Test case #4, Verify Event Registration Back Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Registration Back Button Functionality")
	public void VerifyEventRegistrationBackButtonFunctionality() {
		logger.info("Starting of VerifyEventRegistrationBackButtonFunctionality method");

		directorEventRegistrationPage.clickonEventRegistrationBackButton();

		Assert.assertEquals(directorEventRegistrationPage.getEventLabel(),
				expectedAssertionsProp.getProperty("event.text"));

		Assert.assertTrue(directorEventRegistrationPage.isDisplayedEventPageContains());

		directorEventRegistrationPage.clickonRegisterButton();

		logger.info("Ending of VerifyEventRegistrationBackButtonFunctionality method");
	}

	@Test(priority = 5, description = "Verify Select Your Bracket Checkbox Functionality", groups = "sanity")
	@Description("Test case #5, Verify Select Your Bracket Checkbox Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Select Your Bracket Checkbox Functionality")
	public void VerifySelectYourBracketCheckboxFunctionality() {
		logger.info("Starting of VerifyEventRegistrationBackButtonFunctionality method");

		directorEventRegistrationPage.clickonSelectYourBracketCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		directorEventRegistrationPage.clickonSelectYourBracketCheckbox();

		Assert.assertFalse(directorEventRegistrationPage.isBracketCheckboxSelected());

		logger.info("Ending of VerifyEventRegistrationBackButtonFunctionality method");
	}

	@Test(priority = 6, description = "Verify League Policy Checkbox Functionality", groups = "sanity")
	@Description("Test case #6, Verify League Policy Checkbox Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify League Policy Checkbox Functionality")
	public void VerifyLeaguePolicyCheckboxFunctionality() {
		logger.info("Starting of VerifyLeaguePolicyCheckboxFunctionality method");

		directorEventRegistrationPage.clickonSelectYourBracketCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		directorEventRegistrationPage.clickonRefundPolicyCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickonHealthSafetyPolicyCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());

		directorEventRegistrationPage.clickonLaibilityCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());

		logger.info("Ending of VerifyLeaguePolicyCheckboxFunctionality method");

	}

	@Test(priority = 7, description = "Verify Register Functionality In Event Registration Page", groups = "sanity")
	@Description("Test case #7, Verify Register Functionality In Event Registration Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Register Functionality In Event Registration Page")
	public void VerifyRegisterFunctionalityInEventRegistrationPage() {
		logger.info("Starting of VerifyRegisterFunctionalityInEventRegistrationPage method");

		directorEventRegistrationPage.clickonRegisterButton();

		Assert.assertEquals(directorEventRegistrationPage.getSuccessLabel(),
				expectedAssertionsProp.getProperty("success.text"));
		Assert.assertEquals(directorEventRegistrationPage.getRegistrationCompletedLabel(),
				expectedAssertionsProp.getProperty("registration.completed"));
		Assert.assertEquals(directorEventRegistrationPage.getOkLabel(), expectedAssertionsProp.getProperty("ok.text"));

		directorEventRegistrationPage.clickOnOkButton();
		// Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		logger.info("Ending of VerifyRegisterFunctionalityInEventRegistrationPage method");

	}

	@Test(priority = 8, description = "Verify Register Functionality In Registration Closed Event", groups = "sanity")
	@Description("Test case #8, Verify Register Functionality In Registration Closed Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Register Functionality In Registration Closed Event")
	public void VerifyRegisterFunctionalityInRegistrationClosedEvent() {
		logger.info("Starting of VerifyRegisterFunctionalityInRegistrationClosedEvent method");

		this.VerifyAddEventFunctionality();
		this.verifyFreeBracketWithRoundRobinEventType();

		addEventPage.clickOnEventsTab();
		// directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard();
		Assert.assertFalse(directorEventRegistrationPage.isRegisterButtonDisplayedForRegistrationClosedEventCard());
		logger.info("Ending of VerifyRegisterFunctionalityInRegistrationClosedEvent method");
		addBracketPage.clickOnBackButton();
		addEventPage.clickOnEventsTab();
	}

	@Test(priority = 9, description = "Verify Register Functionality In Upcoming Event", groups = "sanity")
	@Description("Test case #8, Verify Register Functionality In Upcoming Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Register Functionality In Upcoming Event")
	public void VerifyRegisterFunctionalityInUpcomingEvent() {
		logger.info("Starting of VerifyRegisterFunctionalityInUpcomingEvent method");

		// this.VerifyAddEventFunctionality();
		// this.VerifyFreeBracketWithEventTypeAsRoundRobin();

		addEventPage.clickOnEventsTab();
		// directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard();
		Assert.assertFalse(directorEventRegistrationPage.isRegisterButtonDisplayedForUpcomingEventCard());
		logger.info("Ending of VerifyRegisterFunctionalityInUpcomingEvent method");
		addBracketPage.clickOnBackButton();
		addEventPage.clickOnEventsTab();
	}

	@Test(priority = 10, description = "Verify Register Functionality In Ongoing Event", groups = "sanity")
	@Description("Test case #10, Verify Register Functionality In Ongoing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Register Functionality In Ongoing Event")
	public void VerifyRegisterFunctionalityInOngoingEvent() {
		logger.info("Starting of VerifyRegisterFunctionalityInOngoingEvent method");

		this.VerifyAddEventFunctionality();
		// this.VerifyFreeBracketWithEventTypeAsRoundRobin();

		addEventPage.clickOnEventsTab();
		// directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard();
		Assert.assertFalse(directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard());
		logger.info("Ending of VerifyRegisterFunctionalityInOngoingEvent method");
		addBracketPage.clickOnBackButton();
		addEventPage.clickOnEventsTab();
	}

	@Test(priority = 11, description = "Verify Register Functionality In Complete Event", groups = "sanity")
	@Description("Test case #11, Verify Register Functionality In Complete Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Register Functionality In Complete Event")
	public void VerifyRegisterFunctionalityInCompleteEvent() {
		logger.info("Starting of VerifyRegisterFunctionalityInCompleteEvent method");

		// this.VerifyAddEventFunctionality();
		// this.VerifyFreeBracketWithEventTypeAsRoundRobin();

		addEventPage.clickOnEventsTab();
		// directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard();
		Assert.assertFalse(directorEventRegistrationPage.isRegisterButtonDisplayedForCompleteEventCard());
		logger.info("Ending of VerifyRegisterFunctionalityInCompleteEvent method");
		addBracketPage.clickOnBackButton();
		addEventPage.clickOnEventsTab();
	}

	@Test(priority = 12, description = "Verify Register Functionality In Open Registered Player Event", groups = "sanity")
	@Description("Test case #12, Verify Register Functionality In Complete EventVerify Register Functionality In Open Registered Player Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12 , Verify Register Functionality In Open Registered Player Event")
	public void VerifyRegisterFunctionalityInOpenRegisteredPlayerEvent() {
		logger.info("Starting of VerifyRegisterFunctionalityInCompleteEvent method");

		// this.VerifyAddEventFunctionality();
		// this.VerifyFreeBracketWithEventTypeAsRoundRobin();

		addEventPage.clickOnEventsTab();
		// directorEventRegistrationPage.isRegisterButtonDisplayedForOnGoingEventCard();
		Assert.assertFalse(directorEventRegistrationPage.isRegisterButtonDisplayedForOpenEventCard());
		logger.info("Ending of VerifyRegisterFunctionalityInCompleteEvent method");
		addBracketPage.clickOnBackButton();
		// addEventPage.clickonEventButton();
	}

	@Test(priority = 13, description = "Verify Register Functionality With OPenDouble Bracket", groups = "sanity")
	@Description("Test case #3, Verify Register Functionality With OPenDouble Bracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Register Functionality With OPenDouble Bracket")
	public void VerifyRegisterFunctionalityWithOPenDoubleBracket() {
		logger.info("Starting of VerifyRegisterFunctionalityWithOPenDoubleBracket method");

		addEventPage.clickOnAddEventButton();
		this.VerifyAddEventFunctionality();
		this.verifyFreeBracketWithRoundRobinEventType();

		addEventPage.clickOnEventsTab();
		//Assert.assertTrue(addEventPage.selectRecentlyAddedEvent(eventName));

		this.VerifyRegisterFunctionality();
		this.VerifyEventRegistrationBackButtonFunctionality();
		this.VerifySelectYourBracketCheckboxFunctionality();
		this.VerifyLeaguePolicyCheckboxFunctionality();
		this.VerifyRegisterFunctionalityInEventRegistrationPage();
		this.VerifyRegisterFunctionalityInRegistrationClosedEvent();

		logger.info("Ending of VerifyRegisterFunctionalityWithOPenDoubleBracket method");
	}

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
