package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Browse Events-Sanity")
public class BrowseEventsTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(BrowseEventsTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private BrowseEventsPage browseEventsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in BrowseEventsTest");

		this.driver = super.getWebDriver(WebDriversEnum.BROWSE_EVENTS_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);

		logger.info("Ending of initMethod in BrowseEventsTest");
	}

	@Test(priority = 1, description = "Verify my events functionality", groups = "sanity")
	@Description("Test case #1, Verify my events functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify my events functionality")
	public void verifyMyEventsFunctionality() {
		logger.info("Starting of verifyMyEventsFunctionality method");

		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		Assert.assertEquals(browseEventsPage.getEventsText(), expectedAssertionsProp.getProperty("txt.event"));

		Assert.assertTrue(browseEventsPage.isMyEventsPageContains());

		logger.info("Ending of verifyMyEventsFunctionality method");
	}

	@Test(priority = 2, description = "Verify Browse events functionality", groups = "sanity")
	@Description("Test case #2, Verify Browse events functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Browse events functionality")
	public void verifyBrowseEventsFunctionality() {
		logger.info("Starting of verifyBrowseEventsFunctionality method");

		browseEventsPage.clickOnBrowseAllEventsButton();

		clubLogoPage.hardWait(2);

		logger.info("Ending of verifyBrowseEventsFunctionality method");
	}

	@Test(priority = 3, description = "Verify search field functionality", groups = "sanity")
	@Description("Test case #3, Verify search field  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify search field  functionality")
	public void verifySearchFieldFunctionality() {
		logger.info("Starting of verifySearchFieldFunctionality method");

		browseEventsPage.clickOnSearchField(testDataProp.getProperty("invalid.event.search"));

		Assert.assertEquals(browseEventsPage.getNoResultsFoundText(),
				expectedAssertionsProp.getProperty("no.events.found"));

		logger.info("Ending of verifySearchFieldFunctionality method");
	}

	@Test(priority = 4, description = "Verify complete filter functionality", groups = "sanity")
	@Description("Test case #4, Verify complete filter  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify complete filter  functionality")
	public void verifyCompleteFunctionality() {
		logger.info("Starting of verifyCompleteFunctionality method");

		browseEventsPage.clearSearchField();
		browseEventsPage.hardWait(2);
		browseEventsPage.clickOnCompleted();
		Assert.assertTrue(browseEventsPage.getCompleteText());

		logger.info("Ending of verifyCompleteFunctionality method");
	}

	//@Test(priority = 5, description = "Verify complete & open filter functionality", groups = "sanity")
	@Description("Test case #5, Verify complete & open filter functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify complete & open filter functionality")
	public void verifyCompleteAndOpenFilterFunctionality() {
		logger.info("Starting of verifyCompleteAndOpenFilterFunctionality method");

		browseEventsPage.hardWait(3);
		browseEventsPage.clickOnOpen();
		Assert.assertTrue(browseEventsPage.getCompleteOpenEventsText());

		logger.info("Ending of verifyCompleteAndOpenFilterFunctionality method");
	}

	//@Test(priority = 6, description = "Verify open filter functionality", groups = "sanity")
	@Description("Test case #6, Verify open filter functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify open filter functionality")
	public void verifyOpenFilterFunctionality() {
		logger.info("Starting of verifyOpenFilterFunctionality method");

		browseEventsPage.clickOnClearFiltersButton();

		browseEventsPage.hardWait(3);
		browseEventsPage.clickOnOpen();
		browseEventsPage.hardWait(2);
		browseEventsPage.getOpenEventsText();

		logger.info("Ending of verifyOpenFilterFunctionality method");
	}

	@Test(priority = 7, description = "Verify Toggle functionality", groups = "sanity")
	@Description("Test case #7, Verify Toggle functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Toggle functionality")
	public void verifyToggleFunctionality() {
		logger.info("Starting of verifyToggleFunctionality method");

		browseEventsPage.hardWait(2);
		browseEventsPage.clickOnClearFiltersButton();
		browseEventsPage.clickOnFindEventsNearMeToggleButton();

		browseEventsPage.hardWait(2);

		logger.info("Ending of verifyToggleFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.BROWSE_EVENTS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
