package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.clubs.ImportPlayerViaCSVPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class importPlayerViaCSVTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(importPlayerViaCSVTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditClubInfoPage editClubInfoPage = null;
	private ImportPlayerViaCSVPage addPlayerInDirctoeViewPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in importPlayerViaCSVTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_PLAYER_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addPlayerInDirctoeViewPage = new ImportPlayerViaCSVPage(this.driver);

		logger.info("Ending of initMethod in importPlayerViaCSVTest");
	}

	@Test(priority = 1, description = "verify Add Player with import CSV Functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Playerwith import CSV functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Playerwith import CSV functionality")
	public void verifyAddPlayerWithImportCSVFunctionality() {
		logger.info("Starting of verifyAddPlayerFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		addPlayerInDirctoeViewPage.isAsADirectorTextDisplayed();
		addPlayerInDirctoeViewPage.clickOnDemoClubButton();
		addPlayerInDirctoeViewPage.clickOnAddPlayersButton();
		addPlayerInDirctoeViewPage.isAddPlayersDropdownListContains();
		addPlayerInDirctoeViewPage.clickOnImportPlayersViaCSVButton();
		addPlayerInDirctoeViewPage.clickOnCancelButton();

		addPlayerInDirctoeViewPage.clickOnAddPlayersButton();
		addPlayerInDirctoeViewPage.clickOnImportPlayersViaCSVButton();
		addPlayerInDirctoeViewPage.isImportCSVPopUpContains();
		addPlayerInDirctoeViewPage.clickOnDownloadTemplateButton();
		addPlayerInDirctoeViewPage.setBrowseFilesButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("add.players.csv.files"));
		addPlayerInDirctoeViewPage.clickOnRemoveFileButton();
		// addPlayerInDirctoeViewPage.clickOnBrowseFiles();
		addPlayerInDirctoeViewPage.setBrowseFilesButton(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("add.players.csv.files"));
		addPlayerInDirctoeViewPage.clickOnSendInvitesButton();

		logger.info("Ending of verifyAddPlayerFunctionality method");
	}

	@Test(priority = 2, description = "verify Players Added Succesfully PopUp Functionality", groups = "sanity")
	@Description("Test case #2, verify Players Added Succesfully PopUp Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, verify Players Added Succesfully PopUp Functionality")
	public void verifyPlayersAddedSuccesfullyPopUpFunctionality() {
		logger.info("Starting of verifyPlayersAddedSuccesfullyPopUpFunctionality method");

		addPlayerInDirctoeViewPage.isPlayersAddedSuccessfullyPopUpContains();
		addPlayerInDirctoeViewPage.clickOnOkButton();

		logger.info("Ending of verifyPlayersAddedSuccesfullyPopUpFunctionality method");
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