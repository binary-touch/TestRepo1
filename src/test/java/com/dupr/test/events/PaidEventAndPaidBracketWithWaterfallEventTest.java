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
import com.dupr.pages.home.PreservingPageVisitsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PaidEventAndPaidBracketWithWaterfallEventTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(PaidEventAndPaidBracketWithWaterfallEventTest.class.getName());
	private ClubLogoPage clubLogoPage = null;

	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;
	private PreservingPageVisitsPage preservingPageVisitsPage = null;
	
	@BeforeClass
	@Parameters({ "browser", "devsiteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String devsiteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in PaidEventAndPaidBracketWithWaterfallEventTest");

		this.driver = super.getWebDriver(WebDriversEnum.PAID_EVENT_DRIVER);
		this.siteLogin(devsiteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.preservingPageVisitsPage = new PreservingPageVisitsPage(this.driver);
		
		logger.info("Ending of initMethod in PaidEventAndPaidBracketWithWaterfallEventTest");
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
		super.verifyPaidEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();
		super.verifyPaidBracketWithEventTypeAsWateFallInSinglesMatchType();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		logger.info("Ending of verifyPaidEventFunctionalityWithWateFallEventTypeInSingles method");
	}

	    @Test(priority = 4, description = "verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView", groups = "sanity")
		@Description("Test case #4, verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView")
		@Severity(SeverityLevel.NORMAL)
		@Story("Test case #4, verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView")
	    @Parameters({ "browser", "devsiteURL", "validEmail", "validPassword" })
		public void verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView(String browser, String devsiteURL, String validEmail, String validPassword) throws Exception {
			logger.info("Starting of verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView method");

			userDashboardPage.clickOnSettings();
			
			preservingPageVisitsPage.clickOnLogoutButton();
			
			super.initCommonBaseTest( devsiteURL, validEmail, validPassword);
			
			super.verifyRegisterFunctionalityInPlayerAccount();
			
			
			logger.info("Ending of verifyPaidEventRegistrationFunctionalityWithWateFallEventTypeInDirectorAndOrganizerView method");

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
