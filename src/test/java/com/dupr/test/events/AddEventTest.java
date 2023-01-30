package com.dupr.test.events;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketNegativePage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventNegativePage;
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
	private AddEventNegativePage addEventNegativePage = null;
	private AddBracketNegativePage addBracketNegativePage = null;

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
		this.addEventNegativePage = new AddEventNegativePage(this.driver);
		this.addBracketNegativePage = new AddBracketNegativePage(this.driver);
		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
	public void VerifyAddEventFunctionality() {
		logger.info("Starting of VerifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();

		// editClubInfoPage.clickOnBrowseClubsButton();

		// addEventPage.setSearchClubName(testDataProp.getProperty("club.name"));

		// addEventPage.clickonSimbaClubNameButton();
		editClubInfoPage.clickOnSimbaOrganizerButton();
		addEventPage.clickonAddEventButton();

		Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
	}

	@Test(priority = 2, description = "Verify Exit Button Without Entering Any Details In Event Information Page", groups = "sanity")
	@Description("Test case #2, Verify Exit Button Without Entering Any Details In Event Information Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Exit Button Without Entering Any Details In Event Information Page")
	public void VerifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage() {
		logger.info("Starting of VerifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage method");

		addEventPage.clickonExitButton();
		Assert.assertTrue(addEventPage.isDisplayedClubContains());

		logger.info("Ending of VerifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage method");
	}

	@Test(priority = 3, description = "Verify Event Info Page With EmptyFields", groups = "sanity")
	@Description("Test case #3, Verify Event Info Page With EmptyFields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Event Info Page With EmptyFields")
	public void VerifyEventInfoPageWithEmptyFields() {
		logger.info("Starting of VerifyEventInfoPageWithEmptyFields method");

		addEventPage.clickonAddEventButton();
		addEventPage.clickonNextButton();
		Assert.assertTrue(addEventNegativePage.isEventWithEmptyFieldsContainsDisplayed());

		logger.info("Ending of VerifyEventInfoPageWithEmptyFields method");
	}

	@Test(priority = 4, description = "Verify Event Info Page With EmptyFields", groups = "sanity")
	@Description("Test case #4, Verify Event Info Page With EmptyFields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Info Page With EmptyFields")
	public void VerifyEventNameFieldWithMaxCharacters() {
		logger.info("Starting of VerifyEventInfoPageWithEmptyFields method");

		addEventPage.setEventName(addEventPage.randomAlphabet(150));

		String typedEventNameValue = addEventPage.getEventNameValue();

		// Get the length of typed value
		int size = typedEventNameValue.length();

		// Assert with expected
		if (size == 150) {
			logger.info("****Max character functionality is working fine.****");
		} else {
			logger.info("****Event Name Max Limit is not working****");
		}

		logger.info("Ending of VerifyEventInfoPageWithEmptyFields method");
	}

	@Test(priority = 5, description = "Verify Member And NonMember Price Fields With Invalid Details", groups = "sanity")
	@Description("Test case #5, Verify Member And NonMember Price Fields With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Member And NonMember Price Fields With Invalid Details")
	public void VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails() {
		logger.info("Starting of VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");

		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.invalid.value"));

		addEventPage.setNonMemberPrice(testDataProp.getProperty("memberPrice.invalid.value"));

		//Assert.assertTrue(addEventNegativePage.isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed());

		logger.info("Ending of VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");
	}

	@Test(priority = 6, description = "Verify Member And Nonmember Price Fields With Negative Values", groups = "sanity")
	@Description("Test case #6, Verify Member And Nonmember Price Fields With Negative Values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Member And Nonmember Price Fields With Negative Values")
	public void VerifyMemberAndNonmemberPriceFieldsWithNegativeValues() {
		logger.info("Starting of VerifyMemberAndNonmemberPriceFieldsWithNegativeValues method");

		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.value.error"));

		addEventPage.setNonMemberPrice(testDataProp.getProperty("memberPrice.value.error"));

		addEventPage.clickonNextButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addEventNegativePage.isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed());

		logger.info("Ending of VerifyMemberAndNonmemberPriceFieldsWithNegativeValues method");
	}

	@Test(priority = 7, description = "Verify Minimum Ten Chars Validation In AboutTheEvent", groups = "sanity")
	@Description("Test case #7, Verify Minimum Ten Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Minimum Ten Chars Validation In AboutTheEvent")
	public void VerifyMinimumTenCharsValidationInAboutTheEvent() {
		logger.info("Starting of VerifyMinimumTenCharsValidationInAboutTheEvent method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event.minimum.char"));

		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventNegativePage.isMinimumTenCharsValidationDisplayed());

		logger.info("Ending of VerifyMinimumTenCharsValidationInAboutTheEvent method");
	}

	@Test(priority = 8, description = "Verify Font styles for the About event field", groups = "sanity")
	@Description("Test case #8, Verify Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Font styles for the About event field")
	public void VerifyFontStylesAboutEventField() {
		logger.info("Starting of VerifyFontStylesAboutEventField method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonBoldTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldFontStyleDisplayed());

		addEventPage.clickonBoldTextFormattingButton();

		addEventPage.clickonItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicFontStyleDisplayed());

		addEventPage.clickonItalicTextFormattingButton();

		addEventPage.clickonUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isUnderlineFontStyleDisplayed());

		addEventPage.clickonUnderLineTextFormattingButton();

		logger.info("Ending of VerifyFontStylesAboutEventField method");
	}

	@Test(priority = 9, description = "Verify Formating of Font styles for the About event field", groups = "sanity")
	@Description("Test case #9, Verify Formating of Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Formating of Font styles for the About event field")
	public void VerifyFormatingFontStylesAboutEventField() {
		logger.info("Starting of VerifyFormatingFontStylesAboutEventField method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonTextFormattingButtons();
		Assert.assertTrue(this.addEventPage.isBoldItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of VerifyFormatingFontStylesAboutEventField method");
	}

	@Test(priority = 10, description = "Verify combination of Bold and Underline  Font styles for the About event field", groups = "sanity")
	@Description("Test case #10, Verify combination of Bold and Underline Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify combination of Bold and Underline Font styles for the About event field")
	public void VerifyCombinationOFBoldAndUnderlineFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFFontStylesAboutEventField method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonBoldAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldUnderlineFontStylesDisplayed());

		logger.info("Ending of VerifyCombinationOFBoldAndUnderlineFontStylesAboutEventField method");
	}

	@Test(priority = 11, description = "Verify combination of Italic and Underline  Font styles for the About event field", groups = "sanity")
	@Description("Test case #11, Verify combination of Italic and Underline Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify combination of Italic and Underline Font styles for the About event field")
	public void VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonItalicAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField method");
	}

	@Test(priority = 12, description = "Verify combination of Bold and Italic  Font styles for the About event field", groups = "sanity")
	@Description("Test case #12, Verify combination of Bold and Italic Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify combination of Bold and Italic Font styles for the About event field")
	public void VerifyCombinationOFBoldAndItalicFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFBoldAndItalicFontStylesAboutEventField method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonBoldAndItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldItalicFontStylesDisplayed());

		logger.info("Ending of VerifyCombinationOFBoldAndItalicFontStylesAboutEventField method");
	}

	@Test(priority = 13, description = "Verify Maximum Chars Validation In AboutTheEvent", groups = "sanity")
	@Description("Test case #13, Verify Maximum Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Maximum Chars Validation In AboutTheEvent")
	public void VerifyMaximumCharsValidationInAboutTheEvent() {
		logger.info("Starting of VerifyMaximumCharsValidationInAboutTheEvent method");

		String aboutTheEventMaximumChars = RandomStringUtils.randomAlphabetic(4510);

		logger.debug("about max characters text: ***" + aboutTheEventMaximumChars);
		addEventPage.setAboutTheEvent(aboutTheEventMaximumChars);

		Assert.assertTrue(this.addEventNegativePage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of VerifyMaximumCharsValidationInAboutTheEvent method");
	}

	@Test(priority = 14, description = "Verify Invalid logo Functionality In EventInformationPage", groups = "sanity")
	@Description("Test case #14, Verify Invalid logo Functionality In EventInformationPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Invalid logo Functionality In EventInformationPage")
	public void VerifyInvalidlogoFunctionalityInEventInformationPage() {
		logger.info("Starting of VerifyInvalidlogoFunctionalityInEventInformationPage method");

		addEventPage
				.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.invalid.logo.path"));

		Assert.assertTrue(this.addEventPage.isInvalidUploadLogoDisplayed());

		logger.info("Ending of VerifyInvalidlogoFunctionalityInEventInformationPage method");
	}

	@Test(priority = 15, description = "Verify Remove logo Functionality In EventInformationPage", groups = "sanity")
	@Description("Test case #15, Verify Maximum Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Maximum Chars Validation In AboutTheEvent")
	public void VerifyRemovelogoFunctionalityInEventInformationPage() {
		logger.info("Starting of VerifyRemovelogoFunctionalityInEventInformationPage method");

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		addEventNegativePage.clickonRemovelogoIcon();

		Assert.assertTrue(this.addEventPage.isDragandDropImageTextDispalyed());

		logger.info("Ending of VerifyRemovelogoFunctionalityInEventInformationPage method");
	}

	@Test(priority = 16, description = "VerifyExitEventCreationPopupAfterFillingEventInformationDetails", groups = "sanity")
	@Description("Test case #16, VerifyExitEventCreationPopupAfterFillingEventInformationDetails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, VerifyExitEventCreationPopupAfterFillingEventInformationDetails")
	public void VerifyExitEventCreationPopupAfterFillingEventInformationDetails() {
		logger.info("Starting of VerifyExitEventCreationPopupAfterFillingEventInformationDetails method");

		addEventPage.setEventName(testDataProp.getProperty("event.name"));

		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));

		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.value"));

		addEventPage.setNonMemberPrice(testDataProp.getProperty("nonMemberPrice.value"));

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonTextFormattingButtons();

		// addEventPage.clickonExitButton();

		// addEventPage.isDisplayedExitEventCreationPopupContains();

		// addEventPage.clickonExitEventCreationCloseIcon();

		logger.info("Ending of VerifyExitEventCreationPopupAfterFillingEventInformationDetails method");
	}

	@Test(priority = 17, description = "Verify Event Information Page with Valid Details", groups = "sanity")
	@Description("Test case #17, Verify Event Information Page with Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify Event Information Page with Valid Details")
	public void VerifyExitButtonWithEnteringAnyDetailsInEventInformationPage() {
		logger.info("Starting of VerifyExitButtonWithEnteringAnyDetailsInEventInformationPage method");

		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		logger.info("Ending of VerifyExitButtonWithEnteringAnyDetailsInEventInformationPage method");
	}

	@Test(priority = 18, description = "Verify Exit Event Creation Popup in Event Policies", groups = "sanity")
	@Description("Test case #18, Verify Exit Event Creation Popup in Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify Exit Event Creation Popup in Event Policies")
	public void VerifyExitEventCreationPopupInEventPolicies() {
		logger.info("Starting of VerifyExitEventCreationPopupInEventPolicies method");

		addEventPage.clickonExitButton();

		Assert.assertTrue(addEventPage.isDisplayedExitEventCreationPopupContains());

		logger.info("Ending of VerifyExitEventCreationPopupInEventPolicies method");
	}

	@Test(priority = 19, description = "Verify Event Policie Discard Functionality", groups = "sanity")
	@Description("Test case #19, Verify Event Policie Discard Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify Event Policie Discard Functionality")
	public void VerifyEventPolicieDiscardFunctionality() {
		logger.info("Starting of VerifyExitEventCreationPopup method");

		addEventPage.clickonEventPolicieDiscardButton();

		Assert.assertTrue(addEventPage.isDisplayedClubContains());

		logger.info("Ending of VerifyExitEventCreationPopup method");
	}

	@Test(priority = 20, description = "Verify Event Policie Save As Draft Functionality", groups = "sanity")
	@Description("Test case #20, Verify Event Policie Save As Draft Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify Event Policie Save As Draft Functionality")
	public void VerifyEventPolicieSaveAsDraftFunctionality() {
		logger.info("Starting of VerifyEventPolicieSaveAsDraftFunctionality method");

		addEventPage.clickonAddEventButton();

		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();

		this.VerifyExitButtonWithEnteringAnyDetailsInEventInformationPage();

		addEventPage.clickonExitButton();

		addEventPage.clickonSaveAsDraftButton();

		Assert.assertTrue(addEventPage.isDisplayedClubContains());

		logger.info("Ending of VerifyEventPolicieSaveAsDraftFunctionality method");
	}

	@Test(priority = 21, description = "Verify Draft Event in Clubs page-Events Tab Functionality", groups = "sanity")
	@Description("Test case #21, Verify Draft Event in Clubs page-Events Tab Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify Draft Event in Clubs page-Events Tab Functionality")
	public void VerifyDraftEventInClubsPageEventsTabFunctionality() {
		logger.info("Starting of VerifyDraftEventInClubsPageEventsTabFunctionality method");

		addEventPage.clickonEventButton();
		addEventPage.selectDraftFromDraftsList(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyDraftEventInClubsPageEventsTabFunctionality method");
	}

	@Test(priority = 22, description = "Verify Delete Draft Event Functionality Before Publishing Event", groups = "sanity")
	@Description("Test case #22, Verify Delete Draft Event Functionality Before Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #22, Verify Delete Draft Event Functionality Before Publishing Event")
	public void VerifyDeleteDraftEventFunctionalityBeforePublishingEvent() {
		logger.info("Starting of VerifyDeleteDraftEventFunctionalityBeforePublishingEvent method");

		addEventPage.ClickOnDeleteEventFromList(testDataProp.getProperty("event.name"));
		Assert.assertTrue(addEventPage.isDisplayedEventDeletePopUpContains());

		logger.info("Ending of VerifyDeleteDraftEventFunctionalityBeforePublishingEvent method");
	}

	@Test(priority = 23, description = "Verify CancelButton Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #23, Verify CancelButton Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #23, Verify CancelButton Functionality In Delete Event PopUp")
	public void VerifyCancelButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of VerifyCancelButtonFunctionalityInDeleteEventPopUp method");

		addEventPage.clickOnDeleteEventCancelButton();
		addEventPage.selectDraftFromDraftsList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyCancelButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 24, description = "Verify CloseButton Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #24, Verify CloseButton Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #24, Verify CloseButton Functionality In Delete Event PopUp")
	public void VerifyCloseButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of VerifyCloseButtonFunctionalityInDeleteEventPopUp method");

		this.VerifyDeleteDraftEventFunctionalityBeforePublishingEvent();
		addEventPage.clickOnDeleteEventCloseButton();
		addEventPage.selectDraftFromDraftsList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyCloseButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 25, description = "Verify ConfirmButton Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #25, Verify ConfirmButton Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #25, Verify ConfirmButton Functionality In Delete Event PopUp")
	public void VerifyConfirmButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of VerifyConfirmButtonFunctionalityInDeleteEventPopUp method");

		this.VerifyDeleteDraftEventFunctionalityBeforePublishingEvent();
		addEventPage.clickOnDeleteEventConfirmButton();

		Assert.assertTrue(addEventPage.isDisplayedEventDeleteSuccessPopUpContains());

		logger.info("Ending of VerifyConfirmButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 26, description = "Verify OKButton Functionality In Delete Event Success PopUp", groups = "sanity")
	@Description("Test case #26, Verify OKButton Functionality In Delete Event Success PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #26, Verify OKButton Functionality In Delete Event Success PopUp")
	public void VerifyOKButtonFunctionalityInDeleteEventSuccessPopUp() {
		logger.info("Starting of VerifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");

		addEventPage.clickOnDeleteEventOKButton();

		// Assert.assertTrue(addEventPage.isDisplayedEventDeleteSuccessPopUpContains());

		logger.info("Ending of VerifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");
	}

	@Test(priority = 27, description = "Verify Close Icon In Exit Event Creation popup in Event Policies", groups = "sanity")
	@Description("Test case #27, Verify Close Icon In Exit Event Creation popup in Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #27, Verify Close Icon In Exit Event Creation popupp in Event Policies")
	public void VerifyCloseIconInExitEventCreationInEventPoliciespopup() {
		logger.info("Starting of VerifyCloseIconInExitEventCreationpopup method");

		addEventPage.clickonAddEventButton();

		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();

		this.VerifyExitButtonWithEnteringAnyDetailsInEventInformationPage();

		addEventPage.clickonExitButton();

		addEventPage.clickonExitEventCreationCloseIcon();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		logger.info("Ending of VerifyCloseIconInExitEventCreationInEventPoliciespopup method");
	}

	@Test(priority = 28, description = "Verify Event RefundPolicy Required", groups = "sanity")
	@Description("Test case #28, Verify Maximum Chars Validation In Health and Saftey Policy")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #28, Verify Maximum Chars Validation In Health and Saftey Policy")
	public void VerifyEventRefundPolicywithEmptyFeilds() {
		logger.info("Starting of VerifyEventRefundPolicywithEmptyFeilds method");

		addEventPage.clickonNextButton();

		Assert.assertTrue(this.addEventPage.isEventRefundPolicyRequiredDisplayed());

		logger.info("Ending of VerifyEventRefundPolicywithEmptyFeilds method");
	}

	@Test(priority = 29, description = "Verify Go Back Button Functionality", groups = "sanity")
	@Description("Test case #29, Verify Go Back Button Functionalityp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #29, Verify Go Back Button Functionality")
	public void VerifyGoBackButtonFunctionality() {
		logger.info("Starting of VerifyGoBackButtonFunctionality method");

		addEventPage.clickonGoBackButton();

		Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyGoBackButtonFunctionality method");
	}

	@Test(priority = 30, description = "Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage", groups = "sanity")
	@Description("Test case #30, Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #30, Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage")
	public void verifyFormatsSupportedByLiabilityWaiver() {
		logger.info("Starting of verifyFormatsSupportedByLiabilityWaiver method");
		addEventPage.clickonNextButton();
		addEventPage.clickOnLiabilityWaiverButton();

		Assert.assertTrue(this.addEventPage.isFileExplorerContains());

		logger.info("Ending of verifyFormatsSupportedByLiabilityWaiver method");
	}

	@Test(priority = 31, description = "Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage", groups = "sanity")
	@Description("Test case #31, Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #31, Verify Invalid LiabilityWaiver Upload Functionality  In EventPolicesPage")
	public void VerifyInvalidLiabilityWaiverUploadFunctionalityInEventPolicesPage() {
		logger.info("Starting of VerifyInvalidlogoFunctionalityInEventInformationPage method");

		addEventPage.clickonNextButton();
		addEventPage.setUploadaLiabilityWaiverButton(
				BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.invalid.logo.path"));

		Assert.assertTrue(this.addEventNegativePage.isLiabilityWaiverinvalidLogoDisplayed());

		logger.info("Ending of VerifyInvalidlogoFunctionalityInEventInformationPage method");
	}

	@Test(priority = 32, description = "Verify Upload A Liability Wavier Functionality", groups = "sanity")
	@Description("Test case #32, Verify Upload A Liability Wavier Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #32, Verify Upload A Liability Wavier Functionality")
	public void VerifyUploadALiabilityWavierFunctionality() {
		logger.info("Starting of VerifyGoBackButtonFunctionality method");

		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		Assert.assertTrue(addEventPage.isDisplayedRemoveAndReplaceContains());

		logger.info("Ending of VerifyGoBackButtonFunctionality method");
	}

	@Test(priority = 33, description = "Verify Liability Waiver Remove Icon", groups = "sanity")
	@Description("Test case #33, Verify Liability Waiver Remove Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #33, Verify Liability Waiver Remove Icon")
	public void VerifyLiabilityWaiverRemoveIcon() {
		logger.info("Starting of VerifyLiabilityWaiverRemoveIcon method");

		addEventPage.clickonLiabilityWaiverRemoveButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		logger.info("Ending of VerifyLiabilityWaiverRemoveIcon method");
	}

	@Test(priority = 34, description = "Verify Minimum Chars Validation In RefundPolicy", groups = "sanity")
	@Description("Test case #34, Verify Minimum Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #34, Verify Minimum Chars Validation In AboutTheEvent")
	public void VerifyMinimumCharsValidationInRefundPolicy() {
		logger.info("Starting of VerifyMinimumCharsValidationInRefundPolicy method");

		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("refund.policies.minimum.char"));

		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventNegativePage.isMinimumTenCharsValidationDisplayed());

		logger.info("Ending of VerifyMinimumCharsValidationInRefundPolicy method");
	}

	@Test(priority = 35, description = "Verify Maximum Chars Validation In RefundPolicy", groups = "sanity")
	@Description("Test case #35, Verify Maximum Chars Validation In RefundPolicy")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #35, Verify Maximum Chars Validation In RefundPolicy")
	public void VerifyMaximumCharsValidationInRefundPolicy() {
		logger.info("Starting of VerifyMaximumCharsValidationInRefundPolicy method");

		String RefundMaximumChars = RandomStringUtils.randomAlphabetic(4510);
		System.out.println("about max characters text: ***" + RefundMaximumChars);
		addEventPage.setRefundPolicyEdit(RefundMaximumChars);

		Assert.assertTrue(this.addEventNegativePage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of VerifyMaximumCharsValidationInRefundPolicy method");
	}

	@Test(priority = 36, description = "Verify Maximum Chars Validation In HealthSafety", groups = "sanity")
	@Description("Test case #36, Verify Maximum Chars Validation In RefundPolicy")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #36, Verify Maximum Chars Validation In RefundPolicy")
	public void VerifyMaximumCharsValidationInHealthSafety() {
		logger.info("Starting of VerifyMaximumCharsValidationInHealthSafety method");

		String healthysafetyTheEventMaximumChars = RandomStringUtils.randomAlphabetic(4510);
		System.out.println("about max characters text: ***" + healthysafetyTheEventMaximumChars);
		addEventPage.setRefundPolicyEdit(healthysafetyTheEventMaximumChars);

		Assert.assertTrue(this.addEventNegativePage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of VerifyMaximumCharsValidationInHealthSafety method");
	}

	@Test(priority = 37, description = "Verify Event Policies Page By Entering Valid Details", groups = "sanity")
	@Description("Test case #37, Verify Event Policies Page By Entering Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #37, Verify Event Policies Page By Entering Valid Details")
	public void VerifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of VerifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage
				.setUploadaLiabilityWaiverButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		addEventPage.isDisplayedRemoveAndReplaceContains();

		// addEventPage.clickonReplaceButton();

		// addEventPage.setReplaceButton(BASE_DIR + FILE_SEPARATOR +
		// testDataProp.getProperty("replace.image"));

		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("about.the.Event"));

		addEventPage.setHealthandSafetyPolicyEdit(testDataProp.getProperty("about.the.Event"));

		addEventPage.clickonNextButton();

		logger.info("Ending of VerifyEventPoliciesPageByEnteringValidDetails method");
	}

	@Test(priority = 38, description = "Verify Add Bracket Page With Empty Fields", groups = "sanity")
	@Description("Test case #38, Verify Add Bracket Page With Empty Fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #38, Verify Add Bracket Page With Empty Fields")
	public void VerifyAddBracketPageWithEmptyFields() {
		logger.info("Starting of VerifyAddBracketPageWithEmptyFields method");

		addEventPage.clickonNextButton();

		Assert.assertTrue(addBracketNegativePage.isAddBracketFieldsWithEmptyDetailsDisplayed());

		logger.info("Ending of VerifyAddBracketPageWithEmptyFields method");
	}

	@Test(priority = 39, description = "Verify AddBracket Age Range Min Age", groups = "sanity")
	@Description("Test case #39, Verify AddBracket Age Range Min Age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #39, Verify AddBracket Age Range Min Age")
	public void VerifyAddBracketAgeRangeMinAge() {
		logger.info("Starting of VerifyAddBracketAgeRangeMinAge method");

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum.error"));

		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMinimumAgeValidationDisplayed());

		logger.info("Ending of VerifyAddBracketAgeRangeMinAge method");
	}

	@Test(priority = 40, description = "Verify AddBracket Age Range Max Age", groups = "sanity")
	@Description("Test case #40, Verify AddBracket Age Range Max Age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #40, Verify AddBracket Age Range Max Age")
	public void VerifyAddBracketAgeRangeMaxAge() {
		logger.info("Starting of VerifyAddBracketAgeRangeMaxAge method");

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum.error"));

		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMaximumAgeValidationDisplayed());

		logger.info("Ending of VerifyAddBracketAgeRangeMaxAge method");
	}

	@Test(priority = 41, description = "Verify AddBracket AgeRange MaxAge Less Then Min", groups = "sanity")
	@Description("Test case #41, Verify AddBracket AgeRange MaxAge Less Then Min")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #41, Verify AddBracket AgeRange MaxAge Less Then Min")
	public void VerifyAddBracketAgeRangeMaxAgeLessThenMin() {
		logger.info("Starting of VerifyAddBracketAgeRangeMaxAgeLessThenMin method");

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.min.age.in.max.error"));
		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.max.age.in.min.error"));
		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMaximumAgeValidationDisplayed());

		Assert.assertTrue(addBracketNegativePage.isMaxAgeHigheThenMinrValidationDisplayed());

		logger.info("Ending of VerifyAddBracketAgeRangeMaxAgeLessThenMin method");
	}

	@Test(priority = 42, description = "Verify AddBracket RatingRange MaxAge Less Then Min", groups = "sanity")
	@Description("Test case #42, Verify AddBracket RatingRange MaxAge Less Then Min")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #42, Verify AddBracket RatingRange MaxAge Less Then Min")
	public void VerifyAddBracketRatingRangeMaxAgeLessThenMin() {
		logger.info("Starting of VerifyAddBracketRatingRangeMaxAgeLessThenMin method");

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("rating.range.min.age.in.max.error"));
		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("rating.range.max.age.in.min.error"));

		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMinimumRatingRangeMessageDisplayed());

		Assert.assertTrue(addBracketNegativePage.isMaxAgeHigheThenMinrValidationDisplayed());

		logger.info("Ending of VerifyAddBracketRatingRangeMaxAgeLessThenMin method");
	}

	@Test(priority = 43, description = "Verify Validation For RatingRange With LessThan Minimum Characters", groups = "sanity")
	@Description("Test case #43, Verify Validation For RatingRange With LessThan Minimum Characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #43, Verify Validation For RatingRange With LessThan Minimum Characters")
	public void VerifyValidationForRatingRangeWithLessThanMinimumCharacters() {
		logger.info("Starting of VerifyValidationForRatingRangeWithLessThanMinimumCharacters method");

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("rating.range.minimum.error"));

		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMinRatingRangeValidationMessageDisplayed());

		logger.info("Ending of VerifyValidationForRatingRangeWithLessThanMinimumCharacters method");
	}

	@Test(priority = 44, description = "Verify Validation For RatingRange With MoreThan Maximum Characters", groups = "sanity")
	@Description("Test case #44, Verify Validation For RatingRange With MoreThan Maximum Characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #44, Verify Validation For RatingRange With MoreThan Maximum Characters")
	public void VerifyValidationForRatingRangeWithMoreThanMaximumCharacters() {
		logger.info("Starting of VerifyValidationForRatingRangeWithMoreThanMaximumCharacters method");

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("rating.range.maximum.error"));

		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketNegativePage.isMinimumRatingRangeMessageDisplayed());

		logger.info("Ending of VerifyValidationForRatingRangeWithMoreThanMaximumCharacters method");
	}

	@Test(priority = 45, description = "Verify State Of AutoGenerate Functionality After Entering Details", groups = "sanity")
	@Description("Test case #45, Verify State Of AutoGenerate Functionality After Entering Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #45, Verify State Of AutoGenerate Functionality After Entering Details")
	public void VerifyStateOfAutoGenerateFunctionalityAfterEnteringDetails() {
		logger.info("Starting of VerifyStateOfAutoGenerateButtonAfterEnteringDetails method");

		addBracketPage.clickonTypeDropdown();
		addBracketPage.clickonPlayGroupDropdown();
		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));

		Assert.assertTrue(addBracketNegativePage.isAutoGenerateButtonEnabled());

		logger.info("Ending of VerifyStateOfAutoGenerateFunctionalityAfterEnteringDetails method");
	}

	@Test(priority = 46, description = "Verify State Of AutoGenerate Functionality After Entering Details", groups = "sanity")
	@Description("Test case #46, Verify State Of AutoGenerate Functionality After Entering Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #46, Verify State Of AutoGenerate Functionality After Entering Details")
	public void VerifyAutoGeneratefunctionality() {
		logger.info("Starting of VerifyAutoGeneratefunctionality method");

		addBracketPage.clickOnAutoGenerate();
		Assert.assertFalse(addBracketNegativePage.isBracketNameAutoGenerated());

		logger.info("Ending of VerifyAutoGeneratefunctionality method");
	}

	@Test(priority = 47, description = "Verify State Of AutoGenerate Functionality After AutoGenerating BracketName", groups = "sanity")
	@Description("Test case #47, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #47, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	public void VerifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName() {
		logger.info("Starting of VerifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonDisabled());

		logger.info("Ending of VerifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");
	}

	@Test(priority = 48, description = "Verify NumberOfCourts functionality With Invalid Input", groups = "sanity")
	@Description("Test case #48, Verify NumberOfCourts functionality With Invalid Input")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #48, Verify NumberOfCourts functionality With Invalid Input")
	public void VerifyNumberOfCourtsfunctionalityWithInvalidInput() {
		logger.info("Starting of VerifyNumberOfCourtsfunctionalityWithInvalidInput method");

		addBracketPage.clickOnEventTypeWaterfallDropdown();
		addBracketPage.setNumberOfCourt(testDataProp.getProperty("number.of.courts"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isNumberOfCourtsValidationDisplayed());

		logger.info("Ending of VerifyNumberOfCourtsfunctionalityWithInvalidInput method");
	}

	/*@Test(priority = 49, description = "Verify Registration Dates with Invalid Details", groups = "sanity")
	@Description("Test case #49, Verify Registration Dates with Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #49, Verify Registration Dates with Invalid Details")
	public void VerifyRegistrationDateswithInvalidDetails() {
		logger.info("Starting of VerifyRegistrationDateswithInvalidDetails method");

		addBracketPage.setRegistrationStartDate();
		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date.error"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isRegestrationInvalidMsgDisplayed());

		logger.info("Ending of VerifyRegistrationDateswithInvalidDetails method");
	}

	@Test(priority = 50, description = "Verify Registration EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #50, Verify Registration EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #50, Verify Registration EndDate with Previous Date Of StartDate Details")
	public void VerifyRegistrationEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of VerifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setRegistrationStartDate(testDataProp.getProperty("registration.start.Date"));
		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isRegestrationEndDatewithPreviousDateOfStartDateMsgDisplayed());

		logger.info("Ending of VerifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 51, description = "Verify Competition Dates with Invalid Details", groups = "sanity")
	@Description("Test case #51, Verify Competition Dates with Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #51, Verify Competition Dates with Invalid Details")
	public void VerifyCompetitionDateswithInvalidDetails() {
		logger.info("Starting of VerifyCompetitionDateswithInvalidDetails method");

		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date.error"));
		addBracketPage.setCompetitionEndDate(testDataProp.getProperty("competition.end.Date.error"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isCompetitionInvalidMsgDisplayed());

		logger.info("Ending of VerifyCompetitionDateswithInvalidDetails method");
	}

	@Test(priority = 52, description = "Verify Competition EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #52, Verify Competition EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #52, Verify Competition EndDate with Previous Date Of StartDate Details")
	public void VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date"));
		addBracketPage.setCompetitionEndDate(testDataProp.getProperty("competition.end.Date"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed());

		logger.info("Ending of VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 53, description = "Verify Competition Start Date High Regestration End Date Details", groups = "sanity")
	@Description("Test case #53, Verify Competition Start Date High Regestration End Date Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #53, Verify Competition Start Date High Regestration End Date Details")
	public void VerifyCompetitionStartDateHighRegestrationEndDateDetails() {
		logger.info("Starting of VerifyCompetitionStartDateHighRegestrationEndDateDetails method");

		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date.high"));
		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date.low"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isComStartDateHighRegEndDateDisplayed());

		logger.info("Ending of VerifyCompetitionStartDateHighRegestrationEndDateDetails method");
	}*/

	@Test(priority = 54, description = "Verify Bracket Club Member NonMember Price Validation Details", groups = "sanity")
	@Description("Test case #54, Verify Bracket Club Member NonMember Price Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #54, Verify Bracket Club Member NonMember Price Validation Details")
	public void VerifyBracketClubMemberNonMemberPriceValidationDetails() {
		logger.info("Starting of VerifyBracketClubMemberNonMemberPriceValidationDetails method");

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("memberPrice.value.error"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("nonMemberPrice.value.error"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isBracketClubMemNonMemValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketClubMemberNonMemberPriceValidationDetails method");
	}

	@Test(priority = 55, description = "Verify Bracket NumberOfTeams Validation Details", groups = "sanity")
	@Description("Test case #55, Verifys Brackets NumberOfTeams Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #55, Verifys Brackets NumberOfTeams Validation Details")
	public void VerifyBracketNumberOfTeamsValidationDetails() {
		logger.info("Starting of VerifyBracketNumberOfTeamValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.terms.error"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isBracketNumberOfTeamsValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketNumberOfTeamValidationDetails method");
	}

	@Test(priority = 56, description = "Verify Bracket NumberOfTeams Max Validation Details", groups = "sanity")
	@Description("Test case #56, Verifys Brackets NumberOfTeams Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #56, Verifys Brackets NumberOfTeams Max Validation Details")
	public void VerifyBracketNumberOfTeamsMaxValidationDetails() {
		logger.info("Starting of VerifyBracketNumberOfTeamsMaxValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.terms.max.error"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isBracketNumberOfTeamsMaxValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketNumberOfTeamsMaxValidationDetails method");
	}

	@Test(priority = 57, description = "Verify Bracket Waitlist Negative Validation Details", groups = "sanity")
	@Description("Test case #57, Verify Bracket Waitlist Negative Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #57, Verify Bracket Waitlist Negative Validation Details")
	public void VerifyBracketWaitlistNegativeValidationDetails() {
		logger.info("Starting of VerifyBracketWaitlistNegativeValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list.negative.value"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isBracketWaitlistNegativeValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketWaitlistNegativeValidationDetails method");
	}

	@Test(priority = 58, description = "Verify Bracket Waitlist Max Validation Details", groups = "sanity")
	@Description("Test case #58, Verify Bracket Waitlist Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #58, Verify Bracket Waitlist Max Validation Details")
	public void VerifyBracketWaitlistMaxValidationDetails() {
		logger.info("Starting of VerifyBracketWaitlistMaxValidationDetails method");

		// addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list.max.value"));
		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isBracketWaitListMaxValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketWaitlistMaxValidationDetails method");
	}

	@Test(priority = 59, description = "Verify Bracket Combination Of MixedPlayer Group And Single Type", groups = "sanity")
	@Description("Test case #59, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #59, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	public void VerifyBracketCombinationOfMixedPlayerGroupAndSingleType() {
		logger.info("Starting of VerifyBracketCombinationOfMixedPlayerGroupAndSingleType method");

		addEventPage.clickonGoBackButton();
		addBracketNegativePage.clickOnNextStepButton();
		addBracketNegativePage.hardWait(2);
		
		addBracketPage.clickonTypeDropdown();
		addBracketNegativePage.hardWait(2);
		addBracketPage.clickOnSinglesBracketTypeButton();
		
		addBracketPage.clickonPlayGroupDropdown();
		addBracketNegativePage.hardWait(2);
		addBracketPage.clickOnMixedMatchGroupButton();

		addBracketNegativePage.clickOnNextStepButton();
		Assert.assertTrue(addBracketNegativePage.isMixedGroupSinglesValidationDisplayed());

		logger.info("Ending of VerifyBracketCombinationOfMixedPlayerGroupAndSingleType method");
	}

	@Test(priority = 60, description = "Verify Bracket RoundRobin Event Type", groups = "sanity")
	@Description("Test case #60, Verify Bracket RoundRobin Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #60, Verify Bracket RoundRobin Event Type")
	public void VerifyBracketRoundRobinEventType() {
		logger.info("Starting of VerifyBracketRoundRobinEventType method");

		addEventPage.clickonGoBackButton();
		addBracketNegativePage.clickOnNextStepButton();
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketNegativePage.isRounRobinNumberOfCourtsDisplayed());
		Assert.assertTrue(addBracketPage.isNumberOfTeamsDisplayed());
		// addBracketNegativePage.clickOnNextStepButton();

		logger.info("Ending of VerifyBracketRoundRobinEventType method");
	}

	@Test(priority = 61, description = "Verify Bracket Waterfall Event Type", groups = "sanity")
	@Description("Test case #61, Verify Bracket Waterfall Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #61, Verify Bracket Waterfall Event Type")
	public void VerifyBracketWaterfallEventType() {
		logger.info("Starting of VerifyBracketWaterfallEventType method");

		addEventPage.clickonGoBackButton();
		addBracketNegativePage.clickOnNextStepButton();
		addBracketPage.clickOnEventTypeWaterfallDropdown();
		Assert.assertTrue(addBracketPage.isNumberOfCourtsWaterFallValidationDisplayed());
		Assert.assertTrue(addBracketNegativePage.isWaterFallNumberOfTeamsDisplayed());
		addBracketNegativePage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddBracketPageContainsDisplayed());

		logger.info("Ending of VerifyBracketWaterfallEventType method");
	}

	@Test(priority = 62, description = "Verify AddBrackets Page With Valid Details", groups = "sanity")
	@Description("Test case #62, Verify AddBrackets Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #62, Verify AddBrackets Page With Valid Details")
	public void VerifyAddBracketsPageWithValidDetails() {
		logger.info("Starting of VerifyAddBracketsPageWithValidDetails method");

		addBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketListDisplayed());
		addBracketPage.clickOnDoublesBracketTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedBracketTypeDisplayed());

		addBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.clickOnMixedMatchGroupButton();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

		// Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerate();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListDisplayed());
		addBracketPage.clickOnRoundRobinEventTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		// Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("memberPrice.value"));
		// Assert.assertTrue(addBracketPage.isEnteredClubMemberPriceDisplayed());

		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("nonMemberPrice.value"));
		// Assert.assertTrue(addBracketPage.isEnteredClubNonMemberPriceDisplayed());

		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		Assert.assertTrue(addBracketPage.isAddAnotherBracketPopUpContains());

		logger.info("Ending of VerifyAddBracketsPageWithValidDetails method");
	}

	@Test(priority = 63, description = "Verify AddAnotherBracket button In AddAnotherBracketPopup", groups = "sanity")
	@Description("Test case #63, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #63, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	public void VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup() {
		logger.info("Starting of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");

		addBracketPage.clickOnAddAnotherBracketButton();
		addBracketPage.clickonBracket1Button();

		Assert.assertTrue(addBracketPage.isAddNewBracketPageContainsDisplayed());

		logger.info("Ending of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");
	}

	@Test(priority = 64, description = "Verify  Delete Bracket button fuctionality", groups = "sanity")
	@Description("Test case #64, Verify  Delete Bracket button fuctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #64, Verify  Delete Bracket button fuctionality")
	public void VerifyDeleteBracketFuctionality() {
		logger.info("Starting of VerifyDeleteBracketFuctionality method");

		// addBracketPage.clickonBracket1Button();

		addBracketPage.clickOnDeleteBracketButton();

		Assert.assertFalse(addBracketPage.isDeleteBracketDisplayed());

		addEventPage.clickonNextButton();

		logger.info("Ending of VerifyDeleteBracketFuctionality method");
	}

	@Test(priority = 65, description = "Verify Results On Click Of Close Icon In Add Another Bracket? popup", groups = "sanity")
	@Description("Test case #65, Verify Results On Click Of Close Icon In Add Another Bracket? popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #65,Verify Results On Click Of Close Icon In Add Another Bracket? popup")
	public void VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup method");

		addBracketPage.clickOnCloseIconButton();

		addBracketPage.clickonBracket1Button();

		addEventPage.clickonNextButton();

		logger.info("Ending of VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup method");
	}

	@Test(priority = 66, description = "Verify NoContinueToSummary Button In AddAnotherBracket popup", groups = "sanity")
	@Description("Test case #66, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #66, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	public void VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");

		addBracketPage.clickOnNoContinueToSummary();

		Assert.assertTrue(addBracketPage.isEventDetailsSectionDisplayed());
		Assert.assertTrue(addBracketPage.isEventPoliciesSectionDisplayed());
		Assert.assertTrue(addBracketPage.isBracketsSectionDisplayed());

		logger.info("Ending of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");
	}

	@Test(priority = 67, description = "Verify delete Bracket In Summary Page", groups = "sanity")
	@Description("Test case #67, Verify delete Bracket In Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #67, Verify delete Bracket In Summary Page")
	public void VerifyDeleteBracketDetailsInSummaryPage1() {
		logger.info("Starting of VerifyDeleteBracketDetailsInSummaryPage1 method");

		addBracketPage.clickOnEditBracketsButton();

		this.VerifyAddBracketsPageWithValidDetails();
		Assert.assertTrue(addBracketPage.isAddAnotherBracketPopUpContains());

		addBracketPage.clickOnAddAnotherBracketButton();
		addBracketPage.clickOnDeleteBracketButton();

		Assert.assertFalse(addBracketPage.isDeleteBracketDisplayed());

		addEventPage.clickonNextButton();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyDeleteBracketDetailsInSummaryPage1");
	}

	@Test(priority = 68, description = "Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #68, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #68, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	public void VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		Assert.assertTrue(addBracketPage.isEditEventDetailsButtonDisplayed());
		addBracketPage.clickOnEditEventDetailsButton();

		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();
		addEventPage.clickonNextButton();
		this.VerifyEventPoliciesPageByEnteringValidDetails();
		addBracketPage.clickonBracket1Button();
		this.VerifyAddBracketsPageWithValidDetails();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");
	}

	@Test(priority = 69, description = "Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #69, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #69, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	public void VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		addBracketPage.clickOnEditBracketsButton();

		addBracketPage.clickonBracket1Button();
		this.VerifyAddBracketsPageWithValidDetails();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage");
	}

	@Test(priority = 70, description = "Verify Results On Click Of Go Back Button In Summary Page", groups = "sanity")
	@Description("Test case #70, Verify Results On Click Of Go Back Button In Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #70, Verify Results On Click Of Go Back Button In Summary Page")
	public void VerifyResultsOnClickOfGoBackButtonInSummaryPage() {
		logger.info("Starting of VerifyResultsOnClickOfGoBackButtonInSummaryPage method");

		addBracketPage.clickonGoBackButton();

		Assert.assertTrue(addBracketPage.isPublishEventButtonDisplayed());

		logger.info("Ending of VerifyResultsOnClickOfGoBackButtonInSummaryPage method");
	}

	@Test(priority = 68, description = "Verify Draft Event in Clubs page-Events Tab Functionality", groups = "sanity")
	@Description("Test case #68, Verify Draft Event in Clubs page-Events Tab Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #68, Verify Draft Event in Clubs page-Events Tab Functionality")
	public void VerifyDeleteEventInClubsPageEventsTabFunctionality1() {
		logger.info("Starting of VerifyDraftEventInClubsPageEventsTabFunctionality method");

		addEventPage.clickonEventButton();
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyDraftEventInClubsPageEventsTabFunctionality method");
	}

	@Test(priority = 71, description = "Verify Publish Event Button", groups = "sanity")
	@Description("Test case #71, Verify Publish Event Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #71, Verify Publish Event Button")
	public void VerifyPublishEventButton() {
		logger.info("Starting of VerifyPublishEventButton method");

		addBracketPage.clickOnPublishEventButton();

		Assert.assertTrue(addBracketPage.isPublishSuccessPopUpContains());

		logger.info("Ending of VerifyPublishEventButton method");
	}

	@Test(priority = 72, description = "Verify Close Icon In YourEventIsNowPublished Success Popup", groups = "sanity")
	@Description("Test case #72, Verify Close Icon In YourEventIsNowPublished Success Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #72, Verify Close Icon In YourEventIsNowPublished Success Popup")
	public void VerifyCloseIconInYourEventIsNowPublishedSuccessPopup() {
		logger.info("Starting of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");

		addBracketPage.clickOnEventSuccessClosePopupButton();

		Assert.assertTrue(addEventPage.isDisplayedClubContains());

		logger.info("Ending of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");
	}

	@Test(priority = 73, description = "Verify Recently Added Event Under Events Tab", groups = "sanity")
	@Description("Test case #73, Verify Recently Added Event Under Events Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #73, Verify Recently Added Event Under Events Tab")
	public void VerifyRecentlyAddedEventUnderEventsTab() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addEventPage.clickonEventButton();
		addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		// String eventName = addEventPage.getEventName();
		// Assert.assertEquals(eventName,
		// expectedAssertionsProp.getProperty("event.name"));

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 74, description = "Verify Delete Bracket Functionality After Publishing Event", groups = "sanity")
	@Description("Test case #74, Verify Delete Bracket Functionality After Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #74, Verify Delete Bracket Functionality After Publishing Event")
	public void verifyDeleteBracketFunctionalityAfterPublishingEvent() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addEventPage.clickonAddEventButton();
		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();
		addEventPage.clickonNextButton();
		this.VerifyEventPoliciesPageByEnteringValidDetails();
		this.VerifyAddBracketsPageWithValidDetails();
		addBracketPage.clickOnAddAnotherBracketButton();
		this.VerifyAddBracketsPageWithValidDetails();
		addBracketPage.clickOnNoContinueToSummary();
		addBracketPage.clickOnPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		addEventPage.clickonEventButton();

		addEventPage.clickonRecentlyAddedEvent(testDataProp.getProperty("event.name"));

		addBracketPage.clickonDeleteBracket();

		Assert.assertTrue(addBracketPage.isDeleteBracketPopUpDisplayed());

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 75, description = "Verify Cancel Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #75, Verify Cancel Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #75, Verify Cancel Button Functionality In DeleteBracket")
	public void verifyCancelButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addBracketPage.clickonCancelButton();
		addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 76, description = "Verify Close Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #76, Verify Close Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #76, Verify Close  Button Functionality In DeleteBracket")
	public void verifyCloseButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of verifyCloseButtonFunctionalityInDeleteBracket method");

		addBracketPage.clickonDeleteBracket();
		addBracketPage.clickonCloseButton();
		addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		logger.info("Ending of verifyCloseButtonFunctionalityInDeleteBracket method");
	}

	@Test(priority = 77, description = "Verify Confirm Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #77, Verify Confirm Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #77, Verify Confirm  Button Functionality In DeleteBracket")
	public void verifyConfirmButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of verifyConfirmButtonFunctionalityInDeleteBracket method");

		addBracketPage.clickonDeleteBracket();
		addBracketPage.clickonConfirmButton();

		Assert.assertTrue(addBracketPage.isDeleteBracketSuccessPopUpDisplayed());

		logger.info("Ending of verifyConfirmButtonFunctionalityInDeleteBracket method");
	}

	@Test(priority = 78, description = "Verify Ok Button Functionality In DeleteBracket SuccessPopUP", groups = "sanity")
	@Description("Test case #78, Verify Ok Button Functionality In DeleteBracket SuccessPopUP")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #78, Verify Ok  Button Functionality In DeleteBracket SuccessPopUP")
	public void verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP() {
		logger.info("Starting of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");

		addBracketPage.clickonOkButton();

		Assert.assertFalse(addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name")));

		addBracketPage.clickonBackButton();
		logger.info("Ending of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");
	}

	@Test(priority = 79, description = "Verify Free Event Functionality", groups = "sanity")
	@Description("Test case #79, Verify Free Event Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #79, Verify Free Event Functionality")
	public void VerifyFreeEventFunctionality() {
		logger.info("Starting of VerifyFreeEventFunctionality method");

		addEventPage.clickonAddEventButton();

		addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		this.VerifyEventPoliciesPageByEnteringValidDetails();
		this.VerifyAddBracketsPageWithValidDetails();
		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();

		logger.info("Ending of VerifyFreeEventFunctionality method");
	}

	@Test(priority = 80, description = "Verify Free Bracket With Event Type As Round Robin", groups = "sanity")
	@Description("Test case #80, Verify Free Bracket With Event Type As Round Robin")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #80,Verify Free Bracket With Event Type As Round Robin")
	public void VerifyFreeBracketWithEventTypeAsRoundRobin() {
		logger.info("Starting of VerifyFreeBracketWithEventTypeAsRoundRobin method");

		addEventPage.clickonAddEventButton();

		addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		this.VerifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketListDisplayed());
		addBracketPage.clickOnDoublesBracketTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedBracketTypeDisplayed());

		addBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.clickOnMixedMatchGroupButton();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("age.range.minimum")));

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerate();

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListDisplayed());
		addBracketPage.clickOnRoundRobinEventTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));

		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();

		logger.info("Ending of VerifyFreeBracketWithEventTypeAsRoundRobin method");
	}

	@Test(priority = 81, description = "Verify Free Bracket With Event Type As Water Fall", groups = "sanity")
	@Description("Test case #81, Verify Free Bracket With Event Type As Water Fall")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #81,Verify Free Bracket With Event Type As Water Fall")
	public void VerifyFreeBracketWithEventTypeAsWateFall() {
		logger.info("Starting of VerifyFreeBracketWithEventTypeAsWateFall method");

		addEventPage.clickonAddEventButton();

		addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonNextButton();

		Assert.assertTrue(addEventPage.isDisplayedEventPoliciesPageContains());

		this.VerifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickonTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketListDisplayed());
		addBracketPage.clickOnDoublesBracketTypeButton();
		Assert.assertTrue(addBracketPage.isSelectedBracketTypeDisplayed());

		addBracketPage.clickonPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.clickOnMixedMatchGroupButton();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addBracketPage.setAgeRangeMinimum(testDataProp.getProperty("age.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("age.range.minimum")));

		addBracketPage.setAgeRangeMaximum(testDataProp.getProperty("age.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("age.range.maximum")));

		addBracketPage.setRatingRangeMinimum(testDataProp.getProperty("Rating.range.minimum"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerate();

		addBracketPage.clickOnEventTypeWaterfallDropdown();
		addBracketPage.setNumberOfCourt(testDataProp.getProperty("number.of.courts"));

		addBracketPage.clickOnRegistrationStartDate();
		addBracketPage.clickOnRegistrationEndDate();
		addBracketPage.clickOnCompetitionStartDate();
		addBracketPage.clickOnCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketPriceClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addBracketPage.setBracketPriceNonClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));

		// addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		// Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();

		logger.info("Ending of VerifyFreeBracketWithEventTypeAsWateFall method");
	}

	@Test(priority = 82, description = "Verify Delete Event Functionality after publishing the event", groups = "sanity")
	@Description("Test case #82, Verify Delete Event Functionality after publishing the event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #82, Verify Delete Event Functionality after publishing the event")
	public void VerifyDeleteEventFunctionalityAfterPublishingEvent() {
		logger.info("Starting of VerifyDeleteBracketFunctionalityAfterPublishingEvent method");

		addEventPage.clickonEventButton();
		addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name"));
		addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name"));

		addEventPage.ClickOnDeleteEventFromList(testDataProp.getProperty("event.name"));
		Assert.assertTrue(addEventPage.isDisplayedEventDeletePopUpContains());
		// String eventName = addEventPage.getEventName();
		// Assert.assertEquals(eventName,
		// expectedAssertionsProp.getProperty("event.name"));

		addEventPage.clickOnDeleteEventConfirmButton();

		Assert.assertTrue(addEventPage.isDisplayedEventDeleteSuccessPopUpContains());

		addEventPage.clickOnDeleteEventOKButton();
		Assert.assertFalse(addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name")));

		logger.info("Ending of VerifyDeleteBracketFunctionalityAfterPublishingEvent method");
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
