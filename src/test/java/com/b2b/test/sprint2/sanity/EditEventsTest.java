package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EditEventsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("DUPR App")
@Feature("Edit Events Sanity")
public class EditEventsTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(EditEventsTest.class.getName());
	private EditEventsPage editEventsPage = null;
	private static String eventNameForEditEvents = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EditEventsTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_EVENTS_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		this.editEventsPage = new EditEventsPage(this.driver);

		logger.info("Ending of initMethod in EditEventsTest");
	}

	public void verifyFreeEventFunctionality() {
		logger.info("Starting of verifyFreeEventFunctionality method");

		addEventPage.hardWait(3);

		super.verifyAddEventFunctionality();

		eventNameForEditEvents = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		addBracketPage.hardWait(3);
		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		super.verifyAddBracketsFunctionalityWithValidDetails();

		addBracketPage.hardWait(3);
		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.verifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeEventFunctionality method");
	}

	@Test(priority = 1, description = "Verify Edit event functionality in Event page", groups = "sanity")
	@Description("Test case #1, Verify Edit event functionality in Event page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Edit event functionality in Event page")
	public void verifyEditEventsFunctionalityInEventPage() {
		logger.info("Starting of verifyEditEventsFunctionalityInEventPage method");

		this.verifyFreeEventFunctionality();
		clubLogoPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		clubLogoPage.hardWait(3);
		addEventPage.clickOnRecentlyAddedEvent(eventNameForEditEvents);

		editEventsPage.hardWait(2);
		editEventsPage.clickOnEditEventButton();
		editEventsPage.hardWait(2);
		editEventsPage.clickOnCancelButton();
		editEventsPage.hardWait(2);
		editEventsPage.clickOnEditEventButton();
		editEventsPage.hardWait(2);
		Assert.assertEquals(editEventsPage.getEditEventsText(), expectedAssertionsProp.getProperty("edit.event.txt"));
		Assert.assertTrue(editEventsPage.isEditEventsPageContains());

		logger.info("Ending of verifyEditEventsFunctionalityInEventPage method");
	}

	@Test(priority = 2, description = "Verify Event Name Functionality in Event Information page", groups = "sanity")
	@Description("Test case #2, Verify event name Functionality in Event Information page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify event name Functionality in Event Information page")
	public void verifyEditNameFunctionalityInEventInfoPage() {
		logger.info("Starting of verifyEditNameFunctionalityInEventInfoPage method");

		Assert.assertEquals(editEventsPage.getEventNameText(), expectedAssertionsProp.getProperty("event.name.txt"));
		addEventPage.setEventName(testDataProp.getProperty("event.name"));

		logger.info("Ending of verifyEditNameFunctionalityInEventInfoPage method");
	}

	@Test(priority = 3, description = "Verify Edit About the event Functionality in Event Information page", groups = "sanity")
	@Description("Test case #3, Verify Edit About the event Functionality in Event Information page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify about the event field")
	public void verifyEditAboutTheEventFunctionalityInEventInfoPage() {
		logger.info("Starting of verifyEditAboutTheEventFunctionalityInEventInfoPage method");

		Assert.assertEquals(editEventsPage.getAboutEventText(), expectedAssertionsProp.getProperty("about.event.txt"));

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		logger.info("Ending of verifyEditAboutTheEventFunctionalityInEventInfoPage method");
	}

	@Test(priority = 4, description = "Verify Event Information Page Details Got Edited", groups = "sanity")
	@Description("Test case #4, Verify Event Information Page Details Got Edited")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Information Page Details Got Edited")
	public void verifyEventInformationPageDetailsGotEdited() {
		logger.info("Starting of verifyEventInformationPageDetailsGotEdited method");

		Assert.assertEquals(editEventsPage.getEntryFeeText(), expectedAssertionsProp.getProperty("entry.fee"));
		Assert.assertEquals(editEventsPage.getMembersText(), expectedAssertionsProp.getProperty("member.price"));
		Assert.assertEquals(editEventsPage.getNonMemberText(), expectedAssertionsProp.getProperty("nonmember.price"));
		Assert.assertEquals(editEventsPage.getLiabilityWaiverText(),
				expectedAssertionsProp.getProperty("liability.waiver"));

		logger.info("Ending of verifyEventInformationPageDetailsGotEdited method");
	}

	@Test(priority = 5, description = "Verify Edit Liability Waiver file in Event Policies page", groups = "sanity")
	@Description("Test case #5, Verify Edit Liability Waiver file in Event Policies page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Edit Liability Waiver file in Event Policies page")
	public void verifyEditLiabilityWaiverFile() {
		logger.info("Starting of verifyEditLiabilityWaiverFile method");

		try {
			if (editEventsPage.isReplaceButtonDisplayed() == true) {

				editEventsPage.clickOnRemoveButton();
				clubLogoPage
						.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
			}

		} catch (Exception e) {
			clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		}

		logger.info("Ending of verifyEditLiabilityWaiverFile method");
	}

	@Test(priority = 6, description = "Verify Edit Refund Policy Functionality in Event Policies page", groups = "sanity")
	@Description("Test case #6, Verify Edit Refund Policy Functionality in Event Policies page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Edit Refund Policy Functionality in Event Policies page")
	public void verifyEditRefundPolicyFunctionalityInEventPoliciesPage() {
		logger.info("Starting of verifyEditRefundPolicyFunctionalityInEventPoliciesPage method");

		Assert.assertEquals(editEventsPage.getRefundPolicyText(), expectedAssertionsProp.getProperty("refund.policy"));

		addEventPage.setRefundPolicy(testDataProp.getProperty("refund.policy"));

		logger.info("Ending of verifyEditRefundPolicyFunctionalityInEventPoliciesPage method");
	}

	@Test(priority = 7, description = "Verify Edit Health and Safety Policy Functionality in Event Policies page", groups = "sanity")
	@Description("Test case #7, Verify Edit Health and Safety Policy Functionality in Event Policies page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Edit Health and Safety Policy Functionality in Event Policies page")
	public void verifyEditHealthAndSafetyPolicyFunctionalityInEventPoliciesPage() {
		logger.info("Starting of verifyEditHealthAndSafetyPolicyFunctionalityInEventPoliciesPage method");

		Assert.assertEquals(editEventsPage.getHealthSafetyText(),
				expectedAssertionsProp.getProperty("health.and.safety.policy.text"));

		addEventPage.setHealthAndSafetyPolicy(testDataProp.getProperty("health.policy"));

		logger.info("Ending of verifyEditHealthAndSafetyPolicyFunctionalityInEventPoliciesPage method");
	}

	@Test(priority = 8, description = "Verify save changes button Functionality After Event Edit", groups = "sanity")
	@Description("Test case #8, Verify save changes button Functionality After Event Edit")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify save changes button Functionality After Event Edit")

	public void verifySaveChangesFunctionalityAfterEventEdit() {
		logger.info("Starting of verifySaveChangesFunctionalityAfterEventEdit method");

		editEventsPage.clickOnSaveChangesButton();
		editEventsPage.hardWait(3);
		Assert.assertEquals(editEventsPage.getEventNameLabel(), expectedAssertionsProp.getProperty("event.text"));

		logger.info("Ending of verifySaveChangesFunctionalityAfterEventEdit method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_EVENTS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
