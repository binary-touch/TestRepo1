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
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.PaidEventPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
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
		logger.info("Ending of initMethod in PaidEventAndPaidBracketWithWaterfallEventTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
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

	@Test(priority = 2, description = "verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles", groups = "sanity")
	@Description("Test case #2, verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles")
	public void verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles() {
		logger.info("Starting of verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles method");

		super.verifyPaidEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();
		super.verifyPaidBracketWithEventTypeAsWateFallInDoublesMatchType();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		logger.info("Ending of verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles method");

	}

	@Test(priority = 3, description = "verifyPaidEventFunctionalityWithWateFallEventTypeInSingles", groups = "sanity")
	@Description("Test case #3, verifyPaidEventFunctionalityWithWateFallEventTypeInSingles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verifyPaidEventFunctionalityWithWateFallEventTypeInSingles")
	public void verifyPaidEventFunctionalityWithWateFallEventTypeInSingles() {
		logger.info("Starting of verifyPaidEventFunctionalityWithWateFallEventTypeInSingles method");

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

		
		logger.info("Ending of verifyPaidEventFunctionalityWithWateFallEventTypeInSingles method");
	}

	@Parameters({ "devSiteURL", "validEmail", "validPassword" })
	@Test(priority = 4, description = "verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView", groups = "sanity")
	@Description("Test case #4, verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView")
	public void verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView(String devSiteURL,
			String validEmail, String validPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInPlayersView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnSettings();

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

	@Test(priority = 5, description = "verifyBackArrowButtonInPaymentPage", groups = "sanity")
	@Description("Test case #5, verifyBackArrowButtonInPaymentPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verifyBackArrowButtonInPaymentPage")
	public void verifyBackArrowButtonInPaymentPage() {
		logger.info("Starting of verifyBackArrowButtonInPaymentPage method");

		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();

		Assert.assertTrue(paidEventPage.isRegistrationUnSuccessFulPageContains());

		logger.info("Ending of verifyBackArrowButtonInPaymentPage method");
	}

	@Test(priority = 6, description = "verifyOkButtonInRegistrationUnsuccessfulPopUp", groups = "sanity")
	@Description("Test case #6, verifyOkButtonInRegistrationUnsuccessfulPopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verifyOkButtonInRegistrationUnsuccessfulPopUp")
	public void verifyOkButtonInRegistrationUnsuccessfulPopUp() {
		logger.info("Starting of verifyOkButtonInRegistrationUnsuccessfulPopUp method");

		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();

		super.verifyRegisterFunctionalityWithNonMemberInPlayerAccount();

		paidEventPage.clickOnContinuePaymentButton();

		logger.info("Ending of verifyOkButtonInRegistrationUnsuccessfulPopUp method");

	}

	@Test(priority = 7, description = "verifyCloseIconInPaymentPage", groups = "sanity")
	@Description("Test case #7, verifyCloseIconInPaymentPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, verifyCloseIconInPaymentPage")
	public void verifyCloseIconInPaymentPage() {
		logger.info("Starting of verifyCloseIconInPaymentPage method");

		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();

		Assert.assertTrue(paidEventPage.isRegistrationUnSuccessFulPageContains());

		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();

		super.verifyRegisterFunctionalityWithNonMemberInPlayerAccount();

		paidEventPage.clickOnContinuePaymentButton();

		logger.info("Ending of verifyCloseIconInPaymentPage method");

	}

	@Test(priority = 8, description = "verifyEventNonMemberTotalPriceInPaymentPage", groups = "sanity")
	@Description("Test case #8, verifyEventNonMemberTotalPriceInPaymentPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, verifyEventNonMemberTotalPriceInPaymentPage")
	public void verifyEventNonMemberTotalPriceInPaymentPage() {
		logger.info("Starting of verifyEventNonMemberTotalPriceInPaymentPage method");

		float nonClubMemberEventPrice = paidEventPage.getEventNonClubMemberPriceValue();
		Assert.assertSame(nonmemberPrice, nonClubMemberEventPrice);

		float nonClubMemberBracketPrice = paidEventPage.getBracketNonClubMemberPriceValue();
		Assert.assertSame(bracketNonMember, nonClubMemberBracketPrice);

		float nonClubMemberTotalPrice = paidEventPage.getToatalNonMemberPriceValue();
		Assert.assertSame(totalNonMemberPrice, nonClubMemberTotalPrice);

		logger.info("Ending of verifyEventNonMemberTotalPriceInPaymentPage method");

	}
	
	@Test(priority = 9, description = "verifyEventClubMemberTotalPriceInPaymentPage", groups = "sanity")
	@Description("Test case #9, verifyEventClubMemberTotalPriceInPaymentPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, verifyEventClubMemberTotalPriceInPaymentPage")
	public void verifyEventClubMemberTotalPriceInPaymentPage() {
		logger.info("Starting of verifyEventClubMemberTotalPriceInPaymentPage method");
		
		paidEventPage.hardWait(3);
		paidEventPage.clickOnBackTodkarsButton();
		paidEventPage.clickOnRegistrationUnsuccessfulOkButton();
		super.verifyRegisterFunctionalityWithMemberInPlayerAccount();
		paidEventPage.clickOnContinuePaymentButton();
		
		float clubMemberEventPrice = paidEventPage.getEvenClubMemberPriceValue();
		Assert.assertSame(memberPrice, clubMemberEventPrice);

		float clubMemberBracketPrice = paidEventPage.getBracketClubMemberPriceValue();
		Assert.assertSame(bracketMember, clubMemberBracketPrice);

		float clubMemberTotalPrice = paidEventPage.getToatalMemberPriceValue();
		Assert.assertSame(totalMemberPrice, clubMemberTotalPrice);

		logger.info("Ending of verifyEventClubMemberTotalPriceInPaymentPage method");

	}

	@Test(priority = 10, description = "verifyPaymentFunctionalityinPaymentPage", groups = "sanity")
	@Description("Test case #10, verifyPaymentFunctionalityinPaymentPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, verifyPaymentFunctionalityinPaymentPage")
	public void verifyPaymentFunctionalityinPaymentPage() {
		logger.info("Starting of verifyPaymentFunctionalityinPaymentPage method");

		Assert.assertEquals(paidEventPage.getPayWithCardLabel(), expectedAssertionsProp.getProperty("pay.with.card"));
		
		Assert.assertEquals(paidEventPage.getMeetMailLabel(), expectedAssertionsProp.getProperty("meet.mail"));
		
		paidEventPage.setCardInformation(testDataProp.getProperty("card.information"));
		
		paidEventPage.setBoxCardExpiry(testDataProp.getProperty("card.expiry"));
		
		paidEventPage.setBoxCardCvc(testDataProp.getProperty("card.cvc"));
		
		paidEventPage.setBoxNameOnCard(testDataProp.getProperty("name.on.card"));
				
		paidEventPage.clickOnPayButton();
		
		logger.info("Ending of verifyPaymentFunctionalityinPaymentPage method");

	}
	@Parameters({ "browser", "devSiteURL", "directorEmail", "directorPassword" })
	@Test(priority = 11, description = "verifyPaidEventRegisterWithPartnerFunctionality", groups = "sanity")
	@Description("Test case #11, verifyPaidEventRegisterWithPartnerFunctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, verifyPaidEventRegisterWithPartnerFunctionality")
	public void verifyPaidEventRegisterWithPartnerFunctionality(String browser, String devSiteURL, String directorEmail, String directorPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegisterWithPartnerFunctionality method");
		
		paidEventPage.hardWait(3);
		userDashboardPage.clickOnSettings();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, directorEmail, directorPassword, this.driver);
		paidEventPage.hardWait(3);
		this.verifyAddEventInformationPage();
		this.verifyPaidEventFunctionalityWithWateFallEventTypeInDoubles();
    
		super.verifyRegisterFunctionality();

		logger.info("Ending of verifyPaidEventRegisterWithPartnerFunctionality method");

		}
	
	@Parameters({ "devSiteURL", "validEmail", "validPassword" })
	@Test(priority = 12, description = "verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView", groups = "sanity")
	@Description("Test case #12, verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView")
	public void verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView(String devSiteURL,
			String validEmail, String validPassword) throws Exception {
		logger.info("Starting of verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView method");

		paidEventPage.hardWait(3);
		userDashboardPage.clickOnSettings();

		preservingPageVisitsPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(devSiteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();
		
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
		this.verifyPaymentFunctionalityinPaymentPage();

		logger.info("Ending of verifyPaidEventRegisterWithPartnerFunctionalityInPlayersView method");

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
