package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.ImportPlayerViaCSVPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ImportPlayerViaCSVTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ImportPlayerViaCSVTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private ImportPlayerViaCSVPage addPlayerPage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in ImportPlayerViaCSVTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_PLAYER_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addPlayerPage = new ImportPlayerViaCSVPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);

		logger.info("Ending of initMethod in ImportPlayerViaCSVTest");
	}

	@Test(priority = 1, description = "verify Add Player with import CSV Functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Playerwith import CSV functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Playerwith import CSV functionality")
	public void verifyAddPlayerWithImportCSVFunctionality() {
		logger.info("Starting of verifyAddPlayerFunctionality method");

		clubLogoPage.hardWait(6);
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.hardWait(3);
		try {
			if (clubLogoPage.isClubsDisplayedInMyClubs()) {
				Assert.assertTrue(addPlayerPage.isAsADirectorTextDisplayed());
				clubLogoPage.clickOnClub();
			} else {
				myClubsPage.clickOnBrowseClubsButton();
				Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
				clubLogoPage.searchClubWithClubName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		addPlayerPage.clickOnAddPlayersButton();
		Assert.assertTrue(addPlayerPage.isAddPlayersDropdownListContains());
		addPlayerPage.clickOnImportPlayersViaCSVButton();
		addPlayerPage.clickOnCancelButton();

		addPlayerPage.clickOnAddPlayersButton();
		addPlayerPage.clickOnImportPlayersViaCSVButton();
		Assert.assertTrue(addPlayerPage.isImportCSVPopUpContains());
		addPlayerPage.clickOnDownloadTemplateButton();
		addPlayerPage
				.uploadPlayerCSVFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("add.players.csv.files"));
		addPlayerPage.clickOnRemoveFileButton();

		logger.info("Ending of verifyAddPlayerFunctionality method");
	}

	@Test(priority = 2, description = "Verify Add Players Functionality", groups = "sanity")
	@Description("Test case #2, Verify Add Players Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Add Players Functionality")
	public void verifyAddPlayersFunctionality() {
		logger.info("Starting of verifyAddPlayersFunctionality method");

		addPlayerPage
				.uploadPlayerCSVFile(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("add.players.csv.files"));
		addPlayerPage.clickOnSendInvitesButton();

		Assert.assertTrue(addPlayerPage.isPlayersAddedSuccessfullyPopUpContains());
		addPlayerPage.clickOnOkButton();

		logger.info("Ending of verifyAddPlayersFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_PLAYER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}