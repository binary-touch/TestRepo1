package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.profile.ProfilePicturePage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ClubLogoTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(ClubLogoTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private ProfilePicturePage profilePicturePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ClubLogoTest");

		this.driver = super.getWebDriver(WebDriversEnum.CLUB_LOGO_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.profilePicturePage = new ProfilePicturePage(this.driver);

		logger.info("Ending of initMethod in ClubLogoTest");
	}

	@Test(priority = 1, description = "Verify Add Club  logo  functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Club  logo  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Club logo functionality")
	public void verifyAddLogoFunctionality() {
		logger.info("Starting of verifyAddLogoFunctionality method");
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnClub();
		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();

		logger.info("Ending of verifyAddLogoFunctionality method");
	}

	@Test(priority = 2, description = "Verify Choose logo functionality", groups = "sanity")
	@Description("Test case #2, Verify Choose logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Choose logo functionality")
	public void verifyChooseLogoFunctionality() {
		logger.info("Starting of verifyChooseLogoFunctionality method");

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

		logger.info("Ending of verifyChooseLogoFunctionality method");
	}

	@Test(priority = 3, description = "Verify Change  logo functionality", groups = "sanity")
	@Description("Test case #3, Verify Change  logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Change  logo functionality")
	public void verifyEditLogo() {
		logger.info("Starting of verifyEditLogo method");

		profilePicturePage.clickOnCameraIcon();

		Assert.assertTrue(clubLogoPage.isChangeLogoDisplayed());
		Assert.assertTrue(clubLogoPage.isRemoveLogoDisplayed());

		logger.info("Ending of verifyEditLogo method");
	}

	@Test(priority = 4, description = "Verify Change Logo button functionality", groups = "sanity")
	@Description("Test case #4, Verify Change Logo button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Change Logo button functionality")
	public void verifyClickOnChangeLogo() {
		logger.info("Starting of verifyClickOnChangeLogo method");

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

		logger.info("Ending of verifyClickOnChangeLogo method");
	}

	@Test(priority = 5, description = "Verify results on click of Cancel Button in Club  logo popup", groups = "sanity")
	@Description("Test case #5, Verify results on click of Cancel Button in Club  logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify results on click of Cancel Button in Club  logo popup")
	public void verifyCancelButtonFunctionality() {
		logger.info("Starting of verifyCancelButtonFunctionality method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCancelButton();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCancelButtonFunctionality method");
	}

	@Test(priority = 6, description = "Verify results on click of Close Icon in Club  logo popup", groups = "sanity")
	@Description("Test case #6, Verify results on click of Close Icon in Club  logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify results on click of Close Icon in Club  logo popup")
	public void verifyCloseIconInClubLogoPopUp() {
		logger.info("Starting of verifyCloseIconInClubLogoPopUp method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCloseIcon();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCloseIconInClubLogoPopUp method");
	}

	@Test(priority = 7, description = "Verify the state of save button", groups = "sanity")
	@Description("Test case #9, Verify the state of save button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the state of save button")
	public void verifySaveButtonState() {
		logger.info("Starting of verifySaveButtonState method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();
		clubLogoPage.hardWait(2);
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());

		logger.info("Ending of verifySaveButtonState method");
	}

	@Test(priority = 8, description = "Verify results on click of 'No' Button in Remove Logo popup", groups = "sanity")
	@Description("Test case #7, Verify results on click of 'No' Button in Remove Logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify results on click of 'No' Button in Remove Logo popup")
	public void verifyNoButtonFunctionality() {
		logger.info("Starting of verifyNoButtonFunctionality method");

		profilePicturePage.clickOnCancelButton();
		clubLogoPage.hardWait(2);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnRemoveLogoOption();
		clubLogoPage.hardWait(2);
		profilePicturePage.clickOnNoButton();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyNoButtonFunctionality method");
	}

	@Test(priority = 9, description = "Verify Close Icon Button functionality in Remove logo popup", groups = "sanity")
	@Description("Test case #8, Verify Close Icon Button functionality in Remove logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Close Icon Button functionality in Remove logo popup")
	public void verifyCloseIconButtonInRemoveLogoPopup() {
		logger.info("Starting of verifyCloseIconButtonInRemoveLogoPopup method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnRemoveLogoOption();
		clubLogoPage.hardWait(2);
		profilePicturePage.clickOnCloseIcon();

		Assert.assertTrue(clubLogoPage.isClubPageContains());

		logger.info("Ending of verifyCloseIconButtonInRemoveLogoPopup method");
	}

	@Test(priority = 10, description = "Verify remove logo functionality", groups = "sanity")
	@Description("Test case #9, Verify remove logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify remove logo functionality")
	public void verifyRemoveLogo() {
		logger.info("Starting of verifyRemoveLogo method");

		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnRemoveLogoOption();

		Assert.assertTrue(clubLogoPage.isRemoveLogoPopupContains());

		profilePicturePage.clickOnYesButton();

		// Assert.assertFalse(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyRemoveLogo method");
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
