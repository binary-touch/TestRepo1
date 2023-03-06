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
		Assert.assertTrue(profilePicturePage.ispreviousUploadedImageDisplayed());
		profilePicturePage.hardWait(2);
		clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnSaveButton();
		clubLogoPage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChangeLogoOption method");
	}

	@Test(priority = 5, description = "Verify Cancel Button functionality in Club Logo popup", groups = "sanity")
	@Description("Test case #5, Verify Cancel Button functionality in Club Logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Cancel Button functionality in Club Logo popup")
	public void verifyCancelButtonFunctionalityInClubLogoPopup() {
		logger.info("Starting of verifyCancelButtonFunctionalityInClubLogoPopup method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCancelButton();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCancelButtonFunctionalityInClubLogoPopup method");
	}

	@Test(priority = 6, description = "Verify Close Icon functionality in Club Logo popup", groups = "sanity")
	@Description("Test case #6, Verify Close Icon functionality in Club Logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Close Icon functionality in Club Logo popup")
	public void verifyCloseIconInClubLogoPopUp() {
		logger.info("Starting of verifyCloseIconInClubLogoPopUp method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCloseIconOnEventLogo();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCloseIconInClubLogoPopUp method");
	}

	@Test(priority = 7, description = "Verify the state of save button after Changing Logo", groups = "sanity")
	@Description("Test case #7, Verify the state of save button after Changing Logo")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the state of save button after Changing Logo")
	public void verifyTheStateOfSaveButtonAfterLogoEdit() {
		logger.info("Starting of verifyTheStateOfSaveButtonAfterLogoEdit method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();
		clubLogoPage.hardWait(2);
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());

		logger.info("Ending of verifyTheStateOfSaveButtonAfterLogoEdit method");
	}

	@Test(priority = 8, description = "Verify 'No' Button functionality in Remove Logo popup", groups = "sanity")
	@Description("Test case #8, Verify 'No' Button functionality in Remove Logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify 'No' Button functionality in Remove Logo popup")
	public void verifyNoButtonFunctionalityInRemoveLogoPopup() {
		logger.info("Starting of verifyNoButtonFunctionalityInRemoveLogoPopup method");

		profilePicturePage.clickOnCancelButton();
		clubLogoPage.hardWait(2);

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnRemoveLogoOption();
		clubLogoPage.hardWait(2);

		profilePicturePage.clickOnNoButton();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyNoButtonFunctionalityInRemoveLogoPopup method");
	}

	@Test(priority = 9, description = "Verify Close Icon Button functionality in Remove logo popup", groups = "sanity")
	@Description("Test case #9, Verify Close Icon Button functionality in Remove logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Close Icon Button functionality in Remove logo popup")
	public void verifyCloseIconInRemoveLogoPopup() {
		logger.info("Starting of verifyCloseIconInRemoveLogoPopup method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnRemoveLogoOption();

		clubLogoPage.hardWait(2);
		profilePicturePage.iconCloseOnRemoveLogo();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCloseIconInRemoveLogoPopup method");
	}

	@Test(priority = 10, description = "Verify remove logo functionality in club page", groups = "sanity")
	@Description("Test case #10, Verify remove logo functionality in club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify remove logo functionality in club page")
	public void verifyRemoveLogoFunctionalityInClubPage() {
		logger.info("Starting of verifyRemoveLogoFunctionalityInClubPage method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnRemoveLogoOption();

		Assert.assertTrue(clubLogoPage.isRemoveLogoPopupContains());

		profilePicturePage.clickOnYesButton();
		clubLogoPage.hardWait(4);
		Assert.assertFalse(clubLogoPage.isRemoveLogoPopupContains());

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
