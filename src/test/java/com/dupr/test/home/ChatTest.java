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
import com.dupr.pages.home.ChatPage;
import com.dupr.pages.home.PreservingPageVisitsPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Home")
@Feature(value = "Chat")

public class ChatTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ChatTest.class.getName());

	private UserDashboardPage userDashboardPage = null;
	private AddAMatchPage addAMatchPage = null;

	private BrowseEventsPage browseEventsPage = null;

	private BrowseClubsPage browseClubsPage = null;
	private ChatPage chatpage = null;

	private PreservingPageVisitsPage preservingPageVisitsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ChatTest");

		this.driver = super.getWebDriver(WebDriversEnum.CHAT_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);

		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.chatpage = new ChatPage(this.driver);
		this.preservingPageVisitsPage = new PreservingPageVisitsPage(this.driver);

		logger.info("Ending of initMethod in ChatTest");
	}

	@Test(priority = 1, description = "Verify Message Icon Functionality In Dashboard", groups = "sanity")
	@Description("Test case #1, Verify Message Icon Functionality In Dashboard")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Message Icon Functionality In Dashboard")
	public void verifyMessageIconFunctionalityInDashboard() {
		logger.info("Starting of verifyMessageIconFunctionalityInDashboard method");

		Assert.assertTrue(chatpage.isMessageIconDisplayed());

		userDashboardPage.clickOnMessageIcon();

		Assert.assertTrue(chatpage.isMessagePopUpContains());

		chatpage.clickOnTextMessage(testDataProp.getProperty("message.txt"));
		chatpage.hardWait(2);
		chatpage.clickOnCloseIcon();

		logger.info("Ending of verifyMessageIconFunctionalityInDashboard method");
	}

	@Test(priority = 2, description = "Verify Message Icon Functionality In Browse playes", groups = "sanity")
	@Description("Test case #2, Verify Message Icon Functionality In Browse playes")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Message Icon Functionality In Browse playes")
	public void verifyMessageIconFunctionalityInBrowsePlayers() {
		logger.info("Starting of verifyMessageIconFunctionalityInBrowsePlayers method");

		addAMatchPage.clickOnPlayersTab();
		browseEventsPage.hardWait(4);
		chatpage.clickOnMessageIcon();

		Assert.assertTrue(chatpage.isMessagePopUpContains());

		chatpage.clickOnTextMessage(testDataProp.getProperty("message.txt"));
		chatpage.hardWait(2);
		chatpage.clickOnCloseIcon();

		logger.info("Ending of verifyMessageIconFunctionalityInBrowsePlayers method");
	}

	@Test(priority = 3, description = "Verify Message Icon Functionality In playes profile", groups = "sanity")
	@Description("Test case #3, Verify Message Icon Functionality In playes profile")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Message Icon Functionality In playes profile")
	public void verifyMessageIconFunctionalityInPlayersProfile() {
		logger.info("Starting of verifyMessageIconFunctionalityInPlayersProfile method");

		chatpage.clickOnPlayersCard();
		chatpage.clickOnMessageButton();

		Assert.assertTrue(chatpage.isMessagePopUpContains());

		chatpage.clickOnTextMessage(testDataProp.getProperty("message.txt"));
		chatpage.hardWait(2);
		chatpage.clickOnCloseIcon();

		logger.info("Ending of verifyMessageIconFunctionalityInPlayersProfile method");
	}

	@Test(priority = 4, description = "Verify Message Icon Functionality In Club members", groups = "sanity")
	@Description("Test case #4, Verify Message Icon Functionality In Club members")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Message Icon Functionality In Club members")
	public void verifyMessageIconFunctionalityInClubmembers() {
		logger.info("Starting of verifyMessageIconFunctionalityInClubmembers method");

		browseClubsPage.clickOnBrowseClubsTab();
		chatpage.hardWait(3);
		chatpage.searchForClub(testDataProp.getProperty("club.name"));
		chatpage.clickOnClubCard();
		chatpage.hardWait(3);
		chatpage.clickOnMessageIconClub();

		Assert.assertTrue(chatpage.isMessagePopUpContains());

		chatpage.clickOnTextMessage(testDataProp.getProperty("message.txt"));
		chatpage.hardWait(2);
		chatpage.clickOnCloseIcon();

		logger.info("Ending of verifyMessageIconFunctionalityInClubmembers method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 5, description = "Verify the results on click of chart icon on Dashboard with no charts", groups = "sanity")
	@Description("Test case #5, Verify the results on click of chart icon on Dashboard with no charts")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click of chart icon on Dashboard with no charts")
	public void verifyEmptyInBoxOnDashboard(String validPassword) {
		logger.info("Starting of verifyEmptyInBoxOnDashboard method");

		userDashboardPage.clickOnSettings();
		browseEventsPage.hardWait(2);
		preservingPageVisitsPage.clickOnLogoutButton();
		browseEventsPage.hardWait(2);
		loginPage.loginToDUPRApplication(testDataProp.getProperty("inbox.empty.email"), validPassword);
		chatpage.hardWait(3);
		userDashboardPage.clickOnMessageIcon();
		chatpage.hardWait(2);

		Assert.assertTrue(chatpage.isInboxEmptyDisplayed());

		logger.info("Ending of verifyEmptyInBoxOnDashboard method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 6, description = "Verify the results on click of chart icon on Dashboard with not verified email", groups = "sanity")
	@Description("Test case #6, Verify the results on click of chart icon on Dashboard with not verified email")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on click of chart icon on Dashboard with not verified email")
	public void verifyPresenceOfMessageIconForUnverifiedAccount(String validPassword) {
		logger.info("Starting of verifyPresenceOfMessageIconForUnverifiedAccount method");

		userDashboardPage.clickOnSettings();
		browseEventsPage.hardWait(2);
		preservingPageVisitsPage.clickOnLogoutButton();
		browseEventsPage.hardWait(2);

		loginPage.loginToDUPRApplication(testDataProp.getProperty("notverified.email"), validPassword);
		chatpage.hardWait(3);
		chatpage.clickOnCloseOnVerifyEmail();
		chatpage.hardWait(3);

		Assert.assertFalse(chatpage.isMessageIconDisplayed());

		logger.info("Ending of verifyPresenceOfMessageIconForUnverifiedAccount method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.CHAT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
