package com.dupr.test.events;

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
import com.dupr.pages.events.AcceptOrDeclinePartnershipPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.Create_Edit_Split_TeamPage;
import com.dupr.pages.events.EditBracketsPage;
import com.dupr.pages.events.EditOrRemovePartnerPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.PaidEventPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.pages.events.WithdrawPlayerPage;
import com.dupr.pages.home.PreservingPageVisitsPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PaidEventAndPaidBracketWithWaterfallEventTest extends CommonBaseTest {

	private static final Logger logger = Logger
			.getLogger(PaidEventAndPaidBracketWithWaterfallEventTest.class.getName());

	private PreservingPageVisitsPage preservingPageVisitsPage = null;
	private EditOrRemovePartnerPage editOrRemovePartnerPage = null;
	private AcceptOrDeclinePartnershipPage acceptOrDeclinePartnershipPage = null;
	private EditBracketsPage editBracketsPage = null;
	private WithdrawPlayerPage withdrawPlayerPage = null;
	private Create_Edit_Split_TeamPage teamsPage = null;
	
	@BeforeClass
	@Parameters({ "browser", "devSiteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String devSiteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in PaidEventAndPaidBracketWithWaterfallEventTest");

		this.driver = super.getWebDriver(WebDriversEnum.PAID_EVENT_DRIVER);
		this.devSiteLogin(devSiteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.preservingPageVisitsPage = new PreservingPageVisitsPage(this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);
		this.playerEventRegistrationPage = new PlayerEventRegistrationPage(this.driver);
		this.paidEventPage = new PaidEventPage(this.driver);
		this.directorEventRegistrationPage = new EventRegistrationPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);
		this.eventRegistrationPage = new EventRegistrationPage(this.driver);
		this.editOrRemovePartnerPage = new EditOrRemovePartnerPage(this.driver);
		this.acceptOrDeclinePartnershipPage = new AcceptOrDeclinePartnershipPage(this.driver);
		this.editBracketsPage = new EditBracketsPage(this.driver);
		this.withdrawPlayerPage = new WithdrawPlayerPage(this.driver);
		this.teamsPage = new Create_Edit_Split_TeamPage(this.driver);
		
		logger.info("Ending of initMethod in PaidEventAndPaidBracketWithWaterfallEventTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality in Club page", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality in Club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality in Club page")
	public void verifyAddEventInformationPage() {
		logger.info("Starting of verifyAddEventInformationPage method");

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

		logger.info("Ending of verifyAddEventInformationPage method");
	}

	@Test(priority = 2, description = "Verify Paid Event Functionality with WateFall Event Type In Doubles Match", groups = "sanity")
	@Description("Test case #2, Verify Paid Event Functionality with WateFall Event Type In Doubles Match")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Paid Event Functionality with WateFall Event Type In Doubles Match")
	public void verifyPaidEventFunctionalityWithWateFallEventTypeInDoublesMatch() {
		logger.info("Starting of verifyPaidEventFunctionalityWithWateFallEventTypeInDoublesMatch method");

		super.verifyPaidEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();
		super.verifyPaidBracketWithEventTypeAsWateFallInDoublesMatchType();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		logger.info("Ending of verifyPaidEventFunctionalityWithWateFallEventTypeInDoublesMatch method");
	}

	@Test(priority = 3, description = "Verify Paid Event Functionality with WateFall Event Type In Singles Match", groups = "sanity")
	@Description("Test case #3, Verify Paid Event Functionality with WateFall Event Type In Singles Match")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Paid Event Functionality with WateFall Event Type In Singles Match")
	public void verifyPaidEventFunctionalityWithWateFallEventTypeInSinglesMatch() {
		logger.info("Starting of verifyPaidEventFunctionalityWithWateFallEventTypeInSinglesMatch method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();

		paidEventPage.hardWait(2);
		super.verifyPaidEventInformationPageWithValidDetails();

		paidEventPage.hardWait(2);
		super.verifyEventPoliciesPageByEnteringValidDetails();

		paidEventPage.hardWait(2);
		super.verifyPaidBracketWithEventTypeAsWateFallInSinglesMatchType();

		paidEventPage.hardWait(2);
		super.VerifyRecentlyAddedEventUnderEventsTab();

		super.verifyRegisterFunctionality();

		logger.info("Ending of verifyPaidEventFunctionalityWithWateFallEventTypeInSinglesMatch method");
	}

	@Parameters({ "devSiteURL", "validEmail", "validPassword" })
	@Test(priority = 4, description = "Verify Paid Event Registration functionality with WateFall Event Type in Players View", groups = "sanity")
	@Description("Test case #4, Verify Paid Event Registration functionality with WateFall Event Type in Players View")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Paid Event Registration functionality with WateFall Event Type in Players View")
	public void verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView(String devSiteURL,
			String validEmail, String validPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();

		clubLogoPage.clickOnSimbaClubName();
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		super.verifyRegisterFunctionalityWithNonMemberInPlayerAccount();
		paidEventPage.clickOnContinuePaymentButton();

		logger.info("Ending of verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView method");
	}

	@Test(priority = 5, description = "Verify Back Button functionality in Payment Page", groups = "sanity")
	@Description("Test case #5, Verify Back Button functionality in Payment Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Back Button functionality in Payment Page")
	public void verifyBackArrowButtonInPaymentPage() {
		logger.info("Starting of verifyBackArrowButtonInPaymentPage method");

		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();

		Assert.assertTrue(paidEventPage.isRegistrationUnSuccessFullPageContains());

		logger.info("Ending of verifyBackArrowButtonInPaymentPage method");
	}

	@Test(priority = 6, description = "Verify Ok Button Functionality in Registration Unsuccessfull PopUp", groups = "sanity")
	@Description("Test case #6, Verify Ok Button Functionality in Registration Unsuccessfull PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Ok Button Functionality in Registration Unsuccessfull PopUp")
	public void verifyOkButtonFunctionalityInRegistrationUnsuccessfullPopUp() {
		logger.info("Starting of verifyOkButtonFunctionalityInRegistrationUnsuccessfullPopUp method");

		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();

		super.verifyRegisterFunctionalityWithNonMemberInPlayerAccount();

		paidEventPage.clickOnContinuePaymentButton();

		logger.info("Ending of verifyOkButtonFunctionalityInRegistrationUnsuccessfullPopUp method");
	}

	@Test(priority = 7, description = "Verify Close icon functionality in Payment Page", groups = "sanity")
	@Description("Test case #7, Verify Close icon functionality in Payment Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Close icon functionality in Payment Page")
	public void verifyCloseIconFunctionalityInPaymentPage() {
		logger.info("Starting of verifyCloseIconFunctionalityInPaymentPage method");

		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();

		Assert.assertTrue(paidEventPage.isRegistrationUnSuccessFullPageContains());

		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();

		super.verifyRegisterFunctionalityWithNonMemberInPlayerAccount();

		paidEventPage.clickOnContinuePaymentButton();

		logger.info("Ending of verifyCloseIconFunctionalityInPaymentPage method");
	}

	@Test(priority = 8, description = "Verify Event Non-Member Total Price in Payment Page", groups = "sanity")
	@Description("Test case #8, Verify Event Non-Member Total Price in Payment Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Event Non-Member Total Price in Payment Page")
	public void verifyEventNonMemberTotalPriceInPaymentPage() {
		logger.info("Starting of verifyEventNonMemberTotalPriceInPaymentPage method");

		float nonClubMemberEventPrice = paidEventPage.getEventNonClubMemberPriceValue();
		Assert.assertSame(nonmemberPrice, nonClubMemberEventPrice);

		float nonClubMemberBracketPrice = paidEventPage.getBracketNonClubMemberPriceValue();
		Assert.assertSame(bracketNonMember, nonClubMemberBracketPrice);

		float nonClubMemberTotalPrice = paidEventPage.getTotalNonMemberPriceValue();
		Assert.assertSame(totalNonMemberPrice, nonClubMemberTotalPrice);

		logger.info("Ending of verifyEventNonMemberTotalPriceInPaymentPage method");
	}

	@Test(priority = 9, description = "Verify Event Club-Member Total Price in Payment Page", groups = "sanity")
	@Description("Test case #9, Verify Event Club-Member Total Price in Payment Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Event Club-Member Total Price in Payment Page")
	public void verifyEventClubMemberTotalPriceInPaymentPage() {
		logger.info("Starting of verifyEventClubMemberTotalPriceInPaymentPage method");

		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();
		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();
		super.verifyRegisterFunctionalityWithMemberInPlayerAccount();
		paidEventPage.clickOnContinuePaymentButton();

		float clubMemberEventPrice = paidEventPage.getEventClubMemberPriceValue();
		Assert.assertSame(memberPrice, clubMemberEventPrice);

		float clubMemberBracketPrice = paidEventPage.getBracketClubMemberPriceValue();
		Assert.assertSame(bracketMember, clubMemberBracketPrice);

		float clubMemberTotalPrice = paidEventPage.getTotalMemberPriceValue();
		Assert.assertSame(totalMemberPrice, clubMemberTotalPrice);

		logger.info("Ending of verifyEventClubMemberTotalPriceInPaymentPage method");
	}

	@Test(priority = 10, description = "Verify Payment Functionality in Payment Page", groups = "sanity")
	@Description("Test case #10, Verify Payment Functionality in Payment Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Payment Functionality in Payment Page")
	public void verifyPaymentFunctionalityInPaymentPage() {
		logger.info("Starting of verifyPaymentFunctionalityInPaymentPage method");

		Assert.assertEquals(paidEventPage.getPayWithCardLabel(), expectedAssertionsProp.getProperty("pay.with.card"));

		Assert.assertEquals(paidEventPage.getMeetMailLabel(), expectedAssertionsProp.getProperty("meet.mail"));

		paidEventPage.setCardInformation(testDataProp.getProperty("card.information"));
		paidEventPage.setBoxCardExpiry(testDataProp.getProperty("card.expiry"));
		paidEventPage.setBoxCardCVC(testDataProp.getProperty("card.cvc"));
		paidEventPage.setBoxNameOnCard(testDataProp.getProperty("name.on.card"));
		paidEventPage.clickOnPayButton();

		logger.info("Ending of verifyPaymentFunctionalityInPaymentPage method");
	}

	@Parameters({ "browser", "devSiteURL", "directorEmail", "directorPassword" })
	@Test(priority = 11, description = "Verify Paid Event Register with Partner Functionality", groups = "sanity")
	@Description("Test case #11, Verify Paid Event Register with Partner Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Paid Event Register with Partner Functionality")
	public void verifyPaidEventRegisterWithPartnerFunctionality(String browser, String devSiteURL, String directorEmail,
			String directorPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegisterWithPartnerFunctionality method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, directorEmail, directorPassword, this.driver);
		paidEventPage.hardWait(3);
		this.verifyAddEventInformationPage();
		this.verifyPaidEventFunctionalityWithWateFallEventTypeInDoublesMatch();

		eventRegistrationPage.clickOnRegisterButton();

		Assert.assertTrue(eventRegistrationPage.isBracketsCheckBoxesDisplayed());

		Assert.assertEquals(eventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(eventRegistrationPage.getRefundPolicyLabel(),
				expectedAssertionsProp.getProperty("refund.policy"));

		Assert.assertEquals(eventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		Assert.assertEquals(eventRegistrationPage.getLiabiltyPolicyLabel(),
				expectedAssertionsProp.getProperty("liabilty.policies"));

		Assert.assertTrue(eventRegistrationPage.isDisableRegisterButtonDisplayed());

		eventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(eventRegistrationPage.isRefundPolicyCheckboxSelected());

		eventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(eventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());

		eventRegistrationPage.clickOnLiabilityCheckbox();
		Assert.assertTrue(eventRegistrationPage.isLiabilityPolicyCheckboxSelected());

		Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnRegisterButton();

		logger.info("Ending of verifyPaidEventRegisterWithPartnerFunctionality method");
	}

	@Parameters({ "devSiteURL", "validEmail", "validPassword" })
	@Test(priority = 12, description = "Verify Paid Event Register with Partner Functionality in Players view", groups = "sanity")
	@Description("Test case #12, Verify Paid Event Register with Partner Functionality in Players view")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Paid Event Register with Partner Functionality in Players view")
	public void verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView(String devSiteURL, String validEmail,
			String validPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();
		paidEventPage.hardWait(3);
		clubLogoPage.clickOnSimbaClubName();
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		playerEventRegistrationPage.clickOnRegisterButtonInEventPage();

		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(playerEventRegistrationPage.getClubMembershipLabel(),
				expectedAssertionsProp.getProperty("club.membership"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		playerEventRegistrationPage.clickOnClubMemberNoButton();

		directorEventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnAddYourPartnerButton();
		eventRegistrationPage.clickOnOkButton();

		eventRegistrationPage.clickOnAddYourPartnerRadioButton();
		eventRegistrationPage.clickOnAddPartnerRadioButton();

		directorEventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());
		try {
			directorEventRegistrationPage.clickOnLiabilityCheckbox();
			Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}

		paidEventPage.clickOnContinuePaymentButton();

		this.verifyEventNonMemberTotalPriceInPaymentPage();
		this.verifyPaymentFunctionalityInPaymentPage();

		logger.info("Ending of verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView method");
	}

	@Parameters({ "browser", "devSiteURL", "directorEmail", "directorPassword" })
	@Test(priority = 13, description = "Verify Accept/Decline Paid Event with Partner Functionality in Director/Organizer View", groups = "sanity")
	@Description("Test case #13, Verify Accept/Decline Paid Event with Partner Functionality in Director/Organizer View")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Accept/Decline Paid Event with Partner Functionality in Director/Organizer View")
	public void verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInDirectorOrOrganizerView(String browser,
			String devSiteURL, String directorEmail, String directorPassword) throws Exception {
		logger.info(
				"Starting of verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInDirectorOrOrganizerView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, directorEmail, directorPassword, this.driver);
		paidEventPage.hardWait(3);
		this.verifyAddEventInformationPage();
		this.verifyPaidEventFunctionalityWithWateFallEventTypeInDoublesMatch();

		eventRegistrationPage.clickOnRegisterButton();

		Assert.assertTrue(eventRegistrationPage.isBracketsCheckBoxesDisplayed());

		Assert.assertEquals(eventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("event.registration.text"));

		Assert.assertEquals(eventRegistrationPage.getRefundPolicyLabel(),
				expectedAssertionsProp.getProperty("refund.policy"));

		Assert.assertEquals(eventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		Assert.assertEquals(eventRegistrationPage.getLiabiltyPolicyLabel(),
				expectedAssertionsProp.getProperty("liabilty.policies"));

		Assert.assertTrue(eventRegistrationPage.isDisableRegisterButtonDisplayed());

		eventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(eventRegistrationPage.isBracketCheckboxSelected());

		eventRegistrationPage.clickOnAddYourPartnerButton();
		eventRegistrationPage.clickOnOkButton();

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
		editOrRemovePartnerPage.hardWait(3);
		Assert.assertTrue(editOrRemovePartnerPage.isValidPartnerDisplayed(testDataProp.getProperty("partner.name")));

		eventRegistrationPage.clickOnAddYourPartnerRadioButton();
		eventRegistrationPage.clickOnAddPartnerRadioButton();

		directorEventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());
		try {
			directorEventRegistrationPage.clickOnLiabilityCheckbox();
			Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}
		eventRegistrationPage.clickOnRegisterButton();
		eventRegistrationPage.clickOnOkButton();
		/*
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
		 */
		logger.info("Ending of verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInDirectorOrOrganizerView method");
	}

	@Parameters({ "devSiteURL", "validEmail", "validPassword" })
	@Test(priority = 14, description = "Verify Accept/Decline Paid Event with Partner Functionality in Players View", groups = "sanity")
	@Description("Test case #14, Verify Accept/Decline Paid Event with Partner Functionality in Players View")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Accept/Decline Paid Event with Partner Functionality in Players View")
	public void verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInPlayerView(String devSiteURL, String validEmail,
			String validPassword) throws Exception {
		logger.info("Starting of verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInPlayerView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();
		paidEventPage.hardWait(3);
		addEventPage.clickOnSimbaClubName();
		paidEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		editBracketsPage.clickOnBracketLabel();
		paidEventPage.hardWait(3);

		acceptOrDeclinePartnershipPage.clickOnAcceptButton();
		acceptOrDeclinePartnershipPage.clickOnNoRadioButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isNoRadioButtonSelected());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		acceptOrDeclinePartnershipPage.clickOnRegisterButton();

		this.verifyEventNonMemberTotalPriceInPaymentPage();
		this.verifyPaymentFunctionalityInPaymentPage();

		logger.info("Ending of verifyAcceptOrDeclinePaidEventWithPartnerFunctionalityInPlayerView method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.PAID_EVENT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
