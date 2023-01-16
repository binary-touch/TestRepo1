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
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddEventTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddEventTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditClubInfoPage editClubInfoPage = null;

	private AddEventPage addEventPage = null;
	private AddBracketPage addBracketPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in EditClubInfoTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_EVENT_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);

		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
	public void VerifyAddEventFunctionality() {
		logger.info("Starting of VerifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();

		editClubInfoPage.selectDirectorFromDirectorsList();

		addEventPage.clickonAddEventButton();

		Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
	}

	@Test(priority = 2, description = "Verify Event Information page with valid details", groups = "sanity")
	@Description("Test case #2, Verify Event Information page with valid details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Event Information page with valid details")
	public void VerifyEventInformationPageWithValidDetails() {
		logger.info("Starting of VerifyEventInformationPageWithValidDetails method");

		addEventPage.setEventName(testDataProp.getProperty("event.name"));

		addEventPage.setUploadImageButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));

		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.value"));

		addEventPage.setNonMemberPrice(testDataProp.getProperty("nonMemberPrice.value"));

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonTextFormattingButtons();

		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPliciesPageContains());

		logger.info("Ending of VerifyEventInformationPageWithValidDetails method");
	}

	@Test(priority = 3, description = "Verify Exit Event Creation Popup", groups = "sanity")
	@Description("Test case #3, Verify Exit Event Creation Popupe")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Exit Event Creation Popup")
	public void VerifyExitEventCreationPopup() {
		logger.info("Starting of VerifyExitEventCreationPopup method");

		addEventPage.clickonExitButton();

		addEventPage.isDisplayedExitEventCreationPopupContains();

		logger.info("Ending of VerifyExitEventCreationPopup method");
	}

	@Test(priority = 4, description = "Verify Event Policie Discard Functionality", groups = "sanity")
	@Description("Test case #4, Verify Event Policie Discard Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Policie Discard Functionality")
	public void VerifyEventPolicieDiscardFunctionality() {
		logger.info("Starting of VerifyExitEventCreationPopup method");

		addEventPage.clickonEventPolicieDiscardButton();

		addEventPage.isDisplayedClubContains();

		logger.info("Ending of VerifyExitEventCreationPopup method");
	}

	@Test(priority = 5, description = "Verify Event Policie Save As Draft Functionality", groups = "sanity")
	@Description("Test case #5, Verify Event Policie Save As Draft Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Event Policie Save As Draft Functionality")
	public void VerifyEventPolicieSaveAsDraftFunctionality() {
		logger.info("Starting of VerifyEventPolicieSaveAsDraftFunctionality method");

		addEventPage.clickonAddEventButton();

		this.VerifyEventInformationPageWithValidDetails();

		addEventPage.clickonExitButton();

		addEventPage.clickonSaveAsDraftButton();

		addEventPage.isDisplayedClubContains();

		logger.info("Ending of VerifyEventPolicieSaveAsDraftFunctionality method");
	}

	@Test(priority = 6, description = "Verify Draft Event in Clubs page-Events Tab Functionality", groups = "sanity")
	@Description("Test case #6, Verify Draft Event in Clubs page-Events Tab Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Draft Event in Clubs page-Events Tab Functionality")
	public void VerifyDraftEvenInClubsPageEventsTabFunctionality() {
		logger.info("Starting of VerifyDraftEvenInClubsPageEventsTabFunctionality method");

		addEventPage.clickonEventButton();
		addEventPage.selectDraftFromDraftsList(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));
		/*
		 * String eventName = addEventPage.getEventName();
		 * Assert.assertEquals(eventName,
		 * expectedAssertionsProp.getProperty("event.name"));
		 */

		logger.info("Ending of VerifyDraftEvenInClubsPageEventsTabFunctionality method");
	}

	@Test(priority = 7, description = "Verify Close Icon In Exit Event Creation popup", groups = "sanity")
	@Description("Test case #7, Verify Close Icon In Exit Event Creation popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Close Icon In Exit Event Creation popupp")
	public void VerifyCloseIconInExitEventCreationpopup() {
		logger.info("Starting of VerifyCloseIconInExitEventCreationpopup method");

		addEventPage.clickonAddEventButton();

		this.VerifyEventInformationPageWithValidDetails();

		addEventPage.clickonExitButton();

		addEventPage.clickonExitEventCreationCloseIcon();

		// Assert.assertTrue(addEventPage.isDisplayedEventPliciesPageContains());

		logger.info("Ending of VerifyCloseIconInExitEventCreationpopup method");
	}

	@Test(priority = 8, description = "Verify Go Back Button Functionality", groups = "sanity")
	@Description("Test case #8, Verify Go Back Button Functionalityp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Go Back Button Functionality")
	public void VerifyGoBackButtonFunctionality() {
		logger.info("Starting of VerifyGoBackButtonFunctionality method");

		addEventPage.clickonGoBackButton();

		Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyGoBackButtonFunctionality method");
	}

	@Test(priority = 9, description = "Verify Upload A Liability Wavier Functionality", groups = "sanity")
	@Description("Test case #9, Verify Upload A Liability Wavier Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Upload A Liability Wavier Functionality")
	public void VerifyUploadALiabilityWavierFunctionality() {
		logger.info("Starting of VerifyGoBackButtonFunctionality method");

		addEventPage.clickonNextButton();
		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));
		Assert.assertTrue(addEventPage.isDisplayedRemoveAndReplaceContains());

		logger.info("Ending of VerifyGoBackButtonFunctionality method");
	}

	@Test(priority = 10, description = "Verify Liability Waiver Remove Icon", groups = "sanity")
	@Description("Test case #10, Verify Liability Waiver Remove Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Liability Waiver Remove Icon")
	public void VerifyLiabilityWaiverRemoveIcon() {
		logger.info("Starting of VerifyLiabilityWaiverRemoveIcon method");

		addEventPage.clickonLiabilityWaiverRemoveButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPliciesPageContains());

		logger.info("Ending of VerifyLiabilityWaiverRemoveIcon method");
	}

	@Test(priority = 11, description = "Verify Liability Waiver Replace Button", groups = "sanity")
	@Description("Test case #11, Verify Liability Waiver Replace Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Liability Waiver Replace Button")
	public void VerifyLiabilityWaiverReplaceButton() {
		logger.info("Starting of VerifyLiabilityWaiverReplaceButton method");

		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));

		addEventPage.isDisplayedRemoveAndReplaceContains();

		addEventPage.clickonReplaceButton();

		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("upload.image"));

		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("about.the.Event"));

		addEventPage.setHealthandSafetyPolicyEdit(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonNextButton();

		logger.info("Ending of VerifyLiabilityWaiverReplaceButton method");
	}

	@Test(priority = 12, description = "Verify AddBrackets Page With Valid Details", groups = "sanity")
	@Description("Test case #12, Verify AddBrackets Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify AddBrackets Page With Valid Details")
	public void VerifyAddBracketsPageWithValidDetails() {
		logger.info("Starting of VerifyAddBracketsPageWithValidDetails method");

		addBracketPage.clickonBracket1Button();
		addBracketPage.clickonBracket1Button();
		addBracketPage.clickonTypeDropdown();
		addBracketPage.clickonPlayGroundDropdown();
		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		addBracketPage.clickOnAutoGenerate();
		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();
		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("clubmember.price"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("nonclubmember.price"));
		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.terms"));
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		addEventPage.clickonNextButton();

		// Assert.assertTrue(addEventPage.isDisplayedEventPliciesPageContains());

		logger.info("Ending of VerifyAddBracketsPageWithValidDetails method");
	}

	@Test(priority = 13, description = "Verify AddAnotherBracket button In AddAnotherBracketPopup", groups = "sanity")
	@Description("Test case #13, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	public void VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup() {
		logger.info("Starting of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");

		addBracketPage.clickOnAddAnotherBracketButton();

		logger.info("Ending of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");
	}

	@Test(priority = 14, description = "Verify  Delete Bracket button fuctionality", groups = "sanity")
	@Description("Test case #14, Verify  Delete Bracket button fuctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify  Delete Bracket button fuctionality")
	public void VerifyDeleteBracketFuctionality() {
		logger.info("Starting of VerifyDeleteBracketFuctionality method");

		addBracketPage.clickOnDeleteBracketButton();

		logger.info("Ending of VerifyDeleteBracketFuctionality method");
	}

	@Test(priority = 15, description = "Verify NoContinueToSummary Button In AddAnotherBracke tpopup", groups = "sanity")
	@Description("Test case #15, Verify NoContinueToSummary Button In AddAnotherBracke tpopup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify NoContinueToSummary Button In AddAnotherBracke tpopup")
	public void VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");

		addBracketPage.clickonBracket1Button();

		addEventPage.clickonNextButton();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");
	}

	@Test(priority = 16, description = "Verify Publish Event Button", groups = "sanity")
	@Description("Test case #16, Verify Publish Event Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify Publish Event Button")
	public void VerifyPublishEventButton() {
		logger.info("Starting of VerifyPublishEventButton method");

		addBracketPage.clickOnPublishEventButton();

		logger.info("Ending of VerifyPublishEventButton method");
	}

	@Test(priority = 17, description = "Verify Close Icon In YourEventIsNowPublished Success Popup", groups = "sanity")
	@Description("Test case #17, Verify Close Icon In YourEventIsNowPublished Success Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify Close Icon In YourEventIsNowPublished Success Popup")
	public void VerifyCloseIconInYourEventIsNowPublishedSuccessPopup() {
		logger.info("Starting of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");

		addBracketPage.clickOnPublishEventButton();

		logger.info("Ending of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_EVENT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
