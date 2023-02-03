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
	private EditClubInfoPage editClubInfoPage = null;

	private AddEventPage addEventPage = null;
	private AddBracketPage addBracketPage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

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
		
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
	public void VerifyAddEventFunctionality() {
		logger.info("Starting of VerifyAddEventFunctionality method");

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

		addEventPage.clickonAddEventButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
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

		addEventPage.clickonAddEventButton();
		addEventPage.clickOnNextStepButton();
		
		addEventPage.hardWait(3);

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

		addEventPage.setMemberPrice(addEventPage.randomNumber(8));
		addEventPage.setNonMemberPrice(addEventPage.randomNumber(8));

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

		addEventPage.setMemberPrice(testDataProp.getProperty("invalid.minimum.rating.range"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("invalid.minimum.rating.range"));

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
	public void VerifyExitEventCreationPopupAfterFillingEventInformationDetails() {
		logger.info("Starting of VerifyExitEventCreationPopupAfterFillingEventInformationDetails method");

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));
		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickonExitButton();

		Assert.assertTrue(addEventPage.isExitEventCreationPopupContains());

		addEventPage.clickOnExitEventCreationCloseIcon();

		logger.info("Ending of VerifyExitEventCreationPopupAfterFillingEventInformationDetails method");
	}

	@Test(priority = 17, description = "Verify Event Information Page With Valid Details", groups = "sanity")
	@Description("Test case #17, Verify Event Information Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify Event Information Page With Valid Details")
	public void verifyEventInformationPageWithValidDetails() {
		logger.info("Starting of verifyEventInformationPageWithValidDetails method");

		addEventPage.clickOnNextStepButton();

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

		addEventPage.clickonAddEventButton();

		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();
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

		Assert.assertTrue(addEventPage.isEventDeletedSuccessPopUpContains());

		logger.info("Ending of verifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");
	}

	@Test(priority = 27, description = "Verify Close Icon In Exit Event Creation popup in Event Policies", groups = "sanity")
	@Description("Test case #27, Verify Close Icon In Exit Event Creation popup in Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #27, Verify Close Icon In Exit Event Creation popupp in Event Policies")
	public void verifyCloseIconInExitEventCreationInEventPoliciespopup() {
		logger.info("Starting of VerifyCloseIconInExitEventCreationpopup method");

		addEventPage.clickonAddEventButton();

		this.VerifyExitEventCreationPopupAfterFillingEventInformationDetails();
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
		addEventPage.clickOnLiabilityWaiverButton();

		Assert.assertTrue(this.addEventPage.isFileExplorerContains());
		addEventPage.pressEscapeKey();

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

		addEventPage.clickOnReplaceButton();

		Assert.assertTrue(this.addEventPage.isFileExplorerContains());
		addEventPage.pressEscapeKey();

		logger.info("Ending of verifyReplaceLiabilityFileFunctionality method");
	}

	@Test(priority = 35, description = "Verify Refund Policy Minimum Chars Validation in Event Policies Page", groups = "sanity")
	@Description("Test case #35, Verify Refund Policy Minimum Chars Validation in Event Policies Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #35, Verify Refund Policy Minimum Chars Validation in Event Policies Page")
	public void verifyRefundPolicyMinimumCharsValidation() {
		logger.info("Starting of verifyRefundPolicyMinimumCharsValidation method");

		addEventPage.setRefundPolicyEdit(addEventPage.randomAlphabet(4));

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
		addEventPage.setRefundPolicyEdit(RefundMaximumChars);

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
		addEventPage.setRefundPolicyEdit(healthyAndSafetyMaximumChars);

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

		addEventPage.replaceLiabilityWaiver(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("replace.image"));
		addEventPage.setRefundPolicyEdit(testDataProp.getProperty("about.the.event"));
		addEventPage.setHealthAndSafetyPolicyEdit(testDataProp.getProperty("about.the.event"));

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

		addBracketPage.setMinimumAgeRange(addEventPage.randomAlphabet(7));
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

		addBracketPage.setMinimumRatingRange(addEventPage.randomAlphabet(7));
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

		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
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

		addBracketPage.setRegistrationStartDate();
		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date.error"));
		
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isRegistrationDetailsReqValidationDisplayed());

		logger.info("Ending of verifyRegistrationDatesRequiredValidation method");
	}

	/*@Test(priority = 51, description = "Verify Registration EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #51, Verify Registration EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #51, Verify Registration EndDate with Previous Date Of StartDate Details")
	public void verifyRegistrationEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of VerifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setRegistrationStartDate(testDataProp.getProperty("registration.start.Date"));
		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isRegestrationEndDatewithPreviousDateOfStartDateMsgDisplayed());

		logger.info("Ending of VerifyRegistrationEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 52, description = "Verify Competition Dates with Invalid Details", groups = "sanity")
	@Description("Test case #52, Verify Competition Dates with Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #52, Verify Competition Dates with Invalid Details")
	public void VerifyCompetitionDateswithInvalidDetails() {
		logger.info("Starting of VerifyCompetitionDateswithInvalidDetails method");

		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date.error"));
		addBracketPage.setCompetitionEndDate(testDataProp.getProperty("competition.end.Date.error"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isCompetitionInvalidMsgDisplayed());

		logger.info("Ending of VerifyCompetitionDateswithInvalidDetails method");
	}

	@Test(priority = 53, description = "Verify Competition EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #53, Verify Competition EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #53, Verify Competition EndDate with Previous Date Of StartDate Details")
	public void VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails() {
		logger.info("Starting of VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");

		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date"));
		addBracketPage.setCompetitionEndDate(testDataProp.getProperty("competition.end.Date"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed());

		logger.info("Ending of VerifyCompetitionEndDatewithPreviousDateOfStartDateDetails method");
	}

	@Test(priority = 54, description = "Verify Competition Start Date High Regestration End Date Details", groups = "sanity")
	@Description("Test case #54, Verify Competition Start Date High Regestration End Date Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #54, Verify Competition Start Date High Regestration End Date Details")
	public void VerifyCompetitionStartDateHighRegestrationEndDateDetails() {
		logger.info("Starting of VerifyCompetitionStartDateHighRegestrationEndDateDetails method");

		addBracketPage.setRegistrationEndDate(testDataProp.getProperty("registration.end.Date.high"));
		addBracketPage.setCompetitionStartDate(testDataProp.getProperty("competition.start.Date.low"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isComStartDateHighRegEndDateDisplayed());

		logger.info("Ending of VerifyCompetitionStartDateHighRegestrationEndDateDetails method");
	}

	@Test(priority = 55, description = "Verify Bracket Club Member NonMember Price Validation Details", groups = "sanity")
	@Description("Test case #55, Verify Bracket Club Member NonMember Price Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #55, Verify Bracket Club Member NonMember Price Validation Details")
	public void VerifyBracketClubMemberNonMemberPriceValidationDetails() {
		logger.info("Starting of VerifyBracketClubMemberNonMemberPriceValidationDetails method");

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("memberPrice.value.error"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("nonMemberPrice.value.error"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isBracketClubMemNonMemValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketClubMemberNonMemberPriceValidationDetails method");
	}

	@Test(priority = 56, description = "Verify Bracket NumberOfTeams Validation Details", groups = "sanity")
	@Description("Test case #56, Verifys Brackets NumberOfTeams Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #56, Verifys Brackets NumberOfTeams Validation Details")
	public void VerifyBracketNumberOfTeamsValidationDetails() {
		logger.info("Starting of VerifyBracketNumberOfTeamValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("number.of.terms.error"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isBracketNumberOfTeamsValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketNumberOfTeamValidationDetails method");
	}

	@Test(priority = 57, description = "Verify Bracket NumberOfTeams Max Validation Details", groups = "sanity")
	@Description("Test case #57, Verifys Brackets NumberOfTeams Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #57, Verifys Brackets NumberOfTeams Max Validation Details")
	public void VerifyBracketNumberOfTeamsMaxValidationDetails() {
		logger.info("Starting of VerifyBracketNumberOfTeamsMaxValidationDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setNumberOfTeams(testDataProp.getProperty("number.of.terms.max.error"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isBracketNumberOfTeamsMaxValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketNumberOfTeamsMaxValidationDetails method");
	}

	@Test(priority = 58, description = "Verify Bracket Waitlist Negative Validation Details", groups = "sanity")
	@Description("Test case #58, Verify Bracket Waitlist Negative Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #58, Verify Bracket Waitlist Negative Validation Details")
	public void VerifyBracketWaitlistNegativeValidationDetails() {
		logger.info("Starting of VerifyBracketWaitlistNegativeValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list.negative.value"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isBracketWaitlistNegativeValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketWaitlistNegativeValidationDetails method");
	}

	@Test(priority = 59, description = "Verify Bracket Waitlist Max Validation Details", groups = "sanity")
	@Description("Test case #59, Verify Bracket Waitlist Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #59, Verify Bracket Waitlist Max Validation Details")
	public void VerifyBracketWaitlistMaxValidationDetails() {
		logger.info("Starting of VerifyBracketWaitlistMaxValidationDetails method");

		// addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list.max.value"));
		addEventPage.clickOnNextStepButton();
		
		Assert.assertTrue(addBracketPage.isBracketWaitListMaxValidationMsgDisplayed());

		logger.info("Ending of VerifyBracketWaitlistMaxValidationDetails method");
	}

	@Test(priority = 60, description = "Verify Bracket Combination Of MixedPlayer Group And Single Type", groups = "sanity")
	@Description("Test case #60, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #60, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	public void VerifyBracketCombinationOfMixedPlayerGroupAndSingleType() {
		logger.info("Starting of VerifyBracketCombinationOfMixedPlayerGroupAndSingleType method");

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

		logger.info("Ending of VerifyBracketCombinationOfMixedPlayerGroupAndSingleType method");
	}

	@Test(priority = 61, description = "Verify Bracket RoundRobin Event Type", groups = "sanity")
	@Description("Test case #61, Verify Bracket RoundRobin Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #61, Verify Bracket RoundRobin Event Type")
	public void VerifyBracketRoundRobinEventType() {
		logger.info("Starting of VerifyBracketRoundRobinEventType method");

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();
		
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isRounRobinNumberOfCourtsDisplayed());
		Assert.assertTrue(addBracketPage.isNumberOfTeamsDisplayed());
		
		addEventPage.clickOnNextStepButton();

		logger.info("Ending of VerifyBracketRoundRobinEventType method");
	}

	@Test(priority = 61, description = "Verify Bracket Waterfall Event Type", groups = "sanity")
	@Description("Test case #61, Verify Bracket Waterfall Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #61, Verify Bracket Waterfall Event Type")
	public void VerifyBracketWaterfallEventType() {
		logger.info("Starting of VerifyBracketWaterfallEventType method");

		addEventPage.clickonGoBackButton();
		addEventPage.clickOnNextStepButton();
		
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isNumberOfCourtsWaterFallValidationDisplayed());
		Assert.assertTrue(addBracketPage.isWaterFallNumberOfTeamsDisplayed());
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isAddBracketPageContains());

		logger.info("Ending of VerifyBracketWaterfallEventType method");
	}

	@Test(priority = 62, description = "Verify AddBrackets Page With Valid Details", groups = "sanity")
	@Description("Test case #62, Verify AddBrackets Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #62, Verify AddBrackets Page With Valid Details")
	public void VerifyAddBracketsPageWithValidDetails() {
		logger.info("Starting of VerifyAddBracketsPageWithValidDetails method");

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isBracketList());
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
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

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

		addBracketPage.clickOnTimeZoneDropdown(); //
		Assert.assertTrue(addBracketPage.isTimeZoneListDisplayed());
		addBracketPage.clickOnCentalAmericanTimeZoneButton();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("memberPrice.value")); //
		Assert.assertTrue(addBracketPage.isEnteredClubMemberPriceDisplayed());

		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("nonMemberPrice.value")); //
		Assert.assertTrue(addBracketPage.isEnteredClubNonMemberPriceDisplayed());

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

		Assert.assertTrue(addEventPage.isClubPageContains());

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

		// String eventName = addEventPage.getEventName(); //
		Assert.assertEquals(eventName, //
				expectedAssertionsProp.getProperty("event.name"));

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
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

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

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("free.event.bracket.value"));

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
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.minimum")));

		addBracketPage.setRatingRangeMaximum(testDataProp.getProperty("Rating.range.maximum"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("Rating.range.maximum")));

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

		//
		addBracketPage.setNumberOfTerms(testDataProp.getProperty("number.of.teams"));
		// Assert.assertTrue(addBracketPage.isNumberOfTeamsCountDisplayed());

		addBracketPage.setWaitlist(testDataProp.getProperty("wait.list"));
		Assert.assertTrue(addBracketPage.isWaitListCountDisplayed());

		addEventPage.clickonNextButton();

		this.VerifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.VerifyPublishEventButton();

		logger.info("Ending of VerifyFreeBracketWithEventTypeAsWateFall method");
	}

	@Test(priority = 82, description =
	  "Verify Delete Event Functionality after publishing the event", groups =
	  "sanity")
	  
	  @Description("Test case #82, Verify Delete Event Functionality after publishing the event"
	  )
	  
	  @Severity(SeverityLevel.NORMAL)
	  
	  @Story("Test case #82, Verify Delete Event Functionality after publishing the event"
	  ) public void VerifyDeleteEventFunctionalityAfterPublishingEvent() { logger.
	  info("Starting of VerifyDeleteBracketFunctionalityAfterPublishingEvent method"
	  );
	  
	  addEventPage.clickonEventButton();
	  addEventPage.selectRecentlyAddedEvent(testDataProp.getProperty("event.name"))
	  ;
	  addEventPage.selectDeleteEventFromList(testDataProp.getProperty("event.name")
	  );
	  
	  addEventPage.clickOnDeleteEventFromList(testDataProp.getProperty("event.name"
	  )); Assert.assertTrue(addEventPage.isDeleteEventPopUpContains()); // String
	  eventName = addEventPage.getEventName(); // Assert.assertEquals(eventName, //
	  expectedAssertionsProp.getProperty("event.name"));
	  
	  addEventPage.clickOnDeleteEventConfirmButton();
	  
	  Assert.assertTrue(addEventPage.isEventDeletedSuccessPopUpContains());
	  
	  addEventPage.clickOnDeleteEventOKButton();
	  Assert.assertFalse(addEventPage.selectRecentlyAddedEvent(testDataProp.
	  getProperty("event.name")));
	  
	  logger.
	  info("Ending of VerifyDeleteBracketFunctionalityAfterPublishingEvent method"
	  ); }*/

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
