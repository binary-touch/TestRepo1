package com.dupr.test.home;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.home.SharePage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Home")
@Feature(value = "Share")
public class ShareTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ShareTest.class.getName());
	private UserDashboardPage userDashboardPage = null;
	private BrowseClubsPage browseClubsPage = null;
	private SharePage sharePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ShareTest");

		this.driver = super.getWebDriver(WebDriversEnum.SHARE_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.sharePage = new SharePage(this.driver);

		logger.info("Ending of initMethod in ShareTest");
	}

	@Test(priority = 1, description = "Verify the results on click of the share button on the Dashboard page", groups = "sanity")
	@Description("Test case #1, Verify the results on click of the share button on the Dashboard page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the results on click of the share button on the Dashboard page")
	public void verifyShareOptionInDashboard() {
		logger.info("Starting of verifyShareOptionInDashboard method");

		userDashboardPage.clickOnShareButton();
		
		sharePage.hardWait(3);
		Assert.assertTrue(sharePage.isSharePopUPContains());

		logger.info("Ending of verifyShareOptionInDashboard method");
	}

	@Test(priority = 2, description = "Verify the results on click of the share button on the Brackets Home page", groups = "sanity")
	@Description("Test case #2, Verify the results on click of the share button on the Brackets Home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the results on click of the share button on the Brackets Home page")
	public void verifyShareOptionInBracketPage() {
		logger.info("Starting of verifyShareOptionInBracketPage method");

		userDashboardPage.clickOnMyBracketsButton();
		sharePage.hardWait(4);
		sharePage.clickOnCardLabel();
		sharePage.hardWait(4);
		sharePage.clickOnShareButton();

		sharePage.hardWait(3);
		Assert.assertTrue(sharePage.isSharePopUPContains());

		logger.info("Ending of verifyShareOptionInBracketPage method");
	}

	@Test(priority = 3, description = "Verify the results on click of the share button on the Club Home page", groups = "sanity")
	@Description("Test case #3, Verify the results on click of the share button on the Club Home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the results on click of the share button on the Club Home page")
	public void verifyShareOptionInClubPage() {
		logger.info("Starting of verifyShareOptionInClubPage method");

		browseClubsPage.clickOnBrowseClubsTab();
		sharePage.hardWait(4);
		sharePage.clickOnClubEventCardLabel();
		sharePage.hardWait(3);
		sharePage.clickOnShareButton();

		sharePage.hardWait(3);
		Assert.assertTrue(sharePage.isSharePopUPContains());

		logger.info("Ending of verifyShareOptionInClubPage method");
	}

	@Test(priority = 4, description = "Verify the results on click of the share button on the Event Home page", groups = "sanity")
	@Description("Test case #4, Verify the results on click of the share button on the Event Home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of the share button on the Event Home page")
	public void verifyShareOptionInEventsPage() {
		logger.info("Starting of verifyShareOptionInEventsPage method");

		userDashboardPage.clickOnEventsMenu();
		sharePage.hardWait(4);
		sharePage.clickOnEventNameCardLabel();
		sharePage.hardWait(3);
		sharePage.clickOnShareButton();
		
		sharePage.hardWait(3);
		Assert.assertTrue(sharePage.isSharePopUPContains());

		logger.info("Ending of verifyShareOptionInEventsPage method");
	}

	@Test(priority = 5, description = "Verify the results on click of the share button on the Player Profile page", groups = "sanity")
	@Description("Test case #5, Verify the results on click of the share button on the Player Profile page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click of the share button on the Player Profile page")
	public void verifyShareOptionInPlayerProfilePage() {
		logger.info("Starting of verifyShareOptionInPlayerProfilePage method");

		userDashboardPage.clickOnSettings();
		sharePage.clickOnEditProfileButton();
		sharePage.clickOnViewProfileButton();
		userDashboardPage.clickOnShareButton();

		sharePage.hardWait(3);
		Assert.assertTrue(sharePage.isSharePopUPContains());

		logger.info("Ending of verifyShareOptionInPlayerProfilePage method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SHARE_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
