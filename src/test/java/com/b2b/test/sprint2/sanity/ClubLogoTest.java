package com.b2b.test.sprint2.sanity;

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
import com.dupr.pages.profile.ProfilePicturePage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("DUPR App")
@Feature("Club Logo Sanity")
public class ClubLogoTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(ClubLogoTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private ProfilePicturePage profilePicturePage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in ClubLogoTest");

		this.driver = super.getWebDriver(WebDriversEnum.CLUB_LOGO_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.profilePicturePage = new ProfilePicturePage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);

		logger.info("Ending of initMethod in ClubLogoTest");
	}

	@Test(priority = 1, description = "Verify Add Club logo functionality in Club page", groups = "sanity")
	@Description("Test case #1, Verify Add Club logo functionality in Club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Club logo functionality in Club page")
	public void verifyAddLogoFunctionalityInClubPage() {
		logger.info("Starting of verifyAddLogoFunctionalityInClubPage method");

		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnMyClubsTab();
		try {
			if (clubLogoPage.isClubsDisplayedInMyClubs()) {
				clubLogoPage.clickOnClub();
			} else {
				myClubsPage.clickOnBrowseClubsButton();
				Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
				clubLogoPage.searchClubWithClubName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();

		logger.info("Ending of verifyAddLogoFunctionalityInClubPage method");
	}

	@Test(priority = 2, description = "Verify Choose logo functionality in club page", groups = "sanity")
	@Description("Test case #2, Verify Choose logo functionality in club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Choose logo functionality in club page")
	public void verifyChooseLogoFunctionalityInClubPage() {
		logger.info("Starting of verifyChooseLogoFunctionalityInClubPage method");

		try {
			if (clubLogoPage.isEmptyLogoDisplayed() == true) {

				Assert.assertEquals(this.clubLogoPage.getSelectImageToUploadText(),
						expectedAssertionsProp.getProperty("select.image.to.upload"));

				Assert.assertTrue(clubLogoPage.isClubLogoPopupContains());

				String clubLogoText = clubLogoPage.getClubLogoText();
				Assert.assertEquals(clubLogoText, expectedAssertionsProp.getProperty("club.logo.label"));

				Assert.assertTrue(profilePicturePage.isSaveButtonDisabled());

				clubLogoPage
						.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
			}
		} catch (Exception e) {
			clubLogoPage.hardWait(1);
			clubLogoPage.clickOnRemoveLogoOption();
			profilePicturePage.clickOnYesButton();
			clubLogoPage.hardWait(3);
			profilePicturePage.clickOnCameraIcon();
			clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		}

		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnSaveButton();

		profilePicturePage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChooseLogoFunctionalityInClubPage method");
	}

	@Test(priority = 3, description = "Verify Edit logo functionality in club page", groups = "sanity")
	@Description("Test case #3, Verify Edit logo functionality in club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Edit logo functionality in club page")
	public void verifyEditLogoFunctionalityInClubPage() {
		logger.info("Starting of verifyEditLogoFunctionalityInClubPage method");

		profilePicturePage.clickOnCameraIcon();

		Assert.assertTrue(clubLogoPage.isChangeLogoDisplayed());
		Assert.assertTrue(clubLogoPage.isRemoveLogoDisplayed());

		logger.info("Ending of verifyEditLogoFunctionalityInClubPage method");
	}

	@Test(priority = 4, description = "Verify Change Logo button functionality in Club page", groups = "sanity")
	@Description("Test case #4, Verify Change Logo button functionality in Club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Change Logo button functionality in Club page")
	public void verifyChangeLogoOption() {
		logger.info("Starting of verifyChangeLogoOption method");

		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnChangeLogoOption();

		Assert.assertTrue(clubLogoPage.isClubLogoPopupContains());
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());
		Assert.assertTrue(profilePicturePage.isPreviousUploadedImageDisplayed());
		profilePicturePage.hardWait(2);
		clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnSaveButton();
		clubLogoPage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChangeLogoOption method");
	}

	@Test(priority = 5, description = "Verify the state of save button after Changing Logo", groups = "sanity")
	@Description("Test case #5, Verify the state of save button after Changing Logo")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the state of save button after Changing Logo")
	public void verifyTheStateOfSaveButtonAfterLogoEdit() {
		logger.info("Starting of verifyTheStateOfSaveButtonAfterLogoEdit method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();
		clubLogoPage.hardWait(2);
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());
		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnCancelButton();
		clubLogoPage.hardWait(3);

		logger.info("Ending of verifyTheStateOfSaveButtonAfterLogoEdit method");
	}

	@Test(priority = 6, description = "Verify remove logo functionality in club page", groups = "sanity")
	@Description("Test case #6, Verify remove logo functionality in club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify remove logo functionality in club page")
	public void verifyRemoveLogoFunctionalityInClubPage() {
		logger.info("Starting of verifyRemoveLogoFunctionalityInClubPage method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnRemoveLogoOption();
		
		try {
			if(profilePicturePage.isSaveButtonDisplayed()) {
				driver.navigate().refresh();
				profilePicturePage.hardWait(3);
				profilePicturePage.clickOnCameraIcon();
				clubLogoPage.hardWait(3);
				clubLogoPage.clickOnRemoveLogoOption();
			}
		} catch (Exception e) {
			
			System.out.println("****Pop Up Displayed****");
		}
		
		Assert.assertTrue(clubLogoPage.isRemoveLogoPopupContains());

		profilePicturePage.clickOnYesButton();
		clubLogoPage.hardWait(4);

		logger.info("Ending of verifyRemoveLogoFunctionalityInClubPage method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.CLUB_LOGO_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
