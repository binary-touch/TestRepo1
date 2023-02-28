package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.FullRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FullRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(FullRegistrationTest.class.getName());

	private FullRegistrationPage fullRegistrationPage = null;
	private TimeZonePage timeZonePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in FullRegistrationTest");

		this.driver = super.getWebDriver(WebDriversEnum.FULL_REGISTRATION_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.fullRegistrationPage = new FullRegistrationPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);

		logger.info("Ending of initMethod in FullRegistrationTest");
	}

	@Test(priority = 1, description = "VerifyInvalidTeamsCountForTeamsAndWaitlist", groups = "sanity")
	@Description("Test case #1, VerifyInvalidTeamsCountForTeamsAndWaitlist")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, VerifyInvalidTeamsCountForTeamsAndWaitlist")
	public void verifyInvalidTeamsCountForTeamsAndWaitlist() {
		logger.info("Starting of verifyInvalidTeamsCountForTeamsAndWaitlist method");

		super.verifyAddEventFunctionality();
		addBracketPage.hardWait(3);
		super.verifyEventInformationPageWithValidDetails();
		addBracketPage.hardWait(3);
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
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("invalid.number.of.teams"));
		addBracketPage.setWaitlist(testDataProp.getProperty("invalid.wait.list"));

		addEventPage.clickOnNextStepButton();

		fullRegistrationPage.isFullRegistrationValidationsDisplayed();

		addEventPage.clickonGoBackButton();

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyInvalidTeamsCountForTeamsAndWaitlist method");
	}

	@Test(priority = 2, description = "verifyFreeBracketFunctionalityWithFullRegistration", groups = "sanity")
	@Description("Test case #2, verifyFreeBracketFunctionalityWithFullRegistration")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, verifyFreeBracketFunctionalityWithFullRegistration")
	public void verifyFreeBracketFunctionalityWithFullRegistration() {
		logger.info("Starting of verifyFreeBracketFunctionalityWithFullRegistration method");

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectOpenPlayerGroup();
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

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		fullRegistrationPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(2);
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyFreeBracketFunctionalityWithFullRegistration method");
	}

	@Test(priority = 3, description = "verifyFreeBracketPublishEventFunctionalityWithFullRegistration", groups = "sanity")
	@Description("Test case #3, verifyFreeBracketPublishEventFunctionalityWithFullRegistration")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verifyFreeBracketPublishEventFunctionalityWithFullRegistration")
	public void verifyFreeBracketPublishEventFunctionalityWithFullRegistration() {
		logger.info("Starting of verifyFreeBracketPublishEventFunctionalityWithFullRegistration method");

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.verifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketPublishEventFunctionalityWithFullRegistration method");
	}

	@Test(priority = 4, description = "verifyBracketCardFunctionality", groups = "sanity")
	@Description("Test case #4, verifyBracketCardFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verifyBracketCardFunctionality")
	public void verifyBracketCardFunctionality() {
		logger.info("Starting of verifyBracketCardFunctionality method");

		this.verifyRecentlyAddedEventUnderEventsTab();
		Assert.assertTrue(fullRegistrationPage.isOpenSinglesCardDisplayed());

		fullRegistrationPage.clickOnOpenSinglesCard();

		logger.info("Ending of verifyBracketCardFunctionality method");
	}

	@Test(priority = 5, description = "verifyAddParticipantsFunctionality", groups = "sanity")
	@Description("Test case #5, verifyAddParticipantsFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verifyAddParticipantsFunctionality")
	public void verifyAddParticipantsFunctionality() {
		logger.info("Starting of verifyAddParticipantsFunctionality method");

		addparticipantsPage.clickOnAddParticipantsButton();

		Assert.assertTrue(addparticipantsPage.isAddBracketParticipantPageContains());
		Assert.assertTrue(addparticipantsPage.isAddParticipantButtonDisabled());
		Assert.assertEquals(addparticipantsPage.getAddBracketParticipantLabel(),
				expectedAssertionsProp.getProperty("add.bracket.label"));

		super.verifySelectAddParticipantFunctionality();

		logger.info("Ending of verifyAddParticipantsFunctionality method");
	}

	@Test(priority = 6, description = "verifyAddParticipantsFunctionality", groups = "sanity")
	@Description("Test case #6, verifyAddParticipantsFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verifyAddParticipantsFunctionality")
	public void verifyRegisterFunctionalityWithFullRegistration() {
		logger.info("Starting of verifyAddParticipantsFunctionality method");

		for (int i = 0; i <= 1; i++) {

			addparticipantsPage.hardWait(3);
			addparticipantsPage.clickOnAddParticipantsButton();
			addparticipantsPage.hardWait(3);
			super.verifySelectAddParticipantFunctionality();

		}
		driver.navigate().back();
		fullRegistrationPage.clickOnRegisterButton();

		Assert.assertEquals(fullRegistrationPage.getEventRegistrationText(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertTrue(fullRegistrationPage.isSelectBracketCheckBoxDisabledDisplayed());

		Assert.assertEquals(fullRegistrationPage.getRegistrationFullText(),
				expectedAssertionsProp.getProperty("registration.full"));

		Assert.assertTrue(fullRegistrationPage.isRegisterButtonDisableDisplayed());

		logger.info("Ending of verifyAddParticipantsFunctionality method");
	}

	@Test(priority = 7, description = "verifyFullRegistrationFunctionalityWithWaterFallEventType", groups = "sanity")
	@Description("Test case #7, verifyFullRegistrationFunctionalityWithWaterFallEventType")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, verifyFullRegistrationFunctionalityWithWaterFallEventType")
	public void verifyFullRegistrationFunctionalityWithWaterFallEventType() {
		logger.info("Starting of verifyFullRegistrationFunctionalityWithWaterFallEventType method");

		addBracketPage.clickOnBackButton();
		fullRegistrationPage.clickOnOpenSinglesCard();
		timeZonePage.clickOnEditBracketButton();
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectWaterfallEventType();

		addBracketPage.setNumberOfCourts(testDataProp.getProperty("min.rating.range"));
		timeZonePage.clickOnSaveChangesButton();

		try {
			for (int i = 0; i <= 13; i++) {
				addparticipantsPage.hardWait(3);
				addparticipantsPage.clickOnAddParticipantsButton();
				super.verifySelectAddParticipantFunctionality();
				addparticipantsPage.hardWait(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		addparticipantsPage.hardWait(3);
		Assert.assertFalse(this.addparticipantsPage.isAddParticiPantsButtonDisplayed());

		logger.info("Ending of verifyFullRegistrationFunctionalityWithWaterFallEventType method");
	}

	@Test(priority = 8, description = "verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType", groups = "sanity")
	@Description("Test case #8, verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType")
	public void verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType() {
		logger.info("Starting of verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType method");

		for (int i = 0; i <= 2; i++) {

			driver.navigate().back();
		}

		fullRegistrationPage.clickOnRegisterButton();

		Assert.assertEquals(fullRegistrationPage.getEventRegistrationText(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertTrue(fullRegistrationPage.isSelectBracketCheckBoxDisabledDisplayed());

		Assert.assertEquals(fullRegistrationPage.getRegistrationFullText(),
				expectedAssertionsProp.getProperty("registration.full"));

		Assert.assertTrue(fullRegistrationPage.isRegisterButtonDisableDisplayed());

		logger.info("Ending of verifyRegisterFunctionalityWithFullRegistrationWithWaterFallEventType method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.FULL_REGISTRATION_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
