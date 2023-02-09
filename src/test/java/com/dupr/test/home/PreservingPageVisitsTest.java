package com.dupr.test.home;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.home.PreservingPageVisitsPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.pages.profile.EditProfilePage;
import com.dupr.test.CommonBaseTest;
import com.dupr.test.events.WithdrawPlayerTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Home")
@Feature(value = "Preserving Page Visits")
public class PreservingPageVisitsTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(WithdrawPlayerTest.class.getName());
	private BrowsePlayersPage browsePlayersPage = null;;
	private UserDashboardPage userDashboardPage = null;
	private BrowseClubsPage browseClubsPage = null;
	private PreservingPageVisitsPage preservingPageVisitsPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private AddAMatchPage addAMatchPage = null;
	private EditProfilePage editProfilePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in WithdrawPlayerTest");

		this.driver = super.getWebDriver(WebDriversEnum.PRESERVING_PAGE_VISITS_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.browsePlayersPage = new BrowsePlayersPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.preservingPageVisitsPage = new PreservingPageVisitsPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.editProfilePage = new EditProfilePage(this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		logger.info("Ending of initMethod in WithdrawPlayerTest");
	}

	@Test(priority = 1, description = "Verify the preserving page vistis on Browse players", groups = "sanity")
	@Description("Test case #1, Verify the preserving page vistis on Browse players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the preserving page vistis on Browse players")
	public void verifyPreservingPageVisitsFeatureInBrowsePlayers() {
		logger.info("Starting of verifyPreservingPageVisitsFeatureInBrowsePlayers method");

		addAMatchPage.clickOnPlayersTab();
		addAMatchPage.hardWait(3);
		Assert.assertTrue(browsePlayersPage.isBrowsePlayersPageContains());
		preservingPageVisitsPage.clickOnPlayersSearch(testDataProp.getProperty("player.name.txt"));
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnName();
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnBackButton();
		Assert.assertTrue(preservingPageVisitsPage.getPlayerName(testDataProp.getProperty("player.name.txt")));
		logger.info("Ending of verifyPreservingPageVisitsFeatureInBrowsePlayers method");
	}

	@Test(priority = 2, description = "Verify the preserving page vistis on Search Clubs", groups = "sanity")
	@Description("Test case #2, Verify the preserving page vistis on Search Clubs")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the preserving page vistis on Search Clubs")
	public void verifyPreservingPageVisitsFeatureInSearchClubs() {
		logger.info("Starting of verifyPreservingPageVisitsFeatureInSearchClubs method");

		browseClubsPage.clickOnBrowseClubsTab();
		browseEventsPage.hardWait(3);
		Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
		preservingPageVisitsPage.clickOnPlayersSearch(testDataProp.getProperty("club.name.txt"));
		preservingPageVisitsPage.clickOnName();
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnBackButton();
		Assert.assertTrue(preservingPageVisitsPage.getPlayerName(testDataProp.getProperty("club.name.txt")));

		logger.info("Ending of verifyPreservingPageVisitsFeatureInSearchClubs method");
	}

	@Test(priority = 3, description = "Verify the preserving page vistis on Search Events", groups = "sanity")
	@Description("Test case #3, Verify the preserving page vistis on Search Events")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the preserving page vistis on Search Events")
	public void verifyPreservingPageVisitsFeatureInSearchEvents() {
		logger.info("Starting of verifyPreservingPageVisitsFeatureInSearchEvents method");

		userDashboardPage.clickOnEventsMenu();
		browseEventsPage.hardWait(3);
		Assert.assertTrue(browseEventsPage.isBrowseEventsPageContains());
		preservingPageVisitsPage.clickOnPlayersSearch(testDataProp.getProperty("event.name.txt"));
		preservingPageVisitsPage.clickOnName();
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnBackButton();
		Assert.assertTrue(preservingPageVisitsPage.getPlayerName(testDataProp.getProperty("event.name.txt")));

		logger.info("Ending of verifyPreservingPageVisitsFeatureInSearchEvents method");
	}

	@Test(priority = 4, description = "Verify the preserving page vistis on Search Players", groups = "sanity")
	@Description("Test case #4, Verify the preserving page vistis on Search Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the preserving page vistis on Search Players")
	public void verifyPreservingPageVisitsFeatureInSearchPlayers() {
		logger.info("Starting of verifyPreservingPageVisitsFeatureInSearchPlayers method");

		userDashboardPage.clickOnDUPRLogoLink();
		browseEventsPage.hardWait(3);
		userDashboardPage.clickOnSearchPlayers();
		preservingPageVisitsPage.clickOnPlayersSearch(testDataProp.getProperty("player.name.txt"));
		preservingPageVisitsPage.clickOnLocationField(testDataProp.getProperty("location.txt"));
		preservingPageVisitsPage.clickOnLocation();
		preservingPageVisitsPage.clickOnName();
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnBackButton();
		browseEventsPage.hardWait(3);
		Assert.assertTrue(preservingPageVisitsPage.getPlayerName(testDataProp.getProperty("player.name.txt")));
		Assert.assertTrue(preservingPageVisitsPage.getLocation(testDataProp.getProperty("location.txt")));

		logger.info("Ending of verifyPreservingPageVisitsFeatureInSearchPlayers method");
	}

	@Test(priority = 5, description = "Verify the preserving page vistis on Claim Account", groups = "sanity")
	@Description("Test case #5, Verify the preserving page vistis on Claim Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the preserving page vistis on Claim Account")
	public void verifyPreservingPageVisitsFeatureInClaimAccountPage() {
		logger.info("Starting of verifyPreservingPageVisitsFeatureInClaimAccountPage method");

		editProfilePage.clickOnOpenSettingMenu();
		browseEventsPage.hardWait(2);
		preservingPageVisitsPage.clickOnLogoutButton();
		browseEventsPage.hardWait(2);
		preservingPageVisitsPage.clickOnSignUpButton();
		preservingPageVisitsPage.clearSearchField();
		preservingPageVisitsPage.clickOnPlayersSearch(testDataProp.getProperty("clam.account.txt"));
		preservingPageVisitsPage.clickOnClamAccount();
		preservingPageVisitsPage.hardWait(3);
		preservingPageVisitsPage.clickOnGoBackButton();
		browseEventsPage.hardWait(3);
		Assert.assertTrue(preservingPageVisitsPage.getPlayerName(testDataProp.getProperty("clam.account.txt")));

		logger.info("Ending of verifyPreservingPageVisitsFeatureInClaimAccountPage method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.PRESERVING_PAGE_VISITS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
