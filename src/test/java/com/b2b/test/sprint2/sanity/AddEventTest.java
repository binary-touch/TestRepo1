package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Add Event Sanity")
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

	@Test(priority = 2, description = "Verify Add Event Information Details Functionality With Valid Details", groups = "sanity")
	@Description("Test case #2, Verify Add Event Information Details Functionality With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Add Event Information Details Functionality With Valid Details")
	public void verifyAddEventInformationDetailsFunctionalityWithValidDetails() {
		logger.info("Starting of verifyAddEventInformationDetailsFunctionalityWithValidDetails method");

		eventName = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.setMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("min.age.range"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();

		logger.info("Ending of verifyAddEventInformationDetailsFunctionalityWithValidDetails method");
	}

	/*@Test(priority = 3, description = "Verify Event Policies Page Details", groups = "sanity")
	@Description("Test case #3, Verify Event Policies Page Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Event Policies Page Details")
	public void verifyEventPoliciesPageDetails() {
		logger.info("Starting of verifyEventPoliciesPageDetails method");

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(2);
		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of verifyEventPoliciesPageDetails method");
	}

	@Test(priority = 4, description = "Verify Exit Event Creation Popup Details In Event Policies", groups = "sanity")
	@Description("Test case #4, Verify Exit Event Creation Popup Details In Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Exit Event Creation Popup Details In Event Policies")
	public void verifyExitEventCreationPopupDetailsInEventPolicies() {
		logger.info("Starting of verifyExitEventCreationPopupDetailsInEventPolicies method");

		addEventPage.clickonExitButton();

		Assert.assertTrue(addEventPage.isExitEventCreationPopupContains());

		logger.info("Ending of verifyExitEventCreationPopupDetailsInEventPolicies method");
	}

	@Test(priority = 5, description = "Verify Event Policies Discard Functionality", groups = "sanity")
	@Description("Test case #5, Verify Event Policies Discard Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Event Policies Discard Functionality")
	public void verifyEventPoliciesDiscardFunctionality() {
		logger.info("Starting of verifyEventPoliciesDiscardFunctionality method");

		addEventPage.clickOnEventPoliciesDiscardButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of verifyEventPoliciesDiscardFunctionality method");
	}

	@Test(priority = 6, description = "Verify Event Policies Save As Draft Functionality", groups = "sanity")
	@Description("Test case #6, Verify Event Policies Save As Draft Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Event Policies Save As Draft Functionality")
	public void verifyEventPoliciesSaveAsDraftFunctionality() {
		logger.info("Starting of verifyEventPoliciesSaveAsDraftFunctionality method");

		addEventPage.clickOnAddEventButton();

		this.verifyAddEventInformationDetailsFunctionalityWithValidDetails();
		this.verifyEventPoliciesPageDetails();

		addEventPage.clickonExitButton();
		addEventPage.clickOnSaveAsDraftButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of verifyEventPoliciesSaveAsDraftFunctionality method");
	}

	@Test(priority = 7, description = "Verify Recently Drafted Event In Events Tab", groups = "sanity")
	@Description("Test case #7, Verify Recently Drafted Event In Events Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Recently Drafted Event In Events Tab")
	public void verifyRecentlyDraftedEventInEventsTab() {
		logger.info("Starting of verifyRecentlyDraftedEventInEventsTab method");

		addEventPage.clickOnEventsTab();
		Assert.assertTrue(addEventPage.isDraftEventDisplayed(eventName));
		Assert.assertTrue(addEventPage.isDeleteEventButtonDisplayedForDraftEvent(eventName));

		logger.info("Ending of verifyRecentlyDraftedEventInEventsTab method");
	}

	@Test(priority = 8, description = "Verify Delete Draft Event Functionality Before Publishing Event", groups = "sanity")
	@Description("Test case #8, Verify Delete Draft Event Functionality Before Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Delete Draft Event Functionality Before Publishing Event")
	public void verifyDeleteDraftEventFunctionalityBeforePublishingEvent() {
		logger.info("Starting of verifyDeleteDraftEventFunctionalityBeforePublishingEvent method");

		addEventPage.clickOnDeleteEventFromList(eventName);
		Assert.assertTrue(addEventPage.isDeleteEventPopUpContains());

		logger.info("Ending of verifyDeleteDraftEventFunctionalityBeforePublishingEvent method");
	}

	@Test(priority = 9, description = "Verify Confirm Button Functionality In Delete Event PopUp", groups = "sanity")
	@Description("Test case #9, Verify Confirm Button Functionality In Delete Event PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Confirm Button Functionality In Delete Event PopUp")
	public void verifyConfirmButtonFunctionalityInDeleteEventPopUp() {
		logger.info("Starting of verifyConfirmButtonFunctionalityInDeleteEventPopUp method");

		addEventPage.clickOnDeleteEventConfirmButton();

		Assert.assertTrue(addEventPage.isEventDeletedSuccessPopUpContains());

		logger.info("Ending of verifyConfirmButtonFunctionalityInDeleteEventPopUp method");
	}

	@Test(priority = 10, description = "Verify OK Button Functionality In Delete Event Success PopUp", groups = "sanity")
	@Description("Test case #10, Verify OK Button Functionality In Delete Event Success PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify OK Button Functionality In Delete Event Success PopUp")
	public void verifyOKButtonFunctionalityInDeleteEventSuccessPopUp() {
		logger.info("Starting of verifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");

		addEventPage.clickOnDeleteEventOKButton();
		addEventPage.hardWait(3);

		Assert.assertFalse(addEventPage.isEventDeletedSuccessPopUpContains());

		logger.info("Ending of verifyOKButtonFunctionalityInDeleteEventSuccessPopUp method");
	}

	@Test(priority = 11, description = "Verify Close Icon In Exit Event Creation popup in Event Policies", groups = "sanity")
	@Description("Test case #11, Verify Close Icon In Exit Event Creation popup in Event Policies")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Close Icon In Exit Event Creation popupp in Event Policies")
	public void verifyCloseIconInExitEventCreationInEventPoliciespopup() {
		logger.info("Starting of VerifyCloseIconInExitEventCreationpopup method");

		addEventPage.clickOnAddEventButton();

		this.verifyAddEventInformationDetailsFunctionalityWithValidDetails();
		this.verifyEventPoliciesPageDetails();

		addEventPage.clickonExitButton();
		addEventPage.clickOnExitEventCreationCloseIcon();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		logger.info("Ending of VerifyCloseIconInExitEventCreationInEventPoliciespopup method");
	}*/

	@Test(priority = 12, description = "Verify Event Policies Page By Entering Valid Details", groups = "sanity")
	@Description("Test case #12, Verify Event Policies Page By Entering Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Event Policies Page By Entering Valid Details")
	public void verifyEventPoliciesPageByEnteringValidDetails() {
		logger.info("Starting of verifyEventPoliciesPageByEnteringValidDetails method");

		addEventPage.uploadLiabilityWaiverFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		Assert.assertTrue(addEventPage.isRemoveAndReplaceOptionsDisplayed());

		addEventPage.setRefundPolicy(testDataProp.getProperty("refund.policy"));
		addEventPage.setHealthAndSafetyPolicy(testDataProp.getProperty("health.policy"));

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyEventPoliciesPageByEnteringValidDetails method");
	}

	/*@Test(priority = 13, description = "Verify Minimum Age Range Validation in Add Brackets page", groups = "sanity")
	@Description("Test case #13, Verify Minimum Age Range Validation in Add Brackets page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Minimum Age Range Validation in Add Brackets page")
	public void verifyMinimumAgeRangeValidation() {
		logger.info("Starting of verifyMinimumAgeRangeValidation method");

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("zero.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumAgeValidationDisplayed());

		logger.info("Ending of verifyMinimumAgeRangeValidation method");
	}

	@Test(priority = 14, description = "Verify Maximum Age Range Validation in Add Brackets page", groups = "sanity")
	@Description("Test case #14, Verify Maximum Age Range Validation in Add Brackets page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Maximum Age Range Validation in Add Brackets page")
	public void verifyMaximumAgeRangeValidation() {
		logger.info("Starting of verifyMaximumAgeRangeValidation method");

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("invalid.max.age.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMaximumAgeValidationDisplayed());

		logger.info("Ending of verifyMaximumAgeRangeValidation method");
	}

	@Test(priority = 15, description = "Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age", groups = "sanity")
	@Description("Test case #15, Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Minimum AgeRange field validation if MaxAge is Lesser than the min age")
	public void verifyAgeRangeValidationIfMaxAgeIsLesserThanMin() {
		logger.info("Starting of verifyAgeRangeValidationIfMaxAgeIsLesserThanMin method");

		addBracketPage.setMinimumAgeRange(addEventPage.randomNumber(10));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("invalid.max.age.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMaximumAgeValidationDisplayed());
		Assert.assertTrue(addBracketPage.isMaxAgeIsHigherThanMinValidationDisplayed());

		logger.info("Ending of verifyAgeRangeValidationIfMaxAgeIsLesserThanMin method");
	}

	@Test(priority = 16, description = "Verify Rating Range Field Validations With Invalid Details", groups = "sanity")
	@Description("Test case #16, Verify Rating Range Field Validations With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16,Verify Rating Range Field Validations With Invalid Details")
	public void verifyRatingRangeFieldValidationsWithInvalidDetails() {
		logger.info("Starting of verifyRatingRangeFieldValidationsWithInvalidDetails method");

		addBracketPage.setMinimumRatingRange(addEventPage.randomNumber(10));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.age.range.in.min"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumRatingRangeMessageDisplayed());
		Assert.assertTrue(addBracketPage.isMaxAgeIsHigherThanMinValidationDisplayed());

		logger.info("Ending of verifyRatingRangeFieldValidationsWithInvalidDetails method");
	}

	@Test(priority = 17, description = "Verify RatingRange Validations Less Than Minimum Chars", groups = "sanity")
	@Description("Test case #17, Verify RatingRange Validations Less Than Minimum Chars")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify RatingRange Validations Less Than Minimum Chars")
	public void verifyRatingRangeValidationsLessThanMinChars() {
		logger.info("Starting of verifyRatingRangeValidationsLessThanMinChars method");

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("invalid.minimum.rating.range"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinRatingRangeValidationMessageDisplayed());

		logger.info("Ending of verifyRatingRangeValidationsLessThanMinChars method");
	}

	@Test(priority = 18, description = "Verify RatingRange Validations More Than Minimum Chars", groups = "sanity")
	@Description("Test case #18, Verify RatingRange Validations More Than Minimum Chars")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify RatingRange Validations More Than Minimum Chars")
	public void verifyRatingRangeValidationsMoreThanMaxChars() {
		logger.info("Starting of verifyRatingRangeValidationsMoreThanMaxChars method");

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("invalid.max.rating.range"));

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isMinimumRatingRangeMessageDisplayed());

		logger.info("Ending of verifyRatingRangeValidationsMoreThanMaxChars method");
	}

	@Test(priority = 19, description = "Verify State Of AutoGenerate Functionality After Entering Mandatory Details", groups = "sanity")
	@Description("Test case #19, Verify State Of AutoGenerate Functionality After Entering Mandatory Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify State Of AutoGenerate Functionality After Entering Mandatory Details")
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

	@Test(priority = 20, description = "Verify Bracket Name AutoGenerated", groups = "sanity")
	@Description("Test case #20, Verify Bracket Name AutoGenerated")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify Bracket Name AutoGenerated")
	public void verifyBracketNameAutoGenerated() {
		logger.info("Starting of verifyBracketNameAutoGenerated method");

		addBracketPage.clickOnAutoGenerateButton();
		Assert.assertFalse(addBracketPage.isBracketNameAutoGenerated());

		logger.info("Ending of verifyBracketNameAutoGenerated method");
	}

	@Test(priority = 21, description = "Verify State Of AutoGenerate Functionality After AutoGenerating BracketName", groups = "sanity")
	@Description("Test case #21, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify State Of AutoGenerate Functionality After AutoGenerating BracketName")
	public void verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName() {
		logger.info("Starting of verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonDisabled());

		logger.info("Ending of verifyStateOfAutoGenerateFunctionalityAfterAutoGeneratingBracketName method");
	}

	@Test(priority = 22, description = "Verify Number Of Courts With Invalid Details", groups = "sanity")
	@Description("Test case #22, Verify Number Of Courts With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #22, Verify Number Of Courts With Invalid Details")
	public void verifyNumberOfCourtsWithInvalidDetails() {
		logger.info("Starting of verifyNumberOfCourtsWithInvalidDetails method");

		addBracketPage.clickOnEventTypeDropdown();
		addBracketPage.selectWaterfallEventType();

		addBracketPage.setNumberOfCourts(testDataProp.getProperty("zero.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isNumberOfCourtsValidationDisplayed());

		logger.info("Ending of verifyNumberOfCourtsWithInvalidDetails method");
	}

	@Test(priority = 23, description = "Verify Registration Dates Required Validation", groups = "sanity")
	@Description("Test case #23, Verify Registration Dates Required Validation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #23, Verify Registration Dates Required Validation")
	public void verifyRegistrationDatesRequiredValidation() {
		logger.info("Starting of verifyRegistrationDatesRequiredValidation method");

		addEventPage.clickOnNextStepButton();
		addEventPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isRegistrationDetailsReqValidationDisplayed());

		logger.info("Ending of verifyRegistrationDatesRequiredValidation method");
	}

	@Test(priority = 24, description = "Verify Registration EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #24, Verify Registration EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #24, Verify Registration EndDate with Previous Date Of StartDate Details")
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

	@Test(priority = 25, description = "Verify Competition Dates with Invalid Details", groups = "sanity")
	@Description("Test case #25, Verify Competition Dates with Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #25, Verify Competition Dates with Invalid Details")
	public void verifyCompetitionDateswithInvalidDetails() {
		logger.info("Starting of verifyCompetitionDateswithInvalidDetails method");

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isCompetitionDatesRequiredValidationsDisplayed());

		logger.info("Ending of verifyCompetitionDateswithInvalidDetails method");
	}

	@Test(priority = 26, description = "Verify Competition EndDate with Previous Date Of StartDate Details", groups = "sanity")
	@Description("Test case #26, Verify Competition EndDate with Previous Date Of StartDate Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #26, Verify Competition EndDate with Previous Date Of StartDate Details")
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

	@Test(priority = 27, description = "Verify Competition Start Date High Regestration End Date Details", groups = "sanity")
	@Description("Test case #27, Verify Competition Start Date High Regestration End Date Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #27, Verify Competition Start Date High Regestration End Date Details")
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

	@Test(priority = 28, description = "Verify Bracket Club Member NonMember Price Validation Details", groups = "sanity")
	@Description("Test case #28, Verify Bracket Club Member NonMember Price Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #28, Verify Bracket Club Member NonMember Price Validation Details")
	public void verifyBracketClubMemberNonMemberPriceValidationDetails() {
		logger.info("Starting of verifyBracketClubMemberNonMemberPriceValidationDetails method");

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("negative.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("negative.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketClubMemNonMemValidationMsgDisplayed());

		logger.info("Ending of verifyBracketClubMemberNonMemberPriceValidationDetails method");
	}

	@Test(priority = 29, description = "Verify Bracket NumberOfTeams Validation Details", groups = "sanity")
	@Description("Test case #29, Verifys Brackets NumberOfTeams Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #29, Verifys Brackets NumberOfTeams Validation Details")
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

	@Test(priority = 30, description = "Verify Bracket NumberOfTeams Max Validation Details", groups = "sanity")
	@Description("Test case #30, Verifys Brackets NumberOfTeams Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #30, Verifys Brackets NumberOfTeams Max Validation Details")
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

	@Test(priority = 31, description = "Verify Bracket Waitlist Negative Validation Details", groups = "sanity")
	@Description("Test case #31, Verify Bracket Waitlist Negative Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #31, Verify Bracket Waitlist Negative Validation Details")
	public void verifyBracketWaitlistNegativeValidationDetails() {
		logger.info("Starting of verifyBracketWaitlistNegativeValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("negative.value"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketWaitlistNegativeValidationMsgDisplayed());

		logger.info("Ending of verifyBracketWaitlistNegativeValidationDetails method");
	}

	@Test(priority = 32, description = "Verify Bracket Waitlist Max Validation Details", groups = "sanity")
	@Description("Test case #32, Verify Bracket Waitlist Max Validation Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #32, Verify Bracket Waitlist Max Validation Details")
	public void verifyBracketWaitlistMaxValidationDetails() {
		logger.info("Starting of verifyBracketWaitlistMaxValidationDetails method");

		addBracketPage.setWaitlist(testDataProp.getProperty("max.age.range"));
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addBracketPage.isBracketWaitListMaxValidationMsgDisplayed());

		logger.info("Ending of verifyBracketWaitlistMaxValidationDetails method");
	}

	@Test(priority = 33, description = "Verify Bracket Combination Of MixedPlayer Group And Single Type", groups = "sanity")
	@Description("Test case #33, Verify Bracket Combination Of MixedPlayer Group And Single Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #33, Verify Bracket Combination Of MixedPlayer Group And Single Type")
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

	@Test(priority = 34, description = "Verify Bracket RoundRobin Event Type", groups = "sanity")
	@Description("Test case #34, Verify Bracket RoundRobin Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #34, Verify Bracket RoundRobin Event Type")
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

	@Test(priority = 35, description = "Verify Bracket Waterfall Event Type", groups = "sanity")
	@Description("Test case #35, Verify Bracket Waterfall Event Type")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #35, Verify Bracket Waterfall Event Type")
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
	}*/

	@Test(priority = 36, description = "Verify AddBrackets Page With Valid Details", groups = "sanity")
	@Description("Test case #36, Verify AddBrackets Page With Valid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #36, Verify AddBrackets Page With Valid Details")
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

	/*@Test(priority = 37, description = "Verify AddAnotherBracket button In AddAnotherBracketPopup", groups = "sanity")
	@Description("Test case #37, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #37, Verify AddAnotherBracket button In AddAnotherBracketPopup")
	public void verifyAddAnotherBracketbuttonInAddAnotherBracketPopup() {
		logger.info("Starting of verifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");

		addBracketPage.clickOnAddAnotherBracketButton();
		addBracketPage.clickonBracket1Button();

		Assert.assertTrue(addBracketPage.isAddNewBracketPageContainsDisplayed());

		logger.info("Ending of verifyAddAnotherBracketbuttonInAddAnotherBracketPopup method");
	}

	@Test(priority = 38, description = "Verify  Delete Bracket button fuctionality", groups = "sanity")
	@Description("Test case #38, Verify  Delete Bracket button fuctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #38, Verify  Delete Bracket button fuctionality")
	public void verifyDeleteBracketFunctionality() {
		logger.info("Starting of verifyDeleteBracketFunctionality method");

		addBracketPage.clickOnDeleteBracketButton();

		Assert.assertFalse(addBracketPage.isDeleteBracketDisplayed());

		addEventPage.clickOnNextStepButton();

		logger.info("Ending of verifyDeleteBracketFunctionality method");
	}*/

	@Test(priority = 39, description = "Verify NoContinueToSummary Button In AddAnotherBracket popup", groups = "sanity")
	@Description("Test case #39, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #39, Verify NoContinueToSummary Button In AddAnotherBracket popup")
	public void verifyNoContinueToSummaryButtonInAddAnotherBracketpopup() {
		logger.info("Starting of verifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");

		addBracketPage.clickOnNoContinueToSummary();

		clubLogoPage.hardWait(3);
		Assert.assertTrue(addBracketPage.isEventDetailsSectionDisplayed());
		Assert.assertTrue(addBracketPage.isEventPoliciesSectionDisplayed());
		Assert.assertTrue(addBracketPage.isBracketsSectionDisplayed());

		logger.info("Ending of verifyNoContinueToSummaryButtonInAddAnotherBracketpopup method");
	}

	/*@Test(priority = 40, description = "Verify delete Bracket In Summary Page", groups = "sanity")
	@Description("Test case #40, Verify delete Bracket In Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #40, Verify delete Bracket In Summary Page")
	public void verifyDeleteBracketDetailsInSummaryPage() {
		logger.info("Starting of verifyDeleteBracketDetailsInSummaryPage method");

		clubLogoPage.hardWait(3);
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

		logger.info("Ending of verifyDeleteBracketDetailsInSummaryPage");
	}

	@Test(priority = 41, description = "Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #41, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #41, Verify Edit Event Details Section By Clicking On Edit Icon In Event Summary Page")
	public void verifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of verifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		clubLogoPage.hardWait(3);
		Assert.assertTrue(addBracketPage.isEditEventDetailsButtonDisplayed());
		addBracketPage.clickOnEditEventDetailsButton();

		this.verifyAddEventInformationDetailsFunctionalityWithValidDetails();
		addEventPage.clickOnNextStepButton();

		addEventPage.hardWait(2);
		addEventPage.clickOnNextStepButton();
		addBracketPage.clickonBracket1Button();

		addEventPage.hardWait(2);
		addEventPage.clickOnNextStepButton();

		addBracketPage.clickOnNoContinueToSummary();

		logger.info("Ending of verifyEditEventDetailsSectionByClickingOnEditIconInEventSummaryPage method");
	}

	@Test(priority = 42, description = "Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page", groups = "sanity")
	@Description("Test case #42, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #42, Verify Edit Bracket  Details Section By Clicking On Edit Icon In Event Summary Page")
	public void verifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage() {
		logger.info("Starting of verifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage method");

		clubLogoPage.hardWait(3);
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

		logger.info("Ending of verifyEditBracketDetailsSectionByClickingOnEditIconInEventSummaryPage");
	}*/

	@Test(priority = 43, description = "Verify Publish Event Button", groups = "sanity")
	@Description("Test case #43, Verify Publish Event Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #43, Verify Publish Event Button")
	public void verifyPublishEventButton() {
		logger.info("Starting of verifyPublishEventButton method");

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPublishEventButton();

		Assert.assertTrue(addBracketPage.isPublishSuccessPopUpContains());

		logger.info("Ending of verifyPublishEventButton method");
	}

	/*@Test(priority = 44, description = "Verify Close Icon In YourEventIsNowPublished Success Popup", groups = "sanity")
	@Description("Test case #44, Verify Close Icon In YourEventIsNowPublished Success Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #44, Verify Close Icon In YourEventIsNowPublished Success Popup")
	public void verifyCloseIconInYourEventIsNowPublishedSuccessPopup() {
		logger.info("Starting of verifyCloseIconInYourEventIsNowPublishedSuccessPopup method");

		clubLogoPage.hardWait(3);
		addBracketPage.clickOnEventSuccessClosePopupButton();

		Assert.assertTrue(addEventPage.isClubPageContains());

		logger.info("Ending of verifyCloseIconInYourEventIsNowPublishedSuccessPopup method");
	}*/

	@Test(priority = 45, description = "Verify Recently Added Event Under Events Tab", groups = "sanity")
	@Description("Test case #45, Verify Recently Added Event Under Events Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #45, Verify Recently Added Event Under Events Tab")
	public void verifyRecentlyAddedEventUnderEventsTab() {
		logger.info("Starting of verifyRecentlyAddedEventUnderEventsTab method");

		clubLogoPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		Assert.assertTrue(addEventPage.isRecentlyAddedEventDisplayed(eventName));

		logger.info("Ending of verifyRecentlyAddedEventUnderEventsTab method");
	}

	@Test(priority = 46, description = "Verify Delete Bracket Functionality After Publishing Event", groups = "sanity")
	@Description("Test case #46, Verify Delete Bracket Functionality After Publishing Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #46, Verify Delete Bracket Functionality After Publishing Event")
	public void verifyDeleteBracketFunctionalityAfterPublishingEvent() {
		logger.info("Starting of VerifyRecentlyAddedEventUnderEventsTab method");

		clubLogoPage.hardWait(3);
		//addEventPage.clickOnAddEventButton();

		Assert.assertTrue(addEventPage.isEventInformationPageContains());

		this.verifyAddEventInformationDetailsFunctionalityWithValidDetails();
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

	@Test(priority = 47, description = "Verify Confirm Button Functionality In DeleteBracket", groups = "sanity")
	@Description("Test case #47, Verify Confirm Button Functionality In DeleteBracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #47, Verify Confirm  Button Functionality In DeleteBracket")
	public void verifyConfirmButtonFunctionalityInDeleteBracket() {
		logger.info("Starting of verifyConfirmButtonFunctionalityInDeleteBracket method");

		clubLogoPage.hardWait(3);
		addBracketPage.clickOnConfirmButton();

		addBracketPage.hardWait(3);

		Assert.assertTrue(addBracketPage.isDeleteBracketSuccessPopUpDisplayed());

		logger.info("Ending of verifyConfirmButtonFunctionalityInDeleteBracket method");
	}

	@Test(priority = 48, description = "Verify Ok Button Functionality In DeleteBracket SuccessPopUP", groups = "sanity")
	@Description("Test case #48, Verify Ok Button Functionality In DeleteBracket SuccessPopUP")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #48, Verify Ok  Button Functionality In DeleteBracket SuccessPopUP")
	public void verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP() {
		logger.info("Starting of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");

		clubLogoPage.hardWait(3);
		addBracketPage.clickOnOkButton();
		addBracketPage.hardWait(3);
		Assert.assertFalse(addBracketPage.isDeleteBracketSuccessPopUpDisplayed());

		driver.navigate().back();

		logger.info("Ending of verifyOkButtonFunctionalityInDeleteBracketSuccessPopUP method");
	}

	@Test(priority = 49, description = "Verify Free Event Functionality", groups = "sanity")
	@Description("Test case #49, Verify Free Event Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #49, Verify Free Event Functionality")
	public void verifyFreeEventFunctionality() {
		logger.info("Starting of verifyFreeEventFunctionality method");

		addEventPage.hardWait(4);
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
		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.verifyPublishEventButton();
		addBracketPage.clickOnEventSuccessClosePopupButton();

		addBracketPage.hardWait(3);
		this.verifyRecentlyAddedEventUnderEventsTab();

		logger.info("Ending of verifyFreeEventFunctionality method");
	}

	@Test(priority = 50, description = "Verify Free Bracket With Event Type As Round Robin", groups = "sanity")
	@Description("Test case #50, Verify Free Bracket With Event Type As Round Robin")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #50,Verify Free Bracket With Event Type As Round Robin")
	public void verifyFreeBracketWithEventTypeAsRoundRobin() {
		logger.info("Starting of verifyFreeBracketWithEventTypeAsRoundRobin method");

		clubLogoPage.hardWait(3);
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

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		this.verifyPublishEventButton();

		addBracketPage.clickOnEventSuccessClosePopupButton();

		addBracketPage.hardWait(3);
		this.verifyRecentlyAddedEventUnderEventsTab();

		logger.info("Ending of verifyFreeBracketWithEventTypeAsRoundRobin method");
	}

	@Test(priority = 51, description = "Verify Free Bracket With Event Type As Water Fall", groups = "sanity")
	@Description("Test case #51, Verify Free Bracket With Event Type As Water Fall")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #51,Verify Free Bracket With Event Type As Water Fall")
	public void verifyFreeBracketWithEventTypeAsWateFall() {
		logger.info("Starting of verifyFreeBracketWithEventTypeAsWateFall method");

		clubLogoPage.hardWait(3);
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
		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.verifyPublishEventButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventSuccessClosePopupButton();

		logger.info("Ending of verifyFreeBracketWithEventTypeAsWateFall method");
	}

	@Test(priority = 52, description = "Verify Delete Event Functionality after publishing the event", groups = "sanity")
	@Description("Test case #52, Verify Delete Event Functionality after publishing the event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #52, Verify Delete Event Functionality after publishing the event")
	public void verifyDeleteEventFunctionalityAfterPublishingEvent() {
		logger.info("Starting of verifyDeleteEventFunctionalityAfterPublishingEvent method");

		addBracketPage.hardWait(3);
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
