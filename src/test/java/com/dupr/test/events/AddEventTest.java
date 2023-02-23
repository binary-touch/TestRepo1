package com.dupr.test.events;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.clubs.MyClubsPage;
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

	private AddEventPage addEventPage = null;
	private AddBracketPage addBracketPage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;
	private static String freeEventName = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddEventTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_EVENT_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);

		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);

		logger.info("Ending of initMethod in AddEventTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
	public void verifyAddEventFunctionality() {
		logger.info("Starting of verifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.hardWait(3);
		try {
			if (clubLogoPage.isClubsDisplayedInMyClubs()) {
				addEventPage.clickOnSimbaClubName();
			} else {
				myClubsPage.clickOnBrowseClubsButton();
				Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
				addEventPage.clickOnSimbaClubName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		addEventPage.clickOnAddEventButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		logger.info("Ending of verifyAddEventFunctionality method");
	}

	@Test(priority = 2, description = "Verify Exit Button Without Entering Any Details In Event Information Page", groups = "sanity")
	@Description("Test case #2, Verify Exit Button Without Entering Any Details In Event Information Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Exit Button Without Entering Any Details In Event Information Page")
	public void verifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage() {
		logger.info("Starting of verifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage method");

		addEventPage.clickonExitButton();
		Assert.assertTrue(addEventPage.isClubPageContains());
		Assert.assertTrue(addEventPage.isClubDetailsDisplayed());

		logger.info("Ending of verifyExitButtonWithoutEnteringAnyDetailsInEventInformationPage method");
	}

	@Test(priority = 3, description = "Verify Event Info Page With EmptyFields", groups = "sanity")
	@Description("Test case #3, Verify Event Info Page With EmptyFields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Event Info Page With EmptyFields")
	public void VerifyEventInfoPageWithEmptyFields() {
		logger.info("Starting of VerifyEventInfoPageWithEmptyFields method");

		addEventPage.clickOnAddEventButton();
		addEventPage.hardWait(3);
		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(5);

		Assert.assertTrue(addEventPage.isEventInfoPageValidationsDisplayed());

		logger.info("Ending of VerifyEventInfoPageWithEmptyFields method");
	}

	@Test(priority = 4, description = "Verify Event Name Field Max Characters validation", groups = "sanity")
	@Description("Test case #4, Verify Event Name Field Max Characters validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Name Field Max Characters validation")
	public void VerifyEventNameFieldWithMaxCharacters() {
		logger.info("Starting of VerifyEventNameFieldWithMaxCharacters method");

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

		logger.info("Ending of VerifyEventNameFieldWithMaxCharacters method");
	}

	@Test(priority = 5, description = "Verify Member And NonMember Price Fields With Invalid Details", groups = "sanity")
	@Description("Test case #5, Verify Member And NonMember Price Fields With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Member And NonMember Price Fields With Invalid Details")
	public void verifyMemberAndNonMemberPriceFieldsWithInvalidDetails() {
		logger.info("Starting of verifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");

		addEventPage.setMemberPrice(addEventPage.randomNumber(25));
		addEventPage.setNonMemberPrice(addEventPage.randomNumber(25));

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addEventPage.isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed());

		logger.info("Ending of verifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");
	}

	@Test(priority = 6, description = "Verify Member And Nonmember Price Fields With Negative Values", groups = "sanity")
	@Description("Test case #6, Verify Member And Nonmember Price Fields With Negative Values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Member And Nonmember Price Fields With Negative Values")
	public void verifyMemberAndNonmemberPriceFieldsWithNegativeValues() {
		logger.info("Starting of verifyMemberAndNonmemberPriceFieldsWithNegativeValues method");

		addEventPage.setMemberPrice(testDataProp.getProperty("negative.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("negative.value"));

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addEventPage.isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed());

		logger.info("Ending of verifyMemberAndNonmemberPriceFieldsWithNegativeValues method");
	}

	@Test(priority = 7, description = "Verify About The Event field Minimum Chars Validation", groups = "sanity")
	@Description("Test case #7, Verify About The Event field Minimum Chars Validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify About The Event field Minimum Chars Validation")
	public void verifyAboutTheEventMinimumCharsValidation() {
		logger.info("Starting of verifyAboutTheEventMinimumCharsValidation method");

		addEventPage.setAboutTheEvent(addEventPage.randomAlphabet(4));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isMinimumTenCharsValidationDisplayed());

		logger.info("Ending of verifyAboutTheEventMinimumCharsValidation method");
	}

	@Test(priority = 8, description = "Verify Font styles for the About event field", groups = "sanity")
	@Description("Test case #8, Verify Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Font styles for the About event field")
	public void verifyAboutEventFieldWithIndividualFontStyles() {
		logger.info("Starting of verifyAboutEventFieldWithIndividualFontStyles method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		addEventPage.clickonBoldTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldFontStyleDisplayed());

		addEventPage.clickonBoldTextFormattingButton();

		addEventPage.clickonItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicFontStyleDisplayed());

		addEventPage.clickonItalicTextFormattingButton();

		addEventPage.clickonUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isUnderlineFontStyleDisplayed());

		addEventPage.clickonUnderLineTextFormattingButton();

		logger.info("Ending of verifyAboutEventFieldWithIndividualFontStyles method");
	}

	@Test(priority = 9, description = "Verify About Event Field With All Formating Font Styles", groups = "sanity")
	@Description("Test case #9, Verify About Event Field With All Formating Font Styles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify About Event Field With All Formating Font Styles")
	public void verifyAboutEventFieldWithAllFormatingFontStyles() {
		logger.info("Starting of verifyAboutEventFieldWithAllFormatingFontStyles method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		addEventPage.clickonTextFormattingButtons();
		Assert.assertTrue(this.addEventPage.isBoldItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of verifyAboutEventFieldWithAllFormatingFontStyles method");
	}

	@Test(priority = 10, description = "Verify About Event Field With Combination Of Bold And Underline Font Styles", groups = "sanity")
	@Description("Test case #10, Verify About Event Field With Combination Of Bold And Underline Font Styles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify About Event Field With Combination Of Bold And Underline Font Styles")
	public void verifyAboutEventFieldWithCombinationOfBoldAndUnderlineFontStyles() {
		logger.info("Starting of verifyAboutEventFieldWithCombinationOfBoldAndUnderlineFontStyles method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		addEventPage.clickonBoldAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldUnderlineFontStylesDisplayed());

		logger.info("Ending of verifyAboutEventFieldWithCombinationOfBoldAndUnderlineFontStyles method");
	}

	@Test(priority = 11, description = "Verify About Event Field With Combination Of Italic And Underline Font Styles", groups = "sanity")
	@Description("Test case #11, Verify About Event Field With Combination Of Italic And Underline Font Styles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify About Event Field With Combination Of Italic And Underline Font Styles")
	public void verifyAboutEventFieldWithCombinationOfItalicAndUnderlineFontStyles() {
		logger.info("Starting of verifyAboutEventFieldWithCombinationOfItalicAndUnderlineFontStyles method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		addEventPage.clickonItalicAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of verifyAboutEventFieldWithCombinationOfItalicAndUnderlineFontStyles method");
	}

	@Test(priority = 12, description = "Verify About Event Field With Combination Of Bold And Italic Font Styles", groups = "sanity")
	@Description("Test case #12, Verify About Event Field With Combination Of Bold And Italic Font Styles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify About Event Field With Combination Of Bold And Italic Font Styles")
	public void verifyAboutEventFieldWithCombinationOfBoldAndItalicFontStyles() {
		logger.info("Starting of verifyAboutEventFieldWithCombinationOfBoldAndItalicFontStyles method");

		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));

		addEventPage.clickonBoldAndItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldItalicFontStylesDisplayed());

		logger.info("Ending of verifyAboutEventFieldWithCombinationOfBoldAndItalicFontStyles method");
	}

	@Test(priority = 13, description = "Verify About The Event Field Maximum Chars Validation", groups = "sanity")
	@Description("Test case #13, Verify About The Event Field Maximum Chars Validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify About The Event Field Maximum Chars Validation")
	public void verifyAboutTheEventMaximumCharsValidation() {
		logger.info("Starting of verifyAboutTheEventMaximumCharsValidation method");

		String aboutTheEventMaximumChars = RandomStringUtils.randomAlphabetic(4510);

		addEventPage.setAboutTheEvent(aboutTheEventMaximumChars);

		Assert.assertTrue(this.addEventPage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of verifyAboutTheEventMaximumCharsValidation method");
	}

	@Test(priority = 14, description = "Verify Invalid Logo Upload Functionality In Event Information Page", groups = "sanity")
	@Description("Test case #14, Verify Invalid Logo Upload Functionality In Event Information Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Invalid Logo Upload Functionality In Event Information Page")
	public void verifyInvalidLogoUploadFunctionality() {
		logger.info("Starting of verifyInvalidLogoUploadFunctionality method");

		addEventPage
				.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.invalid.logo.path"));

		Assert.assertTrue(this.addEventPage.isInvalidUploadLogoDisplayed());

		logger.info("Ending of verifyInvalidLogoUploadFunctionality method");
	}

	@Test(priority = 15, description = "Verify Remove Event logo Functionality In Event Information Page", groups = "sanity")
	@Description("Test case #15, Verify Remove Event logo Functionality In Event Information Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Remove Event logo Functionality In Event Information Page")
	public void verifyRemoveEventLogoFunctionality() {
		logger.info("Starting of verifyRemoveEventLogoFunctionality method");

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		addEventPage.clickonRemovelogoIcon();

		Assert.assertTrue(this.addEventPage.isDragandDropImageTextDispalyed());

		logger.info("Ending of verifyRemoveEventLogoFunctionality method");
	}

	@Test(priority = 16, description = "VerifyExitEventCreationPopupAfterFillingEventInformationDetails", groups = "sanity")
	@Description("Test case #16, VerifyExitEventCreationPopupAfterFillingEventInformationDetails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, VerifyExitEventCreationPopupAfterFillingEventInformationDetails")
	public void verifyExitEventCreationPopupAfterFillingEventInformationDetails() {
		logger.info("Starting of verifyExitEventCreationPopupAfterFillingEventInformationDetails method");

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.setMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonExitButton();

		Assert.assertTrue(addEventPage.isExitEventCreationPopupContains());

		addEventPage.clickOnExitEventCreationCloseIcon();

		logger.info("Ending of verifyExitEventCreationPopupAfterFillingEventInformationDetails method");
	}

	@Test(priority = 17, description = "Verify Event Information Page With Valid Details", groups = "sanity")
	@Description("Test case #17, Verify Event Information Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify Event Information Page With Valid Details")
	public void verifyEventInformationPageWithValidDetails() {
		logger.info("Starting of verifyEventInformationPageWithValidDetails method");

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(2);
		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of verifyEventInformationPageWithValidDetails method");
	}

	@Test(priority = 18, description = "Verify Exit Event Creation Popup Details In Event Policies", groups = "sanity")
	@Description("Test case #18, Verify Exit Event Creation Popup Details In Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify Exit Event Creation Popup Details In Event Policies")
	public void verifyExitEventCreationPopupDetailsInEventPolicies() {
		logger.info("Starting of verifyExitEventCreationPopupDetailsInEventPolicies method");

		addEventPage.clickonExitButton();

		Assert.assertTrue(addEventPage.isExitEventCreationPopupContains());

		logger.info("Ending of verifyExitEventCreationPopupDetailsInEventPolicies method");
	}

	@Test(priority = 19, description = "Verify Event Policies Discard Functionality", groups = "sanity")
	@Description("Test case #19, Verify Event Policies Discard Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify Event Policies Discard Functionality")
	public void verifyEventPoliciesDiscardFunctionality() {
		logger.info("Starting of verifyEventPoliciesDiscardFunctionality method");

		addEventPage.clickOnEventPoliciesDiscardButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of verifyEventPoliciesDiscardFunctionality method");
	}

	@Test(priority = 20, description = "Verify Event Policies Save As Draft Functionality", groups = "sanity")
	@Description("Test case #20, Verify Event Policies Save As Draft Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify Event Policies Save As Draft Functionality")
	public void verifyEventPoliciesSaveAsDraftFunctionality() {
		logger.info("Starting of verifyEventPoliciesSaveAsDraftFunctionality method");

		addEventPage.clickOnAddEventButton();

		this.verifyExitEventCreationPopupAfterFillingEventInformationDetails();
		this.verifyEventInformationPageWithValidDetails();

		addEventPage.clickonExitButton();
		addEventPage.clickOnSaveAsDraftButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of verifyEventPoliciesSaveAsDraftFunctionality method");
	}

	@Test(priority = 21, description = "Verify Recently Drafted Event In Events Tab", groups = "sanity")
	@Description("Test case #21, Verify Recently Drafted Event In Events Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify Recently Drafted Event In Events Tab")
	public void verifyRecentlyDraftedEventInEventsTab() {
		logger.info("Starting of verifyRecentlyDraftedEventInEventsTab method");

		addEventPage.clickOnEventsTab();
		Assert.assertTrue(addEventPage.isDraftEventDisplayed(eventName));
		Assert.assertTrue(addEventPage.isDeleteEventButtonDisplayedForDraftEvent(eventName));

		logger.info("Ending of verifyRecentlyDraftedEventInEventsTab method");
	}

	@Test(priority = 22, description = "Verify Delete Draft Event Functionality Before Publishing Event", groups = "sanity")
	@Description("Test case #22, Verify Delete Draft Event Functionality Before Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #22, Verify Delete Draft Event Functionality Before Publishing Event")
	public void verifyDeleteDraftEventFunctionalityBeforePublishingEvent() {
		logger.info("Starting of verifyDeleteDraftEventFunctionalityBeforePublishingEvent method");

		addEventPage.clickOnDeleteEventFromList(eventName);
		Assert.assertTrue(addEventPage.isDeleteEventPopUpContains());

		logger.info("Ending of verifyDeleteDraftEventFunctionalityBeforePublishingEvent method");
	}

	@Test(priority = 23, description = "Verify CancelButton Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #23, Verify CancelButton Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #23, Verify CancelButton Functionality In Delete Event PopUp")
	public void verifyCancelButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of verifyCancelButtonFunctionalityInDeleteEventPopUp method");

		addEventPage.clickOnDeleteEventCancelButton();
		Assert.assertTrue(addEventPage.isDraftEventDisplayed(eventName));

		logger.info("Ending of verifyCancelButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 24, description = "Verify CloseButton Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #24, Verify CloseButton Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #24, Verify CloseButton Functionality In Delete Event PopUp")
	public void VerifyCloseButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of VerifyCloseButtonFunctionalityInDeleteEventPopUp method");

		this.verifyDeleteDraftEventFunctionalityBeforePublishingEvent();
		addEventPage.clickOnDeleteEventCloseButton();
		Assert.assertTrue(addEventPage.isDraftEventDisplayed(eventName));

		logger.info("Ending of VerifyCloseButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 25, description = "Verify Confirm Button Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #25, Verify Confirm Button Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #25, Verify Confirm Button Functionality In Delete Event PopUp")
	public void verifyConfirmButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of verifyConfirmButtonFunctionalityInDeleteEventPopUp method");

		this.verifyDeleteDraftEventFunctionalityBeforePublishingEvent();
		addEventPage.clickOnDeleteEventConfirmButton();

		Assert.assertTrue(addEventPage.isEventDeletedSuccessPopUpContains());

		logger.info("Ending of verifyConfirmButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 26, description = "Verify OK Button Functionality In Delete Event Success PopUp", groups = "sanity")
	@Description("Test case #26, Verify OK Button Functionality In Delete Event Success PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #26, Verify OK Button Functionality In Delete Event Success PopUp")
	public void verifyOKButtonFunctionalityInDeleteEventSuccessPopUp() {
		logger.info("Starting of verifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");

		addEventPage.clickOnDeleteEventOKButton();
		addEventPage.hardWait(3);

		Assert.assertFalse(addEventPage.isEventDeletedSuccessPopUpContains());

		logger.info("Ending of verifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");
	}

	@Test(priority = 27, description = "Verify Close Icon In Exit Event Creation popup in Event Policies", groups = "sanity")
	@Description("Test case #27, Verify Close Icon In Exit Event Creation popup in Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #27, Verify Close Icon In Exit Event Creation popupp in Event Policies")
	public void verifyCloseIconInExitEventCreationInEventPoliciespopup() {
		logger.info("Starting of VerifyCloseIconInExitEventCreationpopup method");

		addEventPage.clickOnAddEventButton();

		this.verifyExitEventCreationPopupAfterFillingEventInformationDetails();
		this.verifyEventInformationPageWithValidDetails();

		addEventPage.clickonExitButton();
		addEventPage.clickOnExitEventCreationCloseIcon();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of VerifyCloseIconInExitEventCreationInEventPoliciespopup method");
	}

	@Test(priority = 28, description = "Verify Event Refund Policy Required Validation in Event Policies page", groups = "sanity")
	@Description("Test case #28, Verify Event Refund Policy Required Validation in Event Policies page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #28, Verify Event Refund Policy Required Validation in Event Policies page")
	public void verifyEventRefundPolicyReqValidation() {
		logger.info("Starting of verifyEventRefundPolicyReqValidation method");

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(this.addEventPage.isEventRefundPolicyRequiredDisplayed());

		logger.info("Ending of verifyEventRefundPolicyReqValidation method");
	}

	@Test(priority = 29, description = "Verify Go Back Button Functionality", groups = "sanity")
	@Description("Test case #29, Verify Go Back Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #29, Verify Go Back Button Functionality")
	public void VerifyGoBackButtonFunctionality() {
		logger.info("Starting of VerifyGoBackButtonFunctionality method");

		addEventPage.clickonGoBackButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		logger.info("Ending of VerifyGoBackButtonFunctionality method");
	}

	@Test(priority = 30, description = "Verify File Formats Supported By Liability Waiver in Event Polices Page", groups = "sanity")
	@Description("Test case #30, Verify File Formats Supported By Liability Waiver in Event Polices Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #30, Verify File Formats Supported By Liability Waiver in Event Polices Page")
	public void verifyFileFormatsSupportedByLiabilityWaiver() throws AWTException {
		logger.info("Starting of verifyFileFormatsSupportedByLiabilityWaiver method");

		addEventPage.clickOnNextStepButton();
		// addEventPage.clickOnLiabilityWaiverButton();

		// Assert.assertFalse(this.addEventPage.isFileExplorerContains());

		logger.info("Ending of verifyFileFormatsSupportedByLiabilityWaiver method");
	}

	@Test(priority = 31, description = "Verify Invalid LiabilityWaiver Upload Functionality In Event Policies Page", groups = "sanity")
	@Description("Test case #31, Verify Invalid LiabilityWaiver Upload Functionality In Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #31, Verify Invalid LiabilityWaiver Upload Functionality In EventPoliciesPage")
	public void verifyInvalidLiabilityWaiverFileUploadFunctionality() {
		logger.info("Starting of verifyInvalidLiabilityWaiverFileUploadFunctionality method");

		addEventPage.clickOnNextStepButton();
		addEventPage.uploadLiabilityWaiverFile(
				BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.invalid.logo.path"));

		Assert.assertTrue(this.addEventPage.isLiabilityWaiverInvalidValidationDisplayed());

		logger.info("Ending of verifyInvalidLiabilityWaiverFileUploadFunctionality method");
	}

	@Test(priority = 32, description = "Verify Valid Liability Wavier File Upload Functionality", groups = "sanity")
	@Description("Test case #32, Verify Valid Liability Wavier File Upload Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #32, Verify Valid Liability Wavier File Upload Functionality")
	public void verifyValidLiabilityWavierFileUploadFunctionality() {
		logger.info("Starting of verifyValidLiabilityWavierFileUploadFunctionality method");

		addEventPage.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		Assert.assertTrue(addEventPage.isRemoveAndReplaceOptionsDisplayed());

		logger.info("Ending of verifyValidLiabilityWavierFileUploadFunctionality method");
	}

	@Test(priority = 33, description = "Verify Liability Waiver Remove Icon", groups = "sanity")
	@Description("Test case #33, Verify Liability Waiver Remove Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #33, Verify Liability Waiver Remove Icon")
	public void verifyLiabilityWaiverRemoveIcon() {
		logger.info("Starting of verifyLiabilityWaiverRemoveIcon method");

		addEventPage.clickOnLiabilityWaiverRemoveButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of verifyLiabilityWaiverRemoveIcon method");
	}

	@Test(priority = 34, description = "Verify Replace Liability File Functionality in Event Policies Page", groups = "sanity")
	@Description("Test case #34, Verify Replace Liability File Functionality in Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #34, Verify Replace Liability File Functionality in Event Policies Page")
	public void verifyReplaceLiabilityFileFunctionality() throws AWTException {
		logger.info("Starting of verifyReplaceLiabilityFileFunctionality method");

		addEventPage.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		addEventPage.hardWait(2);
		// addEventPage.clickOnReplaceButton();

		// Assert.assertFalse(this.addEventPage.isFileExplorerContains());
		// addEventPage.pressEscapeKey();

		logger.info("Ending of verifyReplaceLiabilityFileFunctionality method");
	}

	@Test(priority = 35, description = "Verify Refund Policy Minimum Chars Validation in Event Policies Page", groups = "sanity")
	@Description("Test case #35, Verify Refund Policy Minimum Chars Validation in Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #35, Verify Refund Policy Minimum Chars Validation in Event Policies Page")
	public void verifyRefundPolicyMinimumCharsValidation() {
		logger.info("Starting of verifyRefundPolicyMinimumCharsValidation method");

		addEventPage.setRefundPolicy(addEventPage.randomAlphabet(4));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isMinimumTenCharsValidationDisplayed());

		logger.info("Ending of verifyRefundPolicyMinimumCharsValidation method");
	}

	@Test(priority = 36, description = "Verify Refund Policy Maximum Chars Validation in Event Policies Page", groups = "sanity")
	@Description("Test case #36, Verify Refund Policy Maximum Chars Validation in Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #36, Verify Refund Policy Maximum Chars Validation in Event Policies Page")
	public void verifyRefundPolicyMaximumCharsValidation() {
		logger.info("Starting of verifyRefundPolicyMaximumCharsValidation method");

		String RefundMaximumChars = RandomStringUtils.randomAlphabetic(4510);
		addEventPage.setRefundPolicy(RefundMaximumChars);

		Assert.assertTrue(this.addEventPage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of verifyRefundPolicyMaximumCharsValidation method");
	}

	@Test(priority = 37, description = "Verify Health and Safety Policy Maximum Chars Validation in Event Policies Page", groups = "sanity")
	@Description("Test case #37, Verify Health and Safety Policy Maximum Chars Validation in Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #37, Verify Health and Safety Policy Maximum Chars Validation in Event Policies Page")
	public void verifyHealthAndSafetyPolicyMaximumCharsValidation() {
		logger.info("Starting of verifyHealthAndSafetyPolicyMaximumCharsValidation method");

		String healthyAndSafetyMaximumChars = RandomStringUtils.randomAlphabetic(4510);
		addEventPage.setRefundPolicy(healthyAndSafetyMaximumChars);

		Assert.assertTrue(this.addEventPage.isMaximumCharsValidationDisplayed());

		logger.info("Ending of verifyHealthAndSafetyPolicyMaximumCharsValidation method");
	}

	@Test(priority = 38, description = "Verify Event Policies Page By Entering Valid Details", groups = "sanity")
	@Description("Test case #38, Verify Event Policies Page By Entering Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #38, Verify Event Policies Page By Entering Valid Details")
	public void verifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of verifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		Assert.assertTrue(addEventPage.isRemoveAndReplaceOptionsDisplayed());

		addEventPage.setRefundPolicy(testDataProp.getProperty("refund.policy"));
		addEventPage.setHealthAndSafetyPolicy(testDataProp.getProperty("health.policy"));

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyEventPoliciesPageByEnteringValidDetails method");
	}

	@Test(priority = 39, description = "Verify Add Bracket Page Empty Fields Validations", groups = "sanity")
	@Description("Test case #39, Verify Add Bracket Page Empty Fields Validations")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #39, Verify Add Bracket Page Empty Fields Validations")
	public void verifyAddBracketPageEmptyFieldsValidations() {
		logger.info("Starting of verifyAddBracketPageEmptyFieldsValidations method");

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddBracketPageEmptyFieldsValidationsDisplayed());

		logger.info("Ending of verifyAddBracketPageEmptyFieldsValidations method");
	}

	@Test(priority = 40, description = "Verify Minimum Age Range Validation in Add Brackets page", groups = "sanity")
	@Description("Test case #40, Verify Minimum Age Range Validation in Add Brackets page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #40, Verify Minimum Age Range Validation in Add Brackets page")
	public void verifyMinimumAgeRangeValidation() {
		logger.info("Starting of verifyMinimumAgeRangeValidation method");

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("zero.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumAgeValidationDisplayed());

		logger.info("Ending of verifyMinimumAgeRangeValidation method");
	}

	@Test(priority = 41, description = "Verify Maximum Age Range Validation in Add Brackets page", groups = "sanity")
	@Description("Test case #40, Verify Maximum Age Range Validation in Add Brackets page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #40, Verify Maximum Age Range Validation in Add Brackets page")
	public void verifyMaximumAgeRangeValidation() {
		logger.info("Starting of verifyMaximumAgeRangeValidation method");

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("invalid.max.age.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMaximumAgeValidationDisplayed());

		logger.info("Ending of verifyMaximumAgeRangeValidation method");
	}

	@Test(priority = 42, description = "Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age", groups = "sanity")
	@Description("Test case #42, Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #42, Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age")
	public void verifyAgeRangeValidationIfMaxAgeIsLesserThanMin() {
		logger.info("Starting of verifyAgeRangeValidationIfMaxAgeIsLesserThanMin method");

		addBracketPage.setMinimumAgeRange(addEventPage.randomNumber(10));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("invalid.max.age.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMaximumAgeValidationDisplayed());
		Assert.assertTrue(addBracketPage.isMaxAgeIsHigherThanMinValidationDisplayed());

		logger.info("Ending of verifyAgeRangeValidationIfMaxAgeIsLesserThanMin method");
	}

	@Test(priority = 43, description = "Verify Rating Range Field Validations With Invalid Details", groups = "sanity")
	@Description("Test case #43, Verify Rating Range Field Validations With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #43,Verify Rating Range Field Validations With Invalid Details")
	public void verifyRatingRangeFieldValidationsWithInvalidDetails() {
		logger.info("Starting of verifyRatingRangeFieldValidationsWithInvalidDetails method");

		addBracketPage.setMinimumRatingRange(addEventPage.randomNumber(10));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.age.range.in.min"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumRatingRangeMessageDisplayed());
		Assert.assertTrue(addBracketPage.isMaxAgeIsHigherThanMinValidationDisplayed());

		logger.info("Ending of verifyRatingRangeFieldValidationsWithInvalidDetails method");
	}

	@Test(priority = 44, description = "Verify RatingRange Validations Less Than Minimum Chars", groups = "sanity")
	@Description("Test case #44, Verify RatingRange Validations Less Than Minimum Chars")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #44, Verify RatingRange Validations Less Than Minimum Chars")
	public void verifyRatingRangeValidationsLessThanMinChars() {
		logger.info("Starting of verifyRatingRangeValidationsLessThanMinChars method");

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("invalid.minimum.rating.range"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinRatingRangeValidationMessageDisplayed());

		logger.info("Ending of verifyRatingRangeValidationsLessThanMinChars method");
	}

	@Test(priority = 45, description = "Verify RatingRange Validations More Than Minimum Chars", groups = "sanity")
	@Description("Test case #45, Verify RatingRange Validations More Than Minimum Chars")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #45, Verify RatingRange Validations More Than Minimum Chars")
	public void verifyRatingRangeValidationsMoreThanMaxChars() {
		logger.info("Starting of verifyRatingRangeValidationsMoreThanMaxChars method");

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("invalid.max.rating.range"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumRatingRangeMessageDisplayed());

		logger.info("Ending of verifyRatingRangeValidationsMoreThanMaxChars method");
	}

	@Test(priority = 46, description = "Verify State Of AutoGenerate Functionality After Entering Mandatory Details", groups = "sanity")
	@Description("Test case #46, Verify State Of AutoGenerate Functionality After Entering Mandatory Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #46, Verify State Of AutoGenerate Functionality After Entering Mandatory Details")
	public void verifyStateOfAutoGenerateButtonAfterEnteringMandatoryDetails() {
		logger.info("Starting of verifyStateOfAutoGenerateButtonAfterEnteringMandatoryDetails method");

		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.selectSinglesMatchType();

		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.selectMixedPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());

		logger.info("Ending of verifyStateOfAutoGenerateButtonAfterEnteringMandatoryDetails method");
	}

	@Test(priority = 47, description = "Verify Bracket Name AutoGenerated", groups = "sanity")
	@Description("Test case #47, Verify Bracket Name AutoGenerated")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #47, Verify Bracket Name AutoGenerated")
	public void verifyBracketNameAutoGenerated() {
		logger.info("Starting of verifyBracketNameAutoGenerated method");

		addBracketPage.clickOnAutoGenerateButton();
		Assert.assertFalse(addBracketPage.isBracketNameAutoGenerated());

		logger.info("Ending of verifyBracketNameAutoGenerated method");
	}

	@Test(priority = 48, description = "Verify State Of AutoGenerate Functionality After AutoGenerating BracketName", groups = "sanity")
	@Description("Test case #48, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #48, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	public void verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName() {
		logger.info("Starting of verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonDisabled());

		logger.info("Ending of verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");
	}

	@Test(priority = 49, description = "Verify Number Of Courts With Invalid Details", groups = "sanity")
	@Description("Test case #49, Verify Number Of Courts With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #49, Verify Number Of Courts With Invalid Details")
	public void verifyNumberOfCourtsWithInvalidDetails() {
		logger.info("Starting of verifyNumberOfCourtsWithInvalidDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectWaterfallEventType();

		addBracketPage.setNumberOfCourts(testDataProp.getProperty("zero.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isNumberOfCourtsValidationDisplayed());

		logger.info("Ending of verifyNumberOfCourtsWithInvalidDetails method");
	}

	@Test(priority = 50, description = "Verify Registration Dates Required Validation", groups = "sanity")
	@Description("Test case #50, Verify Registration Dates Required Validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #50, Verify Registration Dates Required Validation")
	public void verifyRegistrationDatesRequiredValidation() {
		logger.info("Starting of verifyRegistrationDatesRequiredValidation method");

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isRegistrationDetailsReqValidationDisplayed());

		logger.info("Ending of verifyRegistrationDatesRequiredValidation method");
	}

	@Test(priority = 51, description = "Verify Registration EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #51, Verify Registration EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #51, Verify Registration EndDate with Previous Date Of StartDate Details")
	public void verifyRegistrationEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of verifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setInvalidRegistrationStartDate();
		addEventPage.hardWait(3);

		addBracketPage.setInvalidRegistrationEndDate();

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isRegistrationEndDateValidationDisplayed());

		logger.info("Ending of verifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 52, description = "Verify Competition Dates with Invalid Details", groups = "sanity")
	@Description("Test case #52, Verify Competition Dates with Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #52, Verify Competition Dates with Invalid Details")
	public void verifyCompetitionDateswithInvalidDetails() {
		logger.info("Starting of verifyCompetitionDateswithInvalidDetails method");

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isCompetitionDatesRequiredValidationsDisplayed());

		logger.info("Ending of verifyCompetitionDateswithInvalidDetails method");
	}

	@Test(priority = 53, description = "Verify Competition EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #53, Verify Competition EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #53, Verify Competition EndDate with Previous Date Of StartDate Details")
	public void verifyCompetitionEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of verifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setInvalidCompetitionStartDate();
		addEventPage.hardWait(3);

		addBracketPage.setInvalidCompetitionEndDate();

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed());

		logger.info("Ending of verifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 54, description = "Verify Competition Start Date High Regestration End Date Details", groups = "sanity")
	@Description("Test case #54, Verify Competition Start Date High Regestration End Date Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #54, Verify Competition Start Date High Regestration End Date Details")
	public void verifyCompetitionStartDateHighRegestrationEndDateDetails() {
		logger.info("Starting of verifyCompetitionStartDateHighRegestrationEndDateDetails method");

		addBracketPage.setRegistrationEndDate();
		addEventPage.hardWait(3);

		addBracketPage.setIncorrectCompetitionStartDate();
		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isComStartDateHighRegEndDateDisplayed());

		logger.info("Ending of verifyCompetitionStartDateHighRegestrationEndDateDetails method");
	}

	@Test(priority = 55, description = "Verify Bracket Club Member NonMember Price Validation Details", groups = "sanity")
	@Description("Test case #55, Verify Bracket Club Member NonMember Price Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #55, Verify Bracket Club Member NonMember Price Validation Details")
	public void verifyBracketClubMemberNonMemberPriceValidationDetails() {
		logger.info("Starting of verifyBracketClubMemberNonMemberPriceValidationDetails method");

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("negative.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("negative.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketClubMemNonMemValidationMsgDisplayed());

		logger.info("Ending of verifyBracketClubMemberNonMemberPriceValidationDetails method");
	}

	@Test(priority = 56, description = "Verify Bracket NumberOfTeams Validation Details", groups = "sanity")
	@Description("Test case #56, Verifys Brackets NumberOfTeams Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #56, Verifys Brackets NumberOfTeams Validation Details")
	public void verifyBracketNumberOfTeamValidationDetails() {
		logger.info("Starting of verifyBracketNumberOfTeamValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectRoundRobinEvent();
		addBracketPage.hardWait(2);

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("zero.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketNumberOfTeamsValidationMsgDisplayed());

		logger.info("Ending of verifyBracketNumberOfTeamValidationDetails method");
	}

	@Test(priority = 57, description = "Verify Bracket NumberOfTeams Max Validation Details", groups = "sanity")
	@Description("Test case #57, Verifys Brackets NumberOfTeams Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #57, Verifys Brackets NumberOfTeams Max Validation Details")
	public void verifyBracketNumberOfTeamsMaxValidationDetails() {
		logger.info("Starting of verifyBracketNumberOfTeamsMaxValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectRoundRobinEvent();
		addBracketPage.hardWait(3);

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("invalid.max.age.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketNumberOfTeamsMaxValidationMsgDisplayed());

		logger.info("Ending of verifyBracketNumberOfTeamsMaxValidationDetails method");
	}

	@Test(priority = 58, description = "Verify Bracket Waitlist Negative Validation Details", groups = "sanity")
	@Description("Test case #58, Verify Bracket Waitlist Negative Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #58, Verify Bracket Waitlist Negative Validation Details")
	public void verifyBracketWaitlistNegativeValidationDetails() {
		logger.info("Starting of verifyBracketWaitlistNegativeValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("negative.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketWaitlistNegativeValidationMsgDisplayed());

		logger.info("Ending of verifyBracketWaitlistNegativeValidationDetails method");
	}

	@Test(priority = 59, description = "Verify Bracket Waitlist Max Validation Details", groups = "sanity")
	@Description("Test case #59, Verify Bracket Waitlist Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #59, Verify Bracket Waitlist Max Validation Details")
	public void verifyBracketWaitlistMaxValidationDetails() {
		logger.info("Starting of verifyBracketWaitlistMaxValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("max.age.range"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketWaitListMaxValidationMsgDisplayed());

		logger.info("Ending of verifyBracketWaitlistMaxValidationDetails method");
	}

	@Test(priority = 60, description = "Verify Bracket Combination Of MixedPlayer Group And Single Type", groups = "sanity")
	@Description("Test case #60, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #60, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	public void verifyBracketCombinationOfMixedPlayerGroupAndSingleType() {
		logger.info("Starting of verifyBracketCombinationOfMixedPlayerGroupAndSingleType method");

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(2);

		addBracketPage.clickOnMatchTypeDropdown();
		addEventPage.hardWait(2);
		addBracketPage.selectSinglesMatchType();

		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(2);
		addBracketPage.selectMixedPlayerGroup();

		addEventPage.clickOnNextStepButton();
		Assert.assertTrue(addBracketPage.isMixedGroupSinglesValidationDisplayed());

		logger.info("Ending of verifyBracketCombinationOfMixedPlayerGroupAndSingleType method");
	}

	@Test(priority = 61, description = "Verify Bracket RoundRobin Event Type", groups = "sanity")
	@Description("Test case #61, Verify Bracket RoundRobin Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #61, Verify Bracket RoundRobin Event Type")
	public void verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsRoundRobin() {
		logger.info("Starting of verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsRoundRobin method");

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectRoundRobinEvent();

		Assert.assertTrue(addBracketPage.isNumberOfCourtsFieldDisabled());
		Assert.assertTrue(addBracketPage.isNumberOfTeamsDisplayed());

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsRoundRobin method");
	}

	@Test(priority = 62, description = "Verify Bracket Waterfall Event Type", groups = "sanity")
	@Description("Test case #62, Verify Bracket Waterfall Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #62, Verify Bracket Waterfall Event Type")
	public void verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsWaterfall() {
		logger.info("Starting of verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsWaterfall method");

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectWaterfallEventType();

		Assert.assertTrue(addBracketPage.isNumberOfCourtsFieldEnabled());
		Assert.assertTrue(addBracketPage.isNumberOfTeamsFieldDisabled());

		addEventPage.clickOnNextStepButton();

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyStatesOfNumberOfCourtsAndTeamFieldsIfBracketTypeIsWaterfall method");
	}

	@Test(priority = 63, description = "Verify AddBrackets Page With Valid Details", groups = "sanity")
	@Description("Test case #63, Verify AddBrackets Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #63, Verify AddBrackets Page With Valid Details")
	public void verifyAddBracketsPageWithValidDetails() {
		logger.info("Starting of verifyAddBracketsPageWithValidDetails method");

		addBracketPage.hardWait(3);
		addBracketPage.clickOnBracketCaretIcon();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());

		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());

		addBracketPage.hardWait(2);
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

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonDisabled());

		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredClubMemberPriceDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredClubNonMemberPriceDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.age.range"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddAnotherBracketPopUpContains());

		logger.info("Ending of verifyAddBracketsPageWithValidDetails method");
	}

	@Test(priority = 64, description = "Verify AddAnotherBracket button In AddAnotherBracketPopup", groups = "sanity")
	@Description("Test case #64, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #64, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	public void VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup() {
		logger.info("Starting of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");

		addBracketPage.clickOnAddAnotherBracketButton();
		addBracketPage.clickonBracket1Button();

		Assert.assertTrue(addBracketPage.isAddNewBracketPageContainsDisplayed());

		logger.info("Ending of VerifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");
	}

	@Test(priority = 65, description = "Verify  Delete Bracket button fuctionality", groups = "sanity")
	@Description("Test case #65, Verify  Delete Bracket button fuctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #65, Verify  Delete Bracket button fuctionality")
	public void VerifyDeleteBracketFuctionality() {
		logger.info("Starting of VerifyDeleteBracketFuctionality method");

		addBracketPage.clickOnDeleteBracketButton();

		Assert.assertFalse(addBracketPage.isDeleteBracketDisplayed());

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of VerifyDeleteBracketFuctionality method");
	}

	@Test(priority = 66, description = "Verify Results On Click Of Close Icon In Add Another Bracket? popup", groups = "sanity")
	@Description("Test case #66, Verify Results On Click Of Close Icon In Add Another Bracket? popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #66,Verify Results On Click Of Close Icon In Add Another Bracket? popup")
	public void VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup method");

		addBracketPage.clickOnCloseIconButton();

		addBracketPage.clickonBracket1Button();

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of VerifyResultsOnClickOfCloseIconInAddAnotherBracketpopup method");
	}

	@Test(priority = 67, description = "Verify NoContinueToSummary Button In AddAnotherBracket popup", groups = "sanity")
	@Description("Test case #67, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #67, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	public void VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup() {
		logger.info("Starting of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");

		addBracketPage.clickOnNoContinueToSummary();

		Assert.assertTrue(addBracketPage.isEventDetailsSectionDisplayed());
		Assert.assertTrue(addBracketPage.isEventPoliciesSectionDisplayed());
		Assert.assertTrue(addBracketPage.isBracketsSectionDisplayed());

		logger.info("Ending of VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");
	}

	@Test(priority = 68, description = "Verify delete Bracket In Summary Page", groups = "sanity")
	@Description("Test case #68, Verify delete Bracket In Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #68, Verify delete Bracket In Summary Page")
	public void VerifyDeleteBracketDetailsInSummaryPage() {
		logger.info("Starting of VerifyDeleteBracketDetailsInSummaryPage method");

		addBracketPage.clickOnEditBracketsButton();

		addBracketPage.hardWait(3);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddAnotherBracketPopUpContains());

		addBracketPage.clickOnAddAnotherBracketButton();
		addBracketPage.clickOnDeleteBracketButton();

		Assert.assertFalse(addBracketPage.isDeleteBracketDisplayed());

		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyDeleteBracketDetailsInSummaryPage");
	}

	@Test(priority = 69, description = "Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #69, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #69, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	public void VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		Assert.assertTrue(addBracketPage.isEditEventDetailsButtonDisplayed());
		addBracketPage.clickOnEditEventDetailsButton();

		this.verifyExitEventCreationPopupAfterFillingEventInformationDetails();
		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(2);
		addEventPage.clickOnNextStepButton();
		addBracketPage.clickonBracket1Button();

		addEventPage.hardWait(2);
		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");
	}

	@Test(priority = 70, description = "Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #70, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #70, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	public void VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		addBracketPage.clickOnEditBracketsButton();
		addBracketPage.hardWait(2);

		addBracketPage.setRegistrationStartDate();
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnNoContinueToSummary();

		Assert.assertTrue(addBracketPage.isPublishEventButtonDisplayed());

		logger.info("Ending of VerifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage");
	}

	@Test(priority = 71, description = "Verify Results On Click Of Go Back Button In Summary Page", groups = "sanity")
	@Description("Test case #71, Verify Results On Click Of Go Back Button In Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #71, Verify Results On Click Of Go Back Button In Summary Page")
	public void VerifyResultsOnClickOfGoBackButtonInSummaryPage() {
		logger.info("Starting of VerifyResultsOnClickOfGoBackButtonInSummaryPage method");

		addEventPage.clickonGoBackButton();

		Assert.assertTrue(addBracketPage.isAddBracketsPageDisplayed());

		addEventPage.clickOnNextStepButton();
		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of VerifyResultsOnClickOfGoBackButtonInSummaryPage method");
	}

	// @Test(priority = 72, description = "Verify Draft Event in Clubs page-Events
	// Tab Functionality", groups = "sanity")
	@Description("Test case #72, Verify Draft Event in Clubs page-Events Tab Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #72, Verify Draft Event in Clubs page-Events Tab Functionality")
	public void VerifyDeleteEventInClubsPageEventsTabFunctionality1() {
		logger.info("Starting of VerifyDraftEventInClubsPageEventsTabFunctionality method");

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnDeleteEventFromList(testDataProp.getProperty("event.name"));

		logger.info("Ending of VerifyDraftEventInClubsPageEventsTabFunctionality method");
	}

	@Test(priority = 73, description = "Verify Publish Event Button", groups = "sanity")
	@Description("Test case #73, Verify Publish Event Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #73, Verify Publish Event Button")
	public void VerifyPublishEventButton() {
		logger.info("Starting of VerifyPublishEventButton method");

		addBracketPage.hardWait(2);
		addBracketPage.clickOnPublishEventButton();

		Assert.assertTrue(addBracketPage.isPublishSuccessPopUpContains());

		logger.info("Ending of VerifyPublishEventButton method");
	}

	@Test(priority = 74, description = "Verify Close Icon In YourEventIsNowPublished Success Popup", groups = "sanity")
	@Description("Test case #74, Verify Close Icon In YourEventIsNowPublished Success Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #74, Verify Close Icon In YourEventIsNowPublished Success Popup")
	public void VerifyCloseIconInYourEventIsNowPublishedSuccessPopup() {
		logger.info("Starting of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");

		addBracketPage.clickOnEventSuccessClosePopupButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of VerifyCloseIconInYourEventIsNowPublishedSuccessPopup method");
	}

	@Test(priority = 75, description = "Verify Recently Added Event Under Events Tab", groups = "sanity")
	@Description("Test case #75, Verify Recently Added Event Under Events Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #75, Verify Recently Added Event Under Events Tab")
	public void VerifyRecentlyAddedEventUnderEventsTab() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addEventPage.clickOnEventsTab();
		Assert.assertTrue(addEventPage.isRecentlyAddedEventDisplayed(eventName));

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 76, description = "Verify Delete Bracket Functionality After Publishing Event", groups = "sanity")
	@Description("Test case #76, Verify Delete Bracket Functionality After Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #76, Verify Delete Bracket Functionality After Publishing Event")
	public void verifyDeleteBracketFunctionalityAfterPublishingEvent() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		/*
		 * clubLogoPage.clickOnMyClubsTab();
		 * editClubInfoPage.clickOnSimbaOrganizerButton();
		 */
		addEventPage.clickOnAddEventButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		this.verifyExitEventCreationPopupAfterFillingEventInformationDetails();
		addEventPage.clickOnNextStepButton();

		addEventPage.setRefundPolicy(testDataProp.getProperty("refund.policy"));
		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(2);

		this.addBracketPage.addBrackets(testDataProp.getProperty("min.age.range"),
				testDataProp.getProperty("max.age.range"), testDataProp.getProperty("min.rating.range"),
				testDataProp.getProperty("max.rating.range"));

		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(2);
		addBracketPage.clickOnNoContinueToSummary();

		addEventPage.hardWait(3);
		addBracketPage.clickOnPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		addEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();

		addEventPage.hardWait(2);
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		addBracketPage.clickonDeleteBracket();

		Assert.assertTrue(addBracketPage.isDeleteBracketPopUpDisplayed());

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 77, description = "Verify Cancel Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #77, Verify Cancel Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #77, Verify Cancel Button Functionality In DeleteBracket")
	public void verifyCancelButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		addBracketPage.clickOnCancelButton();
		Assert.assertTrue(addEventPage.isRecentlyCreatedEventDisplayed(eventName));

		logger.info("Ending of VerifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 78, description = "Verify Close Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #78, Verify Close Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #78, Verify Close  Button Functionality In DeleteBracket")
	public void verifyCloseButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of verifyCloseButtonFunctionalityInDeleteBracket method");

		addBracketPage.clickonDeleteBracket();
		addBracketPage.clickOnCloseButton();

		Assert.assertTrue(addEventPage.isRecentlyCreatedEventDisplayed(eventName));

		logger.info("Ending of verifyCloseButtonFunctionalityInDeleteBracket method");
	}

	@Test(priority = 79, description = "Verify Confirm Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #79, Verify Confirm Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #79, Verify Confirm  Button Functionality In DeleteBracket")
	public void verifyConfirmButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of verifyConfirmButtonFunctionalityInDeleteBracket method");

		addBracketPage.clickonDeleteBracket();
		addBracketPage.clickOnConfirmButton();

		addBracketPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isDeleteBracketSuccessPopUpDisplayed());

		logger.info("Ending of verifyConfirmButtonFunctionalityInDeleteBracket method");
	}

	@Test(priority = 80, description = "Verify Ok Button Functionality In DeleteBracket SuccessPopUP", groups = "sanity")
	@Description("Test case #80, Verify Ok Button Functionality In DeleteBracket SuccessPopUP")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #80, Verify Ok  Button Functionality In DeleteBracket SuccessPopUP")
	public void verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP() {
		logger.info("Starting of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");

		addBracketPage.clickOnOkButton();
		addBracketPage.hardWait(3);
		Assert.assertFalse(addBracketPage.isDeleteBracketSuccessPopUpDisplayed());

		driver.navigate().back();

		logger.info("Ending of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");
	}

	@Test(priority = 81, description = "Verify Free Event Functionality", groups = "sanity")
	@Description("Test case #81, Verify Free Event Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #81, Verify Free Event Functionality")
	public void VerifyFreeEventFunctionality() {
		logger.info("Starting of VerifyFreeEventFunctionality method");

		addEventPage.hardWait(3);
		addEventPage.clickOnAddEventButton();

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
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
		this.verifyAddBracketsPageWithValidDetails();

		addBracketPage.hardWait(3);
		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.VerifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of VerifyFreeEventFunctionality method");
	}

	@Test(priority = 82, description = "Verify Free Bracket With Event Type As Round Robin", groups = "sanity")
	@Description("Test case #82, Verify Free Bracket With Event Type As Round Robin")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #82,Verify Free Bracket With Event Type As Round Robin")
	public void verifyFreeBracketWithEventTypeAsRoundRobin() {
		logger.info("Starting of verifyFreeBracketWithEventTypeAsRoundRobin method");

		addEventPage.clickOnAddEventButton();

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectMixedPlayerGroup();

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
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addEventPage.clickOnNextStepButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.VerifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketWithEventTypeAsRoundRobin method");
	}

	@Test(priority = 83, description = "Verify Free Bracket With Event Type As Water Fall", groups = "sanity")
	@Description("Test case #83, Verify Free Bracket With Event Type As Water Fall")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #83,Verify Free Bracket With Event Type As Water Fall")
	public void verifyFreeBracketWithEventTypeAsWateFall() {
		logger.info("Starting of verifyFreeBracketWithEventTypeAsWateFall method");

		addEventPage.clickOnAddEventButton();

		freeEventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());
		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();

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
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();

		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.hardWait(2);
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed(testDataProp.getProperty("min.rating.range")));

		addEventPage.clickOnNextStepButton();

		addBracketPage.hardWait(3);
		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.VerifyPublishEventButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketWithEventTypeAsWateFall method");
	}

	@Test(priority = 84, description = "Verify Delete Event Functionality after publishing the event", groups = "sanity")
	@Description("Test case #84, Verify Delete Event Functionality after publishing the event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #84, Verify Delete Event Functionality after publishing the event")
	public void verifyDeleteEventFunctionalityAfterPublishingEvent() {
		logger.info("Starting of verifyDeleteEventFunctionalityAfterPublishingEvent method");

		addEventPage.clickOnEventsTab();
		Assert.assertTrue(addEventPage.isRecentlyAddedEventDisplayed(freeEventName));
		addEventPage.clickOnDeleteEventFromList(freeEventName);

		Assert.assertTrue(addEventPage.isDeleteEventPopUpContains());

		addEventPage.clickOnDeleteEventConfirmButton();

		Assert.assertTrue(addEventPage.isEventDeletedSuccessPopUpContains());

		addEventPage.clickOnDeleteEventOKButton();
		Assert.assertFalse(addEventPage.isRecentlyAddedEventDisplayed(freeEventName));

		logger.info("Ending of verifyDeleteEventFunctionalityAfterPublishingEvent method");
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
