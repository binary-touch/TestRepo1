package com.dupr.test.home;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.home.AntiScrappingCaptchaPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AntiScrappingCaptchaTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(AntiScrappingCaptchaTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private BrowseClubsPage browseClubsPage = null;
	private BrowsePlayersPage browsePlayersPage = null;
	private AddParticipantsInBracketsPage addparticipantsPage = null;

	private AntiScrappingCaptchaPage antiScrappingCaptchaPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AntiScrappingCaptchaTest");

		this.driver = super.getWebDriver(WebDriversEnum.ANTI_SCRAPPING_CAPTCHA_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.antiScrappingCaptchaPage = new AntiScrappingCaptchaPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.browsePlayersPage = new BrowsePlayersPage(this.driver);
		this.addparticipantsPage = new AddParticipantsInBracketsPage(this.driver);

		logger.info("Ending of initMethod in AntiScrappingCaptchaTest");
	}

	@Test(priority = 1, description = "Verify AntiScrapping Captcha In Browse Events Page", groups = "sanity")
	@Description("Test case #1, Verify AntiScrapping Captcha In Browse Events Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Announcement functionality")
	public void VerifyCaptchaOnBrowseEvents() {
		logger.info("Starting of VerifyCaptchaOnBrowseEvents method");

		browseEventsPage.clickOnMyEventButton();

		Assert.assertEquals(browseEventsPage.getEventsText(), expectedAssertionsProp.getProperty("txt.event"));

		Assert.assertTrue(browseEventsPage.isMyEventsPageContains());

		browseEventsPage.clickOnBrowseAllEventsButton();

		Assert.assertTrue(browseEventsPage.isBrowseEventsPageContains());

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyCaptchaOnBrowseEvents method");
	}

	@Test(priority = 2, description = "Verify AntiScrapping Captcha In Browse Club Page", groups = "sanity")
	@Description("Test case #1, Verify AntiScrapping Captcha In Browse Club Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify AntiScrapping Captcha In Browse Club Page")
	public void VerifyCaptchaOnBrowseClub() {
		logger.info("Starting of VerifyCaptchaOnBrowseClub method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnClubsMenu();

		Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyCaptchaOnBrowseClub method");
	}

	@Test(priority = 3, description = "Verify AntiScrapping Captcha In Browse Players Page", groups = "sanity")
	@Description("Test case #3, Verify AntiScrapping Captcha In Browse Players Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify AntiScrapping Captcha In Browse Players Page")
	public void VerifyCaptchaOnBrowsePlayers() {
		logger.info("Starting of VerifyCaptchaOnBrowsePlayers method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnPlayersMenu();

		Assert.assertTrue(browsePlayersPage.isBrowsePlayersPageContains());

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyCaptchaOnBrowsePlayers method");
	}

	//@Test(priority = 4, description = "Verify AntiScrapping Captcha In Add Partner Page", groups = "sanity")
	@Description("Test case #4, Verify AntiScrapping Captcha In Add Partner Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify AntiScrapping Captcha In Add Partner Page")
	public void VerifyCaptchaOnAddPartner() {
		logger.info("Starting of VerifyCaptchaOnAddPartner method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnHomeMenu();
		antiScrappingCaptchaPage.clickOnMyBrackets();
		antiScrappingCaptchaPage.clickOnBracketLabel();

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyCaptchaOnAddPartner method");
	}

	@Test(priority = 5, description = "Verify AntiScrapping Captcha In Edit Partner Page", groups = "sanity")
	@Description("Test case #5, Verify AntiScrapping Captcha In Edit Partner Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify AntiScrapping Captcha In Edit Partner Page")
	public void VerifyCaptchaOnEditPartner() {
		logger.info("Starting of VerifyCaptchaOnEditPartner method");

		antiScrappingCaptchaPage.goTodefaultContent();
		
		driver.get("https://stage.gamestoppedout.com/dashboard");
		antiScrappingCaptchaPage.hardWait(3);
		antiScrappingCaptchaPage.clickOnMyBrackets();
		
		antiScrappingCaptchaPage.clickOnBracketKebabButton();
		antiScrappingCaptchaPage.clickOnEditPartner();

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyCaptchaOnEditPartner method");
	}

	@Test(priority = 6, description = "Verify AntiScrapping Captcha On  Adds Participants ", groups = "sanity")
	@Description("Test case #6, Verify AntiScrapping Captcha On  Adds Participants ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify AntiScrapping Captcha On  Adds Participants ")
	public void VerifyAntiScrappingCaptchaOnAddParticipants() {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnAddParticipants method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnBracketCancelButon();
		addparticipantsPage.clickOnBracketNameLink();
		
		Assert.assertTrue(addparticipantsPage.isAddBracketParticipantPageContains());

		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnAddParticipants method");
	}

	@Test(priority = 7, description = "Verify AntiScrapping Captcha On  Edit Team Page ", groups = "sanity")
	@Description("Test case #7, Verify AntiScrapping Captcha On   Edit Team Page ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify AntiScrapping Captcha On  Edit Team Page")
	public void VerifyAntiScrappingCaptchaOnEditTeamPage() {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnEditTeamPage method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnGoBackButton();
		antiScrappingCaptchaPage.clickOnTeamsTab();
		antiScrappingCaptchaPage.clickOnEditTeamButton();
		antiScrappingCaptchaPage.clickOnRemovePlayerIcon();
		antiScrappingCaptchaPage.clickOnAddPlayerButton();
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnEditTeamPage method");
	}

	@Test(priority = 8, description = "Verify AntiScrapping Captcha On Add Partner/Opponent ", groups = "sanity")
	@Description("Test case #8, Verify AntiScrapping Captcha OnAdd Partner/Opponent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify AntiScrapping Captcha On Add Partner/Opponent")
	public void VerifyAntiScrappingCaptchaOnAddPartnerOrOpponent() throws InterruptedException {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnAddPartnerOrOpponent method");

		antiScrappingCaptchaPage.goTodefaultContent();

		driver.get("https://stage.gamestoppedout.com/dashboard");
		antiScrappingCaptchaPage.hardWait(3);
		
		antiScrappingCaptchaPage.clickOnAddAMatchMenu();
		antiScrappingCaptchaPage.clickOnAddYourPartnerButton();
		
		antiScrappingCaptchaPage.hardWait(3);
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		driver.navigate().back();
		antiScrappingCaptchaPage.clickOnAddAMatchMenu();
		antiScrappingCaptchaPage.clickOnAddYourOpponentButton();
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnAddPartnerOrOpponent method");
	}

	@Test(priority = 9, description = "Verify AntiScrapping Captcha On Director Add Players ", groups = "sanity")
	@Description("Test case #9, Verify AntiScrapping Captcha On Director Add Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify AntiScrapping Captcha On Director Add Players")
	public void VerifyAntiScrappingCaptchaOnDirectorAddPlayers() {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnDirectorAddPlayers method");

		antiScrappingCaptchaPage.goTodefaultContent();
		driver.get("https://stage.gamestoppedout.com/dashboard");
		antiScrappingCaptchaPage.hardWait(3);
		
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnClub();
		antiScrappingCaptchaPage.clickOnAddPlayersDropdown();
		antiScrappingCaptchaPage.clickOnAddSingleDURPUserButton();
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnDirectorAddPlayers method");
	}

	@Test(priority = 10, description = "Verify AntiScrapping Captcha On Club add a Match Add a player/opponent", groups = "sanity")
	@Description("Test case #10, Verify AntiScrapping Captcha On Club add a Match Add a player/opponent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify AntiScrapping Captcha On Club add a Match Add a player/opponent")
	public void VerifyAntiScrappingCaptchaOnClubAddAMatchAddAPlayerOrOpponent() {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnClubAddAMatchAddAPlayerOrOpponent method");

		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnCancelButtonInClunMemberPage();
		antiScrappingCaptchaPage.clickOnAddAMatchButton();
		antiScrappingCaptchaPage.clickOnAddFirstPlayerButton();
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnClubAddAMatchAddAPlayerOrOpponent method");
	}

	@Test(priority = 11, description = "Verify AntiScrapping Captcha On Claim accounts on Sign up page", groups = "sanity")
	@Description("Test case #11, Verify AntiScrapping Captcha On Claim accounts on Sign up page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify AntiScrapping Captcha On Claim accounts on Sign up page")
	public void VerifyAntiScrappingCaptchaOnClaimAccountOnSignUpPage() {
		logger.info("Starting of VerifyAntiScrappingCaptchaOnClaimAccountOnSignUpPage method");
		antiScrappingCaptchaPage.goTodefaultContent();

		antiScrappingCaptchaPage.clickOnPlayerCancelButton();
		antiScrappingCaptchaPage.clickOnOpenSettingsMenu();
		antiScrappingCaptchaPage.clickOnLogOutButton();
		antiScrappingCaptchaPage.clickOnSignUpButton();
		Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

		logger.info("Ending of VerifyAntiScrappingCaptchaOnClaimAccountOnSignUpPage method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ANTI_SCRAPPING_CAPTCHA_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
